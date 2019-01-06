package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordExtend;

import javax.annotation.Resource;
import java.util.List;

public interface JudgePassService {
    DataRecordExtend isPass(DataRecord dataRecord, List<DataRecord> list);
}
