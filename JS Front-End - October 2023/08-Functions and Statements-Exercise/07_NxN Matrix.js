function nMatrix(number) {
    let row = [];
    for (let i = 0; i < number; i++) {
        for (let i = 0; i < number; i++) {
            row.push(number);
        }
        console.log(row.join(" "));
        row = [];
    }
}

nMatrix(3);
nMatrix(7);