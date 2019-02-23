package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//炭黑_供应商
@Service
public class CarbonBlackService6 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("156")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float result = divided(productvolume, volume);
            if (result < 2250f){
                b = true;
            }
            dataRecordCategory.setProductVolume(productvolume);
            return  transFormToExtend(dataRecordCategory, b, 2250f, result);
        }
        //温室气体排放计算
        if (categoryid.equals("-2")){
            productvolume = gasConsume(list, dataRecordCategory.getClassifyDesc());
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("156")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float result = divided(productvolume, volume);
            b = true;
            dataRecordCategory.setProductVolume(productvolume);
            return  transFormToExtend(dataRecordCategory, b, 0f, result);
        }
        //单位产品新鲜水消耗量
        if (categoryid.equals("160")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("156")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 17f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 17f, result);
        }
        //废气中SO2排放浓度
        if (categoryid.equals("165")){
            if (productvolume <= 550f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 550f, productvolume);
        }
        //废气中NOx排放浓度
        if (categoryid.equals("166")){
            if (productvolume <= 240f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 240f, productvolume);
        }
        //废气中颗粒物排放浓度
        if (categoryid.equals("167")){
            if (productvolume <= 18f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 18f, productvolume);
        }
        //废气中非甲烷总烃排放浓度
        if (categoryid.equals("168")){
            if (productvolume <= 120f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 120f, productvolume);
        }
        //恶臭（H2S）浓度
        if (categoryid.equals("283")){
            if (productvolume <= 0.06f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.06f, productvolume);
        }
        //臭气浓度
        if (categoryid.equals("284")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }
        //废水中COD含量
        if (categoryid.equals("170")){
            if (productvolume <= 100f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 100f, productvolume);
        }
        //废水中BOD5含量
        if (categoryid.equals("171")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }
        //废水中NH3-N含量
        if (categoryid.equals("172")){
            if (productvolume <= 15f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 15f, productvolume);
        }
        //废水中SS含量
        if (categoryid.equals("173")){
            if (productvolume <= 70f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 70f, productvolume);
        }
        //石油类含量
        if (categoryid.equals("174")){
            if (productvolume <= 5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 5f, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }
}
