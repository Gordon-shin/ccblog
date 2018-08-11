package com.ccblog.dao.custom;

import com.ccblog.pojo.vo.CategoryCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryCustomMapper {

    List<CategoryCustom> getCategoryList();

    List<CategoryCustom> getAllParentCat();

    List<CategoryCustom> getAllCatForEditorArticle();

    CategoryCustom getCategoryById(@Param(value="id")Integer articleChildCategoryId);

    List<CategoryCustom> getAllCatForPortalIndex();
}
