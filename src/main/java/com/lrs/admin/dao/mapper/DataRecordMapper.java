package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.DataRecord;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRecordMapper {

    int insert(DataRecord record);
    List<DataRecord> selectGroupByFirmId(int firmid);
    List<DataRecord> selectDetailData(int firmid, String tagTime);

    int insertSelective(DataRecord record);

    DataRecord selectByPrimaryKey(Integer id);

}