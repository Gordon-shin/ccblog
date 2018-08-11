<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/9/009
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>CCBLOG</title>
    <link rel="stylesheet" href="/js/assets/css/bootstrap.css" type='text/css'/>
    <link rel="stylesheet" href="/css/style.css" type='text/css'/>
    <link rel="stylesheet" href="/js/font-awesome/css/font-awesome.min.css" type='text/css'>
    <link rel="stylesheet" href="https://cdn.bootcss.com/superfish/1.7.9/css/superfish.css" type='text/css'/>
    <link rel="stylesheet" href="/css/load.css">
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

        /*  div {
              width: 555px;
              height: 489px;
              border: #000 solid 1px;
              margin: 50px auto;
              overflow: hidden;
          }*/

        /*指针浮到图片，图片变大。*/
        .outImg {
            cursor: pointer;
            transition: all 0.6s;
        }
        .outImg:hover {
            transform: scale(1.3);
        }

    </style>
</head>
<body>
<%--loanding动画 start--%>
<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
    <div class="load_title">首页加载中</div>
</div>
<%--loading动画 end--%>

<%--<div id="page" class="site" style="transform: none;">--%>
<jsp:include page="header.jsp"/>

<%--面包屑通知--%>
<nav class="breadcrumb" style="padding-top: 0px;">
    <div class="bull" style="margin-top: 5px;"><i class="fa fa-volume-up"></i></div>
    <div id="scrolldiv">
        <div class="scrolltext">
            <ul style="margin-top: 0px;">
                <c:forEach items="${noticeList}" var="n">
                    <li class="scrolltext-title">
                        <a href="/notice/${n.noticeId}" style="text-decoration: none"
                           rel="bookmark">${n.noticeTitle}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>

<div id="content" class="site-content" style="transform: none;">

    <div id="primary" class="content-area" style="float: left;">

        <main id="main" class="site-main" role="main">
            <%--bootstrap轮播图begin--%>
            <div class="panel panel-default" style="height: 300px">
                <div id="carousel-example" class="carousel slide" data-ride="carousel"
                     style="height: 300px">
                    <div class="carousel-inner" style="height: 300px">
                        <div class="item active" style="height: 300px">
                            <a href="http://www.baidu.com" rel="external nofollow">
                                <img class="outImg" src="/js/assets/img/slideshow/1.jpg"
                                     alt="WordPress主题: Begin">
                            </a>
                            <p class="slider-caption">
                                测试轮播图1
                            </p>
                        </div>
                        <div class="item" style="height: 300px">
                            <a href="http://www.baidu.com" rel="external nofollow">
                                <img src="/js/assets/img/slideshow/2.jpg"
                                     alt="WordPress主题: Begin">
                            </a>
                            <p class="slider-caption">
                                测试轮播图2
                            </p>
                        </div>
                        <div class="item" style="height: 300px">
                            <a href="http://www.baidu.com" rel="external nofollow">
                                <img src="/js/assets/img/slideshow/3.jpg"
                                     alt="WordPress主题: Begin">
                            </a>
                            <p class="slider-caption">
                                测试轮播图3
                            </p>
                        </div>
                    </div>
                    <!--选择豆豆-->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example" data-slide-to="1"></li>
                        <li data-target="#carousel-example" data-slide-to="2"></li>
                    </ol>
                    <!--上一张，下一张按钮-->
                    <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
            <%--bootstrap轮播图end--%>

            <c:forEach items="${pageInfo.list}" var="a">
                <article class="post type-post">
                    <figure class="thumbnail">
                        <a href="/article/${a.articleId}" style="text-decoration: none">
                            <img width="280" height="210"
                                 src="http://47.98.63.217/images/ccblog/article_imgs/timthumb${a.articleId}.jpg"
                                 class="outImg"
                                 class="attachment-content size-content wp-post-image"
                                 alt="${a.articleTitle}">
                        </a>
                        <span class="cat">
                                <a href="/cat/${a.categoryCustomList[a.categoryCustomList.size()-1].categoryId}"
                                   style="text-decoration: none">
                                        ${a.categoryCustomList[a.categoryCustomList.size()-1].categoryName}
                                </a>
                            </span>
                    </figure>

                    <header class="entry-header">
                        <h2 class="entry-title">
                            <div class="about-name">
                                <a href="/article/${a.articleId}" style="text-decoration: none">
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
                                        <a href="/article/${a.articleId}#comments" style="text-decoration: none"
                                           rel="external nofollow">
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
                                <a href="/article/${a.articleId}" style="text-decoration: none"
                                   rel="bookmark">
                                    阅读全文
                                </a>
                            </span>
                </article>
            </c:forEach>
        </main>

        <%--分页总信息--%>
        <div class="col-md-6">
            当前${pageInfo.pageNum}页,总${pageInfo.pages}页，总${pageInfo.total}条记录
        </div>

        <%--分页按钮栏--%>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li><a href="/pn/1">首页</a></li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="/pn/${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;上一页</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                    <c:if test="${page_Num==pageInfo.pageNum}">
                        <li class="active"><a href="#">${page_Num}</a></li>
                    </c:if>
                    <c:if test="${page_Num!=pageInfo.pageNum}">
                        <li><a href="/pn/${page_Num}">${page_Num}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="/pn/${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">下一页&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="/pn/${pageInfo.pages}">末页</a></li>
            </ul>
        </nav>
    </div>

    <%--右侧导航栏，基本信息等等--%>
    <jsp:include page="sidebar_index.jsp"/>
</div>

<div class="links-box">
    <div id="links">
        <c:forEach items="${linkList}" var="l">
            <ul class="lx7">
                <li class="link-f link-name">
                    <a href="http://${l.linkUrl}" target="_blank">
                            ${l.linkName}
                    </a>
                </li>
            </ul>
        </c:forEach>
        <div class="clear"></div>
    </div>
</div>
<%--底部信息--%>
<jsp:include page="footer.jsp"/>

<%--</div>--%>
<ul id="scroll">
    <li>
        <a class="scroll-h" title="返回顶部" id="toTop" style="text-decoration: none">
            <i class="fa fa-arrow-up fa-2x" style="margin-top: 7px;"></i>
        </a>
    </li>
    <li>
        <a class="scroll-h" title="转到底部" id="toBottom" style="text-decoration: none">
            <i class="fa fa-arrow-down fa-2x" style="margin-top: 8px;"></i>
        </a>
    </li>
</ul>

<script src="/js/assets/js/jquery.min.js"></script>
<script src="/js/assets/js/bootstrap.js" type="text/javascript"></script>
<script src="/js/script.js"></script>
<script src="/js/superfish.js"></script>
<script src="/js/jquery.cookie.js"></script>
<%--<script src="https://coding.net/u/ChandlerChai/p/ccblog-static-files/git/raw/master/ccblog-portal/js/jquery.min.js"></script>
<script src="https://coding.net/u/ChandlerChai/p/ccblog-static-files/git/raw/master/ccblog-portal/js/assets/js/bootstrap.js" type="text/javascript"></script>
<script src="https://coding.net/u/ChandlerChai/p/ccblog-static-files/git/raw/master/ccblog-portal/js/script.js"></script>
<script src="https://coding.net/u/ChandlerChai/p/ccblog-static-files/git/raw/master/ccblog-portal/js/superfish.js"></script>--%>
<script type="text/javascript">
    // 所以数据加载完毕后执行
    $(window).load(function(){
        $('body').addClass('loaded');
        $('#loader-wrapper .load_title').remove();
    });

    $(function () {
        addVisitorViews();
        var nav = $("#menu-box"); //得到导航对象
        var win = $(window); //得到窗口对象
        var sc = $(document);//得到document文档对象。
        win.scroll(function () {
            if (sc.scrollTop() >= 100) {
                nav.addClass("shadow");
                <!--$(".navTmp").fadeIn(); -->
            } else {
                nav.removeClass("shadow");
                <!--$(".navTmp").fadeOut();-->
            }
        })

        /*返回顶部和底部*/
        var speed = 400; //滚动速度
        var h = document.documentElement.clientWidth;
        //回到顶部
        $("#toTop").click(function() {
            $('html,body').animate({
                scrollTop: '0px'
            }, speed);
        });
        //回到底部
        var windowHeight = parseInt($("body").css("height")); //整个页面的高度
        $("#toBottom").click(function() {
            $('html,body').animate({
                scrollTop: windowHeight + 'px'
            }, speed);
        });
    })
    
    //游客进入首页，记录到operatorLog里面一下 visitorViewIPOne visitorViewIPTwo
    var visitorViewIPOne =  $.cookie("visitorViewIPOne")
    function addVisitorViews() {
        if ($.cookie("visitorViewIPTwo") != visitorViewIPOne || $.cookie("visitorViewIPTwo") == null) {
            $.ajax({
                url:"/addVisitorViews/"+visitorViewIPOne,
                type:"GET",
                success:function (data) {
                    $.cookie("visitorViewIPTwo", visitorViewIPOne,//需要cookie写入的业务
                        {
                            "path": "/", //cookie的默认属性
                        }
                    );
                }
            })
        }
    }

</script>
<%--<script color="255,0,0" opacity='1' zIndex="-2" count="150" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>--%>
<script color="255,0,0" opacity='1' zIndex="-2" count="150" src="https://coding.net/u/ChandlerChai/p/canvas-nest-min/git/raw/master/canvas-nest.min.js"></script>

</body>
</html>
