function solve(num1, num2) {
    let sum = 0;
    const numbers = [];
    
    for (let i = num1; i <= num2; i++) {
        sum += i;
        numbers.push(i);
    }

    console.log(numbers.join(" "));
    console.log(`Sum: ${sum}`);
}

solve(5, 10);
solve(0, 26);
solve(50, 60);