function vacationSchedule() {

    // const vacationContainer = document.querySelector('#form')
    const vacName = document.querySelector('#name');
    const numDays = document.querySelector('#num-days');
    const fromDate = document.querySelector('#from-date');


    const addBtn = document.querySelector('#add-vacation');
    const editBtn = document.querySelector('#edit-vacation');

    const confirmedList = document.querySelector('#list');
    const loadBtn = document.querySelector('#load-vacations');

    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/'

    let currentVacations = {};
    let elementToEdit = {};
    let currentId = '';

    loadBtn.addEventListener('click', loadVacationHandler)
    addBtn.addEventListener('click', addVacationHandler)
    editBtn.addEventListener('click', editVacationHandler)

    function loadVacationHandler(event) {

        fetch(BASE_URL)
            .then((data) => data.json())
            .then((vacationRes) => {
                currentVacations = Object.values(vacationRes);

                confirmedList.innerHTML = "";
                for (const { name, days, date, _id} of currentVacations) {
                    const div = createElement('div', confirmedList, null, ['container'], _id);
                    createElement('h2', div, name);
                    createElement('h3', div, date);
                    createElement('h3', div, days);
                    const changeBtn = createElement('button', div, 'Change', ['change-btn']);
                    const doneBtn = createElement('button', div, 'Done', ['done-btn']);

                    changeBtn.addEventListener('click', changeVacationHandler)
                    doneBtn.addEventListener('click', deleteVacationHandler)
              }
              console.log(currentVacations)
            })
            .catch((err) => {
                console.error(err);
        })
    };

    function addVacationHandler(event) {
        event.preventDefault();
        const newItem = JSON.stringify({
            name: vacName.value,
            days: numDays.value,
            date: fromDate.value,
        });

        const httpHeaders = {
          method: 'POST',
          // headers: { 'Content-Type': 'application/json'},
          body: newItem,
        }

        fetch(BASE_URL, httpHeaders)
            .then(() => {
              loadVacationHandler();
             })
            .then(() => {
              vacName.value = '';
              numDays.value = '';
              fromDate.value = '';
            })
            .catch((err) => {
                console.error(err);
        })

    };
    
    function changeVacationHandler(event) {
      let id = event.currentTarget.parentNode.id;
      currentId = id;
      elementToEdit = currentVacations.find((vacation) => vacation._id === id);

      vacName.value = elementToEdit['name']
      numDays.value = elementToEdit['days']
      fromDate.value = elementToEdit['date']

      // let parentDiv = event.currentTarget.parentNode;
      //   vacName.value = parentDiv.querySelector('h2').textContent;
      //   numDays.value = Array.from(parentDiv.querySelectorAll('h3'))[1].textContent;
      //   fromDate.value = Array.from(parentDiv.querySelectorAll('h3'))[0].textContent;

        editBtn.removeAttribute('disabled');
        addBtn.setAttribute('disabled', true)
      
    };

    function editVacationHandler(event) {
      event.preventDefault();
            
        const editedItem = JSON.stringify({
            name: vacName.value,
            days: numDays.value,
            date: fromDate.value,
            _id: currentId,
        });
      console.log(vacName.value, numDays.value, fromDate.value)
        const httpHeaders = {
            method: 'PUT',
            body: editedItem,
        } 

        fetch(`${BASE_URL}${currentId}`, httpHeaders)
          .then(() => {
            loadVacationHandler()
          })
          .then(() => {
              addBtn.removeAttribute('disabled');
              editBtn.setAttribute('disabled', true)
              vacName.value = '';
              numDays.value = '';
              fromDate.value = '';
          })
            .catch((err) => {
                console.error(err);
            })
      
            currentId = '';
  }
  
  function deleteVacationHandler(event) {
    const id = event.currentTarget.parentNode.id;

    const httpHeaders = {
      method: 'DELETE'
    }

    fetch(`${BASE_URL}${id}`, httpHeaders)
    .then(() => {
      loadVacationHandler()
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

vacationSchedule()