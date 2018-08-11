package com.ccblog.service.impl;

import com.ccblog.common.dto.Msg;
import com.ccblog.common.util.AddressUtils;
import com.ccblog.dao.OperationlogsMapper;
import com.ccblog.pojo.po.Operationlogs;
import com.ccblog.service.OPLogService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/23/023.
 */
@Service
public class OPLogServiceImpl implements OPLogService {

    @Autowired
    private OperationlogsMapper operationlogsMapper;
    @Override
    public Msg addIndexVisitorVies(String ip, UserAgent userAgent) {
        //获得网友所在地区
        AddressUtils addressUtils = new AddressUtils();
        String region = "";
        try {
            region = addressUtils.getAddresses("ip=" + ip, "UTF-8");
            //region = addressUtils.getAddresses("ip=115.194.120.251", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //获得浏览器，及操作系统
        Browser browser = userAgent.getBrowser();
        OperatingSystem os = userAgent.getOperatingSystem();

        Operationlogs operationlogs = new Operationlogs();
        operationlogs.setOplogIp(ip);
        operationlogs.setOplogCreateTime(new Date());
        operationlogs.setOplogArea(region);
        operationlogs.setOplogComputer(os.toString());
        operationlogs.setOplogBrowser(browser.toString());
        operationlogs.setOplogOperation("进入首页");
        int insertResult = operationlogsMapper.insertSelective(operationlogs);
        if (insertResult != 1) {
            return Msg.fail();
        }else{
            return Msg.success();
        }
    }


}
