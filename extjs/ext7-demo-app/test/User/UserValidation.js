describe("UserValidation.js", function() {
    it("should pass", function() {
        var user = Ext.create('Ext7DemoApp.model.User'),failedValid = user.getValidation().dirty;
        debugger;
        expect(failedValid).toBe(!true);
        //done();
    });
});