package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.ProCategory;
import com.lrs.admin.dao.mapper.DataRecordMapper;
import com.lrs.admin.dao.mapper.ProCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wanglei1
 * @Date: 2018/12/1 16:35
 */
@Service
public class DataDealService {
    @Autowired
    private ProCategoryMapper proCategoryMapper;
    @Autowired
    private DataRecordMapper dataRecordMapper;

    public List<ProCategory> getUserCategory(String dbColumn){
        return proCategoryMapper.selectList(dbColumn);
    }
    public void insertDataRecord(DataRecord dataRecord){
        dataRecordMapper.insert(dataRecord);
    }
    public List<DataRecord> selectGroupByFirmId(int firmid){
        return dataRecordMapper.selectGroupByFirmId(firmid);
    }
    public List<DataRecord> selectDetailData(int firmid, String tagTime){
        return dataRecordMapper.selectDetailData(firmid, tagTime);
    }
    public ProCategory getProCategoryDetail(String categoryid){
        return proCategoryMapper.getProCategoryDetail(categoryid);
    }

}
