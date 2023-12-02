function solve() {
  const [generateTextarea, buyTextarea] = Array.from(document.querySelectorAll('textarea'));
  const [generateBtn, buyBtn] = Array.from(document.querySelectorAll('button'));
  const tbody = document.querySelector(".table > tbody");

  generateBtn.addEventListener('click', generateHandler);
  buyBtn.addEventListener('click', buyHandler);

  function generateHandler() {
    const data = JSON.parse(generateTextarea.value);
    for (const {img, name, price, decFactor} of data) {
      const tableRow = createElement('tr', '', tbody);
      const firstColumnTd = createElement('td', '', tableRow);
      createElement('img', '', firstColumnTd, '', '', { src: img });
      const secondColumnTd = createElement('td', '', tableRow)
      createElement('p', name, secondColumnTd);
      const thirdColumnTd = createElement('td', '', tableRow)
      createElement('p', price, thirdColumnTd);
      const fourthColumnTd = createElement('td', '', tableRow)
      createElement('p', decFactor, fourthColumnTd);
      const fifthColumnTd = createElement('td', '', tableRow);
      createElement('input', '',fifthColumnTd, "", "", { type: 'checkbox'})
    }
  }

  function buyHandler() {
    const allCheckedInputs = Array.from(document.querySelectorAll("tbody tr input:checked"));
    // input:checked -> selector, който взима всички checked checkboxes
    let boughtItems = [];
    let totalPrice = 0;
    let totalDecFactor = 0;

    for (const input of allCheckedInputs) {
      const tableRow = input.parentElement.parentElement //grandparent на input
      const [_firstColumn, secondColumn, thirdColumn, fourthColumn] = Array.from(tableRow.children); //връща всички td // може и Array.from(tableRow.querySelector....);
      // [...] -> връща HTML Collection, която не може да се деструкторира по този начин за това резултата е облчен в Array.from
      // _firstColumn e с долна черта, защото не я ползва, но я декларирам, по конвенция трябва да е с долна черта
      let item = secondColumn.children[0].textContent // children[0] защото искам <p> от <td>
      // може и let item = tableRow.document.querySelector('td p:nth-child(1)').textContent
      boughtItems.push(item);
      let currentPrice = Number(thirdColumn.children[0].textContent);
      totalPrice += currentPrice;
      let currentDecFactor = Number(fourthColumn.children[0].textContent);
      totalDecFactor += currentDecFactor;
    }

      buyTextarea.value += `Bought furniture: ${boughtItems.join(', ')}\n`
      buyTextarea.value += `Total price: ${totalPrice.toFixed(2)}\n`
      buyTextarea.value += `Average decoration factor: ${totalDecFactor / allCheckedInputs.length}`

  }

  // type = string
  // content = string (text content)
  // id = string
  // classes = array of string
  // attributes= object
  //Factory Function for DOM Elements
  function createElement(type, content, parentNode, id, classes, attributes) {
    if (type == "" || type == null) {
      throw new Error('Type is not defined!');
    }
    const htmlElement = document.createElement(type);


    if (content && type !== "input") {
      htmlElement.textContent = content;
    }
    
    //textarea?!
    //innerHTML

    if (content && type === "input") {
      htmlElement.value = content;
    }

    if (id) {
      htmlElement.id = id;
    }

    // ['list, 'item']
    if (classes) {
      htmlElement.classList.add(...classes);
    }

    // { src: 'link to image', href: 'link to site', type: 'checkbox' ...}
    if (attributes) {
      for (const key in attributes) {
        htmlElement.setAttribute(key, attributes[key]);
      }
    }

    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }

    return htmlElement;
  }

  
}
