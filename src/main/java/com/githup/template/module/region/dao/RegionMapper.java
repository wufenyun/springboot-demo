package com.githup.template.module.region.dao;

import com.githup.template.module.region.dto.RegionDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: wufenyun
 * @date: 2018-06-14 10
 **/
@Mapper
public interface RegionMapper {

    @Select("SELECT * FROM region WHERE region_id= #{regionId}")
    @Results({
            @Result(property = "regionId",column="region_id"),
            @Result(property = "parentId",column="parent_id"),
            @Result(property = "regionName",column="region_name"),
            @Result(property = "regionEname",column="region_ename"),
            @Result(property = "adminCode",column="admincode"),
            @Result(property = "level",column="level"),
            @Result(property = "longitude",column="longitude"),
            @Result(property = "latitude",column="latitude"),
            @Result(property = "zipcode",column="zipcode"),
            @Result(property = "currency",column="currency"),
            @Result(property = "timediff",column="timediff")
    })
    List<RegionDto> getRegionById(Short regionId);

    @Select("SELECT * FROM region")
    @Results({
            @Result(property = "regionId",column="region_id"),
            @Result(property = "parentId",column="parent_id"),
            @Result(property = "regionName",column="region_name"),
            @Result(property = "regionEname",column="region_ename"),
            @Result(property = "adminCode",column="admincode"),
            @Result(property = "level",column="level"),
            @Result(property = "longitude",column="longitude"),
            @Result(property = "latitude",column="latitude"),
            @Result(property = "zipcode",column="zipcode"),
            @Result(property = "currency",column="currency"),
            @Result(property = "timediff",column="timediff")
    })
    List<RegionDto> listAll();
}