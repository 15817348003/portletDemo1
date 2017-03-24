Ext.define('CAT.controller.Monitors', {
    extend: 'Ext.app.Controller',

    views: [
        'monitor.List'
    ],
    stores: ['Monitors'],
    models: ['Monitor'],
    init: function() {
        this.control({
            'monitorlist': {
                itemdblclick: this.editMonitor
            }
        });
    },

    editMonitor: function(grid, record) {
        console.log('Double clicked on ' + record.get('name'));
    }
});