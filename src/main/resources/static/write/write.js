const textarea = document.getElementsByClassName('WritePage_TextArea');
const button = document.getElementsByClassName('buttonOff');


const title = document.getElementById("title");
const content = document.getElementById("content");

const freePost = document.getElementById("freePost")
const transaction = document.getElementById("transaction");
const checkbox = Array.from(document.getElementsByClassName('checkboxItem_Wrapper')); // HTMLCollection을 배열로 변환



// 버튼 키고 끄기
function buttonOn(button){
  button.querySelector('.CheckboxItem_Box').classList.add('CheckboxItem_Box_Select');
  button.querySelector('.CheckboxItem_Box').classList.remove('CheckboxItem_Box');
  button.querySelector('.CheckboxItem_Input').checked = true;
}

function buttonOff(button){
  if (button) {
    const checkboxBox = button.querySelector('.CheckboxItem_Box_Select');
    if (checkboxBox) {
      checkboxBox.classList.add('CheckboxItem_Box');
      checkboxBox.classList.remove('CheckboxItem_Box_Select');
    }
    const checkboxInput = button.querySelector('.CheckboxItem_Input');
    if (checkboxInput) {
      checkboxInput.checked = false;
    }
  }
}


checkbox.forEach(button => {
  button.addEventListener("click", function() {
    if (button.querySelector('.CheckboxItem_Box_Select')) {
      return true;
    } else if (button.querySelector('.CheckboxItem_Box')) {
      buttonOn(button);
      checkbox.forEach(otherButton => {
        if (otherButton !== button && otherButton.querySelector('.CheckboxItem_Box_Select')) {
          buttonOff(otherButton);
        }
      });
    }
  });
});


let titleFlag = false;
let contentFlag = false;

title.addEventListener("keyup", function(){
  // if(!title.value) titleFlag = true;
  // else titleFlag = false;

  console.log(isEmpty(title.value))
  console.log(isEmpty(content.value))
  if(!isEmpty(title.value) && !isEmpty(content.value)) {
    // button[0].style.backgroundColor = rgb(51, 151, 255);
    console.log(isEmpty(title.value));
    console.log(isEmpty(content.value));
    button[0].style.backgroundColor = 'rgb(51, 151, 255)';
    button[0].removeAttribute('disabled')
  }else {
    console.log(isEmpty(title.value));
    console.log(isEmpty(content.value));
    button[0].style.backgroundColor = 'rgb(221, 221, 221)';
    button[0].setAttribute('disabled', 'true');
  }

})

content.addEventListener("keyup", function(){
  //  if (!isEmpty(content.value)) contentFlag = true;
  //  else contentFlag = false;

  console.log(title.value)
  console.log(content.value)


  if(!isEmpty(title.value) && !isEmpty(content.value)) {
    button[0].style.backgroundColor = 'rgb(51, 151, 255)';
    button[0].removeAttribute('disabled')
    console.log(isEmpty(title.value));
    console.log(isEmpty(content.value));
  }else if(isEmpty(content.value)) {
    button[0].style.backgroundColor = 'rgb(221, 221, 221)';
    button[0].setAttribute('disabled')
    console.log(isEmpty(title.value));
    console.log(isEmpty(content.value));
  }
})

function isEmpty(target){
 if( target == null || target == undefined || target == ''){
  return true;
 }
 else{
  return false;
 }
}

