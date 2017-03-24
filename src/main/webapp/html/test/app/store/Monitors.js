Ext.define('CAT.store.Monitors', {
    extend: 'Ext.data.Store',
    //引入数据模型
    model: 'CAT.model.Monitor',
    //开启自动加载
    autoLoad: true,
        
    //通过ajax异步请求获取后台数据
    proxy: {
        type: 'ajax',
        url: restUrl,
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        }
    }


});