function create(words) {
   const content = document.querySelector("#content")

   words.forEach(word => {
      const div = document.createElement("div");
      const p = document.createElement("p");
      p.textContent = word;
      p.style.display = "none"

      div.appendChild(p);
      content.appendChild(div);

      div.addEventListener("click", (event) => {
         const invisibleP = event.currentTarget.querySelector("p");
         invisibleP.style.display = "block"
         
      })
   });
}