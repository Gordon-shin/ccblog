package com.ccblog.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentPidIsNull() {
            addCriterion("comment_pid is null");
            return (Criteria) this;
        }

        public Criteria andCommentPidIsNotNull() {
            addCriterion("comment_pid is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPidEqualTo(Integer value) {
            addCriterion("comment_pid =", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidNotEqualTo(Integer value) {
            addCriterion("comment_pid <>", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidGreaterThan(Integer value) {
            addCriterion("comment_pid >", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_pid >=", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidLessThan(Integer value) {
            addCriterion("comment_pid <", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidLessThanOrEqualTo(Integer value) {
            addCriterion("comment_pid <=", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidIn(List<Integer> values) {
            addCriterion("comment_pid in", values, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidNotIn(List<Integer> values) {
            addCriterion("comment_pid not in", values, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidBetween(Integer value1, Integer value2) {
            addCriterion("comment_pid between", value1, value2, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_pid not between", value1, value2, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPnameIsNull() {
            addCriterion("comment_pname is null");
            return (Criteria) this;
        }

        public Criteria andCommentPnameIsNotNull() {
            addCriterion("comment_pname is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPnameEqualTo(String value) {
            addCriterion("comment_pname =", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameNotEqualTo(String value) {
            addCriterion("comment_pname <>", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameGreaterThan(String value) {
            addCriterion("comment_pname >", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameGreaterThanOrEqualTo(String value) {
            addCriterion("comment_pname >=", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameLessThan(String value) {
            addCriterion("comment_pname <", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameLessThanOrEqualTo(String value) {
            addCriterion("comment_pname <=", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameLike(String value) {
            addCriterion("comment_pname like", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameNotLike(String value) {
            addCriterion("comment_pname not like", value, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameIn(List<String> values) {
            addCriterion("comment_pname in", values, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameNotIn(List<String> values) {
            addCriterion("comment_pname not in", values, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameBetween(String value1, String value2) {
            addCriterion("comment_pname between", value1, value2, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentPnameNotBetween(String value1, String value2) {
            addCriterion("comment_pname not between", value1, value2, "commentPname");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIsNull() {
            addCriterion("comment_article_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIsNotNull() {
            addCriterion("comment_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdEqualTo(Integer value) {
            addCriterion("comment_article_id =", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotEqualTo(Integer value) {
            addCriterion("comment_article_id <>", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdGreaterThan(Integer value) {
            addCriterion("comment_article_id >", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_article_id >=", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdLessThan(Integer value) {
            addCriterion("comment_article_id <", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_article_id <=", value, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdIn(List<Integer> values) {
            addCriterion("comment_article_id in", values, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotIn(List<Integer> values) {
            addCriterion("comment_article_id not in", values, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_article_id between", value1, value2, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_article_id not between", value1, value2, "commentArticleId");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIsNull() {
            addCriterion("comment_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIsNotNull() {
            addCriterion("comment_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameEqualTo(String value) {
            addCriterion("comment_user_name =", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotEqualTo(String value) {
            addCriterion("comment_user_name <>", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameGreaterThan(String value) {
            addCriterion("comment_user_name >", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_name >=", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLessThan(String value) {
            addCriterion("comment_user_name <", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLessThanOrEqualTo(String value) {
            addCriterion("comment_user_name <=", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLike(String value) {
            addCriterion("comment_user_name like", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotLike(String value) {
            addCriterion("comment_user_name not like", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIn(List<String> values) {
            addCriterion("comment_user_name in", values, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotIn(List<String> values) {
            addCriterion("comment_user_name not in", values, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameBetween(String value1, String value2) {
            addCriterion("comment_user_name between", value1, value2, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotBetween(String value1, String value2) {
            addCriterion("comment_user_name not between", value1, value2, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailIsNull() {
            addCriterion("comment_user_email is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailIsNotNull() {
            addCriterion("comment_user_email is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailEqualTo(String value) {
            addCriterion("comment_user_email =", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailNotEqualTo(String value) {
            addCriterion("comment_user_email <>", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailGreaterThan(String value) {
            addCriterion("comment_user_email >", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_email >=", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailLessThan(String value) {
            addCriterion("comment_user_email <", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailLessThanOrEqualTo(String value) {
            addCriterion("comment_user_email <=", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailLike(String value) {
            addCriterion("comment_user_email like", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailNotLike(String value) {
            addCriterion("comment_user_email not like", value, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailIn(List<String> values) {
            addCriterion("comment_user_email in", values, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailNotIn(List<String> values) {
            addCriterion("comment_user_email not in", values, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailBetween(String value1, String value2) {
            addCriterion("comment_user_email between", value1, value2, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserEmailNotBetween(String value1, String value2) {
            addCriterion("comment_user_email not between", value1, value2, "commentUserEmail");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlIsNull() {
            addCriterion("comment_user_url is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlIsNotNull() {
            addCriterion("comment_user_url is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlEqualTo(String value) {
            addCriterion("comment_user_url =", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlNotEqualTo(String value) {
            addCriterion("comment_user_url <>", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlGreaterThan(String value) {
            addCriterion("comment_user_url >", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_url >=", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlLessThan(String value) {
            addCriterion("comment_user_url <", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlLessThanOrEqualTo(String value) {
            addCriterion("comment_user_url <=", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlLike(String value) {
            addCriterion("comment_user_url like", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlNotLike(String value) {
            addCriterion("comment_user_url not like", value, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlIn(List<String> values) {
            addCriterion("comment_user_url in", values, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlNotIn(List<String> values) {
            addCriterion("comment_user_url not in", values, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlBetween(String value1, String value2) {
            addCriterion("comment_user_url between", value1, value2, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentUserUrlNotBetween(String value1, String value2) {
            addCriterion("comment_user_url not between", value1, value2, "commentUserUrl");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentIsNull() {
            addCriterion("comment_agent is null");
            return (Criteria) this;
        }

        public Criteria andCommentAgentIsNotNull() {
            addCriterion("comment_agent is not null");
            return (Criteria) this;
        }

        public Criteria andCommentAgentEqualTo(String value) {
            addCriterion("comment_agent =", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentNotEqualTo(String value) {
            addCriterion("comment_agent <>", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentGreaterThan(String value) {
            addCriterion("comment_agent >", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_agent >=", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentLessThan(String value) {
            addCriterion("comment_agent <", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentLessThanOrEqualTo(String value) {
            addCriterion("comment_agent <=", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentLike(String value) {
            addCriterion("comment_agent like", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentNotLike(String value) {
            addCriterion("comment_agent not like", value, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentIn(List<String> values) {
            addCriterion("comment_agent in", values, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentNotIn(List<String> values) {
            addCriterion("comment_agent not in", values, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentBetween(String value1, String value2) {
            addCriterion("comment_agent between", value1, value2, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentAgentNotBetween(String value1, String value2) {
            addCriterion("comment_agent not between", value1, value2, "commentAgent");
            return (Criteria) this;
        }

        public Criteria andCommentIpIsNull() {
            addCriterion("comment_ip is null");
            return (Criteria) this;
        }

        public Criteria andCommentIpIsNotNull() {
            addCriterion("comment_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIpEqualTo(String value) {
            addCriterion("comment_ip =", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotEqualTo(String value) {
            addCriterion("comment_ip <>", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpGreaterThan(String value) {
            addCriterion("comment_ip >", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpGreaterThanOrEqualTo(String value) {
            addCriterion("comment_ip >=", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpLessThan(String value) {
            addCriterion("comment_ip <", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpLessThanOrEqualTo(String value) {
            addCriterion("comment_ip <=", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpLike(String value) {
            addCriterion("comment_ip like", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotLike(String value) {
            addCriterion("comment_ip not like", value, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpIn(List<String> values) {
            addCriterion("comment_ip in", values, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotIn(List<String> values) {
            addCriterion("comment_ip not in", values, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpBetween(String value1, String value2) {
            addCriterion("comment_ip between", value1, value2, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentIpNotBetween(String value1, String value2) {
            addCriterion("comment_ip not between", value1, value2, "commentIp");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIsNull() {
            addCriterion("comment_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIsNotNull() {
            addCriterion("comment_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeEqualTo(Date value) {
            addCriterion("comment_create_time =", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotEqualTo(Date value) {
            addCriterion("comment_create_time <>", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeGreaterThan(Date value) {
            addCriterion("comment_create_time >", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_create_time >=", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeLessThan(Date value) {
            addCriterion("comment_create_time <", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_create_time <=", value, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeIn(List<Date> values) {
            addCriterion("comment_create_time in", values, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotIn(List<Date> values) {
            addCriterion("comment_create_time not in", values, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeBetween(Date value1, Date value2) {
            addCriterion("comment_create_time between", value1, value2, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_create_time not between", value1, value2, "commentCreateTime");
            return (Criteria) this;
        }

        public Criteria andCommentRoleIsNull() {
            addCriterion("comment_role is null");
            return (Criteria) this;
        }

        public Criteria andCommentRoleIsNotNull() {
            addCriterion("comment_role is not null");
            return (Criteria) this;
        }

        public Criteria andCommentRoleEqualTo(Integer value) {
            addCriterion("comment_role =", value, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleNotEqualTo(Integer value) {
            addCriterion("comment_role <>", value, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleGreaterThan(Integer value) {
            addCriterion("comment_role >", value, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_role >=", value, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleLessThan(Integer value) {
            addCriterion("comment_role <", value, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleLessThanOrEqualTo(Integer value) {
            addCriterion("comment_role <=", value, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleIn(List<Integer> values) {
            addCriterion("comment_role in", values, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleNotIn(List<Integer> values) {
            addCriterion("comment_role not in", values, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleBetween(Integer value1, Integer value2) {
            addCriterion("comment_role between", value1, value2, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_role not between", value1, value2, "commentRole");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Integer value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Integer value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Integer value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Integer value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Integer> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Integer> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Integer value1, Integer value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}