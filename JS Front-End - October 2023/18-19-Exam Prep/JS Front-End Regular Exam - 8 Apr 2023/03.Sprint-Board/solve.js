
function attachEvents() {

    const titleInput = document.querySelector('#title');
    const descriptionInput = document.querySelector('#description');
    const loadBoardBtn = document.querySelector('#load-board-btn');
    const addTaskBtn = document.querySelector('#create-task-btn');

    const toDoContainer = document.querySelector('#todo-section .task-list');
    const inProgressContainer = document.querySelector('#in-progress-section .task-list');
    const codeReviewContainer = document.querySelector('#code-review-section .task-list');
    const doneContainer = document.querySelector('#done-section .task-list');
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/'

    loadBoardBtn.addEventListener('click', loadDataHandler)
    addTaskBtn.addEventListener('click', addTaskHandler)

    const statusContainer = {
        'ToDo': toDoContainer,
        'In Progress': inProgressContainer,
        'Code Review': codeReviewContainer,
        'Done': doneContainer,
    }

    const statusButtonContent = {
        'ToDo': 'Move to In Progress',
        'In Progress': 'Move to Code Review',
        'Code Review': 'Move to Done',
        'Done': 'Close',
    }

    

    function loadDataHandler() {

        Object.values(statusContainer).forEach((container) => {
            container.innerHTML = "";
        })
        
        fetch(BASE_URL)
            .then((data) => data.json())
            .then(response => {
                let currentTasks = Object.values(response);

                for (const { title, description, status, _id } of currentTasks) {
                    const li = createElement('li', statusContainer[status], null, ['task'], _id);
                    createElement('h3', li, title)
                    createElement('p', li, description)
                    const statusBtn = createElement('button', li, statusButtonContent[status])
                    //  <li class="task">
                    //   <h3>Fix Bug</h3>
                    //   <p>We have a new bug to fix</p>
                    //   <button>Move to In Progress/Move to Code Review/Move to Done/Close</button>
                    // </li>

                    statusBtn.addEventListener('click', changeStatusHandler)

                }
            })
            .catch((err) => {
                console.error(err);
            })
    }

    function addTaskHandler(event) {
        event.preventDefault();

        const title = titleInput.value;
        const description = descriptionInput.value;
        const status = 'ToDo';

        if (!title || !description) {
            return;
        }

        const newTask = { title, description, status,}

        const htmlHeaders = {
            method: 'POST',
            body: JSON.stringify(newTask),
        }

        fetch(BASE_URL, htmlHeaders)
        .then(() => loadDataHandler())
        .catch((err) => {
            console.error(err);
        })

        titleInput.value = ''
        descriptionInput.value = ''
    }

    function changeStatusHandler(event) {
        const itemId = event.currentTarget.parentNode.id;
        // взимаме науменованието на контейнера
        const currentStatusContainer =  
            event.currentTarget.parentNode.parentNode.parentNode
                .querySelector('h1:first-child').textContent;


        
        
        if (currentStatusContainer === 'Done') {
            const httpHeaders = {
                method: 'DELETE',  
            }

            fetch(`${BASE_URL}${itemId}`, httpHeaders)
            .then(() => loadDataHandler())
            .catch((err) => {
                console.error(err);
            })


        } else {
            // взимаме науменованието на следващия контейнер
            const statusContainer = event.currentTarget.parentNode.parentNode.parentNode
                .nextElementSibling
                .querySelector('h1:first-child').textContent;
            console.log(statusContainer)

            const payload = {
                status: statusContainer,
            }

            const httpHeaders = {
                method: 'PATCH',
                body: JSON.stringify(payload)
            }

            fetch(`${BASE_URL}${itemId}`, httpHeaders)
            .then(() => loadDataHandler())
            .catch((err) => {
                console.error(err);
            })
        }

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







attachEvents();