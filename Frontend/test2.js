
const cartDataPromise = fetch('http://localhost:8080/cart')
    .then(res => res.json());


const productDataPromise = fetch('http://localhost:8080/products')
    .then(res => res.json());

Promise.all([cartDataPromise, productDataPromise])
    .then(([cartData, productData]) => {
        const dataCon = document.getElementById("data-container");
        dataCon.innerHTML = "";

        cartData.forEach(cartItem => {
            const product = productData.find(product => product.productId === cartItem.productId);

            if (product) {
                const card = document.createElement("div");
                card.classList.add("card");

                const cardBody = document.createElement("div");
                cardBody.classList.add("card-body");

                cardBody.innerHTML = `
                    <div class="cart-details">
                        <table>
                        <tr><h3>Product Details:</h3></tr>
                          
                            <tr>
                                <td><strong> Product Name:</strong> ${product.productName}</td>
                               
                            </tr>
                            <tr>
                               
                                <td><strong>Price:</strong> Rs${product.productPrice.toFixed(2)}</td>
                            </tr>
                            <tr>
                            <td>
                                <strong>Quantity:</strong>
                                <button onclick="incrementQuantity(${cartItem.productId})">+</button>
                                <span id="quantity-${cartItem.productId}">${cartItem.productQuantity}</span>
                                <button onclick="decrementQuantity(${cartItem.productId})">-</button>
                              
                            </td>
                        </tr>
                          
                        </table>
                    </div>
                `;

                card.appendChild(cardBody);
                dataCon.appendChild(card);
            }
        });
    })
    .catch(error => console.log(error));

    function incrementQuantity(productId)
    {
        const quantityElement = document.getElementById(`quantity-${productId}`);
    const currentQuantity = parseInt(quantityElement.textContent);

    
    fetch(`http://localhost:8080/cart/increase/${productId}`)
        .then(res => res.json())
        .then(newQuantity => {
            quantityElement.textContent = newQuantity;
        })
        .catch(error => console.log(error));
}
function decrementQuantity(productId)
{
    const quantityElement = document.getElementById(`quantity-${productId}`);
    const currentQuantity = parseInt(quantityElement.textContent);
    if (currentQuantity >1) {
        fetch(`http://localhost:8080/cart/decrease/${productId}`)
            .then(res => res.json())
            .then(newQuantity => {
                if(newQuantity==-1)
                cardElement.remove();
               else
                quantityElement.textContent = newQuantity;
            })
            .catch(error => console.log(error));
    }
    else if(currentQuantity==1)
     alert("Cannot be decreased");
}

document.addEventListener("DOMContentLoaded", function () {
          
    const redirectButton = document.getElementById("order");

    redirectButton.addEventListener("click", function () {
      
        window.location.href = "order.html";
    });
});

    
