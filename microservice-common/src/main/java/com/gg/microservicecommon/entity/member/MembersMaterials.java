package com.gg.microservicecommon.entity.member;

import java.util.Date;
import java.io.Serializable;

/**
 * (MembersMaterials)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class MembersMaterials implements Serializable {
    private static final long serialVersionUID = 274013086962162358L;
    
    private Integer id;
    
    private Integer state;
    
    private String remark;
    
    private Date auditTime;
    
    private Date applyTime;
    
    private Integer auditorId;
    
    private Integer membersId;
    
    private Integer score;
    
    private String file;
    
    private String image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}