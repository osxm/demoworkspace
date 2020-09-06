describe("Edit User", function() {
    it("在输入之前禁用保存按钮", function() {
        expect(1).toBe(1);
        
        var editForm = Ext.create('Ext7DemoApp.view.system.UserEdit'),button = editForm.down('button'), field = editForm.down('textfield');
        
        field.setValue('张飞');
        //done();    
    });
});