package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.DataRecordCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author:wanglei1
 * @Date: 2018/12/8 13:58
 */
@Mapper
public interface DataRecordCategoryMapper {
    List<DataRecordCategory> selectDetail(int firmid, String tagTime);
}
