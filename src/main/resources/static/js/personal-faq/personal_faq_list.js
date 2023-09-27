// 1:1문의글 제목 클릭 시 상세 내용 표시 관련 js
// 임시 데이터이므로 첫 번째 1:1문의글에만 적용했습니다.

// 웹
const faqTitle = document.querySelectorAll(".FAQ-Element");
const faqContent = document.querySelectorAll(".FAQ-Content");
const faqReply = document.querySelectorAll(".FAQ-ReplyWrapper");

faqTitle[0].addEventListener("click", () => {
    if(faqTitle[0].style.borderBottom != "none"){
        faqTitle[0].style.borderBottom = "none";
        faqTitle[0].style.fontWeight = "bolder";
        faqContent[0].style.display = "block";
        faqReply[0].style.display = "block";
    } else{
        faqTitle[0].style.borderBottom = "1px solid rgb(230, 230, 230)";
        faqTitle[0].style.fontWeight = "bold";
        faqContent[0].style.display = "none";
        faqReply[0].style.display = "none";
    }
});

// 앱
const faqTitleMobile = document.querySelectorAll(".FAQ-Element-Mobile");
const faqContentMobile = document.querySelectorAll(".FAQ-Content-Mobile");
const faqReplyMobile = document.querySelectorAll(".FAQ-ReplyWrapper-Mobile");


faqTitleMobile[0].addEventListener("click", () => {
    if(faqTitleMobile[0].style.borderBottom != "none"){
        faqTitleMobile[0].style.borderBottom = "none";
        faqTitleMobile[0].style.fontWeight = "bolder";
        faqContentMobile[0].style.display = "block";
        faqReplyMobile[0].style.display = "block";
    } else{
        faqTitleMobile[0].style.borderBottom = "1px solid rgb(230, 230, 230)";
        faqTitleMobile[0].style.fontWeight = "bold";
        faqContentMobile[0].style.display = "none";
        faqReplyMobile[0].style.display = "none";
    }
});