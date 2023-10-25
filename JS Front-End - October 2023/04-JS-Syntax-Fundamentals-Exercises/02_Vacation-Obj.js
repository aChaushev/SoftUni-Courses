function solve(group, type, day){
    const prices = {
        Students: {
            Friday:8.45,
            Saturday:9.8,
            Sunday:10.46,
        },
        Business: {
            Friday:10.9,
            Saturday:15.60,
            Sunday:16,
        },
        Regular: {
            Friday:15,
            Saturday:20,
            Sunday:22.5,
        }
    };

    let sum = 0;
    const cost = prices[type][day];
    sum = group * cost;

    if (type === "Students" && group >= 30) {
        sum -= sum * 0.15;
    } else if (type === "Business" && group >= 100) {
        sum = (group - 10) * cost;
    } else if (type === "Regular" && group >= 10 && group <= 20) {
        sum -= sum * 0.05;
    } 

    console.log(`Total price: ${sum.toFixed(2)}`)
}

solve(30, "Students", "Sunday");
solve(40, "Regular", "Saturday");

