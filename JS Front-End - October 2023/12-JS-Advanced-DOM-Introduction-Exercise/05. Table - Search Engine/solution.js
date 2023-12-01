function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const studentsList = Array.from(document.querySelectorAll("tbody tr td"));
      const textToSearch = document.querySelector("#searchField").value;
      
      studentsList.forEach(element => {
         element.parentElement.classList.remove("select")
      });

      studentsList.forEach(element => {
         if (element.textContent.includes(textToSearch)) {
            element.parentElement.classList.add("select")
         }
      });
   }
}