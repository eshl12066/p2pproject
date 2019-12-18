package com.gg.microservicecommon.entity.business;

import java.util.Date;
import java.io.Serializable;

/**
 * (ReturnDetail)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class ReturnDetail implements Serializable {
    private static final long serialVersionUID = -31573636054712716L;
    
    private Integer id;
    
    private Double bidAmount;
    
    private Integer bidId;
    
    private Double totalAmount;
    
    private Double principal;
    
    private Double interest;
    
    private Integer monthIndex;
    
    private Date deadLine;
    
    private Date payDate;
    
    private Integer returnType;
    
    private Integer refundDetailId;
    
    private Integer fromMembersId;
    
    private Integer toMembersId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getMonthIndex() {
        return monthIndex;
    }

    public void setMonthIndex(Integer monthIndex) {
        this.monthIndex = monthIndex;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public Integer getRefundDetailId() {
        return refundDetailId;
    }

    public void setRefundDetailId(Integer refundDetailId) {
        this.refundDetailId = refundDetailId;
    }

    public Integer getFromMembersId() {
        return fromMembersId;
    }

    public void setFromMembersId(Integer fromMembersId) {
        this.fromMembersId = fromMembersId;
    }

    public Integer getToMembersId() {
        return toMembersId;
    }

    public void setToMembersId(Integer toMembersId) {
        this.toMembersId = toMembersId;
    }

}