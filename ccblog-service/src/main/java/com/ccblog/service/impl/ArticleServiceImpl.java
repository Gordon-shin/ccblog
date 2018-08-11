package com.ccblog.service.impl;

import com.ccblog.dao.ArticleMapper;
import com.ccblog.dao.UserMapper;
import com.ccblog.dao.custom.ArticleCustomMapper;
import com.ccblog.dao.custom.CategoryCustomMapper;
import com.ccblog.dao.custom.CommentIndexCutomMapper;
import com.ccblog.dao.custom.TagCustomMapper;
import com.ccblog.pojo.po.Article;
import com.ccblog.pojo.po.ArticleExample;
import com.ccblog.pojo.po.User;
import com.ccblog.pojo.vo.*;
import com.ccblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/8/008.
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleCustomMapper articleCustomMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryCustomMapper categoryCustomMapper;
    @Autowired
    private TagCustomMapper tagCustomMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentIndexCutomMapper commentIndexCutomMapper;


    @Override
    public int getArticleTotalNum() {
        return articleCustomMapper.getArticleTotalNum();
    }

    @Override
    public List<ArticleCustom> getArticleListForIndex() {
        return articleCustomMapper.getArticleListForIndex();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean checkUsedTag(Integer tagId) {
        int i = articleCustomMapper.countArticleByTag(tagId);
        if(i==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsedCategory(Integer catId) {
        int i = articleCustomMapper.countArticleByCategory(catId);
        return i==0;
    }

    @Override
    public List<ArticleCustom> getAllArticleForAdmin() {
        List<ArticleCustom> articleList = articleCustomMapper.getArticleListForAdmin();

        for(int i = 0;i<articleList.size();i++){
            //先查询出此文章的父级和二级分类的名称，赋值
            CategoryCustom categoryCustom = categoryCustomMapper.getCategoryById(articleList.get(i).getArticleChildCategoryId());
            articleList.get(i).setChildCategory(categoryCustom.getCategoryName());
            articleList.get(i).setParentCategory(categoryCustom.getCategoryPname());
            //设置List<TagCustom>  tags 属性
            //在此定义一个tags；
            List<TagCustom> tags = new ArrayList<>();
            String tagsId = articleList.get(i).getArticleTagIds();
            //去除掉没有标签的文章可能性
            if (tagsId != null && tagsId != "") {
                String[] tagId = tagsId.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    TagCustom tagCustom = tagCustomMapper.getTagById(Integer.valueOf(tagId[j]));
                    //防止标签不存在，被删除
                    if (tagCustom != null) {
                        tags.add(tagCustom);
                    }
                }
            }
            articleList.get(i).setTags(tags);

            //设置用户信息
            User user = userMapper.selectByPrimaryKey(articleList.get(i).getArticleUserId());
            articleList.get(i).setUser(user);
        }
        return articleList;
    }

    @Override
    public List<ArticleCustom> getAllAraftsArticleForAdmin() {
        List<ArticleCustom> articleList = articleCustomMapper.getAllAraftsArticleForAdmin();

        for(int i = 0;i<articleList.size();i++){
            //先查询出此文章的父级和二级分类的名称，赋值
            CategoryCustom categoryCustom = categoryCustomMapper.getCategoryById(articleList.get(i).getArticleChildCategoryId());
            articleList.get(i).setChildCategory(categoryCustom.getCategoryName());
            articleList.get(i).setParentCategory(categoryCustom.getCategoryPname());
            //设置List<TagCustom>  tags 属性
            //在此定义一个tags；
            List<TagCustom> tags = new ArrayList<>();
            String tagsId = articleList.get(i).getArticleTagIds();
            //去除掉没有标签的文章可能性
            if (tagsId != null && tagsId != "") {
                String[] tagId = tagsId.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    TagCustom tagCustom = tagCustomMapper.getTagById(Integer.valueOf(tagId[j]));
                    //防止标签不存在，被删除
                    if (tagCustom != null) {
                        tags.add(tagCustom);
                    }
                }
            }
            articleList.get(i).setTags(tags);

            //设置用户信息
            User user = userMapper.selectByPrimaryKey(articleList.get(i).getArticleUserId());
            articleList.get(i).setUser(user);
        }
        return articleList;
    }

    //添加新的文章
    @Override
    public void addArticle(Article article) {
       articleMapper.insertSelective(article);
    }

    //获得最新更新的一篇文章，获取其日期即可
    @Override
    public ArticleCustom getLastUpdateArticle() {
        return articleCustomMapper.getLastUpdateArticle();
    }

    //获得随机的5篇文章
    @Override
    public List<Article> getRandomArticleList() {
        return articleCustomMapper.getRandomArticleList();
    }

    //文章总数
    @Override
    public int countArticleForPortal() {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andArticleStatusEqualTo(1);
        return articleMapper.countByExample(example);
    }

    //文章总评论数
    @Override
    public int coutCommentForPortal() {
        return articleCustomMapper.coutCommentForPortal();
    }

    //文章总浏览量
    @Override
    public int countArticleView() {

        return articleCustomMapper.countArticleView();
    }


    //前台首页展示的文章
    @Override
    public List<ArticleCustom> getArticleListForPortalIndex() {
        List<ArticleCustom> articleList = articleCustomMapper.getArticleListForPortalIndex();
        for(int i = 0;i<articleList.size();i++){

            /*提出html标签*/
                String content = articleList.get(i).getArticleContent().replaceAll("</?[^>]+>", "");
            /*去除字符串中的空格,回车,换行符,制表符  */
                content = content.replaceAll("<a>\\s*|\t|\r|\n</a>", "");
                articleList.get(i).setArticleContent(content);

            //把分类list设置了。
            List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
            categoryCustomList.add(categoryCustomMapper.getCategoryById(articleList.get(i).getArticleParentCategoryId()));
            categoryCustomList.add(categoryCustomMapper.getCategoryById(articleList.get(i).getArticleChildCategoryId()));
            articleList.get(i).setCategoryCustomList(categoryCustomList);

            //设置List<TagCustom>  tags 属性
            //在此定义一个tags；
            //List<TagCustom> tags = new ArrayList<>();
            //String tagsId = articleList.get(i).getArticleTagIds();
            //去除掉没有标签的文章可能性
           /* if (tagsId != null && tagsId != "") {
                String[] tagId = tagsId.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    TagCustom tagCustom = tagCustomMapper.getTagById(Integer.valueOf(tagId[j]));
                    //防止标签不存在，被删除
                    if (tagCustom != null) {
                        tags.add(tagCustom);
                    }
                }
            }
            articleList.get(i).setTags(tags);*/

            //设置用户信息
            //User user = userMapper.selectByPrimaryKey(articleList.get(i).getArticleUserId());
            //articleList.get(i).setUser(user);
        }
        return articleList;
    }

    //根据分类查询文章
    @Override
    public List<ArticleCustom> getArticleListByCategory(Integer categoryId) {
        List<ArticleCustom> articleList = articleCustomMapper.getArticleListByCategory(categoryId);
        for(int i = 0;i<articleList.size();i++){

            /*提出html标签*/
            String content = articleList.get(i).getArticleContent().replaceAll("</?[^>]+>", "");
            /*去除字符串中的空格,回车,换行符,制表符  */
            content = content.replaceAll("<a>\\s*|\t|\r|\n</a>", "");
            articleList.get(i).setArticleContent(content);


            //把分类list设置了。
            List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
            categoryCustomList.add(categoryCustomMapper.getCategoryById(articleList.get(i).getArticleParentCategoryId()));
            categoryCustomList.add(categoryCustomMapper.getCategoryById(articleList.get(i).getArticleChildCategoryId()));
            articleList.get(i).setCategoryCustomList(categoryCustomList);

            //设置List<TagCustom>  tags 属性
            //在此定义一个tags；
            //List<TagCustom> tags = new ArrayList<>();
            //String tagsId = articleList.get(i).getArticleTagIds();
            //去除掉没有标签的文章可能性
            /*if (tagsId != null && tagsId != "") {
                String[] tagId = tagsId.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    TagCustom tagCustom = tagCustomMapper.getTagById(Integer.valueOf(tagId[j]));
                    //防止标签不存在，被删除
                    if (tagCustom != null) {
                        tags.add(tagCustom);
                    }
                }
            }
            articleList.get(i).setTags(tags);*/

            //设置用户信息
            //User user = userMapper.selectByPrimaryKey(articleList.get(i).getArticleUserId());
            //articleList.get(i).setUser(user);
        }
        return articleList;
    }

    //根据标签查询文章
    @Override
    public List<ArticleCustom> getArticleListByTag(Integer tagId) {
        List<ArticleCustom> articleList = articleCustomMapper.getArticleListByTag(tagId);
        for(int i = 0;i<articleList.size();i++){

            /*提出html标签*/
            String content = articleList.get(i).getArticleContent().replaceAll("</?[^>]+>", "");
            /*去除字符串中的空格,回车,换行符,制表符  */
            content = content.replaceAll("<a>\\s*|\t|\r|\n</a>", "");
            articleList.get(i).setArticleContent(content);

            //把分类list设置了。
            List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
            categoryCustomList.add(categoryCustomMapper.getCategoryById(articleList.get(i).getArticleParentCategoryId()));
            categoryCustomList.add(categoryCustomMapper.getCategoryById(articleList.get(i).getArticleChildCategoryId()));
            articleList.get(i).setCategoryCustomList(categoryCustomList);

            //设置List<TagCustom> tags 属性
            //在此定义一个tags；
            //List<TagCustom> tags = new ArrayList<>();
            //String tagsId = articleList.get(i).getArticleTagIds();
            //去除掉没有标签的文章可能性
            /*if (tagsId != null && tagsId != "") {
                String[] tagID = tagsId.split(",");
                for (int j = 0; j < tagID.length; j++) {
                    TagCustom tagCustom = tagCustomMapper.getTagById(Integer.valueOf(tagID[j]));
                    //防止标签不存在，被删除
                    if (tagCustom != null) {
                        tags.add(tagCustom);
                    }
                }
            }
            articleList.get(i).setTags(tags);*/

            //设置用户信息
            //User user = userMapper.selectByPrimaryKey(articleList.get(i).getArticleUserId());
            //articleList.get(i).setUser(user);
        }
        return articleList;
    }

    //前台搜索文章
    @Override
    public List<ArticleCustom> searchArticleForPortal(String query) {
        List<ArticleCustom> articleList = articleCustomMapper.searchArticleForPortal(query);
        for(int i = 0;i<articleList.size();i++){

            /*提出html标签*/
            String content = articleList.get(i).getArticleContent().replaceAll("</?[^>]+>", "");
            /*去除字符串中的空格,回车,换行符,制表符  */
            content = content.replaceAll("<a>\\s*|\t|\r|\n</a>", "");
            articleList.get(i).setArticleContent(content);
        }
        return articleList;
    }

    @Override
    public List<ArticleCustom> articleGuiDang() {
        return articleCustomMapper.articleGuiDang();
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }




    //前台展示文章详情页
    @Override
    public ArticleCustom getArticleDetailByIdForPortal(Integer articleId) {
        ArticleCustom article = articleCustomMapper.getArticleDetailByIdForPortal(articleId);

        //设置分类 list
        List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
        categoryCustomList.add(categoryCustomMapper.getCategoryById(article.getArticleParentCategoryId()));
        categoryCustomList.add(categoryCustomMapper.getCategoryById(article.getArticleChildCategoryId()));
        article.setCategoryCustomList(categoryCustomList);

        //设置List<TagCustom>  tags 属性
        //在此定义一个tags；
        List<TagCustom> tags = new ArrayList<>();
        String tagsId = article.getArticleTagIds();
        //去除掉没有标签的文章可能性
        if (tagsId != null && tagsId != "") {
            String[] tagId = tagsId.split(",");
            for (int j = 0; j < tagId.length; j++) {
                TagCustom tagCustom = tagCustomMapper.getTagById(Integer.valueOf(tagId[j]));
                //防止标签不存在，被删除
                if (tagCustom != null) {
                    tags.add(tagCustom);
                }
            }
        }
        article.setTags(tags);

        //设置用户信息
        User user = userMapper.selectByPrimaryKey(article.getArticleUserId());
        article.setUser(user);


        //5、获取评论信息列表
        List<CommentCustom> commentCustomList = commentIndexCutomMapper.listCommentByArticleId(articleId);
        //给每个评论用户添加头像
        /*后续完善可参照此头像接口:http://cn.gravatar.com/*/
        for(int i=0;i<commentCustomList.size();i++) {
            String avatar = "http://cn.gravatar.com/avatar/%22+56+%22?s=128&d=identicon&r=PG";
            String gravatar = this.getGravatar(commentCustomList.get(i).getCommentUserEmail());
            commentCustomList.get(i).setCommentAuthorAvatar(gravatar);
        }
        article.setCommentCustomList(commentCustomList);

        return article;
    }

    //获得文章详情中的下一篇文章
    @Override
    public ArticleCustom getNextArticle(Integer articleId) {
        return articleCustomMapper.getNextArticle(articleId);
    }

    //获得文章详情中的上一篇文章
    @Override
    public ArticleCustom getPreviousArticle(Integer articleId) {
        return articleCustomMapper.getPreviousArticle(articleId);
    }

    //点赞更新文章
    @Override
    public void updateArticleForThumbUp(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    //增加浏览量更新文章
    @Override
    public void updateArticleForViews(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    //将字符串转为MD5
    public static String strToMd5(String str) {
        String md5Str = null;
        if (str != null && str.length() != 0) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                byte b[] = md.digest();

                int i;
                StringBuffer buf = new StringBuffer("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                //32位
                md5Str = buf.toString();
                //16位
                //  md5Str = buf.toString().substring(8, 24);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return md5Str;
    }

    //根据email获取gravatar头像
    public static String getGravatar(String email) {
        String emailMd5 = strToMd5(email);
        //设置图片大小32px
        String avatar = "http://cn.gravatar.com/avatar/"+emailMd5+"?s=128&d=identicon&r=PG";
        return avatar;
    }

}
