package com.gg.microservicecommon.entity.asset;

import java.util.Date;
import java.io.Serializable;

/**
 * (SystemaccountDetail)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SystemaccountDetail implements Serializable {
    private static final long serialVersionUID = 938239800442669725L;
    
    private Integer id;
    
    private Double money;
    
    private Integer accountState;
    
    private String accountRemark;
    
    private Date accountTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public String getAccountRemark() {
        return accountRemark;
    }

    public void setAccountRemark(String accountRemark) {
        this.accountRemark = accountRemark;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

}