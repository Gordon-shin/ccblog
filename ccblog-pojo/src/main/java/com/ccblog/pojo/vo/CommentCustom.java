package com.ccblog.pojo.vo;

import com.ccblog.pojo.po.Comment;

public class CommentCustom extends Comment {
    //评论者的头像
    private String commentAuthorAvatar;

    //此评论属于哪个文章
    private String articleTitle;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getCommentAuthorAvatar() {
        return commentAuthorAvatar;
    }

    public void setCommentAuthorAvatar(String commentAuthorAvatar) {
        this.commentAuthorAvatar = commentAuthorAvatar;
    }
}
