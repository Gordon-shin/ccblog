<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/14
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="manegerStyle.jsp" %>
</head>
<body>
<%--删除确认模态框--%>
<div class="modal fade" id="DeleteNoticeModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">警告</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-offset-3">
                    确认删除此公告吗?
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="notice_delete_btn">删除</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <%--col-md-12表示占12列 ,也就是占全部列--%>
        <div class="col-md-12">
            <h1 class="page-head-line">全部公告</h1>
        </div>
    </div>

    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-10">
            <a class="btn btn-primary" href="/editNotice" id="add_cat_btn">新增</a>
        </div>
    </div>

    <%--表格数据内容--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive">
                <tr>
                    <th>ID</th>
                    <th>公告标题</th>
                    <th>公告内容</th>
                    <th>公告状态</th>
                    <th>创建时间</th>
                    <th>最近更新</th>
                    <th>操作按钮</th>
                </tr>
                <c:forEach items="${noticeList}" var="notice">
                    <tr>
                        <th>${notice.noticeId}</th>
                        <th>${notice.noticeTitle}</th>
                        <th>${fn:substring(notice.noticeContent,0 ,10 )}..</th>
                        <th>${notice.noticeStatus=="1"?"可用":"隐藏"}</th>
                        <th><fmt:formatDate value="${notice.noticeCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
                        <th><fmt:formatDate value="${notice.noticeUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
                        <th>
                            <a class="btn btn-primary edit_btn" href="/toUpdateNotice/${notice.noticeId}" edit_id="${notice.noticeId}">
                                <i class="fa fa-pencil"></i>编辑
                            </a>

                            <button class="btn btn-danger delete_btn" delete_id="${notice.noticeId}">
                                <i class="fa fa-remove"></i>删除
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


</div>
<%@ include file="managerJavaScript.jsp" %>
<script>
    $(".delete_btn").click(function () {
        $("#notice_delete_btn").attr("NoticeDelete_id",$(this).attr("delete_id"));
        $("#DeleteNoticeModal").modal({});
    });
    
    
    $("#notice_delete_btn").click(function () {
        var noticeId = $(this).attr("NoticeDelete_id");
        $.ajax({
            url:"deleteNotice/"+noticeId,
            type:"GET",
            success:function (result) {
                window.location.href="/noticeIndex";
            }
        });
    });
</script>


</body>
</html>
