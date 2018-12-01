package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.Maunfacturer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaunfacturerMapper {
    Maunfacturer selectUser(String username);

    int deleteByPrimaryKey(Integer firmId);

    int insert(Maunfacturer record);

    int insertSelective(Maunfacturer record);


    Maunfacturer selectByPrimaryKey(Integer firmId);

    int updateByPrimaryKeySelective(Maunfacturer record);

    int updateByPrimaryKey(Maunfacturer record);
}