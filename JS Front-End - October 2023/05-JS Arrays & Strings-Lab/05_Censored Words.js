"use strict";
function censored(text, targetWord) {
    let censoredReplace = '*'.repeat(targetWord.length);
    
    while (text.includes(targetWord)) {
        text = text.replace(targetWord, censoredReplace);
    }
    console.log(text);
}

censored('A small sentence with some words', 'small');
censored('Find the hidden word', 'hidden');