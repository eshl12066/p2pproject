package com.gg.microservicecommon.entity.sys;

import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -35381303718877075L;
    
    private Integer perid;
    
    private String pername;
    
    private Integer pid;
    
    private String permission;
    
    private String pericon;


    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPericon() {
        return pericon;
    }

    public void setPericon(String pericon) {
        this.pericon = pericon;
    }

}