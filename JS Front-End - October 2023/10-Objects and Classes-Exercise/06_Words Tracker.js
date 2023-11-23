function solve(input) {
    // const [firstString, ...words] = input;
    let firstString = input.shift().split(" ");

    let wordsToFind = firstString.reduce((acc, curr) => {
        acc[curr] = 0;
        return acc;
    }, {} )

    input.forEach(word => {
        if (wordsToFind.hasOwnProperty(word)) {
            wordsToFind[word]++;
        }

    });
    
    Object.entries(wordsToFind)
        .sort((a, b) => Number(b[1]) - Number(a[1]))
        .forEach(([key, value]) => {
        console.log(`${key} - ${value}`);
    }) 
}

solve([
    'this sentence',
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
]);

solve([
    'is the', 
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
    );
