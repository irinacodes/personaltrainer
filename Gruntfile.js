module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    concat: {
      options: {
        separator: ';'
      },
      dist: {
        src: ['src/**/*.js'],
        dest: 'dist/production.js'
      }
    },

    uglify: {
      build: {
        src: 'dist/personaltrainer.js',
        dest: 'dist/personaltrainer.min.js'
      }

    },
    jshint: {
      files: ['Gruntfile.js', 'src/**/*.js', 'test/**/*.js']
    },

    bower_concat: {
      all: {
        dest: 'dist/bower.js',
        cssDest: 'dist/bower.css',
        dependencies: {
          'underscore': 'jquery',
          'backbone': 'underscore'
        },
        bowerOptions: {
          relative: false
        }
      }
    },
    less: {
      development: {
        options: {
          paths: ["assets/css"]
        },
        files: {
          "dist/development.css": "assets/css/**/*.less"
        }
      },
      production: {
        options: {
          paths: ["assets/css"],
          cleancss: true
        },
        "dist/development.css": "assets/css/**/*.less"
      },
      wiredep: {
        task: {
          src: ['src/main/webapp/index.html']
        }
      }
    },
    cssmin: {
      target: {
        files: [{
          expand: true,
          cwd: 'src/main/webapp/assets/css',
          src: ['*.css', '!*.min.css'],
          dest: 'dist/css',
          ext: '.min.css'
        }]
      }
    },
    imagemin: {
      dynamic: {
        files: [{
          expand: true,
          cwd: 'src/main/webapp/assets/images/',
          src: ['**/*.{png,jpg,gif}'],
          dest: 'dist/images'
        }]
      }
    },
    watch: {
      scripts: {
        files: ['src/main/webapp/assets/js/*.js'],
        tasks: ['concat', 'uglify', 'less'],
        options: {
          livereload: true,
          spawn: false
        }
      }
    }
  });

  //grunt.loadNpmTasks('grunt-contrib-uglify');
  //grunt.loadNpmTasks('grunt-contrib-jshint');
  //grunt.loadNpmTasks('grunt-contrib-concat');
  //grunt.loadNpmTasks('grunt-bower-concat');
  //grunt.loadNpmTasks('grunt-contrib-less');
  //grunt.loadNpmTasks('grunt-wiredep');
  //grunt.loadNpmTasks('grunt-contrib-cssmin');
  //grunt.loadNpmTasks('grunt-contrib-imagemin');
  //grunt.loadNpmTasks('grunt-contrib-watch');

  require('load-grunt-tasks')(grunt);

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('default', [ 'cssmin', 'concat', 'uglify', 'less', 'wiredep', 'imagemin']);

};