function solve(input) {
    const horsesArr = input.shift().split('|');

    let commandLine = input.shift().split(" ");
    while (commandLine !== "Finish" && input.length > 0) {
        const command = commandLine[0];
        let horse = commandLine[1];


        if (command === "Retake") {
            const horse2 = commandLine[2];
            const horse1Index = Number(horsesArr.indexOf(horse));
            const horse2Index = Number(horsesArr.indexOf(horse2));
            if (horse1Index < horse2Index) {
                [horsesArr[horse1Index], horsesArr[horse2Index]] = [horsesArr[horse2Index], horsesArr[horse1Index]];
                console.log(`${horse} retakes ${horse2}.`);
                // console.log(horsesArr)
            }
        
        } else if (command === "Trouble") {
            if (horsesArr.indexOf(horse) > 0) {
                const horseIndex = Number(horsesArr.indexOf(horse));
                [horsesArr[horseIndex], horsesArr[horseIndex - 1]] = [horsesArr[horseIndex - 1], horsesArr[horseIndex]];
                console.log(`Trouble for ${horse} - drops one position.`)
                // console.log(horsesArr)
            }

        } else if (command === "Rage") {
            let horseIndex = Number(horsesArr.indexOf(horse));
            if (horseIndex === horsesArr.length - 2) {
                [horsesArr[horseIndex], horsesArr[horseIndex + 1]] = [horsesArr[horseIndex + 1], horsesArr[horseIndex]];
            } else if (horseIndex < horsesArr.length - 2) {
                [horsesArr[horseIndex], horsesArr[horseIndex + 1]] = [horsesArr[horseIndex + 1], horsesArr[horseIndex]];
                horseIndex = Number(horsesArr.indexOf(horse));
                [horsesArr[horseIndex], horsesArr[horseIndex + 1]] = [horsesArr[horseIndex + 1], horsesArr[horseIndex]];   
            }
            console.log(`${horse} rages 2 positions ahead.`)
            // console.log(horsesArr)
            
        } else if (command === "Miracle") {
            const elementsToDrop = horsesArr.slice(1); //take elements to drop position
            horsesArr.splice(1, horsesArr.length - 1); // remove these elements
            horsesArr.unshift(...elementsToDrop); // add elements to drop
            console.log(`What a miracle - ${horsesArr[horsesArr.length - 1]} becomes first.`)
            // console.log(horsesArr)
        }

        commandLine = input.shift().split(" ");
    }
    console.log(horsesArr.join("->"))
    console.log(`The winner is: ${horsesArr[horsesArr.length - 1]}`)
}


solve((['Bella|Alexia|Sugar',
    'Retake Alexia Sugar',
    'Rage Bella',
    'Trouble Bella',
    'Finish'])
);

console.log("-----------------------------------")

solve((['Onyx|Domino|Sugar|Fiona',
    'Trouble Onyx',
    'Retake Onyx Sugar',
    'Rage Domino',
    'Miracle',
    'Finish'])
);

console.log("-----------------------------------")

solve((['Fancy|Lilly',
    'Retake Lilly Fancy',
    'Trouble Lilly',
    'Trouble Lilly',
    'Finish',
    'Rage Lilly'])
);