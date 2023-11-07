function repeatStr(string, count) {
    let newString = "";
    for (let i = 0; i < count; i++) {
        newString = newString.concat(string);
    }
 
    return newString;
}

console.log(repeatStr("abc", 3));
console.log(repeatStr("String", 2));
