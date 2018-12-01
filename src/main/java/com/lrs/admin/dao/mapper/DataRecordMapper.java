package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.DataRecord;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRecordMapper {


    int insert(DataRecord record);

    int insertSelective(DataRecord record);


    DataRecord selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(DataRecord record);

    int updateByPrimaryKey(DataRecord record);
}