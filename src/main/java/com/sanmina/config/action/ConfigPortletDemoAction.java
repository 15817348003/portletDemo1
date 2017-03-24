package com.sanmina.config.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * 配置模式下的portlet对应的action类
 * @author cat
 *
 */
public class ConfigPortletDemoAction extends DefaultConfigurationAction {

	
	@Override
	/**
	 * 点击配置选项时进入的方法
	 * 这个方法是点击portlet中的配置时进入的方法。在这个方法里面做以下几件事情。
	 * 1）：我们获取到了当前portlet的PortletPreferences。

	 * 2）：从PortletPreferences里面获取key为customjspConfig_page_title和customjspConfig_page_link的数据，并将他们放到request里面。

	 * 3）：告诉Liferay我的配置页的JSP的路径是哪个。
	 */
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		System.out.println("加载action的render方法");
		String portletResource = renderRequest.getParameter("portletResource");
		//获取当前portlet的 属性配置信息
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest,portletResource);
		//从该配置信息中获取key值为mytitle的参数值，并将其存储到renderRequest中
		renderRequest.setAttribute("mytitle", preferences.getValue("mytitle", StringPool.BLANK));
		renderRequest.setAttribute("mylink", preferences.getValue("mylink", StringPool.BLANK));
		//return super.render(portletConfig, renderRequest, renderResponse);
		return "/html/configtemp/config.jsp";
	}
	
	@Override
	/**
	 * 保存配置时进入的方法，实现功能：
	 * 1.获取配置页中的提交的参数值
	 * 2.将值存储到数据库或者portletpreferences里，这里将值存储到portletpreferences里
	 */
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		System.out.println("加载action的processaction方法");
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		if (Validator.isNotNull(preferences)) {
		//从request里面取数据
		 String title = ParamUtil.getString(actionRequest, "mytitle");
		 String link = ParamUtil.getString(actionRequest, "mylink");
		//将数据以键值对的形式填充到preferences里面
		 actionRequest.setAttribute("mytitle", title);
		 actionRequest.setAttribute("mylink", link);
		 preferences.setValue("mytitle", title);
		 preferences.setValue("mylink", link);
		//存储数据到数据库中，持久化数据
		 preferences.store();
		 SessionMessages.add(actionRequest, "success");
		 }
		 super.processAction(portletConfig, actionRequest, actionResponse);
		 
	}


	
}
