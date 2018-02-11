package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditOrderExample() {
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

        public Criteria andTmallUserNickIsNull() {
            addCriterion("tmall_user_nick is null");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickIsNotNull() {
            addCriterion("tmall_user_nick is not null");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickEqualTo(String value) {
            addCriterion("tmall_user_nick =", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickNotEqualTo(String value) {
            addCriterion("tmall_user_nick <>", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickGreaterThan(String value) {
            addCriterion("tmall_user_nick >", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_user_nick >=", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickLessThan(String value) {
            addCriterion("tmall_user_nick <", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickLessThanOrEqualTo(String value) {
            addCriterion("tmall_user_nick <=", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickLike(String value) {
            addCriterion("tmall_user_nick like", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickNotLike(String value) {
            addCriterion("tmall_user_nick not like", value, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickIn(List<String> values) {
            addCriterion("tmall_user_nick in", values, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickNotIn(List<String> values) {
            addCriterion("tmall_user_nick not in", values, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickBetween(String value1, String value2) {
            addCriterion("tmall_user_nick between", value1, value2, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallUserNickNotBetween(String value1, String value2) {
            addCriterion("tmall_user_nick not between", value1, value2, "tmallUserNick");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdIsNull() {
            addCriterion("tmall_mix_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdIsNotNull() {
            addCriterion("tmall_mix_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdEqualTo(String value) {
            addCriterion("tmall_mix_user_id =", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdNotEqualTo(String value) {
            addCriterion("tmall_mix_user_id <>", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdGreaterThan(String value) {
            addCriterion("tmall_mix_user_id >", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_mix_user_id >=", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdLessThan(String value) {
            addCriterion("tmall_mix_user_id <", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdLessThanOrEqualTo(String value) {
            addCriterion("tmall_mix_user_id <=", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdLike(String value) {
            addCriterion("tmall_mix_user_id like", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdNotLike(String value) {
            addCriterion("tmall_mix_user_id not like", value, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdIn(List<String> values) {
            addCriterion("tmall_mix_user_id in", values, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdNotIn(List<String> values) {
            addCriterion("tmall_mix_user_id not in", values, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdBetween(String value1, String value2) {
            addCriterion("tmall_mix_user_id between", value1, value2, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andTmallMixUserIdNotBetween(String value1, String value2) {
            addCriterion("tmall_mix_user_id not between", value1, value2, "tmallMixUserId");
            return (Criteria) this;
        }

        public Criteria andFinIdIsNull() {
            addCriterion("fin_id is null");
            return (Criteria) this;
        }

        public Criteria andFinIdIsNotNull() {
            addCriterion("fin_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinIdEqualTo(Integer value) {
            addCriterion("fin_id =", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotEqualTo(Integer value) {
            addCriterion("fin_id <>", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdGreaterThan(Integer value) {
            addCriterion("fin_id >", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fin_id >=", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdLessThan(Integer value) {
            addCriterion("fin_id <", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdLessThanOrEqualTo(Integer value) {
            addCriterion("fin_id <=", value, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdIn(List<Integer> values) {
            addCriterion("fin_id in", values, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotIn(List<Integer> values) {
            addCriterion("fin_id not in", values, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdBetween(Integer value1, Integer value2) {
            addCriterion("fin_id between", value1, value2, "finId");
            return (Criteria) this;
        }

        public Criteria andFinIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fin_id not between", value1, value2, "finId");
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

        public Criteria andInstallmentRuleIdIsNull() {
            addCriterion("installment_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdIsNotNull() {
            addCriterion("installment_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdEqualTo(String value) {
            addCriterion("installment_rule_id =", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdNotEqualTo(String value) {
            addCriterion("installment_rule_id <>", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdGreaterThan(String value) {
            addCriterion("installment_rule_id >", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("installment_rule_id >=", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdLessThan(String value) {
            addCriterion("installment_rule_id <", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdLessThanOrEqualTo(String value) {
            addCriterion("installment_rule_id <=", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdLike(String value) {
            addCriterion("installment_rule_id like", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdNotLike(String value) {
            addCriterion("installment_rule_id not like", value, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdIn(List<String> values) {
            addCriterion("installment_rule_id in", values, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdNotIn(List<String> values) {
            addCriterion("installment_rule_id not in", values, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdBetween(String value1, String value2) {
            addCriterion("installment_rule_id between", value1, value2, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andInstallmentRuleIdNotBetween(String value1, String value2) {
            addCriterion("installment_rule_id not between", value1, value2, "installmentRuleId");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountIsNull() {
            addCriterion("fin_credit_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountIsNotNull() {
            addCriterion("fin_credit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountEqualTo(String value) {
            addCriterion("fin_credit_amount =", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountNotEqualTo(String value) {
            addCriterion("fin_credit_amount <>", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountGreaterThan(String value) {
            addCriterion("fin_credit_amount >", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountGreaterThanOrEqualTo(String value) {
            addCriterion("fin_credit_amount >=", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountLessThan(String value) {
            addCriterion("fin_credit_amount <", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountLessThanOrEqualTo(String value) {
            addCriterion("fin_credit_amount <=", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountLike(String value) {
            addCriterion("fin_credit_amount like", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountNotLike(String value) {
            addCriterion("fin_credit_amount not like", value, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountIn(List<String> values) {
            addCriterion("fin_credit_amount in", values, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountNotIn(List<String> values) {
            addCriterion("fin_credit_amount not in", values, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountBetween(String value1, String value2) {
            addCriterion("fin_credit_amount between", value1, value2, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andFinCreditAmountNotBetween(String value1, String value2) {
            addCriterion("fin_credit_amount not between", value1, value2, "finCreditAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountIsNull() {
            addCriterion("ali_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountIsNotNull() {
            addCriterion("ali_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountEqualTo(String value) {
            addCriterion("ali_pay_amount =", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountNotEqualTo(String value) {
            addCriterion("ali_pay_amount <>", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountGreaterThan(String value) {
            addCriterion("ali_pay_amount >", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountGreaterThanOrEqualTo(String value) {
            addCriterion("ali_pay_amount >=", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountLessThan(String value) {
            addCriterion("ali_pay_amount <", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountLessThanOrEqualTo(String value) {
            addCriterion("ali_pay_amount <=", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountLike(String value) {
            addCriterion("ali_pay_amount like", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountNotLike(String value) {
            addCriterion("ali_pay_amount not like", value, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountIn(List<String> values) {
            addCriterion("ali_pay_amount in", values, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountNotIn(List<String> values) {
            addCriterion("ali_pay_amount not in", values, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountBetween(String value1, String value2) {
            addCriterion("ali_pay_amount between", value1, value2, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andAliPayAmountNotBetween(String value1, String value2) {
            addCriterion("ali_pay_amount not between", value1, value2, "aliPayAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdIsNull() {
            addCriterion("tmall_order_id is null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdIsNotNull() {
            addCriterion("tmall_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdEqualTo(String value) {
            addCriterion("tmall_order_id =", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdNotEqualTo(String value) {
            addCriterion("tmall_order_id <>", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdGreaterThan(String value) {
            addCriterion("tmall_order_id >", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_order_id >=", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdLessThan(String value) {
            addCriterion("tmall_order_id <", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdLessThanOrEqualTo(String value) {
            addCriterion("tmall_order_id <=", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdLike(String value) {
            addCriterion("tmall_order_id like", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdNotLike(String value) {
            addCriterion("tmall_order_id not like", value, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdIn(List<String> values) {
            addCriterion("tmall_order_id in", values, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdNotIn(List<String> values) {
            addCriterion("tmall_order_id not in", values, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdBetween(String value1, String value2) {
            addCriterion("tmall_order_id between", value1, value2, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderIdNotBetween(String value1, String value2) {
            addCriterion("tmall_order_id not between", value1, value2, "tmallOrderId");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountIsNull() {
            addCriterion("tmall_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountIsNotNull() {
            addCriterion("tmall_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountEqualTo(String value) {
            addCriterion("tmall_order_amount =", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountNotEqualTo(String value) {
            addCriterion("tmall_order_amount <>", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountGreaterThan(String value) {
            addCriterion("tmall_order_amount >", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_order_amount >=", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountLessThan(String value) {
            addCriterion("tmall_order_amount <", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountLessThanOrEqualTo(String value) {
            addCriterion("tmall_order_amount <=", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountLike(String value) {
            addCriterion("tmall_order_amount like", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountNotLike(String value) {
            addCriterion("tmall_order_amount not like", value, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountIn(List<String> values) {
            addCriterion("tmall_order_amount in", values, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountNotIn(List<String> values) {
            addCriterion("tmall_order_amount not in", values, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountBetween(String value1, String value2) {
            addCriterion("tmall_order_amount between", value1, value2, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andTmallOrderAmountNotBetween(String value1, String value2) {
            addCriterion("tmall_order_amount not between", value1, value2, "tmallOrderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNull() {
            addCriterion("order_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNotNull() {
            addCriterion("order_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyEqualTo(String value) {
            addCriterion("order_money =", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotEqualTo(String value) {
            addCriterion("order_money <>", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThan(String value) {
            addCriterion("order_money >", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("order_money >=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThan(String value) {
            addCriterion("order_money <", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThanOrEqualTo(String value) {
            addCriterion("order_money <=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLike(String value) {
            addCriterion("order_money like", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotLike(String value) {
            addCriterion("order_money not like", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIn(List<String> values) {
            addCriterion("order_money in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotIn(List<String> values) {
            addCriterion("order_money not in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyBetween(String value1, String value2) {
            addCriterion("order_money between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotBetween(String value1, String value2) {
            addCriterion("order_money not between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusIsNull() {
            addCriterion("tmall_order_status is null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusIsNotNull() {
            addCriterion("tmall_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusEqualTo(Integer value) {
            addCriterion("tmall_order_status =", value, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusNotEqualTo(Integer value) {
            addCriterion("tmall_order_status <>", value, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusGreaterThan(Integer value) {
            addCriterion("tmall_order_status >", value, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("tmall_order_status >=", value, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusLessThan(Integer value) {
            addCriterion("tmall_order_status <", value, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("tmall_order_status <=", value, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusIn(List<Integer> values) {
            addCriterion("tmall_order_status in", values, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusNotIn(List<Integer> values) {
            addCriterion("tmall_order_status not in", values, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("tmall_order_status between", value1, value2, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andTmallOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("tmall_order_status not between", value1, value2, "tmallOrderStatus");
            return (Criteria) this;
        }

        public Criteria andSellerNickIsNull() {
            addCriterion("seller_nick is null");
            return (Criteria) this;
        }

        public Criteria andSellerNickIsNotNull() {
            addCriterion("seller_nick is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNickEqualTo(String value) {
            addCriterion("seller_nick =", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotEqualTo(String value) {
            addCriterion("seller_nick <>", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickGreaterThan(String value) {
            addCriterion("seller_nick >", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickGreaterThanOrEqualTo(String value) {
            addCriterion("seller_nick >=", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLessThan(String value) {
            addCriterion("seller_nick <", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLessThanOrEqualTo(String value) {
            addCriterion("seller_nick <=", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLike(String value) {
            addCriterion("seller_nick like", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotLike(String value) {
            addCriterion("seller_nick not like", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickIn(List<String> values) {
            addCriterion("seller_nick in", values, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotIn(List<String> values) {
            addCriterion("seller_nick not in", values, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickBetween(String value1, String value2) {
            addCriterion("seller_nick between", value1, value2, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotBetween(String value1, String value2) {
            addCriterion("seller_nick not between", value1, value2, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdIsNull() {
            addCriterion("tmall_item_id is null");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdIsNotNull() {
            addCriterion("tmall_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdEqualTo(String value) {
            addCriterion("tmall_item_id =", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdNotEqualTo(String value) {
            addCriterion("tmall_item_id <>", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdGreaterThan(String value) {
            addCriterion("tmall_item_id >", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_item_id >=", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdLessThan(String value) {
            addCriterion("tmall_item_id <", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdLessThanOrEqualTo(String value) {
            addCriterion("tmall_item_id <=", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdLike(String value) {
            addCriterion("tmall_item_id like", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdNotLike(String value) {
            addCriterion("tmall_item_id not like", value, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdIn(List<String> values) {
            addCriterion("tmall_item_id in", values, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdNotIn(List<String> values) {
            addCriterion("tmall_item_id not in", values, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdBetween(String value1, String value2) {
            addCriterion("tmall_item_id between", value1, value2, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallItemIdNotBetween(String value1, String value2) {
            addCriterion("tmall_item_id not between", value1, value2, "tmallItemId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdIsNull() {
            addCriterion("tmall_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdIsNotNull() {
            addCriterion("tmall_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdEqualTo(String value) {
            addCriterion("tmall_sku_id =", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdNotEqualTo(String value) {
            addCriterion("tmall_sku_id <>", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdGreaterThan(String value) {
            addCriterion("tmall_sku_id >", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_sku_id >=", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdLessThan(String value) {
            addCriterion("tmall_sku_id <", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdLessThanOrEqualTo(String value) {
            addCriterion("tmall_sku_id <=", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdLike(String value) {
            addCriterion("tmall_sku_id like", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdNotLike(String value) {
            addCriterion("tmall_sku_id not like", value, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdIn(List<String> values) {
            addCriterion("tmall_sku_id in", values, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdNotIn(List<String> values) {
            addCriterion("tmall_sku_id not in", values, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdBetween(String value1, String value2) {
            addCriterion("tmall_sku_id between", value1, value2, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andTmallSkuIdNotBetween(String value1, String value2) {
            addCriterion("tmall_sku_id not between", value1, value2, "tmallSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageContractIsNull() {
            addCriterion("package_contract is null");
            return (Criteria) this;
        }

        public Criteria andPackageContractIsNotNull() {
            addCriterion("package_contract is not null");
            return (Criteria) this;
        }

        public Criteria andPackageContractEqualTo(Integer value) {
            addCriterion("package_contract =", value, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractNotEqualTo(Integer value) {
            addCriterion("package_contract <>", value, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractGreaterThan(Integer value) {
            addCriterion("package_contract >", value, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_contract >=", value, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractLessThan(Integer value) {
            addCriterion("package_contract <", value, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractLessThanOrEqualTo(Integer value) {
            addCriterion("package_contract <=", value, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractIn(List<Integer> values) {
            addCriterion("package_contract in", values, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractNotIn(List<Integer> values) {
            addCriterion("package_contract not in", values, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractBetween(Integer value1, Integer value2) {
            addCriterion("package_contract between", value1, value2, "packageContract");
            return (Criteria) this;
        }

        public Criteria andPackageContractNotBetween(Integer value1, Integer value2) {
            addCriterion("package_contract not between", value1, value2, "packageContract");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeIsNull() {
            addCriterion("monthly_fee is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeIsNotNull() {
            addCriterion("monthly_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeEqualTo(Integer value) {
            addCriterion("monthly_fee =", value, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeNotEqualTo(Integer value) {
            addCriterion("monthly_fee <>", value, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeGreaterThan(Integer value) {
            addCriterion("monthly_fee >", value, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthly_fee >=", value, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeLessThan(Integer value) {
            addCriterion("monthly_fee <", value, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeLessThanOrEqualTo(Integer value) {
            addCriterion("monthly_fee <=", value, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeIn(List<Integer> values) {
            addCriterion("monthly_fee in", values, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeNotIn(List<Integer> values) {
            addCriterion("monthly_fee not in", values, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeBetween(Integer value1, Integer value2) {
            addCriterion("monthly_fee between", value1, value2, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andMonthlyFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("monthly_fee not between", value1, value2, "monthlyFee");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNull() {
            addCriterion("contract_period is null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNotNull() {
            addCriterion("contract_period is not null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodEqualTo(Integer value) {
            addCriterion("contract_period =", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotEqualTo(Integer value) {
            addCriterion("contract_period <>", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThan(Integer value) {
            addCriterion("contract_period >", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_period >=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThan(Integer value) {
            addCriterion("contract_period <", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("contract_period <=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIn(List<Integer> values) {
            addCriterion("contract_period in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotIn(List<Integer> values) {
            addCriterion("contract_period not in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodBetween(Integer value1, Integer value2) {
            addCriterion("contract_period between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_period not between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsIsNull() {
            addCriterion("package_details is null");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsIsNotNull() {
            addCriterion("package_details is not null");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsEqualTo(String value) {
            addCriterion("package_details =", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsNotEqualTo(String value) {
            addCriterion("package_details <>", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsGreaterThan(String value) {
            addCriterion("package_details >", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("package_details >=", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsLessThan(String value) {
            addCriterion("package_details <", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsLessThanOrEqualTo(String value) {
            addCriterion("package_details <=", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsLike(String value) {
            addCriterion("package_details like", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsNotLike(String value) {
            addCriterion("package_details not like", value, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsIn(List<String> values) {
            addCriterion("package_details in", values, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsNotIn(List<String> values) {
            addCriterion("package_details not in", values, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsBetween(String value1, String value2) {
            addCriterion("package_details between", value1, value2, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPackageDetailsNotBetween(String value1, String value2) {
            addCriterion("package_details not between", value1, value2, "packageDetails");
            return (Criteria) this;
        }

        public Criteria andPckToMobileIsNull() {
            addCriterion("pck_to_mobile is null");
            return (Criteria) this;
        }

        public Criteria andPckToMobileIsNotNull() {
            addCriterion("pck_to_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andPckToMobileEqualTo(String value) {
            addCriterion("pck_to_mobile =", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileNotEqualTo(String value) {
            addCriterion("pck_to_mobile <>", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileGreaterThan(String value) {
            addCriterion("pck_to_mobile >", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileGreaterThanOrEqualTo(String value) {
            addCriterion("pck_to_mobile >=", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileLessThan(String value) {
            addCriterion("pck_to_mobile <", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileLessThanOrEqualTo(String value) {
            addCriterion("pck_to_mobile <=", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileLike(String value) {
            addCriterion("pck_to_mobile like", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileNotLike(String value) {
            addCriterion("pck_to_mobile not like", value, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileIn(List<String> values) {
            addCriterion("pck_to_mobile in", values, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileNotIn(List<String> values) {
            addCriterion("pck_to_mobile not in", values, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileBetween(String value1, String value2) {
            addCriterion("pck_to_mobile between", value1, value2, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToMobileNotBetween(String value1, String value2) {
            addCriterion("pck_to_mobile not between", value1, value2, "pckToMobile");
            return (Criteria) this;
        }

        public Criteria andPckToNameIsNull() {
            addCriterion("pck_to_name is null");
            return (Criteria) this;
        }

        public Criteria andPckToNameIsNotNull() {
            addCriterion("pck_to_name is not null");
            return (Criteria) this;
        }

        public Criteria andPckToNameEqualTo(String value) {
            addCriterion("pck_to_name =", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameNotEqualTo(String value) {
            addCriterion("pck_to_name <>", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameGreaterThan(String value) {
            addCriterion("pck_to_name >", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameGreaterThanOrEqualTo(String value) {
            addCriterion("pck_to_name >=", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameLessThan(String value) {
            addCriterion("pck_to_name <", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameLessThanOrEqualTo(String value) {
            addCriterion("pck_to_name <=", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameLike(String value) {
            addCriterion("pck_to_name like", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameNotLike(String value) {
            addCriterion("pck_to_name not like", value, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameIn(List<String> values) {
            addCriterion("pck_to_name in", values, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameNotIn(List<String> values) {
            addCriterion("pck_to_name not in", values, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameBetween(String value1, String value2) {
            addCriterion("pck_to_name between", value1, value2, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToNameNotBetween(String value1, String value2) {
            addCriterion("pck_to_name not between", value1, value2, "pckToName");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumIsNull() {
            addCriterion("pck_to_idcard_num is null");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumIsNotNull() {
            addCriterion("pck_to_idcard_num is not null");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumEqualTo(String value) {
            addCriterion("pck_to_idcard_num =", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumNotEqualTo(String value) {
            addCriterion("pck_to_idcard_num <>", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumGreaterThan(String value) {
            addCriterion("pck_to_idcard_num >", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumGreaterThanOrEqualTo(String value) {
            addCriterion("pck_to_idcard_num >=", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumLessThan(String value) {
            addCriterion("pck_to_idcard_num <", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumLessThanOrEqualTo(String value) {
            addCriterion("pck_to_idcard_num <=", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumLike(String value) {
            addCriterion("pck_to_idcard_num like", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumNotLike(String value) {
            addCriterion("pck_to_idcard_num not like", value, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumIn(List<String> values) {
            addCriterion("pck_to_idcard_num in", values, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumNotIn(List<String> values) {
            addCriterion("pck_to_idcard_num not in", values, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumBetween(String value1, String value2) {
            addCriterion("pck_to_idcard_num between", value1, value2, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andPckToIdcardNumNotBetween(String value1, String value2) {
            addCriterion("pck_to_idcard_num not between", value1, value2, "pckToIdcardNum");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andTradeLngIsNull() {
            addCriterion("trade_lng is null");
            return (Criteria) this;
        }

        public Criteria andTradeLngIsNotNull() {
            addCriterion("trade_lng is not null");
            return (Criteria) this;
        }

        public Criteria andTradeLngEqualTo(String value) {
            addCriterion("trade_lng =", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngNotEqualTo(String value) {
            addCriterion("trade_lng <>", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngGreaterThan(String value) {
            addCriterion("trade_lng >", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngGreaterThanOrEqualTo(String value) {
            addCriterion("trade_lng >=", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngLessThan(String value) {
            addCriterion("trade_lng <", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngLessThanOrEqualTo(String value) {
            addCriterion("trade_lng <=", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngLike(String value) {
            addCriterion("trade_lng like", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngNotLike(String value) {
            addCriterion("trade_lng not like", value, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngIn(List<String> values) {
            addCriterion("trade_lng in", values, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngNotIn(List<String> values) {
            addCriterion("trade_lng not in", values, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngBetween(String value1, String value2) {
            addCriterion("trade_lng between", value1, value2, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLngNotBetween(String value1, String value2) {
            addCriterion("trade_lng not between", value1, value2, "tradeLng");
            return (Criteria) this;
        }

        public Criteria andTradeLatIsNull() {
            addCriterion("trade_lat is null");
            return (Criteria) this;
        }

        public Criteria andTradeLatIsNotNull() {
            addCriterion("trade_lat is not null");
            return (Criteria) this;
        }

        public Criteria andTradeLatEqualTo(String value) {
            addCriterion("trade_lat =", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatNotEqualTo(String value) {
            addCriterion("trade_lat <>", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatGreaterThan(String value) {
            addCriterion("trade_lat >", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatGreaterThanOrEqualTo(String value) {
            addCriterion("trade_lat >=", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatLessThan(String value) {
            addCriterion("trade_lat <", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatLessThanOrEqualTo(String value) {
            addCriterion("trade_lat <=", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatLike(String value) {
            addCriterion("trade_lat like", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatNotLike(String value) {
            addCriterion("trade_lat not like", value, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatIn(List<String> values) {
            addCriterion("trade_lat in", values, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatNotIn(List<String> values) {
            addCriterion("trade_lat not in", values, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatBetween(String value1, String value2) {
            addCriterion("trade_lat between", value1, value2, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeLatNotBetween(String value1, String value2) {
            addCriterion("trade_lat not between", value1, value2, "tradeLat");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceIsNull() {
            addCriterion("trade_province is null");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceIsNotNull() {
            addCriterion("trade_province is not null");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceEqualTo(String value) {
            addCriterion("trade_province =", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceNotEqualTo(String value) {
            addCriterion("trade_province <>", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceGreaterThan(String value) {
            addCriterion("trade_province >", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("trade_province >=", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceLessThan(String value) {
            addCriterion("trade_province <", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceLessThanOrEqualTo(String value) {
            addCriterion("trade_province <=", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceLike(String value) {
            addCriterion("trade_province like", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceNotLike(String value) {
            addCriterion("trade_province not like", value, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceIn(List<String> values) {
            addCriterion("trade_province in", values, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceNotIn(List<String> values) {
            addCriterion("trade_province not in", values, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceBetween(String value1, String value2) {
            addCriterion("trade_province between", value1, value2, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeProvinceNotBetween(String value1, String value2) {
            addCriterion("trade_province not between", value1, value2, "tradeProvince");
            return (Criteria) this;
        }

        public Criteria andTradeCityIsNull() {
            addCriterion("trade_city is null");
            return (Criteria) this;
        }

        public Criteria andTradeCityIsNotNull() {
            addCriterion("trade_city is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCityEqualTo(String value) {
            addCriterion("trade_city =", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityNotEqualTo(String value) {
            addCriterion("trade_city <>", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityGreaterThan(String value) {
            addCriterion("trade_city >", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityGreaterThanOrEqualTo(String value) {
            addCriterion("trade_city >=", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityLessThan(String value) {
            addCriterion("trade_city <", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityLessThanOrEqualTo(String value) {
            addCriterion("trade_city <=", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityLike(String value) {
            addCriterion("trade_city like", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityNotLike(String value) {
            addCriterion("trade_city not like", value, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityIn(List<String> values) {
            addCriterion("trade_city in", values, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityNotIn(List<String> values) {
            addCriterion("trade_city not in", values, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityBetween(String value1, String value2) {
            addCriterion("trade_city between", value1, value2, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeCityNotBetween(String value1, String value2) {
            addCriterion("trade_city not between", value1, value2, "tradeCity");
            return (Criteria) this;
        }

        public Criteria andTradeAreaIsNull() {
            addCriterion("trade_area is null");
            return (Criteria) this;
        }

        public Criteria andTradeAreaIsNotNull() {
            addCriterion("trade_area is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAreaEqualTo(String value) {
            addCriterion("trade_area =", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaNotEqualTo(String value) {
            addCriterion("trade_area <>", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaGreaterThan(String value) {
            addCriterion("trade_area >", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaGreaterThanOrEqualTo(String value) {
            addCriterion("trade_area >=", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaLessThan(String value) {
            addCriterion("trade_area <", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaLessThanOrEqualTo(String value) {
            addCriterion("trade_area <=", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaLike(String value) {
            addCriterion("trade_area like", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaNotLike(String value) {
            addCriterion("trade_area not like", value, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaIn(List<String> values) {
            addCriterion("trade_area in", values, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaNotIn(List<String> values) {
            addCriterion("trade_area not in", values, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaBetween(String value1, String value2) {
            addCriterion("trade_area between", value1, value2, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeAreaNotBetween(String value1, String value2) {
            addCriterion("trade_area not between", value1, value2, "tradeArea");
            return (Criteria) this;
        }

        public Criteria andTradeIpIsNull() {
            addCriterion("trade_ip is null");
            return (Criteria) this;
        }

        public Criteria andTradeIpIsNotNull() {
            addCriterion("trade_ip is not null");
            return (Criteria) this;
        }

        public Criteria andTradeIpEqualTo(String value) {
            addCriterion("trade_ip =", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpNotEqualTo(String value) {
            addCriterion("trade_ip <>", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpGreaterThan(String value) {
            addCriterion("trade_ip >", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpGreaterThanOrEqualTo(String value) {
            addCriterion("trade_ip >=", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpLessThan(String value) {
            addCriterion("trade_ip <", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpLessThanOrEqualTo(String value) {
            addCriterion("trade_ip <=", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpLike(String value) {
            addCriterion("trade_ip like", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpNotLike(String value) {
            addCriterion("trade_ip not like", value, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpIn(List<String> values) {
            addCriterion("trade_ip in", values, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpNotIn(List<String> values) {
            addCriterion("trade_ip not in", values, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpBetween(String value1, String value2) {
            addCriterion("trade_ip between", value1, value2, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andTradeIpNotBetween(String value1, String value2) {
            addCriterion("trade_ip not between", value1, value2, "tradeIp");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusIsNull() {
            addCriterion("processing_result_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusIsNotNull() {
            addCriterion("processing_result_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusEqualTo(Integer value) {
            addCriterion("processing_result_status =", value, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusNotEqualTo(Integer value) {
            addCriterion("processing_result_status <>", value, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusGreaterThan(Integer value) {
            addCriterion("processing_result_status >", value, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("processing_result_status >=", value, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusLessThan(Integer value) {
            addCriterion("processing_result_status <", value, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusLessThanOrEqualTo(Integer value) {
            addCriterion("processing_result_status <=", value, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusIn(List<Integer> values) {
            addCriterion("processing_result_status in", values, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusNotIn(List<Integer> values) {
            addCriterion("processing_result_status not in", values, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusBetween(Integer value1, Integer value2) {
            addCriterion("processing_result_status between", value1, value2, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("processing_result_status not between", value1, value2, "processingResultStatus");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescIsNull() {
            addCriterion("processing_result_desc is null");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescIsNotNull() {
            addCriterion("processing_result_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescEqualTo(String value) {
            addCriterion("processing_result_desc =", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescNotEqualTo(String value) {
            addCriterion("processing_result_desc <>", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescGreaterThan(String value) {
            addCriterion("processing_result_desc >", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescGreaterThanOrEqualTo(String value) {
            addCriterion("processing_result_desc >=", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescLessThan(String value) {
            addCriterion("processing_result_desc <", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescLessThanOrEqualTo(String value) {
            addCriterion("processing_result_desc <=", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescLike(String value) {
            addCriterion("processing_result_desc like", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescNotLike(String value) {
            addCriterion("processing_result_desc not like", value, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescIn(List<String> values) {
            addCriterion("processing_result_desc in", values, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescNotIn(List<String> values) {
            addCriterion("processing_result_desc not in", values, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescBetween(String value1, String value2) {
            addCriterion("processing_result_desc between", value1, value2, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andProcessingResultDescNotBetween(String value1, String value2) {
            addCriterion("processing_result_desc not between", value1, value2, "processingResultDesc");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNull() {
            addCriterion("order_source is null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNotNull() {
            addCriterion("order_source is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceEqualTo(Integer value) {
            addCriterion("order_source =", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotEqualTo(Integer value) {
            addCriterion("order_source <>", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThan(Integer value) {
            addCriterion("order_source >", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_source >=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThan(Integer value) {
            addCriterion("order_source <", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThanOrEqualTo(Integer value) {
            addCriterion("order_source <=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIn(List<Integer> values) {
            addCriterion("order_source in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotIn(List<Integer> values) {
            addCriterion("order_source not in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceBetween(Integer value1, Integer value2) {
            addCriterion("order_source between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_source not between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNull() {
            addCriterion("order_from is null");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNotNull() {
            addCriterion("order_from is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFromEqualTo(String value) {
            addCriterion("order_from =", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotEqualTo(String value) {
            addCriterion("order_from <>", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThan(String value) {
            addCriterion("order_from >", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThanOrEqualTo(String value) {
            addCriterion("order_from >=", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThan(String value) {
            addCriterion("order_from <", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThanOrEqualTo(String value) {
            addCriterion("order_from <=", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLike(String value) {
            addCriterion("order_from like", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotLike(String value) {
            addCriterion("order_from not like", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromIn(List<String> values) {
            addCriterion("order_from in", values, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotIn(List<String> values) {
            addCriterion("order_from not in", values, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromBetween(String value1, String value2) {
            addCriterion("order_from between", value1, value2, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotBetween(String value1, String value2) {
            addCriterion("order_from not between", value1, value2, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNull() {
            addCriterion("express_code is null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNotNull() {
            addCriterion("express_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeEqualTo(String value) {
            addCriterion("express_code =", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            addCriterion("express_code <>", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            addCriterion("express_code >", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("express_code >=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThan(String value) {
            addCriterion("express_code <", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            addCriterion("express_code <=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLike(String value) {
            addCriterion("express_code like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotLike(String value) {
            addCriterion("express_code not like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIn(List<String> values) {
            addCriterion("express_code in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            addCriterion("express_code not in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            addCriterion("express_code between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            addCriterion("express_code not between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNull() {
            addCriterion("express_name is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("express_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("express_name =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("express_name <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("express_name >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("express_name >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("express_name <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("express_name <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("express_name like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("express_name not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("express_name in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("express_name not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("express_name between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("express_name not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeIsNull() {
            addCriterion("tmall_order_time is null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeIsNotNull() {
            addCriterion("tmall_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeEqualTo(Date value) {
            addCriterion("tmall_order_time =", value, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeNotEqualTo(Date value) {
            addCriterion("tmall_order_time <>", value, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeGreaterThan(Date value) {
            addCriterion("tmall_order_time >", value, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tmall_order_time >=", value, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeLessThan(Date value) {
            addCriterion("tmall_order_time <", value, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("tmall_order_time <=", value, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeIn(List<Date> values) {
            addCriterion("tmall_order_time in", values, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeNotIn(List<Date> values) {
            addCriterion("tmall_order_time not in", values, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeBetween(Date value1, Date value2) {
            addCriterion("tmall_order_time between", value1, value2, "tmallOrderTime");
            return (Criteria) this;
        }

        public Criteria andTmallOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("tmall_order_time not between", value1, value2, "tmallOrderTime");
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