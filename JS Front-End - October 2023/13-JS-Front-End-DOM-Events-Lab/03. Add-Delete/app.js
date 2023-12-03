function addItem() {
    const input = document.querySelector("#newItemText").value;

    const newElement = document.createElement("li");
    newElement.textContent = input;

    const addDeleteButton = document.createElement("a");
    addDeleteButton.href = "#";
    addDeleteButton.textContent = "[Delete]";
    newElement.appendChild(addDeleteButton);

    addDeleteButton.addEventListener("click", deleteItem)

    function deleteItem() {
        newElement.remove();
    }

    document.querySelector("#items").appendChild(newElement);
}