package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdcardNoIsNull() {
            addCriterion("idcard_no is null");
            return (Criteria) this;
        }

        public Criteria andIdcardNoIsNotNull() {
            addCriterion("idcard_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardNoEqualTo(String value) {
            addCriterion("idcard_no =", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotEqualTo(String value) {
            addCriterion("idcard_no <>", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoGreaterThan(String value) {
            addCriterion("idcard_no >", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_no >=", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoLessThan(String value) {
            addCriterion("idcard_no <", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoLessThanOrEqualTo(String value) {
            addCriterion("idcard_no <=", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoLike(String value) {
            addCriterion("idcard_no like", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotLike(String value) {
            addCriterion("idcard_no not like", value, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoIn(List<String> values) {
            addCriterion("idcard_no in", values, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotIn(List<String> values) {
            addCriterion("idcard_no not in", values, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoBetween(String value1, String value2) {
            addCriterion("idcard_no between", value1, value2, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardNoNotBetween(String value1, String value2) {
            addCriterion("idcard_no not between", value1, value2, "idcardNo");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateIsNull() {
            addCriterion("idcard_start_date is null");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateIsNotNull() {
            addCriterion("idcard_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateEqualTo(String value) {
            addCriterion("idcard_start_date =", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateNotEqualTo(String value) {
            addCriterion("idcard_start_date <>", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateGreaterThan(String value) {
            addCriterion("idcard_start_date >", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_start_date >=", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateLessThan(String value) {
            addCriterion("idcard_start_date <", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateLessThanOrEqualTo(String value) {
            addCriterion("idcard_start_date <=", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateLike(String value) {
            addCriterion("idcard_start_date like", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateNotLike(String value) {
            addCriterion("idcard_start_date not like", value, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateIn(List<String> values) {
            addCriterion("idcard_start_date in", values, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateNotIn(List<String> values) {
            addCriterion("idcard_start_date not in", values, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateBetween(String value1, String value2) {
            addCriterion("idcard_start_date between", value1, value2, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardStartDateNotBetween(String value1, String value2) {
            addCriterion("idcard_start_date not between", value1, value2, "idcardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateIsNull() {
            addCriterion("idcard_end_date is null");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateIsNotNull() {
            addCriterion("idcard_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateEqualTo(String value) {
            addCriterion("idcard_end_date =", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateNotEqualTo(String value) {
            addCriterion("idcard_end_date <>", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateGreaterThan(String value) {
            addCriterion("idcard_end_date >", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_end_date >=", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateLessThan(String value) {
            addCriterion("idcard_end_date <", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateLessThanOrEqualTo(String value) {
            addCriterion("idcard_end_date <=", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateLike(String value) {
            addCriterion("idcard_end_date like", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateNotLike(String value) {
            addCriterion("idcard_end_date not like", value, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateIn(List<String> values) {
            addCriterion("idcard_end_date in", values, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateNotIn(List<String> values) {
            addCriterion("idcard_end_date not in", values, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateBetween(String value1, String value2) {
            addCriterion("idcard_end_date between", value1, value2, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardEndDateNotBetween(String value1, String value2) {
            addCriterion("idcard_end_date not between", value1, value2, "idcardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueIsNull() {
            addCriterion("idcard_issue is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueIsNotNull() {
            addCriterion("idcard_issue is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueEqualTo(String value) {
            addCriterion("idcard_issue =", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueNotEqualTo(String value) {
            addCriterion("idcard_issue <>", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueGreaterThan(String value) {
            addCriterion("idcard_issue >", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_issue >=", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueLessThan(String value) {
            addCriterion("idcard_issue <", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueLessThanOrEqualTo(String value) {
            addCriterion("idcard_issue <=", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueLike(String value) {
            addCriterion("idcard_issue like", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueNotLike(String value) {
            addCriterion("idcard_issue not like", value, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueIn(List<String> values) {
            addCriterion("idcard_issue in", values, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueNotIn(List<String> values) {
            addCriterion("idcard_issue not in", values, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueBetween(String value1, String value2) {
            addCriterion("idcard_issue between", value1, value2, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardIssueNotBetween(String value1, String value2) {
            addCriterion("idcard_issue not between", value1, value2, "idcardIssue");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressIsNull() {
            addCriterion("idcard_address is null");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressIsNotNull() {
            addCriterion("idcard_address is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressEqualTo(String value) {
            addCriterion("idcard_address =", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotEqualTo(String value) {
            addCriterion("idcard_address <>", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressGreaterThan(String value) {
            addCriterion("idcard_address >", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_address >=", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressLessThan(String value) {
            addCriterion("idcard_address <", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressLessThanOrEqualTo(String value) {
            addCriterion("idcard_address <=", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressLike(String value) {
            addCriterion("idcard_address like", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotLike(String value) {
            addCriterion("idcard_address not like", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressIn(List<String> values) {
            addCriterion("idcard_address in", values, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotIn(List<String> values) {
            addCriterion("idcard_address not in", values, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressBetween(String value1, String value2) {
            addCriterion("idcard_address between", value1, value2, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotBetween(String value1, String value2) {
            addCriterion("idcard_address not between", value1, value2, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgIsNull() {
            addCriterion("face_idcard_img is null");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgIsNotNull() {
            addCriterion("face_idcard_img is not null");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgEqualTo(String value) {
            addCriterion("face_idcard_img =", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgNotEqualTo(String value) {
            addCriterion("face_idcard_img <>", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgGreaterThan(String value) {
            addCriterion("face_idcard_img >", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgGreaterThanOrEqualTo(String value) {
            addCriterion("face_idcard_img >=", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgLessThan(String value) {
            addCriterion("face_idcard_img <", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgLessThanOrEqualTo(String value) {
            addCriterion("face_idcard_img <=", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgLike(String value) {
            addCriterion("face_idcard_img like", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgNotLike(String value) {
            addCriterion("face_idcard_img not like", value, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgIn(List<String> values) {
            addCriterion("face_idcard_img in", values, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgNotIn(List<String> values) {
            addCriterion("face_idcard_img not in", values, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgBetween(String value1, String value2) {
            addCriterion("face_idcard_img between", value1, value2, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceIdcardImgNotBetween(String value1, String value2) {
            addCriterion("face_idcard_img not between", value1, value2, "faceIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgIsNull() {
            addCriterion("back_idcard_img is null");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgIsNotNull() {
            addCriterion("back_idcard_img is not null");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgEqualTo(String value) {
            addCriterion("back_idcard_img =", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgNotEqualTo(String value) {
            addCriterion("back_idcard_img <>", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgGreaterThan(String value) {
            addCriterion("back_idcard_img >", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgGreaterThanOrEqualTo(String value) {
            addCriterion("back_idcard_img >=", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgLessThan(String value) {
            addCriterion("back_idcard_img <", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgLessThanOrEqualTo(String value) {
            addCriterion("back_idcard_img <=", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgLike(String value) {
            addCriterion("back_idcard_img like", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgNotLike(String value) {
            addCriterion("back_idcard_img not like", value, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgIn(List<String> values) {
            addCriterion("back_idcard_img in", values, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgNotIn(List<String> values) {
            addCriterion("back_idcard_img not in", values, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgBetween(String value1, String value2) {
            addCriterion("back_idcard_img between", value1, value2, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andBackIdcardImgNotBetween(String value1, String value2) {
            addCriterion("back_idcard_img not between", value1, value2, "backIdcardImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgIsNull() {
            addCriterion("face_recognition_img is null");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgIsNotNull() {
            addCriterion("face_recognition_img is not null");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgEqualTo(String value) {
            addCriterion("face_recognition_img =", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgNotEqualTo(String value) {
            addCriterion("face_recognition_img <>", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgGreaterThan(String value) {
            addCriterion("face_recognition_img >", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgGreaterThanOrEqualTo(String value) {
            addCriterion("face_recognition_img >=", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgLessThan(String value) {
            addCriterion("face_recognition_img <", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgLessThanOrEqualTo(String value) {
            addCriterion("face_recognition_img <=", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgLike(String value) {
            addCriterion("face_recognition_img like", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgNotLike(String value) {
            addCriterion("face_recognition_img not like", value, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgIn(List<String> values) {
            addCriterion("face_recognition_img in", values, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgNotIn(List<String> values) {
            addCriterion("face_recognition_img not in", values, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgBetween(String value1, String value2) {
            addCriterion("face_recognition_img between", value1, value2, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionImgNotBetween(String value1, String value2) {
            addCriterion("face_recognition_img not between", value1, value2, "faceRecognitionImg");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoIsNull() {
            addCriterion("face_recognition_sco is null");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoIsNotNull() {
            addCriterion("face_recognition_sco is not null");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoEqualTo(String value) {
            addCriterion("face_recognition_sco =", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoNotEqualTo(String value) {
            addCriterion("face_recognition_sco <>", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoGreaterThan(String value) {
            addCriterion("face_recognition_sco >", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoGreaterThanOrEqualTo(String value) {
            addCriterion("face_recognition_sco >=", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoLessThan(String value) {
            addCriterion("face_recognition_sco <", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoLessThanOrEqualTo(String value) {
            addCriterion("face_recognition_sco <=", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoLike(String value) {
            addCriterion("face_recognition_sco like", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoNotLike(String value) {
            addCriterion("face_recognition_sco not like", value, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoIn(List<String> values) {
            addCriterion("face_recognition_sco in", values, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoNotIn(List<String> values) {
            addCriterion("face_recognition_sco not in", values, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoBetween(String value1, String value2) {
            addCriterion("face_recognition_sco between", value1, value2, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionScoNotBetween(String value1, String value2) {
            addCriterion("face_recognition_sco not between", value1, value2, "faceRecognitionSco");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationIsNull() {
            addCriterion("face_recognition_organization is null");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationIsNotNull() {
            addCriterion("face_recognition_organization is not null");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationEqualTo(String value) {
            addCriterion("face_recognition_organization =", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationNotEqualTo(String value) {
            addCriterion("face_recognition_organization <>", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationGreaterThan(String value) {
            addCriterion("face_recognition_organization >", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("face_recognition_organization >=", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationLessThan(String value) {
            addCriterion("face_recognition_organization <", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationLessThanOrEqualTo(String value) {
            addCriterion("face_recognition_organization <=", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationLike(String value) {
            addCriterion("face_recognition_organization like", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationNotLike(String value) {
            addCriterion("face_recognition_organization not like", value, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationIn(List<String> values) {
            addCriterion("face_recognition_organization in", values, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationNotIn(List<String> values) {
            addCriterion("face_recognition_organization not in", values, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationBetween(String value1, String value2) {
            addCriterion("face_recognition_organization between", value1, value2, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andFaceRecognitionOrganizationNotBetween(String value1, String value2) {
            addCriterion("face_recognition_organization not between", value1, value2, "faceRecognitionOrganization");
            return (Criteria) this;
        }

        public Criteria andApplyLngIsNull() {
            addCriterion("apply_lng is null");
            return (Criteria) this;
        }

        public Criteria andApplyLngIsNotNull() {
            addCriterion("apply_lng is not null");
            return (Criteria) this;
        }

        public Criteria andApplyLngEqualTo(String value) {
            addCriterion("apply_lng =", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngNotEqualTo(String value) {
            addCriterion("apply_lng <>", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngGreaterThan(String value) {
            addCriterion("apply_lng >", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngGreaterThanOrEqualTo(String value) {
            addCriterion("apply_lng >=", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngLessThan(String value) {
            addCriterion("apply_lng <", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngLessThanOrEqualTo(String value) {
            addCriterion("apply_lng <=", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngLike(String value) {
            addCriterion("apply_lng like", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngNotLike(String value) {
            addCriterion("apply_lng not like", value, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngIn(List<String> values) {
            addCriterion("apply_lng in", values, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngNotIn(List<String> values) {
            addCriterion("apply_lng not in", values, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngBetween(String value1, String value2) {
            addCriterion("apply_lng between", value1, value2, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLngNotBetween(String value1, String value2) {
            addCriterion("apply_lng not between", value1, value2, "applyLng");
            return (Criteria) this;
        }

        public Criteria andApplyLatIsNull() {
            addCriterion("apply_lat is null");
            return (Criteria) this;
        }

        public Criteria andApplyLatIsNotNull() {
            addCriterion("apply_lat is not null");
            return (Criteria) this;
        }

        public Criteria andApplyLatEqualTo(String value) {
            addCriterion("apply_lat =", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatNotEqualTo(String value) {
            addCriterion("apply_lat <>", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatGreaterThan(String value) {
            addCriterion("apply_lat >", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatGreaterThanOrEqualTo(String value) {
            addCriterion("apply_lat >=", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatLessThan(String value) {
            addCriterion("apply_lat <", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatLessThanOrEqualTo(String value) {
            addCriterion("apply_lat <=", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatLike(String value) {
            addCriterion("apply_lat like", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatNotLike(String value) {
            addCriterion("apply_lat not like", value, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatIn(List<String> values) {
            addCriterion("apply_lat in", values, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatNotIn(List<String> values) {
            addCriterion("apply_lat not in", values, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatBetween(String value1, String value2) {
            addCriterion("apply_lat between", value1, value2, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyLatNotBetween(String value1, String value2) {
            addCriterion("apply_lat not between", value1, value2, "applyLat");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIsNull() {
            addCriterion("apply_province is null");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIsNotNull() {
            addCriterion("apply_province is not null");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceEqualTo(String value) {
            addCriterion("apply_province =", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotEqualTo(String value) {
            addCriterion("apply_province <>", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceGreaterThan(String value) {
            addCriterion("apply_province >", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("apply_province >=", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLessThan(String value) {
            addCriterion("apply_province <", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLessThanOrEqualTo(String value) {
            addCriterion("apply_province <=", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLike(String value) {
            addCriterion("apply_province like", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotLike(String value) {
            addCriterion("apply_province not like", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIn(List<String> values) {
            addCriterion("apply_province in", values, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotIn(List<String> values) {
            addCriterion("apply_province not in", values, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceBetween(String value1, String value2) {
            addCriterion("apply_province between", value1, value2, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotBetween(String value1, String value2) {
            addCriterion("apply_province not between", value1, value2, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyCityIsNull() {
            addCriterion("apply_city is null");
            return (Criteria) this;
        }

        public Criteria andApplyCityIsNotNull() {
            addCriterion("apply_city is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCityEqualTo(String value) {
            addCriterion("apply_city =", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotEqualTo(String value) {
            addCriterion("apply_city <>", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityGreaterThan(String value) {
            addCriterion("apply_city >", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityGreaterThanOrEqualTo(String value) {
            addCriterion("apply_city >=", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLessThan(String value) {
            addCriterion("apply_city <", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLessThanOrEqualTo(String value) {
            addCriterion("apply_city <=", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLike(String value) {
            addCriterion("apply_city like", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotLike(String value) {
            addCriterion("apply_city not like", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityIn(List<String> values) {
            addCriterion("apply_city in", values, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotIn(List<String> values) {
            addCriterion("apply_city not in", values, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityBetween(String value1, String value2) {
            addCriterion("apply_city between", value1, value2, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotBetween(String value1, String value2) {
            addCriterion("apply_city not between", value1, value2, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyAreaIsNull() {
            addCriterion("apply_area is null");
            return (Criteria) this;
        }

        public Criteria andApplyAreaIsNotNull() {
            addCriterion("apply_area is not null");
            return (Criteria) this;
        }

        public Criteria andApplyAreaEqualTo(String value) {
            addCriterion("apply_area =", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaNotEqualTo(String value) {
            addCriterion("apply_area <>", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaGreaterThan(String value) {
            addCriterion("apply_area >", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaGreaterThanOrEqualTo(String value) {
            addCriterion("apply_area >=", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaLessThan(String value) {
            addCriterion("apply_area <", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaLessThanOrEqualTo(String value) {
            addCriterion("apply_area <=", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaLike(String value) {
            addCriterion("apply_area like", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaNotLike(String value) {
            addCriterion("apply_area not like", value, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaIn(List<String> values) {
            addCriterion("apply_area in", values, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaNotIn(List<String> values) {
            addCriterion("apply_area not in", values, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaBetween(String value1, String value2) {
            addCriterion("apply_area between", value1, value2, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyAreaNotBetween(String value1, String value2) {
            addCriterion("apply_area not between", value1, value2, "applyArea");
            return (Criteria) this;
        }

        public Criteria andApplyIpIsNull() {
            addCriterion("apply_ip is null");
            return (Criteria) this;
        }

        public Criteria andApplyIpIsNotNull() {
            addCriterion("apply_ip is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIpEqualTo(String value) {
            addCriterion("apply_ip =", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotEqualTo(String value) {
            addCriterion("apply_ip <>", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpGreaterThan(String value) {
            addCriterion("apply_ip >", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpGreaterThanOrEqualTo(String value) {
            addCriterion("apply_ip >=", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpLessThan(String value) {
            addCriterion("apply_ip <", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpLessThanOrEqualTo(String value) {
            addCriterion("apply_ip <=", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpLike(String value) {
            addCriterion("apply_ip like", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotLike(String value) {
            addCriterion("apply_ip not like", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpIn(List<String> values) {
            addCriterion("apply_ip in", values, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotIn(List<String> values) {
            addCriterion("apply_ip not in", values, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpBetween(String value1, String value2) {
            addCriterion("apply_ip between", value1, value2, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotBetween(String value1, String value2) {
            addCriterion("apply_ip not between", value1, value2, "applyIp");
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

        public Criteria andOpVerifyStatusIsNull() {
            addCriterion("op_verify_status is null");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusIsNotNull() {
            addCriterion("op_verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusEqualTo(Integer value) {
            addCriterion("op_verify_status =", value, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusNotEqualTo(Integer value) {
            addCriterion("op_verify_status <>", value, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusGreaterThan(Integer value) {
            addCriterion("op_verify_status >", value, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_verify_status >=", value, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusLessThan(Integer value) {
            addCriterion("op_verify_status <", value, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("op_verify_status <=", value, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusIn(List<Integer> values) {
            addCriterion("op_verify_status in", values, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusNotIn(List<Integer> values) {
            addCriterion("op_verify_status not in", values, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("op_verify_status between", value1, value2, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpVerifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("op_verify_status not between", value1, value2, "opVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andOpSumScoIsNull() {
            addCriterion("op_sum_sco is null");
            return (Criteria) this;
        }

        public Criteria andOpSumScoIsNotNull() {
            addCriterion("op_sum_sco is not null");
            return (Criteria) this;
        }

        public Criteria andOpSumScoEqualTo(Integer value) {
            addCriterion("op_sum_sco =", value, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoNotEqualTo(Integer value) {
            addCriterion("op_sum_sco <>", value, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoGreaterThan(Integer value) {
            addCriterion("op_sum_sco >", value, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_sum_sco >=", value, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoLessThan(Integer value) {
            addCriterion("op_sum_sco <", value, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoLessThanOrEqualTo(Integer value) {
            addCriterion("op_sum_sco <=", value, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoIn(List<Integer> values) {
            addCriterion("op_sum_sco in", values, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoNotIn(List<Integer> values) {
            addCriterion("op_sum_sco not in", values, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoBetween(Integer value1, Integer value2) {
            addCriterion("op_sum_sco between", value1, value2, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpSumScoNotBetween(Integer value1, Integer value2) {
            addCriterion("op_sum_sco not between", value1, value2, "opSumSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoIsNull() {
            addCriterion("op_credit_notes_sco is null");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoIsNotNull() {
            addCriterion("op_credit_notes_sco is not null");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoEqualTo(Integer value) {
            addCriterion("op_credit_notes_sco =", value, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoNotEqualTo(Integer value) {
            addCriterion("op_credit_notes_sco <>", value, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoGreaterThan(Integer value) {
            addCriterion("op_credit_notes_sco >", value, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_credit_notes_sco >=", value, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoLessThan(Integer value) {
            addCriterion("op_credit_notes_sco <", value, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoLessThanOrEqualTo(Integer value) {
            addCriterion("op_credit_notes_sco <=", value, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoIn(List<Integer> values) {
            addCriterion("op_credit_notes_sco in", values, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoNotIn(List<Integer> values) {
            addCriterion("op_credit_notes_sco not in", values, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoBetween(Integer value1, Integer value2) {
            addCriterion("op_credit_notes_sco between", value1, value2, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpCreditNotesScoNotBetween(Integer value1, Integer value2) {
            addCriterion("op_credit_notes_sco not between", value1, value2, "opCreditNotesSco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoIsNull() {
            addCriterion("op_identity_sco is null");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoIsNotNull() {
            addCriterion("op_identity_sco is not null");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoEqualTo(Integer value) {
            addCriterion("op_identity_sco =", value, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoNotEqualTo(Integer value) {
            addCriterion("op_identity_sco <>", value, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoGreaterThan(Integer value) {
            addCriterion("op_identity_sco >", value, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_identity_sco >=", value, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoLessThan(Integer value) {
            addCriterion("op_identity_sco <", value, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoLessThanOrEqualTo(Integer value) {
            addCriterion("op_identity_sco <=", value, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoIn(List<Integer> values) {
            addCriterion("op_identity_sco in", values, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoNotIn(List<Integer> values) {
            addCriterion("op_identity_sco not in", values, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoBetween(Integer value1, Integer value2) {
            addCriterion("op_identity_sco between", value1, value2, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpIdentityScoNotBetween(Integer value1, Integer value2) {
            addCriterion("op_identity_sco not between", value1, value2, "opIdentitySco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoIsNull() {
            addCriterion("op_consume_sco is null");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoIsNotNull() {
            addCriterion("op_consume_sco is not null");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoEqualTo(Integer value) {
            addCriterion("op_consume_sco =", value, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoNotEqualTo(Integer value) {
            addCriterion("op_consume_sco <>", value, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoGreaterThan(Integer value) {
            addCriterion("op_consume_sco >", value, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_consume_sco >=", value, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoLessThan(Integer value) {
            addCriterion("op_consume_sco <", value, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoLessThanOrEqualTo(Integer value) {
            addCriterion("op_consume_sco <=", value, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoIn(List<Integer> values) {
            addCriterion("op_consume_sco in", values, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoNotIn(List<Integer> values) {
            addCriterion("op_consume_sco not in", values, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoBetween(Integer value1, Integer value2) {
            addCriterion("op_consume_sco between", value1, value2, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpConsumeScoNotBetween(Integer value1, Integer value2) {
            addCriterion("op_consume_sco not between", value1, value2, "opConsumeSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoIsNull() {
            addCriterion("op_action_pre_sco is null");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoIsNotNull() {
            addCriterion("op_action_pre_sco is not null");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoEqualTo(Integer value) {
            addCriterion("op_action_pre_sco =", value, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoNotEqualTo(Integer value) {
            addCriterion("op_action_pre_sco <>", value, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoGreaterThan(Integer value) {
            addCriterion("op_action_pre_sco >", value, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_action_pre_sco >=", value, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoLessThan(Integer value) {
            addCriterion("op_action_pre_sco <", value, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoLessThanOrEqualTo(Integer value) {
            addCriterion("op_action_pre_sco <=", value, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoIn(List<Integer> values) {
            addCriterion("op_action_pre_sco in", values, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoNotIn(List<Integer> values) {
            addCriterion("op_action_pre_sco not in", values, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoBetween(Integer value1, Integer value2) {
            addCriterion("op_action_pre_sco between", value1, value2, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andOpActionPreScoNotBetween(Integer value1, Integer value2) {
            addCriterion("op_action_pre_sco not between", value1, value2, "opActionPreSco");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameIsNull() {
            addCriterion("tmall_user_name is null");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameIsNotNull() {
            addCriterion("tmall_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameEqualTo(String value) {
            addCriterion("tmall_user_name =", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameNotEqualTo(String value) {
            addCriterion("tmall_user_name <>", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameGreaterThan(String value) {
            addCriterion("tmall_user_name >", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_user_name >=", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameLessThan(String value) {
            addCriterion("tmall_user_name <", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameLessThanOrEqualTo(String value) {
            addCriterion("tmall_user_name <=", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameLike(String value) {
            addCriterion("tmall_user_name like", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameNotLike(String value) {
            addCriterion("tmall_user_name not like", value, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameIn(List<String> values) {
            addCriterion("tmall_user_name in", values, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameNotIn(List<String> values) {
            addCriterion("tmall_user_name not in", values, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameBetween(String value1, String value2) {
            addCriterion("tmall_user_name between", value1, value2, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallUserNameNotBetween(String value1, String value2) {
            addCriterion("tmall_user_name not between", value1, value2, "tmallUserName");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridIsNull() {
            addCriterion("tmall_mix_userid is null");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridIsNotNull() {
            addCriterion("tmall_mix_userid is not null");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridEqualTo(String value) {
            addCriterion("tmall_mix_userid =", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridNotEqualTo(String value) {
            addCriterion("tmall_mix_userid <>", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridGreaterThan(String value) {
            addCriterion("tmall_mix_userid >", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridGreaterThanOrEqualTo(String value) {
            addCriterion("tmall_mix_userid >=", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridLessThan(String value) {
            addCriterion("tmall_mix_userid <", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridLessThanOrEqualTo(String value) {
            addCriterion("tmall_mix_userid <=", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridLike(String value) {
            addCriterion("tmall_mix_userid like", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridNotLike(String value) {
            addCriterion("tmall_mix_userid not like", value, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridIn(List<String> values) {
            addCriterion("tmall_mix_userid in", values, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridNotIn(List<String> values) {
            addCriterion("tmall_mix_userid not in", values, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridBetween(String value1, String value2) {
            addCriterion("tmall_mix_userid between", value1, value2, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallMixUseridNotBetween(String value1, String value2) {
            addCriterion("tmall_mix_userid not between", value1, value2, "tmallMixUserid");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusIsNull() {
            addCriterion("tmall_verify_status is null");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusIsNotNull() {
            addCriterion("tmall_verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusEqualTo(Integer value) {
            addCriterion("tmall_verify_status =", value, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusNotEqualTo(Integer value) {
            addCriterion("tmall_verify_status <>", value, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusGreaterThan(Integer value) {
            addCriterion("tmall_verify_status >", value, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("tmall_verify_status >=", value, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusLessThan(Integer value) {
            addCriterion("tmall_verify_status <", value, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("tmall_verify_status <=", value, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusIn(List<Integer> values) {
            addCriterion("tmall_verify_status in", values, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusNotIn(List<Integer> values) {
            addCriterion("tmall_verify_status not in", values, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("tmall_verify_status between", value1, value2, "tmallVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andTmallVerifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("tmall_verify_status not between", value1, value2, "tmallVerifyStatus");
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

        public Criteria andFinNameIsNull() {
            addCriterion("fin_name is null");
            return (Criteria) this;
        }

        public Criteria andFinNameIsNotNull() {
            addCriterion("fin_name is not null");
            return (Criteria) this;
        }

        public Criteria andFinNameEqualTo(String value) {
            addCriterion("fin_name =", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotEqualTo(String value) {
            addCriterion("fin_name <>", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameGreaterThan(String value) {
            addCriterion("fin_name >", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameGreaterThanOrEqualTo(String value) {
            addCriterion("fin_name >=", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameLessThan(String value) {
            addCriterion("fin_name <", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameLessThanOrEqualTo(String value) {
            addCriterion("fin_name <=", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameLike(String value) {
            addCriterion("fin_name like", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotLike(String value) {
            addCriterion("fin_name not like", value, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameIn(List<String> values) {
            addCriterion("fin_name in", values, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotIn(List<String> values) {
            addCriterion("fin_name not in", values, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameBetween(String value1, String value2) {
            addCriterion("fin_name between", value1, value2, "finName");
            return (Criteria) this;
        }

        public Criteria andFinNameNotBetween(String value1, String value2) {
            addCriterion("fin_name not between", value1, value2, "finName");
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

        public Criteria andFinCreditStatusIsNull() {
            addCriterion("fin_credit_status is null");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusIsNotNull() {
            addCriterion("fin_credit_status is not null");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusEqualTo(Integer value) {
            addCriterion("fin_credit_status =", value, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusNotEqualTo(Integer value) {
            addCriterion("fin_credit_status <>", value, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusGreaterThan(Integer value) {
            addCriterion("fin_credit_status >", value, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fin_credit_status >=", value, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusLessThan(Integer value) {
            addCriterion("fin_credit_status <", value, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fin_credit_status <=", value, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusIn(List<Integer> values) {
            addCriterion("fin_credit_status in", values, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusNotIn(List<Integer> values) {
            addCriterion("fin_credit_status not in", values, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusBetween(Integer value1, Integer value2) {
            addCriterion("fin_credit_status between", value1, value2, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fin_credit_status not between", value1, value2, "finCreditStatus");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeIsNull() {
            addCriterion("fin_credit_time is null");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeIsNotNull() {
            addCriterion("fin_credit_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeEqualTo(Date value) {
            addCriterion("fin_credit_time =", value, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeNotEqualTo(Date value) {
            addCriterion("fin_credit_time <>", value, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeGreaterThan(Date value) {
            addCriterion("fin_credit_time >", value, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fin_credit_time >=", value, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeLessThan(Date value) {
            addCriterion("fin_credit_time <", value, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeLessThanOrEqualTo(Date value) {
            addCriterion("fin_credit_time <=", value, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeIn(List<Date> values) {
            addCriterion("fin_credit_time in", values, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeNotIn(List<Date> values) {
            addCriterion("fin_credit_time not in", values, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeBetween(Date value1, Date value2) {
            addCriterion("fin_credit_time between", value1, value2, "finCreditTime");
            return (Criteria) this;
        }

        public Criteria andFinCreditTimeNotBetween(Date value1, Date value2) {
            addCriterion("fin_credit_time not between", value1, value2, "finCreditTime");
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