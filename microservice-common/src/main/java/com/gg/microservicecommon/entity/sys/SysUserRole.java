package com.gg.microservicecommon.entity.sys;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 756872138146013446L;
    
    private Integer id;
    
    private Integer userid;
    
    private Integer roleid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}