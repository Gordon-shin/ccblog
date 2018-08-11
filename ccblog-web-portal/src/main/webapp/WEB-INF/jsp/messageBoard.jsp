<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/20
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="/js/assets/css/bootstrap.css"  rel="stylesheet" type='text/css' />
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/js/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/superfish/1.7.9/css/superfish.css"/>
    <style>
        #primary {
            float: left;
            width: 760px;
            transition-duration: .5s;
        }

        #sidebar {
            float: right;
            width: 28.6%;
        }

        #menu-box {
            background: #fff;
            width: 100%;
            z-index: 999;
            border-bottom: 1px solid #ddd;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.04);
        }

        .fixednav {
            position: fixed;
            top: 0px;
            left: 0px;
            width: 100%;
            z-index: 1;
        }
    </style>
</head>
<body>
<%--公用头部--%>
<jsp:include page="header.jsp"/>
<%--面包屑导航 start--%>
<nav class="breadcrumb">
    <a class="crumbs" href="/">
        <i class="fa fa-home"></i>首页
    </a>
    <i class="fa fa-angle-right"></i>
    留言板
    <i class="fa fa-angle-right"></i>
    正文
</nav>
<%--面包屑导航 end--%>

<div id="content" class="site-content" style="transform: none;">
<div id="primary" class="content-area">
    <main id="main" class="site-main" role="main">
        <article class="post" style="min-height: 500px;">
            <header class="entry-header">
                <h1 class="entry-title">
                    留言板
                </h1>
            </header><!-- .entry-header -->
            <div class="entry-content">
                <div class="single-content">
                    <!--PC版 搜狐畅言测试版-->
                    <div id="SOHUCS" sid="message"></div>
                    <script charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/changyan.js" ></script>
                    <script type="text/javascript">
                        window.changyan.api.config({
                            appid: 'cyqARl5Jo',
                            conf: 'prod_07871915a8107172b3b5dc15a6574ad3'
                        });
                    </script>

                    <%--<p>没域名，没备案，搜狐畅言暂时没法申请。。。</p>--%>
                </div>
                <br><br>

                <footer class="single-footer">
                    <ul class="single-meta">
                        <li class="r-hide">
                            <a href="javascript:pr()" title="侧边栏">
                                <i class="fa fa-caret-left"></i>
                                <i class="fa fa-caret-right"></i>
                            </a>
                        </li>
                    </ul>
                    <ul id="fontsize">
                        <li>A+</li>
                    </ul>
                </footer><!-- .entry-footer -->


                <div class="clear"></div>
            </div><!-- .entry-content -->
        </article><!-- #post -->

    </main>
    <!-- .site-main -->
</div>
    <%--右侧导航栏，基本信息等等--%>
    <jsp:include page="sidebar_other.jsp"/>
</div>
<%--底部信息--%>
<jsp:include page="footer.jsp"/>
<script src="/js/assets/js/jquery.min.js"></script>
<script src="/js/script.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="/js/superfish.js"></script>
<script opacity='1' zIndex="-2" count="150" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>

</body>
</html>
