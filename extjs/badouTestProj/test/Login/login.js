describe("login", function() {
    it("should pass", function() {
        //expect(1).toBe(1);
    ST.play([
        { type: "tap", target: "@/div/div[2]/div/form/div/div/input", x: 56, y: 15, pointerType: "mouse", identifier: 1 },
        { type: "tap", target: "@/div/div[2]/div/form/div/div/input", x: 56, y: 15, pointerType: "mouse", identifier: 1 },
        { type: "dblclick", target: "@/div/div[2]/div/form/div/div/input", x: 56, y: 15, detail: 2 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 },
        { type: "keydown", target: "@/div/div[2]/div/form/div/div/input", caret: 0 }
    ]);
        
    });
    
     it("login then inspect", function() {
          ST.element('@email').type('a-username');
          ST.element('@password').type('a-password');
          ST.element('@submit').click();
      });
});