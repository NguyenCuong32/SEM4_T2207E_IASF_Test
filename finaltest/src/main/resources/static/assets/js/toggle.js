document.addEventListener("DOMContentLoaded", function() {
    var uiBasicToggle = document.querySelector(".ui-basic-toggle");
    var bannerContentToggle = document.querySelector(".banner-content-toggle");
    var uiBasicSubmenu = document.querySelector(".ui-basic-submenu");
    var bannerContentSubmenu = document.querySelector(".banner-content-submenu");

    uiBasicToggle.addEventListener("click", function(e) {
        e.preventDefault();
        uiBasicSubmenu.classList.toggle("show");
    });

    bannerContentToggle.addEventListener("click", function(e) {
        e.preventDefault();
        bannerContentSubmenu.classList.toggle("show");
    });
});