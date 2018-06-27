package com.githup.template.common;

public class ServiceException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String description;
    private Boolean success = false;

    public ServiceException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getDescription());
    }

    public ServiceException(String code, String description) {
        this(code, description, false);
    }

    public ServiceException(ResultCode resultCode, String detail) {
        this(resultCode, false, detail);
    }

    public ServiceException(ResultCode resultCode, Boolean success) {
        this(resultCode, success, null);
    }

    public ServiceException(ResultCode resultCode, Boolean success, String detail) {
        this(resultCode.getCode(), detail == null ? resultCode.getDescription() : resultCode.getDescription() + "," + detail, success);
    }
    
    public ServiceException(String code, String description, Boolean success) {
        super();
        this.code = code;
        this.success = success;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServiceException{");
        sb.append("code='").append(code).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", success=").append(success);
        sb.append('}');
        return sb.toString();
    }
}
