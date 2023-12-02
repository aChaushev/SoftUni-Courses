function solve() {
  const inputText = Array.from(document.querySelector("#input").value.split("."));
  const result = document.querySelector("#output");
  inputText.pop(); // премахваме последната точка
  
  while (inputText.length > 0) {
    const paragraph = document.createElement("p");
    paragraph.textContent = inputText.splice(0, 3).join(".") + ".";
    // разделяме и взимаме първите 3 елемента на input-a (чрез изрязване) 
    // и ги обединяваме с точка + точка накрая

    result.appendChild(paragraph)
  }
}

