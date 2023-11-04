"use strict";
function modernTimes (text) {
    let words = text.split(' ');

    let result = [];
    for (const word of words) {
        if (word.startsWith('#') && word.length > 1 && checkIfWordIsValid(word)) {
            result.push(word.slice(1));
        }
    }

    console.log(result.join('\n')); // печата елементите на нов ред

    function checkIfWordIsValid(myWord) {
        let myWordLowercase = myWord.toLowerCase().slice(1); //взима от index 1 нататак inclusive

        for (const symbol of myWordLowercase) { //проверяваме всеки символ дали е от 'a' до 'z'
            let asciiCode = symbol.charCodeAt(0);
            if (!(asciiCode >= 97 && asciiCode <= 122)) {
                return false; 
            }
        }

        return true;
    }
}


modernTimes('Nowadays everyone uses # to tag a #special word in #socialMedia');
modernTimes('The symbol # is known #variously in English-speaking #regions as the #number sign');