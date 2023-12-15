function lockedProfile() {

    const baseUrl = 'http://localhost:3030/jsonstore/advanced/profiles';

    const main = document.querySelector('main');
    main.innerHTML = '';

    load();
    async function load() {
        const response = await fetch(baseUrl);
        const data = await response.json();

        let userNumber = 1;

        Object.values(data).forEach(element => {

            const divProfile = document.createElement('div');
            divProfile.classList.add('profile');

            const img = document.createElement('img');
            img.src = './iconProfile2.png';
            img.classList.add('userIcon');

            const labelLock = document.createElement('label');
            labelLock.textContent = 'Lock';

            const inputLock = document.createElement('input');
            inputLock.setAttribute('type', 'radio');
            inputLock.name = `user${userNumber}Locked`;
            inputLock.value = 'lock';
            inputLock.setAttribute('checked', 'true');

            const labelUnlock = document.createElement('label');
            labelUnlock.textContent = 'Unlock';

            const inputUnlock = document.createElement('input');
            inputUnlock.setAttribute('type', 'radio');
            inputUnlock.name = `user${userNumber}Locked`;
            inputUnlock.value = 'unlock';

            const br = document.createElement('br');

            const hr = document.createElement('hr');

            const labelUsername = document.createElement('label');
            labelUsername.textContent = 'Username';

            const inputUsername = document.createElement('input');
            inputUsername.setAttribute('type', 'text');
            inputUsername.name = `user${userNumber}Username`;
            inputUsername.value = element.username;
            inputUsername.disabled = true;
            inputUsername.readOnly = true;

            const divHidden = document.createElement('div');
            divHidden.id = `user${userNumber}HiddenFields`;
            // divHidden.id = 'user1HiddenFields';
            divHidden.style.display = 'none';

            const hrInner = document.createElement('hr');

            const labelEmail = document.createElement('label');
            labelEmail.textContent = 'Email:';

            const inputEmail = document.createElement('input');
            inputEmail.setAttribute('type', 'email');
            inputEmail.name = `user${userNumber}Email`;
            inputEmail.value = element.email;
            inputEmail.disabled = true;
            inputEmail.readOnly = true;

            const labelAge = document.createElement('label');
            labelAge.textContent = 'Age:';

            const inputAge = document.createElement('input');
            inputAge.setAttribute('type', 'email');
            inputAge.name = `user${userNumber}Age`;
            inputAge.value = element.age;
            inputAge.disabled = true;
            inputAge.readOnly = true;

            const buttonShow = document.createElement('button');
            buttonShow.textContent = 'Show more';
            buttonShow.addEventListener('click', showMore);

            divHidden.appendChild(hrInner);
            divHidden.appendChild(hrInner);
            divHidden.appendChild(labelEmail);
            divHidden.appendChild(inputEmail);
            divHidden.appendChild(labelAge);
            divHidden.appendChild(inputAge);

            divProfile.appendChild(img);
            divProfile.appendChild(labelLock);
            divProfile.appendChild(inputLock);
            divProfile.appendChild(labelUnlock);
            divProfile.appendChild(inputUnlock);
            divProfile.appendChild(br);
            divProfile.appendChild(hr);
            divProfile.appendChild(labelUsername);
            divProfile.appendChild(inputUsername);
            divProfile.appendChild(divHidden);
            divProfile.appendChild(buttonShow);

            main.appendChild(divProfile);

            userNumber++;
        })
    }

    function showMore(e) {
        const divToShow = e.target.parentElement;

        const locked = e.target.parentElement.querySelector('input');
        if (locked.checked) {
            return;
        }

        if (e.target.textContent === 'Show more') {
            e.target.textContent = 'Hide it';
            const divShow = divToShow.querySelector('div');
            divShow.style.display = 'block';
        } else {
            e.target.textContent = 'Show more';
            const divShow = divToShow.querySelector('div');
            divShow.style.display = 'none';
        }

    }

}