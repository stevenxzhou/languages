function* director() {
    yield "Three";
    yield "Two";
    yield "One";
}

let countdown = director();

// let result = countdown.next();

// while (!result.done) {
//     console.log(result.value);
//     result = countdown.next();
// }

for (let val of countdown) {
    console.log(val);
}