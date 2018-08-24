package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class BjcyOrderGiftRecord {
    private Long id;

    private String orderId;

    private Date chargeTime;

    private String chargeSn;

    private String extChargeSn;

    private String type;

    private String mobile;

    private String giftPrice;

    private String giftName;

    private Integer recordStatus;

    private Date modifyTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChargeSn() {
        return chargeSn;
    }

    public void setChargeSn(String chargeSn) {
        this.chargeSn = chargeSn;
    }

    public String getExtChargeSn() {
        return extChargeSn;
    }

    public void setExtChargeSn(String extChargeSn) {
        this.extChargeSn = extChargeSn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(String giftPrice) {
        this.giftPrice = giftPrice;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}