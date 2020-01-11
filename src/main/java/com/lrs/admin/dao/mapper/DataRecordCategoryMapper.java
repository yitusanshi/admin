package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:wanglei1
 * @Date: 2018/12/8 13:58
 */
@Mapper
public interface DataRecordCategoryMapper {
    List<DataRecordCategory> selectDetail(int firmid, String tagTime);
    List<DataRecordCategory> getRecordData(@Param("tagTime") String tagTime, @Param("firmId") int firmId, @Param("dataYear") String dataYear);
}
