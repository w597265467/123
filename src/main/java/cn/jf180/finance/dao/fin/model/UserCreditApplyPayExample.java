package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCreditApplyPayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCreditApplyPayExample() {
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andFinCreditIdIsNull() {
            addCriterion("fin_credit_id is null");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdIsNotNull() {
            addCriterion("fin_credit_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdEqualTo(String value) {
            addCriterion("fin_credit_id =", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdNotEqualTo(String value) {
            addCriterion("fin_credit_id <>", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdGreaterThan(String value) {
            addCriterion("fin_credit_id >", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdGreaterThanOrEqualTo(String value) {
            addCriterion("fin_credit_id >=", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdLessThan(String value) {
            addCriterion("fin_credit_id <", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdLessThanOrEqualTo(String value) {
            addCriterion("fin_credit_id <=", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdLike(String value) {
            addCriterion("fin_credit_id like", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdNotLike(String value) {
            addCriterion("fin_credit_id not like", value, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdIn(List<String> values) {
            addCriterion("fin_credit_id in", values, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdNotIn(List<String> values) {
            addCriterion("fin_credit_id not in", values, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdBetween(String value1, String value2) {
            addCriterion("fin_credit_id between", value1, value2, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinCreditIdNotBetween(String value1, String value2) {
            addCriterion("fin_credit_id not between", value1, value2, "finCreditId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdIsNull() {
            addCriterion("fin_apply_pay_id is null");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdIsNotNull() {
            addCriterion("fin_apply_pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdEqualTo(String value) {
            addCriterion("fin_apply_pay_id =", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdNotEqualTo(String value) {
            addCriterion("fin_apply_pay_id <>", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdGreaterThan(String value) {
            addCriterion("fin_apply_pay_id >", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdGreaterThanOrEqualTo(String value) {
            addCriterion("fin_apply_pay_id >=", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdLessThan(String value) {
            addCriterion("fin_apply_pay_id <", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdLessThanOrEqualTo(String value) {
            addCriterion("fin_apply_pay_id <=", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdLike(String value) {
            addCriterion("fin_apply_pay_id like", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdNotLike(String value) {
            addCriterion("fin_apply_pay_id not like", value, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdIn(List<String> values) {
            addCriterion("fin_apply_pay_id in", values, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdNotIn(List<String> values) {
            addCriterion("fin_apply_pay_id not in", values, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdBetween(String value1, String value2) {
            addCriterion("fin_apply_pay_id between", value1, value2, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayIdNotBetween(String value1, String value2) {
            addCriterion("fin_apply_pay_id not between", value1, value2, "finApplyPayId");
            return (Criteria) this;
        }

        public Criteria andFinContractNoIsNull() {
            addCriterion("fin_contract_no is null");
            return (Criteria) this;
        }

        public Criteria andFinContractNoIsNotNull() {
            addCriterion("fin_contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andFinContractNoEqualTo(String value) {
            addCriterion("fin_contract_no =", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoNotEqualTo(String value) {
            addCriterion("fin_contract_no <>", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoGreaterThan(String value) {
            addCriterion("fin_contract_no >", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("fin_contract_no >=", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoLessThan(String value) {
            addCriterion("fin_contract_no <", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoLessThanOrEqualTo(String value) {
            addCriterion("fin_contract_no <=", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoLike(String value) {
            addCriterion("fin_contract_no like", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoNotLike(String value) {
            addCriterion("fin_contract_no not like", value, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoIn(List<String> values) {
            addCriterion("fin_contract_no in", values, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoNotIn(List<String> values) {
            addCriterion("fin_contract_no not in", values, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoBetween(String value1, String value2) {
            addCriterion("fin_contract_no between", value1, value2, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinContractNoNotBetween(String value1, String value2) {
            addCriterion("fin_contract_no not between", value1, value2, "finContractNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoIsNull() {
            addCriterion("fin_loan_no is null");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoIsNotNull() {
            addCriterion("fin_loan_no is not null");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoEqualTo(String value) {
            addCriterion("fin_loan_no =", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoNotEqualTo(String value) {
            addCriterion("fin_loan_no <>", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoGreaterThan(String value) {
            addCriterion("fin_loan_no >", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoGreaterThanOrEqualTo(String value) {
            addCriterion("fin_loan_no >=", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoLessThan(String value) {
            addCriterion("fin_loan_no <", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoLessThanOrEqualTo(String value) {
            addCriterion("fin_loan_no <=", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoLike(String value) {
            addCriterion("fin_loan_no like", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoNotLike(String value) {
            addCriterion("fin_loan_no not like", value, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoIn(List<String> values) {
            addCriterion("fin_loan_no in", values, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoNotIn(List<String> values) {
            addCriterion("fin_loan_no not in", values, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoBetween(String value1, String value2) {
            addCriterion("fin_loan_no between", value1, value2, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinLoanNoNotBetween(String value1, String value2) {
            addCriterion("fin_loan_no not between", value1, value2, "finLoanNo");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusIsNull() {
            addCriterion("fin_apply_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusIsNotNull() {
            addCriterion("fin_apply_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusEqualTo(Integer value) {
            addCriterion("fin_apply_pay_status =", value, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusNotEqualTo(Integer value) {
            addCriterion("fin_apply_pay_status <>", value, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusGreaterThan(Integer value) {
            addCriterion("fin_apply_pay_status >", value, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fin_apply_pay_status >=", value, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusLessThan(Integer value) {
            addCriterion("fin_apply_pay_status <", value, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fin_apply_pay_status <=", value, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusIn(List<Integer> values) {
            addCriterion("fin_apply_pay_status in", values, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusNotIn(List<Integer> values) {
            addCriterion("fin_apply_pay_status not in", values, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("fin_apply_pay_status between", value1, value2, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fin_apply_pay_status not between", value1, value2, "finApplyPayStatus");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeIsNull() {
            addCriterion("fin_apply_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeIsNotNull() {
            addCriterion("fin_apply_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeEqualTo(Date value) {
            addCriterion("fin_apply_pay_time =", value, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeNotEqualTo(Date value) {
            addCriterion("fin_apply_pay_time <>", value, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeGreaterThan(Date value) {
            addCriterion("fin_apply_pay_time >", value, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fin_apply_pay_time >=", value, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeLessThan(Date value) {
            addCriterion("fin_apply_pay_time <", value, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("fin_apply_pay_time <=", value, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeIn(List<Date> values) {
            addCriterion("fin_apply_pay_time in", values, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeNotIn(List<Date> values) {
            addCriterion("fin_apply_pay_time not in", values, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeBetween(Date value1, Date value2) {
            addCriterion("fin_apply_pay_time between", value1, value2, "finApplyPayTime");
            return (Criteria) this;
        }

        public Criteria andFinApplyPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("fin_apply_pay_time not between", value1, value2, "finApplyPayTime");
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