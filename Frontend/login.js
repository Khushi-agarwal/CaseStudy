function login() {
    const form = document.getElementById("login-form");
    const formData = new FormData(form);
    const formDataObject = {};
    formData.forEach((value, key) => {
        formDataObject[key] = value;
    });

    fetch("http://localhost:8080/Users", {
        method: "POST",
        body: JSON.stringify(formDataObject),
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then((response) => response.json())
    .then((data) => {
        if (data === 1) {
           
            window.location.href = "index.html";
        } else {
           
            alert("Incorrect username and password");
        }
    })
    .catch((error) => {
        console.error("Error:", error);
    });
}
