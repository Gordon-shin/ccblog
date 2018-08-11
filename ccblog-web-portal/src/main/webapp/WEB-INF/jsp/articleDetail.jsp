<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/17
  Time: 22:21
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
    <link href="/images/timg.jpg" rel="icon">
    <link href="/js/assets/css/bootstrap.css"  rel="stylesheet" type='text/css' />
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/js/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/superfish/1.7.9/css/superfish.css"/>
    <%--ueditor代码高亮要引的css--%>
    <link rel="stylesheet" type="text/css" href="/js/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    <style>
        #primary {
            float: left;
            width: 760px;
            transition-duration: .5s;
        }
        .share-s a{margin-top:-25px}
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
        /*解决代码高亮时候，行数错乱*/
        td.code {
            padding-top: 9.5px;
        }

    </style>
</head>
<body>
    <%--公用头部--%>
    <jsp:include page="header.jsp"/>

    <%--面包屑导航 start--%>
    <nav class="breadcrumb" style="padding-top: 0px;">
        <a class="crumbs" href="/" style="text-decoration: none" >
            <i class="fa fa-home"></i>首页
        </a>
        <c:choose>
            <c:when test="${articleDetailCustom.categoryCustomList.size()!=0}">
                <c:forEach items="${articleDetailCustom.categoryCustomList}" var="c">
                    <i class="fa fa-angle-right"></i>
                    <a href="/cat/${c.categoryId}" style="text-decoration: none" >
                            ${c.categoryName}
                    </a>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <a style="text-decoration: none" >未分类</a>
            </c:otherwise>
        </c:choose>
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>

    <div id="content" class="site-content" style="transform: none;">
    <%--博客主体-左侧文章正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post">
                <header class="entry-header">
                    <h1 class="entry-title site-title" style="background: #f8f8f8;">
                        ${articleDetailCustom.articleTitle}
                    </h1>
                </header><!-- .entry-header -->
                <div class="entry-content">
                    <div class="single-content">
                        ${articleDetailCustom.articleContent}

                            <%--<a href="http://ww1.sinaimg.cn/large/703be3b1jw1evmunct4p9j20jg0elq5q.jpg"><img class="aligncenter" src="http://ww1.sinaimg.cn/large/703be3b1jw1evmunct4p9j20jg0elq5q.jpg" alt="" width="700" height="525" /></a><a href="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmungtytbj20jg0el0v4.jpg"><img class="aligncenter" src="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmungtytbj20jg0el0v4.jpg" alt="" width="700" height="525" /></a><a href="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmunt9tnlj20jg0eljsq.jpg"><img class="aligncenter" src="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmunt9tnlj20jg0eljsq.jpg" alt="" width="700" height="525" /></a><a href="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmuns9varj20jg0el406.jpg"><img class="aligncenter" src="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmuns9varj20jg0el406.jpg" alt="" width="700" height="525" /></a><a href="http://ww3.sinaimg.cn/mw690/703be3b1jw1evmunrm9s8j20jg0eljsw.jpg"><img class="aligncenter" src="http://ww3.sinaimg.cn/mw690/703be3b1jw1evmunrm9s8j20jg0eljsw.jpg" alt="" width="700" height="525" /></a><a href="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunnj8yjj20jg0el3zb.jpg"><img class="aligncenter" src="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunnj8yjj20jg0el3zb.jpg" alt="" width="700" height="525" /></a><a href="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunmwv13j20jg0elt9k.jpg"><img class="aligncenter" src="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunmwv13j20jg0elt9k.jpg" alt="" width="700" height="525" /></a><a href="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunm6kvwj20jg0el3zf.jpg"><img class="aligncenter" src="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunm6kvwj20jg0el3zf.jpg" alt="" width="700" height="525" /></a><a href="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmuni6gsuj20jg0elmy6.jpg"><img class="aligncenter" src="http://ww4.sinaimg.cn/mw690/703be3b1jw1evmuni6gsuj20jg0elmy6.jpg" alt="" width="700" height="525" /></a><a href="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunhe3cyj20jg0eltbb.jpg"><img class="aligncenter" src="http://ww1.sinaimg.cn/mw690/703be3b1jw1evmunhe3cyj20jg0eltbb.jpg" alt="" width="700" height="525" /></a>--%>
                    </div>
                    <div class="clear"></div>
                    <div id="social">
                        <div class="social-main">
                                    <span class="like">
                                        <a href="javascript:;" style="text-decoration: none"  data-action="ding" data-id="1" title="点赞"
                                           class="favorite" onclick="thumbUp()">
                                            <i class="fa fa-thumbs-up"></i>赞
                                            <i class="count" id="count-${articleDetailCustom.articleId}">${articleDetailCustom.articleLikeCount}</i>
                                        </a>
                                    </span>
                            <div class="shang-p">
                                <div class="shang-empty">
                                    <span></span>
                                </div>
                                <span class="shang-s">
                                              <a onclick="" style="cursor:pointer;text-decoration: none">稳</a>
                                        </span>
                            </div>
                            <div class="share-sd">
                                        <span class="share-s" style="margin-top: 25px!important;">
                                            <a href="javascript:void(0)" id="share-s" style="text-decoration: none"  title="分享">
                                                <i class="fa fa-share-alt"></i>分享
                                            </a>
                                        </span>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>

                    <footer class="single-footer">
                        <ul class="single-meta">
                            <c:if test="${sessionScope.user!=null}">
                                <li class="edit-link">
                                    <a target="_blank" class="post-edit-link" style="text-decoration: none"
                                       href="/admin/article/edit/${articleDetailCustom.articleId}">编辑</a>
                                </li>
                            </c:if>
                            <li class="comment">
                                <a href="/article/${articleDetailCustom.articleId}#comments" style="text-decoration: none"
                                   rel="external nofollow">
                                    <i class="fa fa-comment-o"></i>
                                    <i class="comment-count">${articleDetailCustom.commentCustomList.size()}</i>
                                </a>
                            </li>
                            <li class="views">
                                <i class="fa fa-eye"></i> <span
                                    class="articleViewCount">${articleDetailCustom.articleViewCount}</span>
                                views
                            </li>
                            <li class="r-hide">
                                <a href="javascript:pr()" title="侧边栏" style="text-decoration: none" >
                                    <i class="fa fa-caret-left"></i>
                                    <i class="fa fa-caret-right"></i>
                                </a>
                            </li>
                        </ul>
                        <ul id="fontsize">
                            <li>A+</li>
                        </ul>
                        <div class="single-cat-tag">
                            <div class="single-cat">所属分类：
                                <c:forEach items="${articleDetailCustom.categoryCustomList}" var="c">
                                    <a href="/cat/${c.categoryId}" style="text-decoration: none" >
                                            ${c.categoryName}
                                    </a>
                                </c:forEach>
                            </div>
                        </div>
                    </footer><!-- .entry-footer -->


                    <div class="clear"></div>
                </div><!-- .entry-content -->
            </article><!-- #post -->

            <%--所属标签 start--%>
            <div class="single-tag">
                <ul class="" data-wow-delay="0.3s">
                    <c:forEach items="${articleDetailCustom.tags}" var="t">
                        <li>
                            <a href="/tag/${t.tagId}" rel="tag"
                               style="background:#666666;text-decoration: none">
                                    ${t.tagName}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <%--所属标签 end--%>


            <%--版权声明 start--%>
            <div class="authorbio wow fadeInUp" >
                <img alt="${articleDetailCustom.user.userNickname}" src="${articleDetailCustom.user.userAvatar}"
                     class="avatar avatar-64 photo" height="64" width="64">
                <ul class="postinfo">
                    <li></li>
                    <li><strong>版权声明：</strong>本站原创文章，于<fmt:formatDate
                            value="${articleDetailCustom.articlePostTime}"
                            pattern="yyyy-MM-dd"/>，由
                        <strong>
                            ${articleDetailCustom.user.userNickname}
                        </strong>
                        发表。
                    </li>
                    <li class="reprinted"><strong>转载请注明：</strong>
                        <a href="/article/${articleDetailCustom.articleId}" style="text-decoration: none"
                           rel="bookmark"
                           title="本文固定链接 /article/${articleDetailCustom.articleId}">
                            ${articleDetailCustom.articleTitle} | ${option.optionSiteTitle}</a>
                    </li>
                </ul>
                <div class="clear"></div>
            </div>
            <%--版权声明 end--%>


            <%--上一篇下一篇 start--%>
            <nav class="nav-single">
                <c:choose>
                    <c:when test="${preArticle!=null}">
                        <a href="/article/${preArticle.articleId}" rel="next" style="text-decoration: none" >
                            <span class="meta-nav">
                                <span class="post-nav">上一篇
                                 <i class="fa fa-angle-left"></i>
                                </span>
                                <br>${preArticle.articleTitle}
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                              <span class="meta-nav">
                                    <span class="post-nav">
                                        没有了<br>
                                    </span>已是第一篇文章
                                </span>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${afterArticle!=null}">
                        <a href="/article/${afterArticle.articleId}" rel="next" style="text-decoration: none" >
                            <span class="meta-nav">
                                <span class="post-nav">下一篇
                                 <i class="fa fa-angle-right"></i>
                                </span>
                                <br>${afterArticle.articleTitle}
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                            <span class="meta-nav">
                                <span class="post-nav">
                                    没有了<br>
                                </span>已是最后文章
                             </span>
                    </c:otherwise>
                </c:choose>

                <div class="clear"></div>
            </nav>
            <%--上一篇下一篇 end--%>


            <%--评论区域 start--%>
            <div class="scroll-comments"></div>
            <div id="comments" class="comments-area">
                <div id="respond" class="comment-respond">
                    <h3 id="reply-title" class="comment-reply-title"><span id="reply-title-word">发表评论</span>
                        <a rel="nofollow" id="cancel-comment-reply-link"
                           href="/article/${articleDetailCustom.articleId}#respond"
                           style="">取消回复</a>
                    </h3>
                    <%--评论编辑框start--%>
                    <form id="comment_form" method="post">
                        <p class="comment-form-comment">
                            <textarea id="comment" name="commentContent" rows="4" tabindex="1" required></textarea>
                        </p>
                        <div id="comment-author-info">
                            <input type="hidden" name="commentPid" value="0">
                            <input type="hidden" name="commentPname" value="">
                            <c:if test="${sessionScope.user==null}">
                                <input type="hidden" name="commentRole" value="0">
                                <p class="comment-form-author">
                                    <label for="author_name">
                                        昵称<span class="required">*</span>
                                    </label>
                                    <input type="text" name="commentUserName" id="author_name" class="" value=""
                                           tabindex="2" required>
                                </p>
                                <p class="comment-form-email">
                                    <label for="author_email">
                                        邮箱<span class="required">*</span>
                                    </label>
                                    <input type="email" name="commentUserEmail" id="author_email" class="" value=""
                                           tabindex="3" required>
                                </p>
                                <p class="comment-form-url">
                                    <label for="author_url">网址</label>
                                    <input type="url" name="commentUserUrl" id="author_url" class="" value=""
                                           tabindex="4">
                                </p>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                        <p class="form-submit">
                            <input id="submit" name="submit" type="submit" tabindex="5" value="提交评论">
                            <input type="hidden" name="commentArticleId"
                                   value="${articleDetailCustom.articleId}" id="article_id">
                            <input type="hidden" name="commentPid" id="comment_pid" value="0">
                        </p>
                    </form>
                </div>
                <%--评论编辑框end--%>

                <%--评论列表展示start--%>
                <ol class="comment-list">
                    <c:set var="floor" value="0"/>
                    <c:forEach items="${articleDetailCustom.commentCustomList}" var="c">
                        <c:if test="${c.commentPid==0}">
                            <c:set var="floor" value="${floor+1}"/>
                            <li class="comments-anchor">
                                <ul id="anchor-comment-${c.commentId}"></ul>
                            </li>
                            <li class="comment">
                                <div id="div-comment-${c.commentId}" class="comment-body">
                                    <div class="comment-author vcard">
                                        <img class="avatar" src="${c.commentAuthorAvatar}" alt="avatar"
                                             style="display: block;">
                                        <strong>${c.commentUserName} </strong>
                                        <c:if test="${c.commentRole==1}">
                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                            <span class="" style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>群主</b></span>
                                        </c:if>
                                        <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <br>
                                                <span class="comment-aux">
                                                    <span class="reply">
                                                        <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                           onclick="">回复
                                                        </a>
                                                    </span>
                                                    <fmt:formatDate value="${c.commentCreateTime}"
                                                                    pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;

                                                    <span class="floor"> &nbsp;${floor}楼&nbsp;[${c.commentAgent}] </span>
                                                </span>
                                            </span>
                                        </span>
                                        <p>
                                            <c:if test="${c.commentPid!=0}">
                                                <span class="at">@ ${c.commentPname}</span>
                                            </c:if>
                                                ${c.commentContent}
                                        </p>

                                    </div>
                                </div>

                                <%--评论中的子评论--%>
                                <ul class="children">
                                    <c:set var="floor2" value="0"/>
                                    <c:forEach items="${articleDetailCustom.commentCustomList}" var="c2">
                                        <c:if test="${c.commentId==c2.commentPid}">
                                            <c:set var="floor2" value="${floor2+1}"/>
                                            <li class="comments-anchor">
                                                <ul id="anchor-comment-${c2.commentId}"></ul>
                                            </li>
                                            <li class="comment">
                                                <div id="div-comment-${c.commentId}" class="comment-body">
                                                    <div class="comment-author vcard">
                                                        <img class="avatar" src="${c2.commentAuthorAvatar}" alt="avatar"
                                                             style="display: block;">
                                                        <strong>${c2.commentUserName} </strong>
                                                        <c:if test="${c2.commentRole==1}">
                                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                                            <span class=""
                                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>群主</b></span>
                                                        </c:if>
                                                        <span class="comment-meta">
                                                    <span class="ua-info" style="display: inline;">
                                                    <br>
                                                    <span class="comment-aux">
                                                        <span class="reply">
                                                            <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                               onclick="replyComment()">回复
                                                            </a>
                                                        </span>
                                                        <fmt:formatDate value="${c2.commentCreateTime}"
                                                                        pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                        <span class="floor"> &nbsp;${floor2}层 &nbsp;[${c2.commentAgent}]  </span>
                                                    </span>
                                                </span>
                                                    </span>
                                                        <p>
                                                            <c:if test="${c2.commentPid!=0}">
                                                                <c:if test="${c2.commentPid!=0}">
                                                                    <span class="at">@ ${c2.commentPname}</span>
                                                                </c:if>
                                                                ${c2.commentContent}
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                                <%--评论中的子评论--%>

                            </li>
                        </c:if>
                    </c:forEach>
                </ol>
                <%--评论列表展示end--%>

            </div>
            <%--评论框 end--%>
        </main>
        <!-- .site-main -->
            </div>
        <%--博客主体-左侧文章正文end--%>

        <%--右侧导航栏，基本信息等等--%>
        <jsp:include page="sidebar_other.jsp"/>

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

    </div>

    <%--底部信息--%>
    <jsp:include page="footer.jsp"/>
    <script src="/js/assets/js/jquery.min.js"></script>
    <script src="/js/script.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="/js/superfish.js"></script>
    <script src="/js/jquery.cookie.js"></script>
    <%--ueditor代码高亮要引的js--%>
    <script type="text/javascript" src="/js/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
    <script>
       /*代码高亮*/
        SyntaxHighlighter.all();
      /* for(var i=0,di;di=SyntaxHighlighter.highlightContainers[i++];){
           var tds = di.getElementsByTagName('td');
           for(var j=0,li,ri;li=tds[0].childNodes[j];j++){
               ri = tds[1].firstChild.childNodes[j];
               ri.style.height = li.style.height = ri.offsetHeight + 'px';
           }
       }*/

        $(function () {
            //  每次进入文章详情页，文章浏览量加1,cookie有效期内，不得重复添加浏览量
            addViews();
            var nav=$("#menu-box"); //得到导航对象
            var win=$(window); //得到窗口对象
            var sc=$(document);//得到document文档对象。
            win.scroll(function(){
                if(sc.scrollTop()>=100){
                    nav.addClass("shadow");
                    <!--$(".navTmp").fadeIn(); -->
                }else{
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
        var articleId = (window.location.pathname).match(/\d+/g);
        //点赞+1
        function thumbUp() {
            if ($.cookie("likeId") != articleId || $.cookie("likeId") == null) {
                $.ajax({
                    url:"/thumbUp/"+articleId,
                    type:"GET",
                    success:function (data) {
                        $(".count").html(data.map.countNum);
                        $.cookie("likeId", articleId,//需要cookie写入的业务
                            {
                                "path": "/", //cookie的默认属性
                            }
                        );
                    }
                })
            }
        }

        //文章浏览量加一
        function addViews() {
            if ($.cookie("viewId") != articleId || $.cookie("viewId") == null) {
                $.ajax({
                    url:"/addViews/"+articleId,
                    type:"GET",
                    success:function (data) {
                        $(".articleViewCount").html(data.map.viewsNum);
                        $.cookie("viewId", articleId,//需要cookie写入的业务
                            {
                                "path": "/", //cookie的默认属性
                            }
                        );
                    }
                })
            }
        }



       //ajax提交评论信息
       $("#comment_form").submit(function () {
           var commentForm = $("#comment_form").serialize();
           $.ajax({
               async: false,
               type: "POST",
               url: '/addComment',
               contentType: "application/x-www-form-urlencoded; charset=utf-8",
               data: commentForm,
               dataType: "text",
               success: function () {
               },
               error: function () {
               }
           })


       })

    </script>
    <script  opacity='1' zIndex="-2" count="150" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</body>
</html>
