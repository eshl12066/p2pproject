package com.gg.microservicecommon.entity.member;

import java.io.Serializable;

/**
 * (MembersDetail)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class MembersDetail implements Serializable {
    private static final long serialVersionUID = 456046389965572579L;
    
    private Integer id;
    
    private Integer membersId;
    
    private String headPhoto;
    
    private String phone;
    
    private String sex;
    
    private String myselfBackground;
    
    private Double monthlyIncome;
    
    private String maritalStatus;
    
    private String children;
    
    private String house;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMyselfBackground() {
        return myselfBackground;
    }

    public void setMyselfBackground(String myselfBackground) {
        this.myselfBackground = myselfBackground;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

}