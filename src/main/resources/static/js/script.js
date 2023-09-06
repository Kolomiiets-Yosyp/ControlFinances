document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form");
    const registerForm = document.getElementById("register-form");
    const toggleFormButton = document.getElementById("toggle-form-button");

    toggleFormButton.addEventListener("click", function () {
        if (loginForm.style.display === "none") {
            loginForm.style.display = "block";
            registerForm.style.display = "none";
            toggleFormButton.textContent = "Switch to Register";
        } else {
            loginForm.style.display = "none";
            registerForm.style.display = "block";
            toggleFormButton.textContent = "Switch to Login";
        }
    });

    loginForm.addEventListener("submit", function (e) {
        e.preventDefault();
        const username = document.getElementById("login-username").value;
        const password = document.getElementById("login-password").value;

        // Ваша логіка для авторизації
    });

    registerForm.addEventListener("submit", function (e) {
        e.preventDefault();
        const username = document.getElementById("register-username").value;
        const password = document.getElementById("password").value;

        // Ваша логіка для реєстрації
    });

    // Решта вашого JavaScript коду...
});

document.addEventListener("DOMContentLoaded", function () {
    const passwordInput = document.getElementById("password");
    const passwordError = document.getElementById("password-error");

    passwordInput.addEventListener("input", function () {
        const password = passwordInput.value;
        if (password.length < 5) {
            passwordError.textContent = "The password must contain at least 5 characters";
        } else {
            passwordError.textContent = "";
        }
    });
});