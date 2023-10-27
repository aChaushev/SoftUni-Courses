function solve(fruitType, weightInGram, priceInKg) {
    let weightInKg = weightInGram / 1000;
    let totalPrice = weightInKg * priceInKg;
    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruitType}.`)
}

solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);