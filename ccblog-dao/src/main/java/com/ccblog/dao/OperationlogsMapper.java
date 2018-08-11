package com.ccblog.dao;

import com.ccblog.pojo.po.Operationlogs;
import com.ccblog.pojo.po.OperationlogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationlogsMapper {
    int countByExample(OperationlogsExample example);

    int deleteByExample(OperationlogsExample example);

    int deleteByPrimaryKey(Integer oplogId);

    int insert(Operationlogs record);

    int insertSelective(Operationlogs record);

    List<Operationlogs> selectByExample(OperationlogsExample example);

    Operationlogs selectByPrimaryKey(Integer oplogId);

    int updateByExampleSelective(@Param("record") Operationlogs record, @Param("example") OperationlogsExample example);

    int updateByExample(@Param("record") Operationlogs record, @Param("example") OperationlogsExample example);

    int updateByPrimaryKeySelective(Operationlogs record);

    int updateByPrimaryKey(Operationlogs record);
}