globalThis.flag = new Array([false, false]);

const inputId = document.querySelector("input[name=email]");
const inputPassword = document.querySelector("input[name=password]");
const correctDescription = document.querySelector("input[name=passwordConfirm]");
const loginBtn = document.querySelector(".correct-RegisterPage-Submit-Btn");

inputId.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPassword.value || !correctDescription.value){
        globalThis.flag[0] = false;
    } else {
        globalThis.flag[0] = true;
    }
    if(globalThis.flag[0]){
        loginBtn.disabled = false;
    } else{
        loginBtn.disabled = true;
    }
});

inputPassword.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputId.value || !correctDescription.value){
        globalThis.flag[0] = false;
    } else {
        globalThis.flag[0] = true;
    }
    if(globalThis.flag[0]){
        loginBtn.disabled = false;
    } else {
        loginBtn.disabled = true;
    }
});


correctDescription.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPassword.value || !inputId.value){
        globalThis.flag[0] = false;
    } else {
        globalThis.flag[0] = true;
    }
    if(globalThis.flag[0]){
        loginBtn.disabled = false;
    } else {
        loginBtn.disabled = true;
    }
});

// 반응형

const inputIdMobile = document.querySelector(".correct-InputId-Form-mobile");
const inputPasswordMobile = document.querySelector(".correct-InputPw-Form-mobile");
const correctDescriptionMobile = document.querySelector(".correct-InputPwCheck-Form-mobile");
const loginBtnMobile = document.querySelector(".correct-RegisterPage-Submit-Btn-mobile");

inputIdMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPasswordMobile.value || !correctDescriptionMobile.value){
        globalThis.flag[1] = false;
    } else {
        globalThis.flag[1] = true;
    }
    if(globalThis.flag[1]){
        loginBtnMobile.disabled = false;
    } else{
        loginBtnMobile.disabled = true;
    }
});

inputPasswordMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputIdMobile.value || !correctDescriptionMobile.value){
        globalThis.flag[1] = false;
    } else {
        globalThis.flag[1] = true;
    }
    if(globalThis.flag[1]){
        loginBtnMobile.disabled = false;
    } else {
        loginBtnMobile.disabled = true;
    }
});


correctDescriptionMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPasswordMobile.value || !inputIdMobile.value){
        globalThis.flag[1] = false;
    } else {
        globalThis.flag[1] = true;
    }
    if(globalThis.flag[1]){
        loginBtnMobile.disabled = false;
    } else {
        loginBtnMobile.disabled = true;
    }
});