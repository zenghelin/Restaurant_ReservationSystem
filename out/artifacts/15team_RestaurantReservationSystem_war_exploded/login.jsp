<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录注册</title>
    <link rel="stylesheet" type="text/css" href="lib/css/login/style.css"/>
    <link rel="stylesheet" type="text/css" href="lib/css/login/body.css"/>
    <link rel="stylesheet" type="text/css" href="lib/css/login/login.css"/>
</head>
<body>

<div style="text-align: center"><img src="lib/images/login/login_title.png"></div>
<div class="container">
    <section id="content">
        <form id="loginForm" action="login" method="post">
            <h1>登录页面</h1>
            <div>
                <input type="text" name="username" value="111" required="" id="username"/>
            </div>
            <div>
                <input type="password" name="password" value="222" required="" id="password"/>
            </div>
            角&nbsp色:<input type="radio" name="role" value="顾客" checked="checked">顾客
            <input type="radio" name="role" value="经理">经理<br>
            <div class="login_error_tips">
                <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
            </div>
            <div>
                <input type="submit" value="登录" class="btn btn-primary"
                       id="js-btn-login"/> <a href="#">经理默认用户名跟密码前面加一个m</a>
            </div>
        </form>
        <!-- form -->
        <div class="button">
            <a href="#">@Fifteen.Order.com</a>
        </div>
        <!-- button --> </section>
    <!-- content -->
</div>
</body>
</html>
