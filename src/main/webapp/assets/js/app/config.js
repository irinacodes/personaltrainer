require.config({
    baseUrl: 'lib',
    paths : {
        backbone : 'backbone',
        underscore : 'underscore',
        jquery : 'jquery',
        knockout: 'knockout'
    },
    shim : {
        jquery : {
            exports : '$'
        },
        underscore : {
            exports : '_'
        },
        backbone : {
            deps : ['jquery', 'underscore'],
            exports : 'Backbone'
        }
    }
});