global.name = "globalName";

const obj = {
    name: "localParentName",
    childObj: {
        getNameFn: function() {
            console.log(this.name); // steven

            // Non-strict mode: this refers to global object
            (function abc() { 
                console.log(this.name); // undefined when no global name, or use the global name.
            })();

            // Non-strict mode: this refers to global object
            function bcd() {
                console.log(this.name);
            }

            bcd();
        }, 
    },
    getNameFn: function() {
        console.log(this.name); // steven

        // Non-strict mode: this refers to global object
        (function abc() { 
            console.log(this.name); // undefined when no global name, or use the global name.
        })();

        // Non-strict mode: this refers to global object
        function bcd() {
            console.log(this.name);
        }

        bcd();
    },
    getNameArrow: () => {
        console.log(this.name);  // always undefined
    }
}

// obj.getNameFn(); 
// obj.getNameArrow();
// obj.childObj.getNameFn();


class Test {
    constructor(name){
        this.name = name;
    }

    getNameFn() {
        console.log(this.name); // still depends on how this function is called. the context can be changed. So more flexible. 
    }

    getNameArrow = () => {
        console.log(this.name); // this context is fixed. 
    }
}

let test = new Test('localName');
test.getNameFn();
test.getNameArrow();

