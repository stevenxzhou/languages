// // Arrow Function: No hoisting
// const say = (message: string) => {
//     console.log(message);
// }
// say("Hello TyepScript!");

// // Declared Function: Hoisting
// sayHi("Hi");
// function sayHi(message: string) {
//     console.log(message);
// }







// // Call
// const funcCall = (greeting, name) => {
//     console.log(`${greeting}, ${name}`);
// }
// funcCall.call(this, "Hello", "Lily"); // Immediate call, multiple arguments can be taken. 

// // Apply
// const funcApply = (greeting, name) => {
//     console.log(`${greeting}, ${name}`);
// }
// funcApply.apply(this, ["Hello", "Lily", "Haha"]); // Immediate call, only one additional argument which is an array of arguments. 

// // Bind
// funcCall.bind(this)("Bob", "Lily"); // Same as call, it is easier when we want to re-use the method with the specified `this`. 










// list args destructuring
const argsFuncList = (...names) => {
    console.log(...names); // We don't use it this way. 
    console.log(names); // Access names as an array. 
    names.forEach(name => {
        console.log(`Hello, ${name}`);
    })
}
argsFuncList("Lily", "Bob")

// obj args destructuring
const argsFuncObj = ({name, ...keyvals}) => {
    console.log(name);
    console.log(keyvals);
    console.log(keyvals.sex);
}
argsFuncObj({name: "Lily", sex:"Female"})