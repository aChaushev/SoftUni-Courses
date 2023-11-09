function seqSignCheck(num1, num2, num3) {
    const signsArr = [
    ...(num1 < 0 ? [num1] : []),
    ...(num2 < 0 ? [num2] : []),
    ...(num3 < 0 ? [num3] : []),
    ];
        
    if (signsArr.length % 2 === 0) {
        console.log("Positive")
    } else if (signsArr.length % 2 !== 0) {
        console.log("Negative")
    } else {
        console.log("Zero")
    } 
}

seqSignCheck(5, 12, -15);
seqSignCheck(-6, -12, 14);
seqSignCheck(-1, -2, -3);