<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/17
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--博客主体-右侧侧边栏 start--%>
<div id="sidebar" class="widget-area all-sidebar"
     style="position: relative; overflow: visible; box-sizing: border-box; min-height: 1px;">

    <%--搜索框--%>
    <aside class="widget widget_search">
        <div class="searchbar">
            <form  id="searchform1" method="get" action="/search">
                        <span>
                            <input type="text" value="" name="query" id="s1" placeholder="输入搜索内容" required="">
                            <button type="submit" id="searchsubmit1">搜索</button>
                        </span>
            </form>
        </div>
        <div class="clear"></div>
    </aside>
    <%--搜索框--%>

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

    <%--博客主体-右侧侧边栏-随机文章 start--%>
    <aside id="random_post-7" class="widget random_post wow fadeInUp" data-wow-delay="0.3s">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>随机文章
        </h3>
        <div id="random_post_widget">
            <ul>
                <c:forEach items="${articleListForSideBar}" var="r">
                    <li>
                        <a href="/article/${r.articleId}" rel="bookmark" style="text-decoration: none" >
                                ${r.articleTitle}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--博客主体-右侧侧边栏-近期文章 end--%>

</div>
<%--博客主体-右侧侧边栏 end--%>