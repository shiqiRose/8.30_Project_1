/**
 * 
 */
package com.lingzhuo.control;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.common.code.AuthCode;

/**
 * @ClassName: AuthCodeControl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年9月1日 下午3:23:22
 *
 */
@WebServlet("/authCodeControl.do")
public class AuthCodeControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String authCode=AuthCode.getAuthCode();
		request.getSession().setAttribute(AuthCode.AUTH_CODE,authCode);//key
		ImageIO.write(AuthCode.getAuthImg(authCode),"JPEG",response.getOutputStream());
		
	}
	

}
