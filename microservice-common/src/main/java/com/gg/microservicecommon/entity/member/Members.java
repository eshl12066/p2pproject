package com.gg.microservicecommon.entity.member;

import java.io.Serializable;

/**
 * (Members)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class Members implements Serializable {
    private static final long serialVersionUID = 201165544109319056L;
    
    private Integer id;
    
    private String name;
    
    private String password;
    
    private Integer certificationScore;
    
    private Integer isIdentityAuthentication;
    
    private Integer membersState;
    
    private Integer bidRequestId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCertificationScore() {
        return certificationScore;
    }

    public void setCertificationScore(Integer certificationScore) {
        this.certificationScore = certificationScore;
    }

    public Integer getIsIdentityAuthentication() {
        return isIdentityAuthentication;
    }

    public void setIsIdentityAuthentication(Integer isIdentityAuthentication) {
        this.isIdentityAuthentication = isIdentityAuthentication;
    }

    public Integer getMembersState() {
        return membersState;
    }

    public void setMembersState(Integer membersState) {
        this.membersState = membersState;
    }

    public Integer getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Integer bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

}