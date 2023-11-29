function subtract() {
    const firstNumber = document.querySelector("#firstNumber").value;
    const secondNumber = document.querySelector("#secondNumber").value;
    
    const difference = Number(firstNumber) - Number(secondNumber);
    
    const result = document.querySelector("#result");
    result.textContent = difference;
}