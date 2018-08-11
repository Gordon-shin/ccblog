package com.ccblog.service.impl;

import com.ccblog.dao.NoticeMapper;
import com.ccblog.pojo.po.Notice;
import com.ccblog.pojo.po.NoticeExample;
import com.ccblog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9/009.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    //后台管理获得所有Notice
    @Override
    public List<Notice> getNoticeList() {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeStatusIsNotNull();
        return noticeMapper.selectByExample(example);
    }

    //添加新的Notice
    @Override
    public void addNotice(Notice notice) {
        noticeMapper.insertSelective(notice);
    }

    @Override
    public void deleteNotice(Integer noticeId) {
        noticeMapper.deleteByPrimaryKey(noticeId);
    }

    //前台首页展示的notice
    @Override
    public List<Notice> getNoticeListForPortal() {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeStatusEqualTo(1);
        return noticeMapper.selectByExample(example);
    }

    @Override
    public Notice getNoticeDetaiByIdForPortal(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Override
    public void updateNoticeById(Notice notice) {
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public Notice getNoticeDetailByIdForAdmin(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }
}