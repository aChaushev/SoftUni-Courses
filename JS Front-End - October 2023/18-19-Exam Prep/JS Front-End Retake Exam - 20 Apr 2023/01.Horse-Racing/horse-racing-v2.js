function solve(input) {
    const horsesList = input.shift().split("|");
    
    let commandLine = input.shift();
    while (commandLine != 'Finish') {
        const commandArr = commandLine.split(' ');
        const command = commandArr[0];
        const firstHorse = commandArr[1];
        const secondHorse = commandArr[2];

        const horsePosition = horsesList.indexOf(firstHorse);
        const secondHorsePosition = horsesList.indexOf(secondHorse);

        switch (command) {
            case 'Retake':
                if (horsePosition < secondHorsePosition) {
                    horsesList[horsePosition] = secondHorse;
                    horsesList[secondHorsePosition] = firstHorse;

                    console.log(`${firstHorse} retakes ${secondHorse}.`);
                }
                break;
            
            case 'Trouble':
                if (horsePosition > 0) {
                    horsesList[horsePosition] = horsesList[horsePosition - 1];
                    horsesList[horsePosition - 1] = firstHorse;

                    console.log(`Trouble for ${firstHorse} - drops one position.`)
                }
                break;
            
            case 'Rage':
                if (horsePosition === horsesList.length - 2) {
                    horsesList[horsesList.length - 2] = horsesList[horsesList.length - 1]
                    horsesList[horsePosition - 1] = firstHorse

                } else if (horsePosition < horsesList.length - 1) {
                    horsesList[horsePosition] = horsesList[horsePosition + 1];
                    horsesList[horsePosition + 1] = horsesList[horsePosition + 2];
                    horsesList[horsePosition + 2] = firstHorse 
                }

                console.log(`${firstHorse} rages 2 positions ahead.`)

                // const rageLength = Math.min(horsesList.length - 1 - horsePosition, 2); 
                // if (horsePosition !== 0) {
                //     horsesList.splice(horsePosition, 1);
                //     horsesList.splice(horsePosition, 1);
                //     console.log(`${horsePosition} rages 2 positions ahead.`)
                // }
                
                break;
            
            case 'Miracle':
                const lastHorse = horsesList.shift();
                horsesList.push(lastHorse);

                console.log(`What a miracle - ${lastHorse} becomes first.`)
                break;
        }

        commandLine = input.shift()
    }

    console.log(horsesList.join('->'));
    console.log(`The winner is: ${horsesList.pop()}`)
}

solve((['Bella|Alexia|Sugar',
    'Retake Alexia Sugar',
    'Rage Bella',
    'Trouble Bella',
    'Finish'])
);

console.log("--------------------------------------------");

solve((['Onyx|Domino|Sugar|Fiona',
    'Trouble Onyx',
    'Retake Onyx Sugar',
    'Rage Domino',
    'Miracle',
    'Finish'])
);

console.log("--------------------------------------------");

solve((['Fancy|Lilly',
    'Retake Lilly Fancy',
    'Trouble Lilly',
    'Trouble Lilly',
    'Finish',
    'Rage Lilly'])
);