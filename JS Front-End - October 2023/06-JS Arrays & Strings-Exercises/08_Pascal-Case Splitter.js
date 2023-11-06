"use strict";
function pascalCaseSplitter(input) {
    let lastWordStartIndex = 0;
    let textArr = []
    
    for (let i = 0; i < input.length; i++) {
        let symbol = input[i];
        let asciiCode = symbol.charCodeAt(0);
        if (i > 0 && asciiCode >= 65 && asciiCode <=90) {
            let wordToAdd = input.substring(lastWordStartIndex, i);
            textArr.push(wordToAdd);
            lastWordStartIndex = i;
        }
        if (i === input.length - 1) {
            let wordToAdd = input.substring(lastWordStartIndex, i + 1);
            textArr.push(wordToAdd);
        }
    }

    console.log(textArr.join(', '))
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCanSD');
pascalCaseSplitter('HoldTheDoor');
pascalCaseSplitter('ThisIsSoAnnoyingToDo');