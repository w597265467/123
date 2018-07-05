package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class CreditOrderGiftHistory {
    private Long id;

    private String creditOrderGiftId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditOrderGiftId() {
        return creditOrderGiftId;
    }

    public void setCreditOrderGiftId(String creditOrderGiftId) {
        this.creditOrderGiftId = creditOrderGiftId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}