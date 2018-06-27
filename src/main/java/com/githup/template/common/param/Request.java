package com.githup.template.common.param;

/**
 * @description:
 * @author: wufenyun
 * @date: 2018-06-27 13
 **/
public class Request<T> extends BaseRequest {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}