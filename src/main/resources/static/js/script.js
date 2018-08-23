$(function () {
    "use strict";

    /*-----------------------------------
     * FIXED  MENU - HEADER
     *-----------------------------------*/
    function menuscroll() {
        var $navmenu = $('.nav-menu');
        if ($(window).scrollTop() > 50) {
            $navmenu.addClass('is-scrolling');
        } else {
            $navmenu.removeClass("is-scrolling");
        }
    }

    menuscroll();

    $(window).on('scroll', function () {
        menuscroll();
    });

    /*-----------------------------------
     * ONE PAGE SCROLLING
     *-----------------------------------*/
    // Select all links with hashes
    $('a[href*="#"]').not('[href="#"]').not('[href="#0"]').not('[data-toggle="tab"]').on('click', function (event) {
        // On-page links
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            // Figure out element to scroll to
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            // Does a scroll target exist?
            if (target.length) {
                // Only prevent default if animation is actually gonna happen
                event.preventDefault();
                $('html, body').animate({
                    scrollTop: target.offset().top
                }, 1000, function () {
                    // Callback after animation
                    // Must change focus!
                    var $target = $(target);
                    $target.focus();
                    if ($target.is(":focus")) { // Checking if the target was focused
                        return false;
                    } else {
                        $target.attr('tabindex', '-1'); // Adding tabindex for elements not focusable
                        $target.focus(); // Set focus again
                    }
                    ;
                });
            }
        }
    });

    /*-----------------------------------
     * MARK MENU HEADER SELECTED
     *-----------------------------------*/
    function menuHeaderSelected() {

        $('a.nav-link').on('click', function (e) {
            $('a.nav-link').removeClass('active');
            $(this).addClass('active');
        });
    }
    
    menuHeaderSelected();
    
    $('.imagem-premio').slick({
        dots: true,
        infinite: true,
        speed: 300,
        slidesToShow: 1
    });
    
	function sameHeight(where, element){
        var height = [];
        var maxHeight = 0;
        $(where).find(element).each(function(index){
            height[index] = $(this).height();
            if(height[index] > maxHeight){
                maxHeight = height[index];
            }
        }).css('min-height', maxHeight);
    }
 
    /* Fuction with parameters where and what element will have the same height */
    sameHeight('.block-notice', '.retranca');
    sameHeight('.block-notice', '.title');
    sameHeight('.relacionada', '.title');

}); /* End Fn */
