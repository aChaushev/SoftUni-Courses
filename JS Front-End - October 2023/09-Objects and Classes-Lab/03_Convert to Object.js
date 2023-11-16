function convertToObject(json) {
    let object = JSON.parse(json);
    Object.entries(object).forEach(([key, value]) => {
        console.log(`${key}: ${value}`);
    })
}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');
convertToObject('{"name": "Peter", "age": 35, "town": "Plovdiv"}');