Ext.define('CAT.view.monitor.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.monitorlist',

    title : 'Active Monitors',
    store: 'Monitors',

    initComponent: function() {
        this.columns = [
            {header: 'MonitorName', dataIndex: 'monitorName', flex: 1},
            {header: 'MonitorShortName',  dataIndex: 'monitorShortName',  flex: 1}
            
        ];

        this.callParent(arguments);
    }
});