package com.ccblog.action;

import com.ccblog.pojo.po.Notice;
import com.ccblog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/2/25/025.
 */
@Controller
public class NoticeAction {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/notice/{noticeId}", method = RequestMethod.GET)
    public String noticeDetail(@PathVariable("noticeId")Integer noticeId, Model model) {
        Notice notice = noticeService.getNoticeDetaiByIdForPortal(noticeId);
        model.addAttribute("noticeCustom", notice);
        return "notice";
    }

}
