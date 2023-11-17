function collectPhoneNumbers(arr) {
    const phoneObj = arr.reduce((acc, curr) => { // accumulator, current
        const [name, number] = curr.split(' '); //разделяме масива на масив/тупал от name и number
        acc[name] = number; // името отговаря на този номер

        return acc;
    }, {}); // {} -> Първоначалната стойност е масив // ако ще сумираме тотал вместо {} -> 0

    Object.entries(phoneObj).forEach(([key, value]) => {
        console.log(`${key} -> ${value}`);
    });
}

collectPhoneNumbers(['Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344']
);