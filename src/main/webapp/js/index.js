$(document).ready(function($) {
    showMeYourCookies('When index document is ready');

    $.ajax({
        type: 'GET',
        url: '/rest/user/hello'

    }).done(function (data, textStatus, jqXHR) {
        showMeYourJqXHR('When GET /rest/hello is done', jqXHR);
        showMeYourCookies('When GET /rest/hello is done');

        var csrfToken = jqXHR.getResponseHeader('X-CSRF-TOKEN');
        if (csrfToken) {
            var cookie = JSON.parse($.cookie('hello'));
            cookie.csrf = csrfToken;
            $.cookie('hello', JSON.stringify(cookie));
        }

        $('#message').html(data.message);

    }).fail(function (jqXHR, textStatus, errorThrown) {
        showMeYourJqXHR('When GET /rest/user/hello fails', jqXHR);
        showMeYourCookies('When GET /rest/user/hello fails');

        if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
            var cookie = JSON.stringify({method: 'GET', url: '/', csrf: jqXHR.getResponseHeader('X-CSRF-TOKEN')});
            $.cookie('hello', cookie);

            window.location = '/login.html';

        } else {
            console.error('Houston, we have a problem...');
        }
    });

    $('#postButton').on('click', function () {
        event.preventDefault();

        showMeYourCookies('When postButton is clicked');

        var cookie = JSON.parse($.cookie('hello'));
        $.ajax({
            data: {},
            headers: {'X-CSRF-TOKEN': cookie.csrf},
            timeout: 1000,
            type: 'POST',
            url: '/rest/hellopost'

        }).done(function(data, textStatus, jqXHR) {
            showMeYourJqXHR('When POST /rest/hellopost is done', jqXHR);
            showMeYourCookies('When POST /rest/hellopost is done');

            console.info("POST succeeded!!!");

        }).fail(function(jqXHR, textStatus, errorThrown) {
            showMeYourJqXHR('When POST /rest/hellopost fails', jqXHR);
            showMeYourCookies('When POST /rest/hellopost fails');

            console.error('Problems when posting...');
        });
    });

    $('#logoutButton').on('click', function (event) {
        event.preventDefault();

        showMeYourCookies('When logoutButton is clicked');

        var cookie = JSON.parse($.cookie('hello'));
        $.ajax({
            data: {},
            headers: {'X-CSRF-TOKEN': cookie.csrf},
            timeout: 1000,
            type: 'POST',
            url: '/logout'

        }).done(function(data, textStatus, jqXHR) {
            showMeYourJqXHR('When POST /logout is done', jqXHR);
            showMeYourCookies('When POST /logout is done');

            console.info('congratulations, you have logged out!');

            window.location = '/';

        }).fail(function(jqXHR, textStatus, errorThrown) {
            showMeYourJqXHR('When POST /logout fails', jqXHR);
            showMeYourCookies('When POST /logout fails');

            console.error('Help! I cannot get out of here!');
        });
    });
});