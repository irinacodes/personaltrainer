/**
 * Starter file to load up the app
 *
 * This will run the client in debug mode. Using non optimized versions of javascript files.
 */
require.config({
    baseUrl: "js"
});
require(["config"],function() {
    require(["main"]);
});
