// 후기 삭제 버튼 마우스 오버시 이미지 변경
const deleteImgContainer = document.querySelectorAll(".ReviewDeleteButton");

deleteImgContainer.forEach((container) => {
  container.children[0].addEventListener("mouseover", (e) => {
    let target = e.target;
    target.setAttribute("src", "./deleteYes.png");
  });
  container.children[0].addEventListener("mouseout", (e) => {
    let target = e.target;
    target.setAttribute("src", "./delete.png");
  });
});

// 좋아요 버튼 클릭시 이미지 변경 및 span 태그 숫자 1로 변경(DB 연동하면 숫자 가지고 와야 함)
const heartImgContainer = document.querySelectorAll(".ActionGroupLikeButton");

heartImgContainer.forEach((container) => {
  container.children[0].addEventListener("click", (e) => {
    let target = e.target;
    if (target.getAttribute("src") === "./reviewNoHeart.png") {
      target.setAttribute("src", "./reviewHeart.png");
      console.log(container.children[1].textContent);
      container.children[1].textContent = "1";
    } else if (target.getAttribute("src") === "./reviewHeart.png") {
      target.setAttribute("src", "./reviewNoHeart.png");
      container.children[1].textContent = "0";
    }
  });
});

// 후기 사진 화살표 클릭시 다음 사진으로 이동하는 js(수정 필요)
const wholeWrapper = document.querySelectorAll(".ImageArrowButtonWrapper");
const prevButton = document.querySelector(".ReviewImagePrevArrow");
const nextButton = document.querySelector(".ReviewImageNextArrow");
const images = document.querySelectorAll(".ImageWrapper");
let count = 0;

nextButton.addEventListener("click", () => {
  images.forEach((image) => {
    count++;
    image.style.transition = "transform 0s";
    image.style.transform = "translate(-" + 368.63 * count + "px)";
    if (count > 2) {
      count = 2;
      image.style.transition = "transform 0s";
      image.style.transform = "translate(-737.26px)";
    }
  });
});

prevButton.addEventListener("click", () => {
  images.forEach((image) => {
    --count;
    if (count === 1) {
      image.style.transition = "transform 0s";
      image.style.transform = "translate(-368.63px)";
    } else if (count === 0) {
      image.style.transition = "transform 0s";
      image.style.transform = "translate(0px)";
    } else if (count < 0) {
      count = 0;
    }
  });
});
