function factorialDivision(num1, num2) {
    
    function factorial(num) {
        let numFactorial = 1;
        for (let i = num; i > 0 ; i--) {
            numFactorial *= i;
        }
        return numFactorial;
    }

    console.log((factorial(num1) / factorial(num2)).toFixed(2));
}

factorialDivision(5, 2);
factorialDivision(6, 2);