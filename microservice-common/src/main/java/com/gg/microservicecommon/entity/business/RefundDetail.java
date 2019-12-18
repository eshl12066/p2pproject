package com.gg.microservicecommon.entity.business;

import java.util.Date;
import java.io.Serializable;

/**
 * (RefundDetail)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class RefundDetail implements Serializable {
    private static final long serialVersionUID = 656879000960213246L;
    
    private Integer id;
    
    private Date deadLine;
    
    private Date payDate;
    
    private Double totalAmount;
    
    private Double principal;
    
    private Double interest;
    
    private Integer monthIndex;
    
    private Integer state;
    
    private String bidRequestTitle;
    
    private Integer membersId;
    
    private Integer bidRequestId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBidRequestTitle() {
        return bidRequestTitle;
    }

    public void setBidRequestTitle(String bidRequestTitle) {
        this.bidRequestTitle = bidRequestTitle;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Integer getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Integer bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

}