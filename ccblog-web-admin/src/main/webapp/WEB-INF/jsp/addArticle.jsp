<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/6/006
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加文章</title>
    <%@ include file="manegerStyle.jsp" %>
    <%--ueditor代码高亮--%>
    <link rel="stylesheet" type="text/css" href="/js/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
</head>
<body>
<div class="container">

<div class="row">
    <div class="col-md-12">
        <h1 class="page-head-line">添加文章</h1>
    </div>
</div>

<!-- /. ROW  -->
<div class="row">
    <div class="col-md-10 col-sm-6 col-xs-12">

            <div class="panel-body">
                <form class="form-horizontal" id="articleForm" method="post" action="addArticle">
                    <div class="form-group">
                        <label>文章标题:</label>
                        <input class="form-control" id="article_title" name="articleTitle" type="text">
                        <span class="help-block" style="color: red"></span>
                    </div>
                    <div class="form-group">
                        <label>文章内容:</label>
                        <span class="help-block" id="content" style="color: red"></span>
                        <!-- 加载ueditor编辑器的容器 -->
                        <script id="container" id="article_content" name="articleContent" type="text/plain"></script>
                    </div>

                    <div class="form-group">
                        <label>分类:</label>
                        <select class="form-inline" name="articleParentCategoryId" id="articleParentCategoryId" style="width: 120px;height: 40px;">
                            <option value="">一级分类</option>
                            <c:forEach items="${cats}" var="cat">
                                <c:if test="${cat.categoryPid==0}">
                                    <option value="${cat.categoryId}">${cat.categoryName}</option>
                                </c:if>
                            </c:forEach>

                        </select>

                        <select class="form-inline" name="articleChildCategoryId" id="articleChildCategoryId" style="width: 120px;height: 40px;">
                            <option value="">二级分类</option>
                        </select>
                        <span class="help-block" id="category" style="color: red"></span>


                    </div>

                    <div class="form-group">
                        <label>标签:</label>
                        <c:forEach items="${tags}" var="tag">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="articleTagIds" value="${tag.tagId}"> ${tag.tagName}
                            </label>
                        </c:forEach>
                    </div>

                    <div class="form-group">
                        <label>状态:</label>
                        <label class="radio-inline">
                            <input type="radio" name="articleStatus" id="inlineRadio1" checked="checked" value="1">发布
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="articleStatus" id="inlineRadio2" value="0">草稿
                        </label>
                    </div>


                    <div class="form-group">
                    <button type="submit" id="add_article_btn" class="btn btn-info">提交 </button>
                    </div>

                </form>
            </div>
    </div>

       <%-- <form class="form-horizontal">
            <div class="form-group">
                <label  class="col-sm-2 control-label">文章标题</label>
                <div class="col-sm-6">
                    <input type="email" class="form-control" id="inputEmail3">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">文章内容</label>
                <div class="col-sm-10">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="content" type="text/plain"></script>
                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">文章标题</label>
                <div class="col-sm-6">
                    <select class="form-control" style="width: 102px;height: 32px;">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                    <select class="form-control" style="width: 102px;height: 32px;">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>--%>

</div>

</div>
<%@ include file="managerJavaScript.jsp" %>
<!-- 百度富文本编辑器 -->
<!-- 配置文件 -->
<script src="js/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="js/ueditor/ueditor.all.min.js"></script>
<%--ueditor代码高亮--%>
<script type="text/javascript" src="/js/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<script>
    //初始化之前删除原有的容器
    UE.delEditor('container');
    //实例化编辑器
    var ue = UE.getEditor('container',{

        toolbars: [
            [
                //'anchor', //锚点
                'undo', //撤销
                'redo', //重做
                //'snapscreen', //截图
                'formatmatch', //格式刷
                'blockquote', //引用
                'pasteplain', //纯文本粘贴模式
                //'selectall', //全选
                'print', //打印
                'horizontal', //分隔线
                'removeformat', //清除格式
                'time', //时间
                'date', //日期
                'unlink', //取消链接
                'insertrow', //前插入行
                'insertcol', //前插入列
                'mergeright', //右合并单元格
                'mergedown', //下合并单元格
                'deleterow', //删除行
                'deletecol', //删除列
                'splittorows', //拆分成行
                'splittocols', //拆分成列
                'splittocells', //完全拆分单元格
                'deletecaption', //删除表格标题
                'inserttitle', //插入标题
                'mergecells', //合并多个单元格
                'deletetable', //删除表格
                'cleardoc', //清空文档
                'insertparagraphbeforetable', //"表格前插入行"
                'edittable', //表格属性
                'edittd', //单元格属性
                'link', //超链接
                'emotion', //表情
                'spechars', //特殊字符
                'searchreplace', //查询替换
                'map', //Baidu地图
                //'gmap', //Google地图
                //'insertvideo', //视频
                //'help', //帮助
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'backcolor', //背景色
                'insertorderedlist', //有序列表
                'insertunorderedlist', //无序列表
                'fullscreen', //全屏
                'directionalityltr', //从左向右输入
                'directionalityrtl', //从右向左输入
                'rowspacingtop', //段前距
                'rowspacingbottom', //段后距
                //'pagebreak', //分页
                //'insertframe', //插入Iframe
                'imagenone', //默认
                'imageleft', //左浮动
                'imageright', //右浮动
                'imagecenter', //居中
                //'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
                'customstyle', //自定义标题
                'autotypeset', //自动排版
                //'webapp', //百度应用
                //'touppercase', //字母大写
                //'tolowercase', //字母小写
                //'background', //背景
                //'template', //模板
                //'scrawl', //涂鸦
                'charts', // 图表
                'inserttable', //插入表格
                'insertcode', //代码语言
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                'simpleupload', //单图上传
                'attachment', //附件
                'music', //音乐
                //'insertimage', //多图上传
                'bold', //加粗
                'indent', //首行缩进
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'subscript', //下标
                'fontborder', //字符边框
                'superscript', //上标
                'drafts', // 从草稿箱加载
                'source', //源代码
                'preview', //预览
            ]
        ],
        initialFrameWidth: '100%',
        initialFrameHeight: '400',
        autoHeightEnabled: false,
        serverUrl:'/file/upload'
    });



    $("#articleParentCategoryId").change(function () {
        var optionstring = "";
        var pid = $("#articleParentCategoryId").val();
        <c:forEach items="${cats}" var="cat">
        if(pid==${cat.categoryPid}) {
            optionstring += "<option name='childCategory' value='${cat.categoryId}'>${cat.categoryName}</option>";
        }
        </c:forEach>
        $("#articleChildCategoryId").html("<option value=''selected>二级分类</option>"+optionstring);

            <%--<c:forEach items="${cats}" var="cat">
            var catId = ${cat.categoryPid};
            var catname = ${cat.categoryName};
            var id = ${cat.categoryId};
            if(catId==pid){
                 var  optionEle = $("<option></option>").append(catname).attr("value",id);
                 optionEle.appendTo("#articleForm select[name=articleChildCategoryId]");
            }
            </c:forEach>--%>
    });

    /*$(".btn-info").click(function () {
        var article = $("#articleForm").serialize();
        alert(article);
    })*/

    $("#add_article_btn").click(function () {
        //每次进入校验要清空提示span
        $("#article_title").next("span").text("");
        $("#content").text("");
        $("#category").text("");

        //简单校验一下
        var articletitle = $("#article_title").val();
        var cat1 = $("#articleParentCategoryId").val();
        var cat2 = $("#articleChildCategoryId").val();
        var content = ue.getContent();//此为html内容
        var content2 = ue.getContentTxt();//此为纯文本
        var content3 = ue.getPlainTxt();//此为带有样式的文本
        if(articletitle==""||articletitle==null){
            $("#article_title").next("span").text("请填写标题");
            return false;
        }else if(content==""||content==null){
            $("#content").text("内容不能为空");
            return false;
        }
        /*else if($(cat1==""||cat1==null)){
            $("#category").text("分类呢？？")
            return false;
        }else if($(cat2==""||cat2==null)){
            $("#category").text("分类呢？？")
            return false;
        }*/
    })

    /*代码高亮*/
    SyntaxHighlighter.all();
</script>
</body>
</html>