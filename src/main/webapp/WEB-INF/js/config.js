require.config({
  paths: {
    bootstrap: 'lib/bootstrap/dist/js/bootstrap',
    grunt: 'lib/grunt/lib/grunt',
    jquery: 'lib/jquery/dist/jquery',
    knockout: 'lib/knockout/dist/knockout',
    requirejs: 'lib/requirejs/require',
    underscore: 'lib/underscore/underscore',
    html5shiv: 'lib/html5shiv/dist/html5shiv',
    'jquery-birthday-picker': 'lib/jquery-birthday-picker/jquery-birthday-picker.js',
    'jquery.easing': 'lib/jquery.easing/js/jquery.easing',
    respond: 'lib/respond/dest/respond.src'
  },
  shim: {
    jquery: {
      exports: '$'
    },
    underscore: {
      exports: '_'
    }
  },
  packages: [

  ]
});

require(["main"]);

