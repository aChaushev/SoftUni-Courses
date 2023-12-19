function solve() {

    const foodElement = document.querySelector('#food');
    const timeElement = document.querySelector('#time');
    const caloriesElement = document.querySelector('#calories');

    const addMealBtn = document.querySelector('#add-meal');
    const editBtn = document.querySelector('#edit-meal');

    const confirmedList = document.querySelector('#list');
    const loadBtn = document.querySelector('#load-meals');

    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/'
    
    let currentMeals = {};
    let elementToEdit = {};
    let currentId = '';

    loadBtn.addEventListener('click', loadMealHandler)
    addMealBtn.addEventListener('click', addMealHandler)
    editBtn.addEventListener('click', editMealHandler)

    function loadMealHandler() {

        fetch(BASE_URL)
            .then((data) => data.json())
            .then((mealRes) => {
                currentMeals = Object.values(mealRes);

                confirmedList.innerHTML = "";
                for (const { food, calories, time, _id} of currentMeals) {
                    const div = createElement('div', confirmedList, null, ['meal'], _id);
                    createElement('h2', div, food);
                    createElement('h3', div, time);
                    createElement('h3', div, calories);
                    const btnDiv = createElement('div', div, null, ['meal-buttons'])
                    const changeBtn = createElement('button', btnDiv, 'Change', ['change-meal']);
                    const deleteBtn = createElement('button', btnDiv, 'Delete', ['delete-meal']);

                    changeBtn.addEventListener('click', changeMealHandler)
                    deleteBtn.addEventListener('click', deleteMealHandler)
              }
              
            })
            .catch((err) => {
                console.error(err);
        })
    };

    function addMealHandler(event) {
        event.preventDefault();
        const newItem = JSON.stringify({
            food: foodElement.value,
            time: timeElement.value,
            calories: caloriesElement.value,
        });

        const httpHeaders = {
          method: 'POST',
          // headers: { 'Content-Type': 'application/json'},
          body: newItem,
        }

        fetch(BASE_URL, httpHeaders)
            .then(() => {
                loadMealHandler();
             })
            .then(() => {
                foodElement.value = '';
                timeElement.value = '';
                caloriesElement.value = '';
            })
            .catch((err) => {
                console.error(err);
        })

    };

    function changeMealHandler(event) {
        let id = event.currentTarget.parentNode.parentNode.id;
        currentId = id;
        elementToEdit = currentMeals.find((meal) => meal._id === id);
  
        foodElement.value = elementToEdit['food']
        timeElement.value = elementToEdit['time']
        caloriesElement.value = elementToEdit['calories']
  
          editBtn.removeAttribute('disabled');
          addMealBtn.setAttribute('disabled', true)
        
    }

    function editMealHandler(event) {
        event.preventDefault();
              
          const editedItem = JSON.stringify({
            food: foodElement.value,
            time: timeElement.value,
            calories: caloriesElement.value,
            _id: currentId,
          });
        
          const httpHeaders = {
              method: 'PUT',
              body: editedItem,
          } 
  
          fetch(`${BASE_URL}${currentId}`, httpHeaders)
            .then(() => {
                loadMealHandler()
            })
            .then(() => {
                addMealBtn.removeAttribute('disabled');
                editBtn.setAttribute('disabled', true)
                foodElement.value = '';
                timeElement.value = '';
                caloriesElement.value = '';
            })
              .catch((err) => {
                  console.error(err);
              })
        
              currentId = '';
    }

    function deleteMealHandler(event) {
        const id = event.currentTarget.parentNode.parentNode.id;

        const httpHeaders = {
          method: 'DELETE'
        }
    
        fetch(`${BASE_URL}${id}`, httpHeaders)
        .then(() => {
            loadMealHandler()
        })
          .catch((err) => {
              console.error(err);
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

solve()