// 찜버튼 클릭 시 하트 모양 바뀌는 js
const heartButtonContainer = document.querySelectorAll(".HeartContainer");

heartButtonContainer.forEach((container) => {
    let firstImg = container.firstElementChild.children[0];
    let secondImg = container.firstElementChild.children[1];

    firstImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        secondImg.style.display = "block";
    });
    secondImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        firstImg.style.display = "block";
    });
});

// 트레이너 찜버튼 클릭 이벤트
const trainerHeartButtonContainer = document.querySelectorAll(".ProfileHeart");

trainerHeartButtonContainer.forEach((container) => {
    let firstImg = container.children[0];
    let secondImg = container.children[1];

    firstImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        secondImg.style.display = "block";
    });
    secondImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        firstImg.style.display = "block";
    });
});
