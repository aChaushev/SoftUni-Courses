function motoGPRace(input) {
    const racersCnt = Number(input.shift());
    let ridersList = {};
    // !!!max Fuel = 100%
    let commandParser = {
        StopForFuel: stopForFuel,
        Overtaking: overtaking,
        EngineFail: engineFail,
    }

    for (let i = 0; i < racersCnt; i++) {
        const [rider, fuelCapacity, position] = input.shift().split('|');
        ridersList[rider] = {
            fuelCapacity: Number(fuelCapacity),
            position: Number(position)
          };
    }

    for (const inputLine of input) {
        if (inputLine === 'Finish') {
            break;
        }
        let commandTokens = inputLine.split(" - ")
        let command = commandTokens.shift();
        commandParser[command](...commandTokens.slice(0));
    }

    Object.keys(ridersList).forEach((rider) => {
        const {_fuelCapacity, position} = ridersList[rider];
        console.log(rider);
        console.log(`Final position: ${position}`);
    })

    function stopForFuel(rider, minFuel, changedPosition) {
        minFuel = Number(minFuel);
        changedPosition = Number(changedPosition);
            if (ridersList[rider].fuelCapacity < minFuel) {
                ridersList[rider].fuelCapacity = 100;
                ridersList[rider].position = changedPosition;
                console.log(`${rider} stopped to refuel but lost his position, now he is ${changedPosition}.`)
            } else {
                console.log(`${rider} does not need to stop for fuel!`)
            }   
    }

    function overtaking(rider1, rider2) {
        if (ridersList[rider1].position < ridersList[rider2].position) {
            [ridersList[rider1].position, ridersList[rider2].position]
                = [ridersList[rider2].position, ridersList[rider1].position]
                console.log(`${rider1} overtook ${rider2}!`)
            }
            //[arr[0], arr[1]] = [arr[1], arr[0]];
            // [ridersList[rider1], ridersList[rider2]] = [ridersList[rider2], ridersList[rider1]];
    }

    function engineFail(rider, lapsLeft) {
            // let riderIndex = ridersList.indexOf(rider);
            // ridersList.splice(riderIndex, 1)
            delete ridersList[rider]
            console.log(`${rider} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`)    
    }
}

motoGPRace((["3",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|2",
    "Jorge Lorenzo|80|3",
    "StopForFuel - Valentino Rossi - 50 - 1",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"])
);

console.log("------------------------------")

motoGPRace((["4",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|3",
    "Jorge Lorenzo|80|4",
    "Johann Zarco|80|2",
    "StopForFuel - Johann Zarco - 90 - 5",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"])
);
