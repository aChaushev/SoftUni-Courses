"use strict";
function modernTimes (text) {
    return text.split(' ')
        .filter((word) => word.startsWith('#') && containsOnlyLetters(word))
        .map((word) => word.slice(1))
        .filter((word) => word !== '')
        .join('\n');

    function containsOnlyLetters(word) {
        return [...word.toLowerCase()]
            .slice(1)
            .map((symbol) => symbol.charCodeAt(0))
            .every((charCode) => charCode >= 97 && charCode <= 122);
    }
}

console.log(
modernTimes('Nowadays everyone uses # to tag a #special word in #socialMedia'));
console.log(
modernTimes('The symbol # is known #variously in English-speaking #regions as the #number sign'));