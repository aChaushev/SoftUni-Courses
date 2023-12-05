function focused() {
    const sections = Array.from(document.querySelectorAll("input"));
    console.log(sections)

    sections.forEach((section) => {
        section.addEventListener("focus", (e) => {
            e.target.parentElement.classList.add("focused")
        });
        section.addEventListener("blur", (e) => {
            e.target.parentElement.classList.remove("focused")
        });
    });
  }