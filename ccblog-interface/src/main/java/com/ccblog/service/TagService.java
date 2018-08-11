package com.ccblog.service;

import com.ccblog.pojo.po.Tag;
import com.ccblog.pojo.vo.TagCustom;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9/009.
 */
public interface TagService {

    List<TagCustom> getAllTags();

    void saveTag(Tag tag);

    boolean checkTag(String tagName);

    Tag getTagById(Integer tagId);

    void updateTag(Tag tag);

    void deleteTag(Integer tagId);

    List<TagCustom> getAllTagsForEditorArticle();

    List<TagCustom> getAllTagsForPortalIndex();

    int countTagForPortal();
}
