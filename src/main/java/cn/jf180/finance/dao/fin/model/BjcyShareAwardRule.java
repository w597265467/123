package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class BjcyShareAwardRule {
    private Long id;

    private String normalAward;

    private String subAwardMoney;

    private String realizeCountAward;

    private String realizeCount;

    private String cType;

    private Integer status;

    private Integer activityNum;

    private Date modifyTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNormalAward() {
        return normalAward;
    }

    public void setNormalAward(String normalAward) {
        this.normalAward = normalAward;
    }

    public String getSubAwardMoney() {
        return subAwardMoney;
    }

    public void setSubAwardMoney(String subAwardMoney) {
        this.subAwardMoney = subAwardMoney;
    }

    public String getRealizeCountAward() {
        return realizeCountAward;
    }

    public void setRealizeCountAward(String realizeCountAward) {
        this.realizeCountAward = realizeCountAward;
    }

    public String getRealizeCount() {
        return realizeCount;
    }

    public void setRealizeCount(String realizeCount) {
        this.realizeCount = realizeCount;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
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