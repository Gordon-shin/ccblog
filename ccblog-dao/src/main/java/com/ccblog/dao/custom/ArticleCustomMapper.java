package com.ccblog.dao.custom;

import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.vo.ArticleCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCustomMapper {
    //获得文章总数
    int getArticleTotalNum();

    //获得后台管理首页展示的最新5篇文章
    List<ArticleCustom> getArticleListForIndex();

    //查询有几篇文章用了此标签
    int countArticleByTag(@Param(value = "tagId") Integer tagId);

    //查看有几篇文章在这个分类下
    int countArticleByCategory(@Param(value = "categoryId") Integer categoryId);

    //后台全部文章模块显示文章列表
    List<ArticleCustom> getArticleListForAdmin();

    //获得最新的一篇文章
    ArticleCustom getLastUpdateArticle();

    //获得5片随机文章
    List<Article> getRandomArticleList();

    //获得总评论数
    int coutCommentForPortal();

    //获得文章总浏览数
    int countArticleView();

    //获得前台的文章list
    List<ArticleCustom> getArticleListForPortalIndex();

    //前台展示文章详情页
    ArticleCustom getArticleDetailByIdForPortal(@Param(value = "articleId")Integer articleId);

    //获得文章详情中的下一篇文章
    ArticleCustom getNextArticle(@Param(value = "articleId")Integer articleId);

    //获得文章详情中的上一篇文章
    ArticleCustom getPreviousArticle(@Param(value = "articleId")Integer articleId);

    //根据分类获取文章List
    List<ArticleCustom> getArticleListByCategory(@Param(value = "categoryId")Integer categoryId);

    //根据标签查询文章list
    List<ArticleCustom> getArticleListByTag(@Param(value = "tagId")Integer tagId);

    //前台搜索文章
    List<ArticleCustom> searchArticleForPortal(@Param(value = "query")String query);

    //文章归档
    List<ArticleCustom> articleGuiDang();

    //后台，所有文章草稿
    List<ArticleCustom> getAllAraftsArticleForAdmin();
}
