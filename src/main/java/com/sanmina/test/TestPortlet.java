package com.sanmina.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sanmina.util.PortletHelper;

/**
 * Portlet implementation class TestPortlet
 */
public class TestPortlet extends MVCPortlet {
	
	@Override
	/**
	 * 跨域请求中转，调用远程rest服务，封装json资源再返回给前端
	 */
	public void serveResource(ResourceRequest request,
			ResourceResponse response) throws IOException,
			PortletException {
			//设置响应类型与编码
			response.setContentType("application/json;charset-utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			//获取远程rest资源
			String jsonResponse = PortletHelper.executeByGET("http://localhost:8081/extension/monitors");
			System.out.println(jsonResponse);
			//将返回的json提供给前端
			out.print(jsonResponse);
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletPreferences preferences = renderRequest.getPreferences();
		//不显示portlet边框
		preferences.setValue("portletSetupShowBorders", "false");
		preferences.store();
		
		//保存上下文路径
		String contextPath = renderRequest.getContextPath() + "/";
		renderRequest.setAttribute("contextPath", contextPath);
		super.render(renderRequest, renderResponse);
	}

}
