// 카테고리 클릭 시 색상 및 아래 내용 전환

///////////////////////
// 웹

const labels = document.querySelectorAll(".pc .TabLabelsWrapper a");
const allContent = document.querySelector(".pc .FAQ-FadeWrapper1");
const helpContent = document.querySelector(".pc .FAQ-FadeWrapper2");
const infoContent = document.querySelector(".pc .FAQ-FadeWrapper3");
const payContent = document.querySelector(".pc .FAQ-FadeWrapper4");
const couponContent = document.querySelector(".pc .FAQ-FadeWrapper5");
const applyContent = document.querySelector(".pc .FAQ-FadeWrapper6");
const etcContent = document.querySelector(".pc .FAQ-FadeWrapper7");


function showFAQContent(label) {
    if(label.classList.contains("AllLabel")){
        allContent.style.display = "block";
        helpContent.style.display = "none";
        infoContent.style.display = "none";
        payContent.style.display = "none";
        couponContent.style.display = "none";
        applyContent.style.display = "none";
        etcContent.style.display = "none";
    } else if(label.classList.contains("HelpLabel")){
        allContent.style.display = "none";
        helpContent.style.display = "block";
        infoContent.style.display = "none";
        payContent.style.display = "none";
        couponContent.style.display = "none";
        applyContent.style.display = "none";
        etcContent.style.display = "none";
    } else if(label.classList.contains("InfoLabel")){
        allContent.style.display = "none";
        helpContent.style.display = "none";
        infoContent.style.display = "block";
        payContent.style.display = "none";
        couponContent.style.display = "none";
        applyContent.style.display = "none";
        etcContent.style.display = "none";
    } else if(label.classList.contains("PayLabel")){
        allContent.style.display = "none";
        helpContent.style.display = "none";
        infoContent.style.display = "none";
        payContent.style.display = "block";
        couponContent.style.display = "none";
        applyContent.style.display = "none";
        etcContent.style.display = "none";
    } else if(label.classList.contains("CouponLabel")){
        allContent.style.display = "none";
        helpContent.style.display = "none";
        infoContent.style.display = "none";
        payContent.style.display = "none";
        couponContent.style.display = "block";
        applyContent.style.display = "none";
        etcContent.style.display = "none";
    } else if(label.classList.contains("ApplyLabel")){
        allContent.style.display = "none";
        helpContent.style.display = "none";
        infoContent.style.display = "none";
        payContent.style.display = "none";
        couponContent.style.display = "none";
        applyContent.style.display = "block";
        etcContent.style.display = "none";
    } else {
        allContent.style.display = "none";
        helpContent.style.display = "none";
        infoContent.style.display = "none";
        payContent.style.display = "none";
        couponContent.style.display = "none";
        applyContent.style.display = "none";
        etcContent.style.display = "block";
    }
}

labels.forEach((label) => {
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
            showFAQContent(e.target.parentNode);
        }
    })
})

//////////////////////////////
// 앱
const labelsM = document.querySelectorAll(".mobile .TabLabelsWrapper-Mobile a");
const allContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile1");
const helpContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile2");
const infoContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile3");
const payContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile4");
const couponContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile5");
const applyContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile6");
const etcContentM = document.querySelector(".mobile .FAQ-FadeWrapper-Mobile7");


function showFAQContentM(label) {
    if(label.classList.contains("AllLabel")){
        allContentM.style.display = "block";
        helpContentM.style.display = "none";
        infoContentM.style.display = "none";
        payContentM.style.display = "none";
        couponContentM.style.display = "none";
        applyContentM.style.display = "none";
        etcContentM.style.display = "none";
    } else if(label.classList.contains("HelpLabel")){
        allContentM.style.display = "none";
        helpContentM.style.display = "block";
        infoContentM.style.display = "none";
        payContentM.style.display = "none";
        couponContentM.style.display = "none";
        applyContentM.style.display = "none";
        etcContentM.style.display = "none";
    } else if(label.classList.contains("InfoLabel")){
        allContentM.style.display = "none";
        helpContentM.style.display = "none";
        infoContentM.style.display = "block";
        payContentM.style.display = "none";
        couponContentM.style.display = "none";
        applyContentM.style.display = "none";
        etcContentM.style.display = "none";
    } else if(label.classList.contains("PayLabel")){
        allContentM.style.display = "none";
        helpContentM.style.display = "none";
        infoContentM.style.display = "none";
        payContentM.style.display = "block";
        couponContentM.style.display = "none";
        applyContentM.style.display = "none";
        etcContentM.style.display = "none";
    } else if(label.classList.contains("CouponLabel")){
        allContentM.style.display = "none";
        helpContentM.style.display = "none";
        infoContentM.style.display = "none";
        payContentM.style.display = "none";
        couponContentM.style.display = "block";
        applyContentM.style.display = "none";
        etcContentM.style.display = "none";
    } else if(label.classList.contains("ApplyLabel")){
        allContentM.style.display = "none";
        helpContentM.style.display = "none";
        infoContentM.style.display = "none";
        payContentM.style.display = "none";
        couponContentM.style.display = "none";
        applyContentM.style.display = "block";
        etcContentM.style.display = "none";
    } else {
        allContentM.style.display = "none";
        helpContentM.style.display = "none";
        infoContentM.style.display = "none";
        payContentM.style.display = "none";
        couponContentM.style.display = "none";
        applyContentM.style.display = "none";
        etcContentM.style.display = "block";
    }
}

labelsM.forEach((label) => {
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
            showFAQContentM(e.target.parentNode);
        }
    })
})


// 자주 묻는 질문 제목 클릭 시 상세 내용 표시 관련 js
// 임시 데이터이므로 첫 번째 질문글에만 적용했습니다.

// 웹

const questions = new Array(document.querySelector(".Question1"), document.querySelector(".Question2"), document.querySelector(".Question3"),
    document.querySelector(".Question4"), document.querySelector(".Question5"), document.querySelector(".Question6"),
    document.querySelector(".Question7"));
const replyContents = document.querySelectorAll(".FAQ-ReplyWrapper");

for(let i = 0; i < questions.length; i++){
    questions[i].addEventListener("click", (e) => {
        e.preventDefault();
        if(e.target.style.borderBottom != "none"){
            e.target.style.borderBottom = "none";
            e.target.style.fontWeight = "bolder";
            replyContents[i].style.display = "block";
        } else {
            e.target.style.borderBottom = "1px solid rgb(230, 230, 230)";
            e.target.style.fontWeight = "bold";
            replyContents[i].style.display = "none";
        }
    })
}

// 앱
const questionsM = new Array(document.querySelector(".Question-Mobile1"), document.querySelector(".Question-Mobile2"), document.querySelector(".Question-Mobile3"),
    document.querySelector(".Question-Mobile4"), document.querySelector(".Question-Mobile5"), document.querySelector(".Question-Mobile6"),
    document.querySelector(".Question-Mobile7"));
const replyContentsM = document.querySelectorAll(".FAQ-ReplyWrapper-Mobile");

for(let i = 0; i < questionsM.length; i++){
    questionsM[i].addEventListener("click", (e) => {
        e.preventDefault();
        if(e.target.style.borderBottom != "none"){
            e.target.style.borderBottom = "none";
            e.target.style.fontWeight = "bolder";
            replyContentsM[i].style.display = "block";
        } else {
            e.target.style.borderBottom = "1px solid rgb(230, 230, 230)";
            e.target.style.fontWeight = "bold";
            replyContentsM[i].style.display = "none";
        }
    })
}
