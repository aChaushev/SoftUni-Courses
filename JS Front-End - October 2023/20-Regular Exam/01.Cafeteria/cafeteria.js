function solve(input) {
    const baristasCnt = input.shift();
    const baristasList = {};

    let commandParser = {
        'Prepare': prepareHandler,
        'Change Shift': changeShiftHandler,
        'Learn': learnHandler,
    };

    for (let index = 0; index < baristasCnt; index++) {
        const [name, shift, coffeeTypes] = input.shift().split(' ');

        baristasList[name] = {
            shift: shift,
            coffeeType: coffeeTypes.split(','),
        };
    }

    for (const inputLine of input) {
        if (inputLine === 'Closed') {
            break;
        }

        let commandTokens = inputLine.split(" / ");
        let command = commandTokens[0];
        commandParser[command](...commandTokens.slice(1));
      
    }

    function prepareHandler(name, shift, coffeeTypePrep) {

            if (!baristasList.hasOwnProperty(name)) {
                return;
            }

            if (baristasList[name].shift === shift && baristasList[name].coffeeType.includes(coffeeTypePrep)) {
                console.log(`${name} has prepared a ${coffeeTypePrep} for you!`);
            } else {
                console.log(`${name} is not available to prepare a ${coffeeTypePrep}.`);
            };
        }
    
    function changeShiftHandler(name, newShift) {
        if (!baristasList.hasOwnProperty(name)) {
            return;
        }
            baristasList[name].shift = newShift;
            console.log(`${name} has updated his shift to: ${newShift}`);
        }

    function learnHandler( name, newCoffeeType) {
        if (!baristasList.hasOwnProperty(name)) {
            return;
        }
        if (baristasList[name].coffeeType.includes(newCoffeeType)) {
            console.log(`${name} knows how to make ${newCoffeeType}.`);
        } else {
            baristasList[name].coffeeType.push(newCoffeeType);
            console.log(`${name} has learned a new coffee type: ${newCoffeeType}.`);
        }
    }

    Object.keys(baristasList).forEach(name => {
        const { shift, coffeeType } = baristasList[name];
        console.log(`Barista: ${name}, Shift: ${shift}, Drinks: ${coffeeType.join(', ')}`);
    });

}
    
solve([
    '3',
    'Alice day Espresso,Cappuccino',
    'Bob night Latte,Mocha',
    'Carol day Americano,Mocha',
    'Prepare / Alice / day / Espresso',
    'Change Shift / Bob / night',
    'Learn / Carol / Latte',
    'Learn / Bob / Latte',
    'Prepare / Bob / night / Latte',
    'Closed']
);

console.log("-----------------------------------");

    solve([
        '4',
        'Alice day Espresso,Cappuccino',
        'Bob night Latte,Mocha',
        'Carol day Americano,Mocha',
        'David night Espresso',
        'Prepare / Alice / day / Espresso',
        'Change Shift / Bob / day',
        'Learn / Carol / Latte',
        'Prepare / Bob / night / Latte',
        'Learn / David / Cappuccino',
        'Prepare / Carol / day / Cappuccino',
        'Change Shift / Alice / night',
        'Learn / Bob / Mocha',
        'Prepare / David / night / Espresso',
        'Closed']
    );
