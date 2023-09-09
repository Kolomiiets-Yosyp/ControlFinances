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
    document.addEventListener("DOMContentLoaded", function () {
        const errorMessageElement = document.getElementById("errorMessage");

        // Отримуємо повідомлення про помилку з моделі, якщо воно існує
        const errorMessage = errorMessageElement.textContent.trim();

        // Перевіряємо, чи є повідомлення про помилку та виводимо його
        if (errorMessage) {
            errorMessageElement.style.display = "block"; // Показуємо повідомлення
        }
    });

    // Залиште решту вашого JavaScript-коду, як є
});


