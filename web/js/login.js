jQuery(document).ready(function ($) {
    $('#loginform').submit(function (event) {
        event.preventDefault();

        showMeYourCookies('At loginform submission');

        var cookie = JSON.parse($.cookie('helloween'));
        var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
        $.ajax({
            //by default, Spring Security exposes a “/login” service which accepts form data to submit credentials
            //the form parameters must be named “username” and “password” for this to work out-of-the box
            data: data,
            headers: {'X-CSRF-TOKEN': cookie.csrf},
            timeout: 1000,
            type: 'POST',
            url: '/login'

        }).done(function(data, textStatus, jqXHR) {
            showMeYourJqXHR('When loginform is done', jqXHR);
            showMeYourCookies('When loginform is done');

            window.location = cookie.url;

        }).fail(function(jqXHR, textStatus, errorThrown) {
            showMeYourJqXHR('When loginform fails', jqXHR);
            showMeYourCookies('When loginform fails');

            console.error('Booh! Wrong credentials, try again!');
        });
    });
});