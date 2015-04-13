$('.checkbox').click(function() {
  $('.adminFields')[this.checked ? "show" : "hide"]();
});