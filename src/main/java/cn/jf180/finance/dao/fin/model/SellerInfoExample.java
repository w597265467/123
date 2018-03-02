package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellerInfoExample() {
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

        public Criteria andSellerNameIsNull() {
            addCriterion("seller_name is null");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNotNull() {
            addCriterion("seller_name is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNameEqualTo(String value) {
            addCriterion("seller_name =", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotEqualTo(String value) {
            addCriterion("seller_name <>", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThan(String value) {
            addCriterion("seller_name >", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            addCriterion("seller_name >=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThan(String value) {
            addCriterion("seller_name <", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThanOrEqualTo(String value) {
            addCriterion("seller_name <=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLike(String value) {
            addCriterion("seller_name like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotLike(String value) {
            addCriterion("seller_name not like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameIn(List<String> values) {
            addCriterion("seller_name in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotIn(List<String> values) {
            addCriterion("seller_name not in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameBetween(String value1, String value2) {
            addCriterion("seller_name between", value1, value2, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotBetween(String value1, String value2) {
            addCriterion("seller_name not between", value1, value2, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameIsNull() {
            addCriterion("seller_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameIsNotNull() {
            addCriterion("seller_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameEqualTo(String value) {
            addCriterion("seller_bank_name =", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameNotEqualTo(String value) {
            addCriterion("seller_bank_name <>", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameGreaterThan(String value) {
            addCriterion("seller_bank_name >", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("seller_bank_name >=", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameLessThan(String value) {
            addCriterion("seller_bank_name <", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameLessThanOrEqualTo(String value) {
            addCriterion("seller_bank_name <=", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameLike(String value) {
            addCriterion("seller_bank_name like", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameNotLike(String value) {
            addCriterion("seller_bank_name not like", value, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameIn(List<String> values) {
            addCriterion("seller_bank_name in", values, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameNotIn(List<String> values) {
            addCriterion("seller_bank_name not in", values, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameBetween(String value1, String value2) {
            addCriterion("seller_bank_name between", value1, value2, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankNameNotBetween(String value1, String value2) {
            addCriterion("seller_bank_name not between", value1, value2, "sellerBankName");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardIsNull() {
            addCriterion("seller_bank_card is null");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardIsNotNull() {
            addCriterion("seller_bank_card is not null");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardEqualTo(String value) {
            addCriterion("seller_bank_card =", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardNotEqualTo(String value) {
            addCriterion("seller_bank_card <>", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardGreaterThan(String value) {
            addCriterion("seller_bank_card >", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("seller_bank_card >=", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardLessThan(String value) {
            addCriterion("seller_bank_card <", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardLessThanOrEqualTo(String value) {
            addCriterion("seller_bank_card <=", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardLike(String value) {
            addCriterion("seller_bank_card like", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardNotLike(String value) {
            addCriterion("seller_bank_card not like", value, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardIn(List<String> values) {
            addCriterion("seller_bank_card in", values, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardNotIn(List<String> values) {
            addCriterion("seller_bank_card not in", values, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardBetween(String value1, String value2) {
            addCriterion("seller_bank_card between", value1, value2, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andSellerBankCardNotBetween(String value1, String value2) {
            addCriterion("seller_bank_card not between", value1, value2, "sellerBankCard");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickIsNull() {
            addCriterion("tmall_seller_nick is null");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickIsNotNull() {
            addCriterion("tmall_seller_nick is not null");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickEqualTo(String value) {
            addCriterion("tmall_seller_nick =", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickNotEqualTo(String value) {
            addCriterion("tmall_seller_nick <>", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickGreaterThan(String value) {
            addCriterion("tmall_seller_nick >", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_seller_nick >=", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickLessThan(String value) {
            addCriterion("tmall_seller_nick <", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickLessThanOrEqualTo(String value) {
            addCriterion("tmall_seller_nick <=", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickLike(String value) {
            addCriterion("tmall_seller_nick like", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickNotLike(String value) {
            addCriterion("tmall_seller_nick not like", value, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickIn(List<String> values) {
            addCriterion("tmall_seller_nick in", values, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickNotIn(List<String> values) {
            addCriterion("tmall_seller_nick not in", values, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickBetween(String value1, String value2) {
            addCriterion("tmall_seller_nick between", value1, value2, "tmallSellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallSellerNickNotBetween(String value1, String value2) {
            addCriterion("tmall_seller_nick not between", value1, value2, "tmallSellerNick");
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