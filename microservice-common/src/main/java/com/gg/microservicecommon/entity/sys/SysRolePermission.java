package com.gg.microservicecommon.entity.sys;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 328845915015688196L;
    
    private Integer id;
    
    private Integer roleid;
    
    private Integer perid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

}