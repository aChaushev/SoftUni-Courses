function validatePassword(password) {
    const errors = [];

    if (password.length < 6 || password.length > 10) {
        errors.push("Password must be between 6 and 10 characters");
    }

    if (!password.match("^[A-Za-z0-9]+$")) {
        errors.push("Password must consist only of letters and digits");
    }

    const digitCount = password.match(/\d/g);

    if (!digitCount || digitCount.length < 2) {
        errors.push("Password must have at least 2 digits");
    }

    if (errors.length > 0) {
        console.log(errors.join("\n"));
        return;
    }

    console.log("Password is valid");
}

validatePassword("logIn");
// validatePassword("MyPass123");
// validatePassword("Pa$s$s");