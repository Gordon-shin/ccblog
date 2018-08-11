package com.ccblog.service;

import com.ccblog.common.dto.Page;

/**
 * Created by Administrator on 2018/3/20/020.
 */
public interface SearchService {

    Page search(String param, Integer pageSize, Integer pageNo, String type) throws Exception ;
}
