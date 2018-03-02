package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class UserAccount {
    private Long id;

    private String phone;

    private Integer opCreditScoring;

    private String tmallUserName;

    private Integer finId;

    private String finName;

    private String finCreditId;

    private Integer finCreditLine;

    private Integer jftCreditLine;

    private Integer curCreditLine;

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

    public Integer getOpCreditScoring() {
        return opCreditScoring;
    }

    public void setOpCreditScoring(Integer opCreditScoring) {
        this.opCreditScoring = opCreditScoring;
    }

    public String getTmallUserName() {
        return tmallUserName;
    }

    public void setTmallUserName(String tmallUserName) {
        this.tmallUserName = tmallUserName;
    }

    public Integer getFinId() {
        return finId;
    }

    public void setFinId(Integer finId) {
        this.finId = finId;
    }

    public String getFinName() {
        return finName;
    }

    public void setFinName(String finName) {
        this.finName = finName;
    }

    public String getFinCreditId() {
        return finCreditId;
    }

    public void setFinCreditId(String finCreditId) {
        this.finCreditId = finCreditId;
    }

    public Integer getFinCreditLine() {
        return finCreditLine;
    }

    public void setFinCreditLine(Integer finCreditLine) {
        this.finCreditLine = finCreditLine;
    }

    public Integer getJftCreditLine() {
        return jftCreditLine;
    }

    public void setJftCreditLine(Integer jftCreditLine) {
        this.jftCreditLine = jftCreditLine;
    }

    public Integer getCurCreditLine() {
        return curCreditLine;
    }

    public void setCurCreditLine(Integer curCreditLine) {
        this.curCreditLine = curCreditLine;
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