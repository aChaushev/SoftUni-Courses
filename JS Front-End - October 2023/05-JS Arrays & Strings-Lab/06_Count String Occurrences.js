"use strict";
function solve(text, word) {
    const words = text.split(" ");
    let counter = 0;

    for (let i = 0; i < words.length; i++) {
        if (words[i] === word) {
            counter++;
        }
        
    }
    // или
    // const counter = text.split(" ").filter(function (element) {
    //     return element === word;
    // }).length;

    console.log(counter);

}

solve('This is a word and it also is a sentence','is');
solve('softuni is great place for learning new programming languages','softuni');