package test.generator.model;

import java.util.Date;

public class CmEmpowerRecord {
    private Long id;

    private String phone;

    private String empowerNo;

    private String reqId;

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

    public String getEmpowerNo() {
        return empowerNo;
    }

    public void setEmpowerNo(String empowerNo) {
        this.empowerNo = empowerNo;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}