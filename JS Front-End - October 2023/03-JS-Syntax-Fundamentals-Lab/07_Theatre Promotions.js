function solve(day, age) {
    let result;

    if ( 0 <= age && age <= 18 ) {
        if (day === 'Weekday') {
            result = "12$";
        } else if (day === 'Weekend') {
            result = "15$";
        } else if (day === 'Holiday') {
            result = "5$";
        }

    } else if ( 18 < age && age <= 64 ) {
        if (day === 'Weekday') {
            result = "18$";
        } else if (day === 'Weekend') {
            result = "20$";
        } else if (day === 'Holiday') {
            result = "12$";
        }
        
    } else if ( 64 < age && age <= 122 ) {
        if (day === 'Weekday') {
            result = "12$";
        } else if (day === 'Weekend') {
            result = "15$";
        } else if (day === 'Holiday') {
            result = "10$";
        }
        
    } else {
        result = "Error!";
    }
    
    console.log(result);
}

solve('Weekday', 42);
solve('Holiday', -12);
solve('Holiday', 15);