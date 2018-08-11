package com.ccblog.dao.custom;

import com.ccblog.pojo.vo.TagCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagCustomMapper {

    List<TagCustom> getTagCustomList();

    List<TagCustom> getAllTagsForEditorArticle();

    TagCustom getTagById(@Param(value="id")Integer integer);
}
