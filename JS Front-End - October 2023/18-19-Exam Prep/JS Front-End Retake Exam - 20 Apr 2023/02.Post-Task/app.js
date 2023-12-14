window.addEventListener("load", solve);

function solve() {

    const inputDOMElements = {
        titleElement: document.querySelector('#task-title'),
        categoryElement: document.querySelector('#task-category'),
        contentElement: document.querySelector('#task-content'),
     }
 
     const otherDOMElements = {
         publishBtn: document.querySelector('#publish-btn'),
         taskReviewListElement: document.querySelector('#review-list'),
         uploadedTaskElement: document.querySelector('#published-list'),
     }
 
     otherDOMElements.publishBtn.addEventListener('click', publishTaskHandler)
 
     function publishTaskHandler(event) {
         event.preventDefault();
         const title = inputDOMElements.titleElement.value;
         const category = inputDOMElements.categoryElement.value;
         const content = inputDOMElements.contentElement.value;
         if (!title || !category || !content) {
             return;
         }
 
         const li = createElement('li', otherDOMElements.taskReviewListElement, null, ['rpost'])
         const article = createElement('article', li)
         createElement('h4', article, title)
         createElement('p', article, `Category: ${category}`)
         createElement('p', article, `Content: ${content}`)

         const editBtnElement = createElement('button', li, 'Edit', ['action-btn', 'edit']);
         const postBtnElement = createElement('button', li, 'Post', ['action-btn', 'post']);
 
         inputDOMElements.titleElement.value = ''
         inputDOMElements.categoryElement.value = ''
         inputDOMElements.contentElement.value = ''
  
         editBtnElement.addEventListener('click', (e) => {
             inputDOMElements.titleElement.value = title;
             inputDOMElements.categoryElement.value = category;
             inputDOMElements.contentElement.value = content;
             li.remove()
         })

         postBtnElement.addEventListener('click', () => {
            editBtnElement.remove()
             postBtnElement.remove()
             
             otherDOMElements.uploadedTaskElement.appendChild(li);
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