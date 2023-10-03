const heartButtonContainer = document.querySelectorAll(".CardProductWishWrapper");

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

// heartButtonContainer.forEach((container) => {
//     let firstImg = container.firstElementChild.children[0];
//     let secondImg = container.firstElementChild.children[1];
//
//     firstImg.addEventListener("click", (e) => {
//         e.preventDefault();
//         firstImg.style.visibility = "hidden";
//         secondImg.style.visibility = "visible";
//     });
//
//     secondImg.addEventListener("click", (e) => {
//         e.preventDefault();
//         secondImg.style.visibility = "hidden";
//         firstImg.style.visibility = "visible";
//     });
// });