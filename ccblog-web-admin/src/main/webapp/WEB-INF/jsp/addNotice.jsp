<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/14
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑文章</title>
    <%@ include file="manegerStyle.jsp" %>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-head-line">添加公告信息</h1>
        </div>
    </div>

    <!-- /. ROW  -->
    <div class="row">
        <div class="col-md-10 col-sm-6 col-xs-12">
            <div class="panel-body">
                <form role="form" id="addNoticeForm" action="/addNotice" method="post">
                    <div class="form-group">
                        <label>公告标题:</label>

                        <input class="form-control" name="noticeTitle" id="notice_title" type="text">
                            <span class="help-block" style="color: red"></span>

                    </div>
                    <div class="form-group">
                        <label>公告内容:</label>
                            <span class="help-block" id="content" style="color: red"></span>
                        <!-- 加载编辑器的容器 -->
                        <script id="container" name="noticeContent" type="text/plain"></script>

                    </div>

                    <div class="form-group">
                        <label>状态:</label>
                        <label class="radio-inline">
                            <input type="radio" name="noticeStatus" id="inlineRadio1" checked="checked" value="1">发布
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="noticeStatus" id="inlineRadio2" value="0">隐藏
                        </label>
                    </div>
                    <button type="submit" class="btn btn-info" id="addNoticeBtn">提交</button>

                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="managerJavaScript.jsp" %>
<!-- 百度富文本编辑器 -->
<!-- 配置文件 -->
<script src="js/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="js/ueditor/ueditor.all.min.js"></script>
<script>
    //初始化之前删除原有的容器
    UE.delEditor('container');
    //实例化编辑器
    var ue = UE.getEditor('container',{
        initialFrameWidth: '100%',
        initialFrameHeight: '300',
        serverUrl:'file/upload'
    });

    $("#addNoticeBtn").click(function () {
        //每次校验清空提示框中的信息
        $("#notice_title").next("span").text("");
        $("#content").text("");

        //简单校验一下
        var noticeTitle = $("#notice_title").val();
        var content = ue.getContent();//此为html内容
        var content2 = ue.getContentTxt();//此为纯文本
        var content3 = ue.getPlainTxt();//此为带有样式的文本
        if(noticeTitle==""||noticeTitle==null){
            $("#notice_title").next("span").text("请填写标题");
            return false;
        }else if(content==""||content==null){
            $("#content").text("内容不能为空");
            return false;
        }

    })



</script>
</body>
</html>
