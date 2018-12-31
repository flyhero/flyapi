package cn.iflyapi.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SocialExample() {
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

        public Criteria andSocialIdIsNull() {
            addCriterion("social_id is null");
            return (Criteria) this;
        }

        public Criteria andSocialIdIsNotNull() {
            addCriterion("social_id is not null");
            return (Criteria) this;
        }

        public Criteria andSocialIdEqualTo(Long value) {
            addCriterion("social_id =", value, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdNotEqualTo(Long value) {
            addCriterion("social_id <>", value, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdGreaterThan(Long value) {
            addCriterion("social_id >", value, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("social_id >=", value, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdLessThan(Long value) {
            addCriterion("social_id <", value, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdLessThanOrEqualTo(Long value) {
            addCriterion("social_id <=", value, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdIn(List<Long> values) {
            addCriterion("social_id in", values, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdNotIn(List<Long> values) {
            addCriterion("social_id not in", values, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdBetween(Long value1, Long value2) {
            addCriterion("social_id between", value1, value2, "socialId");
            return (Criteria) this;
        }

        public Criteria andSocialIdNotBetween(Long value1, Long value2) {
            addCriterion("social_id not between", value1, value2, "socialId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSocialTypeIsNull() {
            addCriterion("social_type is null");
            return (Criteria) this;
        }

        public Criteria andSocialTypeIsNotNull() {
            addCriterion("social_type is not null");
            return (Criteria) this;
        }

        public Criteria andSocialTypeEqualTo(Integer value) {
            addCriterion("social_type =", value, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeNotEqualTo(Integer value) {
            addCriterion("social_type <>", value, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeGreaterThan(Integer value) {
            addCriterion("social_type >", value, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("social_type >=", value, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeLessThan(Integer value) {
            addCriterion("social_type <", value, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeLessThanOrEqualTo(Integer value) {
            addCriterion("social_type <=", value, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeIn(List<Integer> values) {
            addCriterion("social_type in", values, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeNotIn(List<Integer> values) {
            addCriterion("social_type not in", values, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeBetween(Integer value1, Integer value2) {
            addCriterion("social_type between", value1, value2, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("social_type not between", value1, value2, "socialType");
            return (Criteria) this;
        }

        public Criteria andSocialUrlIsNull() {
            addCriterion("social_url is null");
            return (Criteria) this;
        }

        public Criteria andSocialUrlIsNotNull() {
            addCriterion("social_url is not null");
            return (Criteria) this;
        }

        public Criteria andSocialUrlEqualTo(String value) {
            addCriterion("social_url =", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlNotEqualTo(String value) {
            addCriterion("social_url <>", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlGreaterThan(String value) {
            addCriterion("social_url >", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlGreaterThanOrEqualTo(String value) {
            addCriterion("social_url >=", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlLessThan(String value) {
            addCriterion("social_url <", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlLessThanOrEqualTo(String value) {
            addCriterion("social_url <=", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlLike(String value) {
            addCriterion("social_url like", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlNotLike(String value) {
            addCriterion("social_url not like", value, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlIn(List<String> values) {
            addCriterion("social_url in", values, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlNotIn(List<String> values) {
            addCriterion("social_url not in", values, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlBetween(String value1, String value2) {
            addCriterion("social_url between", value1, value2, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andSocialUrlNotBetween(String value1, String value2) {
            addCriterion("social_url not between", value1, value2, "socialUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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