package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Category;
import com.ccblog.pojo.vo.CategoryCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryAction {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/categoryIndex")
    public String categoryIndex(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pn,7);
        //startpage后面紧跟的查询就是一个分页查询
        List<CategoryCustom> categoryCustoms = categoryService.listCategory();
        PageInfo page = new PageInfo(categoryCustoms,5);
        model.addAttribute("pageInfo",page);
        return "categoryIndex";
    }

    /**
     * 查询所有一级分类
     * @return
     */
    @RequestMapping("/getAllParentCat")
    @ResponseBody
    public Msg getAllParentCat(){
        List<CategoryCustom> categoryParentCustomList =  categoryService.getAllParentCat();

        return Msg.success().add("parentCats",categoryParentCustomList);
    }

    /**
     * 查询分类名是否重复
     * @param catName
     * @return
     */
    @RequestMapping("/checkCat")
    @ResponseBody
    public Msg checkCat(@RequestParam(value = "catName")String catName){
        boolean b = categoryService.checkCat(catName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 保存分类
     * @param category
     * @return
     */
    @RequestMapping(value = "saveCat",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveTag(Category category){
        //设置分类状态为1
        category.setCategoryStatus(1);
        categoryService.saveCat(category);
        return Msg.success();
    }

    @RequestMapping(value = "/getCatById/{catId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getCatById(@PathVariable("catId")Integer catId){
        Category category = categoryService.getCatById(catId);
        return Msg.success().add("category",category);
    }


    //更新分类
    @RequestMapping(value = "/updateCat/{categoryId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateCat(Category category){
        categoryService.updateCat(category);
        return Msg.success();
    }

    //检查能不能删此分类
    @RequestMapping("/checkCatDelete")
    @ResponseBody
    public Msg checkCatDelete(@RequestParam("catId")Integer catId){
        boolean flag = articleService.checkUsedCategory(catId);
        if(flag){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }


    //删除分类
    @RequestMapping(value = "/deleteCat/{catId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteCat(@PathVariable("catId")Integer catId){
        categoryService.deleteCategory(catId);
        return Msg.success();
    }
}
