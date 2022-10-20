function checkLogin() {
    $.ajax({
        type: "get",
        url: "/user/check",
        success: function (body) {
        },
        error: function (body) {
            location.assign("blog_login.html");
        },
    });
}
var userId = 0;
function logOut() {
    $.ajax({
        type: "get",
        url: "/user/logout",
        success: function (body) {
        },
        error: function (body) {
            location.assign("blog_login.html");
        },
    });
}
