function attachEvents() {

  const url = "http://localhost:3030/jsonstore/collections/books"

  const tableBody = document.querySelector('tbody');
  tableBody.innerHTML = '';

  const loadBtn = document.getElementById('loadBooks');
  loadBtn.addEventListener('click', loadBooks);

  const createBookBtn = document.querySelectorAll('button')[1];
  createBookBtn.addEventListener('click', createBook);

  const title = document.getElementsByName('title')[0];
  const author = document.getElementsByName('author')[0];

  let editID;

  async function loadBooks() {
      tableBody.innerHTML = '';

      const response = await fetch(url);
      const data = await response.json();
 
      Object.entries(data).forEach(element => {
      
          const tr = document.createElement('tr');
          tr.id = element[0];
          const tdTitle = document.createElement('td');
          tdTitle.textContent = element[1].title;

          const tdAuthor = document.createElement('td');
          tdAuthor.textContent = element[1].author;

          const editBtn = document.createElement('button');
          editBtn.textContent = 'Edit';
          editBtn.addEventListener('click', editBook);

          const deleteBtn = document.createElement('button');
          deleteBtn.textContent = 'Delete';
          deleteBtn.addEventListener('click', deleteBook);

          tr.appendChild(tdTitle);
          tr.appendChild(tdAuthor);
          tr.appendChild(editBtn);
          tr.appendChild(deleteBtn);

          tableBody.appendChild(tr);

      });
  }

  async function createBook() {

      const t = title.value;
      const a = author.value;

      if (t == '' || a == '') {
          return;
      }

      const options = {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              "author": a,
              "title": t
          })
      }

      const response = await fetch(url, options);
      await response.json();

      title.value = '';
      author.value = '';

      await loadBooks();

  }


  function editBook(e) {
      const divForm = document.querySelector('h3');
      divForm.textContent = 'Edit FORM';

      const index = Array.from(document.querySelectorAll('button')).length - 1;
      
      createBookBtn.removeEventListener('click', createBook);
      const editBtn = document.querySelectorAll('button')[index];
      editBtn.textContent = 'Save';
      editBtn.addEventListener('click', saveBook);

      const tr = e.currentTarget.parentElement;
      editID = tr.id;

      const t = tr.children[0].textContent;
      const a = tr.children[1].textContent;

      title.value = t;
      author.value = a;

  }

  async function saveBook() {
      tableBody.innerHTML = '';

      const options = {
          method: 'PUT',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              "author": author.value,
              "title": title.value
          })
      }

      await fetch(url + '/' + editID, options);

      await loadBooks();
      
      title.value = '';
      author.value = '';
  }

  async function deleteBook(e) {
      e.preventDefault();

      const tr = e.currentTarget.parentElement;

      const options = {
          method: 'DELETE'
      }

      await fetch(url + '/' + tr.id, options);

      await loadBooks();
  }
}

attachEvents();