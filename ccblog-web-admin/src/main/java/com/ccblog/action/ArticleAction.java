package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.po.User;
import com.ccblog.pojo.vo.ArticleCustom;
import com.ccblog.pojo.vo.CategoryCustom;
import com.ccblog.pojo.vo.TagCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.CategoryService;
import com.ccblog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
@Controller
public class ArticleAction {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    //通过id获得文章
    @RequestMapping("/getArticleById/{articleId}")
    public String getArticleById(Model model, @PathVariable("articleId") Integer articleId) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "articleDetail";
    }

    //进入到添加文章页面
    @RequestMapping("/editArticle")
    public String editArticle(Model model) {
        List<TagCustom> allTags = tagService.getAllTagsForEditorArticle();
        List<CategoryCustom> allCats = categoryService.getAllCatForEditorArticle();
        model.addAttribute("tags", allTags);
        model.addAttribute("cats", allCats);
        return "addArticle";
    }

    //添加新的文章
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(HttpServletRequest request, Article article) {
        article.setArticlePostTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleIsComment(1);
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        User user = (User) request.getSession().getAttribute("user");
        article.setArticleUserId(user.getUserId());
        articleService.addArticle(article);
        return "redirect:/articleIndex";
    }

    @RequestMapping(value = "/updateArticleById",method = RequestMethod.POST)
    public String updateArticleById(HttpServletRequest request, Article article) {
        article.setArticleUpdateTime(new Date());
        articleService.updateArticle(article);
        return "redirect:/articleIndex";
    }

    //跳转到全部文章页面
    @RequestMapping("/articleIndex")
    public String articleIndex(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pn, 5);
        List<ArticleCustom> articleList = articleService.getAllArticleForAdmin();
        //使用pageInfo包装查询后的数据结果，只需要将pageInfo交给页面就行了
        //navigatePages表示连续显示几页
        PageInfo page = new PageInfo(articleList, 5);
        model.addAttribute("pageInfo", page);
        return "articleIndex";
    }

    @RequestMapping("/draftsIndex")
    public String draftsIndex(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pn, 5);
        List<ArticleCustom> articleList = articleService.getAllAraftsArticleForAdmin();
        //使用pageInfo包装查询后的数据结果，只需要将pageInfo交给页面就行了
        //navigatePages表示连续显示几页
        PageInfo page = new PageInfo(articleList, 5);
        model.addAttribute("pageInfo", page);
        return "draftsIndex";


    }

    //根据id查询文章
    @RequestMapping(value = "/getArticleById/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getArticleById(@PathVariable("articleId") Integer articleId) {
        Article article = articleService.getArticleById(articleId);
        return Msg.success().add("article", article);
    }

    //跳到修改文章页面。
    @RequestMapping(value = "/updataArticle/{articleId}", method = RequestMethod.GET)
    public String updateArticle(@PathVariable("articleId") Integer articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        List<TagCustom> allTags = tagService.getAllTagsForEditorArticle();
        List<CategoryCustom> allCats = categoryService.getAllCatForEditorArticle();
        model.addAttribute("tags", allTags);
        model.addAttribute("cats", allCats);
        model.addAttribute("article", article);
        return "editArticle";
    }

}
