package com.lrs.admin.service;

import com.lrs.admin.dao.domain.MenuList;
import com.lrs.admin.dao.mapper.MenuListMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuListService {
    @Resource
    private MenuListMapper menuListMapper;
    public List<MenuList> getMeunList(String role){
        HashMap<String, String> map = new HashMap<>();
        map.put("role", role);
        return menuListMapper.getMenulist(map);
    }
}
