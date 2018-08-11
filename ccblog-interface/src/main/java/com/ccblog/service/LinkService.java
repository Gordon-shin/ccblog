package com.ccblog.service;

import com.ccblog.pojo.po.Link;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9/009.
 */
@Service
public interface LinkService {

    //获得全部链接
    List<Link> getLinkList();

    //获得链接综述
    Integer countLink();

    //添加链接
    void addLink(Link link);

    //删除链接
    void deleteLink(Integer linkId);

    //更新链接
    void updateLink(Link link);

    //根据id查询链接
    Link getLinkById(Integer linkId);


    int countLinkForPortal();

    List<Link> getLinkListForPortal();
}
