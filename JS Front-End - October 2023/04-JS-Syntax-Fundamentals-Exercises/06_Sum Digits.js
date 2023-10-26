function solve(number) {
    const digitsString = number.toString(); // превръщаме integer в string //
    let sum = 0;

    for (let i = 0; i < digitsString.length; i++) {
        sum += Number(digitsString[i]);  // превръщаме digitsString[i] в integer //
    }
    console.log(sum);
}

solve(245678);
solve(97561);
solve(543);
