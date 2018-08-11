package com.ccblog.action;

import com.ccblog.pojo.po.User;
import com.ccblog.pojo.vo.ArticleCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.CommentService;
import com.ccblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
/**
 * Created by Administrator on 2018/1/31/031.
 */

public class IndexAction {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    public String index(Model model) {
        //打印验证码
        return "index";
    }

    @RequestMapping("/uerInfo")
    public String uerInfo(Model model) {
        User user = userService.testShowUser(1);
        model.addAttribute("user", user);
        return "userInfo";
    }

    @RequestMapping("/mainTest")
    public String mainTest(Model model) {
        //获得后台首页要展示的信息:文章总数，评论总数，最近文章，评论。
        int articleTotalNum = articleService.getArticleTotalNum();
        List<ArticleCustom> articleList = articleService.getArticleListForIndex();
        model.addAttribute("articleTotalNum", articleTotalNum);
        model.addAttribute("articleList", articleList);
       /* int commentTotalNum = commentService.getCommentTotalNum();
        List<CommentCustom> commentList = commentService.getCommentListForIndex();
        model.addAttribute("commentTotalNum",commentTotalNum);
        model.addAttribute("commentList",commentList);*/
        return "main";
    }
}
