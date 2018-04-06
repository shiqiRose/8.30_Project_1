/**
 * 
 */
package com.lingzhuo.framework.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lingzhuo.vo.PageVo;

/**
 * @ClassName: BaseControl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月31日 下午2:59:01
 *
 */
public class BaseControl extends HttpServlet{
	
	private PageVo pageVo =new PageVo();
	private String action;
	
	public String getAction() {
		return action;
	}
	
	public PageVo getPageVo() {
		return pageVo;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNow=request.getParameter("pageNow");
		action=request.getParameter("action");
		if(pageNow!=null&&!pageNow.trim().equals("")){
			pageVo.setPageNow(Integer.parseInt(pageNow));	
		}else{
			pageVo.setPageNow(1);
		}
	}
	
	

}
