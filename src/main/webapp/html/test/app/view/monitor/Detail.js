//声明一个monitor详细信息视图
Ext.define('CAT.view.monitor.Detail', {
    extend: 'Ext.window.Window',
    //设置别名为monitordetail
    alias : 'widget.monitordetail',
    

    title : 'Monitor Detail',
    layout: 'fit',
   // width: 500,
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
            	//引入form组件
                xtype: 'form',
                //添加信息空间显示monitor信息
                items: [
                    {
                        xtype: 'displayfield',
                        name : 'monitorName',
                        labelWidth:140,
                        fieldLabel: 'Monitor全名'
                    },
                    {
                        xtype: 'displayfield',
                        name : 'monitorShortName',
                        labelWidth:140,
                        fieldLabel: 'Monitor简称'
                    },
                    {
                        xtype: 'displayfield',
                        name : 'monitorStatus',
                        labelWidth:140,
                        fieldLabel: 'Monitor状态'
                    },
                    {
                        xtype: 'displayfield',
                        name : 'monitorType',
                        labelWidth:140,
                        fieldLabel: 'Monitor类型'
                    },
                    {
                        xtype: 'displayfield',
                        name : 'attributeName',
                        labelWidth:140,
                        fieldLabel: 'Monitor参数'
                    }
                ]
            }
        ];

        //添加按钮控件，点击关闭
        this.buttons = [
            {
                text: '确定',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});