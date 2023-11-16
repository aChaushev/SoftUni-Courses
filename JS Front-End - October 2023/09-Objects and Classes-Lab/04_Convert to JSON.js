function convertToJSON(name, lastName, hairColor) {
    let object = {
        name,
        lastName,
        hairColor,
    }
    let json = JSON.stringify(object);
    console.log(json);
}

convertToJSON('George', 'Jones', 'Brown');
convertToJSON('Peter', 'Smith', 'Blond');