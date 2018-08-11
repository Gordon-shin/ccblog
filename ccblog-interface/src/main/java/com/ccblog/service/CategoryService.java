package com.ccblog.service;

import com.ccblog.pojo.po.Category;
import com.ccblog.pojo.vo.CategoryCustom;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9/009.
 */
public interface CategoryService {

    public List<CategoryCustom> listCategory();

    List<CategoryCustom> getAllParentCat();

    boolean checkCat(String catName);

    void saveCat(Category category);

    Category getCatById(Integer catId);

    void updateCat(Category category);

    void deleteCategory(Integer catId);

    List<CategoryCustom> getAllCatForEditorArticle();

    List<CategoryCustom> getAllCatForPortalIndex();

    int countCatForPortal();
}
