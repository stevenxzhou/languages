// Rest with type annotations
// Use rest parameters (...numbers) when you want a more flexible, varargs-style interface
// The rest operator (...) gathers all remaining arguments into an array.
function sum(...numbers: number[]): number {
    return numbers.reduce((total, num) => total + num, 1);
}
console.log(sum(1, 2, 3, 4, 5));
// Use array parameter (numbers: number[]) when you're working with existing arrays
function sum2(numbers: number[]): number {
    return numbers.reduce((prev, val) => prev + val , 0)
}
console.log(sum2([1, 2, 3, 4, 5]));





// Rest in array destructuring with types
const [first, second, third, ...additionals]: number[] = [1, 2, 3, 4, 5];
console.log(first);
console.log(additionals);





// Rest in object destructuring with types
interface Person {
    name1: string, 
    age: number, 
    city: string
}
const {name1, ...others}: Person = {name1: 'John', age: 30, city: 'Bothell'}
console.log(others);
