package com.ccblog.service.impl;

import com.ccblog.common.jedis.JedisClient;
import com.ccblog.common.util.JsonUtils;
import com.ccblog.dao.CustombuttonMapper;
import com.ccblog.pojo.po.Custombutton;
import com.ccblog.pojo.po.CustombuttonExample;
import com.ccblog.service.CustombuttonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义按钮
 * Created by Administrator on 2018/2/23/023.
 */

@Service
public class CustombuttonServiceImpl implements CustombuttonService {


    @Autowired
    private CustombuttonMapper buttonMapper;
    @Autowired
    private JedisClient jedisClient;
    //后台管理获得所有自定义按钮
    @Override
    public List<Custombutton> getAllButtonForAdmin() {
        CustombuttonExample example = new CustombuttonExample();
        CustombuttonExample.Criteria criteria = example.createCriteria();
        criteria.andCustombuttonIdIsNotNull();
        List<Custombutton> custombuttons = buttonMapper.selectByExample(example);
        return custombuttons;
    }

    //添加新的自定义按钮
    @Override
    public void addButton(Custombutton button) {
        buttonMapper.insertSelective(button);
        jedisClient.expire("ccblog_portal_custombutton",1);
    }

    //删除自定义按钮
    @Override
    public void removeButton(Integer buttonId) {
        buttonMapper.deleteByPrimaryKey(buttonId);
        jedisClient.expire("ccblog_portal_custombutton",1);
    }

    /**
     * 在博客门户展示左右自定义菜单
     * 做成redis缓存
     * @return
     */
    @Override
    public List<Custombutton> getAllButtonForPortal() {
        List<Custombutton> list = null;
        //先到集群里面查
        try {
            String json = jedisClient.get("ccblog_portal_custombutton");
            if (StringUtils.isNotBlank(json)) {
                list = JsonUtils.jsonToList(json, Custombutton.class);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //查不到，从数据库查，然后存入集群
        CustombuttonExample example = new CustombuttonExample();
        CustombuttonExample.Criteria criteria = example.createCriteria();
        criteria.andCustombuttonStatusEqualTo(1);
        list = buttonMapper.selectByExample(example);
        try{
            jedisClient.set("ccblog_portal_custombutton", JsonUtils.objectToJson(list));
        }catch (Exception e ){
            e.printStackTrace();
        }
        return list;
    }
}
