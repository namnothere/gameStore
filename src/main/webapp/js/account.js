$(document).ready(function() {
    $("#show_hide_password_2 a").on('click', function(event) {
        event.preventDefault();
        if($('#show_hide_password_2 input').attr("type") == "text"){
            $('#show_hide_password_2 input').attr('type', 'password');
            $('#show_hide_password_2 i').addClass( "fa-eye-slash" );
            $('#show_hide_password_2 i').removeClass( "fa-eye" );
        }else if($('#show_hide_password_2 input').attr("type") == "password"){
            $('#show_hide_password_2 input').attr('type', 'text');
            $('#show_hide_password_2 i').removeClass( "fa-eye-slash" );
            $('#show_hide_password_2 i').addClass( "fa-eye" );
        }
    });

    $("#show_hide_password a").on('click', function(event) {
        event.preventDefault();
        if($('#show_hide_password input').attr("type") == "text"){
            $('#show_hide_password input').attr('type', 'password');
            $('#show_hide_password i').addClass( "fa-eye-slash" );
            $('#show_hide_password i').removeClass( "fa-eye" );
        }else if($('#show_hide_password input').attr("type") == "password"){
            $('#show_hide_password input').attr('type', 'text');
            $('#show_hide_password i').removeClass( "fa-eye-slash" );
            $('#show_hide_password i').addClass( "fa-eye" );
        }
    });
    
    
});


var setButtonState = function () {
    if ($("#user-name-email").val().trim() == "" || $("#login-password").val().trim() == "") {
        $("#button-login").attr("disabled", true);
    }
    else {
        $("#button-login").removeAttr("disabled");
    }
}
$("#user-name-email").bind("input propertychange change keyup paste select", setButtonState);
$("#login-password").bind("input propertychange change keyup paste select", setButtonState);
setButtonState();