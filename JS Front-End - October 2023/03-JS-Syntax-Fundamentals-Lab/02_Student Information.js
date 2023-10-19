function solve (name, age, grade) {
    let fixedGrade = grade.toFixed(2);
    console.log(`Name: ${name}, Age: ${age}, Grade: ${fixedGrade}`);
}

solve('John', 15, 5.54678);
solve('Steve', 16, 2.1426);
solve('Marry', 12, 6.00);