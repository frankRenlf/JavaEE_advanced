function checkLogin() {
    $.ajax({
        type: "get",
        url: "/user/check",
        success: function (body) {
        },
        error: function (body) {
            alert('invalid login');
            location.assign("blog_login.html");
        },
    });
}
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
