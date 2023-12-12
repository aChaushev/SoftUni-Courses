function pianist(input) {
    let piecesCnt = Number(input.shift());
    let piecesCollection = {}
    let commandParser = {
        'Add': addPiece,
        'Remove': removePiece,
        'ChangeKey': changeKey,
    };

    for (let i = 0; i < piecesCnt; i++) {
        const [ piece, composer, key ] = input.shift().split("|");
        piecesCollection[piece] = { composer, key };  
    }

    for (let inputLine of input) {
        if (inputLine === 'Stop') {
            break;
        }

        let commandTokens = inputLine.split("|");
        let command = commandTokens[0];
        commandParser[command](...commandTokens.slice(1));
        //commandParser[command] -> връща една от трите функции
        // ...commandTokens -> spread оператор за да разчупи по отделни аргументи на функцията
        // slice[1] -> взима всичко от индекс 1 нататък 
    }

    for (const piece in piecesCollection) {
        const { key, composer } = piecesCollection[piece];
        console.log(`${piece} -> Composer: ${composer}, Key: ${key}`)
    }
    
    function addPiece(piece, composer, key) {
        if (piecesCollection.hasOwnProperty(piece)) {
            // проверяваме дали колекцията(мап-а) съдържа такъв елемент
            console.log(`${piece} is already in the collection!`)
        } else {
            piecesCollection[piece] = { composer, key };
            console.log(`${piece} by ${composer} in ${key} added to the collection!`)
        }
    }

    function removePiece(piece) {
        if (piecesCollection.hasOwnProperty(piece)) {
            // delete -> се ползва само за обекти / за масив -> splice
            delete piecesCollection[piece];
            console.log(`Successfully removed ${piece}!`)
        } else {
            
            console.log(`Invalid operation! ${piece} does not exist in the collection.`)
        }
    }

    function changeKey(piece, newKey) {
        if (piecesCollection.hasOwnProperty(piece)) {
            // delete -> се ползва само за обекти / за масив -> splice
            piecesCollection[piece].key = newKey
            console.log(`Changed the key of ${piece} to ${newKey}!`)
        } else {
            
            console.log(`Invalid operation! ${piece} does not exist in the collection.`)
        }
    }
}


pianist([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'  
  ]
  )