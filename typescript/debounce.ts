function debounce(func:Function): Function {

    let timeoutHandle = null;

    return function(args) {
        if (timeoutHandle != null) {
            clearTimeout(timeoutHandle);
        }
        timeoutHandle = setTimeout(()=> {
            func(args);
        }, 2000)
    }
}

function saySomething(message: string): void {
    console.log(message);
}
let db = debounce(saySomething); // debounce function
db("Hello 01");
db("Hello 02");
db("Hello 03");