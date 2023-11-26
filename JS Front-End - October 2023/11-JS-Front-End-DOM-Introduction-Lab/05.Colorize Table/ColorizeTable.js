function colorize() {
    const evenRows = Array.from(document.querySelectorAll("tr:nth-child(even)"));
    evenRows.forEach((row) => {
        row.style.background = "Teal"
    })
}
