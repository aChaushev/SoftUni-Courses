function attachEventsListeners() {
    const daysInput = document.querySelector("#days");
    const daysBtn = document.querySelector("#daysBtn");

    const hoursInput = document.querySelector("#hours");
    const hoursBtn = document.querySelector("#hoursBtn");

    const minutesInput = document.querySelector("#minutes");
    const minutesBtn = document.querySelector("#minutesBtn");

    const secondsInput = document.querySelector("#seconds");
    const secondsBtn = document.querySelector("#secondsBtn");

    // const inputs = Array.from(document.querySelectorAll('input[type="text"]'));
    // const buttons = Array.from(document.querySelectorAll('input[type="button"]'));
    
    daysBtn.addEventListener("click", convertDays);
    hoursBtn.addEventListener("click", convertHours);
    minutesBtn.addEventListener("click", convertMinutes);
    secondsBtn.addEventListener("click", convertSeconds);
  
    function convertDays() {
      const daysValue = parseFloat(daysInput.value);
      hoursInput.value = daysValue * 24;
      minutesInput.value = daysValue * 24 * 60;
      secondsInput.value = daysValue * 24 * 60 * 60;
    }
  
    function convertHours() {
      const hoursValue = parseFloat(hoursInput.value);
      daysInput.value = hoursValue / 24;
      minutesInput.value = hoursValue * 60;
      secondsInput.value = hoursValue * 60 * 60;
    }
  
    function convertMinutes() {
      const minutesValue = parseFloat(minutesInput.value);
      daysInput.value = minutesValue / (24 * 60);
      hoursInput.value = minutesValue / 60;
      secondsInput.value = minutesValue * 60;
    }
  
    function convertSeconds() {
      const secondsValue = parseFloat(secondsInput.value);
      daysInput.value = secondsValue / (24 * 60 * 60);
      hoursInput.value = secondsValue / (60 * 60);
      minutesInput.value = secondsValue / 60;
    }
}