<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
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
<nav class="breadcrumb" style="padding-bottom: 0px;padding-top: 0px;">
    <a class="crumbs" href="/">
        <i class="fa fa-home"></i>首页</a>
    <i class="fa fa-angle-right"></i>
    搜索 <span style="color: red">${query}</span> 找到 <span style="color: red">${pageInfo.list.size()}</span> 个与之相关的文章
</nav>
<%--面包屑导航 end--%>

<div class="clear" style="height: 5px"></div>

    <%--博客主体 start--%>
    <section id="content" class="site-content shadow">
        <%--博客主体-左侧正文 start--%>
        <section id="primary" class="content-area">

            <main id="main" class="site-main" role="main">
                <ul class="search-page">
                    <c:choose>
                        <c:when test="${pageInfo.list.size()!=0}">
                            <c:forEach items="${pageInfo.list}" var="a">
                                <li class="search-inf">
                                    <fmt:formatDate value="${a.articlePostTime}" pattern="yyyy年MM月dd日"/>
                                </li>
                                <li class="entry-title">
                                    <a href="/article/${a.articleId}" rel="bookmark">
                                            ${a.articleTitle}
                                    </a>
                                </li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <br>
                            很遗憾，没有查询到带有 <font style="color: red;"> ${query} </font> 的内容，换一个关键词再试试吧。
                            <br> <br>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </main>


            <%--分页总信息--%>
            <div class="col-md-6">
                当前${pageInfo.pageNum}页,总${pageInfo.pages}页，总${pageInfo.total}条记录
            </div>
            <%--分页按钮栏--%>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="/search/${query}/pn/1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}" >
                        <li>
                            <a href="/search/${query}/pn/${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;上一页</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num==pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num!=pageInfo.pageNum}">
                            <li><a href="/search/${query}/pn/${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}" >
                        <li>
                            <a href="/search/${query}/pn/${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">下一页&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="/search/${query}/pn/${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>

        </section>
            <%--右侧导航栏，基本信息等等--%>
            <jsp:include page="sidebar_other.jsp"/>
    </section>
    <%--右侧导航栏，基本信息等等--%>
    <jsp:include page="sidebar_other.jsp"/>
<%--底部信息--%>
<jsp:include page="footer.jsp"/>
<script src="/js/assets/js/jquery.min.js"></script>
<script src="/js/script.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="/js/superfish.js"></script>
<script opacity='1' zIndex="-2" count="150" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>

</body>
</html>
