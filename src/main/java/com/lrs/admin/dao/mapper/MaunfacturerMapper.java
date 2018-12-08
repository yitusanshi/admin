package com.lrs.admin.dao.mapper;

import com.lrs.admin.dao.domain.Maunfacturer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaunfacturerMapper {
    int insert(Maunfacturer record);
    Maunfacturer selectUser(String username);
    Maunfacturer selectByFirmId(int firmid);
    List<Maunfacturer> selectByGrade(int grade);
    List<Maunfacturer> selectAll();
    void updatePassword(int firmid, String newpassword);
}