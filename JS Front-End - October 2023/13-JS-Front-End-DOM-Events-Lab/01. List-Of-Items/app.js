function addItem() {
    const newValue = document.querySelector("#newItemText").value;
    const newItem = document.createElement("li");
    newItem.textContent = newValue;

    document.querySelector('#items').appendChild(newItem);
}