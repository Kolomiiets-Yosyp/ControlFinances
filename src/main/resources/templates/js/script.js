document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form");
    const registerForm = document.getElementById("register-form");

    loginForm.addEventListener("submit", function (e) {
        e.preventDefault();
        const username = document.getElementById("login-username").value;
        const password = document.getElementById("login-password").value;

        // Perform AJAX request to check credentials and login
        // Example:
        // fetch("/login", {
        //     method: "POST",
        //     body: JSON.stringify({ username, password }),
        //     headers: { "Content-Type": "application/json" }
        // })
        // .then(response => response.json())
        // .then(data => {
        //     if (data.success) {
        //         // Redirect to user dashboard or other page
        //     } else {
        //         alert("Invalid credentials");
        //     }
        // })
    });

    registerForm.addEventListener("submit", function (e) {
        e.preventDefault();
        const username = document.getElementById("register-username").value;
        const password = document.getElementById("register-password").value;

        // Perform AJAX request to register user
        // Example:
        // fetch("/register", {
        //     method: "POST",
        //     body: JSON.stringify({ username, password }),
        //     headers: { "Content-Type": "application/json" }
        // })
        // .then(response => response.json())
        // .then(data => {
        //     if (data.success) {
        //         // Redirect to login page or show success message
        //     } else {
        //         alert("Registration failed");
        //     }
        // })
    });
});
