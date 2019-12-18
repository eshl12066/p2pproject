package com.gg.microservicecommon.entity.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysLoginLog)实体类
 *
 * @author makejava
 * @since 2019-12-14 16:01:57
 */
public class SysLoginLog implements Serializable {
    private static final long serialVersionUID = -53801334947798474L;
    
    private Integer logId;
    
    private Integer userId;
    
    private String userName;
    
    private String userRole;
    
    private String content;
    
    private String type;
    
    private String remarks;
    
    private String tablename;
    
    private String resultValue;
    
    private String ip;
    
    private String requestUrl;
    
    private Integer result;
    
    private String exString;

    private Date logTime;

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getExString() {
        return exString;
    }

    public void setExString(String exString) {
        this.exString = exString;
    }

}