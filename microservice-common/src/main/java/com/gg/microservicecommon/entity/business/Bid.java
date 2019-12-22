package com.gg.microservicecommon.entity.business;

import java.util.Date;
import java.io.Serializable;

/**
 * (Bid)实体类
 *
 * @author makejava
 * @since 2019-12-12 10:48:55
 */
public class Bid implements Serializable {
    private static final long serialVersionUID = -33909524347880508L;
    
    private Integer id;
    
    private Double actualRate;
    
    private Double availableAmount;
    
    private Integer bidRequestId;
    
    private Integer membersId;
    
    private Date bidTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getActualRate() {
        return actualRate;
    }

    public void setActualRate(Double actualRate) {
        this.actualRate = actualRate;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Integer getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Integer bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", actualRate=" + actualRate +
                ", availableAmount=" + availableAmount +
                ", bidRequestId=" + bidRequestId +
                ", membersId=" + membersId +
                ", bidTime=" + bidTime +
                '}';
    }
}