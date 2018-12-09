package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.ProCategory;
import com.lrs.admin.dao.mapper.DataRecordCategoryMapper;
import com.lrs.admin.dao.mapper.DataRecordMapper;
import com.lrs.admin.dao.mapper.ProCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private DataRecordCategoryMapper dataRecordCategoryMapper;

    public List<ProCategory> getUserCategory(String dbColumn){
        Map<String, String> map = new HashMap<>();
        map.put("dbColumn", dbColumn);
        return proCategoryMapper.selectList(map);
    }
    public void insertDataRecord(List<DataRecord> dataRecord){
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
    public List<DataRecord> selectUniqueTag(){
        return dataRecordMapper.selectUniqueTag();
    }
    public List<DataRecordCategory> selectDetail(int firmid, String tagTime){
        return dataRecordCategoryMapper.selectDetail(firmid, tagTime);
    }

}
