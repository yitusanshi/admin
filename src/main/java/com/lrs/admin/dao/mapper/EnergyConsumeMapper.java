package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.EnergyConsume;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EnergyConsumeMapper {


    List<EnergyConsume> selectAll();

}