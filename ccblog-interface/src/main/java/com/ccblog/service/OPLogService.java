package com.ccblog.service;

import com.ccblog.common.dto.Msg;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * Created by Administrator on 2018/2/23/023.
 */
//操作日志记录
public interface OPLogService {
    public Msg addIndexVisitorVies(String ip, UserAgent userAgent);
}
