package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.ProCategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProCategoryMapper {
    List<ProCategory> selectList(Map<String, String> dbColumn);
    ProCategory getProCategoryDetail(String categoryid);
    int deleteByPrimaryKey(Integer id);

    int insert(ProCategory record);
    ;
}