function deleteByEmail() {
    const newEmail = Array.from(document.getElementsByName("email"))[0].value;
    const emails = Array.from(document.querySelectorAll('td:nth-child(2)'));
    
    const result = document.querySelector("#result");

    emails.forEach((e) => {
        if (e.textContent === newEmail) {
            e.parentElement.remove();
            result.textContent = "Deleted."
        } else {
            result.textContent = "Not found."
        }
    }); 
}