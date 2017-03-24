Ext.application({
	requires: 'Ext.panel.Panel',
	//声明全局命名空间为CAT
    name: 'CAT',

    //声明全局根目录为app
    appFolder: contextPath + 'html/test/app',

    //引入monitors控制器
     controllers: [
        'Monitors'
    ],

    launch: function() {
    	//实例化panel对象
    	Ext.create('Ext.panel.Panel', {
    		//绑定到mytest组件中
            renderTo: 'mytest',
            
            items: {
            	//引用monitorlist视图
                xtype: 'monitorlist'
            }
        });
    }
});