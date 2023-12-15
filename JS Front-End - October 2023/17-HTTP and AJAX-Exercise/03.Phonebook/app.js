function attachEvents() {

    const baseUrl = 'http://localhost:3030/jsonstore/phonebook/';

    document.getElementById('btnLoad').addEventListener('click', load);
    document.getElementById('btnCreate').addEventListener('click', create);

    const phonebook = document.getElementById('phonebook');

    async function load() {
        phonebook.innerHTML = '';

        const response = await fetch(baseUrl);
        const data = await response.json();

        Object.values(data).forEach(element => {
            const li = document.createElement('li');
            li.id = element._id;
            li.textContent = `${element.person}: ${element.phone}`;

            const deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Delete';
            deleteBtn.addEventListener('click', deleteItem);

            li.appendChild(deleteBtn);

            phonebook.appendChild(li);


        })

    }

    async function deleteItem(e) {
        const id = e.target.parentElement;

        const options = {
            method: 'DELETE'
        }

        const response = await fetch(baseUrl + id.id, options);
        await response.json();

        await load();

    }

    async function create() {

        const person = document.getElementById('person').value;
        const phone = document.getElementById('phone').value;

        if (person === '' || phone === '') {
            return;
        }
        const options = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "person": person,
                "phone": phone
            })
        }

        const response = await fetch(baseUrl, options);
        response.json();

        await load();
    }

}

attachEvents();