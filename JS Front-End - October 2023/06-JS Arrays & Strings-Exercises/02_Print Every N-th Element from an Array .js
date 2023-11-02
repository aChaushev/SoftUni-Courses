"use strict";
function printNthElement (arr,nthStep) {
const newArr =[];
    for (let i = 0; i < arr.length; i++) {
        if(i % nthStep === 0){
            newArr.push(arr[i])
        }
    }
    
    return newArr;
}
console.log(printNthElement(['5', '20', '31', '4', '20'], 2));
console.log(printNthElement(['dsa','asd', 'test', 'tset'], 2));
console.log(printNthElement(['1', '2','3', '4', '5'], 6));