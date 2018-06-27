package com.githup.template.common;

public enum ResultCode {
    SUCCESS("200", "成功"),

    FAIL("400", "操作失败"),

    PARAM_ERROR("401", "参数错误"),

    SERVER_ERROR("501", "服务器内部错误");



    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    ResultCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String toStr() {
        return "code:" + code + ",description=" + description;
    }

    public String toStr(String detail) {
        return "code:" + code + ",description=" + description + "," + detail;
    }

}
