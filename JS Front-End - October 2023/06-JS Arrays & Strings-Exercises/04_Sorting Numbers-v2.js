"use strict";
function numSort(arr) {
    const smallestArr = [...arr.sort((a, b) => a - b)];
    const biggestArr = [...arr.sort((a, b) => b - a)]; // reverse()

    const resultArr = [];
    for (let i = 0; i < arr.length / 2; i++) {
        resultArr.push(smallestArr[i]);
        resultArr.push(biggestArr[i]); 
    }

    if (arr.length % 2 !== 0) {
        resultArr.pop();
    }

    return resultArr;
}

console.log(numSort([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));
console.log(numSort([1, 65, 3, 52, 48, 63, 31, -3, 18, 56, 99]));