function solve(input) {
  let movies = [];
  input.forEach((command) => {
    if (command.includes("addMovie")) {
      const [_, name] = command.split("addMovie ");
      movies.push({
        name,
      });
    } else if (command.includes("directedBy")) {
      const [movieName, directorName] = command.split(" directedBy ");
      const movie = movies.find((movie) => movie.name === movieName);
      if (movie) {
        movie.director = directorName;
      }
    } else if (command.includes("onDate")) {
      const [movieName, movieDate] = command.split(" onDate ");
      const movie = movies.find((movie) => movie.name === movieName);
      if (movie) {
        movie.date = movieDate;
      }
    }
  });
    
    movies
        .filter(movie => movie.name && movie.director && movie.date)
        .forEach(movie => console.log(JSON.stringify(movie)));
}

solve([
  "addMovie Fast and Furious",
  "addMovie Godfather",
  "Inception directedBy Christopher Nolan",
  "Godfather directedBy Francis Ford Coppola",
  "Godfather onDate 29.07.2018",
  "Fast and Furious onDate 30.07.2018",
  "Batman onDate 01.08.2018",
  "Fast and Furious directedBy Rob Cohen",
]);
solve([
  "addMovie The Avengers",
  "addMovie Superman",
  "The Avengers directedBy Anthony Russo",
  "The Avengers onDate 30.07.2010",
  "Captain America onDate 30.07.2010",
  "Captain America directedBy Joe Russo",
]);
