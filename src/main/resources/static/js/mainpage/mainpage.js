// 메인페이지 웹 메인 슬라이드배너 js입니다.

const mainBanner = document.querySelector(".ImageSlider-ImageTrack");
const currentCount = document.querySelector(".MainBanner-CurrentCount");
let count = 0;
let firstDiv = document.createElement("div");
let lastDiv = document.createElement("div");

// 첫 화면에서는 첫 번째 배너가 보이지만,
// 이 함수가 실행되는 순간 두 번째 배너로 넘어간다.
function autoSlide() {
    // 이동시간 0.5초
    mainBanner.style.transition = "transform 0.5s";
    // 마지막 슬라이드일 때
    // 10번 뒤에 1번을 배치시킨다.
    // 10번에서 1번으로 슬라이드 진행
    // 0s를 줘서 원래 1번 위치로 이동(슬라이드 효과는 안 보임)
    count++;
    if (count == 10) {
        mainBanner.style.transform = "translate(-" + 768 * (count + 1) + "px)";
        setTimeout(function () {
            mainBanner.style.transition = "transform 0s";
            mainBanner.style.transform = "translate(-768px)";
        }, 500);
        count = 0;
    } else {
        mainBanner.style.transform = "translate(-" + 768 * (count + 1) + "px)";
    }
    // 더보기 버튼의 숫자를 업데이트해준다.
    currentCount.innerText = count + 1;
}

// 가장 마지막에 첫 번째 배너를 이어 붙인다.
firstDiv.innerHTML = `<img src="./bannerImages/mainbanner_top1.png">`;
mainBanner.appendChild(firstDiv);

// 가장 첫 번째에 마지막 배너를 이어 붙인다.
lastDiv.innerHTML = `<img src="./bannerImages/mainbanner_top10.png">`;
mainBanner.insertBefore(lastDiv, document.querySelector(".ImageSlider-ImageTrack div"));

// 첫 번째 배너는 10번이니까 왼쪽으로 한 번 밀어서 1번이 보이게 한다.
mainBanner.style.transform = "translate(-768px)";

// 4초마다 슬라이드 이동
let inter = setInterval(autoSlide, 4000);

// 이전 버튼, 다음 버튼 구현
const arrows = document.querySelectorAll(".ImageSlider-Arrow");
let arrowButtonCheck = true;
arrows.forEach((arrow) => {
    arrow.addEventListener("click", function () {
        if (arrowButtonCheck) {
            arrowButtonCheck = false;
            clearInterval(inter);
            mainBanner.style.transition = "transform 0.5s";
            let arrowType = arrow.classList[1];
            if (arrowType == "ImageSlider-PrevArrow") {
                count--;
                if (count == -1) {
                    mainBanner.style.transform = "translate(0px)";
                    setTimeout(function () {
                        mainBanner.style.transition = "transform 0s";
                        mainBanner.style.transform = "translate(-7680px)";
                    }, 500);
                    count = 9;
                } else {
                    mainBanner.style.transform = "translate(-" + 768 * (count + 1) + "px)";
                }
            } else {
                count++;
                if (count == 10) {
                    mainBanner.style.transform = "translate(-" + 768 * (count + 1) + "px)";
                    setTimeout(function () {
                        mainBanner.style.transition = "transform 0s";
                        mainBanner.style.transform = "translate(-768px)";
                    }, 500);
                    count = 0;
                } else {
                    mainBanner.style.transform = "translate(-" + 768 * (count + 1) + "px)";
                }
            }
            inter = setInterval(autoSlide, 4000);
            setTimeout(function () {
                arrowButtonCheck = true;
            }, 500);
        }
        // 더보기 버튼의 숫자를 업데이트해준다.
        currentCount.innerText = count + 1;
    });
});

//////////////////////////////////////////////////
// 슬라이드 배너의 더보기 버튼 클릭 시 배너 상세 팝업 js
const detailBannerButton = document.querySelector(".MainBanner-InfoButton");
const detailBannerInfo = document.querySelector(".FullScreenWrapper");
const detailExitButton = document.querySelector(".MainBannerViewer-Exit");

detailBannerButton.addEventListener("click", () => {
    detailBannerInfo.style.display = "block";
});

detailExitButton.addEventListener("click", () => {
    detailBannerInfo.style.display = "none";
});

//////////////////////////////////////////////////
// 찜버튼 클릭 시 하트 모양 바뀌는 js
const wishButtonContainer = document.querySelectorAll(".CardProduct-WishContainer");

wishButtonContainer.forEach((container) => {
    let firstImg = container.firstElementChild.children[0];
    let secondImg = container.firstElementChild.children[1];

    firstImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        secondImg.style.display = "inline";
    });
    secondImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        firstImg.style.display = "inline";
    });
});

//////////////////////////////////////////////////
// 광고 배너 js입니다.
const adBanner = document.querySelector(".ImageSlider-ImageTrack-Ad");

let countAd = 0;
let firstDivAd = document.createElement("div");
let lastDivAd = document.createElement("div");

// 첫 화면에서는 첫 번째 배너가 보이지만,
// 이 함수가 실행되는 순간 두 번째 배너로 넘어간다.
function autoSlideAd() {
    // 이동시간 0.5초
    adBanner.style.transition = "transform 0.5s";
    // 마지막 슬라이드일 때
    // 2번 뒤에 1번을 배치시킨다.
    // 2번에서 1번으로 슬라이드 진행
    // 0s를 줘서 원래 1번 위치로 이동(슬라이드 효과는 안 보임)
    countAd++;
    if (countAd == 2) {
        adBanner.style.transform = "translate(-" + 768 * (countAd + 1) + "px)";
        setTimeout(function () {
            adBanner.style.transition = "transform 0s";
            adBanner.style.transform = "translate(-768px)";
        }, 500);
        countAd = 0;
    } else {
        adBanner.style.transform = "translate(-" + 768 * (countAd + 1) + "px)";
    }
}

// 가장 마지막에 첫 번째 배너를 이어 붙인다.
firstDivAd.innerHTML = `<img src="./bannerImages/adBanner_1.png">`;
adBanner.appendChild(firstDivAd);

// 가장 첫 번째에 마지막 배너를 이어 붙인다.
lastDivAd.innerHTML = `<img src="./bannerImages/adBanner_2.png">`;
adBanner.insertBefore(lastDivAd, document.querySelector(".ImageSlider-ImageTrack-Ad div"));

// 첫 번째 배너는 2번이니까 왼쪽으로 한 번 밀어서 1번이 보이게 한다.
adBanner.style.transform = "translate(-768px)";

// 4초마다 슬라이드 이동
let interAd = setInterval(autoSlideAd, 4000);

// 이전 버튼, 다음 버튼 구현
const arrowsAd = document.querySelectorAll(".ImageSlider-Arrow-Ad");
let arrowAdButtonCheck = true;
arrowsAd.forEach((arrow) => {
    arrow.addEventListener("click", function () {
        if (arrowAdButtonCheck) {
            arrowAdButtonCheck = false;
            clearInterval(interAd);
            adBanner.style.transition = "transform 0.5s";
            let arrowType = arrow.classList[1];
            if (arrowType == "ImageSlider-PrevArrow-Ad") {
                countAd--;
                if (countAd == -1) {
                    adBanner.style.transform = "translate(0px)";
                    setTimeout(function () {
                        adBanner.style.transition = "transform 0s";
                        adBanner.style.transform = "translate(-1536px)";
                    }, 500);
                    countAd = 1;
                } else {
                    adBanner.style.transform = "translate(-" + 768 * (countAd + 1) + "px)";
                }
            } else {
                countAd++;
                if (countAd == 2) {
                    adBanner.style.transform = "translate(-" + 768 * (countAd + 1) + "px)";
                    setTimeout(function () {
                        adBanner.style.transition = "transform 0s";
                        adBanner.style.transform = "translate(-768px)";
                    }, 500);
                    countAd = 0;
                } else {
                    adBanner.style.transform = "translate(-" + 768 * (countAd + 1) + "px)";
                }
            }
            interAd = setInterval(autoSlideAd, 4000);
            setTimeout(function () {
                arrowAdButtonCheck = true;
            }, 500);
        }
    });
});

//////////////////////////////////////////////////
// 기획전 슬라이드배너 js (얘는 버튼 포함입니다.)

const exBanner = document.querySelector(".ImageSlider-ImageTrack-ex");
const exButtons = document.querySelectorAll(".ImageSlider-DotButtons button");

let countEx = 0,
    temp = exButtons[countEx];
let firstDivEx = document.createElement("div");
let lastDivEx = document.createElement("div");

// 첫 화면에서는 첫 번째 배너가 보이지만,
// 이 함수가 실행되는 순간 두 번째 배너로 넘어간다.
function autoSlideEx() {
    // 이동시간 0.5초
    exBanner.style.transition = "transform 0.5s";
    // 마지막 슬라이드일 때
    // 5번 뒤에 1번을 배치시킨다.
    // 5번에서 1번으로 슬라이드 진행
    // 0s를 줘서 원래 1번 위치로 이동(슬라이드 효과는 안 보임)
    countEx++;
    if (countEx == 5) {
        exButtons[countEx - 1].classList.toggle("ButtonUnselected")
        exBanner.style.transform = "translate(-" + 768 * (countEx + 1) + "px)";
        setTimeout(function () {
            exBanner.style.transition = "transform 0s";
            exBanner.style.transform = "translate(-768px)";
        }, 500);
        countEx = 0;
        exButtons[countEx].classList.toggle("ButtonUnselected")
    } else {
        exButtons[countEx - 1].classList.toggle("ButtonUnselected")
        exButtons[countEx].classList.toggle("ButtonUnselected")
        exBanner.style.transform = "translate(-" + 768 * (countEx + 1) + "px)";
    }
    temp = exButtons[countEx];
}

// 가장 마지막에 첫 번째 배너를 이어 붙인다.
firstDivEx.innerHTML = `<img src="./bannerImages/exbanner_1.png">`;
exBanner.appendChild(firstDivEx);

// 가장 첫 번째에 마지막 배너를 이어 붙인다.
lastDivEx.innerHTML = `<img src="./bannerImages/exbanner_5.png">`;
exBanner.insertBefore(lastDivEx, document.querySelector(".ImageSlider-ImageTrack-ex div"));

// 첫 번째 버튼이 무조건 첫 번째 배너니까 색 변경하고 시작
exButtons[countEx].classList.toggle("ButtonUnselected");

// 첫 번째 배너는 5번이니까 왼쪽으로 한 번 밀어서 1번이 보이게 한다.
exBanner.style.transform = "translate(-768px)";

// 4초마다 슬라이드 이동
let interEx = setInterval(autoSlideEx, 4000);

// 원하는 번호의 배너 보기
// 각 버튼마다 클릭 이벤트 적용
// 버튼을 광클하지 못하게 막아주는 flag
let numberButtonCheck = true;

exButtons.forEach((v, i, btns) => {
    // 각 버튼에 클릭 이벤트를 걸어줌.
    btns[i].addEventListener("click", function () {
        // 아래의 얍삽한 방법으로 인해 0s로 변할 수 있기 때문에 무조건 0.5s로 설정하고 시작
        exBanner.style.transition = "transform 0.5s";
        if (numberButtonCheck) {
            // 0.5초가 지나고 나서 클릭했거나 처음 클릭하거나
            numberButtonCheck = false; // 누르자마자 바로 false
            clearInterval(interEx); // autoSlide 타이머 제거, 동시에 돌아가면 안됨.
            countEx = i; // 클릭한 버튼의 인덱스를 배너의 번호로 설정
            temp.classList.toggle("ButtonUnselected");
            exButtons[countEx].classList.toggle("ButtonUnselected");
            exBanner.style.transform = "translate(-" + 768 * (countEx + 1) + "px)";
            temp = exButtons[countEx];
            interEx = setInterval(autoSlideEx, 4000);
            setTimeout(function () {
                numberButtonCheck = true;
            }, 500);
        }
    });
});

// 이전 버튼, 다음 버튼 구현
const arrowsEx = document.querySelectorAll(".ImageSlider-Arrow-ex");
let arrowExButtonCheck = true;
arrowsEx.forEach((arrow) => {
    arrow.addEventListener("click", function () {
        if (arrowExButtonCheck) {
            arrowExButtonCheck = false;
            clearInterval(interEx);
            exBanner.style.transition = "transform 0.5s";
            let arrowType = arrow.classList[1];
            if (arrowType == "ImageSlider-PrevArrow-ex") {
                countEx--;
                if (countEx == -1) {
                    exBanner.style.transform = "translate(0px)";
                    setTimeout(function () {
                        exBanner.style.transition = "transform 0s";
                        exBanner.style.transform = "translate(-3840px)";
                    }, 500);
                    countEx = 4;
                } else {
                    exBanner.style.transform = "translate(-" + 768 * (countEx + 1) + "px)";
                }
            } else {
                countEx++;
                if (countEx == 5) {
                    exBanner.style.transform = "translate(-" + 768 * (countEx + 1) + "px)";
                    setTimeout(function () {
                        exBanner.style.transition = "transform 0s";
                        exBanner.style.transform = "translate(-768px)";
                    }, 500);
                    countEx = 0;
                } else {
                    exBanner.style.transform = "translate(-" + 768 * (countEx + 1) + "px)";
                }
            }
            temp.classList.toggle("ButtonUnselected");
            temp = exButtons[countEx];
            exButtons[countEx].classList.toggle("ButtonUnselected");
            interEx = setInterval(autoSlideEx, 4000);
            setTimeout(function () {
                arrowExButtonCheck = true;
            }, 500);
        }
    });
});

//////////////////////////////////////////////////

// 메인페이지 앱 메인 슬라이드배너 js입니다.

const mainBannerMobile = document.querySelector(".SlickTrack-Mobile");
const currentCountMobile = document.querySelector(".MainBanner-CurrentCount-Mobile");
let countMobile = 0;
let firstDivMobile = document.createElement("div");
let lastDivMobile = document.createElement("div");

// 첫 화면에서는 첫 번째 배너가 보이지만,
// 이 함수가 실행되는 순간 두 번째 배너로 넘어간다.
function autoSlideMobile() {
    // 이동시간 0.5초
    mainBannerMobile.style.transition = "transform 0.5s";
    // 마지막 슬라이드일 때
    // 8번 뒤에 1번을 배치시킨다.
    // 8번에서 1번으로 슬라이드 진행
    // 0s를 줘서 원래 1번 위치로 이동(슬라이드 효과는 안 보임)
    countMobile++;
    if (countMobile == 8) {
        mainBannerMobile.style.transform = "translate(-" + 100 * (countMobile + 1) + "vw)";
        setTimeout(function () {
            mainBannerMobile.style.transition = "transform 0s";
            mainBannerMobile.style.transform = "translate(-100vw)";
        }, 500);
        countMobile = 0;
    } else {
        mainBannerMobile.style.transform = "translate(-" + 100 * (countMobile + 1) + "vw)";
    }
    // 더보기 버튼의 숫자를 업데이트해준다.
    currentCountMobile.innerText = countMobile + 1;
}

// 가장 마지막에 첫 번째 배너를 이어 붙인다.
firstDivMobile.innerHTML = `<img src="./bannerImages/mainbanner_top1.png">`;
mainBannerMobile.appendChild(firstDivMobile);

// 가장 첫 번째에 마지막 배너를 이어 붙인다.
lastDivMobile.innerHTML = `<img src="./bannerImages/mainbanner_top10.png">`;
mainBannerMobile.insertBefore(lastDivMobile, document.querySelector(".SlickTrack-Mobile div"));

// 첫 번째 배너는 8번이니까 왼쪽으로 한 번 밀어서 1번이 보이게 한다.
mainBannerMobile.style.transform = "translate(-100vw)";

// 4초마다 슬라이드 이동
let interMobile = setInterval(autoSlideMobile, 4000);

/////////////////////////////////////////////////////////////////////////
// (앱) 슬라이드 배너의 더보기 버튼 클릭 시 배너 상세 팝업 js
const detailBannerButtonMobile = document.querySelector(".MainBanner-InfoButton-Mobile");
const detailBannerInfoMobile = document.querySelector(".FullScreenWrapper-Mobile");
const detailExitButtonMobile = document.querySelector(".MainBannerViewer-Exit-Mobile");

detailBannerButtonMobile.addEventListener("click", () => {
    detailBannerInfoMobile.style.display = "block";
});

detailExitButtonMobile.addEventListener("click", () => {
    detailBannerInfoMobile.style.display = "none";
});


////////////////////////////////////////////////////////////
// (앱) 광고 슬라이드배너입니다.
// 광고 배너 js입니다.
const adBannerM = document.querySelector(".ImageSlider-ImageTrack-Ad-Mobile");

let countAdM = 0;
let firstDivAdM = document.createElement("div");
let lastDivAdM = document.createElement("div");

// 첫 화면에서는 첫 번째 배너가 보이지만,
// 이 함수가 실행되는 순간 두 번째 배너로 넘어간다.
function autoSlideAdM() {
    // 이동시간 0.5초
    adBannerM.style.transition = "transform 0.5s";
    // 마지막 슬라이드일 때
    // 2번 뒤에 1번을 배치시킨다.
    // 2번에서 1번으로 슬라이드 진행
    // 0s를 줘서 원래 1번 위치로 이동(슬라이드 효과는 안 보임)
    countAdM++;
    if (countAdM == 2) {
        adBannerM.style.transform = "translate(-" + 90 * (countAdM + 1) + "vw)";
        setTimeout(function () {
            adBannerM.style.transition = "transform 0s";
            adBannerM.style.transform = "translate(-90vw)";
        }, 500);
        countAdM = 0;
    } else {
        adBannerM.style.transform = "translate(-" + 90 * (countAdM + 1) + "vw)";
    }
}

// 가장 마지막에 첫 번째 배너를 이어 붙인다.
firstDivAdM.innerHTML = `<img src="./bannerImages/adBanner_1.png">`;
adBannerM.appendChild(firstDivAdM);

// 가장 첫 번째에 마지막 배너를 이어 붙인다.
lastDivAdM.innerHTML = `<img src="./bannerImages/adBanner_2.png">`;
adBannerM.insertBefore(lastDivAdM, document.querySelector(".ImageSlider-ImageTrack-Ad-Mobile div"));

// 첫 번째 배너는 2번이니까 왼쪽으로 한 번 밀어서 1번이 보이게 한다.
adBannerM.style.transform = "translate(-90vw)";

// 4초마다 슬라이드 이동
let interAdM = setInterval(autoSlideAdM, 4000);


////////////////////////////////////////////////////////////
// (앱) 기획전 슬라이드배너입니다.

const exBannerM = document.querySelector(".ExSlick-Track");
const exButtonsM = document.querySelectorAll(".ImageSlider-DotButtons-Mobile button");

let countExM = 0,
    tempM = exButtonsM[countExM];
let firstDivExM = document.createElement("div");
let lastDivExM = document.createElement("div");

// 첫 화면에서는 첫 번째 배너가 보이지만,
// 이 함수가 실행되는 순간 두 번째 배너로 넘어간다.
function autoSlideExM() {
    // 이동시간 0.5초
    exBannerM.style.transition = "transform 0.5s";
    // 마지막 슬라이드일 때
    // 5번 뒤에 1번을 배치시킨다.
    // 5번에서 1번으로 슬라이드 진행
    // 0s를 줘서 원래 1번 위치로 이동(슬라이드 효과는 안 보임)
    countExM++;
    if (countExM == 5) {
        exButtonsM[countExM - 1].classList.toggle("ButtonUnselected-Mobile")
        exBannerM.style.transform = "translate(-" + 95 * (countExM + 1) + "vw)";
        setTimeout(function () {
            exBannerM.style.transition = "transform 0s";
            exBannerM.style.transform = "translate(-95vw)";
        }, 500);
        countExM = 0;
        exButtonsM[countExM].classList.toggle("ButtonUnselected-Mobile")
    } else {
        exButtonsM[countExM - 1].classList.toggle("ButtonUnselected-Mobile")
        exButtonsM[countExM].classList.toggle("ButtonUnselected-Mobile")
        exBannerM.style.transform = "translate(-" + 95 * (countExM + 1) + "vw)";
    }
    tempM = exButtonsM[countExM];
}

// 가장 마지막에 첫 번째 배너를 이어 붙인다.
firstDivExM.innerHTML = `<img src="./bannerImages/exbanner_mobile_1.png">`;
exBannerM.appendChild(firstDivExM);

// 가장 첫 번째에 마지막 배너를 이어 붙인다.
lastDivExM.innerHTML = `<img src="./bannerImages/exbanner_mobile_5.png">`;
exBannerM.insertBefore(lastDivExM, document.querySelector(".ExSlick-Track div"));

// 첫 번째 버튼이 무조건 첫 번째 배너니까 색 변경하고 시작
exButtonsM[countExM].classList.toggle("ButtonUnselected-Mobile");

// 첫 번째 배너는 5번이니까 왼쪽으로 한 번 밀어서 1번이 보이게 한다.
exBannerM.style.transform = "translate(-95vw)";

// 4초마다 슬라이드 이동
let interExM = setInterval(autoSlideExM, 4000);

// 원하는 번호의 배너 보기
// 각 버튼마다 클릭 이벤트 적용
// 버튼을 광클하지 못하게 막아주는 flag
let numberButtonCheckM = true;

exButtonsM.forEach((v, i, btns) => {
    // 각 버튼에 클릭 이벤트를 걸어줌.
    btns[i].addEventListener("click", function () {
        // 아래의 얍삽한 방법으로 인해 0s로 변할 수 있기 때문에 무조건 0.5s로 설정하고 시작
        exBannerM.style.transition = "transform 0.5s";
        if (numberButtonCheckM) {
            // 0.5초가 지나고 나서 클릭했거나 처음 클릭하거나
            numberButtonCheckM = false; // 누르자마자 바로 false
            clearInterval(interExM); // autoSlide 타이머 제거, 동시에 돌아가면 안됨.
            countExM = i; // 클릭한 버튼의 인덱스를 배너의 번호로 설정
            tempM.classList.toggle("ButtonUnselected-Mobile");
            exButtonsM[countExM].classList.toggle("ButtonUnselected-Mobile");
            exBannerM.style.transform = "translate(-" + 95 * (countExM + 1) + "vw)";
            tempM = exButtonsM[countExM];
            interExM = setInterval(autoSlideExM, 4000);
            setTimeout(function () {
                numberButtonCheckM = true;
            }, 500);
        }
    });
});
