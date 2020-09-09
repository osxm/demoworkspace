describe("InspectTool", function() {
    it("should pass", function() {
        //鼠标放在这一行用于监视获取页面元素定位
        ST.element('@keyword').type('Spring+Spring MVC+MyBatis整合开发实战 机械工业出版社');
        ST.element('@/div[2]/form/input[4]').click();
    });
});