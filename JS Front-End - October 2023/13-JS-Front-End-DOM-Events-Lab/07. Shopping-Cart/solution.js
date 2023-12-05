function solve() {
   const addButtons = Array.from(document.querySelectorAll(".add-product"));
   const textarea = document.querySelector("textarea");
   const checkoutBtn = document.querySelector(".checkout")

   let boughtProducts = [];
   let totalPrice = 0; 

   addButtons.forEach(button => {
      button.addEventListener("click", addElementInTheCard);
   })

   function addElementInTheCard(e) {
      const currentProduct = e.currentTarget.parentNode.parentNode;//the whole .product div element
      const productTitle = currentProduct.querySelector(".product-title").textContent;
      const productPrice = currentProduct.querySelector(".product-line-price").textContent;

      if (!boughtProducts.includes(productTitle)) {
         boughtProducts.push(productTitle);
      }
      totalPrice += Number(productPrice);
      
      textarea.value += `Added ${productTitle} for ${productPrice} to the cart.\n`
   }

   checkoutBtn.addEventListener("click", checkout);

   function checkout(e) {
      textarea.value += `You bought ${boughtProducts.join(', ')} for ${totalPrice.toFixed(2)}.`

      checkoutBtn.disabled = 'true';
      
      addButtons.forEach(button => {
         button.disabled = 'true';
         button.removeEventListener("click", addElementInTheCard);
      })
   }
}