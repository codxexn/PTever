globalThis.flag = new Array([false, false]);

const inputId = document.querySelector("input[name=email]");
const inputPassword = document.querySelector("input[name=password]");
const loginBtn = document.querySelector(".login-Btn");

inputId.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPassword.value){
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
    if(!e.target.value || !inputId.value){
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

// 아래는 반응형(앱) 페이지 버튼 활성화 관련 js입니다.

const inputIdMobile = document.querySelector(".inputId-Email-Mobile");
const inputPasswordMobile = document.querySelector(".inputId-Password-Mobile");
const loginBtnMobile = document.querySelector(".login-Btn-Mobile");

inputIdMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPasswordMobile.value){
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
    if(!e.target.value || !inputIdMobile.value){
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