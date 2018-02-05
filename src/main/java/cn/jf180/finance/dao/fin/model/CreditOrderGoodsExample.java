package cn.jf180.finance.dao.fin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditOrderGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditOrderGoodsExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(String value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(String value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(String value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(String value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(String value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLike(String value) {
            addCriterion("sku_id like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotLike(String value) {
            addCriterion("sku_id not like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<String> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<String> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(String value1, String value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(String value1, String value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(String value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(String value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(String value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(String value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(String value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(String value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLike(String value) {
            addCriterion("goods_price like", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotLike(String value) {
            addCriterion("goods_price not like", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<String> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<String> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(String value1, String value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(String value1, String value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNull() {
            addCriterion("goods_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goods_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goods_num =", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goods_num <>", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goods_num >", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num >=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goods_num <", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num <=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            addCriterion("goods_num in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            addCriterion("goods_num not in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_num between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num not between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeIsNull() {
            addCriterion("network_type is null");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeIsNotNull() {
            addCriterion("network_type is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeEqualTo(String value) {
            addCriterion("network_type =", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotEqualTo(String value) {
            addCriterion("network_type <>", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeGreaterThan(String value) {
            addCriterion("network_type >", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("network_type >=", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeLessThan(String value) {
            addCriterion("network_type <", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeLessThanOrEqualTo(String value) {
            addCriterion("network_type <=", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeLike(String value) {
            addCriterion("network_type like", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotLike(String value) {
            addCriterion("network_type not like", value, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeIn(List<String> values) {
            addCriterion("network_type in", values, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotIn(List<String> values) {
            addCriterion("network_type not in", values, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeBetween(String value1, String value2) {
            addCriterion("network_type between", value1, value2, "networkType");
            return (Criteria) this;
        }

        public Criteria andNetworkTypeNotBetween(String value1, String value2) {
            addCriterion("network_type not between", value1, value2, "networkType");
            return (Criteria) this;
        }

        public Criteria andCpuInfoIsNull() {
            addCriterion("cpu_info is null");
            return (Criteria) this;
        }

        public Criteria andCpuInfoIsNotNull() {
            addCriterion("cpu_info is not null");
            return (Criteria) this;
        }

        public Criteria andCpuInfoEqualTo(String value) {
            addCriterion("cpu_info =", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotEqualTo(String value) {
            addCriterion("cpu_info <>", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoGreaterThan(String value) {
            addCriterion("cpu_info >", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoGreaterThanOrEqualTo(String value) {
            addCriterion("cpu_info >=", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoLessThan(String value) {
            addCriterion("cpu_info <", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoLessThanOrEqualTo(String value) {
            addCriterion("cpu_info <=", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoLike(String value) {
            addCriterion("cpu_info like", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotLike(String value) {
            addCriterion("cpu_info not like", value, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoIn(List<String> values) {
            addCriterion("cpu_info in", values, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotIn(List<String> values) {
            addCriterion("cpu_info not in", values, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoBetween(String value1, String value2) {
            addCriterion("cpu_info between", value1, value2, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andCpuInfoNotBetween(String value1, String value2) {
            addCriterion("cpu_info not between", value1, value2, "cpuInfo");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIsNull() {
            addCriterion("memory_size is null");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIsNotNull() {
            addCriterion("memory_size is not null");
            return (Criteria) this;
        }

        public Criteria andMemorySizeEqualTo(String value) {
            addCriterion("memory_size =", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotEqualTo(String value) {
            addCriterion("memory_size <>", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThan(String value) {
            addCriterion("memory_size >", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThanOrEqualTo(String value) {
            addCriterion("memory_size >=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThan(String value) {
            addCriterion("memory_size <", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThanOrEqualTo(String value) {
            addCriterion("memory_size <=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLike(String value) {
            addCriterion("memory_size like", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotLike(String value) {
            addCriterion("memory_size not like", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIn(List<String> values) {
            addCriterion("memory_size in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotIn(List<String> values) {
            addCriterion("memory_size not in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeBetween(String value1, String value2) {
            addCriterion("memory_size between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotBetween(String value1, String value2) {
            addCriterion("memory_size not between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMobileStyleIsNull() {
            addCriterion("mobile_style is null");
            return (Criteria) this;
        }

        public Criteria andMobileStyleIsNotNull() {
            addCriterion("mobile_style is not null");
            return (Criteria) this;
        }

        public Criteria andMobileStyleEqualTo(String value) {
            addCriterion("mobile_style =", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleNotEqualTo(String value) {
            addCriterion("mobile_style <>", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleGreaterThan(String value) {
            addCriterion("mobile_style >", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_style >=", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleLessThan(String value) {
            addCriterion("mobile_style <", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleLessThanOrEqualTo(String value) {
            addCriterion("mobile_style <=", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleLike(String value) {
            addCriterion("mobile_style like", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleNotLike(String value) {
            addCriterion("mobile_style not like", value, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleIn(List<String> values) {
            addCriterion("mobile_style in", values, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleNotIn(List<String> values) {
            addCriterion("mobile_style not in", values, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleBetween(String value1, String value2) {
            addCriterion("mobile_style between", value1, value2, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andMobileStyleNotBetween(String value1, String value2) {
            addCriterion("mobile_style not between", value1, value2, "mobileStyle");
            return (Criteria) this;
        }

        public Criteria andComboTypeIsNull() {
            addCriterion("combo_type is null");
            return (Criteria) this;
        }

        public Criteria andComboTypeIsNotNull() {
            addCriterion("combo_type is not null");
            return (Criteria) this;
        }

        public Criteria andComboTypeEqualTo(String value) {
            addCriterion("combo_type =", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeNotEqualTo(String value) {
            addCriterion("combo_type <>", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeGreaterThan(String value) {
            addCriterion("combo_type >", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeGreaterThanOrEqualTo(String value) {
            addCriterion("combo_type >=", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeLessThan(String value) {
            addCriterion("combo_type <", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeLessThanOrEqualTo(String value) {
            addCriterion("combo_type <=", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeLike(String value) {
            addCriterion("combo_type like", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeNotLike(String value) {
            addCriterion("combo_type not like", value, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeIn(List<String> values) {
            addCriterion("combo_type in", values, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeNotIn(List<String> values) {
            addCriterion("combo_type not in", values, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeBetween(String value1, String value2) {
            addCriterion("combo_type between", value1, value2, "comboType");
            return (Criteria) this;
        }

        public Criteria andComboTypeNotBetween(String value1, String value2) {
            addCriterion("combo_type not between", value1, value2, "comboType");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceIsNull() {
            addCriterion("after_sale_service is null");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceIsNotNull() {
            addCriterion("after_sale_service is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceEqualTo(String value) {
            addCriterion("after_sale_service =", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceNotEqualTo(String value) {
            addCriterion("after_sale_service <>", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceGreaterThan(String value) {
            addCriterion("after_sale_service >", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceGreaterThanOrEqualTo(String value) {
            addCriterion("after_sale_service >=", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceLessThan(String value) {
            addCriterion("after_sale_service <", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceLessThanOrEqualTo(String value) {
            addCriterion("after_sale_service <=", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceLike(String value) {
            addCriterion("after_sale_service like", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceNotLike(String value) {
            addCriterion("after_sale_service not like", value, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceIn(List<String> values) {
            addCriterion("after_sale_service in", values, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceNotIn(List<String> values) {
            addCriterion("after_sale_service not in", values, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceBetween(String value1, String value2) {
            addCriterion("after_sale_service between", value1, value2, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andAfterSaleServiceNotBetween(String value1, String value2) {
            addCriterion("after_sale_service not between", value1, value2, "afterSaleService");
            return (Criteria) this;
        }

        public Criteria andVersionTypeIsNull() {
            addCriterion("version_type is null");
            return (Criteria) this;
        }

        public Criteria andVersionTypeIsNotNull() {
            addCriterion("version_type is not null");
            return (Criteria) this;
        }

        public Criteria andVersionTypeEqualTo(String value) {
            addCriterion("version_type =", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotEqualTo(String value) {
            addCriterion("version_type <>", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeGreaterThan(String value) {
            addCriterion("version_type >", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("version_type >=", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeLessThan(String value) {
            addCriterion("version_type <", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeLessThanOrEqualTo(String value) {
            addCriterion("version_type <=", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeLike(String value) {
            addCriterion("version_type like", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotLike(String value) {
            addCriterion("version_type not like", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeIn(List<String> values) {
            addCriterion("version_type in", values, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotIn(List<String> values) {
            addCriterion("version_type not in", values, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeBetween(String value1, String value2) {
            addCriterion("version_type between", value1, value2, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotBetween(String value1, String value2) {
            addCriterion("version_type not between", value1, value2, "versionType");
            return (Criteria) this;
        }

        public Criteria andOpNameIsNull() {
            addCriterion("op_name is null");
            return (Criteria) this;
        }

        public Criteria andOpNameIsNotNull() {
            addCriterion("op_name is not null");
            return (Criteria) this;
        }

        public Criteria andOpNameEqualTo(String value) {
            addCriterion("op_name =", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotEqualTo(String value) {
            addCriterion("op_name <>", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameGreaterThan(String value) {
            addCriterion("op_name >", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameGreaterThanOrEqualTo(String value) {
            addCriterion("op_name >=", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLessThan(String value) {
            addCriterion("op_name <", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLessThanOrEqualTo(String value) {
            addCriterion("op_name <=", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLike(String value) {
            addCriterion("op_name like", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotLike(String value) {
            addCriterion("op_name not like", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameIn(List<String> values) {
            addCriterion("op_name in", values, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotIn(List<String> values) {
            addCriterion("op_name not in", values, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameBetween(String value1, String value2) {
            addCriterion("op_name between", value1, value2, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotBetween(String value1, String value2) {
            addCriterion("op_name not between", value1, value2, "opName");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNull() {
            addCriterion("buy_type is null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNotNull() {
            addCriterion("buy_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeEqualTo(String value) {
            addCriterion("buy_type =", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotEqualTo(String value) {
            addCriterion("buy_type <>", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThan(String value) {
            addCriterion("buy_type >", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_type >=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThan(String value) {
            addCriterion("buy_type <", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThanOrEqualTo(String value) {
            addCriterion("buy_type <=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLike(String value) {
            addCriterion("buy_type like", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotLike(String value) {
            addCriterion("buy_type not like", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIn(List<String> values) {
            addCriterion("buy_type in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotIn(List<String> values) {
            addCriterion("buy_type not in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeBetween(String value1, String value2) {
            addCriterion("buy_type between", value1, value2, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotBetween(String value1, String value2) {
            addCriterion("buy_type not between", value1, value2, "buyType");
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