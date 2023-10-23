function solve(argument) {
    let result;
    let argumentType = typeof(argument);

    if ( argumentType === "number") {
        result = (Math.PI * Math.pow(argument, 2)).toFixed(2);

    } else {
        result = "We can not calculate the circle area, because we receive a " + argumentType +".";
    }

    console.log(result);
}

solve(5);
solve('name');