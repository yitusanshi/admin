package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.DataRecord;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRecordMapper {

    int insert(List<DataRecord> record);
    List<DataRecord> selectGroupByFirmId(int firmid);
    List<DataRecord> selectGroupByFirmIdForOne(int firmid);
    List<DataRecord> selectDetailData(int firmid, String tagTime);
    List<DataRecord> selectUniqueTag();
    void delDataRecord(int firmid);
    void updateRecordData(DataRecord dataRecord);

/*    int insertSelective(DataRecord record);

    DataRecord selectByPrimaryKey(Integer id);*/


}