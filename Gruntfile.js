var SRC_PATH = 'src/main/webapp/WEB-INF/';
var BUILD_DIR = 'src/main/webapp/static/';
var path = require('path');

module.exports = function(grunt) {

  //reset if you want to uglify files
  debug = true;

  grunt.initConfig({

    pkg: grunt.file.readJSON('package.json'),

    //validate all custom js files
    jshint: {
      all: [SRC_PATH + 'js/**/*.js', '!'+ SRC_PATH + 'js/lib/**/*.js'],
      options: {
        force: true
      }
    },

    //compress css files
    cssmin: {
      build: {
        files: {
          'src/main/webapp/static/personatrainer.min.css': [ SRC_PATH + 'css/*.css' ]
        }
      }
    },

    //minify image files
    imagemin: {
      dynamic: {
        files: [{
          expand: true,
          cwd: SRC_PATH + 'img',
          src: '{,*/}**/*.{png,jpg,jpeg}',
          dest: BUILD_DIR + 'images'
        }]
      }
    },

    //automagically wire up installed Bower components into requireJS config
    bowerRequirejs: {
      target: {
        rjsConfig: SRC_PATH + 'js/config.js'
      }
    },

    watch: {
      scripts: {
        files: [SRC_PATH + '/**'],
        tasks: ['jshint', 'cssmin', 'imagemin', 'requirejs'],
        options: {
          livereload: true,
          spawn: false
        }
      }
    },

    //copy html files to maven dist dir
    copy: {
      main: {
        files: [
          { cwd: SRC_PATH,  // set working folder / root to copy
            src: ['*.html'],           // copy all html files
            dest: BUILD_DIR,    // destination folder
            expand: true,           // required when using cwd
            flatten: false // keep directory structure
          }
        ]
      }
    },

    //concatenate and uglify requirejs dependencies
    requirejs: {
      compile: {
        options: {
          baseUrl: 'src/main/webapp/WEB-INF/js',
          mainConfigFile: "src/main/webapp/WEB-INF/js/config.js",
          name: 'main',
          wrap: true,
          preserveLicenseComments: false,
          optimize: debug ? 'none' : 'uglify2',
          out: 'src/main/webapp/static/personaltrainer.min.js'
        }
      }
    },

    mavenPrepare: {
      options: {
        resources: ['**']
      }
    },

    watch: {
      maven: {
        files: [],
        tasks: 'default'
      }
    }
  });


  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-imagemin');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-requirejs');
  grunt.loadNpmTasks('grunt-bower-requirejs');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-maven');


  //Automatically load grunt tasks from package.json
  //require('load-grunt-tasks')(grunt);

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('default', ['mavenPrepare', 'jshint', 'cssmin', 'imagemin', 'requirejs', 'copy']);

};