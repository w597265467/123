package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class BjcyGiftCharge {
    private String chargeSn;

    private String extChargeSn;

    private String giftRecordId;

    private Integer chargeStatus;

    private String mobile;

    private String chargePrice;

    private Date createTime;

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

    public String getGiftRecordId() {
        return giftRecordId;
    }

    public void setGiftRecordId(String giftRecordId) {
        this.giftRecordId = giftRecordId;
    }

    public Integer getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(String chargePrice) {
        this.chargePrice = chargePrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}