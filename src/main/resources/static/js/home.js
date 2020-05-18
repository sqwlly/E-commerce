window.onload = function() {
    window.onscroll = function () {
        if($('.nav1').offset().top > 100) {
            $('.nav1').addClass('fixed-nav');
        }else{
            $('.nav1').removeClass('fixed-nav');
        }
    };
};
