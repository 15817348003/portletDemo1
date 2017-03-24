//声明一个控制器
Ext.define('CAT.controller.Monitors', {
    extend: 'Ext.app.Controller',
    requires: 'Ext.window.Window',

    //引入视图，存储以及数据模型
    views: [
            'monitor.List',
            'monitor.Detail'
    ],
    stores: ['Monitors'],
    models: ['Monitor'],
    //初始化控制器:给视图添加双击的事件监听
    init: function() {
        this.control({
            'monitorlist': {
                itemdblclick: this.monitorDetail
            }
        });
    },

    //实例化详情视图
    monitorDetail: function(grid, record) {
    	var view = Ext.widget('monitordetail');
    	
    	//将record传递给详情视图中的form组件
        view.down('form').loadRecord(record);
    }
});