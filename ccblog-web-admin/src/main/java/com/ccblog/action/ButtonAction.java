package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Custombutton;
import com.ccblog.service.CustombuttonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/2/23/023.
 */
@Controller
public class ButtonAction {

    @Autowired
    private CustombuttonService buttonService;


    @RequestMapping("/buttonIndex")
    public String buttonIndex(Model model){
       List<Custombutton> list =  buttonService.getAllButtonForAdmin();
        model.addAttribute("buttonList", list);
        return "customButtonIndex";
    }

    @RequestMapping(value = "saveButton",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveButton(Custombutton button){
        //设置状态为1
        button.setCustombuttonStatus(1);
        buttonService.addButton(button);
        return Msg.success();

    }


    //删除分类
    @RequestMapping(value = "/deleteButton/{buttonId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteCat(@PathVariable("buttonId")Integer buttonId){
        buttonService.removeButton(buttonId);
        return Msg.success();
    }

}
