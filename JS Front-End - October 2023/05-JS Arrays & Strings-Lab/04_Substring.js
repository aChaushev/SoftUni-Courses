"use strict";
function substring(text, startIndex, endIndex) {
    let resultString  = text.substr(startIndex, endIndex);
    console.log(resultString);
}

substring('ASentence', 1, 8);
substring('SkipWord', 4, 7);