function addressBook(inoutArr) {
    inoutArr = inoutArr.sort((a, b) => a - b);
  let addressBook = {};
  for (const line of inoutArr) {
    let token = line.split(":");
    let name = token[0];
    let address = token[1];
    addressBook[name] = address;
    }
    
    Object.entries(addressBook)
        .sort((a, b) => a[0].localeCompare(b[0]))
        .forEach(([key, value]) => {
    console.log(`${key} -> ${value}`);
  });
}

addressBook([
  "Tim:Doe Crossing",
  "Bill:Nelson Place",
  "Peter:Carlyle Ave",
  "Bill:Ornery Rd",
]);
addressBook(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
    'Jeff:Huxley Rd'
]);
