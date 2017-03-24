<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%-- editPortlet编辑模式下的视图 --%>
<portlet:defineObjects />
<h4>设置Monitor的IP地址与端口号</h4>

<form class="form-inline" action="<liferay-portlet:actionURL portletConfiguration="true" />"
	name="myform" id="myform" method="post">
	<div class="form-group">
		<label for="myIp">Ip地址:</label>
    	<input type="text" class="form-control" id="myIp" name="<portlet:namespace />myIp" value="${myIp }" />
	</div>
	<div class="form-group">
    	<label for="myPort">端口号:</label>
    	<input type="text" class="form-control" id="myPort" value="${myPort }" name="<portlet:namespace />myPort" />
    </div>
  	<input type="submit" value="提交" />
</form>