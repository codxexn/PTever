const $images = $(".img-slider img");
let count = 0;
$images.hide();
$images.eq(count).show();

setInterval(function() {
    $images.eq(count++).fadeOut();
    if(count == 6){
        count = 0;
    }
    $images.eq(count).fadeIn();
},  3000);