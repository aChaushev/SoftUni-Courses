window.addEventListener('load', solve);

function solve() {

    // const storyState = {
    //     genre: null,
    //     name: null,
    //     author: null,
    //     date: null,
    // }
    
    const inputDOMSelectors = {
        genre: document.querySelector("#genre"),
        name: document.querySelector("#name"),
        author: document.querySelector("#author"),
        date: document.querySelector("#date"),
    }
    
    const otherDOMSelectors =  {
        addBtn: document.querySelector("#add-btn"),
        collectionOfSongs: document.querySelector(".all-hits-container"),
        likes: document.querySelector(".likes > p"),
        savedSongs: document.querySelector(".saved-container"),  
    }
    
    otherDOMSelectors.addBtn.addEventListener('click', addSongHandler)

    function addSongHandler(event) {
        event.preventDefault();
        const allFieldsHaveValue = Object.values(inputDOMSelectors)
        .every((input) => input.value !== '')
        
        if (!allFieldsHaveValue) {
            console.log("EMPTY FIELD")
            return;
        }

        const { genre, name, author, date } = inputDOMSelectors;
        const div = createElement('div', otherDOMSelectors.collectionOfSongs, null, ["hits-info"])
        createElement('img', div, null, null, null, {src: './static/img/img.png'});
        createElement('h2', div, `Genre: ${genre.value}`);
        createElement('h2', div, `Name: ${name.value}`);
        createElement('h2', div, `Author: ${author.value}`);
        createElement('h3', div, `Date: ${date.value}`);
        const saveBtn = createElement('button', div, 'Save song', ['save-btn']);
        const likeBtn = createElement('button', div, 'Like song', ['like-btn']);
        const deleteBtn = createElement('button', div, 'Delete', ['delete-btn']);

        likeBtn.addEventListener('click', addLikeHandler);
        saveBtn.addEventListener('click', saveSongHandler);
        deleteBtn.addEventListener('click', deleteSongHandler)

        // for (const key in inputDOMSelectors) {
        //     storyState[key] = inputDOMSelectors[key].value;
        // }

        clearAllInputs(inputDOMSelectors);


        function addLikeHandler(event) {
            let likesCnt = Number(otherDOMSelectors.likes.textContent.split(":")[1]);
            // правим масив от съдържанието и вземаме втория елемент като число
            otherDOMSelectors.likes.textContent = `Total Likes: ${likesCnt + 1}`;
            event.currentTarget.setAttribute('disabled', true)
            // ----------CHECK FOR BACKGROUND COLOR SOLUTION
        }
        
        function saveSongHandler() {
            otherDOMSelectors.savedSongs.appendChild(div)
            div.removeChild(saveBtn);
            div.removeChild(likeBtn);
        }

        function deleteSongHandler() {
            div.parentNode.removeChild(div)
        }

    }
 

    function clearAllInputs(inputSelectors) {
        Object.values(inputSelectors)
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