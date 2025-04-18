var hoistedVar = function() {
    function f(){
        console.log(abc);
    }
    
    // abc is hoisted and assigned with undefined.
    f(); // undefined
    
    var abc = "hello world";
}

var hoistedTDZ = function() {
    function f() {
        console.log(abc);
    }
    
    // abc is hoisted and placed under Temporal Dead Zone.
    f(); // ReferenceError: Cannot access 'abc' before initialization
    
    let abc = "hello world";
}

var hoistedFixed = function() {
    function f() {
        console.log(abc);
    }
    
    let abc = "hello world";

    // abc is hoisted and placed under Temporal Dead Zone.
    f(); // Hello world
}

hoistedFixed()
// hoistedVar();
// hoistedTDZ();

