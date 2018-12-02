package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.TransportRecord;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TransportRecord record);

    int insertSelective(TransportRecord record);

    TransportRecord selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(TransportRecord record);

    int updateByPrimaryKey(TransportRecord record);
}