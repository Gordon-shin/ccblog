<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/15
  Time: 11:47
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
<!-- link详情模态框Modal -->
<div class="modal fade" id="linkDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">链接详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkId"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">链接名称</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkName"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">链接地址</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkUrl"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">链接备注</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkOwnerContact"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">链接描述</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkDescription"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">创建时间</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkCreateTime"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">链接状态</label>
                        <div class="col-sm-6">
                            <p class="form-control-static" id="linkStatus"></p>
                        </div>
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
    <div class="row">
        <%--col-md-12表示占12列 ,也就是占全部列--%>
        <div class="col-md-12">
            <h1 class="page-head-line">链接详情</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-10">
            <button class="btn btn-primary" id="add_link_btn">新增链接</button>
        </div>
    </div>

    <%--表格数据内容--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive table-hover">
                <tr>
                    <th>ID</th>
                    <th>链接名称</th>
                    <th>链接地址</th>
                    <th>链接备注</th>
                    <th>创建时间</th>
                    <th>链接状态</th>
                    <th>操作按钮</th>
                </tr>
                <c:forEach items="${linkList}" var="link">
                    <tr>
                        <th>${link.linkId}</th>
                        <th>${link.linkName}</th>
                        <th>${link.linkUrl}</th>
                        <th>${fn:substring(link.linkOwnerContact,0 ,5 )}..</th>
                        <th><fmt:formatDate value="${link.linkCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
                        <th>${link.linkStatus==1?"已通过":"待审核"}</th>
                        <th>
                            <button class="btn btn-primary details_button" detail_id="${link.linkId}" detail_date="<fmt:formatDate value="${link.linkCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" />">
                                <i class="fa fa-pencil"></i>详情
                            </button>
                            <button class="btn btn-primary edit_btn" edit_id="${link.linkId}">
                                <i class="fa fa-pencil"></i>编辑
                            </button>

                            <button class="btn btn-danger delete_btn" delete_id="${link.linkId}">
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

    $(".details_button").click(function () {

        var linkId = $(this).attr("detail_id")
        var linkdate = $(this).attr("detail_date")
        getLinkDetail(linkId,linkdate);
        $("#linkDetailModal").modal({});
    });
    
    function getLinkDetail(linkId,linkdate) {
        $.ajax({
            url:"getLinkById/"+linkId,
            type:"GET",
            success:function (result) {
                var link = result.map.link;
                $("#linkId").text(link.linkId);
                $("#linkName").text(link.linkName);
                $("#linkUrl").text(link.linkUrl);
                $("#linkOwnerContact").text(link.linkOwnerContact);
                $("#linkDescription").text(link.linkDescription);
                $("#linkCreateTime").text(linkdate);
                $("#linkStatus").text(link.linkStatus==1?"已通过":"待审核");
            }
        });
    }


</script>
</body>
</html>
