"use strict";
function sumDifference(arr) {
    let sumEven = 0;
    let sumOdd = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % 2 === 0) {
            sumEven += arr[i];
        } else {
            sumOdd += arr[i];
        }  
    }

    // console.log(Math.abs(sumEven - sumOdd));
    console.log(sumEven - sumOdd)
} 

sumDifference([1,2,3,4,5,6]);
sumDifference([3,5,7,9]);
sumDifference([2,4,6,8,10]);