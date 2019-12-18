package com.gg.microservicecommon.entity.setting;

import java.io.Serializable;

/**
 * (SetMessage)实体类
 *
 * @author makejava
 * @since 2019-12-12 11:01:57
 */
public class SetMessage implements Serializable {
    private static final long serialVersionUID = 953236918649786173L;
    
    private Integer id;
    
    private Integer fromMessageId;
    
    private Integer toMessageId;
    
    private String messageContext;
    
    private String messageTitle;
    
    private Integer messageState;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromMessageId() {
        return fromMessageId;
    }

    public void setFromMessageId(Integer fromMessageId) {
        this.fromMessageId = fromMessageId;
    }

    public Integer getToMessageId() {
        return toMessageId;
    }

    public void setToMessageId(Integer toMessageId) {
        this.toMessageId = toMessageId;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public Integer getMessageState() {
        return messageState;
    }

    public void setMessageState(Integer messageState) {
        this.messageState = messageState;
    }

}