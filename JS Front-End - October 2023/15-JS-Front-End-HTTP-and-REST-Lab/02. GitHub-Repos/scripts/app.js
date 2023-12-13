function loadRepos() {

   const url = 'https://api.github.com/users/testnakov/repos';
   const divList = document.getElementById('res');

   fetch(url)
       .then(response => response.text())
       .then(data => {
           divList.textContent = data;
       })
       .catch(error => {
           console.log(error);
       })

}