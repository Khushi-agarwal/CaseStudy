response = fetch('http://localhost:8080/products')
    .then(res => {
        return res.json();
    })
    .then(data => {
        const dataCon = document.getElementById("data-container");
        dataCon.innerHTML = "";

        data.forEach(product => {
            const card = document.createElement("div");
            card.classList.add("card");
            
            const cardHeader = document.createElement("div");

            cardHeader.classList.add("card-header");
            cardHeader.innerHTML = `<h2>${product.productName}</h2>`;

         
            const cardBody = document.createElement("div");
            cardBody.classList.add("card-body");
          

            
            cardBody.innerHTML = `
            <div class="left-content">
                <p><strong>Description:</strong> ${product.productDesc}</p>
                <p><strong>Category:</strong> ${product.productCategory}</p>
            </div>
            <div class="right-content">
                <p><strong>Price:</strong> Rs${product.productPrice.toFixed(2)}</p>
                <p><strong>Ratings:</strong> ${product.productRating} stars</p>
              
            </div>
            <div class="buttons">
                        <button class="btn btn-secondary" onclick="addButton(${product.productId})">Add</button>
                        <button class="btn btn-secondary" onclick="deleteButton(${product.productId})">Remove</button>
                    </div>
            <br>
           
        `;

          
        card.appendChild(cardHeader);
        card.appendChild(cardBody);

        dataCon.appendChild(card);
        });
    })
    .catch(error => console.log(error));

    function addButton(productId){
            
            fetch(`http://localhost:8080/products/add/${productId}`, {
                method: 'GET'
               
            })
            .then(response => {
                
                if (response.status === 200) {
                   
                    alert('Product added to cart.');
                } else {
                   
                    alert('Failed to add product to cart.');
                }
            })
            .catch(error => {
               
                console.error('Error:', error);
            });
        }
        function deleteButton(productId) {
            
            fetch(`http://localhost:8080/products/delete/${productId}`, {
                method: 'GET'
              
            })
            .then(response => {
                console.log('Response status:', response.status);
              
                if (response.status === 200) {
                   
                    alert('Product removed from cart.');
                } else {
                  
                    alert('Failed to remove product from cart.');
                }
            })
            .catch(error => {
               
                console.error('Error:', error);
            });
        }
       
        function searchProducts(event){
            event.preventDefault();
            const searchQueryInput = document.getElementById("search-query");
            const productName = searchQueryInput.value.trim();
            // Send a request to the server to perform the search
            fetch(`http://localhost:8080/products/search/${productName}`)
                .then(response => response.json())
                .then(products => {
                    console.log(products);
                    displaySearchResults(products);
                })
                .catch(error => console.error("Error performing search:", error));
        }
            function displaySearchResults(products) {
                const searchResultsDiv = document.getElementById("search-results");
                searchResultsDiv.innerHTML = "";
                if (products.length === 0) {
                    searchResultsDiv.innerHTML = "<p>No products found.</p>";
                } else {
                    // const productList = document.getElementById("product-list");
                    products.forEach(product => {
                        const card = document.createElement("div");
                        card.classList.add("card");
                        
                        const cardHeader = document.createElement("div");
            
                        cardHeader.classList.add("card-header");
                        cardHeader.innerHTML = `<h2>${product.productName}</h2>`;
            
                     
                        const cardBody = document.createElement("div");
                        cardBody.classList.add("card-body");
                      
            
                        
                        cardBody.innerHTML = `
                        <div class="left-content">
                            <p><strong>Description:</strong> ${product.productDesc}</p>
                            <p><strong>Category:</strong> ${product.productCategory}</p>
                        </div>
                        <div class="right-content">
                            <p><strong>Price:</strong> Rs${product.productPrice.toFixed(2)}</p>
                            <p><strong>Ratings:</strong> ${product.productRating} stars</p>
                          
                        </div>
                        <div class="buttons">
                                    <button class="btn btn-secondary" onclick="addButton(${product.productId})">Add</button>
                                    <button class="btn btn-secondary" onclick="deleteButton(${product.productId})">Remove</button>
                                </div>
                        <br>
                       
                    `;
            
                      
                    card.appendChild(cardHeader);
                    card.appendChild(cardBody);
                   
                        searchResultsDiv.appendChild(card);
                    });
                }
            }

        document.addEventListener("DOMContentLoaded", function () {
          
            const redirectButton = document.getElementById("checkout");
        
            redirectButton.addEventListener("click", function () {
              
                window.location.href = "cart.html";
            });
        });
    
    
   
   
    

