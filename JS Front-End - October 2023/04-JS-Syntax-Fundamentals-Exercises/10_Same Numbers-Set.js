"use strict";

function solve(number) {
    const digits = Array.from(String(number), Number); 
    // кастваме числото в String и го правим в масив, 
    // записвайки масива кастваме всеки char обратно в digit
    // или 
    // const digits = number.toString().split("").map(Number);

    const isConsistent = new Set(digits).size === 1; 
    // създаваме Set(всеки елемент е уникален) от масива 
    // и проверяваме дали има само един елемент 

    const sum = digits.reduce(function(total, num) {
        return total + num;

    }, 0) // reduce method - най-често за калкулации на total sum ....
    // първоначална стойност 0

    console.log(isConsistent);
    console.log(sum);
}

solve(2222222);
solve(1234);