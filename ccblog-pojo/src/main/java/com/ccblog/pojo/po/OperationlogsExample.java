package com.ccblog.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationlogsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationlogsExample() {
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

        public Criteria andOplogIdIsNull() {
            addCriterion("oplog_id is null");
            return (Criteria) this;
        }

        public Criteria andOplogIdIsNotNull() {
            addCriterion("oplog_id is not null");
            return (Criteria) this;
        }

        public Criteria andOplogIdEqualTo(Integer value) {
            addCriterion("oplog_id =", value, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdNotEqualTo(Integer value) {
            addCriterion("oplog_id <>", value, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdGreaterThan(Integer value) {
            addCriterion("oplog_id >", value, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oplog_id >=", value, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdLessThan(Integer value) {
            addCriterion("oplog_id <", value, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdLessThanOrEqualTo(Integer value) {
            addCriterion("oplog_id <=", value, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdIn(List<Integer> values) {
            addCriterion("oplog_id in", values, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdNotIn(List<Integer> values) {
            addCriterion("oplog_id not in", values, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdBetween(Integer value1, Integer value2) {
            addCriterion("oplog_id between", value1, value2, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oplog_id not between", value1, value2, "oplogId");
            return (Criteria) this;
        }

        public Criteria andOplogIpIsNull() {
            addCriterion("oplog_ip is null");
            return (Criteria) this;
        }

        public Criteria andOplogIpIsNotNull() {
            addCriterion("oplog_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOplogIpEqualTo(String value) {
            addCriterion("oplog_ip =", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpNotEqualTo(String value) {
            addCriterion("oplog_ip <>", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpGreaterThan(String value) {
            addCriterion("oplog_ip >", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpGreaterThanOrEqualTo(String value) {
            addCriterion("oplog_ip >=", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpLessThan(String value) {
            addCriterion("oplog_ip <", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpLessThanOrEqualTo(String value) {
            addCriterion("oplog_ip <=", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpLike(String value) {
            addCriterion("oplog_ip like", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpNotLike(String value) {
            addCriterion("oplog_ip not like", value, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpIn(List<String> values) {
            addCriterion("oplog_ip in", values, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpNotIn(List<String> values) {
            addCriterion("oplog_ip not in", values, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpBetween(String value1, String value2) {
            addCriterion("oplog_ip between", value1, value2, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogIpNotBetween(String value1, String value2) {
            addCriterion("oplog_ip not between", value1, value2, "oplogIp");
            return (Criteria) this;
        }

        public Criteria andOplogOperationIsNull() {
            addCriterion("oplog_operation is null");
            return (Criteria) this;
        }

        public Criteria andOplogOperationIsNotNull() {
            addCriterion("oplog_operation is not null");
            return (Criteria) this;
        }

        public Criteria andOplogOperationEqualTo(String value) {
            addCriterion("oplog_operation =", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationNotEqualTo(String value) {
            addCriterion("oplog_operation <>", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationGreaterThan(String value) {
            addCriterion("oplog_operation >", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationGreaterThanOrEqualTo(String value) {
            addCriterion("oplog_operation >=", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationLessThan(String value) {
            addCriterion("oplog_operation <", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationLessThanOrEqualTo(String value) {
            addCriterion("oplog_operation <=", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationLike(String value) {
            addCriterion("oplog_operation like", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationNotLike(String value) {
            addCriterion("oplog_operation not like", value, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationIn(List<String> values) {
            addCriterion("oplog_operation in", values, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationNotIn(List<String> values) {
            addCriterion("oplog_operation not in", values, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationBetween(String value1, String value2) {
            addCriterion("oplog_operation between", value1, value2, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogOperationNotBetween(String value1, String value2) {
            addCriterion("oplog_operation not between", value1, value2, "oplogOperation");
            return (Criteria) this;
        }

        public Criteria andOplogAreaIsNull() {
            addCriterion("oplog_area is null");
            return (Criteria) this;
        }

        public Criteria andOplogAreaIsNotNull() {
            addCriterion("oplog_area is not null");
            return (Criteria) this;
        }

        public Criteria andOplogAreaEqualTo(String value) {
            addCriterion("oplog_area =", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaNotEqualTo(String value) {
            addCriterion("oplog_area <>", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaGreaterThan(String value) {
            addCriterion("oplog_area >", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaGreaterThanOrEqualTo(String value) {
            addCriterion("oplog_area >=", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaLessThan(String value) {
            addCriterion("oplog_area <", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaLessThanOrEqualTo(String value) {
            addCriterion("oplog_area <=", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaLike(String value) {
            addCriterion("oplog_area like", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaNotLike(String value) {
            addCriterion("oplog_area not like", value, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaIn(List<String> values) {
            addCriterion("oplog_area in", values, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaNotIn(List<String> values) {
            addCriterion("oplog_area not in", values, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaBetween(String value1, String value2) {
            addCriterion("oplog_area between", value1, value2, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogAreaNotBetween(String value1, String value2) {
            addCriterion("oplog_area not between", value1, value2, "oplogArea");
            return (Criteria) this;
        }

        public Criteria andOplogComputerIsNull() {
            addCriterion("oplog_computer is null");
            return (Criteria) this;
        }

        public Criteria andOplogComputerIsNotNull() {
            addCriterion("oplog_computer is not null");
            return (Criteria) this;
        }

        public Criteria andOplogComputerEqualTo(String value) {
            addCriterion("oplog_computer =", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerNotEqualTo(String value) {
            addCriterion("oplog_computer <>", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerGreaterThan(String value) {
            addCriterion("oplog_computer >", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerGreaterThanOrEqualTo(String value) {
            addCriterion("oplog_computer >=", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerLessThan(String value) {
            addCriterion("oplog_computer <", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerLessThanOrEqualTo(String value) {
            addCriterion("oplog_computer <=", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerLike(String value) {
            addCriterion("oplog_computer like", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerNotLike(String value) {
            addCriterion("oplog_computer not like", value, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerIn(List<String> values) {
            addCriterion("oplog_computer in", values, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerNotIn(List<String> values) {
            addCriterion("oplog_computer not in", values, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerBetween(String value1, String value2) {
            addCriterion("oplog_computer between", value1, value2, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogComputerNotBetween(String value1, String value2) {
            addCriterion("oplog_computer not between", value1, value2, "oplogComputer");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserIsNull() {
            addCriterion("oplog_browser is null");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserIsNotNull() {
            addCriterion("oplog_browser is not null");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserEqualTo(String value) {
            addCriterion("oplog_browser =", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserNotEqualTo(String value) {
            addCriterion("oplog_browser <>", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserGreaterThan(String value) {
            addCriterion("oplog_browser >", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("oplog_browser >=", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserLessThan(String value) {
            addCriterion("oplog_browser <", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserLessThanOrEqualTo(String value) {
            addCriterion("oplog_browser <=", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserLike(String value) {
            addCriterion("oplog_browser like", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserNotLike(String value) {
            addCriterion("oplog_browser not like", value, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserIn(List<String> values) {
            addCriterion("oplog_browser in", values, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserNotIn(List<String> values) {
            addCriterion("oplog_browser not in", values, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserBetween(String value1, String value2) {
            addCriterion("oplog_browser between", value1, value2, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogBrowserNotBetween(String value1, String value2) {
            addCriterion("oplog_browser not between", value1, value2, "oplogBrowser");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeIsNull() {
            addCriterion("oplog_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeIsNotNull() {
            addCriterion("oplog_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeEqualTo(Date value) {
            addCriterion("oplog_create_time =", value, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeNotEqualTo(Date value) {
            addCriterion("oplog_create_time <>", value, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeGreaterThan(Date value) {
            addCriterion("oplog_create_time >", value, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oplog_create_time >=", value, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeLessThan(Date value) {
            addCriterion("oplog_create_time <", value, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("oplog_create_time <=", value, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeIn(List<Date> values) {
            addCriterion("oplog_create_time in", values, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeNotIn(List<Date> values) {
            addCriterion("oplog_create_time not in", values, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeBetween(Date value1, Date value2) {
            addCriterion("oplog_create_time between", value1, value2, "oplogCreateTime");
            return (Criteria) this;
        }

        public Criteria andOplogCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("oplog_create_time not between", value1, value2, "oplogCreateTime");
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