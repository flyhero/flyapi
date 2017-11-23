function setCookie(cname,cvalue,exdays){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = cname+"="+cvalue+"; "+expires;
}
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}
function checkCookie(){
    var user=getCookie("isLogin");
    if (user == "true"){
        $("#login-state").append('  <div class="flyhero-user" >\n' +
            '            <div class="user-hover" style="width: 80px;height: 65px;" data-dropdown="#dropdown-standard">\n' +
            '                <a class="avatar dropdown" href="">\n' +
            '                    <img src="../res/images/avatar/flyhero.jpg">\n' +
            '                </a>\n' +
            '            </div>\n' +
            '\n' +
            '            <div class="dropdown-menu dropdown-anchor-top-left dropdown-has-anchor" id="dropdown-standard">\n' +
            '                <ul>\n' +
            '                    <li><a href="http://www.flyapi.cn:8090/flyapi-web/forword/go?html=/user/home">主页</a></li>\n' +
            '                    <li><a href="http://www.flyapi.cn:8090/flyapi-web/user/go?html=/user/set">设置</a></li>\n' +
            '                    <li><a href="http://www.flyapi.cn:8090/flyapi-web/user/go?html=/user/logout">退出</a></li>\n' +
            '                    &lt;!&ndash;<li class="divider"></li>&ndash;&gt;\n' +
            '                    <li><a href="#">反馈</a></li>\n' +
            '                </ul>\n' +
            '            </div>\n' +
            '        </div>');
    }
    else {
        alert("未登录 ");
        $("#login-state").append('  <div class="nav-user" >\n' +
            '            <a class="unlogin" href=""><i class="iconfont icon-touxiang"></i></a>\n' +
            '            <span>\n' +
            '                <a href="http://www.iflyapi.cn:8090/flyapi-web/forward/go?html=login.html">登入</a>\n' +
            '                <a href="../user/login.html">注册</a>\n' +
            '            </span>\n' +
            '        </div>');
    }
}
checkCookie();