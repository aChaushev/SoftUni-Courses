"use strict";

function solve(number) {
    let areSame = true;
    const numToString = number.toString();
    let sum = 0;

    for (let i = 0; i < numToString.length; i++) {
        if (i < (numToString.length - 1) && numToString[i] !== numToString[i + 1]) {
            areSame = false;
        }
        sum += Number(numToString[i]);
    }

    console.log(areSame);
    console.log(sum);
}

solve(2222222);
solve(1234);