package com.gg.microservicecommon.entity.asset;

import java.util.Date;
import java.io.Serializable;

/**
 * (MoneyWithdraw)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class MoneyWithdraw implements Serializable {
    private static final long serialVersionUID = 129699336505373525L;
    
    private Integer id;
    
    private Integer state;
    
    private String remark;
    
    private Date auditTime;
    
    private Date applyTime;
    
    private Integer auditorId;
    
    private Integer membersId;
    
    private Double amount;
    
    private Double fee;
    
    private String tradeCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

}