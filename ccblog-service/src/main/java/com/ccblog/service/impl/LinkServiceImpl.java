package com.ccblog.service.impl;

import com.ccblog.dao.LinkMapper;
import com.ccblog.pojo.po.Link;
import com.ccblog.pojo.po.LinkExample;
import com.ccblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    //获得所有link
    @Override
    public List<Link> getLinkList() {
        LinkExample example = new LinkExample();
        LinkExample.Criteria criteria = example.createCriteria();
        criteria.andLinkIdIsNotNull();
        List<Link> links = linkMapper.selectByExample(example);
        return links;
    }

    //获得链接总数
    @Override
    public Integer countLink() {
        LinkExample example = new LinkExample();
        LinkExample.Criteria criteria = example.createCriteria();
        criteria.andLinkIdIsNotNull();
        return linkMapper.countByExample(example);
    }

    //添加新链接
    @Override
    public void addLink(Link link) {
        linkMapper.insertSelective(link);
    }

    //删除链接
    @Override
    public void deleteLink(Integer linkId) {
        linkMapper.deleteByPrimaryKey(linkId);
    }


    //更新链接
    @Override
    public void updateLink(Link link) {
        linkMapper.updateByPrimaryKeySelective(link);
    }

    //通过id获得链接
    @Override
    public Link getLinkById(Integer linkId) {
        return linkMapper.selectByPrimaryKey(linkId);
    }

    @Override
    public int countLinkForPortal() {
        LinkExample example = new LinkExample();
        LinkExample.Criteria criteria = example.createCriteria();
        criteria.andLinkStatusEqualTo(1);
        return linkMapper.countByExample(example);
    }

    @Override
    public List<Link> getLinkListForPortal() {
        LinkExample example = new LinkExample();
        LinkExample.Criteria criteria = example.createCriteria();
        criteria.andLinkStatusEqualTo(1);
        return linkMapper.selectByExample(example);
    }
}
