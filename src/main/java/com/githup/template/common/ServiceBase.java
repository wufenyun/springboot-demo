package com.githup.template.common;

import com.githup.template.common.param.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceBase {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 构造成功response
     *
     * @return
     */
    public <T> Result<T> success() {
        return success(null);
    }

    /**
     * 构造成功response
     *
     * @return
     */
    public <T> Result<T> success(String code, String desc) {
        return success(null,code, desc);
    }

    /**
     * 构造成功response
     *
     * @param data
     * @param <T>
     * @return
     */
    public <T> Result<T> success(T data) {
        return success(data,ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getDescription());
    }

    /**
     * 构造成功response
     *
     * @return
     */
    public <T> Result<T> success(T data,String code,String descr) {
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setData(data);
        result.setCode(code);
        result.setDescription(descr);
        return result;
    }

    /**
     * 构造失败response
     *
     * @param desc 失败描述
     * @return
     */
    public <T> Result<T> fail(String desc) {
        return fail(ResultCode.FAIL.getCode(), desc);
    }

    public <T> Result<T> fail(ResultCode rc) {
        return fail(rc.getCode(), rc.getDescription());
    }

    /**
     * 构造失败response
     *
     * @param code 失败码
     * @param desc 失败描述
     * @return
     */
    public <T> Result<T> fail(String code, String desc) {
        return fail(code, desc, null);
    }

    /**
     * 构造失败response
     *
     * @param code 失败码
     * @param desc 失败描述
     * @return
     */
    public <T> Result<T> fail(String code, String desc, T data) {
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setDescription(desc);
        result.setCode(code);
        result.setData(data);
        return result;
    }


}
