package com.ccblog.interceptor;

import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.po.Custombutton;
import com.ccblog.pojo.po.Options;
import com.ccblog.pojo.vo.ArticleCustom;
import com.ccblog.pojo.vo.CategoryCustom;
import com.ccblog.pojo.vo.TagCustom;
import com.ccblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.ArrayList;
import java.util.List;

public class HomeResourceInterceptor implements WebRequestInterceptor {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private CommentService commentService;
    @Autowired
    private CustombuttonService custombuttonService;


    //用来准备前台首页，及几乎所有页面都需要的信息。如分类，标签，菜单，博客基本信息等，
    @Override
    public void preHandle(WebRequest request) throws Exception {
        //查询出所有分类
        List<CategoryCustom> categoryList = categoryService.getAllCatForPortalIndex();
        request.setAttribute("categoryList",categoryList,WebRequest.SCOPE_SESSION);

        //查询出所有标签  getAllTagsForEditorArticle此方法查询status为1的tag，只查id和name
        List<TagCustom> tagList = tagService.getAllTagsForPortalIndex();
        request.setAttribute("tagList",tagList,WebRequest.SCOPE_REQUEST);

        //查询出所有菜单，用来放在头部,导航栏。易于维护
        List<Custombutton> buttonList = custombuttonService.getAllButtonForPortal();
        request.setAttribute("buttonList",buttonList,WebRequest.SCOPE_REQUEST);

        //右侧边栏显示的东西
        //获得随机文章
        List<Article> articleListForSideBar = articleService.getRandomArticleList();
        request.setAttribute("articleListForSideBar",articleListForSideBar,WebRequest.SCOPE_REQUEST);

        //网站概况
        List<String> blogBaseInfo = new ArrayList<>();
        blogBaseInfo.add(articleService.countArticleForPortal()+"");
        blogBaseInfo.add(articleService.coutCommentForPortal()+"");
        blogBaseInfo.add(categoryService.countCatForPortal()+"");
        blogBaseInfo.add(tagService.countTagForPortal() + "");
        blogBaseInfo.add(linkService.countLinkForPortal() + "");
        blogBaseInfo.add(articleService.countArticleView() + "");
        request.setAttribute("blogBaseInfo",blogBaseInfo,WebRequest.SCOPE_REQUEST);
        //获得最近更新一片文章。用来显示最新更新时间
        ArticleCustom lastUpdateArticle = articleService.getLastUpdateArticle();
        request.setAttribute("lastUpdateArticle",lastUpdateArticle,WebRequest.SCOPE_REQUEST);
        //option
        Options option = optionsService.getOptionsForPortal();
        request.setAttribute("option",option,WebRequest.SCOPE_REQUEST);
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}