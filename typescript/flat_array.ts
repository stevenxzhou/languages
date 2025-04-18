// recursive
function flattenArray(nestedArray: any[]): number[] {
    let flattened: number[] = [];

    nestedArray.forEach((item: number | number[]) => {
        if (typeof item === 'number') {
            flattened.push(item);
        } else {
            flattened = flattened.concat(flattenArray(item));
        }
    })

    return flattened;
}

// Iterative

const nestedArray = [1, [2, [3, [4]]]];
const flattened = flattenArray(nestedArray);
console.log(flattened); // 输出: [1, 2, 3, 4]