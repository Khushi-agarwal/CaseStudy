function submitCheckoutForm() {
    const form = document.getElementById("checkoutform");
    const formData = new FormData(form);
    const formDataObject = {};
    formData.forEach((value, key) => {
        formDataObject[key] = value;
    });

    fetch("http://localhost:8080/orders", {
        method: "POST",
        body: JSON.stringify(formDataObject),
         headers: {
        "Content-Type": "application/json"
    }
    })
    .then((response) => {
        if (response.ok) {
           window.location.href="confirm.html"
           
        } else {
            alert("Order cannot be placed. Please try again.");
        }
    })
    .catch((error) => {
        console.error("Error:", error);
    });
}