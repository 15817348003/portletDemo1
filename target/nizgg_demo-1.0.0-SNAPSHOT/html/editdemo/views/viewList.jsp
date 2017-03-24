<%@ page contentType="text/html; charset=utf-8"%>

<table class="table table-hover">
	<tr class="bg-info">
		<!-- 非空判断 -->
		<th><h6 ng-if="count && !count==''">
				共有活跃的monitor<strong> {{count}} </strong>条
			</h6></th>
	</tr>
	<tbody ng-repeat="item in list">
		<tr>
			<td ng-click='search(item)'><a ng-click='search(item)'>
					{{item.monitorShortName}} </a></td>
		</tr>

	</tbody>
</table>
