require.config({
  paths: {
    bootstrap: '../bower_components/bootstrap/dist/js/bootstrap',
    grunt: '../bower_components/grunt/lib/grunt',
    jquery: '../bower_components/jquery/dist/jquery',
    knockout: '../bower_components/knockout/dist/knockout',
    requirejs: '../bower_components/requirejs/require',
    underscore: '../bower_components/underscore/underscore'
  },
  shim: {
    jquery: {
      exports: '$'
    },
    underscore: {
      exports: '_'
    }
  },
  packages: []
});

require(["main"]);
