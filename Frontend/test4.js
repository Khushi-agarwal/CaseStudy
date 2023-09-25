response=fetch('http://localhost:8080/orders/totalamount')
.then(res => res.json())
.then(data =>{
    console.log(data);
    const tt=document.getElementById("value");
    tt.textContent=data;
})
.catch(error => console.log(error));