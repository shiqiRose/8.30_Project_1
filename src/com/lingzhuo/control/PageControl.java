/**
 * 
 */
package com.lingzhuo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.common.utils.JsonUtils;
import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.framework.control.BaseControl;
import com.lingzhuo.service.ExaminationService;
import com.lingzhuo.service.ExamineeService;
import com.lingzhuo.service.ManagerService;
import com.lingzhuo.serviceImpl.ExaminationServiceImpl;
import com.lingzhuo.serviceImpl.ExamineeServiceImpl;
import com.lingzhuo.serviceImpl.ManagerServiceImpl;
import com.lingzhuo.vo.PageVo;
import com.lingzhuo.vo.ResultMessage;

/**
 * @ClassName: MainControl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月31日 下午3:35:25
 *
 */
@WebServlet("/pageControl.do")
public class PageControl extends BaseControl{
	
	private static ExaminationService examinationService=(ExaminationService) BeanFactory.getBeanFactory().getBean(ExaminationServiceImpl.class);

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		if(this.getAction().equals("page")){
					
					try {
						
					  String rname =request.getParameter("rname");
					  String cardno =request.getParameter("cardno");
					  String leve=request.getParameter("leve");
					  String state =request.getParameter("state");
					  ExamineeEntity entity =new ExamineeEntity();
					  entity.setRname(rname);//封装数据
					  entity.setCardno(cardno);
					  entity.setExaLeve(leve);
					  entity.setExaminestate(state);
						
					  int total = examinationService.selectEntityTotal(entity);
					  System.out.println("---total---:"+total);
					  
					  PageVo p=new PageVo();
					  p.setPageNow(this.getPageVo().getPageNow());//封装页码 计算偏移量
					  p.setTotal(total);//封装总记录数  计算总页数
					
					
					  List<ExamineeEntity> list =examinationService.selectEntityPageTotal(p,entity);
					  request.setAttribute("Rows", list);
					  request.setAttribute("pageVo", p);
					  System.out.println("---pageVo---:"+p.getPageTotal()+":"+p.getTotal());
					  
					  request.setAttribute("rname", rname);
					  request.setAttribute("cardno", cardno);
					  request.setAttribute("leve", leve);
					  request.setAttribute("state", state);
					  
					  request.getRequestDispatcher("/WEB-INF/views/examineeRows.jsp").forward(request, response);
					  }catch(Exception e){
						 e.printStackTrace();
						 request.getRequestDispatcher("error.jsp").forward(request, response);
					  }
	
	}else if(this.getAction().equals("deleteItems")){
		String exaId=request.getParameter("exaId");
		System.out.println("--exaId--"+exaId);
		try {
			int i= examinationService.deleteEntityById(Integer.parseInt(exaId));
		
			if(i>0){
				response.sendRedirect("pageControl.do?action=page&pageNow=1");
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} 

		
	}else if(this.getAction().equals("examinee")){
		String exaId=request.getParameter("exid");
		try {
			ExamineeEntity entity=examinationService.selectEntityById(exaId);
			 // 查询该记录是否已审核，如果已审核，则响应2
			if(entity!=null&&entity.getExaminestate()!=null&&entity.getExaminestate().toString().equals("Y")){
				PrintWriter out=response.getWriter();//响应给jsp 的 res
				out.print("2");
				out.close();
			}else{
				//如果未审核，则进行审核操作
				ExaminationEntity user =(ExaminationEntity) request.getSession().getAttribute("user");
				int i=examinationService.updateExaminee(exaId,"Y",user.getExaminationId().toString(), null);
				if(i>0){
					PrintWriter out=response.getWriter();
					out.print("1");
					out.close();
				}else{
					PrintWriter out=response.getWriter();
					out.print("3");
					out.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//未审核通过校验
	}else if(this.getAction().equals("noexaminee")){
		String exaId =request.getParameter("exid");
		System.out.println("--exaid1111111---"+exaId);
		try {
			//审核已经通过，则返回2
			ExamineeEntity entity=examinationService.selectEntityById(exaId);
			System.out.println("--exaid1111111name---"+entity.getRname());
			if(entity!=null){
				PrintWriter out =response.getWriter();
				ResultMessage res=new ResultMessage();
				//进行未审核操作为F状态
				// F待审核，N未通过审核，Y通过审核
				if(entity!=null&&entity.getExaminestate().toString().equals("Y")||entity.getExaminestate().toString().equals("N")){
					res.setFlag(false);
					res.setMsg("该记录已经被审核过，不能再次审核！！！");
					
				}else{
					res.setFlag(true);
				}
				out.print(JsonUtils.beanToJson(res));//将res Object对象转换为json对象
				out.close();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 //审核不通过操作
	else if(this.getAction().equals("noExamineCommit")){
		String exid =request.getParameter("exid");
		String examineMsg=request.getParameter("examineMsg");//驳回原因
		ResultMessage res=new ResultMessage();//msg flag
		PrintWriter out =response.getWriter();
		
		ExaminationEntity user =(ExaminationEntity) request.getSession().getAttribute("user");//审核人id
		ExamineeEntity entity;
		try {
			entity = examinationService.selectEntityById(exid);
			System.out.println("--entityid---"+entity.getExaId());
			
			if(entity!=null){
				 //修改 ：审核状态N、审核人，审核时间，未通过原因
				int i=examinationService.updateExaminee(exid, "N", user.getExaminationId().toString(), examineMsg);
				if(i>0){
					res.setFlag(true);
				}else{
					res.setFlag(false);
					res.setMsg("审核'未通过'操作失败！");
				}
				out.print(JsonUtils.beanToJson(res));//将res Object对象转换为json对象
			}
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}

}
