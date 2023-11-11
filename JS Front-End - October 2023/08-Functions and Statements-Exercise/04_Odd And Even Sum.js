function oddAndEvenSum(number) {
    const numArr = Array.from(String(number), Number)

    let evenSum = 0;
    let oddSum = 0;

    for (let i = 0; i < numArr.length; i++) {
        if (numArr[i] % 2 === 0) {
            evenSum += numArr[i];
        } else {
            oddSum += numArr[i];
        }
        
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);

}

oddAndEvenSum(1000435);
oddAndEvenSum(3495892137259234);