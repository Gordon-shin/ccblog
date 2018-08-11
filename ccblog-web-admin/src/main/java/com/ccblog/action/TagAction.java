package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Tag;
import com.ccblog.pojo.vo.TagCustom;
import com.ccblog.service.ArticleService;
import com.ccblog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TagAction {

    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/tagIndex")
    public  String getTags(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引用pagehelper插件
        //在查询之前调用，传入页码，以及第几页
        PageHelper.startPage(pn,7);
        //startpage后面紧跟的查询就是一个分页查询
        List<TagCustom> tags = tagService.getAllTags();
        //使用pageInfo包装查询后的数据结果，只需要将pageInfo交给页面就行了
        //navigatePages表示连续显示几页
        PageInfo page = new PageInfo(tags,5);
        model.addAttribute("pageInfo",page);
        return "tagIndex";
    }


    @RequestMapping(value = "saveTag",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveTag(Tag tag){
        //设置标签状态为1
        tag.setTagStatus(1);
        tagService.saveTag(tag);
        return Msg.success();
    }

    /**
     * 检查标签名是否重复
     * @param tagName
     * @return
     */
    @RequestMapping("/checkTag")
    @ResponseBody
    public Msg checkTag(@RequestParam(value = "tagName")String tagName){
        boolean b = tagService.checkTag(tagName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 通过id查找tag标签信息
     * @param tagId
     * @return
     */
    @RequestMapping(value = "/getTagById/{tagId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getTagById(@PathVariable("tagId")Integer tagId){
        Tag tag = tagService.getTagById(tagId);
        return Msg.success().add("tag",tag);
    }

    /**
     * 更新tag标签信息
     * @param tag
     * @return
     */
    @RequestMapping(value = "/updateTag/{tagId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateTag(Tag tag){
        tagService.updateTag(tag);
        return Msg.success();
    }

    /**
     * 删除标签方法
     */
    @RequestMapping(value = "/deleteTag/{tagId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteTag(@PathVariable("tagId")Integer tagId){
            tagService.deleteTag(tagId);
            return Msg.success();
    }


    @RequestMapping("/checkArticleByTagId")
    @ResponseBody
    public Msg checkArticlByTagId(@RequestParam("tagId")Integer tagId){
        boolean flag = articleService.checkUsedTag(tagId);
        if(flag){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }


}
