package com.ccblog.action;

import com.ccblog.common.dto.Msg;
import com.ccblog.pojo.po.Notice;
import com.ccblog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class NoticeAction {

    @Autowired
    private NoticeService noticeService;


    //跳转到添加Notice编辑页面
    @RequestMapping("/editNotice")
    public String editNotice(){
        return"addNotice";
    }

    //进入Notice首页
    @RequestMapping("/noticeIndex")
    public String noticeIndex(Model model){
        List<Notice> noticeList = noticeService.getNoticeList();
        for(int i = 0;i<noticeList.size();i++){
            /*提出html标签*/
            String content = noticeList.get(i).getNoticeContent().replaceAll("</?[^>]+>", "");
            /*去除字符串中的空格,回车,换行符,制表符  */
            content = content.replaceAll("<a>\\s*|\t|\r|\n</a>", "");
            noticeList.get(i).setNoticeContent(content);
        }
        model.addAttribute("noticeList",noticeList);
        return "noticeIndex";
    }


    //添加新公告Notice
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    public String addNotice(Notice notice){
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeUpdateTime(new Date());
        noticeService.addNotice(notice);
        return "redirect:/noticeIndex";
    }

    @RequestMapping(value = "/toUpdateNotice/{noticeId}", method = RequestMethod.GET)
    public String toUpdateNotice(@PathVariable("noticeId") Integer noticeId, Model model) {
        Notice notice = noticeService.getNoticeDetailByIdForAdmin(noticeId);
        model.addAttribute("notice", notice);

        return "editNotice";
    }

    //更新公告
    @RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
    public String updateNotice(Notice notice) {
        notice.setNoticeUpdateTime(new Date());
        noticeService.updateNoticeById(notice);
        return "redirect:/noticeIndex";
    }

    //删除公告
    @RequestMapping(value = "deleteNotice/{noticeId}",method = RequestMethod.GET)
    @ResponseBody
    public Msg removeNotice(@PathVariable("noticeId")Integer noticeId){
        noticeService.deleteNotice(noticeId);
        return Msg.success();
    }




}
