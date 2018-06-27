package com.githup.template.module.region.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 地域信息表对应实体类，暂时不涉及写操作，暂时保留此对象日后用
 */
public class RegionDto implements Serializable {
    /**
     * 地域ID
     */
    private Integer regionId;
    /**
     * 父地域ID
     */
    private Integer parentId;
    /**
     * 地域名称
     */
    private String regionName;
    /**
     * 地域英文名
     */
    private String regionEname;
    /**
     * 行政区划编码
     */
    private String adminCode;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 邮政编码
     */
    private String zipcode;
    /**
     * 默认种币
     */
    private String currency;
    /**
     * 认默时差（秒）
     */
    private Integer timediff;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTimediff() {
        return timediff;
    }

    public void setTimediff(Integer timediff) {
        this.timediff = timediff;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionEname() {
        return regionEname;
    }

    public void setRegionEname(String regionEname) {
        this.regionEname = regionEname;
    }
}
