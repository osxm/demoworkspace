Ext.define('Ext7DemoApp.view.main.UserGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'usergrid',
    title:'三国名人录',
    columns: [
        { text: 'Id',  dataIndex: 'id' },
        { text: 'Name',  dataIndex: 'name' },
        { text: 'Kingdom', dataIndex: 'kingdom'},
    ],store:{
        type:'user'
    }
});