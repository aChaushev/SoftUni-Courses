function validate() {
  const emailInput = document.querySelector("#email");

  emailInput.addEventListener("change", (e) => {
    const emailInputValue = e.currentTarget.value;
    if (
      /[a-z]+@[a-z]+.[a-z]+/.test(emailInputValue) !== true) {
      emailInput.classList = "error";
    } else {
      emailInput.classList = "input";
    }
  });
}
