package com.gg.microservicecommon.entity.setting;

import java.io.Serializable;

/**
 * (SetSetting)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SetSetting implements Serializable {
    private static final long serialVersionUID = 278693085559789089L;
    
    private Integer id;
    
    private String k;
    
    private Double value;
    
    private String ktitle;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getKtitle() {
        return ktitle;
    }

    public void setKtitle(String ktitle) {
        this.ktitle = ktitle;
    }

}