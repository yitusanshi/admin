package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordExtend;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseJudgeService implements JudgePassService {
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
}
