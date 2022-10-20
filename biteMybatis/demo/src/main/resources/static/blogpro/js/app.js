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
