<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/3/003
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录页面</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="js/assets/css/bootstrap.css" rel="stylesheet" type='text/css' />

    <link href="js/bootstrapValidator.css">
    <!-- FONTAWESOME STYLES-->
    <link href="js/assets/css/font-awesome.css" rel="stylesheet" type='text/css' />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

    <%--给body一个背景图，整个页面--%>
    <style type="text/css">
        body{
            background-image: url("images/loginBackground.jpg");
            background-size:cover;
        }
    </style>
</head>
<body>
<%--<div id="box"></div>--%>
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <img src="js/assets/img/logo-invoice.png" />
        </div>
    </div>
    <div class="row ">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
            <div class="panel-body">
               <%-- <%
                    String username = "";
                    String password = "";
                    //获取当前站点的所有Cookie
                    Cookie[] cookies = request.getCookies();
                    for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
                        if ("username".equals(cookies[i].getName())) {
                            username = cookies[i].getValue();
                        } else if ("password".equals(cookies[i].getName())) {
                            password = cookies[i].getValue();
                        }
                    }
                %>--%>
                <form role="form" id="loginform" name="loginform" action="logincheck" method="post">
                    <hr />
                    <h5>Enter Details to Login</h5>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                        <input type="text" class="form-control"  name="username" id="username" value="" placeholder="请填写用户名 " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                        <input type="password" class="form-control" name="password" id="password" value=""  placeholder="请填写密码" />
                    </div>
                    <div class="form-group input-group" >
                        <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                        <input type="text"  class="form-control" id="kaptcha" placeholder="请输入验证码" />
                    </div>
                    <div class="form-group input-group" style="margin-bottom: 20px;">
                        <div class="yanzma" style="border: 0px;position: relative;">
                            <img src="/kaptcha.jpg" class="captcha" id="J_captcha" style="cursor:pointer;" />
                            &nbsp;&nbsp;<span style="cursor:pointer;" onclick="document.getElementById('J_captcha').src='/kaptcha.jpg?'+Math.floor(Math.random()*100);">换一个</span>
                        </div>
                    </div>
                    <%--<div class="form-group">
                        <label class="checkbox-inline">
                            <input type="checkbox" /> 记住我
                        </label>
                    </div>--%>
                    <div class="form-group input-group" >
                        <input type="submit"  class="btn btn-primary" value="登录" />
                    </div>

                    <%--<a href="login" class="btn btn-primary ">登录</a>--%>
                    <hr />
                </form>
            </div>
        </div>
    </div>
</div>
<%--<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>--%>
</body>
</html>
