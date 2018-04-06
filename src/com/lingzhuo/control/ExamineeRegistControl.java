package com.lingzhuo.control;

import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lingzhuo.common.utils.DateFormatSupport;
import com.lingzhuo.common.utils.JsonUtils;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.framework.control.BaseControl;
import com.lingzhuo.service.ExamineeService;
import com.lingzhuo.serviceImpl.ExamineeServiceImpl;
import com.lingzhuo.vo.ResultMessage;

/**
 * Servlet implementation class ExamineeRegistControl
 */
@WebServlet("/examineeRegistControl.do")
public class ExamineeRegistControl extends BaseControl {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ExamineeService examineeService=(ExamineeService) BeanFactory.getBeanFactory().getBean(ExamineeServiceImpl.class);
		super.doPost(request, response);
		//加载注册页面
		if(this.getAction()!=null&&this.getAction().equals("load")){
			 request.getRequestDispatcher("/WEB-INF/views/examineeRegist.jsp").forward(request, response);
		}
		//上传个人图片
		else if(this.getAction()!=null&&this.getAction().equals("uploadPhoto")){
			ResultMessage res=new ResultMessage();
			String fileName=null;
			
			//获得磁盘文件条目工厂  
			DiskFileItemFactory factory =new DiskFileItemFactory();
			 //获取文件需要上传到的路径  
			String path=request.getSession().getServletContext().getRealPath("/upload/img");
			File tempFile=new File(path);
			if(!tempFile.exists()){
				tempFile.mkdirs();
			}
			factory.setRepository(tempFile);//设置临时目录:文件上传时，上传文件会在服务器中有一个临时文件
			//通过SerlvetFileUpload 进行上传文件
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			try {
				List<FileItem> list=upload.parseRequest(request);
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						FileItem item=list.get(i);
						if(item.isFormField()){//表单中普通的文本数据，即不是文件
							System.out.println(item.getFieldName()+"----item----"+item.getName());
						}else{//是文件
							InputStream inputStream=item.getInputStream();
							
							fileName=UUID.randomUUID()+item.getName().substring(item.getName().lastIndexOf("."));
							File fileTarget=new File(path+"/"+fileName);
							System.out.println(item.getFieldName()+"----fileTarget----"+fileTarget);
							OutputStream outputStream=new FileOutputStream(fileTarget);
							System.out.println(item.getFieldName()+"----item1111----"+item.getName());
							System.out.println("上传的文件名为："+item.getName()+"文件的后缀为："
							+item.getName().substring(item.getName().lastIndexOf(".")));
							int j=0;
							byte[] bytes=new byte[1024*1024];
								while((j=inputStream.read(bytes))!=-1){
									outputStream.write(bytes, 0, j);
									outputStream.flush();
								}
								outputStream.close();
								inputStream.close();
							}
						}
					}
				//如果没有异常则表示长传成功
				res.setFlag(true);
				res.setMsg("upload/img/"+fileName);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res.setFlag(false);
				res.setMsg("文件上传出现异常，失败！");
			}
			
			PrintWriter out=response.getWriter();
			out.print(JsonUtils.beanToJson(res));
			out.close();
		   }
		else if(this.getAction()!=null&&this.getAction().equals("register")){
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			String rname=request.getParameter("rname");
			String cardno=request.getParameter("cardno");
			String leve=request.getParameter("leve");
			String birthday=request.getParameter("birthday");
			String  sex=request.getParameter("sex");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			String province=request.getParameter("province");
			String photoUrl=request.getParameter("photoUrl");
			
			
			ExamineeEntity entity =new ExamineeEntity();
			entity.setUsername(username);
			entity.setPwd(pwd);
			entity.setRname(rname);
			entity.setCardno(cardno);
			entity.setExaLeve(leve);
			entity.setExaminestate("F");
			entity.setBirthday(birthday!=null&&!birthday.trim().equals("")?birthday.trim().replace("-", ""):null);
			entity.setSex(sex);
			entity.setPhone(phone);
			entity.setEmail(email);
			entity.setProvince(province);
			entity.setPhoto(photoUrl.substring(photoUrl.lastIndexOf("/")+1));
			entity.setPhotoURL(photoUrl.substring(0, photoUrl.lastIndexOf("/")));
     	    /*System.out.println("---photoUrl111---"+photoUrl);
     	    System.out.println("---photo---"+photoUrl.substring(photoUrl.lastIndexOf("/")+1));
     	    System.out.println("---photoUrl---"+photoUrl.substring(0, photoUrl.lastIndexOf("/")));*/
			entity.setExaDate(DateFormatSupport.getNowDateStr());
     		entity.setExaTime(DateFormatSupport.getNowDateTimeStr());
     		int i=0;
     		try {
				i=examineeService.saveEntity(entity);
			 
     		if(i>0){
     			request.getSession().setAttribute("user",entity);
     			//查询个人信息
				response.sendRedirect("exaStudentControl.do?action=selectById");
     		}else{
     			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
     		}
     		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	 }
	}


