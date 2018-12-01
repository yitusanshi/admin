package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.ProCategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProCategoryMapper {


    int insert(ProCategory record);

    int insertSelective(ProCategory record);



    ProCategory selectByPrimaryKey(Integer categoryId);


    int updateByPrimaryKeySelective(ProCategory record);

    int updateByPrimaryKey(ProCategory record);
}