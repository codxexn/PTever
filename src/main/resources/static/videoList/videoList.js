// 플레이버튼 마우스오버시 이미지 변경
const playButtonContainer = document.querySelectorAll(".VideoPlay");

playButtonContainer.forEach((container) => {
  container.children[0].addEventListener("mouseover", (e) => {
    let target = e.target;
    target.setAttribute("src", "./playMouseover.png");
  });
  container.children[0].addEventListener("mouseout", (e) => {
    let target = e.target;
    target.setAttribute("src", "./playMouseout.png");
  });
});