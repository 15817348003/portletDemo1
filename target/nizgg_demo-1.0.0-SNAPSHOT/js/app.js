//声明一个editApp的模块
var actionApp = angular.module('editApp', ['ngRoute']);
/*
 * 配置路由：
 *      路径为：list时渲染viewlist.jsp视图
 *      路径为：detail时渲染viewdetail.jsp视图
 */
actionApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/list', {
        controller: 'ViewListController',
        templateUrl: contextPath+'html/editdemo/views/viewList.jsp',
    }).when('/detail', {
        controller: 'ViewDetailController',
        templateUrl: contextPath+'html/editdemo/views/viewDetail.jsp',
    });
    
}]);


