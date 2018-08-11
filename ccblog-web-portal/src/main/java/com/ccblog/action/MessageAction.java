package com.ccblog.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/2/16/025.
 */

@Controller
public class MessageAction {

    @RequestMapping("/message")
    public String message(){
        return "messageBoard";
    }

}
