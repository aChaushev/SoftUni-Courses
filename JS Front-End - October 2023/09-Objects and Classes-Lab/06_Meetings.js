function schedule(input) {
  let meetings = input.reduce((acc, curr) => {
    const [day, name] = curr.split(" ");

    if (acc.hasOwnProperty(day)) {
      console.log(`Conflict on ${day}!`);
    } else {
      acc[day] = name;
      console.log(`Scheduled for ${day}`);
      }
      
    return acc;
  }, {});

    Object.keys(meetings).forEach((day) => {
      console.log(`${day} -> ${meetings[day]}`)
  })
}

// schedule(["Monday Peter", "Wednesday Bill", "Monday Tim", "Friday Tim"]);
schedule(['Friday Bob', 'Saturday Ted', 'Monday Bill', 'Monday John', 'Wednesday George']);
