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