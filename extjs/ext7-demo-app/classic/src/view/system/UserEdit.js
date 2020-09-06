Ext.define('Ext7DemoApp.view.system.UserEdit', {
    extend: 'Ext.form.Panel',
    xtype: 'UserEdit',
    controller:'UserEdit',
    title:'人员编辑',
    
    items:[{
        xtype:'textfield',
        fieldLabel:'Name'
    },{
        xtype:'combobox',
        fieldLabel:'KingDom',
        store:['魏','蜀','吴']
    },{
           xtype: 'button',
           text: 'Submit Change',
           formBind: true
    }],
    bbar:[{
        text:'Save',
        formBind: true
    },{
        text:'Cancle'
    }]
});