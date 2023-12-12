window.addEventListener("load", solve);
// window.onload -> когато се заредят всички елементи в browser-a, тогава ще се стартира function solve()


// Always use array from to transform a collection -> querySelectorAll, children
function solve() {
  const storyState = {
    firstName: null,
    lastName: null,
    age: null,
    title: null,
    genre: null,
    story: null,
  }
  const inputDOMSelectors = {
    firstName: document.querySelector("#first-name"),
    lastName: document.querySelector("#last-name"),
    age: document.querySelector("#age"),
    title: document.querySelector("#story-title"),
    genre: document.querySelector("#genre"),
    story: document.querySelector("#story"),
  }

  const otherDOMSelectors =  {
    publishBtn: document.querySelector("#form-btn"),
    previewList: document.querySelector("#preview-list"),
    mainContainer: document.querySelector("#main"),
  }
  
  otherDOMSelectors.publishBtn.addEventListener('click', publishStoryHandler);
  
  function publishStoryHandler() {
    const allFieldsHaveValue = Object.values(inputDOMSelectors)
    .every((input) => input.value !== '') //true/false
    // Object.values(inputDOMSelectors) -> връща масив

    if (!allFieldsHaveValue){
      // console.log('EMPTY FIELD');
      return;
    };

    // CREATE HTML ELEMENTS FOR PREVIEW_CONTAINER
    const { firstName, lastName, age, title, genre, story} = inputDOMSelectors;
    const li = createElement('li', otherDOMSelectors.previewList, null, ["story-info"]);
    // ако няма други елементи за деклариране, деклрарираме само до последния такъв
    const article = createElement('article', li);
    createElement('h4', article, `Name: ${firstName.value} ${lastName.value}`);
    createElement('p', article, `Age: ${age.value}`);
    createElement('p', article, `Title: ${title.value}`);
    createElement('p', article, `Genre: ${genre.value}`);
    createElement('p', article, story.value);
    const saveBtn = createElement('button', li, 'Save Story', ['save-btn']);
    const editBtn = createElement('button', li, 'Edit Story', ['edit-btn']);
    const deleteBtn = createElement('button', li, 'Delete Story', ['delete-btn']);

    editBtn.addEventListener('click', editStoryHandler);
    deleteBtn.addEventListener('click', deleteStoryHandler);
    saveBtn.addEventListener('click', saveStoryHandler);

    //save all created elements in backup object before clearing
    for (const key in inputDOMSelectors) {
      storyState[key] = inputDOMSelectors[key].value;
    }

    // Clear Input
    clearAllInputs();
    // Disable button
    otherDOMSelectors.publishBtn.setAttribute('disabled', true);
  }
  

  function editStoryHandler() {
    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = storyState[key];
    }
   // Enable button
    otherDOMSelectors.publishBtn.removeAttribute('disabled');
    //Clear PreviewList(Container)
    otherDOMSelectors.previewList.innerHTML = '';
    //Create new Preview Heading in PreviewList
    createElement('h3', otherDOMSelectors.previewList, 'Preview');
  }

  function deleteStoryHandler(event) {
    const liItem = event.currentTarget.parentNode;// връща съдържанието PreviewList(Container)
    liItem.remove();
    otherDOMSelectors.publishBtn.removeAttribute('disabled')
  }
  // или
  // function deleteStoryHandler() {
  //   const liItem = this.parentNode
  //   ...........
  // }

  function saveStoryHandler() {
    otherDOMSelectors.mainContainer.innerHTML = "";
    createElement('h1', otherDOMSelectors.mainContainer, "Your scary story is saved!")
  }

  function clearAllInputs() {
    Object.values(inputDOMSelectors)
      .forEach((input) => {
        input.value = '';
    })
  }


function createElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
  const htmlElement = document.createElement(type);

  if (content && useInnerHtml) {
    htmlElement.innerHtml = content;
  } else {
    if (content && type !== 'input') {
      htmlElement.textContent = content;
    }

    if (content && type === 'input') {
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


