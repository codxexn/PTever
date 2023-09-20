NodeList.prototype.map = Array.prototype.map;
globalThis.flag = new Array([false, false, false, false, false, false, false, false]);

const inputNickName = document.querySelector("input[name=nickname]");
const inputPhoneNum = document.querySelector("input[name=mobileNumber]");
const certificationBtn = document.querySelector(".certification-Btn");
const inputCertificationNum = document.querySelector("input[name=verificationCode]");
const certificationBtn2 = document.querySelector(".certification-Btn2"); 
const agreementBtn = document.querySelector(".agreement-Btn");

// 모두 동의
const all = document.querySelector("input[name=check-All]");
const terms = document.querySelectorAll("input[name=check]");
const noneDisabledCheckbox = document.querySelectorAll("input[type=checkbox]");

// mobile
const inputNickNameMobile = document.querySelector(".form-InputNickName-mobile");
const inputPhoneNumMobile = document.querySelector(".form_InputPhoneNum-mobile");
const certificationBtnMobile = document.querySelector(".certification-Btn-mobile");
const inputCertificationNumMobile = document.querySelector(".form_InputCheckNum-mobile");
const certificationBtn2Mobile = document.querySelector(".certification-Btn2-mobile"); 
const agreementBtnMobile = document.querySelector(".agreement-Btn-mobile");


// mobile
const allMobile = document.querySelector("input[name=check-All-mobile]");
const termsMobile = document.querySelectorAll("input[name=check-mobile]");
const noneDisabledCheckboxMobile = document.querySelectorAll("input[type=checkbox]");




// 휴대폰 번호 입력시 인증번호 전송 버튼 disabled 사라지게 하는 js
inputPhoneNum.addEventListener("keyup", (e) => {
    if(!e.target.value){
        globalThis.flag[0] = false;
    } else {
        globalThis.flag[0] = true;
    }
    if(globalThis.flag[0]){
        certificationBtn.disabled = false;
    } else{
        certificationBtn.disabled = true;
    }
});




inputCertificationNum.addEventListener("keyup", (e) => {
    if(!e.target.value){
        globalThis.flag[1] = false;
    } else {
        globalThis.flag[1] = true;
    }
    if(globalThis.flag[1]){
        certificationBtn2.disabled = false;
    } else{
        certificationBtn2.disabled = true;
    }
});

// agreement

function repeatCheck() {
    const checkBox = document.getElementById("all");
    if(checkBox.checked) {
        agreementBtn.disabled = false;
    } 
}

inputNickName.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPhoneNum.value || !inputCertificationNum.value) {
        globalThis.flag[2] = false;
        // 아닌 경우 disabled = true
        noneDisabledCheckbox.forEach((check) => {
            check.disabled = true;
        });
        agreementBtn.disabled = true;
    } else {
        globalThis.flag[2] = true;
        // 동의버튼은 input 3곳에 값이 다 들어가 있을 때 disabled가 해제되게 함
        noneDisabledCheckbox.forEach((check) => {
            check.disabled = false;
        });
        repeatCheck();
    }

    if(globalThis.flag[2]) {
        all.addEventListener("click", (e) => {
            const checked = e.target.checked;
            if(checked) {
                terms.forEach((term) => {
                    term.checked = true;
                });
                agreementBtn.disabled = false;
            } else {
                terms.forEach((term) => {
                    term.checked = false;
                });
                agreementBtn.disabled = true;
            }
        });
    
        terms.forEach((term) => {
            term.addEventListener("click", () => {
             all.checked = terms.map((term) => term.checked).filter((checked) => checked).length == 3;
             if(all.checked) {
                agreementBtn.disabled = false;
             } else {
                all.checked = false;
                agreementBtn.disabled = true;
             }
            });
        });
        
    }
});

inputPhoneNum.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputNickName.value || !inputCertificationNum.value) {
        globalThis.flag[2] = false;
        // 아닌 경우 disabled = true
        noneDisabledCheckbox.forEach((check) => {
            check.disabled = true;
        });
        agreementBtn.disabled = true;
    } else {
        globalThis.flag[2] = true;
        // 동의버튼은 input 3곳에 값이 다 들어가 있을 때 disabled가 해제되게 함
        noneDisabledCheckbox.forEach((check) => {
            check.disabled = false;
        });
        repeatCheck();
    }

    if(globalThis.flag[2]) {
        all.addEventListener("click", (e) => {
            const checked = e.target.checked;
            if(checked) {
                terms.forEach((term) => {
                    term.checked = true;
                });
                agreementBtn.disabled = false;
            } else {
                terms.forEach((term) => {
                    term.checked = false;
                });
                agreementBtn.disabled = true;
            }
        });
    
        terms.forEach((term) => {
            term.addEventListener("click", () => {
             all.checked = terms.map((term) => term.checked).filter((checked) => checked).length == 3;
             if(all.checked) {
                agreementBtn.disabled = false;
             } else {
                all.checked = false;
                agreementBtn.disabled = true;
             }
            });
        });
    } 


});


inputCertificationNum.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputNickName.value || !inputPhoneNum.value) {
        globalThis.flag[2] = false;
        // 아닌 경우 disabled = true
        noneDisabledCheckbox.forEach((check) => {
            check.disabled = true;
        });
        agreementBtn.disabled = true;
    } else {
        globalThis.flag[2] = true;
        // 동의버튼은 input 3곳에 값이 다 들어가 있을 때 disabled가 해제되게 함
        noneDisabledCheckbox.forEach((check) => {
            check.disabled = false;
        });
        repeatCheck();
    }

    if(globalThis.flag[2]) {
        all.addEventListener("click", (e) => {
            const checked = e.target.checked;
            if(checked) {
                terms.forEach((term) => {
                    term.checked = true;
                });
                agreementBtn.disabled = false;
            } else {
                terms.forEach((term) => {
                    term.checked = false;
                });
                agreementBtn.disabled = true;
            }
        });
    
        terms.forEach((term) => {
            term.addEventListener("click", () => {
             all.checked = terms.map((term) => term.checked).filter((checked) => checked).length == 3;
             if(all.checked) {
                agreementBtn.disabled = false;
             } else {
                all.checked = false;
                agreementBtn.disabled = true;
             }
            });
        });
    }


});







// 반응형


function repeatCheckMobile() {
    const checkBoxMobile = document.getElementById("all-mobile");
    if(checkBoxMobile.checked) {
        agreementBtnMobile.disabled = false;
    } 
}


// 휴대폰 번호 입력시 인증번호 전송 버튼 disabled 사라지게 하는 js
inputPhoneNumMobile.addEventListener("keyup", (e) => {
    if(!e.target.value){
        globalThis.flag[3] = false;
    } else {
        globalThis.flag[3] = true;
    }
    if(globalThis.flag[3]){
        certificationBtnMobile.disabled = false;
    } else{
        certificationBtnMobile.disabled = true;
    }
});


inputCertificationNumMobile.addEventListener("keyup", (e) => {
    if(!e.target.value){
        globalThis.flag[4] = false;
    } else {
        globalThis.flag[4] = true;
    }
    if(globalThis.flag[4]){
        certificationBtn2Mobile.disabled = false;
    } else{
        certificationBtn2Mobile.disabled = true;
    }
});

// 체크버튼

// 모두 동의

// 전체 동의를 완성하라.



inputNickNameMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputPhoneNumMobile.value || !inputCertificationNumMobile.value) {
        globalThis.flag[5] = false;
        noneDisabledCheckboxMobile.forEach((check) => {
            check.disabled = true;
        });
    } else {
        globalThis.flag[5] = true;
        noneDisabledCheckboxMobile.forEach((check) => {
            check.disabled = false;
        });
        repeatCheckMobile();
    }

    if(globalThis.flag[5]) {
        allMobile.addEventListener("click", (e) => {
            const checkedMobile = e.target.checked;
            if(checkedMobile) {
                termsMobile.forEach((term) => {
                    term.checked = true;
                });
                agreementBtnMobile.disabled = false;
            } else {
                termsMobile.forEach((term) => {
                    term.checked = false;
                });
                agreementBtnMobile.disabled = true;
            }
        });
    
        termsMobile.forEach((term) => {
            term.addEventListener("click", () => {
             allMobile.checked = termsMobile.map((term) => term.checked).filter((checked) => checked).length == 3;
             if(allMobile.checked) {
                agreementBtnMobile.disabled = false;
             } else {
                allMobile.checked = false;
                agreementBtnMobile.disabled = true;
             }
            });
        });
    }

});

inputPhoneNumMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputNickNameMobile.value || !inputCertificationNumMobile.value) {
        globalThis.flag[5] = false;
        noneDisabledCheckboxMobile.forEach((check) => {
            check.disabled = true;
        });
    } else {
        globalThis.flag[5] = true;
        noneDisabledCheckboxMobile.forEach((check) => {
            check.disabled = false;
        });
        repeatCheckMobile();
    }

    if(globalThis.flag[5]) {
        allMobile.addEventListener("click", (e) => {
            const checkedMobile = e.target.checked;
            if(checkedMobile) {
                termsMobile.forEach((term) => {
                    term.checked = true;
                });
                agreementBtnMobile.disabled = false;
            } else {
                termsMobile.forEach((term) => {
                    term.checked = false;
                });
                agreementBtnMobile.disabled = true;
            }
        });
    
        termsMobile.forEach((term) => {
            term.addEventListener("click", () => {
             allMobile.checked = termsMobile.map((term) => term.checked).filter((checked) => checked).length == 3;
             if(allMobile.checked) {
                agreementBtnMobile.disabled = false;
             } else {
                allMobile.checked = false;
                agreementBtnMobile.disabled = true;
             }
            });
        });
    }

});


inputCertificationNumMobile.addEventListener("keyup", (e) => {
    if(!e.target.value || !inputNickNameMobile.value || !inputPhoneNumMobile.value) {
        globalThis.flag[5] = false;
        noneDisabledCheckboxMobile.forEach((check) => {
            check.disabled = true;
        });
    } else {
        globalThis.flag[5] = true;
        noneDisabledCheckboxMobile.forEach((check) => {
            check.disabled = false;
        });
        repeatCheckMobile();
    }

    if(globalThis.flag[5]) {
        allMobile.addEventListener("click", (e) => {
            const checkedMobile = e.target.checked;
            if(checkedMobile) {
                termsMobile.forEach((term) => {
                    term.checked = true;
                });
                agreementBtnMobile.disabled = false;
            } else {
                termsMobile.forEach((term) => {
                    term.checked = false;
                });
                agreementBtnMobile.disabled = true;
            }
        });
    
        termsMobile.forEach((term) => {
            term.addEventListener("click", () => {
             allMobile.checked = termsMobile.map((term) => term.checked).filter((checked) => checked).length == 3;
             if(allMobile.checked) {
                agreementBtnMobile.disabled = false;
             } else {
                allMobile.checked = false;
                agreementBtnMobile.disabled = true;
             }
            });
        });
    }

});


// test

// allMobile.addEventListener("click", () => {
//     const checkedMobile = e.target.checked;
//     if(checkedMobile) {
//         termsMobile.checked = true;
//     }
//     termsMobile.forEach((term) => {
//     term.checked = allMobile.checked;
//   });

// });

// termsMobile.forEach((term) => {
//   term.addEventListener("click", (e) => {
//     allMobile.checked =
//     termsMobile.map((term) => term.checked).filter((checked) => checked)
//         .length == 3;
//   });
// });

// all.addEventListener("click", (e) => {
//     const checked = e.target.checked;
//     if(checked) {
//         terms.forEach((term) => {
//             term.checked = true;
//         });
//         agreementBtn.disabled = false;
//     } else {
//         terms.forEach((term) => {
//             term.checked = false;
//         });
//         agreementBtn.disabled = true;
//     }
// });

// terms.forEach((term) => {
//     term.addEventListener("click", () => {
//      all.checked = terms.map((term) => term.checked).filter((checked) => checked).length == 3;
//      if(all.checked) {
//         agreementBtn.disabled = false;
//      } else {
//         all.checked = false;
//         agreementBtn.disabled = true;
//      }
//     });
// });