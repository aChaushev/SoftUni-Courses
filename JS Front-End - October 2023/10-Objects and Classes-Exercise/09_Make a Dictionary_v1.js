function solve(input) {
    const dictionary = input
      // ['', '', '' ,'']
      .reduce((acc, curr) => {
        const term = JSON.parse(curr);
        // map -> [{}, {}, {}, {}
        acc = { ...acc, ...term };
        // acc се натрупва(добавяме всички property които идват от следващия елемент) -
        //- при всеки loop и така при извикването съдържа всички предишни елементи
      return acc;
    }, {});
    // reduce -> {coffee: '...'}

    const sortedTerms = Object.keys(dictionary).sort()
  
  sortedTerms.forEach(term => {
    console.log(`Term: ${term} => Definition: ${dictionary[term]}`)
  })
  
  // console.log(JSON.stringify(dictionary, null, 2));
}

solve([
  '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
  '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
  '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
  '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
  '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}',
]);
