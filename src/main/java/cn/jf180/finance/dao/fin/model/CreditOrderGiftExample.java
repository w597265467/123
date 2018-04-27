package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditOrderGiftExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditOrderGiftExample() {
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

        public Criteria andGiftConfigIdIsNull() {
            addCriterion("gift_config_id is null");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdIsNotNull() {
            addCriterion("gift_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdEqualTo(Integer value) {
            addCriterion("gift_config_id =", value, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdNotEqualTo(Integer value) {
            addCriterion("gift_config_id <>", value, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdGreaterThan(Integer value) {
            addCriterion("gift_config_id >", value, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_config_id >=", value, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdLessThan(Integer value) {
            addCriterion("gift_config_id <", value, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("gift_config_id <=", value, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdIn(List<Integer> values) {
            addCriterion("gift_config_id in", values, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdNotIn(List<Integer> values) {
            addCriterion("gift_config_id not in", values, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("gift_config_id between", value1, value2, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andGiftConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_config_id not between", value1, value2, "giftConfigId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andGiftNameIsNull() {
            addCriterion("gift_name is null");
            return (Criteria) this;
        }

        public Criteria andGiftNameIsNotNull() {
            addCriterion("gift_name is not null");
            return (Criteria) this;
        }

        public Criteria andGiftNameEqualTo(String value) {
            addCriterion("gift_name =", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotEqualTo(String value) {
            addCriterion("gift_name <>", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameGreaterThan(String value) {
            addCriterion("gift_name >", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameGreaterThanOrEqualTo(String value) {
            addCriterion("gift_name >=", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameLessThan(String value) {
            addCriterion("gift_name <", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameLessThanOrEqualTo(String value) {
            addCriterion("gift_name <=", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameLike(String value) {
            addCriterion("gift_name like", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotLike(String value) {
            addCriterion("gift_name not like", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameIn(List<String> values) {
            addCriterion("gift_name in", values, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotIn(List<String> values) {
            addCriterion("gift_name not in", values, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameBetween(String value1, String value2) {
            addCriterion("gift_name between", value1, value2, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotBetween(String value1, String value2) {
            addCriterion("gift_name not between", value1, value2, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftPriceIsNull() {
            addCriterion("gift_price is null");
            return (Criteria) this;
        }

        public Criteria andGiftPriceIsNotNull() {
            addCriterion("gift_price is not null");
            return (Criteria) this;
        }

        public Criteria andGiftPriceEqualTo(Integer value) {
            addCriterion("gift_price =", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceNotEqualTo(Integer value) {
            addCriterion("gift_price <>", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceGreaterThan(Integer value) {
            addCriterion("gift_price >", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_price >=", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceLessThan(Integer value) {
            addCriterion("gift_price <", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceLessThanOrEqualTo(Integer value) {
            addCriterion("gift_price <=", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceIn(List<Integer> values) {
            addCriterion("gift_price in", values, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceNotIn(List<Integer> values) {
            addCriterion("gift_price not in", values, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceBetween(Integer value1, Integer value2) {
            addCriterion("gift_price between", value1, value2, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_price not between", value1, value2, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andReturnCycleIsNull() {
            addCriterion("return_cycle is null");
            return (Criteria) this;
        }

        public Criteria andReturnCycleIsNotNull() {
            addCriterion("return_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCycleEqualTo(Integer value) {
            addCriterion("return_cycle =", value, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleNotEqualTo(Integer value) {
            addCriterion("return_cycle <>", value, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleGreaterThan(Integer value) {
            addCriterion("return_cycle >", value, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_cycle >=", value, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleLessThan(Integer value) {
            addCriterion("return_cycle <", value, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleLessThanOrEqualTo(Integer value) {
            addCriterion("return_cycle <=", value, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleIn(List<Integer> values) {
            addCriterion("return_cycle in", values, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleNotIn(List<Integer> values) {
            addCriterion("return_cycle not in", values, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleBetween(Integer value1, Integer value2) {
            addCriterion("return_cycle between", value1, value2, "returnCycle");
            return (Criteria) this;
        }

        public Criteria andReturnCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("return_cycle not between", value1, value2, "returnCycle");
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