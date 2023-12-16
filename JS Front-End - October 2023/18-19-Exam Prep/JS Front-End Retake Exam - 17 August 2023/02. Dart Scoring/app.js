window.addEventListener("load", solve);

function solve() {
  const storyScore = {
    player: null,
    score: null,
    round: null,
  }

    
  const inputDOMSelectors = {
    player: document.querySelector('#player'),
    score: document.querySelector('#score'),
    round: document.querySelector('#round'),
  }

  const otherDOMSelectors = {
    addBtn: document.querySelector('#add-btn'),
    sureList: document.querySelector('#sure-list'),
    scoreboardList: document.querySelector('#scoreboard-list'),
    clearBtn: document.querySelector(['.btn', '.clear'])
  }

  otherDOMSelectors.addBtn.addEventListener('click', addScoringHandler)
  otherDOMSelectors.clearBtn.addEventListener('click', clearScoringHandler)

  function addScoringHandler() {
    const allFieldsHaveValue = Object.values(inputDOMSelectors)
      .every((input) => input.value !== "");
    if (!allFieldsHaveValue) {
      return;
    }
  
    const { player, score, round } = inputDOMSelectors;
    const li = createElement('li', otherDOMSelectors.sureList, null, ['dart-item']);
    const article = createElement('article', li);
    createElement('p', article, player.value);
    createElement('p', article, `Score: ${score.value}`);
    createElement('p', article, `Round: ${round.value}`);
    const editBtn = createElement('button', li, 'edit', ['btn', 'edit']);
    const okBtn = createElement('button', li, 'ok', ['btn', 'ok']);

    editBtn.addEventListener('click', editScoringHandler);
    okBtn.addEventListener('click', okScoringHandler);

    for (const key in inputDOMSelectors) {
      storyScore[key] = inputDOMSelectors[key].value;
    }
    

    Object.values(inputDOMSelectors).forEach((element) => {
      element.value = ''
    })
    otherDOMSelectors.addBtn.setAttribute('disabled', true);
  }

  function editScoringHandler(event) {
    const list = event.currentTarget.parentNode;
    list.remove()
    for (const key in storyScore) {
      inputDOMSelectors[key].value = storyScore[key];
    }
    otherDOMSelectors.addBtn.removeAttribute('disabled')
  }

  function okScoringHandler(event) {
    const li = event.currentTarget.parentNode;
    li.removeChild(li.querySelector('.edit'))
    li.removeChild(li.querySelector('.ok'))
    otherDOMSelectors.scoreboardList.appendChild(li);

    otherDOMSelectors.addBtn.removeAttribute('disabled')
  }

  function clearScoringHandler() {
    window.location.reload();
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
  