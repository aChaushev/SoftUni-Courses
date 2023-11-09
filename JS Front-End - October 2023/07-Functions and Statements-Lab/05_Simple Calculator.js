function calculate(num1, num2, operator) {
    
  if (operator == "multiply") {
    return num1 * num2;
  }
  if (operator == "divide") {
    return num1 / num2;
  }
  if (operator == "add") {
    return num1 + num2;
  }
  if (operator == "subtract") {
    return num1 - num2;
  }
}

const result = calculate(5, 5, "multiply");
console.log(result);
