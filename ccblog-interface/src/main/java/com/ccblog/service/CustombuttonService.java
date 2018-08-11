package com.ccblog.service;

import com.ccblog.pojo.po.Custombutton;

import java.util.List;

/**
 * Created by Administrator on 2018/2/23/023.
 */
public interface CustombuttonService {

    //后台管理获得所有自定义按钮
    List<Custombutton> getAllButtonForAdmin();

    //添加新的自定义按钮
    void addButton(Custombutton button);

    //删除自定义按钮
    void removeButton(Integer buttonId);

    List<Custombutton> getAllButtonForPortal();
}
