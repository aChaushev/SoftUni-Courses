function solve(input) {
  let wordsArr = input.split(" ");
  let wordsObj = {};

    wordsArr
        .forEach((element) => {
            element = element.toLowerCase();
            if (wordsObj.hasOwnProperty(element)) {
                wordsObj[element] += 1;
            } else {
                wordsObj[element] = 1;
            }
        });

    let arrayOfOdds = Object.entries(wordsObj)
        .filter(([key, value]) => {
            if (value % 2 !== 0) {
                return key;
            }
        })
        .map(el => el[0]);;
        
  
        console.log(arrayOfOdds.join(" "));
}

solve("Java C# Php PHP Java PhP 3 C# 3 1 5 C#");
solve("Cake IS SWEET is Soft CAKE sweet Food");
