class EventLoop {

    constructor() {}

    timeout = () => {
        console.log("1");
        setTimeout(()=>{
            console.log("3");
        }, 0);
        console.log("2");
    }

    promise = () => {
        // Stack
        console.log("1");
        // Macro-task
        setTimeout(()=>{
            console.log("4");
        }, 0);
        // Micro-task queue
        Promise.resolve().then(() => {
            console.log("3");
        })
        // Stack
        console.log("2");
    }
}

let eventLoop = new EventLoop();
// eventLoop.timeout();
eventLoop.promise();