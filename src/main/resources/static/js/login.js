$(document).ready(function(){

    const inputSelector = $('input');

    inputSelector.focus(function(){
        $(this).parents('.form-group').addClass('focused');
    });

    inputSelector.blur(function(){
        let inputValue = $(this).val();
        if ( inputValue === "" ) {
            $(this).removeClass('filled');
            $(this).parents('.form-group').removeClass('focused');
        } else {
            $(this).addClass('filled');
        }
    });
});