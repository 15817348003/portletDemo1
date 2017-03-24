<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%-- editPortlet视图 --%>
<portlet:defineObjects />

<div class="container-fluid" ng-app="editApp" >
	<div class="row center-block">
  		<div class="col-md-4" style=""><h5>地址:${myIp}</h5></div>
   		<div class="col-md-3"><h5>端口号:${myPort}</h5></div>
   		<div class="col-md-4  col-md-offset-1"><a class="btn " href="#/list">获取monitor列表</a></div>
  	</div>
	<ng-view></ng-view>
</div>
<script type="text/javascript" >
		//获取上下文路径
		var contextPath = ' ${contextPath}';
		//将ip和端口号绑定到js中
		var myIp = '${myIp}';
		var myPort = '${myPort}';
</script>