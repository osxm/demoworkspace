describe("Search", function() {
    it("should pass", function() {
        ST.element('@keyword').type('Spring+Spring MVC+MyBatis整合开发实战 机械工业出版社');
        ST.element('input[type="submit"]').click();
        
    });
});