package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordExtend;
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
    protected DataRecordExtend transFormToExtend(DataRecord dataRecord, Boolean b, float reference){
        DataRecordExtend dataRecordExtend = new DataRecordExtend();
        if (b){
            dataRecordExtend.setIsPass(1);
        }else {
            dataRecordExtend.setIsPass(-1);
        }
        dataRecordExtend.setReference(reference);
        dataRecordExtend.setId(dataRecord.getId());
        dataRecordExtend.setFirmId(dataRecord.getFirmId());
        dataRecordExtend.setTagTime(dataRecord.getTagTime());
        dataRecordExtend.setCategoryId(dataRecord.getCategoryId());
        dataRecordExtend.setClassifyId(dataRecord.getClassifyId());
        dataRecordExtend.setProductVolume(dataRecord.getProductVolume());
        dataRecordExtend.setDataSource(dataRecord.getDataSource());
        dataRecordExtend.setRemark(dataRecord.getRemark());
        dataRecordExtend.setApplicantTime(dataRecord.getApplicantTime());
        return dataRecordExtend;
    }

    protected long energyConsume(List<DataRecord> list){
        List<EnergyConsume> energyConsumeList = energyConsumeMapper.selectAll();
        for (EnergyConsume energyConsume : energyConsumeList){
            map.put(energyConsume.getCategoryId(), energyConsume.getRatio());
        }
        long target = 0;
        for (DataRecord dataRecord : list){
            String categoryid = dataRecord.getCategoryId();
            if (map.containsKey(categoryid)){
                target += dataRecord.getProductVolume() * map.get(categoryid);
            }
        }
        return target;
    }
}
