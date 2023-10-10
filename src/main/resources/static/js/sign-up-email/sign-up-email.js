globalThis.flag = new Array([false, false]);

const inputId = document.querySelector("input[name=userEmail]");
const inputPassword = document.querySelector("input[name=userPassword]");
const correctDescription = document.querySelector("input[name=passwordConfirm]");
const loginBtn = document.querySelector(".correct-RegisterPage-Submit-Btn");
const warning = document.querySelector(".warning");

inputId.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPassword.value || !correctDescription.value){
        globalThis.flag[0] = false;
    } else if (inputPassword.value !== correctDescription.value){
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
    } else if (inputPassword.value !== correctDescription.value){
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
    } else if (inputPassword.value !== correctDescription.value){
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

// 새 비번과 새 비번 확인란의 값이 일치하지 않으면 p 태그에 경고문구가 뜨고
// 두 input의 border를 빨갛게 변경하였습니다.
inputPassword.addEventListener("keyup", () => {
    if (!inputPassword.value || !correctDescription.value) {
        inputPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    } else if (inputPassword.value !== correctDescription.value) {
        inputPassword.style.border = "solid 1px red";
        correctDescription.style.border = "solid 1px red";
        warning.innerText = "입력하신 비밀번호가 일치하지 않습니다.";
    } else {
        inputPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    }
});

correctDescription.addEventListener("keyup", () => {
    if (!inputPassword.value || !correctDescription.value) {
        inputPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    } else if (inputPassword.value !== correctDescription.value) {
        inputPassword.style.border = "solid 1px red";
        correctDescription.style.border = "solid 1px red";
        warning.innerText = "입력하신 비밀번호가 일치하지 않습니다.";
    } else {
        inputPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
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