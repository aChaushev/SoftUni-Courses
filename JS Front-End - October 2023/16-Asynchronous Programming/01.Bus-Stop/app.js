function getInfo() {
    const stopIdInput = document.querySelector("#stopId");
    const stopNameContainer = document.querySelector("#stopName");
    const busesContainer = document.querySelector("#buses");
    const BASE_URL = 'http://localhost:3030/jsonstore/bus/businfo';
    const stopId = stopIdInput.value;

    busesContainer.innerHTML = '';
    // може и busesContainer.textContent = '';
    //трие предишния check

    fetch(`${BASE_URL}/${stopId}`)
        .then((res) => res.json()) // res = response
        .then((busInfo) => {
            const { name, buses } = busInfo;
            stopNameContainer.textContent = name;
            for (const busId in buses) {
                const li = document.createElement('li');
                li.textContent = `Bus ${busId} arrives in ${buses[busId]} minutes`;
                busesContainer.appendChild(li);
            }
        })
        .catch((err) => {
            stopNameContainer.textContent = "Error"
        })


}