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
import java.util.Map;

@Service
public abstract class BaseJudgeService implements JudgePassService {
    @Resource
    private EnergyConsumeMapper energyConsumeMapper;
    private HashMap<String, Float> energymap = new HashMap<String, Float>();
    private HashMap<String, EnergyConsume> gasMap = new HashMap<>();
    private static Map<String, Float> origionMap = new HashMap(){{
        put("北京\\天津\\河北\\山西\\山东", 0.8843f);
        put("辽宁\\吉林\\黑龙江", 0.7769f);
        put("上海\\江苏\\浙江\\安徽\\福建", 0.7035f);
        put("河南\\湖北\\湖南\\江西\\四川\\重庆", 0.5257f);
        put("陕西\\甘肃\\青海\\宁夏\\新疆", 0.6671f);
        put("广东\\广西\\云南\\贵州\\海南", 0.5271f);
    }
    };
    protected DataRecordCategoryExtend transFormToExtend(DataRecordCategory dataRecordCategory, Boolean b, float reference, float result){
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
        dataRecordExtend.setResult(result);
        return dataRecordExtend;
    }

    protected long energyConsume(List<DataRecordCategory> list){
        List<EnergyConsume> energyConsumeList = energyConsumeMapper.selectAll();
        for (EnergyConsume energyConsume : energyConsumeList){
            energymap.put(energyConsume.getCategoryId(), energyConsume.getRatio());
        }
        long target = 0;
        for (DataRecordCategory dataRecord : list){
            String categoryid = dataRecord.getCategoryId();
            if (energymap.containsKey(categoryid)){
                target += dataRecord.getProductVolume() * energymap.get(categoryid);
            }
        }
        return target;
    }
    protected float gasConsume(List<DataRecordCategory> list, String address){
        List<EnergyConsume> energyConsumeList = energyConsumeMapper.selectAll();
        for (EnergyConsume energyConsume : energyConsumeList){
            gasMap.put(energyConsume.getCategoryId(), energyConsume);
        }
        float target = 0;
        float elec = 0f;
        for (DataRecordCategory dataRecord : list){
            String categoryid = dataRecord.getCategoryId();
            System.out.println("gasMap======"+gasMap);
            if (gasMap.containsKey(categoryid)){
                System.out.println("categoryid+==="+categoryid);

                EnergyConsume energyConsume = gasMap.get(categoryid);
                target += dataRecord.getProductVolume() * energyConsume.getHotNum()*energyConsume.getCarbonNum()*energyConsume.getBurnPercent()*44f/12;
            }
            if (dataRecord.getCategoryId().equals("276")){
                elec = dataRecord.getProductVolume();
            }
        }
        String provnice = address.substring(0,2);
        float ratio = 0f;
        if (provnice.equals("内蒙")){
            if (provnice.contains("赤峰") || provnice.contains("通辽") || provnice.contains("呼伦贝尔") || provnice.contains("兴安盟")){
                ratio = 0.7769f;
            }else {
                ratio = 0.8843f;
            }
        }else {
            for (Map.Entry<String, Float> entry : origionMap.entrySet()){
                if (entry.getKey().contains(provnice)){
                    ratio = entry.getValue();
                }
            }
        }
        System.out.println("elec+===="+elec);
        System.out.println("ratio+===="+ratio);
        target+= elec*ratio/1000;

        return target;
    }

    public float divided(float f1, float f2){
        if (f2 <= 0f){
            return 0f;
        }
        return  f1/f2;
    }
}
