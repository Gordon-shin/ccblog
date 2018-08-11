package com.ccblog.action;

import com.ccblog.pojo.po.Comment;
import com.ccblog.service.ArticleService;
import com.ccblog.service.CommentService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class CommentAction {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public void addComment(HttpServletRequest request, Comment comment){


        //获取ip地址  start
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //获取ip地址end

        //获得UserAgent
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //添加评论
        comment.setCommentIp(ip);
        comment.setCommentCreateTime(new Date());
        commentService.addComment(comment,userAgent);
    }


}
