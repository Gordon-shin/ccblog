<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/23/023
  Time: 11:27
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
<div class="modal fade" id="DeleteButtonModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">警告</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-offset-3">
                    确认删除此自定义按钮吗?
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="button_delete_btn">删除</button>
            </div>
        </div>
    </div>
</div>


<!-- tag添加模态框Modal -->
<div class="modal fade" id="addButtonModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加按钮</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addButton_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">按钮名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="buttonname_input" name="custombuttonName" placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">按钮url</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="buttonname_desc"  name="custombuttonUrl" placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">按钮位置</label>
                        <div class="col-sm-6">
                            <label class="radio-inline">
                                <input type="radio"  name="custombuttonLevel" id="buttonLevel1" value="1"> 头部
                            </label>
                            <label class="radio-inline">
                            <input type="radio" name="custombuttonLevel" id="buttonLevel2" value="2"> 导航栏
                        </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">按钮样式</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="buttonname_icon"  name="custombuttonIcon" placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"  id="button_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <%--col-md-12表示占12列 ,也就是占全部列--%>
        <div class="col-md-12">
            <h1 class="page-head-line">按钮详情</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-10">
            <button class="btn btn-primary" id="add_button_btn">新增按钮</button>
        </div>
    </div>

    <%--表格数据内容--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive table-hover">
                <tr>
                    <th>ID</th>
                    <th>按钮名称</th>
                    <th>按钮url</th>
                    <th>按钮级别</th>
                    <th>按钮样式</th>
                    <th>按钮状态</th>
                    <th>操作按钮</th>
                </tr>
                <c:forEach items="${buttonList}" var="button">
                    <tr>
                        <th>${button.custombuttonId}</th>
                        <th>${button.custombuttonName}</th>
                        <th>${button.custombuttonUrl}</th>
                        <th>${button.custombuttonLevel}</th>
                        <th>${button.custombuttonIcon}</th>
                        <th>${button.custombuttonStatus==1?"可用":"隐藏"}</th>
                        <th>
                            <button class="btn btn-primary edit_btn" edit_id="${button.custombuttonId}">
                                <i class="fa fa-pencil"></i>编辑
                            </button>

                            <button class="btn btn-danger delete_btn" delete_id="${button.custombuttonId}">
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
        // 添加按钮，加载添加模态框
    $("#add_button_btn").click(function () {
        //每次加载模态框，表单清零
        $("#addButtonModal form")[0].reset();

        //加载模态框
        $("#addButtonModal").modal({
            backdrop:"static"
        });
    });


    //提交模态框中数据
    $("#button_save_btn").click(function () {
        var buttonInfo = $("#addButton_form").serialize();


        //3.将表单数据提交保存
        $.ajax({
            url:"saveButton",
            type:"POST",
            data:buttonInfo,
            success:function(result){
                //保存成功后：
                //1：关闭模态框
                $("#addButtonModal").modal('hide');
                //2:跳到最后一页
                window.location.href="/buttonIndex";
            }
        });

    })


    //删除自定义按钮
    $(".delete_btn").click(function () {
       var id =  $(this).attr("delete_id");
        $("#button_delete_btn").attr("btnDelete_id",id);
        $("#DeleteButtonModal").modal({});

    });

    $("#button_delete_btn").click(function () {
        var btnId = $(this).attr("btnDelete_id");

        $.ajax({
            url:"/deleteButton/"+btnId,
            type:"GET",
            success:function (result) {
                window.location.href="/buttonIndex";
            }
        });

    })






</script>
</body>
</html>
