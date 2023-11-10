function charactersInRange(char1, char2) {
    let charList = [];

    let asciiCode1 = Math.min(char1.charCodeAt(0), char2.charCodeAt(0));
    let asciiCode2 = Math.max(char1.charCodeAt(0), char2.charCodeAt(0));
    
    for (let i = asciiCode1 + 1; i < asciiCode2; i++) {
        charList.push(String.fromCharCode(i));
    }

    console.log(charList.join(" "));
}

charactersInRange('a', 'd');
charactersInRange('#', ':');
charactersInRange('C', '#');