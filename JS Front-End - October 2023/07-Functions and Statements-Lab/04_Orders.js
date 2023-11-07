function productOrder(order, count) {
    const products = {
        coffee: 1.50,
        water: 1.00,
        coke: 1.40,
        snacks: 2.00,
    };
    
    const product = products[order];
    const totalPrice = (product * count).toFixed(2);

    console.log(totalPrice);
}

productOrder("water", 5);
productOrder("coffee", 2);