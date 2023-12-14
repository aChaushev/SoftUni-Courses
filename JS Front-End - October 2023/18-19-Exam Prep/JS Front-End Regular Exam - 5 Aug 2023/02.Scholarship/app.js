window.addEventListener("load", solve);

function solve() {

  let applicationState = {
    student: null,
    university: null,
    number: null,
  }
    
  const inputDOMSelectors = {
    student: document.querySelector('#student'),
    university: document.querySelector('#university'),
    number: document.querySelector('#score'),
  }

  const otherDOMSelectors = {
    nextBtn: document.querySelector('#next-btn'),
    previewList: document.querySelector('#preview-list'),
    candidatesList: document.querySelector('#candidates-list'),
  }

  otherDOMSelectors.nextBtn.addEventListener('click', addApplicationHandler)
  
  function addApplicationHandler(event) {
    event.preventDefault();
    const allFieldsHaveValue = Object.values(inputDOMSelectors)
      .every((input) => input.value !== '')
      if (!allFieldsHaveValue){
        return;
    };
    
    const { student, university, number } = inputDOMSelectors;
    const li = createElement('li', otherDOMSelectors.previewList, null, ['application']);
    const article = createElement('article', li);
    createElement('h4', article, student.value);
    createElement('p', article, `University: ${university.value}`);
    createElement('p', article, `Score: ${number.value}`);
    const editBtn = createElement('button', li, 'edit', ['action-btn', 'edit']);
    const applyBtn = createElement('button', li, 'apply', ['action-btn', 'apply']);

    editBtn.addEventListener('click', editApplicationHandler)
    applyBtn.addEventListener('click', applyApplicationHandler)

    for (const key in inputDOMSelectors) {
      applicationState[key] = inputDOMSelectors[key].value;
    }

    Object.values(inputDOMSelectors)
    .forEach((input) => {
      input.value = '';
    })
    otherDOMSelectors.nextBtn.setAttribute('disabled', true);
  }

  function editApplicationHandler(event) {
    otherDOMSelectors.previewList.removeChild(event.currentTarget.parentNode);

    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = applicationState[key];
    }

    otherDOMSelectors.nextBtn.removeAttribute('disabled');
  }

  function applyApplicationHandler(event) {
    const li = event.currentTarget.parentNode;
    li.removeChild(li.querySelector(".edit"))
    li.removeChild(li.querySelector(".apply"))
    otherDOMSelectors.candidatesList.appendChild(li);

    otherDOMSelectors.nextBtn.removeAttribute('disabled');
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
  