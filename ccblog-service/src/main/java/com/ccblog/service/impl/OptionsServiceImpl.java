package com.ccblog.service.impl;

import com.ccblog.common.jedis.JedisClient;
import com.ccblog.common.util.JsonUtils;
import com.ccblog.dao.OptionsMapper;
import com.ccblog.pojo.po.Options;
import com.ccblog.service.OptionsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionsMapper optionsMapper;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public Options getOptionsForPortal() {
        Options options = null;
        //先到集群里面查
        try {
            String json = jedisClient.get("ccblog_portal_options");
            if (StringUtils.isNotBlank(json)) {
                options = JsonUtils.jsonToPojo(json, Options.class);
                return options;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查不到的情况下再去数据库里查
        options = optionsMapper.selectByPrimaryKey(1);
        try{
            jedisClient.set("ccblog_portal_options", JsonUtils.objectToJson(options));
        }catch (Exception e ){
            e.printStackTrace();
        }
        return options;
    }
}

