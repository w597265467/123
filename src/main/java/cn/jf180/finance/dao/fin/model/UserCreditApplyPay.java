package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class UserCreditApplyPay {
    private Long id;

    private String phone;

    private String orderId;

    private String finCreditId;

    private String finApplyPayId;

    private String finContractNo;

    private String finLoanNo;

    private Integer finApplyPayStatus;

    private Date finApplyPayTime;

    private Date modifyTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFinCreditId() {
        return finCreditId;
    }

    public void setFinCreditId(String finCreditId) {
        this.finCreditId = finCreditId;
    }

    public String getFinApplyPayId() {
        return finApplyPayId;
    }

    public void setFinApplyPayId(String finApplyPayId) {
        this.finApplyPayId = finApplyPayId;
    }

    public String getFinContractNo() {
        return finContractNo;
    }

    public void setFinContractNo(String finContractNo) {
        this.finContractNo = finContractNo;
    }

    public String getFinLoanNo() {
        return finLoanNo;
    }

    public void setFinLoanNo(String finLoanNo) {
        this.finLoanNo = finLoanNo;
    }

    public Integer getFinApplyPayStatus() {
        return finApplyPayStatus;
    }

    public void setFinApplyPayStatus(Integer finApplyPayStatus) {
        this.finApplyPayStatus = finApplyPayStatus;
    }

    public Date getFinApplyPayTime() {
        return finApplyPayTime;
    }

    public void setFinApplyPayTime(Date finApplyPayTime) {
        this.finApplyPayTime = finApplyPayTime;
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