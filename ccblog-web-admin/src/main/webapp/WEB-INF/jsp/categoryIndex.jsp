<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/14
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="manegerStyle.jsp" %>
</head>
<body>

<%--删除确认模态框--%>
<div class="modal fade" id="DeleteCatModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">警告</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-offset-3">
                    确认删除此分类吗?
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="cat_delete_btn">删除</button>
            </div>
        </div>
    </div>
</div>

<%--拒绝删除模态框--%>
<div class="modal fade" id="rejectDelete"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">
                    警告
                </h4>
            </div>
            <div class="modal-body">
                <div class="col-md-offset-3">
                    拒绝删除
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">好的</button>

            </div>
        </div>
    </div>
</div>

<!-- category更新模态框Modal -->
<div class="modal fade" id="updateCatModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myUpdateModalLabel">修改分类信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateCat_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">分类名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="catname_update_input" name="categoryName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">分类描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="catname_update_desc"  name="categoryDescription">
                            <span class="help-block"></span>
                        </div>
                    </div>

                   <%-- 父分类不能修改，没错，就是不能修改。
                   <div class="form-group">
                        <label  class="col-sm-2 control-label">父分类</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="categoryPid" id="parentCat_update_select">

                            </select>
                        </div>
                    </div>--%>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">分类图标</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="catname_update_icon"  name="categoryIcon" placeholder="可不填">
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">分类状态</label>
                        <div class="col-sm-6">
                            <label class="radio-inline">
                                <input type="radio" name="categoryStatus" id="catStatus1" value="1"> 可用
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="categoryStatus" id="catStatus2" value="0"> 隐藏
                            </label>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"  id="cat_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>


<!-- category添加模态框Modal -->
<div class="modal fade" id="addCatModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加分类</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addCat_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">分类名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="catname_input" name="categoryName" placeholder="必填项">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">分类描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="catname_desc"  name="categoryDescription" placeholder="必填项">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">父分类</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="categoryPid" id="parentCat_add_select">

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">分类图标</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="catname_icon"  name="categoryIcon" placeholder="可不填">
                        </div>
                    </div>




                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"  id="cat_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <%--col-md-12表示占12列 ,也就是占全部列--%>
        <div class="col-md-12">
            <h1 class="page-head-line">分类管理</h1>
        </div>
    </div>

    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-10">
            <button class="btn btn-primary" id="add_cat_btn">新增</button>
        </div>
    </div>

    <%--表格数据内容--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive">
                <tr>
                    <th>ID</th>
                    <th>PID</th>
                    <th>分类名称</th>
                    <th>分类描述</th>
                    <th>文章数</th>
                    <th>分类状态</th>
                    <th>操作按钮</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="category">
                    <tr>
                        <th>${category.categoryId}</th>
                        <th>${category.categoryPid}</th>
                        <th>${category.categoryName}</th>
                        <th>${category.categoryDescription}</th>
                        <th>${category.articleCount}</th>
                        <th>${category.categoryStatus=="1"?"可用":"隐藏"}</th>
                        <th>
                            <button class="btn btn-primary edit_btn" edit_id="${category.categoryId}">
                                <i class="fa fa-pencil"></i>编辑
                            </button>

                            <button class="btn btn-danger delete_btn" delete_id="${category.categoryId}">
                                <i class="fa fa-remove"></i>删除
                            </button>
                        </th>
                    </tr>
                </c:forEach>
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
                    <li><a href="/categoryIndex?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}" >
                        <li>
                            <a href="/categoryIndex?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;上一页</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num==pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>

                        <c:if test="${page_Num!=pageInfo.pageNum}">
                            <li><a href="/categoryIndex?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>

                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}" >
                        <li>
                            <a href="/categoryIndex?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">下一页&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="/categoryIndex?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>


</div>
<%@ include file="managerJavaScript.jsp" %>
<script>

    //点击增加按钮，弹出添加分类模态框
    $("#add_cat_btn").click(function () {
        //发送ajax请求，查出所有一级分类，放到下拉列表中
        getAllParentCat();

        //模态框弹出前都要清空表单数据  以及要校验的input的样式
        $("#addCatModal form")[0].reset();
        $("#catname_input").parent().removeClass("has-error has-success");
        $("#catname_desc").parent().removeClass("has-error has-success");

        //加载模态框
        $("#addCatModal").modal({
            backdrop:"static"
        });
    });
    //发送ajax请求，查出所有一级分类，放到下拉列表中
    function getAllParentCat() {
        $.ajax({
            url:"getAllParentCat",
            type:"GET",
            success:function (result) {
                //每次点击添加按钮时候清空option，避免重复
                $("#parentCat_add_select").find("option").remove();

                //每次写死一个option为父节点选项
                var  optionEleParent = $("<option></option>").append("此节点为父节点").attr("value","0");
                optionEleParent.appendTo("#addCatModal select");

                //遍历Msg中的所有一级分类list，append到option中去
                $.each(result.map.parentCats,function () {
                    var  optionEle = $("<option></option>").append(this.categoryName).attr("value",this.categoryId);
                    optionEle.appendTo("#addCatModal select");
                })
            }
        });
    }


    //点击添加分类模态框中的  添加按钮
    $("#cat_save_btn").click(function () {
        //1.先对要提交的数据进行校验
        if(!validate_addCat()){
            return false;
        }
        //2.判断Cat名校验是否成功
        if($(this).attr("ajax-va")=="error"){
            return false;
        }
        //3.将表单数据提交保存
        $.ajax({
            url:"saveCat",
            type:"POST",
            data:$("#addCat_form").serialize(),
            success:function(result){
                //保存成功后：
                //1：关闭模态框
                $("#addCatModal").modal('hide');
                //2:跳到最后一页
                window.location.href="/categoryIndex?pn=${pageInfo.pages}";
            }
        });
    });
    
    function validate_addCat() {
        //拿到校验的数据,使用正则表达式
        var catname = $("#catname_input").val();
        var catdesc = $("#catname_desc").val();
        //此正则为校验 匹配中文，英文字母和数字及_
        var regCatName = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
        if(!regCatName.test(catname)){
            //每次校验都清空之前的class
            $("#catname_input").parent().removeClass("has-error has-success");
            $("#catname_input").parent().addClass("has-error");
            $("#catname_input").next("span").text("分类名没填哦");
            return false;
        }else{
            $("#catname_input").parent().removeClass("has-error has-success");
            $("#catname_input").parent().addClass("has-success");
            $("#catname_input").next("span").text("");
        }
        if(!regCatName.test(catdesc)){
            $("#catname_desc").parent().removeClass("has-error has-success");
            $("#catname_desc").parent().addClass("has-error");
            $("#catname_desc").next("span").text("分类描述没填哦");
            return false;
        }else{
            $("#catname_desc").parent().removeClass("has-error has-success");
            $("#catname_desc").parent().addClass("has-success");
            $("#catname_desc").next("span").text("");
        }
        return true;

    }

    $("#catname_input").change(function () {
        var catName = this.value;
        $.ajax({
            url:"checkCat",
            data:"catName="+catName,
            type:"POST",
            success:function (result) {
                if(result.code==100){
                    $("#catname_input").parent().removeClass("has-error has-success");
                    $("#catname_input").parent().addClass("has-success");
                    $("#catname_input").next("span").text("分类名名可用");
                    $("#cat_save_btn").attr("ajax-va","success");
                } else{
                    $("#catname_input").parent().removeClass("has-error has-success");
                    $("#catname_input").parent().addClass("has-error");
                    $("#catname_input").next("span").text("分类名名已存在");
                    $("#cat_save_btn").attr("ajax-va","error");
                }
            }
        })
    });

    $(".edit_btn").click(function () {

        //通过ajax查询cat信息，并附给模态框
        getCatById($(this).attr("edit_id"));
        //将自定义属性给模态框的提交按钮
        $("#cat_update_btn").attr("edit_id",$(this).attr("edit_id"));
        $("#updateCatModal").modal({
            backdrop:"static"
        });
    });

    function getCatById(catId) {
        $.ajax({
            url:"getCatById/"+catId,
            type:"GET",
            success:function (result) {
                //把查询到的值附给模态框
                var cat = result.map.category;
                $("#catname_update_input").val(cat.categoryName);
                $("#catname_update_desc").val(cat.categoryDescription);
                $("#catname_update_icon").val(cat.categoryIcon);
                $("#updateCatModal input[name=categoryStatus]").val([cat.categoryStatus]);
            }
        });
    }

    //点击模态框中的更新按钮，所要进行的操作
    $("#cat_update_btn").click(function () {
        //拿到校验的数据,使用正则表达式
        var catname = $("#catname_update_input").val();
        var catdesc = $("#catname_update_desc").val();
        //此正则为校验 匹配中文，英文字母和数字及_
        var regCatName = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
        if(!regCatName.test(catname)){
            //每次校验都清空之前的class
            $("#catname_update_input").parent().removeClass("has-error has-success");
            $("#catname_update_input").parent().addClass("has-error");
            $("#catname_update_input").next("span").text("分类名没填哦");
            return false;
        }else{
            $("#catname_update_input").parent().removeClass("has-error has-success");
            $("#catname_update_input").parent().addClass("has-success");
            $("#catname_update_input").next("span").text("");
        }
        if(!regCatName.test(catdesc)){
            $("#catname_update_desc").parent().removeClass("has-error has-success");
            $("#catname_update_desc").parent().addClass("has-error");
            $("#catname_update_desc").next("span").text("分类描述没填哦");
            return false;
        }else{
            $("#catname_update_desc").parent().removeClass("has-error has-success");
            $("#catname_update_desc").parent().addClass("has-success");
            $("#catname_update_desc").next("span").text("");
        }

        //2，发送ajax请求保存更新的cat数据
        var id = $(this).attr("edit_id");
        $.ajax({
            url:"updateCat/"+id,
            type:"PUT",
            data:$("#updateCatModal form").serialize(),
            success:function (result) {
                //1：关闭模态框
                $("#updateCatModal").modal('hide');
                //2:跳到当前页
                window.location.href="/categoryIndex?pn=${pageInfo.pageNum}";
            }
        });
    })

    //删除分类
    $(".delete_btn").click(function () {
        //检查这个分类能否被删除
        checkCatDelete($(this).attr("delete_id"));
    })

    function checkCatDelete(catId) {

        $.ajax({
            url:"checkCatDelete",
            data:"catId="+catId,
            type:"POST",
            success:function (result) {
                if(result.code==100){
                    //该标签可以删除
                    $("#cat_delete_btn").attr("catDelete_id",catId);
                    $("#DeleteCatModal").modal({});
                }else{
                    //该标签不能删除
                    $("#rejectDelete").modal({});
                }
            }
        });
    }

    //在模态框中删除操作
    $("#cat_delete_btn").click(function () {
        var catId = $(this).attr("catDelete_id");
        var delCatName = $(this).parents("tr").find("th:eq(1)").text();
        $.ajax({
            url:"deleteCat/"+catId,
            type:"GET",
            success:function (result) {
                window.location.href="/categoryIndex?pn=${pageInfo.pageNum}";
            }
        });
    })





</script>
</body>
</html>
