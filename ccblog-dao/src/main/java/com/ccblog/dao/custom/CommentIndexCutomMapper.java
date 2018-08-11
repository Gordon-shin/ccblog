package com.ccblog.dao.custom;

import com.ccblog.pojo.vo.CommentCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
public interface CommentIndexCutomMapper {

    //获得总评论数
    int getCommentTotalNum();

    //获得后台管理首页展示的最新5条评论
    List<CommentCustom> getCommentListForIndex();

    //获得文章详情页下的评论
    List<CommentCustom> listCommentByArticleId(@Param(value="id") Integer articleId);

    void updateCommentCountsForArticle(@Param(value = "articleId")Integer articleId);
}
