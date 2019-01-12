package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseJudgeService implements JudgePassService {
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
}
