// 공지사항에서 탭 클릭 시 탭 색상 변경 및 아래 내용 변경
NodeList.prototype.filter = Array.prototype.filter;

///////////////////////
// 웹

const labels = document.querySelectorAll(".pc .TabLabelsWrapper a");
const allNoticeContent = document.querySelector(".pc .FadeWrapper1");
const noticeNoticeContent = document.querySelector(".pc .FadeWrapper2");
const normalNoticeContent = document.querySelector(".pc .FadeWrapper3");


function showNoticeContent(label) {
    if(label.classList.contains("AllLabel")){
        allNoticeContent.style.display = "block";
        noticeNoticeContent.style.display = "none";
        normalNoticeContent.style.display = "none";
    } else if(label.classList.contains("NoticeLabel")){
        allNoticeContent.style.display = "none";
        noticeNoticeContent.style.display = "block";
        normalNoticeContent.style.display = "none";
    } else {
        allNoticeContent.style.display = "none";
        noticeNoticeContent.style.display = "none";
        normalNoticeContent.style.display = "block";
    }
}

labels.filter((label) => !label.parentNode.classList.contains("LinkToEventPage"))
.forEach((label) => {
    label.addEventListener("click", (e) => {
        e.preventDefault();
        for(let i = 0; i < labels.length; i++){
            if(labels[i].parentNode.classList.contains("TabLabel-Selected")){
                labels[i].parentNode.classList.remove("TabLabel-Selected");
                if(!labels[i].parentNode.classList.contains("TabLabel-Unselected")){
                    labels[i].parentNode.classList.add("TabLabel-Unselected");
                }
            }
        }
        if(!e.target.parentNode.classList.contains("TabLabel-Selected")){
            e.target.parentNode.classList.add("TabLabel-Selected");
            showNoticeContent(e.target.parentNode);
        }
    })
})

// 앱

const labelsM = document.querySelectorAll(".mobile .TabLabelsWrapper-Mobile a");
const allNoticeContentM = document.querySelector(".mobile .FadeWrapper1-Mobile");
const noticeNoticeContentM = document.querySelector(".mobile .FadeWrapper2-Mobile");
const normalNoticeContentM = document.querySelector(".mobile .FadeWrapper3-Mobile");


function showNoticeContentM(label) {
    if(label.classList.contains("AllLabel-Mobile")){
        allNoticeContentM.style.display = "block";
        noticeNoticeContentM.style.display = "none";
        normalNoticeContentM.style.display = "none";
    } else if(label.classList.contains("NoticeLabel-Mobile")){
        allNoticeContentM.style.display = "none";
        noticeNoticeContentM.style.display = "block";
        normalNoticeContentM.style.display = "none";
    } else {
        allNoticeContentM.style.display = "none";
        noticeNoticeContentM.style.display = "none";
        normalNoticeContentM.style.display = "block";
    }
}

labelsM.filter((label) => !label.parentNode.classList.contains("LinkToEventPage"))
.forEach((label) => {
    label.addEventListener("click", (e) => {
        e.preventDefault();
        for(let i = 0; i < labelsM.length; i++){
            if(labelsM[i].parentNode.classList.contains("TabLabel-Selected")){
                labelsM[i].parentNode.classList.remove("TabLabel-Selected");
                if(!labelsM[i].parentNode.classList.contains("TabLabel-Unselected")){
                    labelsM[i].parentNode.classList.add("TabLabel-Unselected");
                }
            }
        }
        if(!e.target.parentNode.classList.contains("TabLabel-Selected")){
            e.target.parentNode.classList.add("TabLabel-Selected");
            showNoticeContentM(e.target.parentNode);
        }
    })
})




// 공지사항 제목 클릭 시 상세 내용 표시 관련 js
// 임시 데이터이므로 첫 번째 공지사항 글에만 적용했습니다.
/////////////////////
// 웹
const noticeTitles = new Array(document.querySelector(".NoticeTitle-1"), document.querySelector(".NoticeTitle-2"), document.querySelector(".NoticeTitle-3"));
const noticeContents = document.querySelectorAll(".Notice-ContentWrapper");

for(let i = 0; i < noticeTitles.length; i++){
    noticeTitles[i].addEventListener("click", (e) => {
        e.preventDefault();
        if(e.target.parentNode.style.borderBottom != "none"){
            e.target.parentNode.style.borderBottom = "none";
            e.target.style.fontWeight = "bolder";
            noticeContents[i].style.display = "block";
        } else {
            e.target.parentNode.style.borderBottom = "1px solid rgb(230, 230, 230)";
            e.target.style.fontWeight = "bold";
            noticeContents[i].style.display = "none";
        }
    })
}




// 앱
const noticeTitlesM = new Array(document.querySelector(".Notice-Title-Mobile-1"), document.querySelector(".Notice-Title-Mobile-2"), document.querySelector(".Notice-Title-Mobile-3"));
const noticeContentsM = document.querySelectorAll(".Notice-ContentWrapper-Mobile");

for(let i = 0; i < noticeTitlesM.length; i++){
    noticeTitlesM[i].addEventListener("click", (e) => {
        e.preventDefault();
        if(e.target.parentNode.style.borderBottom != "none"){
            e.target.parentNode.style.borderBottom = "none";
            e.target.style.fontWeight = "bolder";
            noticeContentsM[i].style.display = "block";
        } else {
            e.target.parentNode.style.borderBottom = "1px solid rgb(230, 230, 230)";
            e.target.style.fontWeight = "bold";
            noticeContentsM[i].style.display = "none";
        }
    })
}
