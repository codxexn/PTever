// FAQ에서 질문 클릭 시 실행 함수 (웹)
const replyArrows = document.querySelectorAll(".ReplyArrowImg");
const questionWrappers = document.querySelectorAll(".QuestionWrapper");

for(let i = 0; i < replyArrows.length; i++){
    questionWrappers[i].addEventListener("click", (e) => {
        e.preventDefault();
        if (questionWrappers[i].style.borderBottom != "none"){
            questionWrappers[i].style.borderBottom = "none";
        } else {
            questionWrappers[i].style.borderBottom = "1px solid rgb(204, 204, 204)";
        }
        questionWrappers[i].nextElementSibling.classList.toggle("HiddenReply");
        questionWrappers[i].nextElementSibling.classList.toggle("ShowReply");
        replyArrows[i].classList.toggle("ReplyArrowImg");
        replyArrows[i].classList.toggle("ReplyArrowImg-Clicked");
    });
}

// FAQ에서 질문 클릭 시 실행 함수 (앱)
const replyArrowsM = document.querySelectorAll(".ReplyArrowImg-Mobile");
const questionWrappersM = document.querySelectorAll(".QuestionWrapper-Mobile");

for(let i = 0; i < replyArrowsM.length; i++){
    questionWrappersM[i].addEventListener("click", (e) => {
        e.preventDefault();
        if (questionWrappersM[i].style.borderBottom != "none"){
            questionWrappersM[i].style.borderBottom = "none";
        } else {
            questionWrappersM[i].style.borderBottom = "1px solid rgb(204, 204, 204)";
        }
        questionWrappersM[i].nextElementSibling.classList.toggle("HiddenReply");
        questionWrappersM[i].nextElementSibling.classList.toggle("ShowReply");
        replyArrowsM[i].classList.toggle("ReplyArrowImg-Mobile");
        replyArrowsM[i].classList.toggle("ReplyArrowImg-Mobile-Clicked");
    });
}