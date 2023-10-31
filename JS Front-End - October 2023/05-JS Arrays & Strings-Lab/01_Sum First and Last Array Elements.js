"use strict";
function sumFirstAndLast (arr) {
    // let result = arr[0] + arr[arr.length - 1];
    let result = arr.pop() + arr.shift();
    console.log(result);
}

sumFirstAndLast([20, 30, 40]);
sumFirstAndLast([10, 17, 22, 33]);
sumFirstAndLast([11, 58, 69]);