"use strict";
function pascalCaseSplitter(input) {

    console.log(input.split(/(?=[A-Z])/).join(", "));
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCan');
pascalCaseSplitter('HoldTheDoor');
pascalCaseSplitter('ThisIsSoAnnoyingToDo');

