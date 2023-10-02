
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





const accordionContainers = document.querySelectorAll('.LinkAccordionAccordionContainer');

// 각 AccordionContainer에 대해 클릭 이벤트 리스너를 추가합니다.
accordionContainers.forEach((container) => {
    const accordionContent = container.querySelector('.AccordionContent');

    container.addEventListener('click', () => {
        // 현재 상태를 확인하고 토글합니다.
        if (accordionContent.style.height === '0px' || !accordionContent.style.height) {
            // 텍스트가 포함된 전체 높이를 가져옵니다.
            const autoHeight = accordionContent.scrollHeight + 'px';
            accordionContent.style.height = autoHeight;
        } else {
            // 닫힌 상태로 변경합니다.
            accordionContent.style.height = '0px';
        }
    });
});





