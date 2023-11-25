function calc() {
    
    const firstElement = document.querySelector("#num1").value;
    const secondElement = document.querySelector("#num2").value;

    const result = Number(firstElement) + Number(secondElement);
    
    document.querySelector("#sum").value = result;
}
