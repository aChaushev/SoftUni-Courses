
const coursesType = [
    'Long',
    'Medium',
    'Short'
    ]

    const titleElement = document.querySelector('#course-name')
    const typeElement = document.querySelector('#course-type')
    const descElement = document.querySelector('#description')
    const teacherElement = document.querySelector('#teacher-name')
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/'

// let currentCourses = {};
let currentCourseId = '';

    const progressCourseContainer = document.querySelector('#list')
    const loadBtn = document.querySelector('#load-course')
    const addBtn = document.querySelector('#add-course')
    const editPlannerBtn = document.querySelector('#edit-course')

    loadBtn.addEventListener('click', loadCoursesHandler);
    addBtn.addEventListener('click', addCourseHandler)
    editPlannerBtn.addEventListener('click', editCourseHandler)

    function loadCoursesHandler() {

        progressCourseContainer.innerHTML = '';
        fetch(BASE_URL)
            .then(data => data.json())
            .then(response => {
                let currentCourses = Object.values(response);

                for (const { title, type, description, teacher, _id} of currentCourses) {
                    const divContainer = createElement('div', progressCourseContainer, null, ['container'], _id);
                    createElement('h2', divContainer, title);
                    createElement('h3', divContainer, teacher);
                    createElement('h3', divContainer, type);
                    createElement('h4', divContainer, description);
                    
                    const editBtn = createElement('button', divContainer, 'Edit Course', ['edit-btn']);
                    const finishBtn = createElement('button', divContainer, 'Finish Course', ['finish-btn']);

                    editBtn.addEventListener('click', (event) => {
                        titleElement.value = title;
                        typeElement.value = type;
                        descElement.value = description;
                        teacherElement.value = teacher;
                        currentCourseId = _id;

                        addBtn.setAttribute('disabled', true);
                        editPlannerBtn.removeAttribute('disabled');

                        event.currentTarget.parentNode.remove();
                    });

                    finishBtn.addEventListener('click', (event) => {
                        const id = event.currentTarget.parentNode.id

                        const httpHeaders = {
                            method: 'DELETE',
                        }

                        fetch(`${BASE_URL}${id}`, httpHeaders)
                            .then(() => loadCoursesHandler())
                            .catch((err) => {
                                console.error(err);
                            })
                    });
                }
            })
            .catch((err) => {
                console.error(err);
            })
    }

    function addCourseHandler(event) {
        event.preventDefault();
        const title = titleElement.value;
        const type = typeElement.value;
        const description = descElement.value;
        const teacher = teacherElement.value;

        if (!coursesType.includes(type)) {
            return;
        }
        //judge може да иска проверка за празни полета !!!!
        const newCourse = {
            title,
            type,
            description,
            teacher,
        }

        const httpHeaders = {
            method: 'POST',
            body:JSON.stringify(newCourse)
        }

        fetch(BASE_URL, httpHeaders) 
            .then(() => {
                loadCoursesHandler();
                titleElement.value = '';
                typeElement.value = '';
                descElement.value = '';
                teacherElement.value = '';
            })
            .catch((err) => {
                console.error(err);
            })
    }
    
    function editCourseHandler(event) {
        event.preventDefault();
        const title = titleElement.value;
        const type = typeElement.value;
        const description = descElement.value;
        const teacher = teacherElement.value;

        if (!coursesType.includes(type)) {
            return;
        }
        //judge може да иска проверка за празни полета !!!!
        const editCourse = {
            title,
            type,
            description,
            teacher,
        }

        const httpHeaders = {
            method: 'PUT',
            body:JSON.stringify(editCourse)
        }

        fetch(`${BASE_URL}${currentCourseId}`, httpHeaders) 
            .then(() => {
                loadCoursesHandler();
                titleElement.value = '';
                typeElement.value = '';
                descElement.value = '';
                teacherElement.value = '';
            })
            .catch((err) => {
                console.error(err);
            })
        
            editPlannerBtn.setAttribute('disabled', true);
            addBtn.removeAttribute('disabled');
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