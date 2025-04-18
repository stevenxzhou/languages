class PromiseTest {
    constructor() {}

    delay = (ms) => {
        return new Promise((resolve) => {
            setTimeout(resolve, ms);
        })
    }

    test = async () => {
        console.log("Before delay");
        await this.delay(2000);
        console.log("After delay");
    }
}

let promiseTest = new PromiseTest();

promiseTest.test()
console.log("This will show up first as the function called above is async.")


