package com.lingzhuo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.framework.control.BaseControl;

/**
 * Servlet implementation class ExitControl
 */
@WebServlet("/exitControl.do")
public class ExitControl extends BaseControl {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		request.getSession().invalidate();//销毁
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
