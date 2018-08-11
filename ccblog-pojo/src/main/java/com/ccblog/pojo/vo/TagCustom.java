package com.ccblog.pojo.vo;

import com.ccblog.pojo.po.Tag;

public class TagCustom extends Tag {

    //使用过此标签的文章数
    private Integer articleNum;

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }
}
