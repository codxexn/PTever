globalThis.flag = false;

const inputOldPw = document.querySelector("input[name=oldPw]");
const inputNewPassword = document.querySelector("input[name=newPw]");
const correctDescription = document.querySelector(
    "input[name=passwordConfirm]"
);
const changeButton = document.querySelector(".correct-RegisterPage-Submit-Btn");
const warning = document.querySelector(".warning");

// 기존 비밀번호와 새로운 비밀번호, 비밀번호 확인란이 모두 입력되지 않으면
// 변경하기 버튼이 활성화되지 않습니다.
// 세 input이 모두 입력돼야 변경하기 버튼이 활성화 됩니다.
// 또한 새로운 비밀번호와 확인란의 값이 일치하지 않으면 변경하기 버튼이 활성화되지 않도록 하였습니다.

inputOldPw.addEventListener("keyup", (e) => {
    if (!e.target.value || !inputNewPassword.value || !correctDescription.value) {
        globalThis.flag = false;
    } else {
        globalThis.flag = true;
    }
    if (globalThis.flag) {
        changeButton.disabled = false;
    } else {
        changeButton.disabled = true;
    }
});

inputNewPassword.addEventListener("keyup", (e) => {
    if (!e.target.value || !inputOldPw.value || !correctDescription.value) {
        globalThis.flag = false;
    } else if (inputNewPassword.value !== correctDescription.value) {
        globalThis.flag = false;
    } else {
        globalThis.flag = true;
    }
    if (globalThis.flag) {
        changeButton.disabled = false;
    } else {
        changeButton.disabled = true;
    }
});

correctDescription.addEventListener("keyup", (e) => {
    if (!e.target.value || !inputNewPassword.value || !inputOldPw.value) {
        globalThis.flag = false;
    } else if (inputNewPassword.value !== correctDescription.value) {
        globalThis.flag = false;
    } else {
        globalThis.flag = true;
    }
    if (globalThis.flag) {
        changeButton.disabled = false;
    } else {
        changeButton.disabled = true;
    }
});

// 새 비번과 새 비번 확인란의 값이 일치하지 않으면 p 태그에 경고문구가 뜨고
// 두 input의 border를 빨갛게 변경하였습니다.
inputNewPassword.addEventListener("keyup", () => {
    if (!inputNewPassword.value || !correctDescription.value) {
        inputNewPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    } else if (inputNewPassword.value !== correctDescription.value) {
        inputNewPassword.style.border = "solid 1px red";
        correctDescription.style.border = "solid 1px red";
        warning.innerText = "입력하신 비밀번호가 일치하지 않습니다.";
    } else {
        inputNewPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    }
});

correctDescription.addEventListener("keyup", () => {
    if (!inputNewPassword.value || !correctDescription.value) {
        inputNewPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    } else if (inputNewPassword.value !== correctDescription.value) {
        inputNewPassword.style.border = "solid 1px red";
        correctDescription.style.border = "solid 1px red";
        warning.innerText = "입력하신 비밀번호가 일치하지 않습니다.";
    } else {
        inputNewPassword.style.border = "solid 1px rgb(238, 238, 238)";
        correctDescription.style.border = "solid 1px rgb(238, 238, 238)";
        warning.innerText = "";
    }
});

// 변경하기 버튼이 허용하지 않음 상태였다가
// 모두 값이 입력됐을 때 포인터로 바뀝니다.
// 새 비번과 확인란의 값이 일치하지 않으면 허용하지 않음 상태로 바뀌게 우선 설정해두었습니다.

changeButton.addEventListener("mouseover", (e) => {
    if (inputNewPassword.value !== correctDescription.value) {
        e.target.style.cursor = "not-allowed";
    } else if (
        inputOldPw.value &&
        inputNewPassword.value &&
        correctDescription.value
    ) {
        e.target.style.cursor = "Pointer";
    } else {
        e.target.style.cursor = "not-allowed";
    }
});

const inputTags = document.querySelectorAll(".registerPage-Form");

inputTags.forEach((inputTag) => {
    inputTag.addEventListener("focus", (e) => {
        e.target.style.border = "blue";
    });
});
