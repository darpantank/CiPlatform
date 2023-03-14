var swiper = new Swiper(".mySwiper", {
    slidesPerView: 4,
    spaceBetween: 10,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    speed: 400,
});
$(".imgCarousel").click(function () { $(".mainPhoto").attr("src", $(this).prop("src")); });
