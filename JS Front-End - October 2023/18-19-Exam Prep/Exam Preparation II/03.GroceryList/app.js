function attachEvents() {

    const productName = document.querySelector('#product');
    const productCount = document.querySelector('#count');
    const productPrice = document.querySelector('#price');
    const addBtn = document.querySelector('#add-product');
    const updateBtn = document.querySelector('#update-product');
    const loadBtn = document.querySelector('#load-product');
    const productContainer = document.querySelector('#tbody');
    const form = document.querySelector('.list')
    const BASE_URL = 'http://localhost:3030/jsonstore/grocery/';

    let currentProducts = {};
    let productToEdit = {};

    loadBtn.addEventListener('click', loadProductsHandler)
    addBtn.addEventListener('click', addProductHandler)
    updateBtn.addEventListener('click', updateProductHandler)

    async function loadProductsHandler(event) {
        if (event) {
            event.preventDefault();
        }

        fetch(BASE_URL) 
            .then((data) => data.json())
            .then((productRes) => {
                currentProducts = Object.values(productRes);
                console.log(currentProducts)

                productContainer.innerHTML = "";
                for (const { product, count, price, _id } of currentProducts) {
                    const tr = document.createElement("tr");
                    const nameBox = document.createElement("td");
                    const countBox = document.createElement("td");
                    const priceBox = document.createElement("td");
                    const buttonsContainer = document.createElement("td");
                    const updateBtnBox = document.createElement("button");
                    const deleteBtnBox = document.createElement("button");

                    tr.id = _id;
                    productContainer.appendChild(tr);

                    nameBox.classList.add('name')
                    nameBox.textContent = product;
                    tr.appendChild(nameBox);

                    countBox.classList.add('count-product')
                    countBox.textContent = Number(count);
                    tr.appendChild(countBox);
                    
                    priceBox.classList.add('product-price')
                    priceBox.textContent = Number(price);
                    tr.appendChild(priceBox);
                    
                    buttonsContainer.classList.add('btn')
                    tr.appendChild(buttonsContainer);

                    updateBtnBox.className += 'update'
                    updateBtnBox.textContent = 'Update'
                    buttonsContainer.appendChild(updateBtnBox);

                    deleteBtnBox.className += 'delete'
                    deleteBtnBox.textContent = 'Delete'
                    buttonsContainer.appendChild(deleteBtnBox);

                    updateBtnBox.addEventListener('click', loadUpdateProductHandler)
                    deleteBtnBox.addEventListener('click', deleteProductHandler)
                }
            })
            .catch((err) => {
                console.error(err);
            })
    }


    function loadUpdateProductHandler(event) {
        const id = event.currentTarget.parentNode.parentNode.id
        productToEdit = currentProducts.find((product) => product._id === id);
        // от списъка с продукти ми намери продукта с id отговарящо на търсеното id
        productName.value = productToEdit['product'];
        productCount.value = productToEdit['count'];
        productPrice.value = productToEdit['price'];

        addBtn.setAttribute('disabled', true)
        updateBtn.removeAttribute('disabled')
    }

    function updateProductHandler(event) {
        event.preventDefault();
        const payload = JSON.stringify({
            product: productName.value,
            count: productCount.value,
            price: productPrice.value,
        });
        const httpHeaders = {
            method: 'PATCH',
            body: payload,
        }

        fetch(`${BASE_URL}${productToEdit._id}`, httpHeaders)
            .then(() => {
                loadProductsHandler();
                updateBtn.setAttribute('disabled', true)
                addBtn.removeAttribute('disabled');
                form.reset(); //изчиства полетата на формата
            })
            .catch((err) => {
                console.error(err);
        })
    }

    function addProductHandler(event) {
        event.preventDefault();
        const newItem = JSON.stringify({
            product: productName.value,
            count: productCount.value,
            price: productPrice.value,
        });
        const httpHeaders = {
            method: 'POST',
            body: newItem,
        }

        fetch(`${BASE_URL}`, httpHeaders)
        .then(() => {
            loadProductsHandler();
            form.reset(); //изчиства полетата на формата
        })
        .catch((err) => {
            console.error(err);
    })
    }

    function deleteProductHandler(event) {
        const id = event.currentTarget.parentNode.parentNode.id;

        const httpHeaders = {
            method: 'DELETE',
        }

        fetch(`${BASE_URL}${id}`, httpHeaders)
            .then(() => loadProductsHandler())
            .catch((err) => {
                console.error(err);
        })
    }


}

attachEvents();
