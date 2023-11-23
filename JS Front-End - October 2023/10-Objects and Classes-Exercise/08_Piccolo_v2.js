function solve(input) {
  let cars = [];
  input.forEach((entry) => {
      const [command, car] = entry.split(", ")
    if (command === "IN" && !cars.includes(car)) {
      cars.push(car);
    } else if (command === "OUT" && cars.includes(car)) {
      const carIndex = cars.indexOf(car);
      cars.splice(carIndex, 1);
    }
  });

  if (cars.length === 0) {
    console.log("Parking Lot is Empty");
  } else {
      cars.sort((a, b) => a.localeCompare(b))
      .forEach((car) => console.log(car));
      
  }
}

solve([
  "IN, CA2844AA",
  "IN, CA1234TA",
  "OUT, CA2844AA",
  "IN, CA9999TT",
  "IN, CA2866HI",
  "OUT, CA1234TA",
  "IN, CA2844AA",
  "OUT, CA2866HI",
  "IN, CA9876HH",
  "IN, CA2822UU",
]);

solve(["IN, CA2844AA", "IN, CA1234TA", "OUT, CA2844AA", "OUT, CA1234TA"]);
