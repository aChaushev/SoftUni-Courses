// TODO
function attachEvents() {
    const titleInput = document.querySelector("#title");
    const loadBtn = document.querySelector("#load-button");
    const addBtn = document.querySelector("#add-button");
    const todoListContainer = document.querySelector("#todo-list");
    const BASE_URL = "http://localhost:3030/jsonstore/tasks/";


    loadBtn.addEventListener('click', loadTasksHandler);
    addBtn.addEventListener('click', addTaskHandler);

    function loadTasksHandler(event) {
        if (event) { // ако event-а съществува
            event.preventDefault();
            // event? .preventDefault(); -> '?' null safe operator -> ако event е null няма да извика метода в дясно preventDefault()
        }
        
        todoListContainer.innerHTML = "";
        //при async function
        // try {
        //     const data = await fetch(BASE_URL, httpHeaders);
        //     const tasksRes = await data.json();
        //     ... след това 
        //          for (const { _id, ...
        // } catch (err) {
        //     console.error(err);
        // }

        fetch(BASE_URL)
            .then((data) => data.json())
            .then((tasksRes) => {
                const tasks = Object.values(tasksRes);
            
                for (const { _id, name } of tasks) {
                    const li = document.createElement('li');
                    const span = document.createElement('span');
                    const removeBtn = document.createElement('button');
                    const editBtn = document.createElement('button');

                    li.id = _id; // закача id-то на всеки сздаден лист
                    span.textContent = name;
                    removeBtn.textContent = 'Remove';
                    editBtn.textContent = 'Edit';

                    editBtn.addEventListener('click', loadEditFormHandler)
                    removeBtn.addEventListener('click', removeTaskHandler)


                    li.append(span, removeBtn, editBtn);
                    todoListContainer.appendChild(li);
                
                }
            })
            .catch((err) => {
                console.error(err);
            })
    }

    function loadEditFormHandler(event) {
        const liParent = event.currentTarget.parentNode; // чрез edit button-a взимаме parent-a му
        const [span, _removeBtn, editBtn] = Array.from(liParent.children); // правим масив от децата -> <span>Go Shopping</span> <button>Remove</button> <button>Edit</button>
        
        const editInput = document.createElement('input');
        editInput.value = span.textContent; // правим нов инпут със съдържанието на span-a
        liParent.prepend(editInput); // закачаме новия инпут

        const submitBtn = document.createElement('button');
        submitBtn.textContent = 'Submit';
        submitBtn.addEventListener('click', submitTaskHandler);
        liParent.appendChild(submitBtn);

        span.remove();
        editBtn.remove();

    }

    function submitTaskHandler(event) {
        const liParent = event.currentTarget.parentNode;  // чрез submit button-a взимаме parent-a му
        const id = liParent.id; //взимаме di-то
        //или  const id = this.parentNode.id;
        const [input, _removeBtn, _submitBtn] = Array.from(liParent.children);

        const httpHeaders = {
            method: 'PATCH',
            body: JSON.stringify({ name: input.value })
        }

        fetch(`${BASE_URL}${id}`, httpHeaders) //като втори аргумент са винаги headers
            .then(() => loadTasksHandler())
            .catch((err) => {
                console.error(err);
            })
    }

    function addTaskHandler(event) {
        if (event) {
            event.preventDefault();
        }
            const name = titleInput.value;
            const httpHeaders = {
                method: 'POST',
                body: JSON.stringify({ name })
            }

            fetch(BASE_URL, httpHeaders) // таргетирам всички таскове и за това не ми трябва id
                .then(() => {
                    loadTasksHandler()
                    titleInput.value = ''; // 1исти input Title полето
                })
            .catch((err) => {
                console.error(err);
            })
    }

    function removeTaskHandler(event) {
        const liParent = event.currentTarget.parentNode;
        const id = liParent.id;

        const httpHeaders = {
            method: 'DELETE',
        }

        fetch(`${BASE_URL}${id}`, httpHeaders)
            .then(() => loadEditFormHandler())
            .catch(handleError);
    }

    // async function removeTaskHandler(event) {
    //     const liParent = event.currentTarget.parentNode;
    //     const id = liParent.id;

    //     const httpHeaders = {
    //         method: 'DELETE',
    //     }

    //     try {
    //         await fetch(`${BASE_URL}${id}`, httpHeaders);
    //         loadEditFormHandler()
    //     } catch (err) {
    //         console.error(err);
    //     }
    // }

    function handleError(err) {
        console.error(err);
    }

}
attachEvents();
