package com.ccblog.action;

import com.ccblog.pojo.po.Link;
import com.ccblog.pojo.po.Notice;
import com.ccblog.pojo.vo.ArticleCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.LinkService;
import com.ccblog.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
@Controller
public class IndexAction {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private LinkService linkService;


    /*@ModelAttribute
    public void init(Model model)  throws Exception {
        //友情链接
        //List<LinkCustom> linkCustomList = linkService.listLink(1);
        //model.addAttribute("linkCustomList",linkCustomList);

        //公告
        List<Notice> noticeList = noticeService.getNoticeListForPortal();
        model.addAttribute("noticeList", noticeList);
    }*/

    //首页显示第一页文章预览部分
    @RequestMapping("/")
    public String index(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pn,5);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> articleCustomList = articleService.getArticleListForPortalIndex();
        PageInfo page = new PageInfo(articleCustomList,5);
        List<Notice> noticeList = noticeService.getNoticeListForPortal();
        List<Link> linkList = linkService.getLinkListForPortal();
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("linkList", linkList);
        model.addAttribute("pageInfo",page);
        return "index";
    }

    //首页部分文章分页
    @RequestMapping("/pn/{pageNum}")
    public String articleByPage(@PathVariable("pageNum") Integer pageNum, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pageNum,5);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> articleCustomList = articleService.getArticleListForPortalIndex();
        PageInfo page = new PageInfo(articleCustomList,5);
        List<Notice> noticeList = noticeService.getNoticeListForPortal();
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("pageInfo",page);
        return "index";
    }
}
