Ext.define('CAT.store.Monitors', {
    extend: 'Ext.data.Store',
    model: 'CAT.model.Monitor',
    autoLoad: true,
        
    proxy: {
        type: 'ajax',
        url: 'http://localhost:8081/extension/monitors',
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        }
    }


});