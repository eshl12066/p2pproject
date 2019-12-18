package com.gg.microservicecommon.entity.asset;

import java.io.Serializable;

/**
 * (Systemaccount)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class Systemaccount implements Serializable {
    private static final long serialVersionUID = -70739285693515257L;
    
    private Integer id;
    
    private Double usableAmount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(Double usableAmount) {
        this.usableAmount = usableAmount;
    }

}