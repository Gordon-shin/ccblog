package com.ccblog.service.impl;

import com.ccblog.common.jedis.JedisClient;
import com.ccblog.common.util.JsonUtils;
import com.ccblog.dao.CategoryMapper;
import com.ccblog.dao.custom.ArticleCustomMapper;
import com.ccblog.dao.custom.CategoryCustomMapper;
import com.ccblog.pojo.po.Category;
import com.ccblog.pojo.po.CategoryExample;
import com.ccblog.pojo.vo.CategoryCustom;
import com.ccblog.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryCustomMapper categoryCustomMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleCustomMapper articleCustomMapper;
    @Autowired
    private JedisClient jedisClient;

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<CategoryCustom> listCategory() {
        List<CategoryCustom> categoryList = categoryCustomMapper.getCategoryList();
        for (int i = 0;i<categoryList.size();i++){
            Integer catId = categoryList.get(i).getCategoryId();
            int num = articleCustomMapper.countArticleByCategory(catId);
            categoryList.get(i).setArticleCount(num);
        }
        return categoryList;
    }

    /**
     * 查询所有一级分类
     * @return
     */
    @Override
    public List<CategoryCustom> getAllParentCat() {
        List<CategoryCustom> list = categoryCustomMapper.getAllParentCat();
        return list;
    }


    /**
     * 验证分类名是否重复
     * 用于添加新分类时候ajax校验
     * @param catName
     * @return
     */
    @Override
    public boolean checkCat(String catName) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryNameEqualTo(catName);
        int i = categoryMapper.countByExample(example);
        return i==0;
    }

    /**
     * 添加新的分类。
     * 此方法里要更新redis缓存
     * @param category
     */
    @Override
    public void saveCat(Category category) {
        categoryMapper.insertSelective(category);
        //更新缓存
        jedisClient.expire("ccblog_portal_category",1);
    }

    /**
     * 根据id获得分类信息
     * @param catId
     * @return
     */
    @Override
    public Category getCatById(Integer catId) {
        return categoryMapper.selectByPrimaryKey(catId);
    }

    /**
     * 更新分类。
     * 此方法里要更新redis缓存
     * @param category
     */
    @Override
    public void updateCat(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
        //更新缓存
        jedisClient.expire("ccblog_portal_category",1);
    }

    /**
     * 删除分类。
     * 此方法里要更新redis缓存
     * @param catId
     */
    @Override
    public void deleteCategory(Integer catId) {
        categoryMapper.deleteByPrimaryKey(catId);
        //更新缓存
        jedisClient.expire("ccblog_portal_category",1);
    }

    /**
     * 编辑文章时候，展示所有可用分类，供选择
     * @return
     */
    @Override
    public List<CategoryCustom> getAllCatForEditorArticle() {
        return categoryCustomMapper.getAllCatForEditorArticle();
    }

    /**
     * 查询所有分类，博客门户每个页面头部导航栏都要展示的
     * 利用redis集群做成缓存，提高查询效率
     * @return
     */
    @Override
    public List<CategoryCustom> getAllCatForPortalIndex() {
        List<CategoryCustom> list = null;
        //先到集群里面查
        try {
            String json = jedisClient.get("ccblog_portal_category");
            if (StringUtils.isNotBlank(json)) {
                list = JsonUtils.jsonToList(json, CategoryCustom.class);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查不到的情况下再去数据库里查
        list = categoryCustomMapper.getAllCatForPortalIndex();
        try{
            jedisClient.set("ccblog_portal_category", JsonUtils.objectToJson(list));
        }catch (Exception e ){
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 查询一共有多少个分类
     * 用于博客门户基本信息展示
     * @return
     */
    @Override
    public int countCatForPortal() {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryStatusEqualTo(1);
        int catNum = categoryMapper.countByExample(example);
        return catNum;
    }


}
