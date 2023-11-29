function toggle() {
    const contentText = document.querySelector("#extra");
    const button = document.querySelector(".button");

    if (contentText.style.display === "none") {
        contentText.style.display = "block";
        button.textContent = "Less";
    } else {
        contentText.style.display = "none";
        button.textContent = "More";
    }
}