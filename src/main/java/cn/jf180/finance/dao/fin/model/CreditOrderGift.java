package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class CreditOrderGift {
    private Long id;

    private Integer giftConfigId;

    private String orderId;

    private String giftName;

    private Integer giftPrice;

    private Integer returnCycle;

    private Date modifyTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGiftConfigId() {
        return giftConfigId;
    }

    public void setGiftConfigId(Integer giftConfigId) {
        this.giftConfigId = giftConfigId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Integer giftPrice) {
        this.giftPrice = giftPrice;
    }

    public Integer getReturnCycle() {
        return returnCycle;
    }

    public void setReturnCycle(Integer returnCycle) {
        this.returnCycle = returnCycle;
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