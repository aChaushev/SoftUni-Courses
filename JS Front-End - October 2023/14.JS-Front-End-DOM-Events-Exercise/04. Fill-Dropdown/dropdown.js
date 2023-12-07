function addItem() {
    const inputText = document.querySelector("#newItemText");
    const inputValue = document.querySelector("#newItemValue");
    
   
    const option = createOption(inputText, inputValue);

    const select = document.querySelector("#menu");
    select.appendChild(option);
    clearInputFields(inputText,inputValue);

    function createOption(textIn, valueIn) {
        const option = document.createElement("option")
        option.textContent = textIn.value;
        option.setAttribute("value", valueIn.value);

        return option;
    }
    
    function clearInputFields(...inputs) {
        inputs.forEach(input => {
            input.value = "";
        })
    }
    // или
    // function clearInputFields() {
    //     const inputs = Array.from(document.querySelectorAll("input"));
    //     inputs.forEach(input => {
    //         input.value = "";
    //     })
    // }

}