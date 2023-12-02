function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
       let restaurants = {};
       const inputs = document.querySelector('textarea').value;
       let restaurantsData = JSON.parse(inputs);

       restaurantsData.forEach(element => {

           let [restaurant, workers] = element.split(' - ');
           if (!restaurants.hasOwnProperty(restaurant)) {
               restaurants[restaurant] = {
                   averageSalary: 0,
                   bestSalary: -1,
                   workers: {},
               }
           }

           let totalSalary = 0;
           for (const iterator of workers.split(", ")) {
               let [name, salary] = iterator.split(" ")
               restaurants[restaurant].workers[name] = Number(salary)
               if (Number(salary) > restaurants[restaurant].bestSalary) {
                   restaurants[restaurant].bestSalary = Number(salary);
               }
           }

           Object.values(restaurants[restaurant].workers).forEach(element => {
               totalSalary += element
           });
           restaurants[restaurant].averageSalary = totalSalary / Object.keys(restaurants[restaurant].workers).length; //restaurants[restaurant].workers.length;
       });

       let bestRestaurant = {
           name: "",
           averageSalary: 0,
           bestSalary: -1,
           workers: {},
       };
       Object.entries(restaurants).forEach(element => {
           const restaurantsData = element[1];
           if (restaurantsData.averageSalary > bestRestaurant.averageSalary) {
               bestRestaurant.name = element[0];
               bestRestaurant.averageSalary = restaurantsData.averageSalary;
               bestRestaurant.bestSalary = restaurantsData.bestSalary;
               bestRestaurant.workers = restaurantsData.workers;
           }
       });

       let outputBestRestaurant = document.querySelector("#bestRestaurant p");
       outputBestRestaurant.textContent = `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.averageSalary.toFixed(2)} Best Salary: ${bestRestaurant.bestSalary.toFixed(2)}`;

       let outputWorkers = document.querySelector("#workers p");

       let sortedSalary = Object.entries(bestRestaurant.workers).sort((a, b) => b[1] - a[1]);
       sortedSalary.forEach(element => {
           outputWorkers.textContent += `Name: ${element[0]} With Salary: ${element[1]} `
       })
       outputWorkers.textContent = outputWorkers.textContent.trim();
   }
}