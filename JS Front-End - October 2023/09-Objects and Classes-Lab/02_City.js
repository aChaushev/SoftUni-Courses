function createCity(city) {
    Object.entries(city).forEach(([key, value]) => {
        console.log(`${key} -> ${value}`);
    });
}

createCity({
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
}
);