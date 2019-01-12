package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;

import java.util.List;

public interface JudgePassService {
    DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecord> list);
}
