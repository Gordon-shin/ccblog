package com.ccblog.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class CustombuttonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustombuttonExample() {
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

        public Criteria andCustombuttonIdIsNull() {
            addCriterion("custombutton_id is null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdIsNotNull() {
            addCriterion("custombutton_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdEqualTo(Integer value) {
            addCriterion("custombutton_id =", value, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdNotEqualTo(Integer value) {
            addCriterion("custombutton_id <>", value, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdGreaterThan(Integer value) {
            addCriterion("custombutton_id >", value, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("custombutton_id >=", value, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdLessThan(Integer value) {
            addCriterion("custombutton_id <", value, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdLessThanOrEqualTo(Integer value) {
            addCriterion("custombutton_id <=", value, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdIn(List<Integer> values) {
            addCriterion("custombutton_id in", values, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdNotIn(List<Integer> values) {
            addCriterion("custombutton_id not in", values, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdBetween(Integer value1, Integer value2) {
            addCriterion("custombutton_id between", value1, value2, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("custombutton_id not between", value1, value2, "custombuttonId");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameIsNull() {
            addCriterion("custombutton_name is null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameIsNotNull() {
            addCriterion("custombutton_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameEqualTo(String value) {
            addCriterion("custombutton_name =", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameNotEqualTo(String value) {
            addCriterion("custombutton_name <>", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameGreaterThan(String value) {
            addCriterion("custombutton_name >", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameGreaterThanOrEqualTo(String value) {
            addCriterion("custombutton_name >=", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameLessThan(String value) {
            addCriterion("custombutton_name <", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameLessThanOrEqualTo(String value) {
            addCriterion("custombutton_name <=", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameLike(String value) {
            addCriterion("custombutton_name like", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameNotLike(String value) {
            addCriterion("custombutton_name not like", value, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameIn(List<String> values) {
            addCriterion("custombutton_name in", values, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameNotIn(List<String> values) {
            addCriterion("custombutton_name not in", values, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameBetween(String value1, String value2) {
            addCriterion("custombutton_name between", value1, value2, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonNameNotBetween(String value1, String value2) {
            addCriterion("custombutton_name not between", value1, value2, "custombuttonName");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlIsNull() {
            addCriterion("custombutton_url is null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlIsNotNull() {
            addCriterion("custombutton_url is not null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlEqualTo(String value) {
            addCriterion("custombutton_url =", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlNotEqualTo(String value) {
            addCriterion("custombutton_url <>", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlGreaterThan(String value) {
            addCriterion("custombutton_url >", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlGreaterThanOrEqualTo(String value) {
            addCriterion("custombutton_url >=", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlLessThan(String value) {
            addCriterion("custombutton_url <", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlLessThanOrEqualTo(String value) {
            addCriterion("custombutton_url <=", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlLike(String value) {
            addCriterion("custombutton_url like", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlNotLike(String value) {
            addCriterion("custombutton_url not like", value, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlIn(List<String> values) {
            addCriterion("custombutton_url in", values, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlNotIn(List<String> values) {
            addCriterion("custombutton_url not in", values, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlBetween(String value1, String value2) {
            addCriterion("custombutton_url between", value1, value2, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonUrlNotBetween(String value1, String value2) {
            addCriterion("custombutton_url not between", value1, value2, "custombuttonUrl");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelIsNull() {
            addCriterion("custombutton_level is null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelIsNotNull() {
            addCriterion("custombutton_level is not null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelEqualTo(Integer value) {
            addCriterion("custombutton_level =", value, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelNotEqualTo(Integer value) {
            addCriterion("custombutton_level <>", value, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelGreaterThan(Integer value) {
            addCriterion("custombutton_level >", value, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("custombutton_level >=", value, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelLessThan(Integer value) {
            addCriterion("custombutton_level <", value, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelLessThanOrEqualTo(Integer value) {
            addCriterion("custombutton_level <=", value, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelIn(List<Integer> values) {
            addCriterion("custombutton_level in", values, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelNotIn(List<Integer> values) {
            addCriterion("custombutton_level not in", values, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelBetween(Integer value1, Integer value2) {
            addCriterion("custombutton_level between", value1, value2, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("custombutton_level not between", value1, value2, "custombuttonLevel");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconIsNull() {
            addCriterion("custombutton_icon is null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconIsNotNull() {
            addCriterion("custombutton_icon is not null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconEqualTo(String value) {
            addCriterion("custombutton_icon =", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconNotEqualTo(String value) {
            addCriterion("custombutton_icon <>", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconGreaterThan(String value) {
            addCriterion("custombutton_icon >", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconGreaterThanOrEqualTo(String value) {
            addCriterion("custombutton_icon >=", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconLessThan(String value) {
            addCriterion("custombutton_icon <", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconLessThanOrEqualTo(String value) {
            addCriterion("custombutton_icon <=", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconLike(String value) {
            addCriterion("custombutton_icon like", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconNotLike(String value) {
            addCriterion("custombutton_icon not like", value, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconIn(List<String> values) {
            addCriterion("custombutton_icon in", values, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconNotIn(List<String> values) {
            addCriterion("custombutton_icon not in", values, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconBetween(String value1, String value2) {
            addCriterion("custombutton_icon between", value1, value2, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonIconNotBetween(String value1, String value2) {
            addCriterion("custombutton_icon not between", value1, value2, "custombuttonIcon");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusIsNull() {
            addCriterion("custombutton_status is null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusIsNotNull() {
            addCriterion("custombutton_status is not null");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusEqualTo(Integer value) {
            addCriterion("custombutton_status =", value, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusNotEqualTo(Integer value) {
            addCriterion("custombutton_status <>", value, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusGreaterThan(Integer value) {
            addCriterion("custombutton_status >", value, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("custombutton_status >=", value, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusLessThan(Integer value) {
            addCriterion("custombutton_status <", value, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusLessThanOrEqualTo(Integer value) {
            addCriterion("custombutton_status <=", value, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusIn(List<Integer> values) {
            addCriterion("custombutton_status in", values, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusNotIn(List<Integer> values) {
            addCriterion("custombutton_status not in", values, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusBetween(Integer value1, Integer value2) {
            addCriterion("custombutton_status between", value1, value2, "custombuttonStatus");
            return (Criteria) this;
        }

        public Criteria andCustombuttonStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("custombutton_status not between", value1, value2, "custombuttonStatus");
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