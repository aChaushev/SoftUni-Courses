function formatGrade(grade) {
    let result = grade.toFixed(2);
    if (grade >= 5.50) {
        return `Excellent (${result})`;
    } else if (grade >= 4.50) {
        return `Very good (${result})`;
    } else if (grade >= 3.50) {
        return `Good (${result})`;
    } else if (grade >= 3.00) {
        return `Poor (${result})`;
    } else if (grade < 3.00) {
        return `Fail (2)`;
    }
}

console.log(formatGrade(3.33));
console.log(formatGrade(5.50));
console.log(formatGrade(2.99));