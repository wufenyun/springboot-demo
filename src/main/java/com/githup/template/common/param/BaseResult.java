package com.githup.template.common.param;

import java.io.Serializable;

/**
 * @description:
 * @author: wufenyun
 * @date: 2018-06-27 13
 **/
public class BaseResult implements Serializable {

    private String sid;
    private String code;
    private boolean success;
    private String description;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}