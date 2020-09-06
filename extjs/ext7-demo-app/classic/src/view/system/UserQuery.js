Ext.define('Ext7DemoApp.view.system.UserQuery', {
    extend: 'Ext.grid.Panel',
    xtype: 'UserQuery',
    title:'三国名人录',
    controller:'UserQuery',
    columns: [
        { text: 'Id',  dataIndex: 'id' },
        { text: 'Name',  dataIndex: 'name' },
        { text: 'Kingdom', dataIndex: 'kingdom'},
    ],store:{
        type:'user'
    },
    tbar:[{
        text:'Add',
        handler:'addUser'
    }]
});