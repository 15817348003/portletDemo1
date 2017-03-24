package com.portlet.edit;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EditDemoPortlet
 */
public class EditDemoPortlet extends MVCPortlet {
 
	/**
	 * 跳转到用户偏好设置界面
	 */
	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		System.out.println("加载EditDemoPortlet的doedit方法");
		
		//获取当前portlet的 属性配置信息
		PortletPreferences preferences  = renderRequest.getPreferences();
	
		//从该配置信息中获取key值为mytitle的参数值，并将其存储到renderRequest中
		renderRequest.setAttribute("myIp", preferences.getValue("myIp", StringPool.BLANK));
		renderRequest.setAttribute("myPort", preferences.getValue("myPort", StringPool.BLANK));
		
		//请求转发到edit.jsp页面中，该页面接收来自request的参数
		getPortletContext().getRequestDispatcher("/html/editdemo/edit.jsp").include(renderRequest,
					renderResponse);
	}
	
	@Override
	/**
	 * edit.jsp页面表单提交操作的方法
	 */
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		System.out.println("加载EditDemoPortlet的processAction方法");
		
		//获取当前portlet的属性配置信息
		PortletPreferences preferences =  actionRequest.getPreferences();
		//该属性配置信息不为空时
		if (Validator.isNotNull(preferences)) {
			//从request里面取数据
			String myIp = ParamUtil.getString(actionRequest, "myIp");
			String myPort = ParamUtil.getString(actionRequest, "myPort");
			
			//将数据以键值对的形式填充到preferences里面
			preferences.setValue("myIp", myIp);
			preferences.setValue("myPort", myPort);
			
			//存储数据到数据库中，持久化数据
			preferences.store();
			SessionMessages.add(actionRequest, "success");
		 }

		super.processAction(actionRequest, actionResponse);
	}
	
	@Override
	/**
	 * 加载portlet时加载的方法
	 * 获取该portlet的设置属性信息，并将其保存到request里
	 */
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		
		System.out.println("加载EditDemoPortlet的render方法");
		
		//获取该portlet的属性配置信息
		PortletPreferences preferences = renderRequest.getPreferences();
		String myIp = preferences.getValue("myIp", StringPool.BLANK);
		String myPort = preferences.getValue("myPort", StringPool.BLANK);
		
		//设置为空时的默认值
		if(myIp == null || "".equals(myIp)){
			renderRequest.setAttribute("myIp", "localhost");
		} else {
			renderRequest.setAttribute("myIp", myIp);
		}
		
		if(myPort == null || "".equals(myPort)){
			renderRequest.setAttribute("myPort", "8080");
		} else {
			renderRequest.setAttribute("myPort", myPort);
		}
		//将上下问路径加载到request对象中
		renderRequest.setAttribute("contextPath", renderRequest.getContextPath() + "/");
		super.render(renderRequest, renderResponse);
	}

}
