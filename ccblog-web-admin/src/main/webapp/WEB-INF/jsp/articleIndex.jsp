<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/16
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="manegerStyle.jsp" %>
</head>
<body>

<!-- ariticle详情模态框Modal -->
<div class="modal fade" id="articleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">文章详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">文章标题</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="articleTitle"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">文章内容</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="articleContent"></p>
                        </div>
                    </div>
                    <div id="content">

                    </div>



                </form>
            </div>
            <div class="modal-footer">
                点击旁边可关闭
            </div>
        </div>
    </div>
</div>


<div class="container">
    <%--  标题--%>
    <div class="row">
        <%--col-md-12表示占12列 ,也就是占全部列--%>
        <div class="col-md-12">
            <h1 class="page-head-line">全部文章</h1>
        </div>
    </div>

        <%--按钮--%>
        <div class="row">
            <div class="col-md-4 col-md-offset-10">
                <button class="btn btn-primary" id="add_article_btn">新增文章</button>
            </div>
        </div>

        <%--表格数据内容--%>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-responsive table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>标题</th>
                        <th>所属分类</th>
                        <th>标签们</th>
                        <th>发布时间</th>
                        <th>操作按钮</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="article">
                        <tr>
                            <th>${article.articleId}</th>
                            <th>
                                <a style="text-decoration: none">${article.articleTitle}</a>
                            </th>
                            <th>${article.parentCategory}--${article.childCategory}</th>
                            <th>
                                <c:forEach items="${article.tags}" var="tag">
                                    ${tag.tagName}&nbsp;
                                </c:forEach>
                            </th>
                            <th><fmt:formatDate value="${article.articlePostTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></th>
                            <th>
                                <button class="btn btn-info details-button" style="background-color: yellow;color:black" detail_id="${article.articleId}">
                                    <i class="fa fa-paper-plane"></i>预览
                                </button>
                                <%--<button class="btn btn-primary edit_btn" edit_id="${article.articleId}">
                                    <i class="fa fa-pencil"></i>编辑
                                </button>--%>
                                <a class="btn btn-primary edit_btn" href="/updataArticle/${article.articleId}" edit_id="${article.articleId}">
                                    <i class="fa fa-pencil"></i>编辑
                                </a>

                                <button class="btn btn-danger delete_btn" delete_id="${article.articleId}">
                                    <i class="fa fa-remove"></i>删除
                                </button>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <%--显示分页信息--%>
        <div class="row">
            <%--分页文字信息--%>
            <div class="col-md-6">
                当前${pageInfo.pageNum}页,总${pageInfo.pages}页，总${pageInfo.total}条记录
            </div>

            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><a href="/articleIndex?pn=1">首页</a></li>
                        <c:if test="${pageInfo.hasPreviousPage}" >
                            <li>
                                <a href="/articleIndex?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;上一页</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${page_Num==pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>

                            <c:if test="${page_Num!=pageInfo.pageNum}">
                                <li><a href="/articleIndex?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>

                        </c:forEach>

                        <c:if test="${pageInfo.hasNextPage}" >
                            <li>
                                <a href="/articleIndex?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">下一页&raquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <li><a href="/articleIndex?pn=${pageInfo.pages}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>



</div>
<%@ include file="managerJavaScript.jsp" %>
<!-- 百度富文本编辑器 -->
<!-- 配置文件 -->
<script src="js/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="js/ueditor/ueditor.parse.js"></script>
<script>
//    解析文章内容，在#content里面
    uParse('#content', {
        rootPath: './js/ueditor'
    });

    $(".details-button").click(function () {
        var articleId = $(this).attr("detail_id");
        //ajax根据id查询文章信息加载到详情模态框里
        getArticleDetailToModal(articleId);
        /* ueditor解析文章格式配置*/
        $("#articleDetailModal").modal({});

    });

    //预览文章，文章内容加载进模态框
    function getArticleDetailToModal(articleId) {
        $.ajax({
            url:"getArticleById/"+articleId,
            type:"GET",
            success:function (result) {
                var article = result.map.article;
                //每次append前，清空一下<div id="content"></div>里面的子元素
                $("#content").empty();
                //注意此处一定要用append，不然会以字符串“文章内容”的形式加载进模态框，无法解析
                $("#content").append(article.articleContent);
                $("#articleTitle").text(article.articleTitle);
            }
        });
    }


</script>

</body>
</html>
