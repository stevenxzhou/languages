
var shadowingA = function() {
    var a = "123";

    function f() {
        a = "456";
    }
    
    f();

    console.log(a); // 456.

}

var shadowingB= function() {
    var a = "123";

    function f() {
        let a = "456";
    }
    
    f();

    console.log(a); // 123
}

shadowingA();
shadowingB();