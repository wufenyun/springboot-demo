package com.githup.template.common.param;

import java.io.Serializable;

/**
 * @description:
 * @author: wufenyun
 * @date: 2018-06-27 13
 **/
public class BaseRequest implements Serializable {

    /**
     * 请求标识id
     */
    private String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}