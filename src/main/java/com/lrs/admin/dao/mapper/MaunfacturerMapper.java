package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.Maunfacturer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Resource(name = "maunfacturerMapper")
public interface MaunfacturerMapper {
    int insert(Maunfacturer record);
    Maunfacturer selectUser(String username);
}