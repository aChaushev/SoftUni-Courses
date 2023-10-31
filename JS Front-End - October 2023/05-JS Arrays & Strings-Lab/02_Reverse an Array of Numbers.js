"use strict";
function reverseArray(indexCnt, arr) {
  let newArr = arr.slice(0, indexCnt);
  newArr.reverse();
  
  console.log(newArr.join(" "));
  // let output = "";
  // for (let number of newArr) 
  // output += `${number} `;
  // console.log(output);
}

reverseArray(3, [10, 20, 30, 40, 50]);
reverseArray(4, [-1, 20, 99, 5]);
reverseArray(2, [66, 43, 75, 89, 47]);
