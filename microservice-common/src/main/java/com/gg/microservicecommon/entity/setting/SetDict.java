package com.gg.microservicecommon.entity.setting;

import java.io.Serializable;

/**
 * (SetDict)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SetDict implements Serializable {
    private static final long serialVersionUID = 545025185799485480L;
    
    private Integer id;
    
    private String sn;
    
    private String title;
    
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

}