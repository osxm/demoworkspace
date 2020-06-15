/**
 * Author:Xueming Chen
 * Date:2020/06
 */
Ext.define('Ext7DemoApp.controller.ComUtil', {
    extend: 'Ext.app.Controller',
    init: function () {
        alert('应用控制器init');
    },
    getLoginToken: function () {
        return "JWT Token";
    }


});
