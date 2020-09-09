describe("login", function() {
    it("should pass", function() {
        ST.element('@userid').type('a-username');
        
        expect(1).toBe(1);
    });
});