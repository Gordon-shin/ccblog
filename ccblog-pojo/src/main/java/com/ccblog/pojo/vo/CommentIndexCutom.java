package com.ccblog.pojo.vo;

import com.ccblog.pojo.po.Comment;

/**
 * Created by Administrator on 2018/2/8/008.
 */
public class CommentIndexCutom extends Comment {

    //此评论属于哪个文章
    private String articleTitle;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }


}
