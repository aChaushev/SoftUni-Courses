
// const calculator = {
//     multiply: (x, y) => x * y,
//     divide: (x, y) => x / y,
//     add: (x, y) => x + y,
//     subtract: (x, y) => x - y,
// }

// const calculate = (num1, num2, operator) =>
//     calculator[operator] ? calculator[operator](num1, num2) : 0;


function calculate(num1, num2, operator) {
// object with arrow functions
const calculator = {
    multiply: (x, y) => x * y,
    divide: (x, y) => x / y,
    add: (x, y) => x + y,
    subtract: (x, y) => x - y,
}
    const fun = calculator[operator];

    if (!fun) {
        return 0;
    }

    return calculator[operator](num1, num2);
}
    
const result = calculate (5, 5,'multiply')
console.log(result);