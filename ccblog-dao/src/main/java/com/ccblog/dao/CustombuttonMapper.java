package com.ccblog.dao;

import com.ccblog.pojo.po.Custombutton;
import com.ccblog.pojo.po.CustombuttonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustombuttonMapper {
    int countByExample(CustombuttonExample example);

    int deleteByExample(CustombuttonExample example);

    int deleteByPrimaryKey(Integer custombuttonId);

    int insert(Custombutton record);

    int insertSelective(Custombutton record);

    List<Custombutton> selectByExample(CustombuttonExample example);

    Custombutton selectByPrimaryKey(Integer custombuttonId);

    int updateByExampleSelective(@Param("record") Custombutton record, @Param("example") CustombuttonExample example);

    int updateByExample(@Param("record") Custombutton record, @Param("example") CustombuttonExample example);

    int updateByPrimaryKeySelective(Custombutton record);

    int updateByPrimaryKey(Custombutton record);
}