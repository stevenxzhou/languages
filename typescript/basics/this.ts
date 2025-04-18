// Lexical This

// Example 1. Commmented as ts would show errors on `this.name`. 
// const obj = {
//     name: "Alice",
//     say: () => {
//         console.log(this.name); // `this` refers to the outer context, NOT `obj`
//     }
// };
// obj.say(); // Output: undefined

// Example 2.
// const sayHii = () => {
//     console.log(this.name);
// }
// const obj = {
//     name: "Alice",
//     say: sayHii
// };
// obj.say(); // Output: undefined


// Dynamic This.

// Example: 1
// const obj = {
//     name: "Alice",
//     sayHi() {
//         console.log(this.name); // `this` refers to `obj`
//     }
// };
// obj.sayHi(); // Output: Alice

// // Example: 2
// function sayHello() {
//     console.log(this.name);
// }

// const obj1 = { name: "Alice", greet: sayHello };
// const obj2 = { name: "Bob", greet: sayHello };

// obj1.greet(); // Output: "Alice"
// obj2.greet(); // Output: "Bob"



// class Emiter {
//     public eventName:string;
    
//     constructor(){
//         this.eventName = "EventNameHi"
//     }

//     once(event: string): void {
//         console.log(`Event: ${event}, EventName: ${this.eventName}`);
//     }
// }

// const emitter_2 = new Emiter();
// const callbackFail = emitter_2.once;
// callbackFail("error"); // once is no longer called with the `this` from emitter_2 context. 
// const callbackSucceed = emitter_2.once.bind(emitter_2);
// callbackSucceed("succeed");

// // bind this withtin a class for a function declaration. 
// class Counter {
//     count = 0;

//     constructor() {
//         // Bind the increment method to the class instance
//         this.increment = this.increment.bind(this);

//         document.getElementById('btn').addEventListener('click', this.increment.bind(this));
//     }

//     increment() {
//         this.count += 1;
//         console.log(this.count);
//     }
// }

// ==> this in function
// 1. arrow function. It behaves like Java. It looks anything defined within the scope. 
// 2. Function declaration. It behaves like vanila JS. It finds anything possible along the chain. 

// ==> this in object literal
// no this for arrow function. 
// this is okay which will look up in the chain. 

// ==> this in class
// arrow function helps keep the this scope. 
// function declaration needs to bind the this if intended to call the function under a different context (eg. called by window.methodName or any other callbacks)

// ==> this in dom (callback)
// bind the object before assiging to the dom event. 