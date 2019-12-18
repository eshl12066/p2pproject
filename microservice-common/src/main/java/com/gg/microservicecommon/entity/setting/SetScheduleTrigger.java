package com.gg.microservicecommon.entity.setting;

import java.io.Serializable;

/**
 * (SetScheduleTrigger)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SetScheduleTrigger implements Serializable {
    private static final long serialVersionUID = 661642199654853177L;
    
    private Integer id;
    
    private String cron;
    
    private Integer status;
    
    private String jobName;
    
    private String jobGroup;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

}