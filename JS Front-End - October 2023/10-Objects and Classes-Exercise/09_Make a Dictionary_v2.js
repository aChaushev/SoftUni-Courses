function solve(input) {
  let dictionary = {};
 
  input.forEach(jsonString => {
    const term = JSON.parse(jsonString);
    dictionary = Object.assign(dictionary, term);
    // merge objects - взима term(и други обекти след него, ако има такива) и ще ги вкара в първия
  });

  const sortedTerms = Object.keys(dictionary).sort()
  //сортираме ключовете в масив
  sortedTerms.forEach(term => {
    console.log(`Term: ${term} => Definition: ${dictionary[term]}`)
  })
  //принтираме ключовете, като взимаме стойностите им от обекта

  // console.log(JSON.stringify(dictionary, null, 2));
}

solve([
  '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
  '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
  '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
  '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
  '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}',
]);
