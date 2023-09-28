
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


const toggleButton = document.getElementById('expandButton');
const content = document.getElementById('content');


function toggleContent() {
    if (content.style.height == '657px') {
        content.style.height = 'auto';
    } else {
        content.style.height = '657px';
    }
}

toggleButton.addEventListener('click', toggleContent);