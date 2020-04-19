Ext.define('Ext7DemoApp.store.User', {
    extend: 'Ext.data.Store',

    alias: 'store.user',

    model: 'Ext7DemoApp.model.User',

    data: {
        items: [
            { id: 1, name: '刘备',  kingdom: "蜀国" },
            { id: 2, name: '曹操',  kingdom: "魏国" },
            { id: 3, name: '孙权',  kingdom: "吴国" },
        ]
    },

    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});