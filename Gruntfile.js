var BUILD_DIR = './dist/';
var path = require('path');

module.exports = function(grunt) {

  debug = true;

  grunt.initConfig({

    pkg: grunt.file.readJSON('package.json'),

    //auto_install: {
    //  local: {},
    //  subdir: {
    //    options: {
    //      cwd: 'subdir',
    //      stdout: true,
    //      stderr: true,
    //      failOnError: true,
    //      npm: '--production'
    //    }
    //  }
    //},

    //validate all custom js files
    jshint: {
      all: ['js/**/*.js', '!js/lib/**'],
      options: {
        force: true
      }
    },

    //concatenate and minify all js files
    //uglify: {
    //  build: {
    //    options: {
    //      mangle: false
    //    },
    //    files: {
    //      'dist/personaltrainer.min.js': [ 'js/**/*.js' ]
    //    }
    //  },
    //  bower: {
    //    options: {
    //      mangle: true,
    //      compress: true
    //    },
    //    files: {
    //      'js/bower.min.js': 'js/bower.js'
    //    }
    //  }
    //},

    //compress css files
    cssmin: {
      build: {
        files: {
          'dist/personatrainer.min.css': [ 'css/*.css' ]
        }
      }
    },

    //minify image files
    imagemin: {
      dynamic: {
        files: [{
          expand: true,
          cwd: './img',
          src: '{,*/}**/*.{png,jpg,jpeg}',
          dest: BUILD_DIR + 'images'
        }]
      }
    },

    watch: {
      scripts: {
        files: ['js/**/*.js'],
        tasks: ['cssmin', 'uglify'],
        options: {
          livereload: true,
          spawn: false
        }
      }
    },

    //automagically wire up installed Bower components into requireJS config
    bowerRequirejs: {
      target: {
        rjsConfig: 'js/config.js'
      }
    },

    //concatenate all bower dependencies into a single file
    bower_concat: {
      all: {
        dest: 'js/bower.js'
      }
    },

    //copy dist folder contents to maven webapp dir
    //copy: {
    //  main: {
    //    files: [
    //      { cwd: 'js',  // set working folder / root to copy
    //        src: ['**/*'],           // copy all files and subfolders
    //        dest: '../src/main/webapp/js',    // destination folder
    //        expand: true,           // required when using cwd
    //        flatten: false // keep directory structure
    //      }
    //    ]
    //  },
    //  separate: {
    //    files: [
    //      { cwd: '.',
    //        src: ['index.html', 'login.html'],
    //        dest: '../src/main/webapp',
    //        expand: true
    //      }
    //    ]
    //  }
    //},

    requirejs: {
      compile: {
        options: {
          baseUrl: 'js',
          paths: {
            'lib': 'lib',
            'jquery': 'lib/jquery/jquery-2.1.1'
          },
          name: 'main',
          wrap: true,
          preserveLicenseComments: false,
          optimize: debug ? 'none' : 'uglify2',
          out: 'dist/personaltrainer.js',
          'onModuleBundleComplete': function (data) {
            var fs = require('fs');
            var amdclean = require('amdclean');
            var outputFile = 'dist/personaltrainer.js';

            fs.writeFileSync(outputFile, amdclean.clean({
                  'filePath': outputFile
                })
            );
          }
        }
      }
    },

    //delete dist folder
    clean: {
      src: [ 'target-grunt'],
      options: {
        force: true //to delete folders outside working dir
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


  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-bower-concat');
  grunt.loadNpmTasks('grunt-contrib-less');
  grunt.loadNpmTasks('grunt-wiredep');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-imagemin');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-requirejs');
  grunt.loadNpmTasks('grunt-bower-requirejs');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-bower-concat');
  grunt.loadNpmTasks('grunt-maven');


  //Automatically load grunt tasks from package.json
  //require('load-grunt-tasks')(grunt);

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('buildbower', ['bower_concat', 'uglify:bower']);

  grunt.registerTask('default', ['mavenPrepare']);

  grunt.registerTask('build', [ 'clean', 'jshint', 'uglify', 'cssmin', 'imagemin', 'copy']);

};