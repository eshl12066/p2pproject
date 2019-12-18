package com.gg.microservicecommon.entity.member;

import java.io.Serializable;

/**
 * (MembersAccount)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class MembersAccount implements Serializable {
    private static final long serialVersionUID = -70951536509672860L;
    
    private Integer id;
    
    private Integer membersId;
    
    private String tradePassword;
    
    private Double usableAmount;
    
    private Double unReceiveInterest;
    
    private Double unReceivePrincipal;
    
    private Double borrowLimit;
    
    private String tradeCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public Double getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(Double usableAmount) {
        this.usableAmount = usableAmount;
    }

    public Double getUnReceiveInterest() {
        return unReceiveInterest;
    }

    public void setUnReceiveInterest(Double unReceiveInterest) {
        this.unReceiveInterest = unReceiveInterest;
    }

    public Double getUnReceivePrincipal() {
        return unReceivePrincipal;
    }

    public void setUnReceivePrincipal(Double unReceivePrincipal) {
        this.unReceivePrincipal = unReceivePrincipal;
    }

    public Double getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(Double borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

}