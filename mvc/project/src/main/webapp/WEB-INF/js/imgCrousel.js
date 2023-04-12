let image= Array.from(document.getElementsByClassName("imgCarousel"));
let mainphoto = document.getElementById("mainPhoto");
function updateimage(event){
    let image=event.target;
    mainphoto.src=image.src;
}
image.forEach(function(image){
    image.addEventListener('click',updateimage);
});