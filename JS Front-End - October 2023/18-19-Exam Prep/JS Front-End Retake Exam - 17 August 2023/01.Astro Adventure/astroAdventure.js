function solve(input) {
    const astronautsCount = Number(input.shift());
    let astronautsCollection = {};
    let commandParser = {
        Explore: exploreHandler,
        Refuel: refuelHandler,
        Breathe: breatheHandler, 
    }

    for (let i = 0; i < astronautsCount; i++) {
        let [name, oxygenLevel, energyReserves] = input.shift().split(" ");
        energyReserves = Number(energyReserves)
        oxygenLevel = Number(oxygenLevel)
        astronautsCollection[name] = { oxygenLevel, energyReserves };
        
    }

    for (const inputLine of input) {
        if (inputLine === "End") {
            break;
        }

        let commandToken = inputLine.split(" - ")
        let command = commandToken.shift();
        commandParser[command](...commandToken.slice(0));
        //ex. commandParser[command] = exploreHandler(name, energyNeeded) -> function
        //ex. (...commandToken.slice(0)) = (name, energyNeeded)
        
    }


    function exploreHandler(name, energyNeeded) {
        energyNeeded = Number(energyNeeded);
        if (astronautsCollection[name].energyReserves >= energyNeeded) {
            astronautsCollection[name].energyReserves -= energyNeeded;
            console.log(`${name} has successfully explored a new area and now has ${astronautsCollection[name].energyReserves} energy!`)
        } else {
            console.log(`${name} does not have enough energy to explore!`)
        }
    }

    function refuelHandler(name, amount) {
        amount = Number(amount);
        
        if (astronautsCollection[name].energyReserves + amount > 200) {
            amount = 200 - astronautsCollection[name].energyReserves;
            astronautsCollection[name].energyReserves = 200;
        } else {
            astronautsCollection[name].energyReserves += amount;
        }
        console.log(`${name} refueled their energy by ${amount}!`)

    }

    function breatheHandler(name, amount) {
        amount = Number(amount);
    
        if (astronautsCollection[name].oxygenLevel + amount > 100) {
            amount = 100 - astronautsCollection[name].oxygenLevel;
            astronautsCollection[name].oxygenLevel = 100;
        } else {
            astronautsCollection[name].oxygenLevel += amount;
        }
        console.log(`${name} took a breath and recovered ${amount} oxygen!`)
    }

    Object.entries(astronautsCollection).forEach(([name, oxygenLevel, energyReserves]) => {
        console.log(`Astronaut: ${name}, Oxygen: ${astronautsCollection[name].oxygenLevel}, Energy: ${astronautsCollection[name].energyReserves}`)
    })
}

solve(['3',
    'John 50 120',
    'Kate 80 180',
    'Rob 70 150',
    'Explore - John - 50',
    'Refuel - Kate - 30',
    'Breathe - Rob - 20',
    'End']
);

console.log("------------------------------------------")

solve(['4',
    'Alice 60 100',
    'Bob 40 80',
    'Charlie 70 150',
    'Dave 80 180',
    'Explore - Bob - 60',
    'Refuel - Alice - 30',
    'Breathe - Charlie - 50',
    'Refuel - Dave - 40',
    'Explore - Bob - 40',
    'Breathe - Charlie - 30',
    'Explore - Alice - 40',
    'End']
);