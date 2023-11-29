function solve() {
  const inputText = Array.from(document.querySelector("#text").value.split(" "));
  const inputConvention = document.querySelector("#naming-convention").value;
  const result = document.querySelector("#result");

  if (inputConvention === "Camel Case" || inputConvention === "Pascal Case") {
    const transformedText = inputText.reduce((acc, word, index) => {
      const element = word.toLowerCase();
      const formattedWord = index > 0 ? element.charAt(0).toUpperCase() + element.slice(1) : element;
      return acc + formattedWord;
    }, "");

    result.textContent = inputConvention === "Camel Case" ? transformedText : transformedText.charAt(0).toUpperCase() + transformedText.slice(1);
  } else {
    result.textContent = "Error!";
  }

  // if (inputConvention === "Camel Case") {
  //   let camelCase = "";
  //   for (let i = 0; i < inputText.length; i++) {
  //     let element = inputText[i].toLowerCase();
  //     if (i > 0) {
  //       element = element.charAt(0).toUpperCase() + element.slice(1);
  //     }
  //     camelCase = camelCase.concat(element);
  //   }
  //   result.textContent = camelCase;
    
  // } else if (inputConvention === "Pascal Case") {
  //   let pascalCase = "";
  //   for (let i = 0; i < inputText.length; i++) {
  //     let element = inputText[i].toLowerCase();
  //     element = element.charAt(0).toUpperCase() + element.slice(1);
  //     pascalCase = pascalCase.concat(element);
  //   }
  //   result.textContent = pascalCase;
    
  // } else {
  //   result.textContent = "Error!";
  // }
}

