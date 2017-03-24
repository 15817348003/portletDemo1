//声明ViewListController控制器，注入rootScope全局对象
actionApp.controller('ViewListController', ['$rootScope', '$scope', '$http', 
    function($rootScope,$scope, $http) {
		//加载完成的事件监听
        $scope.$on('$viewContentLoaded', function() {
        	//向rest服务请求资源
        	$http.get('http://'+myIp+':'+myPort+'/extension/monitors', {
            }).success(function(data) {
            	console.log(data);
            	//将数据绑定到scope对象中
                $scope.list = data.data;
                $scope.count = data.count;
            });
        });

        //查看详情的onclick调用的函数
        $scope.search = function(item) {
        	//将传进来的monitor对象存储到rootScope全局对象中，方便其他视图控制器访问
        	$rootScope.monitor = item;
            console.log(item);
            //跳转到detail路由
            location.href = "#/detail";
        };
    }]);

actionApp.controller('ViewDetailController', ['$rootScope', '$scope', 
    function($rootScope, $scope) {
        $scope.$on('$viewContentLoaded', function(){
        	//从rootScope全局对象获取monitor对象绑定到scope中
        	$scope.monitor = $rootScope.monitor;
            console.log('页面加载完成');
        });
    }]);