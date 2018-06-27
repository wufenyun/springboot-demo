package com.githup.template.module.region;

import com.githup.template.common.ServiceBase;
import com.githup.template.common.param.Result;
import com.githup.template.module.region.dao.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: wufenyun
 * @date: 2018-06-27 13
 **/
@Service
public class RegionService extends ServiceBase {

    @Autowired
    private RegionMapper regionMapper;

    public Result listAll() {
        return success(regionMapper.listAll());
    }
}