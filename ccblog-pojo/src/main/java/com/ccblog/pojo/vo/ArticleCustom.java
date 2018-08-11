package com.ccblog.pojo.vo;

import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.po.User;

import java.util.List;

public class ArticleCustom extends Article {

    //发布此文章作者姓名
    private String articleAuthorName;

    //发布者信息
    private User user;

    //一级分类名称
    private String parentCategory;

    //二级分类名称
    private String childCategory;

    //文章对应的分类
    private List<CategoryCustom> categoryCustomList;

    //此文章用过的标签
    private List<TagCustom> tags;

    //评论信息
    private List<CommentCustom> commentCustomList;

    public String getArticleAuthorName() {
        return articleAuthorName;
    }

    public void setArticleAuthorName(String articleAuthorName) {
        this.articleAuthorName = articleAuthorName;
    }

    public List<CategoryCustom> getCategoryCustomList() {
        return categoryCustomList;
    }

    public void setCategoryCustomList(List<CategoryCustom> categoryCustomList) {
        this.categoryCustomList = categoryCustomList;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(String childCategory) {
        this.childCategory = childCategory;
    }

    public List<TagCustom> getTags() {
        return tags;
    }

    public void setTags(List<TagCustom> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CommentCustom> getCommentCustomList() {
        return commentCustomList;
    }

    public void setCommentCustomList(List<CommentCustom> commentCustomList) {
        this.commentCustomList = commentCustomList;
    }
}
