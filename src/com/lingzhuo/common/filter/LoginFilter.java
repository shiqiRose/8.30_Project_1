/**
 * 
 */
package com.lingzhuo.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年9月8日 上午9:32:09
 *
 */

public class LoginFilter implements Filter{


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("+++++++fiter---destory");
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("+++++++dofiter++++++");
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		//获取请求的Url
		String url=httpRequest.getRequestURI().toString();//   /8.30ServletExample/sdf/xxxx.do
		url=url.substring(url.indexOf("/",1));//  从第一个字符位置开始往后继续查找，包含当前位置  ，结果8.30ServletExample/xxxx.do
		//System.out.println("----url----"+url);
		Object obj=httpRequest.getSession().getAttribute("uesr");
		//验证用户是否登录成功过
		if(obj!=null){//登陆成功过
			chain.doFilter(request, response);//放行
		}else{//未登录成功过
			if(url!=null){
				if(url.equals("/login.do")){
					chain.doFilter(request, response);//放行
				}else if(url.equals("/authCodeControl.do")){
					chain.doFilter(request, response);//放行
				}else if(url.equals("/examineeRegistControl.do")){
					chain.doFilter(request, response);//放行
				}else if(url.equals("/ExamineeInfo.do")){
					chain.doFilter(request, response);//放行
				}else if(url.equals("/pageControl.do")){
					chain.doFilter(request, response);//放行
				}else if(url.equals("/exaStudentControl.do")){
					chain.doFilter(request, response);//放行
				}
				else{
					 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				}
				
			}
		}
	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println("+++++++fiter---init");
	}

}
