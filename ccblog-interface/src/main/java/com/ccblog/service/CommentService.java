package com.ccblog.service;

import com.ccblog.pojo.po.Comment;
import com.ccblog.pojo.vo.CommentCustom;
import eu.bitwalker.useragentutils.UserAgent;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
public interface CommentService {

    //获得总评论数
    int getCommentTotalNum();

    //获得后台管理首页展示的最新5条评论
    List<CommentCustom> getCommentListForIndex();

    //插入新的评论，顺便更新该文章评论数
    void addComment(Comment comment,UserAgent userAgent);
}
