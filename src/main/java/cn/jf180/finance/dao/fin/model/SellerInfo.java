package cn.jf180.finance.dao.fin.model;

import java.util.Date;

public class SellerInfo {
    private Long id;

    private String sellerName;

    private String sellerBankName;

    private String sellerBankCard;

    private String tmallSellerNick;

    private Date modifyTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerBankName() {
        return sellerBankName;
    }

    public void setSellerBankName(String sellerBankName) {
        this.sellerBankName = sellerBankName;
    }

    public String getSellerBankCard() {
        return sellerBankCard;
    }

    public void setSellerBankCard(String sellerBankCard) {
        this.sellerBankCard = sellerBankCard;
    }

    public String getTmallSellerNick() {
        return tmallSellerNick;
    }

    public void setTmallSellerNick(String tmallSellerNick) {
        this.tmallSellerNick = tmallSellerNick;
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