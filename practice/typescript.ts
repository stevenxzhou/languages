class Animal {
    #name = "";
    private sex = "";
    constructor() {
        this.#name = "asdf";
        this.sex = "male";
    }

    get name(){
        return this.#name;
    }

    get getSex(){
        return this.sex;
    }
}

const animal = new Animal();
console.log(animal.name);
console.log(animal.getSex);