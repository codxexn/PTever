// 문의 등록하기 버튼 관련 js
// 제목과 내용 중 하나라도 비어있으면 비활성화

const askTitle = document.querySelector("input[name=askTitle]");
const askContent = document.querySelector(".PersonalAskContent");
const submitButton = document.querySelector(".PersonalAsk-Footer-SubmitButton");

askTitle.addEventListener("keyup", (e) => {
    if(e.target.value && askContent.value){
        submitButton.disabled=false;
    } else {
        submitButton.disabled=true;
    }
})

askContent.addEventListener("keyup", (e) => {
    if(e.target.value && askTitle.value){
        submitButton.disabled=false;
    } else {
        submitButton.disabled = true;
    }

})