window.addEventListener("load", solve);

function solve() {

    let applicationState = {
        expense: null,
        amount: null,
        date: null,
      }

    const inputDOMSelectors = {
        expense: document.querySelector("#expense"),
        amount: document.querySelector("#amount"),
        date: document.querySelector("#date"),    
    }

    const otherDOMSelectors =  {
        addBtn: document.querySelector("#add-btn"),
        previewContainer: document.querySelector("#preview-list"),
        expensesContainer: document.querySelector("#expenses-list"),
        deleteBtn: document.querySelector('.delete')
    }

    otherDOMSelectors.addBtn.addEventListener('click', addExpenseHandler)
    otherDOMSelectors.deleteBtn.addEventListener('click', (e) => { window.location.reload() })
    

    function addExpenseHandler(event) {
        event.preventDefault();

        const allFieldsHaveValue = Object.values(inputDOMSelectors)
        .every((input) => input.value !== '')
        
        if (!allFieldsHaveValue) {
            console.log("EMPTY FIELD")
            return;
        }

        const { expense, amount, date } = inputDOMSelectors;
        const li = createElement('li', otherDOMSelectors.previewContainer, null, ['expense-item']);
        const article = createElement('article', li);
        createElement('p', article, `Type: ${expense.value}`);
        createElement('p', article, `Amount: ${amount.value}$`);
        createElement('p', article, `Date: ${date.value}`);
        const buttonsContainer = createElement('div', li, null, ['buttons'])
        const editBtn = createElement('button', buttonsContainer, 'edit', ['btn', 'edit'])
        const okBtn = createElement('button', buttonsContainer, 'ok', ['btn', 'ok'])
        
        for (const key in inputDOMSelectors) {
            applicationState[key] = inputDOMSelectors[key].value;
          }

        otherDOMSelectors.addBtn.setAttribute('disabled', true)
        clearAllInputs(inputDOMSelectors);
        

        editBtn.addEventListener('click', (e) => {
            for (const key in inputDOMSelectors) {
                inputDOMSelectors[key].value = applicationState[key];
              }

            li.remove();

            otherDOMSelectors.addBtn.removeAttribute('disabled')
        })

        okBtn.addEventListener('click', (event) => {
        const list = event.currentTarget.parentNode.parentNode;
        list.removeChild(list.querySelector(".buttons"))
    
        otherDOMSelectors.expensesContainer.appendChild(li);

        })
    }


function clearAllInputs(inputSelectors) {
    Object.values(inputSelectors)
      .forEach((input) => {
        input.value = '';
    })
}

    function createElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
        if (type == "" || type == null) {
          throw new Error("Type is not defined!");
        }
      
        const htmlElement = document.createElement(type);
      
        if (content && useInnerHtml) {
          htmlElement.innerHtml = content;
        } else {
          if (content && type !== "input") {
            htmlElement.textContent = content;
          }
      
          if (content && type === "input") {
            htmlElement.value = content;
          }
        }
      
        if (classes && classes.length > 0) {
          htmlElement.classList.add(...classes);
        }
      
        if (id) {
          htmlElement.id = id;
        }
      
        // {src: 'link', href: 'http'}
        if (attributes) {
          for (const key in attributes) {
            // htmlElement[key] = attributes[key];
            htmlElement.setAttribute(key, attributes[key]);
          }
        }
      
        if (parentNode) {
          parentNode.appendChild(htmlElement);
        }
      
        return htmlElement;
      }
}