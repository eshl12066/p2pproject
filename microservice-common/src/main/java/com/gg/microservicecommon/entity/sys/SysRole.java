package com.gg.microservicecommon.entity.sys;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = -37273696089418114L;
    
    private Integer roleid;
    
    private String rolename;
    
    private String description;
    
    private Integer rolestate;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRolestate() {
        return rolestate;
    }

    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }

}