package com.ccblog.service;

import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.vo.ArticleCustom;


import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
public interface ArticleService {

    //获得后台管理首页文章总数
    int getArticleTotalNum();

    //获得后台管理首页展示的最新5篇文章
    List<ArticleCustom> getArticleListForIndex();

    //根据id获得文章
    Article getArticleById(Integer id);

    //检查有没有文章使用过此标签
    boolean checkUsedTag(Integer tagId);

    //查看有没有文章属于这个分类
    boolean checkUsedCategory(Integer catId);

    //查出所有文章展示在后台，全部文章，模块
    List<ArticleCustom> getAllArticleForAdmin();

    //添加新文章
    void addArticle(Article article);

    //得到最新的一篇文章
    ArticleCustom getLastUpdateArticle();

    //获得5篇随机的文章
    List<Article> getRandomArticleList();

    //共有几篇文章？
    int countArticleForPortal();

    // 共有多少评论？
    int coutCommentForPortal();

    //共有多少浏览量？
    int countArticleView();

    //前台首页展示的文章
    List<ArticleCustom> getArticleListForPortalIndex();

    //前台展示文章详情页
    ArticleCustom getArticleDetailByIdForPortal( Integer articleId);

    //获得文章详情中的下一篇文章
    ArticleCustom getNextArticle(Integer articleId);

    //获得文章详情中的上一篇文章
    ArticleCustom getPreviousArticle(Integer articleId);

    //更新文章
    //void updateArticle(Article article);
    void updateArticleForThumbUp(Article article);

    //更新文章for浏览量
    void updateArticleForViews(Article article);

    //根据分类查询文章
    List<ArticleCustom> getArticleListByCategory(Integer categoryId);

    //根据标签查询文章
    List<ArticleCustom> getArticleListByTag(Integer tagId);

    //搜索分页
    List<ArticleCustom> searchArticleForPortal(String query);

    //文章归档
    List<ArticleCustom> articleGuiDang();

    //后台更新修改文章
    void updateArticle(Article article);

    //跳转到admin草稿箱
    List<ArticleCustom> getAllAraftsArticleForAdmin();
}
