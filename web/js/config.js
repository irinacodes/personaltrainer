require.config({
  paths: {
    bootstrap: 'lib/bootstrap/dist/js/bootstrap',
    grunt: 'lib/grunt/lib/grunt',
    jquery: 'lib/jquery/dist/jquery',
    knockout: 'lib/knockout/dist/knockout',
    requirejs: 'lib/requirejs/require',
    underscore: 'lib/underscore/underscore'
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

