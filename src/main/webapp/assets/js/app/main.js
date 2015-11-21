require(['user', 'blog/post'], function(u, p){
    var user = new u(), post = new p();
    post.makePost();
});
