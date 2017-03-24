Ext.application({
    requires: 'Ext.container.Viewport',
    name: 'CAT',

    appFolder: 'app',

     controllers: [
        'Monitors'
    ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
        	renderTo : Ext.get("mytest"),
            layout: 'fit',
            items: {
                xtype: 'monitorlist'
            }
        });
    }
});