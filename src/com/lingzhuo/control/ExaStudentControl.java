package com.lingzhuo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.framework.control.BaseControl;

/**
 * Servlet implementation class ExaStudentControl
 */
@WebServlet("/exaStudentControl.do")
public class ExaStudentControl extends BaseControl {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		if(this.getAction().equals("selectById")){
			//注册成功后显示跟人信息
			 //注册成功后直接走该查询，该数据已经放入session中，此时直接跳转页面即可
			request.getRequestDispatcher("/WEB-INF/views/examineeInfo.jsp").forward(request, response);
			 
		}
	}

}
