globalThis.flag = new Array([false, false]);

const inputId = document.querySelector("input[name=email]");
const loginBtn = document.querySelector(".send-Email-Btn");

inputId.addEventListener("keyup", (e) => {
    if(!e.target.value){
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

// 아래는 반응형(앱) 페이지 버튼 활성화 관련 js입니다.

const inputIdMobile = document.querySelector(".input-Email-Form-mobile");
const loginBtnMobile = document.querySelector(".send-Email-Btn-mobile");

inputIdMobile.addEventListener("keyup", (e) => {
    if(!e.target.value){
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