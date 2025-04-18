
function curriedSum(): any {
    let total: number = 0;

    const add = function(...args: number[]) : number | Function {
        if (args.length > 0) {
            total = total + args[0];
            return add;
        } else {
            return total;
        }
    }

    add.clear = function() : void {
        total = 0;
    }

    return add;
}


const add = curriedSum();

console.log(add(1)(2)(3)()); // Output: 6
add.clear();
console.log(add(5)(10)(15)(-5)()); // Output: 25
add.clear();
console.log(add()); // Output: 0
