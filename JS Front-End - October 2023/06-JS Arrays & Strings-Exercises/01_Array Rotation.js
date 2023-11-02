"use strict";
function arrayRotation(arr, rotations) {
    // const copiedArr = [...arr]; 
    // -> ще направи копие на масива, което не е негова референция 
    for (let i = 0; i < rotations; i++) {
        const firstElement = arr.shift();
        arr.push(firstElement);
    }
    console.log(arr.join(" "));
}

arrayRotation([51, 47, 32, 61, 21], 2);
arrayRotation([32, 21, 61, 1], 4);
arrayRotation([2, 4, 15, 31], 5);