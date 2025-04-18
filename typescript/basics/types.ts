const primitiveNum = 42;
const objectNum = new Number(42);

// typeof checks
console.log(typeof primitiveNum === 'number')  // ✅ true
console.log(typeof objectNum === 'number')     // ❌ false (it's an 'object')

// instanceof checks
// console.log(primitiveNum instanceof Number)    // ❌ false
console.log(objectNum instanceof Number)       // ✅ true
