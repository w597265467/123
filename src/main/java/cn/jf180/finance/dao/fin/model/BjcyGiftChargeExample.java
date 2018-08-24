package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BjcyGiftChargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BjcyGiftChargeExample() {
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

        public Criteria andChargeSnIsNull() {
            addCriterion("charge_sn is null");
            return (Criteria) this;
        }

        public Criteria andChargeSnIsNotNull() {
            addCriterion("charge_sn is not null");
            return (Criteria) this;
        }

        public Criteria andChargeSnEqualTo(String value) {
            addCriterion("charge_sn =", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnNotEqualTo(String value) {
            addCriterion("charge_sn <>", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnGreaterThan(String value) {
            addCriterion("charge_sn >", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnGreaterThanOrEqualTo(String value) {
            addCriterion("charge_sn >=", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnLessThan(String value) {
            addCriterion("charge_sn <", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnLessThanOrEqualTo(String value) {
            addCriterion("charge_sn <=", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnLike(String value) {
            addCriterion("charge_sn like", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnNotLike(String value) {
            addCriterion("charge_sn not like", value, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnIn(List<String> values) {
            addCriterion("charge_sn in", values, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnNotIn(List<String> values) {
            addCriterion("charge_sn not in", values, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnBetween(String value1, String value2) {
            addCriterion("charge_sn between", value1, value2, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andChargeSnNotBetween(String value1, String value2) {
            addCriterion("charge_sn not between", value1, value2, "chargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnIsNull() {
            addCriterion("ext_charge_sn is null");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnIsNotNull() {
            addCriterion("ext_charge_sn is not null");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnEqualTo(String value) {
            addCriterion("ext_charge_sn =", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnNotEqualTo(String value) {
            addCriterion("ext_charge_sn <>", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnGreaterThan(String value) {
            addCriterion("ext_charge_sn >", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnGreaterThanOrEqualTo(String value) {
            addCriterion("ext_charge_sn >=", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnLessThan(String value) {
            addCriterion("ext_charge_sn <", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnLessThanOrEqualTo(String value) {
            addCriterion("ext_charge_sn <=", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnLike(String value) {
            addCriterion("ext_charge_sn like", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnNotLike(String value) {
            addCriterion("ext_charge_sn not like", value, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnIn(List<String> values) {
            addCriterion("ext_charge_sn in", values, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnNotIn(List<String> values) {
            addCriterion("ext_charge_sn not in", values, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnBetween(String value1, String value2) {
            addCriterion("ext_charge_sn between", value1, value2, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andExtChargeSnNotBetween(String value1, String value2) {
            addCriterion("ext_charge_sn not between", value1, value2, "extChargeSn");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdIsNull() {
            addCriterion("gift_record_id is null");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdIsNotNull() {
            addCriterion("gift_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdEqualTo(String value) {
            addCriterion("gift_record_id =", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdNotEqualTo(String value) {
            addCriterion("gift_record_id <>", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdGreaterThan(String value) {
            addCriterion("gift_record_id >", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("gift_record_id >=", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdLessThan(String value) {
            addCriterion("gift_record_id <", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdLessThanOrEqualTo(String value) {
            addCriterion("gift_record_id <=", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdLike(String value) {
            addCriterion("gift_record_id like", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdNotLike(String value) {
            addCriterion("gift_record_id not like", value, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdIn(List<String> values) {
            addCriterion("gift_record_id in", values, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdNotIn(List<String> values) {
            addCriterion("gift_record_id not in", values, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdBetween(String value1, String value2) {
            addCriterion("gift_record_id between", value1, value2, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andGiftRecordIdNotBetween(String value1, String value2) {
            addCriterion("gift_record_id not between", value1, value2, "giftRecordId");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIsNull() {
            addCriterion("charge_status is null");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIsNotNull() {
            addCriterion("charge_status is not null");
            return (Criteria) this;
        }

        public Criteria andChargeStatusEqualTo(Integer value) {
            addCriterion("charge_status =", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotEqualTo(Integer value) {
            addCriterion("charge_status <>", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusGreaterThan(Integer value) {
            addCriterion("charge_status >", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_status >=", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLessThan(Integer value) {
            addCriterion("charge_status <", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("charge_status <=", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIn(List<Integer> values) {
            addCriterion("charge_status in", values, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotIn(List<Integer> values) {
            addCriterion("charge_status not in", values, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusBetween(Integer value1, Integer value2) {
            addCriterion("charge_status between", value1, value2, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_status not between", value1, value2, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andChargePriceIsNull() {
            addCriterion("charge_price is null");
            return (Criteria) this;
        }

        public Criteria andChargePriceIsNotNull() {
            addCriterion("charge_price is not null");
            return (Criteria) this;
        }

        public Criteria andChargePriceEqualTo(String value) {
            addCriterion("charge_price =", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotEqualTo(String value) {
            addCriterion("charge_price <>", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceGreaterThan(String value) {
            addCriterion("charge_price >", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceGreaterThanOrEqualTo(String value) {
            addCriterion("charge_price >=", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceLessThan(String value) {
            addCriterion("charge_price <", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceLessThanOrEqualTo(String value) {
            addCriterion("charge_price <=", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceLike(String value) {
            addCriterion("charge_price like", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotLike(String value) {
            addCriterion("charge_price not like", value, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceIn(List<String> values) {
            addCriterion("charge_price in", values, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotIn(List<String> values) {
            addCriterion("charge_price not in", values, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceBetween(String value1, String value2) {
            addCriterion("charge_price between", value1, value2, "chargePrice");
            return (Criteria) this;
        }

        public Criteria andChargePriceNotBetween(String value1, String value2) {
            addCriterion("charge_price not between", value1, value2, "chargePrice");
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