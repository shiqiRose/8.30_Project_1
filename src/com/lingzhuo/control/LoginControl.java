/**
 * 
 */
package com.lingzhuo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.common.code.AuthCode;
import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.entity.ManagerEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.framework.control.BaseControl;
import com.lingzhuo.service.ExaminationService;
import com.lingzhuo.service.ExamineeService;
import com.lingzhuo.service.ManagerService;
import com.lingzhuo.serviceImpl.ExaminationServiceImpl;
import com.lingzhuo.serviceImpl.ExamineeServiceImpl;
import com.lingzhuo.serviceImpl.ManagerServiceImpl;
import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: LoginCOntrol
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月31日 下午3:32:45
 *
 */
@WebServlet("/login.do")
public class LoginControl extends BaseControl{

private static ManagerService managerService=(ManagerService) BeanFactory.getBeanFactory().getBean(ManagerServiceImpl.class);
private static ExaminationService examinationService=(ExaminationService) BeanFactory.getBeanFactory().getBean(ExaminationServiceImpl.class);
private static ExamineeService examineeService=(ExamineeService) BeanFactory.getBeanFactory().getBean(ExamineeServiceImpl.class);
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		if(this.getAction()==null){
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}else{
				if(this.getAction().equals("validateAuthCode")){
					String authCode=request.getParameter("authCode");
					System.out.println("-----"+authCode);
					String sessionAuthCode=(String) request.getSession().getAttribute(AuthCode.AUTH_CODE);
					if(sessionAuthCode!=null&&sessionAuthCode.equals(authCode)){
						PrintWriter out =response.getWriter();
						out.println("{\"valid\":true}");
						out.close();
						
					}else{
						PrintWriter out =response.getWriter();
						out.println("{\"valid\":false}");
						out.close();
					 }
			  }
			else if(this.getAction().equals("userLogin")){
				 String role=request.getParameter("role");
				 String username=request.getParameter("username");
				 String password=request.getParameter("password");
				 String rememberMe=request.getParameter("rememberMe");
				/* System.out.println("--user:"+username);
				 System.out.println("--pwd:"+password);*/
				try {
				
					  if(role!=null&&role.equals("101")){//考生
		               ExamineeEntity e =examineeService.selectEntityByUser(username, password);
		              
						 if(e!=null){
							 request.getSession().setAttribute("user", e);
						     if(rememberMe!=null&&rememberMe.equals("101")){
						    	 Cookie cookie1=new Cookie("username",e.getUsername());
						    	 Cookie cookie2=new Cookie("pwd",e.getPwd());
						    	 Cookie cookie3=new Cookie("role","101");
						    	 cookie1.setPath("/");
						    	 cookie2.setPath("/");
						    	 cookie3.setPath("/");
						    	 response.addCookie(cookie1);
						    	 response.addCookie(cookie2);
						    	 response.addCookie(cookie3);
						     }
							 response.sendRedirect("ExamineeInfo.do");
							 //request.getRequestDispatcher("/WEB-INF/views/examineeInfo.jsp").forward(request, response);
						 }else{
							 request.setAttribute("loginError", "登录失败");
							 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
						 }
			
			  }else if(role!=null&&role.equals("102")){//考务人员
				  ExaminationEntity e =examinationService.selectEntityByUser(username, password);
			      
				  if(e!=null){
				  request.getSession().setAttribute("user", e);
				  if(rememberMe!=null&&rememberMe.equals("102")){
				    	 Cookie cookie1=new Cookie("username",e.getUsername());
				    	 Cookie cookie2=new Cookie("pwd",e.getPwd());
				    	 Cookie cookie3=new Cookie("role","102");
				    	 cookie1.setPath("/");
				    	 cookie2.setPath("/");
				    	 cookie3.setPath("/");
				    	 response.addCookie(cookie1);
				    	 response.addCookie(cookie2);
				    	 response.addCookie(cookie3);
				     }
				  response.sendRedirect("pageControl.do?action=page&pageNow=1");
				  //request.getRequestDispatcher("pageControl?action=page&pageNow=1").forward(request, response);
				 
				   
				  }else{
					  request.setAttribute("loginError", "登录失败");
					  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				  }
				 
			  }else{//系统管理员
				  ManagerEntity e=managerService.selectEntityByUser(username, password);
				  
				  if(e!=null){
					  request.getSession().setAttribute("user", e);
					  if(rememberMe!=null&&rememberMe.equals("103")){
					    	 Cookie cookie1=new Cookie("username",e.getUsername());
					    	 Cookie cookie2=new Cookie("pwd",e.getPwd());
					    	 Cookie cookie3=new Cookie("role","103");
					    	 cookie1.setPath("/");
					    	 cookie2.setPath("/");
					    	 cookie3.setPath("/");
					    	 response.addCookie(cookie1);
					    	 response.addCookie(cookie2);
					    	 response.addCookie(cookie3);
					     }
					  request.getRequestDispatcher("/WEB-INF/views/manager.jsp").forward(request, response);
					  }else{
						  request.setAttribute("loginError", "登录失败");
						  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
					  }
			  }
			  
			} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("loginError", "系统异常，登录失败！");
					 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		  }
		
		}
	}
	

}
