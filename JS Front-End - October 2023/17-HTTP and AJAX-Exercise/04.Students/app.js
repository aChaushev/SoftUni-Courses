function attachEvents() {

  const baseUrl = 'http://localhost:3030/jsonstore/collections/students/';

  const tbody = document.querySelector('tbody');
  load();

  document.getElementById('submit').addEventListener('click', addStudent);

  let [firstName, lastName, facultyNumber, grade] = document.querySelectorAll('input');

  async function load() {

      tbody.innerHTML = '';

      const response = await fetch(baseUrl);
      const data = await response.json();

      Object.values(data).forEach(element => {

          const tr = document.createElement('tr');

          const firstNameTd = document.createElement('td');
          firstNameTd.textContent = element.firstName;

          const lastNameTd = document.createElement('td');
          lastNameTd.textContent = element.lastName;

          const facultyTd = document.createElement('td');
          facultyTd.textContent = element.facultyNumber;

          const gradeTd = document.createElement('td');
          gradeTd.textContent = element.grade;

          tr.appendChild(firstNameTd);
          tr.appendChild(lastNameTd);
          tr.appendChild(facultyTd);
          tr.appendChild(gradeTd);

          tbody.appendChild(tr);

      })
  }

  async function addStudent() {

      if (firstName.value === '' || lastName.value === '' || facultyNumber.value === '' || grade.value === '') {
          return;
      }

      const options = {
          method: 'POST',
          body: JSON.stringify({
              firstName: firstName.value,
              lastName: lastName.value,
              facultyNumber: facultyNumber.value,
              grade: grade.value
          })
      }

      await fetch(baseUrl, options);

      await load();

      firstName.value = '';
      lastName.value = '';
      facultyNumber.value = '';
      grade.value = '';

  }


}

attachEvents();