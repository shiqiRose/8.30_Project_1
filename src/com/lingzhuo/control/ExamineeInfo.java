package com.lingzhuo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.entity.ExaminationEntity;
import com.lingzhuo.entity.ExamineeEntity;
import com.lingzhuo.factory.BeanFactory;
import com.lingzhuo.framework.control.BaseControl;
import com.lingzhuo.service.ExaminationService;
import com.lingzhuo.serviceImpl.ExaminationServiceImpl;

/**
 * Servlet implementation class ExamineeInfo
 */
@WebServlet("/ExamineeInfo.do")
public class ExamineeInfo extends BaseControl {
	private static final long serialVersionUID = 1L;
	private static ExaminationService examinationService=(ExaminationService) BeanFactory.getBeanFactory().getBean(ExaminationServiceImpl.class);  
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		ExamineeEntity user =(ExamineeEntity) request.getSession().getAttribute("user");
		try {
			ExamineeEntity entity=examinationService.selectEntityById(user.getExaId().toString());
			System.out.println("-------"+entity.getRname()+entity.getEmail());
			request.setAttribute("user", entity);
			request.getRequestDispatcher("/WEB-INF/views/examineeInfo.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
}
