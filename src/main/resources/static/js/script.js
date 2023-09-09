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

    // Залиште решту вашого JavaScript-коду, як є
});


