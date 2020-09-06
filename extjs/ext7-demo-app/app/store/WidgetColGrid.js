Ext.define('Ext7DemoApp.store.WidgetColGrid', {
    extend: 'Ext.data.Store',
    alias: 'store.WidgetColGrid',
    model: 'Ext7DemoApp.model.Personnel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '/app/data/users.json',
        reader: {
            type: 'json',
            rootProperty: 'datas'
        }
    }
});