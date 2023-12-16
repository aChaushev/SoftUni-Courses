function weatherTracker() {

    const loadHistoryBtn = document.querySelector('#load-history')
    const location = document.querySelector('#location');
    const temperature = document.querySelector('#temperature');
    const date = document.querySelector('#date');
    const addWeatherBtn = document.querySelector('#add-weather')
    const editWeatherBtn = document.querySelector('#edit-weather')
    const locationList = document.querySelector('#list')
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/'

    let currentLocations = {};
    let locationToEdit = {};

    loadHistoryBtn.addEventListener('click', loadHistoryHandler)
    addWeatherBtn.addEventListener('click', addWeatherHandler)
    editWeatherBtn.addEventListener('click', editWeatherHandler)
    
    function loadHistoryHandler() {
        fetch(BASE_URL)
            .then((data) => data.json())
            .then((locationsRes) => {
                currentLocations = Object.values(locationsRes);

                locationList.innerHTML = "";
                for (const { location, temperature, date, _id } of currentLocations) {
                    const divContainer = createElement('div', locationList, null, ['container'], _id)
                    createElement('h2', divContainer, location)
                    createElement('h3', divContainer, date)
                    createElement('h3', divContainer, temperature, null, ['celsius'])
                    const buttonsDivContainer = createElement('div', divContainer, null, null, ['buttons-container'])
                    const changeBtn = createElement('button', buttonsDivContainer, 'Change', ['change-btn'])
                    const deleteBtn = createElement('button', buttonsDivContainer, 'Delete', ['delete-btn'])

                    changeBtn.addEventListener('click', changeItemHandler)
                    deleteBtn.addEventListener('click', deleteItemHandler)
                }
                

            })
            .catch((err) => {
                console.error(err);
        }) 
    }

    function addWeatherHandler(event) {
        event.preventDefault();
        const newItem = JSON.stringify({
            location: location.value,
            temperature: temperature.value,
            date: date.value,
        })
        const httpHeaders = {
            method: 'POST',
            body: newItem,
        }

        fetch(BASE_URL, httpHeaders) 
            .then(() => {
                loadHistoryHandler();
                location.value = '';
                temperature.value = '';
                date.value = '';
            })
            .catch((err) => {
                console.error(err);
        }) 
    }

    function changeItemHandler(event) {
        let id = event.currentTarget.parentNode.parentNode.id;
        locationToEdit = currentLocations.find((location) => location._id === id);
      location.value = locationToEdit['location'];
      temperature.value = locationToEdit['temperature'];
      date.value = locationToEdit['date'];

        editWeatherBtn.removeAttribute('disabled')
        addWeatherBtn.setAttribute('disabled', true);

        event.currentTarget.parentNode.parentNode.remove();
    }
    
    function editWeatherHandler(event) {
        event.preventDefault();
        const editedItem = JSON.stringify({
            location: location.value,
            temperature: temperature.value,
            date: date.value,
        })
        const httpHeaders = {
            method: 'PUT',
            body: editedItem,
        }

        fetch(`${BASE_URL}${locationToEdit._id}`, httpHeaders) 
            .then(() => {
                loadHistoryHandler();
                addWeatherBtn.removeAttribute('disabled');
                editWeatherBtn.setAttribute('disabled', true);
                location.value = '';
                temperature.value = '';
                date.value = '';
            })
            .catch((err) => {
                console.error(err);
        }) 
    }

    function deleteItemHandler(event) {
        let id = event.currentTarget.parentNode.parentNode.id;

        const httpHeaders = {
            method: 'DELETE',
        }

        fetch(`${BASE_URL}${id}`, httpHeaders)
            .then(() => loadHistoryHandler())
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

weatherTracker();