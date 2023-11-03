"use strict";
function numSort(arr) {
    const sortedArray = arr.sort((a, b) => a - b);
    const resultArr = [];
    const length = arr.length;

    for (let i = 0; i < length; i++) {
        if(i % 2 === 0){
            resultArr.push(sortedArray.shift());
        } else {
            resultArr.push(sortedArray.pop());
        }
    }

    return resultArr;
}

console.log(numSort([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));