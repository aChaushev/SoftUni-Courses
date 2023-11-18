class Cat {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    meow = () => {
        console.log(`${this.name}, age ${this.age} says Meow`);
    };
} 

//за Judge class Cat да се премести във function createCats

function createCats(input) { 
    input.forEach((line) => {
        const [name, age] = line.split(" ");
        const cat = new Cat(name, age);
        const greet = cat.meow;

        greet();
    });
}

createCats(['Mellow 2', 'Tom 5']);
createCats(['Candy 1', 'Poppy 3', 'Nyx 2']);