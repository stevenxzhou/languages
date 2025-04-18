class EventEmitter {
    
    private events: Map<string, Function[]>;

    constructor() {
        this.events = new Map<string, Function[]>();
    }

    on = (event: string, func: Function) => {
        if (!this.events.has(event)) {
            this.events.set(event, []);
        }

        const eventFuncs = this.events.get(event)!;

        if (!eventFuncs.includes(func)) {
            eventFuncs.push(func);
        }

        // console.log(eventFuncs);
    }

    off = (event: string, func: Function) => {
        if (!this.events.has(event)) {
            return;
        }

        const eventFuncs = this.events.get(event);

        // onsole.log(this.events);

        this.events.set(event, eventFuncs.filter(fn => fn !== func));
        // console.log(this.events);
    }

    emit = (event: string, ...args) => {
        if (!this.events.has(event)) {
            return;
        }

        let eventFuncs = this.events.get(event);

        eventFuncs.forEach(fn => {
            fn(...args);
        })
    }

    once = (event: string, func: Function) => {
        const wrapper = (...args)=> {
            func(...args);
            this.off(event, wrapper);
        }
        this.on(event, wrapper);
    }
}




// Test
const emitter = new EventEmitter();

const greet = (name) => console.log(`Hello, ${name}`);
const farewell = (name) => console.log(`Goodbye, ${name}`);

emitter.on('greeting', greet);
emitter.on('greeting', farewell);
emitter.emit('greeting', 'Alice'); // Output: "Hello, Alice" and "Goodbye, Alice"

emitter.off('greeting', greet);
emitter.emit('greeting', 'Bob'); // Output: "Goodbye, Bob"

const onceTime = (name) => console.log(`I see you once, ${name}`);
emitter.once('greeting', onceTime);
emitter.emit('greeting', 'Bob');
emitter.emit('greeting', 'Bob'); 

