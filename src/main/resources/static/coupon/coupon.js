globalThis.flag = false;
const couponNum = document.querySelector(".Insert-TextField");
const insertButton = document.querySelector(".InsertButton");

couponNum.addEventListener("keyup", (e) => {
    if(!e.target.value){
        globalThis.flag = false;
    } else {
        globalThis.flag = true;
    }
    if(globalThis.flag){
        insertButton.disabled = false;
    } else{
        insertButton.disabled = true;
    }
})

const couponNumMobile = document.querySelector(".Insert-TextFieldMobile");
const insertButtonMobile = document.querySelector(".InsertButtonMobile");

couponNumMobile.addEventListener("keyup", (e) => {
    if(!e.target.value){
        globalThis.flag = false;
    } else {
        globalThis.flag = true;
    }
    if(globalThis.flag){
        insertButtonMobile.disabled = false;
    } else{
        insertButtonMobile.disabled = true;
    }
})
