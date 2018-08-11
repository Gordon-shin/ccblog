package com.ccblog.service.impl;

import com.ccblog.common.util.AddressUtils;
import com.ccblog.dao.CommentMapper;
import com.ccblog.dao.custom.CommentIndexCutomMapper;
import com.ccblog.pojo.po.Comment;
import com.ccblog.pojo.vo.CommentCustom;
import com.ccblog.service.CommentService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentIndexCutomMapper commentIndexCutomMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int getCommentTotalNum() {
        return commentIndexCutomMapper.getCommentTotalNum();
    }

    @Override
    public List<CommentCustom> getCommentListForIndex() {
        return commentIndexCutomMapper.getCommentListForIndex();
    }

    @Override
    public void addComment(Comment comment,UserAgent userAgent) {
        //获得网友所在地区
        AddressUtils addressUtils = new AddressUtils();
        String region = "";
        try {
            region = addressUtils.getAddresses("ip=" + comment.getCommentIp(), "UTF-8");
            //region = addressUtils.getAddresses("ip=115.194.120.251", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //获得浏览器，及操作系统
        Browser browser = userAgent.getBrowser();
        OperatingSystem os = userAgent.getOperatingSystem();

        comment.setCommentAgent("来自"+region+"的老铁"+"     "+browser.toString()+"|"+os.toString());
        //更新文章评论数
        System.out.println("此时agent为"+comment.getCommentAgent());
        commentMapper.insertSelective(comment);
        commentIndexCutomMapper.updateCommentCountsForArticle(comment.getCommentArticleId());
    }
}
