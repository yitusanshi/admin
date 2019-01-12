package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import com.lrs.admin.dao.domain.EnergyConsume;
import com.lrs.admin.dao.mapper.EnergyConsumeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public abstract class BaseJudgeService implements JudgePassService {
    @Resource
    private EnergyConsumeMapper energyConsumeMapper;
    private HashMap<String, Float> map = new HashMap<String, Float>();
    protected DataRecordCategoryExtend transFormToExtend(DataRecordCategory dataRecordCategory, Boolean b, float reference){
        DataRecordCategoryExtend dataRecordExtend = new DataRecordCategoryExtend();
        if (b){
            dataRecordExtend.setIsPass(1);
        }else {
            dataRecordExtend.setIsPass(-1);
        }
        dataRecordExtend.setReference(reference);
        dataRecordExtend.setId(dataRecordCategory.getId());
        dataRecordExtend.setFirmId(dataRecordCategory.getFirmId());
        dataRecordExtend.setTagTime(dataRecordCategory.getTagTime());
        dataRecordExtend.setCategoryId(dataRecordCategory.getCategoryId());
        dataRecordExtend.setClassifyId(dataRecordCategory.getClassifyId());
        dataRecordExtend.setProductVolume(dataRecordCategory.getProductVolume());
        dataRecordExtend.setDataSource(dataRecordCategory.getDataSource());
        dataRecordExtend.setRemark(dataRecordCategory.getRemark());
        dataRecordExtend.setApplicantTime(dataRecordCategory.getApplicantTime());
        dataRecordExtend.setCategoryName(dataRecordCategory.getCategoryName());
        dataRecordExtend.setUnit(dataRecordCategory.getUnit());
        dataRecordExtend.setClassifyName(dataRecordCategory.getClassifyName());
        dataRecordExtend.setClassifyDesc(dataRecordCategory.getClassifyDesc());
        return dataRecordExtend;
    }

    protected long energyConsume(List<DataRecordCategory> list){
        List<EnergyConsume> energyConsumeList = energyConsumeMapper.selectAll();
        for (EnergyConsume energyConsume : energyConsumeList){
            map.put(energyConsume.getCategoryId(), energyConsume.getRatio());
        }
        long target = 0;
        for (DataRecordCategory dataRecord : list){
            String categoryid = dataRecord.getCategoryId();
            if (map.containsKey(categoryid)){
                target += dataRecord.getProductVolume() * map.get(categoryid);
            }
        }
        return target;
    }
}
