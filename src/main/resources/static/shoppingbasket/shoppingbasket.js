// 전체 선택 js
function selectAll(selectAll)  {
    const checkboxes 
       = document.querySelectorAll('input[type="checkbox"]');
    
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked
    })
  };

// 장바구니
 // JavaScript 코드
 const quantities = document.querySelectorAll('.quantity');
 const prices = document.querySelectorAll('.price');
 const totalPriceElement = document.getElementById('totalPrice');

 // input 창 클릭 시 페이지 새로고침되는 현상 방지
quantities.forEach((input) => {
    input.addEventListener("click", (e) => {
        e.preventDefault();
    });
})


 // 제품 가격 설정
 const productPrices = [20000, 20000, 30000];

 function updateTotalPrice() {
     let total = 0;
     for (let i = 0; i < quantities.length; i++) {
         let quantity = parseInt(quantities[i].value);
         let price = productPrices[i];
         let productTotal = quantity * price;
         prices[i].textContent = price + "원";
         total += productTotal;
     }
     totalPriceElement.textContent = total + "원";
 }

 for (let i = 0; i < quantities.length; i++) {
     quantities[i].addEventListener('input', updateTotalPrice);
 }

 // 페이지 로드 시 초기 총 가격 업데이트
 updateTotalPrice();










  
// 장바구니 아이템 요소와 checkbox, 수량 입력 필드를 가져옵니다.
// const cartItems = document.querySelectorAll('.cart-item');
// const itemCheckboxes = document.querySelectorAll('.item-checkbox');
// const quantityInputs = document.querySelectorAll('.quantity-input');
// const subtotalElements = document.querySelectorAll('.subtotal');
// const totalAmountElement = document.getElementById('total-amount');

// // 각 아이템의 수량 입력 필드와 checkbox에 대한 이벤트 리스너를 추가합니다.

// cartItems.forEach((item, index) => {
//     const quantityInput = quantityInputs[index];
//     const itemCheckbox = itemCheckboxes[index];

//     quantityInput.addEventListener('input', () => {
//         updateSubtotal(index);
//         calculateTotal();
//     });

//     itemCheckbox.addEventListener('change', () => {
//         updateSubtotal(index);
//         calculateTotal();
//     });
// });

// // 각 아이템의 소계를 업데이트하는 함수
// function updateSubtotal(index) {
//     const pricePerItem = 10; // 상품 가격
//     const quantity = parseInt(quantityInputs[index].value);
//     const itemSubtotal = pricePerItem * quantity;
//     subtotalElements[index].textContent = `소계: $${itemSubtotal.toFixed(2)}`;
// }

// // 전체 총 가격을 계산하는 함수
// function calculateTotal() {
//     let total = 0;
//     cartItems.forEach((item, index) => {
//         const itemCheckbox = itemCheckboxes[index];
//         if (itemCheckbox.checked) {
//             const itemSubtotal = parseFloat(subtotalElements[index].textContent.replace('$', ''));
//             total += itemSubtotal;
//         }
//     });
//     totalAmountElement.textContent = total.toFixed(2);
// }