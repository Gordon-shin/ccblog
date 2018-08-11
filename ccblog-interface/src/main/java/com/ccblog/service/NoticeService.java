package com.ccblog.service;

import com.ccblog.pojo.po.Notice;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Administrator on 2018/2/9/009.
 */
@Service
public interface NoticeService {

    List<Notice> getNoticeList();

    void addNotice(Notice notice);

    void deleteNotice(Integer noticeId);

    List<Notice> getNoticeListForPortal();

    Notice getNoticeDetaiByIdForPortal(Integer noticeId);

    void updateNoticeById(Notice notice);

    Notice getNoticeDetailByIdForAdmin(Integer noticeId);
}
