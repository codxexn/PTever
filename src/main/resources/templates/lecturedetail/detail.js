
// 찜 누르면 하트 빨간색 변경
const heartButtonContainer = document.querySelectorAll(".CardProductWishContainer");

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


// 다시 해야함
// 프레임
const DescriptionSectionDescriptionContainer = document.querySelector(".DescriptionSectionDescriptionContainer");
// 버튼
const DescriptSectionButton = document.querySelectorAll(".ButtonMoreButton");
// 내용
const ProductDescription = document.querySelectorAll(".ProductDescription");

