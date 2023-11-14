"use strict";
function loadingBar(number) {
    let percentageNumber = number / 10;
    let bar = "%".repeat(percentageNumber) + ".".repeat(10 - percentageNumber);

    if (number < 100) {
        console.log(`${number}% [${bar}]`);
        console.log("Still loading...");
    } else if (number === 100) {
        console.log("100% Complete!");
        console.log("[%%%%%%%%%%]");
    }
}

loadingBar(0);
loadingBar(30);
loadingBar(50);
loadingBar(100);