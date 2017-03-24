<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<%-- portlet的配置页面 --%>
<portlet:defineObjects />

This is the
<b>Config Demo</b>
portlet in Config mode.
<form action="<liferay-portlet:actionURL portletConfiguration="true" />"
	name="<portlet:namespace />fm" id="myform"
	method="post">
	<ul>
		<li><span>标题：</span> <input tabindex="1" type="text"
			name="<portlet:namespace />mytitle"
			id="<portlet:namespace />mytitle"
			value="${mytitle }" /></li>
		<li><span>链接地址:</span> <input
			id='mylink'
			name='<portlet:namespace />mylink' type="text"
			value="${mylink }" /></li>
<portlet:renderURL  var="renderUrl">
	<portlet:param name="mvcPath" value="/html/editdemo/view.jsp" />
</portlet:renderURL>
		<li><input type="button" value="提交" onclick="saveConfig('${renderUrl}')"></li>
		
	</ul>
</form>
