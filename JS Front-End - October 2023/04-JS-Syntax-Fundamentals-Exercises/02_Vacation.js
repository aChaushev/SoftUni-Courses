function solve(group, type, day){
    let sum = 0;

    if (type === "Students") {
        if(day === "Friday"){
            sum = group * 8.45;
        } else if(day === "Saturday"){
            sum = group * 9.8;
        } else if(day === "Sunday"){
            sum = group * 10.46;
        } 

        if (group >= 30) {
            sum -= sum * 0.15;
        }
    } else if (type === "Business") {
        if(group >= 100){
            group -= 10;
        }

        if(day === "Friday"){
            sum = group * 10.9;
        } else if(day === "Saturday"){
            sum = group * 15.60;
        } else if(day === "Sunday"){
            sum = group * 16;
        } 
    } else if (type === "Regular") {
        if(day === "Friday"){
            sum = group * 15;
        } else if(day === "Saturday"){
            sum = group * 20;
        } else if(day === "Sunday"){
            sum = group * 22.5;
        } 

        if (group >= 10 && group <= 20) {
            sum -= sum * 0.05;
        }
    }

    console.log(`Total price: ${sum.toFixed(2)}`)
}

solve(30, "Students", "Sunday");
solve(40, "Regular", "Saturday");
solve(100, "Business", "Sunday");
