package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Link;
import com.ccblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LinkAction {
    @Autowired
    private LinkService linkService;

    /**
     * 进入linkIndex，将linkList传入
     * @param model
     * @return
     */
    @RequestMapping("/linkIndex")
    public String linkIndex(Model model){
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkList",linkList);
        return "linkIndex";
    }

    //查看link详情
    @RequestMapping(value = "/getLinkById/{linkId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getLinkById(@PathVariable("linkId")Integer linkId){
        Link link = linkService.getLinkById(linkId);
        return Msg.success().add("link",link);
    }






}
