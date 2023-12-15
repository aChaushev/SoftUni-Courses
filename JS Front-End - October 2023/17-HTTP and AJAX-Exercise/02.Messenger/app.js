function attachEvents() {

    const baseUrl = 'http://localhost:3030/jsonstore/messenger/';

    const textArea = document.getElementById('messages');

    const authorName = document.getElementsByName('author')[0];

    const message = document.getElementsByName('content')[0];

    const sendBtn = document.getElementById('submit');
    sendBtn.addEventListener('click', sendMessage);

    const refreshBtn = document.getElementById('refresh');
    refreshBtn.addEventListener('click', loadMessages);

    async function sendMessage() {
        if (authorName.value !== '' && message.value !== '') {

            const options = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    "author": authorName.value,
                    "content": message.value
                })
            }

            await fetch(baseUrl, options);
            await loadMessages();
        }

        authorName.value = '';
        message.value = '';
        
    }

    async function loadMessages() {
        textArea.textContent = '';

        const response = await fetch(baseUrl);
        const data = await response.json();
        const messageToDisplay = [];

        Object.values(data).forEach(element => {
            messageToDisplay.push(`${element.author}: ${element.content}`);
        });

        textArea.textContent = messageToDisplay.join('\n');
    }


}

attachEvents();