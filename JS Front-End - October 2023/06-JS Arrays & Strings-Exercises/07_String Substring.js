"use strict";
function substring(word, text) {
    let textArr = text.split(' ');

    for (let i = 0; i < textArr.length; i++) {
        if(textArr[i].toLowerCase() === word) {
            console.log(word);
            return;
        }
    }

    console.log(`${word} not found!`)
}

substring('javascript','JavaScript is the best programming language');
substring('python','JavaScript is the best programming language');