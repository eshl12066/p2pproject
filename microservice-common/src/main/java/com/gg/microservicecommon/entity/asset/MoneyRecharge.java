package com.gg.microservicecommon.entity.asset;

import java.util.Date;
import java.io.Serializable;

/**
 * (MoneyRecharge)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class MoneyRecharge implements Serializable {
    private static final long serialVersionUID = -32170888894450465L;

    private Integer id;

    private String tradeCode;

    private Date tradeTime;

    private Double amount;

    private Integer membersId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

}