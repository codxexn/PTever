

function checkWindowSize() {
  const body = document.querySelector('body');

  if (body.offsetWidth < 767) {
    window.location.href = 'transaction-App.html';
  } else if (body.offsetWidth > 1024) {
    window.location.href = 'transaction.html';
  }
}

// 페이지 로드 시와 윈도우 크기 변경 시에 checkWindowSize 함수를 실행
//window.addEventListener('load', checkWindowSize);
window.addEventListener('resize', checkWindowSize);
