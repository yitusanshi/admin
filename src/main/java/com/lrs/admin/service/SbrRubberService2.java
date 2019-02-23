package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//合成橡胶_丁苯橡胶_供应商
@Service
public class SbrRubberService2 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            float volume = 0f;
            productvolume = energyConsume(list);
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("47")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float result = divided(productvolume, volume)*0.7f;
            b = true;
            dataRecordCategory.setProductVolume(result);
            return  transFormToExtend(dataRecordCategory, b, 0f, result);
        }
        //温室气体排放计算
        if (categoryid.equals("-2")){
            productvolume = gasConsume(list, dataRecordCategory.getClassifyDesc());
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("47")){
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
        if (categoryid.equals("50")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("47")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 7f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 7f, result);
        }

        //废气中苯乙烯排放浓度
        if (categoryid.equals("56")){
            if (productvolume <= 50f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 50f, productvolume);
        }
        //废气中非甲烷总烃排放浓度
        if (categoryid.equals("57")){
            if (productvolume <= 120f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 120f, productvolume);
        }
        //废气中NOx排放浓度
        if (categoryid.equals("58")){
            if (productvolume <= 150f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 150f, productvolume);
        }
        //废水中BOD5含量
        if (categoryid.equals("60")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }


        //废水中CODcr含量
        if (categoryid.equals("61")){
            if (productvolume <= 60f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 60f, productvolume);
        }
        //废水中SS含量
        if (categoryid.equals("62")){
            if (productvolume <= 70f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 70f, productvolume);
        }
        //废水中NH3-N含量
        if (categoryid.equals("63")){
            if (productvolume <= 8f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 8f, productvolume);
        }
        //废水中TN含量
        if (categoryid.equals("64")){
            if (productvolume <= 40f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 40f, productvolume);
        }
        //废水中TP含量
        if (categoryid.equals("65")){
            if (productvolume <= 1f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 1f, productvolume);
        }
        //废水中石油类含量
        if (categoryid.equals("66")){
            if (productvolume <= 5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 5f, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }



}
