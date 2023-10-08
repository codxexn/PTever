// 데스크탑 버전 헤더, 모바일 버전 헤더 가져오기
const headerDeskTop = document.querySelector(".NavBar-wrapper");
const headerMobile = document.querySelector(".Header-Mobile");
const navMobile = document.querySelector(".BottomBar-Wrapper");

// 브라우저 크기 변화 감지
function checkMobile() {
    if (window.innerWidth <= 768) {
        headerDeskTop.style.display = "none";
        headerMobile.style.display = "block";
        navMobile.style.display = "flex";
    } else {
        headerDeskTop.style.display = "block";
        headerMobile.style.display = "none";
        navMobile.style.display = "none";
    }
}


// 페이지 로드 및 브라우저 크기 변화 시 함수 호출
window.addEventListener("load", checkMobile);
window.addEventListener("resize", checkMobile);

// 검색창 클릭 시 변화입니다.(웹)
const searchbar = document.querySelectorAll(".SearchForm")[0];
const searchInput = document.querySelectorAll(".SearchInput")[0];
const fadeWrapper = document.querySelectorAll(".FadeWrapper")[0];

// input 태그(검색창)에 focus 이벤트 발생 시(onfocus) 실행됩니다.
function showKeywordSearch(){
    searchbar.style.border = "1px solid rgb(51, 151, 255)";
    searchbar.style.backgroundColor = "white";
    fadeWrapper.style.display = "block";
}

// 반대로 blur 이벤트 발생 시(onblur) 실행됩니다.
function hideKeywordSearch(){
    searchbar.style.border = "none";
    searchbar.style.backgroundColor = "rgb(244, 244, 244)";
    fadeWrapper.style.display = "none";
}

// 앱에서 검색창 클릭 시 변화입니다.
const searchbarMobile = document.querySelectorAll(".SearchForm")[1];
const searchInputMobile = document.querySelectorAll(".SearchInput")[1];
const fadeWrapperMobile = document.querySelector(".FadeWrapper-Mobile")
const cancelButton = document.querySelector(".SearchCancelButton");

// input 태그(검색창)에 focus 이벤트 발생 시(onfocus) 실행됩니다.
function showKeywordSearchMobile(){
    searchbarMobile.style.backgroundColor = "white";
    fadeWrapperMobile.style.display = "block";
    cancelButton.style.display = "inline-block";
}

// 취소 버튼 클릭 시 (onclick) 실행됩니다.
function hideKeywordSearchMobile(){
    searchbarMobile.style.backgroundColor = "rgb(244, 244, 244)";
    fadeWrapperMobile.style.display = "none";
    cancelButton.style.display = "none";
}

// 검색 인풋 태그에 입력 후 엔터시 함수 실행
const inputElement = document.querySelector(".SearchInput");

inputElement.addEventListener("keyup", (e) => {
    if(e.keyCode === 13) {
        let keyword = inputElement.value;


        // form 엘리먼트 생성
        let formElement = document.createElement("form");

        let keywordInput = document.createElement("input");
        keywordInput.setAttribute("type", "hidden");
        keywordInput.setAttribute("name", "keyword");
        keywordInput.setAttribute("value", keyword)

        // from의 method와 action 속성을 설정
        formElement.setAttribute("method", "get");
        formElement.setAttribute("action", "/search-results/search");

        formElement.setAttribute("target", "_self"); 

        // form에 input 엘리먼트 추가합니다.
        formElement.appendChild(keywordInput);

        // form을 body에 추가하고 submit 합니다.
        document.body.appendChild(formElement);
        formElement.submit();
    }


})