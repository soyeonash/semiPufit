$(document).ready(function () {
  $(document).on("click", "#navbar_toogleBtn", function () {
    $(".navbar_side").toggleClass("active");
  });

  $(document).on("click", ".navbar_logo", function () {
    location.reload();
  });
});