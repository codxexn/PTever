
const agreementButtonContainer = document.querySelectorAll(".CheckImgWrapper");

agreementButtonContainer.forEach((container) => {
    let firstImg = container.children[0];
    let secondImg = container.children[1];

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