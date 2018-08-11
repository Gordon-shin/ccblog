<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/11/011
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <link href="js/assets/css/font-awesome.css" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="css/zui.css">
    <style> body {
        background-image: url(images/4.jpg);
    }</style>
</head>
<body>
<div id="main-box"></div>
<div id="main-content">
    <div class="login-body  animated fadeInLeft">
        <div class="login-main pr">
            <form action="logincheck" method="post" class="login-form">
                <h3> CCBLOG后台管理 </h3>
                <h5 style="padding-bottom: 10px"> 这是一首简单的小情歌 </h5>
                <!-- 账号登陆 -->
                <div id="MobileBox" class="item-box">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-user"></i>
                        </span>
                        <input type="text" name="username" class="form-control" data-rules="required"
                               placeholder="用户名/QQ号" value="admin">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-lock"></i>
                        </span>
                        <input type="password" name="password" class="form-control" data-rules="required"
                               placeholder="密码" value="123456">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-volume-up"></i>
                        </span>
                        <input type="password" name="kaptcha" class="form-control" data-rules="required"
                               placeholder="验证码">
                    </div>
                    <div class="form-group input-group" style="margin-bottom: 20px;">
                        <div class="yanzma" style="border: 0px;position: relative;">
                            <img src="/kaptcha.jpg" class="captcha" id="J_captcha" style="cursor:pointer;"/>
                            &nbsp;&nbsp;<span style="cursor:pointer;"
                                              onclick="document.getElementById('J_captcha').src='/kaptcha.jpg?'+Math.floor(Math.random()*100);"><font style="color: white">换一个</font></span>
                        </div>
                    </div>

                    <div class="login_btn_panel">
                        <button class=" btn btn-primary btn-block btn-lg" data-ajax="post" type="submit"
                                data-callback="success">登录
                        </button>
                        <div class="check-tips"></div>
                    </div>

                </div>
            </form>
        </div>
    </div>


</div>
</body>
</html>
