"use strict";
function sortedNameList(arr) {
    arr.sort((a, b) => a.toLowerCase().localeCompare(b.toLowerCase()));
    // -> прави първите букви малки и ги сравнява и сортира (избягваме сравнение на малки и големи букви)
    // -> arr не се променя в стрима

    for (let i = 0; i < arr.length; i++) {
        console.log(`${i + 1}.${arr[i]}`);
    }  
}

sortedNameList(["John", "Bob", "Christina", "Ema"]);