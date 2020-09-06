Ext.define('Badou.controller.system.UserQueryController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.UserQuery',
    addUser:function(){
        Ext.create('Ext.window.Window',{
            width:600,
            height:400,
            items:{
                margin:10,
                xtype:'UserEdit',
                title:false
            }
        }).show();
    }
});