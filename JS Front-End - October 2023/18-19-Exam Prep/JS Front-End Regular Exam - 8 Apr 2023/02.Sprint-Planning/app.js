window.addEventListener('load', solve);

function solve() {
  const tasks = {};  

  const inputDOMSelectors = {
        
        titleInput: document.querySelector('#title'),
        descriptionInput: document.querySelector('#description'),
        labelInput: document.querySelector('#label'),
        pointsInput: document.querySelector('#points'),
        assigneeInput: document.querySelector('#assignee'),
    }

  const otherDOMSelectors = {
        hiddenTaskId: document.querySelector('#task-id'),
        createBtn: document.querySelector('#create-task-btn'),
        deleteTaskBtn: document.querySelector('#delete-task-btn'),
        newSprintTasks: document.querySelector('#tasks-section'),
        totalPoints: document.querySelector('#total-sprint-points'),
    }
  
  const iconsMap = {
    'Feature': '&#8865;',
    'Low Priority Bug': '&#9737;',
    'High Priority Bug': '&#9888;',
  }
  const labelClass = {
    'Feature': 'feature',
    'Low Priority Bug': 'low-priority',
    'High Priority Bug': 'high-priority',
  }

    // let totalPointsCnt = Number(otherDOMSelectors.totalPoints.textContent.trim().split(' ')[2].split('')[0]);
    // console.log(totalPointsCnt);
  otherDOMSelectors.createBtn.addEventListener('click', createTaskHandler)
  otherDOMSelectors.deleteTaskBtn.addEventListener('click', deleteTaskHandler)
  

    function createTaskHandler() {
      // if (Object.values(inputDOMSelectors).some(selector => selector.value === '')) {
      //   ако има някой празен селектор
      //   return;
      // }
      const task = {
        id: `task-${Object.values(tasks).length + 1}`, // При един таск в tasks -> id: task-1,
        title: inputDOMSelectors.titleInput.value,
        description: inputDOMSelectors.descriptionInput.value,
        label: inputDOMSelectors.labelInput.value,
        points: Number(inputDOMSelectors.pointsInput.value),
        assignee: inputDOMSelectors.assigneeInput.value,
      };

      tasks[task.id] = task;
        
        if (!task.title || !task.description || !task.label || !task.points || !task.assignee) {
            return;
        }

      // alert('works');
        const article = createElement('article', otherDOMSelectors.newSprintTasks, null, ['task-card'], task.id)
        // createElement('div', article, `${task.label} ${iconsMap[task.label]}`, ['task-card-label', labelClass[task.label]], null, null, true)
        const labelDiv = createElement('div', article, null, ['task-card-label', labelClass[task.label]]);
        labelDiv.textContent = task.label;
        const iconSpan = createElement('span', labelDiv);
        iconSpan.innerHTML = " " + iconsMap[task.label];
        //ADD HTML ICONS WITH CODE -------------------------
        createElement('h3', article, `${task.title}`, ['task-card-title'])
        createElement('p', article, `${task.description}`, ['task-card-description'])
        createElement('div', article, `Estimated at ${task.points} pts`, ['task-card-points'])
        createElement('div', article, `Assigned to: ${task.assignee}`, ['task-card-assignee'])
        const btnContainer =  createElement('div', article, null, ['task-card-actions'])
        const deleteBtn =  createElement('button', btnContainer, 'Delete')

      // const totalPointsCnt = 0;
      // Object.value(tasks).forEach((task) => {
      //   totalPointsCnt += task.points;
      // })

      // CALCULATE TOTAL POINTS
      calculateTotalPoints();
      // CLEAR INPUT-ELEMENTS
      Object.values(inputDOMSelectors).forEach((element) => {
        element.value = '';
      })

      deleteBtn.addEventListener('click', loadDeleteConfirmHandler)
         
    }


    function loadDeleteConfirmHandler(event) {
      const taskId = event.currentTarget.parentNode.parentNode.getAttribute('id')
      
      inputDOMSelectors.titleInput.value = tasks[taskId].title
      inputDOMSelectors.descriptionInput.value = tasks[taskId].description
      inputDOMSelectors.labelInput.value = tasks[taskId].label
      inputDOMSelectors.pointsInput.value = tasks[taskId].points
      inputDOMSelectors.assigneeInput.value = tasks[taskId].assignee

      inputDOMSelectors.titleInput.disabled = true;
      inputDOMSelectors.descriptionInput.disabled = true;
      inputDOMSelectors.labelInput.disabled = true;
      inputDOMSelectors.pointsInput.disabled = true;
      inputDOMSelectors.assigneeInput.disabled = true;

      otherDOMSelectors.createBtn.disabled = true;
      otherDOMSelectors.deleteTaskBtn.disabled = false;

      otherDOMSelectors.hiddenTaskId.value = taskId;

  }
  
  function deleteTaskHandler(event) {
    event.preventDefault();
    const taskId = otherDOMSelectors.hiddenTaskId.value;
    const taskElement = document.querySelector(`#${taskId}`)
    taskElement.remove();
    delete tasks[taskId];

    inputDOMSelectors.titleInput.disabled = false;
    inputDOMSelectors.descriptionInput.disabled = false;
    inputDOMSelectors.labelInput.disabled = false;
    inputDOMSelectors.pointsInput.disabled = false;
    inputDOMSelectors.assigneeInput.disabled = false;

    inputDOMSelectors.titleInput.value = ''
    inputDOMSelectors.descriptionInput.value = ''
    inputDOMSelectors.labelInput.value = ''
    inputDOMSelectors.pointsInput.value = ''
    inputDOMSelectors.assigneeInput.value = ''

    otherDOMSelectors.createBtn.disabled = false;
    otherDOMSelectors.deleteTaskBtn.disabled = true;

    calculateTotalPoints();
    }
 
  function calculateTotalPoints() {
      const totalPointsCnt = Object.values(tasks).reduce((acc, curr) => acc + curr.points, 0)
      otherDOMSelectors.totalPoints.textContent = `Total Points ${totalPointsCnt}pts`;
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
          // htmlElement.id = id;
          htmlElement.setAttribute('id', id);
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