<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/20
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    文章归档
    <i class="fa fa-angle-right"></i>
    正文
</nav>
<%--面包屑导航 end--%>

<div id="content" class="site-content" style="transform: none;">
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <ul class="search-page">
                <c:forEach items="${articleList}" var="a">
                    <li class="search-inf">
                       <fmt:formatDate value="${a.articlePostTime}" pattern="yyyy年MM月dd日"/>
                    </li>
                    <li class="entry-title">
                        <a href="/article/${a.articleId}" style="text-decoration: none">${a.articleTitle}</a>
                    </li>
                </c:forEach>
            </ul>
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
