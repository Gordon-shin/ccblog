<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 2018/2/12
  Time: 16:16
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
             该标签已被文章使用不能删除
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">好的</button>

            </div>
        </div>
    </div>
</div>

<%--删除确认模态框--%>
<div class="modal fade" id="DeleteTagModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">警告</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-offset-3">
                    确认删除此标签吗?
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="tag_delete_btn">删除</button>
            </div>
        </div>
    </div>
</div>

<%--修改标签模态框--%>
<div class="modal fade" id="updateTagModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">修改标签</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateTag_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标签名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="tagname_update_input" name="tagName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">标签描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="tagname_update_desc"  name="tagDescription">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">标签状态</label>
                        <div class="col-sm-6">
                            <label class="radio-inline">
                                <input type="radio" name="tagStatus" id="tagStatus1" value="1"> 可用
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="tagStatus" id="tagStatus2" value="0"> 隐藏
                            </label>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="tag_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>


<!-- tag添加模态框Modal -->
<div class="modal fade" id="addTagModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加标签</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addTag_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标签名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="tagname_input" name="tagName" placeholder="别太长啊">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">标签描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="tagname_desc"  name="tagDescription" placeholder="随便描述吧">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"  id="tag_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>


<div class="container">
  <%--  标题--%>
<div class="row">
    <%--col-md-12表示占12列 ,也就是占全部列--%>
    <div class="col-md-12">
        <h1 class="page-head-line">标签管理</h1>
    </div>
</div>

      <%--按钮--%>
      <div class="row">
          <div class="col-md-4 col-md-offset-10">
              <button class="btn btn-primary" id="add_tag_btn">新增</button>
          </div>
      </div>
        <%--表格数据内容--%>
      <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>标签名</th>
                    <th>标签描述</th>
                    <th>文章数</th>
                    <th>标签状态</th>
                    <th>操作按钮</th>
                </tr>
                </thead>
                <tbody>
        <c:forEach items="${pageInfo.list}" var="tag">
                <tr>
                    <th>${tag.tagId}</th>
                    <th>${tag.tagName}</th>
                    <th>${tag.tagDescription}</th>
                    <th>${tag.articleNum}</th>
                    <th>${tag.tagStatus=="1"?"可用":"隐藏"}</th>
                    <th>
                        <button class="btn btn-primary edit_btn" edit_id="${tag.tagId}">
                            <i class="fa fa-pencil"></i>编辑
                        </button>

                        <button class="btn btn-danger delete_btn" delete_id="${tag.tagId}">
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
                  <li><a href="/tagIndex?pn=1">首页</a></li>
                  <c:if test="${pageInfo.hasPreviousPage}" >
                      <li>
                          <a href="/tagIndex?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                              <span aria-hidden="true">&laquo;上一页</span>
                          </a>
                      </li>
                  </c:if>

                  <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                      <c:if test="${page_Num==pageInfo.pageNum}">
                          <li class="active"><a href="#">${page_Num}</a></li>
                      </c:if>

                      <c:if test="${page_Num!=pageInfo.pageNum}">
                          <li><a href="/tagIndex?pn=${page_Num}">${page_Num}</a></li>
                      </c:if>

                  </c:forEach>

                  <c:if test="${pageInfo.hasNextPage}" >
                      <li>
                          <a href="/tagIndex?pn=${pageInfo.pageNum+1}" aria-label="Next">
                              <span aria-hidden="true">下一页&raquo;</span>
                          </a>
                      </li>
                  </c:if>


                  <li><a href="/tagIndex?pn=${pageInfo.pages}">末页</a></li>
              </ul>
          </nav>
          </div>
      </div>


</div>
<%@ include file="managerJavaScript.jsp" %>
<script>

  /* 加载增加标签模态框*/
    $("#add_tag_btn").click(function () {
        //模态框弹出前都要清空表单数据
        $("#addTagModal form")[0].reset();
        $("#addTagModal").modal({
            backdrop:"static"
        });
    });

    //表单校验
    function validate_addTag() {
        //拿到校验的数据,使用正则表达式
        var tagname = $("#tagname_input").val();
        var tagdesc = $("#tagname_desc").val();
        //此正则为校验 匹配中文，英文字母和数字及_
        var regTagName = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
        if(!regTagName.test(tagname)){
            //每次校验都清空之前的class
            $("#tagname_input").parent().removeClass("has-error has-success");
            $("#tagname_input").parent().addClass("has-error");
            $("#tagname_input").next("span").text("标签名没填哦");
            return false;
        }else{
            $("#tagname_input").parent().removeClass("has-error has-success");
            $("#tagname_input").parent().addClass("has-success");
            $("#tagname_input").next("span").text("");
        }
        if(!regTagName.test(tagdesc)){
            $("#tagname_desc").parent().removeClass("has-error has-success");
            $("#tagname_desc").parent().addClass("has-error");
            $("#tagname_desc").next("span").text("标签描述没填哦");
            return false;
        }else{
            $("#tagname_desc").parent().removeClass("has-error has-success");
            $("#tagname_desc").parent().addClass("has-success");
            $("#tagname_desc").next("span").text("");
        }
        return true;

    }

    //校验标签名是否重复
    $("#tagname_input").change(function () {
        var tagName = this.value;
        $.ajax({
            url:"checkTag",
            data:"tagName="+tagName,
            type:"POST",
            success:function (result) {
               if(result.code==100){
                   $("#tagname_input").parent().removeClass("has-error has-success");
                   $("#tagname_input").parent().addClass("has-success");
                   $("#tagname_input").next("span").text("标签名可用");
                   $("#tag_save_btn").attr("ajax-va","success");
               } else{
                   $("#tagname_input").parent().removeClass("has-error has-success");
                   $("#tagname_input").parent().addClass("has-error");
                   $("#tagname_input").next("span").text("标签名已存在");
                   $("#tag_save_btn").attr("ajax-va","error");
               }
            }
        })
    });

    $("#tag_save_btn").click(function () {
        //1.先对要提交的数据进行校验
        if(!validate_addTag()){
            return false;
        }
        //2.判断tag名校验是否成功
        if($(this).attr("ajax-va")=="error"){
            return false;
        }
        //3.将表单数据提交保存
        $.ajax({
            url:"saveTag",
            type:"POST",
            data:$("#addTag_form").serialize(),
            success:function(result){
                //保存成功后：
                //1：关闭模态框
                $("#addTagModal").modal('hide');
                //2:跳到最后一页
                window.location.href="/tagIndex?pn=${pageInfo.pages}";

            }

        });
    });

    $(".edit_btn").click(function () {

        //通过ajax查询tag信息，并附给模态框
        getTagById($(this).attr("edit_id"));
        //将自定义属性给模态框的提交按钮
        $("#tag_update_btn").attr("edit_id",$(this).attr("edit_id"));
        $("#updateTagModal").modal({
            backdrop:"static"
        });
    });

    function getTagById(tagId) {
        $.ajax({
            url:"getTagById/"+tagId,
            type:"GET",
            success:function (result) {
                //把查询到的值附给模态框
                var tag = result.map.tag;
                $("#tagname_update_input").val(tag.tagName);
                $("#tagname_update_desc").val(tag.tagDescription);
                $("#updateTagModal input[name=tagStatus]").val([tag.tagStatus]);
            }
        });

    }

//    更新tag方法
    $("#tag_update_btn").click(function () {
        //验证数据
        //拿到校验的数据,使用正则表达式
        var tagname = $("#tagname_update_input").val();
        var tagdesc = $("#tagname_update_desc").val();
        //此正则为校验 匹配中文，英文字母和数字及_
        var regTagName = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
        if(!regTagName.test(tagname)){
            //每次校验都清空之前的class
            $("#tagname_update_input").parent().removeClass("has-error has-success");
            $("#tagname_update_input").parent().addClass("has-error");
            $("#tagname_update_input").next("span").text("标签名没填哦");
            return false;
        }else{
            $("#tagname_update_input").parent().removeClass("has-error has-success");
            $("#tagname_update_input").parent().addClass("has-success");
            $("#tagname_update_input").next("span").text("");
        }
        if(!regTagName.test(tagdesc)){
            $("#tagname_update_desc").parent().removeClass("has-error has-success");
            $("#tagname_update_desc").parent().addClass("has-error");
            $("#tagname_update_desc").next("span").text("标签描述没填哦");
            return false;
        }else{
            $("#tagname_update_desc").parent().removeClass("has-error has-success");
            $("#tagname_update_desc").parent().addClass("has-success");
            $("#tagname_update_desc").next("span").text("");
        }
        //2，发送ajax请求保存更新的tag数据
        var id = $(this).attr("edit_id");
       $.ajax({
          url:"updateTag/"+id,
          type:"PUT",
          data:$("#updateTagModal form").serialize(),
           success:function (result) {
               //1：关闭模态框
               $("#updateTagModal").modal('hide');
               //2:跳到当前页
               window.location.href="/tagIndex?pn=${pageInfo.pageNum}";
           }
       });
    });

    $(".delete_btn").click(function () {
        //确认此标签是否已经被文章使用，如被使用拒绝删除
        checkTagFromArticle($(this).attr("delete_id"));
    });

    function checkTagFromArticle(id) {
        $.ajax({
            url:"checkArticleByTagId",
            data:"tagId="+id,
            type:"POST",
            success:function (result) {
                if(result.code==100){
                    //该标签可以删除
                    $("#tag_delete_btn").attr("tagDelete_id",id);
                    $("#DeleteTagModal").modal({
                       /* backdrop:"static"*/
                    });
                }else{
                    //该标签不能删除
                    $("#rejectDelete").modal({});
                }
            }
        })
    }
//        在模态框里面进行删除操作
        $("#tag_delete_btn").click(function () {
            var tagId = $(this).attr("tagDelete_id");
            var delTagName = $(this).parents("tr").find("th:eq(1)").text();
            $.ajax({
                url:"deleteTag/"+tagId,
                type:"GET",
                success:function (result) {
                    $("#DeleteTagModal").modal('hide');
                    window.location.href="/tagIndex?pn=${pageInfo.pageNum}";
                }
            });
        });

</script>

</body>
</html>
