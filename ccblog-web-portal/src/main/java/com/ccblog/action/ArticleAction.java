package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.po.Category;
import com.ccblog.pojo.po.Tag;
import com.ccblog.pojo.vo.ArticleCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.CategoryService;
import com.ccblog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ArticleAction {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

   /*前台网站文章详情*/
    @RequestMapping(value = "/article/{articleId}")
    public String getArticleDetailByIdForPortal(@PathVariable("articleId") Integer articleId, Model model){
        //通过id查找文章传给
        ArticleCustom articleDetailCustom = articleService.getArticleDetailByIdForPortal(articleId);
        model.addAttribute("articleDetailCustom", articleDetailCustom);
        //获取下一篇文章
        ArticleCustom afterArticle = articleService.getNextArticle(articleId);
        model.addAttribute("afterArticle", afterArticle);
        //获取上一篇文章
        ArticleCustom preArticle = articleService.getPreviousArticle(articleId);
        model.addAttribute("preArticle", preArticle);
        return "articleDetail";

    }

    //给指定文章点赞加一
    @RequestMapping(value = "/thumbUp/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg thumbUp(@PathVariable("articleId") Integer articleId) {
        Article article = articleService.getArticleById(articleId);
        //当前点赞数
        Integer likeCountNow = article.getArticleLikeCount();
        //增加点赞数
        article.setArticleLikeCount(likeCountNow+1);
        //更新
        articleService.updateArticleForThumbUp(article);
        //放进Msg内，传到页面
        return Msg.success().add("countNum",likeCountNow+1);
    }

    //文章访问量加一
    @RequestMapping(value = "/addViews/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg addViews(@PathVariable("articleId") Integer articleId) {
        Article article = articleService.getArticleById(articleId);
        //当前访问量
        Integer viewCountNow = article.getArticleViewCount();
        //增加访问量
        article.setArticleViewCount(viewCountNow+1);
        //更新
        articleService.updateArticleForViews(article);
        //放进Msg内，传到页面
        return Msg.success().add("viewsNum", viewCountNow + 1);
    }

    //根据分类查询文章
    @RequestMapping("cat/{categoryId}")
    public String getArticleListByCategory(@PathVariable("categoryId")Integer categoryId, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(1,5);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> articleCustomList = articleService.getArticleListByCategory(categoryId);
        PageInfo page = new PageInfo(articleCustomList,5);
        Category category = categoryService.getCatById(categoryId);
        model.addAttribute("category",category);
        model.addAttribute("pageInfo",page);
        return "articleByCategory";
    }

    //分页 根据分类查询文章
    @RequestMapping("/cat/{categoryId}/pn/{pageNum}")
    public String getArticleListByCategoryByPage(@PathVariable("categoryId")Integer categoryId,@PathVariable("pageNum")Integer pageNum, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pageNum,5);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> articleCustomList = articleService.getArticleListByCategory(categoryId);
        PageInfo page = new PageInfo(articleCustomList,5);
        Category category = categoryService.getCatById(categoryId);
        model.addAttribute("pageInfo",page);
        model.addAttribute("category",category);
        return "articleByCategory";
    }

    //根据标签查询文章
    @RequestMapping("/tag/{tagId}")
    public String getArticleListByTag(@PathVariable("tagId") Integer tagId, Model model) {
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(1,5);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> articleList = articleService.getArticleListByTag(tagId);
        PageInfo page = new PageInfo(articleList,5);
        Tag tag = tagService.getTagById(tagId);
        model.addAttribute("pageInfo",page);
        model.addAttribute("tag", tag);
        return "articleByTag";
    }

    //分页 根据标签查询文章
    @RequestMapping("/tag/{tagId}/pn/{pageNum}")
    public String getArticleListByTagByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("tagId") Integer tagId,Model model) {
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pageNum,5);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> articleList = articleService.getArticleListByTag(tagId);
        PageInfo page = new PageInfo(articleList,5);
        Tag tag = tagService.getTagById(tagId);
        model.addAttribute("pageInfo",page);
        model.addAttribute("tag", tag);
        return "articleByTag";
    }

    //搜索
    @RequestMapping("/search")
    public ModelAndView searchArticle(@RequestParam("query")String query,ModelAndView modelAndView) throws UnsupportedEncodingException {
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(1,10);
        //startpage后面紧跟的查询就是一个分页查询
        query.getBytes("utf-8");
        List<ArticleCustom> list = articleService.searchArticleForPortal(query);
        PageInfo page = new PageInfo(list,5);
        modelAndView.addObject("pageInfo", page);
        modelAndView.addObject("query", query);
        modelAndView.setViewName("searchArticle");
        return modelAndView;
    }

    //搜索分页
    @RequestMapping("/search/{query}/pn/{pageNum}")
    public String searchArticleByPage(@PathVariable("pageNum") Integer pageNum,@PathVariable("query")String query,Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pageNum,10);
        //startpage后面紧跟的查询就是一个分页查询
        List<ArticleCustom> list = articleService.searchArticleForPortal(query);
        PageInfo page = new PageInfo(list,5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("query", query);
        return "searchArticle";
    }

    //文章归档

    @RequestMapping("articleGuiDang")
    public String articleGuiDang(Model model) {
        List<ArticleCustom> list = articleService.articleGuiDang();
        model.addAttribute("articleList", list);
        return "articleGuiDang";
    }


}
