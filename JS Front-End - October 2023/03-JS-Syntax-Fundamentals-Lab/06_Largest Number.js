function solve(firstNum, secondNum, thirdNum) {
    let result;

    if (firstNum > secondNum && firstNum > thirdNum) {
        result = firstNum;
    } else if (secondNum > firstNum && secondNum > thirdNum) {
        result = secondNum;
    } else if (thirdNum > firstNum && thirdNum > secondNum) {
        result = thirdNum;
    }

    console.log(`The largest number is ${result}.`);
}

solve(5, -3, 16);
solve(-3, -5, -22.5);