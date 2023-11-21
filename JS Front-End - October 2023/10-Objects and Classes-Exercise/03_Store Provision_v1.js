function solve(stockArr, productsArr) {
  function objectFill(arr, object) {
    for (let i = 0; i < arr.length; i += 2) {
      let key = arr[i];
      let value;
      if (object.hasOwnProperty(key)) {
        value = Number(arr[i + 1]) + object[key];
      } else {
        value = Number(arr[i + 1]);
      }
      object[key] = value;
    }
  }

  let stockObj = {};
  objectFill(stockArr, stockObj);
  objectFill(productsArr, stockObj);

  Object.entries(stockObj).forEach(([key, value]) => {
    console.log(`${key} -> ${value}`);
  });
}

solve(
  ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],
  ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
);
solve(
  ["Salt", "2", "Fanta", "4", "Apple", "14", "Water", "4", "Juice", "5"],
  ["Sugar", "44", "Oil", "12", "Apple", "7", "Tomatoes", "7", "Bananas", "30"]
);
