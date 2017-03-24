//声明一个数据模型类
Ext.define('CAT.model.Monitor', {
    extend: 'Ext.data.Model',
    //实体数据属性名
    fields: ['monitorKey', 'monitorInitialKey', 'netUserId', 'monitorName', 'monitorType', 'monitorShortName', 
            'partNumber', 'groupingType', 'visibleChart', 'monitorStatus', 'attributeName', 
            'groupingTimeRange', 'lastGroupDate', 'partFamilyKey', 'partFamilyId', 'partFamilyId',
             'partFamilyName', 'sampleSize', 'monitorCreateTime', 'extf1', 'extf2', 'extf3', 
             'dataSource', 'lastGroupTime', 'lastGroupTime2', 'lastGroupTime3', 'lastGroupTime4'],
});