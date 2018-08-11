package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Link;
import com.ccblog.pojo.po.Notice;
import com.ccblog.pojo.po.Operationlogs;
import com.ccblog.pojo.vo.ArticleCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.LinkService;
import com.ccblog.service.NoticeService;
import com.ccblog.service.OPLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    @Autowired
    private OPLogService opLogService;


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
    public String index(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model, HttpServletRequest request, HttpServletResponse response){
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

        String cookieName="visitorViewIPOne";
        Cookie cookie=new Cookie(cookieName, ip);
        cookie.setMaxAge(1800); //存活期为10秒
        response.addCookie(cookie);
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

    //进入首页时候，记录访客信息
    @RequestMapping(value = "/addVisitorViews/{visitorViewIPOne}",method = RequestMethod.GET)
    @ResponseBody
    public Msg addVisitorViews(@PathVariable("visitorViewIPOne") String visitorViewIPOne,HttpServletRequest request){
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
        Msg msg = opLogService.addIndexVisitorVies(ip, userAgent);
        return msg;

    }
}
