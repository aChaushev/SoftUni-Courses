function loadingBar(number) {
    let loadingBarArr = [];

    for (let i = 0; i < number/10; i++) {
        loadingBarArr.push("%");
    }

    for (let i = number/10; i < 10; i++) {
        loadingBarArr.push(".");
    }

    if (number < 100) {
        console.log(`${number}% [${loadingBarArr.join("")}]`);
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