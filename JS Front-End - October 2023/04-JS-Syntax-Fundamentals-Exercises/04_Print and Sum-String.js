function solve(num1, num2) {
    let sum = 0;
    let numbers ="";
    
    for (let i = num1; i <= num2; i++) {
        sum += i;
        // numbers = numbers.concat(i + " ");
        numbers += i + " "; 
    }

    console.log(numbers.trimEnd());
    console.log(`Sum: ${sum}`);
}

solve(5, 10);
solve(0, 26);
solve(50, 60);