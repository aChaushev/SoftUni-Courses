function extractText() {
    const itemsList = Array.from(document.querySelectorAll('li'));
    
    const result = itemsList.map((item) => item.textContent).join('\n');
    
    document.querySelector('#result').value = result;
}