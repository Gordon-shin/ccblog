<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/14
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="/js/assets/css/bootstrap.css"  rel="stylesheet" type='text/css' />
    <!-- FONTAWESOME STYLES-->
    <link href="/js/assets/css/font-awesome.css" rel="stylesheet" type='text/css' />
    <!--CUSTOM BASIC STYLES-->
    <link href="/js/assets/css/basic.css" rel="stylesheet" type='text/css' />
    <!--CUSTOM MAIN STYLES-->
    <link href="/js/assets/css/custom.css" rel="stylesheet" type='text/css' />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <style>
        .container {height:100% ; width:100%; position:absolute;}
        .page-inner {height:100% ; width:100%; position:absolute;}

    </style>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-head-line">修改公告信息</h1>
        </div>
    </div>

    <!-- /. ROW  -->
    <div class="row">
        <div class="col-md-10 col-sm-6 col-xs-12">
            <div class="panel-body">
                <form role="form" id="addNoticeForm" action="/updateNotice" method="post">
                    <input type="hidden" name="noticeId" value="${notice.noticeId}">
                    <div class="form-group">
                        <label>公告标题:</label>

                        <input class="form-control" name="noticeTitle" id="notice_title" value="${notice.noticeTitle}" type="text">
                        <span class="help-block" style="color: red"></span>

                    </div>
                    <div class="form-group">
                        <label>公告内容:</label>
                        <span class="help-block" id="content" style="color: red"></span>
                        <!-- 加载编辑器的容器 -->
                        <script id="container" name="noticeContent" type="text/plain">
                            ${notice.noticeContent}
                        </script>

                    </div>

                    <div class="form-group">
                        <label>状态:</label>
                        <label class="radio-inline">
                            <input type="radio" name="noticeStatus" id="inlineRadio1" <c:if test="${notice.noticeStatus==1}">checked</c:if> value="1">发布
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="noticeStatus" id="inlineRadio2" <c:if test="${notice.noticeStatus==0}">checked</c:if> value="0">隐藏
                        </label>
                    </div>

                    <button type="submit" class="btn btn-info" id="addNoticeBtn">提交</button>

                </form>
            </div>
        </div>
    </div>


</div>
<!-- JQUERY SCRIPTS -->
<script src="/js/assets/js/jquery-1.10.2.js" type="text/javascript" ></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="/js/assets/js/bootstrap.js" type="text/javascript" ></script>
<!-- METISMENU SCRIPTS -->
<script src="/js/assets/js/jquery.metisMenu.js" type="text/javascript" ></script>

<!-- 百度富文本编辑器 -->
<!-- 配置文件 -->
<script src="/js/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="/js/ueditor/ueditor.all.min.js"></script>
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
