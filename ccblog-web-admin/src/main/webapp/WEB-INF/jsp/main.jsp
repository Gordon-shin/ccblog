<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/2/002
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>Title</title>

    <%@ include file="manegerStyle.jsp" %>

</head>
<body>
<div class="row">
    <div class="col-md-12">
        <h1 class="page-head-line">仪表盘</h1>
    </div>
</div>

<div class="panel-body">
    <div class="row">
        <div class="col-md-3 ">
            <div class="alert alert-info text-center">
                <i class="fa fa-book fa-5x"></i>
                <h4>发表了</h4>
                <h4>${articleTotalNum}</h4>
                <h4>篇文章</h4>
            </div>
        </div>
        <div class="col-md-3 ">
            <div class="alert alert-success text-center">
                <i class="fa fa-bars fa-5x"></i>
                <h4>收到了</h4>
                <h4>666</h4>
                <h4>条评论</h4>
            </div>
        </div>
        <div class="col-md-3 ">
            <div class="alert alert-success text-center">
                <i class="fa fa-bars fa-5x"></i>
                <h4>共有</h4>
                <h4>3</h4>
                <h4>种分类</h4>
            </div>
        </div>
        <div class="col-md-3 ">
            <div class="alert alert-success text-center">
                <i class="fa fa-bars fa-5x"></i>
                <h4>共有</h4>
                <h4>5</h4>
                <h4>种标签</h4>
            </div>
        </div>
        <%--天气预报--%>
        <%--<div class="col-md-3 ">
            <div class="alert alert-success text-center">
                <iframe allowtransparency="true"  frameborder="0" width="255" height="157" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=1&bd=0&k=&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=255&h=98&align=center"></iframe>
            </div>
        </div>--%>
    </div>
</div>

<!-- /. ROW  -->
<div class="row">
    <div class="col-md-6">
        <!--    Hover Rows  -->
        <div class="panel panel-default">
            <div class="panel-heading">
                最新文章
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr class="info">
                            <th>文章标题</th>
                            <th>发布者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${articleList}" var="article">
                        <tr class="info">
                            <td>
                               <a href="/getArticleById/${article.articleId}">${article.articleTitle}</a>
                            </td>

                            <td>
                                ${article.articleAuthorName}
                            </td>

                            <td>
                                <fmt:formatDate value="${article.articlePostTime}" pattern="yyyy年MM月dd日 HH:mm:ss" />
                            </td>
                        </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- End  Hover Rows  -->
    </div>
    <div class="col-md-3 ">
        <div class="alert alert-success text-center">
            <iframe allowtransparency="true"  frameborder="0" width="255" height="157" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=1&bd=0&k=&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=255&h=98&align=center"></iframe>
        </div>
    </div>
</div>

<%@ include file="managerJavaScript.jsp" %>




</body>
</html>
