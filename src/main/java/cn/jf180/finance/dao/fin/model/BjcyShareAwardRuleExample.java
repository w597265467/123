package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BjcyShareAwardRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BjcyShareAwardRuleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNormalAwardIsNull() {
            addCriterion("normal_award is null");
            return (Criteria) this;
        }

        public Criteria andNormalAwardIsNotNull() {
            addCriterion("normal_award is not null");
            return (Criteria) this;
        }

        public Criteria andNormalAwardEqualTo(String value) {
            addCriterion("normal_award =", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardNotEqualTo(String value) {
            addCriterion("normal_award <>", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardGreaterThan(String value) {
            addCriterion("normal_award >", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardGreaterThanOrEqualTo(String value) {
            addCriterion("normal_award >=", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardLessThan(String value) {
            addCriterion("normal_award <", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardLessThanOrEqualTo(String value) {
            addCriterion("normal_award <=", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardLike(String value) {
            addCriterion("normal_award like", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardNotLike(String value) {
            addCriterion("normal_award not like", value, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardIn(List<String> values) {
            addCriterion("normal_award in", values, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardNotIn(List<String> values) {
            addCriterion("normal_award not in", values, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardBetween(String value1, String value2) {
            addCriterion("normal_award between", value1, value2, "normalAward");
            return (Criteria) this;
        }

        public Criteria andNormalAwardNotBetween(String value1, String value2) {
            addCriterion("normal_award not between", value1, value2, "normalAward");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyIsNull() {
            addCriterion("sub_award_money is null");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyIsNotNull() {
            addCriterion("sub_award_money is not null");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyEqualTo(String value) {
            addCriterion("sub_award_money =", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyNotEqualTo(String value) {
            addCriterion("sub_award_money <>", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyGreaterThan(String value) {
            addCriterion("sub_award_money >", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("sub_award_money >=", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyLessThan(String value) {
            addCriterion("sub_award_money <", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyLessThanOrEqualTo(String value) {
            addCriterion("sub_award_money <=", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyLike(String value) {
            addCriterion("sub_award_money like", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyNotLike(String value) {
            addCriterion("sub_award_money not like", value, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyIn(List<String> values) {
            addCriterion("sub_award_money in", values, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyNotIn(List<String> values) {
            addCriterion("sub_award_money not in", values, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyBetween(String value1, String value2) {
            addCriterion("sub_award_money between", value1, value2, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andSubAwardMoneyNotBetween(String value1, String value2) {
            addCriterion("sub_award_money not between", value1, value2, "subAwardMoney");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardIsNull() {
            addCriterion("realize_count_award is null");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardIsNotNull() {
            addCriterion("realize_count_award is not null");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardEqualTo(String value) {
            addCriterion("realize_count_award =", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardNotEqualTo(String value) {
            addCriterion("realize_count_award <>", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardGreaterThan(String value) {
            addCriterion("realize_count_award >", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardGreaterThanOrEqualTo(String value) {
            addCriterion("realize_count_award >=", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardLessThan(String value) {
            addCriterion("realize_count_award <", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardLessThanOrEqualTo(String value) {
            addCriterion("realize_count_award <=", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardLike(String value) {
            addCriterion("realize_count_award like", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardNotLike(String value) {
            addCriterion("realize_count_award not like", value, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardIn(List<String> values) {
            addCriterion("realize_count_award in", values, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardNotIn(List<String> values) {
            addCriterion("realize_count_award not in", values, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardBetween(String value1, String value2) {
            addCriterion("realize_count_award between", value1, value2, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountAwardNotBetween(String value1, String value2) {
            addCriterion("realize_count_award not between", value1, value2, "realizeCountAward");
            return (Criteria) this;
        }

        public Criteria andRealizeCountIsNull() {
            addCriterion("realize_count is null");
            return (Criteria) this;
        }

        public Criteria andRealizeCountIsNotNull() {
            addCriterion("realize_count is not null");
            return (Criteria) this;
        }

        public Criteria andRealizeCountEqualTo(String value) {
            addCriterion("realize_count =", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountNotEqualTo(String value) {
            addCriterion("realize_count <>", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountGreaterThan(String value) {
            addCriterion("realize_count >", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountGreaterThanOrEqualTo(String value) {
            addCriterion("realize_count >=", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountLessThan(String value) {
            addCriterion("realize_count <", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountLessThanOrEqualTo(String value) {
            addCriterion("realize_count <=", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountLike(String value) {
            addCriterion("realize_count like", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountNotLike(String value) {
            addCriterion("realize_count not like", value, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountIn(List<String> values) {
            addCriterion("realize_count in", values, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountNotIn(List<String> values) {
            addCriterion("realize_count not in", values, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountBetween(String value1, String value2) {
            addCriterion("realize_count between", value1, value2, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andRealizeCountNotBetween(String value1, String value2) {
            addCriterion("realize_count not between", value1, value2, "realizeCount");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(String value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(String value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(String value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(String value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(String value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLike(String value) {
            addCriterion("c_type like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotLike(String value) {
            addCriterion("c_type not like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<String> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<String> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(String value1, String value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(String value1, String value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andActivityNumIsNull() {
            addCriterion("activity_num is null");
            return (Criteria) this;
        }

        public Criteria andActivityNumIsNotNull() {
            addCriterion("activity_num is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNumEqualTo(Integer value) {
            addCriterion("activity_num =", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotEqualTo(Integer value) {
            addCriterion("activity_num <>", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumGreaterThan(Integer value) {
            addCriterion("activity_num >", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_num >=", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLessThan(Integer value) {
            addCriterion("activity_num <", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLessThanOrEqualTo(Integer value) {
            addCriterion("activity_num <=", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumIn(List<Integer> values) {
            addCriterion("activity_num in", values, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotIn(List<Integer> values) {
            addCriterion("activity_num not in", values, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumBetween(Integer value1, Integer value2) {
            addCriterion("activity_num between", value1, value2, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_num not between", value1, value2, "activityNum");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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