<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/19
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <!-- BOOTSTRAP STYLES-->
    <%--<link href="/js/assets/css/bootstrap.css"  rel="stylesheet" type='text/css' />
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/js/font-awesome/css/font-awesome.min.css">--%>
    <link href="/js/assets/css/bootstrap.css"  rel="stylesheet" type='text/css' />
    <link href="/css/style.css"  rel="stylesheet" type='text/css' />
    <link href="/js/font-awesome/css/font-awesome.min.css"  rel="stylesheet" type='text/css' />
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
            <a class="crumbs" href="/" style="text-decoration: none" >
                <i class="fa fa-home"></i>首页</a>
            <i class="fa fa-angle-right"></i>
            <c:choose>
                <c:when test="${pageInfo.list!=null}">
                    <c:choose>
                        <c:when test="${pageInfo.list.size()!=0}">
                            <c:if test="${pageInfo.list[0].categoryCustomList[0].categoryId}==${category.categoryId}">
                                <a href="/cat/${pageInfo.list[0].categoryCustomList[0].categoryId}" style="text-decoration: none" >${pageInfo.list[0].categoryCustomList[0].categoryName}</a>
                            </c:if>
                            <a href="/cat/${pageInfo.list[0].categoryCustomList[0].categoryId}">${pageInfo.list[0].categoryCustomList[0].categoryName}</a>
                            <i class="fa fa-angle-right"></i>
                            <a href="/cat/${category.categoryId}" style="text-decoration: none" >${category.categoryName}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="/cat/${category.categoryId}" style="text-decoration: none" >${category.categoryName}</a>
                        </c:otherwise>
                    </c:choose>
                    <i class="fa fa-angle-right"></i>
                    文章
                </c:when>
                <c:otherwise>
                    该分类不存在
                </c:otherwise>
            </c:choose>
        </nav>
        <%--面包屑导航 end--%>

<div id="content" class="site-content" style="transform: none;">
    <div id="primary" class="content-area" style="float: left;">
        <main id="main" class="site-main">
            <c:choose>
                <c:when test="${pageInfo.list!=null}">
                    <c:choose>
                        <c:when test="${pageInfo.list.size()!=0}">
                            <%--文章列表-start--%>
                            <c:forEach items="${pageInfo.list}" var="a">
                                <article  class="post type-post">
                                    <figure class="thumbnail">
                                        <a href="/article/${a.articleId}" style="text-decoration: none" >
                                            <img width="280" height="210"
                                                 src="http://47.98.63.217/images/ccblog/article_imgs/timthumb${a.articleId}.jpg"
                                                 class="attachment-content size-content wp-post-image"
                                                 alt="${a.articleTitle}">
                                        </a>
                                        <span class="cat">
                                <a href="/cat/${a.categoryCustomList[a.categoryCustomList.size()-1].categoryId}" style="text-decoration: none" >
                                        ${a.categoryCustomList[a.categoryCustomList.size()-1].categoryName}
                                </a>
                            </span>
                                    </figure>

                                    <header class="entry-header">
                                        <h2 class="entry-title">
                                            <div class="about-name">
                                                <a href="/article/${a.articleId}" style="text-decoration: none" >
                                                        ${a.articleTitle}
                                                </a>
                                            </div>
                                        </h2>
                                    </header>

                                    <div class="entry-content">
                                        <div class="archive-content">
                                                ${fn:substring(a.articleContent,0 ,100 )}...
                                        </div>
                                        <span class="title-l"></span>
                                        <span class="new-icon">
                                    <c:choose>
                                        <c:when test="${a.articleStatus==2}">
                                            <i class="fa fa-bookmark-o"></i>
                                        </c:when>
                                        <c:otherwise>
                                            <jsp:useBean id="nowDate" class="java.util.Date"/>
                                            <c:set var="interval"
                                                   value="${nowDate.time - a.articlePostTime.time}"/><%--时间差毫秒数--%>
                                            <fmt:formatNumber value="${interval/1000/60/60/24}" pattern="#0"
                                                              var="days"/>
                                            <c:if test="${days <= 7}">NEW</c:if>
                                        </c:otherwise>
                                    </c:choose>


                                </span>
                                        <span class="entry-meta">
                                    <span class="date">
                                        <fmt:formatDate value="${a.articlePostTime}" pattern="yyyy年MM月dd日"/>
                                    &nbsp;&nbsp;
                                    </span>
                                    <span class="views">
                                        <i class="fa fa-eye"></i>
                                            ${a.articleViewCount} views
                                    </span>
                                    <span class="comment">&nbsp;&nbsp;
                                        <a href="/article/${a.articleId}#comments" rel="external nofollow" style="text-decoration: none" >
                                          <i class="fa fa-comment-o"></i>
                                            <c:choose>
                                                <c:when test="${a.articleCommentCount==0}">
                                                    发表评论
                                                </c:when>
                                                <c:otherwise>
                                                    ${a.articleCommentCount}
                                                </c:otherwise>
                                            </c:choose>

                                        </a>
                                    </span>
                                </span>
                                        <div class="clear"></div>
                                    </div><!-- .entry-content -->

                                    <span class="entry-more">
                                <a href="/article/${a.articleId}"
                                   rel="bookmark" style="text-decoration: none" >
                                    阅读全文
                                </a>
                            </span>
                                </article>
                            </c:forEach>
                            <%--文章列表-end--%>
                        </c:when>
                        <c:otherwise>
                            <section class="no-results not-found">
                                <div class="post">
                                    <p>该分类目前还没有文章！</p>
                                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                                </div>
                            </section>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <section class="no-results not-found">
                        <div class="post">
                            <p>该分类不存在</p>
                            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>

        </main>
    <%--分页总信息--%>
    <div class="col-md-6">
        当前${pageInfo.pageNum}页,总${pageInfo.pages}页，总${pageInfo.total}条记录
    </div>

    <%--分页按钮栏--%>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li><a href="/cat/${category.categoryId}/pn/1">首页</a></li>
            <c:if test="${pageInfo.hasPreviousPage}" >
                <li>
                    <a href="/cat/${category.categoryId}/pn/${pageInfo.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;上一页</span>
                    </a>
                </li>
            </c:if>
            <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                <c:if test="${page_Num==pageInfo.pageNum}">
                    <li class="active"><a href="#">${page_Num}</a></li>
                </c:if>
                <c:if test="${page_Num!=pageInfo.pageNum}">
                    <li><a href="/cat/${category.categoryId}/pn/${page_Num}">${page_Num}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${pageInfo.hasNextPage}" >
                <li>
                    <a href="/cat/${category.categoryId}/pn/${pageInfo.pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">下一页&raquo;</span>
                    </a>
                </li>
            </c:if>
            <li><a href="/cat/${category.categoryId}/pn/${pageInfo.pages}">末页</a></li>
        </ul>
    </nav>
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
