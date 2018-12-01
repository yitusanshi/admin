package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.ProCategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProCategoryMapper {
    List<ProCategory> selectList(String dbColumn);
    ProCategory getProCategoryDetail(String categoryid);
    int deleteByPrimaryKey(Integer id);

    int insert(ProCategory record);

    int insertSelective(ProCategory record);


    ProCategory selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(ProCategory record);

    int updateByPrimaryKey(ProCategory record);
}