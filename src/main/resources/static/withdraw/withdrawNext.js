const inputField = document.querySelector(".InputField");
const warning = document.querySelector(".Warning");
const button = document.querySelector(".ButtonWrapper");
const final = document.querySelector(".FinalAgreement");

function deleteAccount(seq){
  Swal.fire({
    title: '정말 탈퇴를 진행하시겠습니까?',
    text: "탈퇴를 진행하시면 계정 상태를 복구할 수 없습니다.",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: '탈퇴',
    cancelButtonText: '취소'
  }).then((result) => {
    if (result.value) {
            //"삭제" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다. 
    }
  })
}

button.addEventListener("click", (e) => {
  if(!inputField.value) {
    inputField.focus();
    warning.innerText = "본인 확인을 위해 비밀번호를 입력해주세요.";
    warning.style.color = "red";
    return;
  } else {
    warning.innerText = "";
    deleteAccount();
  }
})