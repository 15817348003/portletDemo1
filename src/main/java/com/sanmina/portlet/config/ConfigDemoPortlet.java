package com.sanmina.portlet.config;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ConfigDemoPortlet
 */
public class ConfigDemoPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		System.out.println("加载configdemo的reder方法");
		PortletPreferences preferences = renderRequest.getPreferences();
		String title = preferences.getValue("mytitle", StringPool.BLANK);
		String link = preferences.getValue("mylink", StringPool.BLANK);
		renderRequest.setAttribute("mytitle", title);
		renderRequest.setAttribute("mylink", link);
		super.render(renderRequest, renderResponse);
	}
	
	
 

}
