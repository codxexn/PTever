// 공지사항 제목 클릭 시 상세 내용 표시 관련 js
// 임시 데이터이므로 첫 번째 공지사항 글에만 적용했습니다.

// 웹
const eventTitle = document.querySelectorAll(".event-Entity-Wrapper");
const eventContent = document.querySelectorAll(".event-Entity-Content");
const eventTitleTitle = document.querySelectorAll(".event-Title");

eventTitle[0].addEventListener("click", () => {
    if(eventTitle[0].style.borderBottom != "none"){
        eventTitle[0].style.borderBottom = "none";
        eventTitleTitle[0].style.fontWeight = "bolder";
        eventContent[0].style.display = "block";
    } else{
        eventTitle[0].style.borderBottom = "1px solid rgb(230, 230, 230)";
        eventTitleTitle[0].style.fontWeight = "bold";
        eventContent[0].style.display = "none";
    }
});

// 앱 {
const eventTitleMobile = document.querySelectorAll(".event-Entity-Wrapper-mobile");
const eventContentMobile = document.querySelectorAll(".event-Entity-Content-mobile");
const eventTitleTitleMobile = document.querySelectorAll(".event-Title-mobile");

eventTitleMobile[0].addEventListener("click", () => {
    if(eventTitleMobile[0].style.borderBottom != "none"){
        eventTitleMobile[0].style.borderBottom = "none";
        eventTitleTitleMobile[0].style.fontWeight = "bolder";
        eventContentMobile[0].style.display = "block";
    } else{
        eventTitleMobile[0].style.borderBottom = "1px solid rgb(230, 230, 230)";
        eventTitleTitleMobile[0].style.fontWeight = "bold";
        eventContentMobile[0].style.display = "none";
    }
});

// globalThis = 0;

// eventTitles.forEach((eventTitle) => {
//     eventTitle.addEventListener("click", () => {
//         if(eventTitle.style.borderBottom != "none"){
//             eventTitle.style.borderBottom = "none";
//             eventTitleTitles[globalThis].style.fontWeight = "bolder";
//             eventContents[globalThis].style.display = "block";
//         } else{
//             eventTitle.style.borderBottom = "1px solid rgb(230, 230, 230)";
//             eventTitleTitles[globalThis].style.fontWeight = "bold";
//             eventContents[globalThis].style.display = "none";
//         }
//     });
// });