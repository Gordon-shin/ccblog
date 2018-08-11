package com.ccblog.service.impl;

import com.ccblog.common.jedis.JedisClient;
import com.ccblog.common.util.JsonUtils;
import com.ccblog.dao.TagMapper;
import com.ccblog.dao.custom.ArticleCustomMapper;
import com.ccblog.dao.custom.TagCustomMapper;
import com.ccblog.pojo.po.Tag;
import com.ccblog.pojo.po.TagExample;
import com.ccblog.pojo.vo.TagCustom;
import com.ccblog.service.TagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagCustomMapper tagCustomMapper;

    @Autowired
    private ArticleCustomMapper articleCustomMapper;

    @Autowired
    private JedisClient jedisClient;

    /**
     * 查询所有tags，用于后台管理编辑tag页面
     * @return
     */
    @Override
    public List<TagCustom> getAllTags() {
        List<TagCustom> tagCustomList = tagCustomMapper.getTagCustomList();
        for (int i = 0;i<tagCustomList.size();i++){
            Integer tagId = tagCustomList.get(i).getTagId();
            int num = articleCustomMapper.countArticleByTag(tagId);
            tagCustomList.get(i).setArticleNum(num);
        }
        return tagCustomList;
    }

    /**
     * 增加新的标签
     * 需要更新redis缓存
     * @param tag
     */
    @Override
    public void saveTag(Tag tag) {
        tagMapper.insertSelective(tag);
        //更新缓存
        jedisClient.expire("ccblog_portal_tags",1);
    }

    /**
     * 检查标签名是否重复，用于添加新标签时候ajax校验。
     * @param tagName
     * @return true ：代表可用  false：代表不可用
     */
    @Override
    public boolean checkTag(String tagName) {
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        criteria.andTagNameEqualTo(tagName);
        int count = tagMapper.countByExample(example);
        return count==0;
    }

    /**
     * 通过id查找标签
     * @param tagId
     * @return
     */
    @Override
    public Tag getTagById(Integer tagId) {
        return tagMapper.selectByPrimaryKey(tagId);
    }

    /**
     * 更新标签
     * 需要更新redis缓存
     * @param tag
     */
    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateByPrimaryKeySelective(tag);
        //更新缓存
        jedisClient.expire("ccblog_portal_tags",1);
    }

    /**
     * 删除标签
     * 需要更新redis缓存
     * @param tagId
     */
    @Override
    public void deleteTag(Integer tagId) {
        tagMapper.deleteByPrimaryKey(tagId);
        //更新缓存
        jedisClient.expire("ccblog_portal_tags",1);
    }

    /**
     * 编辑文章的时候，展示所有标签以供选择
     * @return
     */
    @Override
    public List<TagCustom> getAllTagsForEditorArticle() {
        List<TagCustom> list = tagCustomMapper.getAllTagsForEditorArticle();
        return list;
    }

    /**
     * 博客门户每个页面都会展示的所有标签
     * 利用redis集群做成缓存，提高查询效率
     * 1.先从缓存里面查
     * 2.查不到，再从数据库里查
     * 3.存进缓存,返回结果
     * @return
     */
    @Override
    public List<TagCustom> getAllTagsForPortalIndex() {
        List<TagCustom> list = null;
        //先到集群里面查
        try {
            String json = jedisClient.get("ccblog_portal_tags");
            if (StringUtils.isNotBlank(json)) {
                list = JsonUtils.jsonToList(json, TagCustom.class);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查不到的情况下再去数据库里查
        list = tagCustomMapper.getAllTagsForEditorArticle();
        try{
            jedisClient.set("ccblog_portal_tags", JsonUtils.objectToJson(list));
        }catch (Exception e ){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 一共有多少个标签
     * 用于博客门户基本信息展示
     * @return
     */
    @Override
    public int countTagForPortal() {
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        criteria.andTagStatusEqualTo(1);
        return tagMapper.countByExample(example);
    }
}
