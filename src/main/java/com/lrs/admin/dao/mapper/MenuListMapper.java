package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.MenuList;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MenuListMapper {

    List<MenuList> getMenulist(HashMap<String, String> map);
    int insert(MenuList record);

}