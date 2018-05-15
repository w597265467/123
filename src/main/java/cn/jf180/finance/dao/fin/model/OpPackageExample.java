package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.List;

public class OpPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpPackageExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andReturnFeeIsNull() {
            addCriterion("return_fee is null");
            return (Criteria) this;
        }

        public Criteria andReturnFeeIsNotNull() {
            addCriterion("return_fee is not null");
            return (Criteria) this;
        }

        public Criteria andReturnFeeEqualTo(Integer value) {
            addCriterion("return_fee =", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeNotEqualTo(Integer value) {
            addCriterion("return_fee <>", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeGreaterThan(Integer value) {
            addCriterion("return_fee >", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_fee >=", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeLessThan(Integer value) {
            addCriterion("return_fee <", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeLessThanOrEqualTo(Integer value) {
            addCriterion("return_fee <=", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeIn(List<Integer> values) {
            addCriterion("return_fee in", values, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeNotIn(List<Integer> values) {
            addCriterion("return_fee not in", values, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeBetween(Integer value1, Integer value2) {
            addCriterion("return_fee between", value1, value2, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("return_fee not between", value1, value2, "returnFee");
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

        public Criteria andContractPeriodEqualTo(String value) {
            addCriterion("contract_period =", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotEqualTo(String value) {
            addCriterion("contract_period <>", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThan(String value) {
            addCriterion("contract_period >", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("contract_period >=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThan(String value) {
            addCriterion("contract_period <", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThanOrEqualTo(String value) {
            addCriterion("contract_period <=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLike(String value) {
            addCriterion("contract_period like", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotLike(String value) {
            addCriterion("contract_period not like", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIn(List<String> values) {
            addCriterion("contract_period in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotIn(List<String> values) {
            addCriterion("contract_period not in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodBetween(String value1, String value2) {
            addCriterion("contract_period between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotBetween(String value1, String value2) {
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

        public Criteria andPackageDetailIsNull() {
            addCriterion("package_detail is null");
            return (Criteria) this;
        }

        public Criteria andPackageDetailIsNotNull() {
            addCriterion("package_detail is not null");
            return (Criteria) this;
        }

        public Criteria andPackageDetailEqualTo(String value) {
            addCriterion("package_detail =", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailNotEqualTo(String value) {
            addCriterion("package_detail <>", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailGreaterThan(String value) {
            addCriterion("package_detail >", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailGreaterThanOrEqualTo(String value) {
            addCriterion("package_detail >=", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailLessThan(String value) {
            addCriterion("package_detail <", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailLessThanOrEqualTo(String value) {
            addCriterion("package_detail <=", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailLike(String value) {
            addCriterion("package_detail like", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailNotLike(String value) {
            addCriterion("package_detail not like", value, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailIn(List<String> values) {
            addCriterion("package_detail in", values, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailNotIn(List<String> values) {
            addCriterion("package_detail not in", values, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailBetween(String value1, String value2) {
            addCriterion("package_detail between", value1, value2, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andPackageDetailNotBetween(String value1, String value2) {
            addCriterion("package_detail not between", value1, value2, "packageDetail");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowIsNull() {
            addCriterion("domestic_flow is null");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowIsNotNull() {
            addCriterion("domestic_flow is not null");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowEqualTo(String value) {
            addCriterion("domestic_flow =", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowNotEqualTo(String value) {
            addCriterion("domestic_flow <>", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowGreaterThan(String value) {
            addCriterion("domestic_flow >", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowGreaterThanOrEqualTo(String value) {
            addCriterion("domestic_flow >=", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowLessThan(String value) {
            addCriterion("domestic_flow <", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowLessThanOrEqualTo(String value) {
            addCriterion("domestic_flow <=", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowLike(String value) {
            addCriterion("domestic_flow like", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowNotLike(String value) {
            addCriterion("domestic_flow not like", value, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowIn(List<String> values) {
            addCriterion("domestic_flow in", values, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowNotIn(List<String> values) {
            addCriterion("domestic_flow not in", values, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowBetween(String value1, String value2) {
            addCriterion("domestic_flow between", value1, value2, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticFlowNotBetween(String value1, String value2) {
            addCriterion("domestic_flow not between", value1, value2, "domesticFlow");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeIsNull() {
            addCriterion("domestic_time is null");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeIsNotNull() {
            addCriterion("domestic_time is not null");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeEqualTo(Integer value) {
            addCriterion("domestic_time =", value, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeNotEqualTo(Integer value) {
            addCriterion("domestic_time <>", value, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeGreaterThan(Integer value) {
            addCriterion("domestic_time >", value, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("domestic_time >=", value, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeLessThan(Integer value) {
            addCriterion("domestic_time <", value, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeLessThanOrEqualTo(Integer value) {
            addCriterion("domestic_time <=", value, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeIn(List<Integer> values) {
            addCriterion("domestic_time in", values, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeNotIn(List<Integer> values) {
            addCriterion("domestic_time not in", values, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeBetween(Integer value1, Integer value2) {
            addCriterion("domestic_time between", value1, value2, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andDomesticTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("domestic_time not between", value1, value2, "domesticTime");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowIsNull() {
            addCriterion("provincial_flow is null");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowIsNotNull() {
            addCriterion("provincial_flow is not null");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowEqualTo(String value) {
            addCriterion("provincial_flow =", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowNotEqualTo(String value) {
            addCriterion("provincial_flow <>", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowGreaterThan(String value) {
            addCriterion("provincial_flow >", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowGreaterThanOrEqualTo(String value) {
            addCriterion("provincial_flow >=", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowLessThan(String value) {
            addCriterion("provincial_flow <", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowLessThanOrEqualTo(String value) {
            addCriterion("provincial_flow <=", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowLike(String value) {
            addCriterion("provincial_flow like", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowNotLike(String value) {
            addCriterion("provincial_flow not like", value, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowIn(List<String> values) {
            addCriterion("provincial_flow in", values, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowNotIn(List<String> values) {
            addCriterion("provincial_flow not in", values, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowBetween(String value1, String value2) {
            addCriterion("provincial_flow between", value1, value2, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialFlowNotBetween(String value1, String value2) {
            addCriterion("provincial_flow not between", value1, value2, "provincialFlow");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeIsNull() {
            addCriterion("provincial_time is null");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeIsNotNull() {
            addCriterion("provincial_time is not null");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeEqualTo(Integer value) {
            addCriterion("provincial_time =", value, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeNotEqualTo(Integer value) {
            addCriterion("provincial_time <>", value, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeGreaterThan(Integer value) {
            addCriterion("provincial_time >", value, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("provincial_time >=", value, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeLessThan(Integer value) {
            addCriterion("provincial_time <", value, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeLessThanOrEqualTo(Integer value) {
            addCriterion("provincial_time <=", value, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeIn(List<Integer> values) {
            addCriterion("provincial_time in", values, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeNotIn(List<Integer> values) {
            addCriterion("provincial_time not in", values, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeBetween(Integer value1, Integer value2) {
            addCriterion("provincial_time between", value1, value2, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andProvincialTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("provincial_time not between", value1, value2, "provincialTime");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNull() {
            addCriterion("op_type is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("op_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(Integer value) {
            addCriterion("op_type =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(Integer value) {
            addCriterion("op_type <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(Integer value) {
            addCriterion("op_type >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_type >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(Integer value) {
            addCriterion("op_type <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("op_type <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<Integer> values) {
            addCriterion("op_type in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<Integer> values) {
            addCriterion("op_type not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(Integer value1, Integer value2) {
            addCriterion("op_type between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("op_type not between", value1, value2, "opType");
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