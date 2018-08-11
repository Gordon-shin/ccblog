<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar" class="widget-area all-sidebar" style="position: relative; overflow: visible; box-sizing: border-box; min-height: 1px;">

    <%--搜索框--%>
    <aside class="widget widget_search">
        <div class="searchbar">
            <form id="searchform1" method="get" action="/search">
                        <span>
                            <input type="text"  name="query" id="s1" placeholder="输入搜索内容" required="">
                            <button type="submit" id="searchsubmit1">搜索</button>
                        </span>
            </form>
        </div>
        <div class="clear"></div>
    </aside>
    <!--<%--关于本站 start--%>-->

    <aside class="widget about">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>关于本站
        </h3>
        <div id="feed_widget">
            <div class="feed-about">
                <div class="about-main">
                    <div class="about-img">
                        <img src="${option.optionAboutsiteAvatar}" alt="QR Code">
                    </div>
                    <div class="about-name">${option.optionAboutsiteTitle}</div>
                    <div class="about-the">
                        ${option.optionAboutsiteContent}
                    </div>
                </div>
                <div class="clear"></div>
                <ul>
                    <li class="weixin">
                        <a title="微信" style="height: 40px;padding-top: 10px;"  rel="external nofollow">
                            <i class="fa fa-weixin"> </i>
                            <div id="weixin_code" class="hide">
                                <img src="${options.optionAboutsiteWechat}" alt="">
                            </div>
                        </a>
                    </li>
                    <li class="tqq">
                        <a target="blank" rel="external nofollow" style="height: 40px;padding-top: 10px;"  href="http://wpa.qq.com/msgrd?V=3&amp;uin=${option.optionAboutsiteQq}&amp;Site=QQ&amp;Menu=yes" title="QQ在线">
                            <i class="fa fa-qq"></i>
                        </a>
                    </li>
                    <li class="tsina">
                        <a title="" href="http://weibo.com/${option.optionAboutsiteWeibo}" style="height: 40px;padding-top: 10px;"  target="_blank" rel="external nofollow">
                            <i class="fa fa-weibo"></i>
                        </a>
                    </li>
                    <li class="feed">
                        <a title="" href="${options.optionAboutsiteGithub}" style="height: 40px;padding-top: 10px;"  target="_blank" rel="external nofollow">
                            <i class="fa fa-github"></i>
                        </a>
                    </li>
                </ul>
                <div class="about-inf">
                    <span class="about-pn">文章 ${blogBaseInfo[0]} </span>
                    <span class="about-cn">浏览 ${blogBaseInfo[5]} </span>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </aside>
    <%--关于本站 start--%>

    <%--网站概况 start--%>
    <aside id="php_text-22" class="widget php_text">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>网站概况
        </h3>
        <div class="textwidget widget-text">
            <ul class="site-profile">
                <li><i class="fa fa-file-o"></i> 文章总数：${blogBaseInfo[0]} 篇</li>
                <li><i class="fa fa-commenting-o"></i> 留言数量：${blogBaseInfo[1]} 条</li>
                <li><i class="fa fa-folder-o"></i> 分类数量：${blogBaseInfo[2]} 个</li>
                <li><i class="fa fa-tags"></i> 标签总数：${blogBaseInfo[3]} 个</li>
                <li><i class="fa fa-link"></i> 链接数量：${blogBaseInfo[4]} 个</li>
                <li><i class="fa fa-eye"></i> 浏览总量：${blogBaseInfo[5]} 次</li>
                <li><i class="fa fa-pencil-square-o"></i> 最后更新：
                    <span style="color:#2F889A">
                                         <fmt:formatDate value="${lastUpdateArticle.articleUpdateTime}" pattern="yyyy年MM月dd日"/>
                                   </span>
                </li>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--网站概况 end--%>

    <%--所有标签 start--%>
    <aside class="widget">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>所有标签
        </h3>
        <div class="tagcloud">
            <c:forEach items="${tagList}" var="tag">
                <a href="/tag/${tag.tagId}"
                   class="tag-link-129 tag-link-position-1" title="2个话题"
                   style="font-size: 14px;text-decoration: none">
                        ${tag.tagName}
                </a>
            </c:forEach>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </aside>
    <%--所有标签 end--%>

    <%--随机文章 start--%>
    <aside id="random_post-7" class="widget random_post wow fadeInUp" data-wow-delay="0.3s">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>随机文章
        </h3>
        <div id="random_post_widget">
            <ul>
                <c:forEach items="${articleListForSideBar}" var="r">
                    <li>
                        <a href="/article/${r.articleId}" style="text-decoration: none"  rel="bookmark">
                                ${r.articleTitle}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--近期文章 end--%>



</div>