import { Person } from "./Person";

class Animal {
    test = () => {
        let person = new Person();
        person.speak();
    };
}

let animal = new Animal();
animal.test();