package com.gg.microservicecommon.entity.business;

import java.util.Date;
import java.io.Serializable;

/**
 * (BidRequest)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:00:49
 */
public class BidRequest implements Serializable {
    private static final long serialVersionUID = 257906360338996598L;
    
    private Integer id;
    
    private Integer returnType;
    
    private Integer bidRequestType;
    
    private Integer bidRequestState;
    
    private Double bidRequestAmount;
    
    private Double currentRate;
    
    private Integer monthesReturn;
    
    private Integer bidCount;
    
    private Double totalRewardAmount;
    
    private Double currentSum;
    
    private String title;
    
    private String description;
    
    private String note;
    
    private Date disableDate;
    
    private Integer membersId;
    
    private Integer disableDays;
    
    private Date publishTime;
    
    private String remark;
    
    private Date auditTime;
    
    private Date applyTime;
    
    private Integer auditorId;
    
    private Integer newColumn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public Integer getBidRequestType() {
        return bidRequestType;
    }

    public void setBidRequestType(Integer bidRequestType) {
        this.bidRequestType = bidRequestType;
    }

    public Integer getBidRequestState() {
        return bidRequestState;
    }

    public void setBidRequestState(Integer bidRequestState) {
        this.bidRequestState = bidRequestState;
    }

    public Double getBidRequestAmount() {
        return bidRequestAmount;
    }

    public void setBidRequestAmount(Double bidRequestAmount) {
        this.bidRequestAmount = bidRequestAmount;
    }

    public Double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Double currentRate) {
        this.currentRate = currentRate;
    }

    public Integer getMonthesReturn() {
        return monthesReturn;
    }

    public void setMonthesReturn(Integer monthesReturn) {
        this.monthesReturn = monthesReturn;
    }

    public Integer getBidCount() {
        return bidCount;
    }

    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }

    public Double getTotalRewardAmount() {
        return totalRewardAmount;
    }

    public void setTotalRewardAmount(Double totalRewardAmount) {
        this.totalRewardAmount = totalRewardAmount;
    }

    public Double getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(Double currentSum) {
        this.currentSum = currentSum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Integer getDisableDays() {
        return disableDays;
    }

    public void setDisableDays(Integer disableDays) {
        this.disableDays = disableDays;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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

    public Integer getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(Integer newColumn) {
        this.newColumn = newColumn;
    }

    @Override
    public String toString() {
        return "BidRequest{" +
                "id=" + id +
                ", returnType=" + returnType +
                ", bidRequestType=" + bidRequestType +
                ", bidRequestState=" + bidRequestState +
                ", bidRequestAmount=" + bidRequestAmount +
                ", currentRate=" + currentRate +
                ", monthesReturn=" + monthesReturn +
                ", bidCount=" + bidCount +
                ", totalRewardAmount=" + totalRewardAmount +
                ", currentSum=" + currentSum +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", disableDate=" + disableDate +
                ", membersId=" + membersId +
                ", disableDays=" + disableDays +
                ", publishTime=" + publishTime +
                ", remark='" + remark + '\'' +
                ", auditTime=" + auditTime +
                ", applyTime=" + applyTime +
                ", auditorId=" + auditorId +
                ", newColumn=" + newColumn +
                '}';
    }
}