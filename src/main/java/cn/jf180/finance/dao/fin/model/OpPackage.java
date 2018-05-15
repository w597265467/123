package cn.jf180.finance.dao.fin.model;

public class OpPackage {
    private String id;

    private Integer monthlyFee;

    private Integer returnFee;

    private String contractPeriod;

    private String packageName;

    private String packageDetail;

    private String domesticFlow;

    private Integer domesticTime;

    private String provincialFlow;

    private Integer provincialTime;

    private Integer opType;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(Integer monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Integer getReturnFee() {
        return returnFee;
    }

    public void setReturnFee(Integer returnFee) {
        this.returnFee = returnFee;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDetail() {
        return packageDetail;
    }

    public void setPackageDetail(String packageDetail) {
        this.packageDetail = packageDetail;
    }

    public String getDomesticFlow() {
        return domesticFlow;
    }

    public void setDomesticFlow(String domesticFlow) {
        this.domesticFlow = domesticFlow;
    }

    public Integer getDomesticTime() {
        return domesticTime;
    }

    public void setDomesticTime(Integer domesticTime) {
        this.domesticTime = domesticTime;
    }

    public String getProvincialFlow() {
        return provincialFlow;
    }

    public void setProvincialFlow(String provincialFlow) {
        this.provincialFlow = provincialFlow;
    }

    public Integer getProvincialTime() {
        return provincialTime;
    }

    public void setProvincialTime(Integer provincialTime) {
        this.provincialTime = provincialTime;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}