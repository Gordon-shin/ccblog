<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="masthead" class="site-header">
    <nav id="top-header">
        <div class="top-nav">
            <div class="user-login">
                <a id="jinruhoutai" onclick="bugeijin();">进入后台</a>
            </div>
            <div class="menu-topmenu-container">

                <ul id="menu-topmenu" class="top-menu">
                    <c:forEach items="${buttonList}" var="button">
                        <li class="menu-item">
                            <c:if test="${button.custombuttonLevel==1}">
                                <a href="${button.custombuttonUrl}" style="text-decoration: none">
                                    <i class="${button.custombuttonIcon}"></i>
                                    <span class="font-text">${button.custombuttonName}&nbsp;</span>&nbsp;
                                </a>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
    <!-- #top-header -->
    <%--顶部菜单 end--%>

    <%--主要菜单 satrt--%>
    <div id="menu-box">
        <div id="top-menu">
			<%--<span class="nav-search">
                    <i class="fa fa-search"></i>
                </span>--%>
                <!-- .logo-site -->
            <div class="logo-site">
                <h1 class="site-title">
                    <a href="/" style="text-decoration: none" title="${option.optionSiteTitle}">${option.optionSiteTitle}</a>
                </h1>
                <p class="site-description">${option.optionSiteDescrption}</p>
            </div>
                <%--<div class="logo-sites">
                    <a href="http://zmingcx.com/">
                        <span class="logo-small">
                        <img src="http://imgs.zmingcx.com/wp-content/uploads/2017/12/zml.png">
                        </span>
                    </a>
                    <h1 class="site-title">
                        <a href="http://zmingcx.com/" title="CCBLOG" style="text-decoration: none" rel="home">
                            CCBLOG
                        </a>
                    </h1>
                    <p class="site-description">崇尚专注　追求极致</p>
                </div>--%>
            <!-- .logo-site -->
            <div id="site-nav-wrap">
                <div id="sidr-close">
                    <a href="#sidr-close" class="toggle-sidr-close">×</a>
                </div>
                <nav id="site-nav" class="main-nav">
                    <a href="#sidr-main" id="navigation-toggle" class="bars">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="menu-pcmenu-container">
                        <ul id="menu-pcmenu" class="down-menu nav-menu sf-js-enabled sf-arrows">

                            <li>
                                <a href="/" class="head_site" style="text-decoration: none" >
                                    <i class="fa fa-home"></i>
                                    <span class="font-text">首页</span>
                                </a>
                            </li>

                            <!--一级菜单java-->
                            <c:forEach items="${categoryList}" var="category">
                                <c:if test="${category.categoryPid==0}">
                                    <li>
                                        <a href="/cat/${category.categoryId}" style="text-decoration: none"  class="sf-with-ul head_site">
                                            <i class="${category.categoryIcon}"></i>
                                            <span class="font-text">${category.categoryName}&nbsp;</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <c:forEach items="${categoryList}" var="cat">
                                                <c:if test="${cat.categoryPid==category.categoryId}">
                                                    <li>
                                                        <a href="/cat/${cat.categoryId}" style="text-decoration: none" >${cat.categoryName}</a>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:if>
                            </c:forEach>


                            <%--主要菜单其余部分--%>
                            <li>
                                <a href="/message" class="head_site" style="text-decoration: none" >
                                    <i class="fa fa-comment"></i>
                                    <span class="font-text">留言板&nbsp;</span>
                                </a>
                            </li>

                            <%--主要菜单其余部分--%>
                            <c:forEach items="${buttonList}" var="button">
                                <li class="menu-item">
                                    <c:if test="${button.custombuttonLevel==2}">
                                        <a href="${button.custombuttonUrl}" class="head_site" style="text-decoration: none" >
                                            <i class="${button.custombuttonIcon}"></i>
                                            <span class="font-text">${button.custombuttonName}&nbsp;</span>&nbsp;
                                        </a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
            <div class="clear"></div>
        </div>
        <!-- #top-menu -->
    </div>
    <!-- #menu-box -->
    <%--主要菜单 satrt--%>

</header>
<!-- #masthead -->
<%--导航 end start--%>

<%--搜索框 start--%>
<%--<div id="search-main">
    <div class="searchbar">
        <form method="get" id="searchform" action="#">
			<span>
                    <input type="text" value="" name="query" id="s" placeholder="输入搜索内容"required="">
                    <button type="submit" id="searchsubmit">搜索</button>
                </span>
        </form>
    </div>
    <div class="clear"></div>
</div>--%>
<%--搜索框 end--%>