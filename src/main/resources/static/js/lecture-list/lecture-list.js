const heartButtonContainer = document.querySelectorAll(".CardProductWish");

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