package com.gg.microservicecommon.entity.setting;

import java.io.Serializable;

/**
 * (SetDictitem)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SetDictitem implements Serializable {
    private static final long serialVersionUID = -87440270388095583L;
    
    private Integer id;
    
    private Integer parentid;
    
    private String title;
    
    private String value;
    
    private Integer sequence;
    
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}