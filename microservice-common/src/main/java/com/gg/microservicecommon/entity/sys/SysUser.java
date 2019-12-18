package com.gg.microservicecommon.entity.sys;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 439883944206372433L;
    
    private Integer userid;
    
    private String username;
    
    private String password;
    
    private String salt;
    
    private Date createdate;
    
    private Integer userstate;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createdate=" + createdate +
                ", userstate=" + userstate +
                '}';
    }
}