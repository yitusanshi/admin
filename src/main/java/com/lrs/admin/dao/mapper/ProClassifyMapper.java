package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.ProClassify;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProClassifyMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(ProClassify record);

    int insertSelective(ProClassify record);


    ProClassify selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(ProClassify record);

    int updateByPrimaryKey(ProClassify record);
}