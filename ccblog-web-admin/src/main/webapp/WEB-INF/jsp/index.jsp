<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>CCBLOG</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="js/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="js/assets/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="js/assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="js/assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body>


<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar">柴畅</span>
               <%-- <span class="icon-bar"></span>
                <span class="icon-bar"></span>--%>
            </button>
            <a class="navbar-brand" href="/" style="font-size:x-large">CCBLOG后台</a>
        </div>

        <div class="header-right">

            <a href="logout" class="btn btn-danger" title="Logout"><i class="fa fa-user fa-2x"></i>退出</a>

        </div>
    </nav>
    <!-- 左边个人信息+多级导航  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">



                <li>
                    <a class="active-menu" href="/"><i class="fa fa-dashboard "></i>主页</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-book"></i>用户管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#"><i class="fa fa-desktop "></i>全部用户 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-code "></i>添加用户</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-lock"></i>文章管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/articleIndex" target="iframeBox"><i class="fa fa-toggle-on"></i>全部文章</a>
                        </li>
                        <li>
                            <a href="/editArticle" target="iframeBox"><i class="fa fa-bell "></i>写文章</a>
                        </li>
                        <li>
                            <a href="/draftsIndex" target="iframeBox"><i class="fa fa-circle-o "></i>草稿箱</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="http://www.jq22.com/demo/html5Csss201802041853" target="iframeBox"><i class="fa fa-bug "></i>评论管理</a>
                </li>

                <li>
                    <a href="/categoryIndex"  target="iframeBox"><i class="fa fa-flash "></i>分类管理 </a>

                </li>

                <li>
                    <a href="/tagIndex" target="iframeBox"><i class="fa fa-anchor "></i>标签管理</a>
                </li>

                <li>
                    <a href="#"><i class="fa fa-book"></i>链接管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">

                        <li>
                            <a href="/linkIndex" target="iframeBox"><i class="fa fa-desktop "></i>全部链接 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-code "></i>添加链接</a>
                        </li>

                    </ul>
                </li>


                <li>
                    <a href="#"><i class="fa fa-book"></i>公告管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/noticeIndex" target="iframeBox"><i class="fa fa-desktop "></i>全部公告 </a>
                        </li>
                        <li>
                            <a href="/editNotice" target="iframeBox"><i class="fa fa-code "></i>添加公告</a>
                        </li>

                    </ul>
                </li>


                <li>
                    <a href="/buttonIndex" target="iframeBox"><i class="fa fa-sign-in "></i>自定义按钮</a>
                </li>


                <li>
                    <a href="#"><i class="fa fa-square-o "></i>设置</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#"><i class="fa fa-desktop "></i>网站描述</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-code "></i>菜单</a>
                        </li>

                    </ul>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">

            <iframe src="/mainTest" height="100%" width="100%" id="iframeBox" scrolling="no" name="iframeBox" class="-o-box9" frameborder="0"></iframe>
            <!--/.ROW-->

        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

<div id="footer-sec">
    Copyright &copy; 2016.Company name All rights reserved.More Templates <a target="_blank" title="CCBLOG">CCBLOG</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
</div>


<!-- JQUERY SCRIPTS -->
<script src="js/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="js/assets/js/bootstrap.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="js/assets/js/jquery.metisMenu.js"></script>
<script src="js/assets/js/wizard/jquery.steps.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="js/assets/js/custom.js"></script>




<script>

   /* $(function () {

        $("#page-inner").load('mainTest');
    })

    var menuClick = function(menuUrl) {

        $("#page-inner").load(menuUrl);
    };
*/
   /*function setIframeHeight(iframe) {
       if (iframe) {
           var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
           if (iframeWin.document.body) {
               iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
           }
       }
   };

   window.onload = function () {
       setIframeHeight(document.getElementById('iframeBox'));
   };
*/
   /*var iframe = document.getElementById('iframeBox');
   if (iframe.attachEvent){
       iframe.attachEvent("onload", function(){
           layer.msg('加载中', {
               icon: 16
               ,shade: 0.01
           });
       });
   }*/
   /*else {
       iframe.onload = function(){
           layer.close(layer.index);
       };
   }*/


    $('a').bind('click', function(){
        $('a').removeClass('active-menu');
        $(this).addClass('active-menu');
    });


</script>
</body>
</html>
