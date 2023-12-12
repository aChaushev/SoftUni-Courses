function solve(input) {
    let groceriesList = input.shift().split("!");
    let commandParser = {
        'Urgent': addItemAtStart,
        'Unnecessary': removeItemByName,
        'Correct': changeItemName,
        'Rearrange': rearrangeItemPosition,
    }
    
    for (const commandLine of input) {
        if (commandLine === 'Go Shopping!') {
            break;
        }
        let commandTokens = commandLine.split(" ");
        let command = commandTokens[0];
        commandParser[command](...commandTokens.slice(1));
        
    }

    console.log(groceriesList.join(", "))

    function addItemAtStart(item) {
        if (!groceriesList.includes(item)) {
            groceriesList.unshift(item);
        }

    }
    function removeItemByName(item) {
        if (groceriesList.includes(item)) { 
            const itemIndex = groceriesList.indexOf(item);
            groceriesList.splice(itemIndex, 1);
        }
    }
    function changeItemName(item, newItem) {
        if (groceriesList.includes(item)) {
            const itemIndex = groceriesList.indexOf(item);
            groceriesList.splice(itemIndex, 1, newItem);
            
        }
    }
    function rearrangeItemPosition(item) {
        if (groceriesList.includes(item)) {
            const itemIndex = groceriesList.indexOf(item);
            groceriesList.splice(itemIndex, 1);
            groceriesList.push(item);
        }

    }

}


solve((["Tomatoes!Potatoes!Bread",
"Unnecessary Milk",
"Urgent Tomatoes",
"Go Shopping!"])
)

solve((["Milk!Pepper!Salt!Water!Banana",
"Urgent Salt",
"Unnecessary Grapes",
"Correct Pepper Onion",
"Rearrange Grapes",
"Correct Tomatoes Potatoes",
"Go Shopping!"])
)

