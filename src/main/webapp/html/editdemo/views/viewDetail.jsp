<%@ page contentType="text/html; charset=utf-8" %>
<table class="table table-hover" >
  <tr class="bg-info" >
    <th colspan="2" >{{monitor.monitorShortName}}</th>
  </tr>
  <tr>
    <td >编号：</td><td>{{monitor.monitorKey}}</td>
  </tr>
  <!-- 状态为1时该monitor为活跃状态 -->
  <tr ng-if="monitor.monitorStatus == '1'">
    <td  >状态：</td><td>活跃的Monitor</td>
  </tr>
  <tr>
    <td>全名：</td><td>{{monitor.monitorName}}</td>
  </tr>
  <tr>
  <!-- 格式化时间 -->
    <td >创建时间：</td><td>{{monitor.monitorCreateTime | date:'yyyy年MM月dd日 hh时mm分ss秒'}}</td>
  </tr>
</table>
