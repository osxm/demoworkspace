describe("ButtonText", function() {
    it("should pass", function() {
        var btn = Ext.create('Ext.button.Button',{
            renderTo:Ext.getBody(),
            text:'My Button'
        });
        expect(btn.getText()).toBe('My Button');
    });
});