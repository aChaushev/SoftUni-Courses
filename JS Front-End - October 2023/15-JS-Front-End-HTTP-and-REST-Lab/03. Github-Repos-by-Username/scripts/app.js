function loadRepos() {

	const url = 'https://api.github.com/users/';
	const username = document.getElementById('username').value;
	const ulList = document.getElementById('repos');

	ulList.textContent = '';

	fetch(url + username + '/repos')
		.then(response => response.json())
		.then(data => {
			console.log(data);
			data.forEach(repo => {
				const li = document.createElement('li');
				const a = document.createElement('a');
				a.href = repo.html_url;
				a.textContent = repo.full_name;
				
				li.appendChild(a);
				ulList.appendChild(li);

			})
		})
		.catch(error => {
			 const errorItem = document.createElement('li');
                    errorItem.textContent = `Error: ${error.message}`;
					ulList.appendChild(errorItem);
		})
	

}