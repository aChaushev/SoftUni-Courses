function encodeAndDecodeMessages() {
    const messageToEncode = document.querySelector("#main div:nth-of-type(1) textarea");
    const encodeBtn = document.querySelector("#main div:nth-of-type(1) button");

    const messageToDecode = document.querySelector("#main div:nth-of-type(2) textarea");
    const decodeBtn = document.querySelector("#main div:nth-of-type(2) button");

    encodeBtn.addEventListener("click", encode);
    decodeBtn.addEventListener("click", decode);

    function encode() {
        const originalMessage = messageToEncode.value;
        let encodedMessage = "";

        Array.from(originalMessage).forEach(char => {
            const currentChar = char.charCodeAt(0);
            encodedMessage += String.fromCharCode(currentChar + 1);
        });

        // Clear sender textarea
        messageToEncode.value = '';

        // Add the encoded message to the receiver textarea
        messageToDecode.value = encodedMessage;
    }

    function decode() {
        const encodedMessage = messageToDecode.value;
        let decodedMessage = "";

        Array.from(encodedMessage).forEach(char => {
            const currentChar = char.charCodeAt(0);
            decodedMessage += String.fromCharCode(currentChar - 1);
        });

        // Replace the encoded message with the decoded message
        messageToDecode.value = decodedMessage;
    }
}