function solution() {

    const baseUrl = 'http://localhost:3030/jsonstore/advanced/articles/list';

    const section = document.getElementById('main');


    load();
    async function load() {

        const response = await fetch(baseUrl);
        const data = await response.json();

        Object.values(data).forEach(element => {

            const divAccordion = document.createElement('div');
            divAccordion.classList.add('accordion');
            divAccordion.id = element._id;

            const divHead = document.createElement('div');
            divHead.classList.add('head');

            const span = document.createElement('span');
            span.textContent = element.title;

            const button = document.createElement('button');
            button.classList.add('button');
            button.id = element._id;
            button.textContent = 'More';
            button.addEventListener('click', showHide);

            const divExtra = document.createElement('div');
            divExtra.classList.add('extra');

            const p = document.createElement('p');
            p.textContent = element.content;

            divExtra.appendChild(p);

            divHead.appendChild(span);
            divHead.appendChild(button);

            divAccordion.appendChild(divHead);
            divAccordion.appendChild(divExtra);

            section.appendChild(divAccordion);

        })
    }

    async function showHide(e) {
        const but = e.target;
        const buttonName = e.target.textContent.toLowerCase();

        if (buttonName === 'more') {
            const mainDiv = but.parentElement.parentElement;

            const p = mainDiv.querySelector('.extra p');
            p.textContent = '';

            const id = but.id;

            const responce = await fetch('http://localhost:3030/jsonstore/advanced/articles/details/' + `${id}`);
            const data = await responce.json();

            p.textContent = data.content;

            const extra = but.parentElement.parentElement.querySelector('.extra');
            extra.style.display = 'block';
            extra.appendChild(p);

            but.textContent = 'Less';

        } else if (buttonName === 'less') {
            const extra = but.parentElement.parentElement.querySelector('.extra');
            extra.style.display = 'none';

            but.textContent = 'More';
        }

    }

}

solution()