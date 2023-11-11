"use strict";
function palindromeIntegers(array) {

    for (let i = 0; i < array.length; i++) {
        let digitsArr = Array.from(String(array[i]), Number);
        console.log(isPalindrome(digitsArr));
    }

    function isPalindrome(digitsArr) {
        while (digitsArr.length > 1) {
            let firstNum = digitsArr.shift();
            let lastNum = digitsArr.pop();
            if (firstNum !== lastNum) {
                return false; 
            }
        }
        return true;
    }
}

palindromeIntegers([123, 323, 421, 121]);
palindromeIntegers([32,2,232,1010]);

