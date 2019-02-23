package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//尼龙帘布_供应商
@Service
public class NylonCordService4 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("89")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float result = divided(productvolume, volume);
            b = true;
            dataRecordCategory.setProductVolume(productvolume);
            return  transFormToExtend(dataRecordCategory, b, 0f, result);
        }
        //温室气体排放计算
        if (categoryid.equals("-2")){
            productvolume = gasConsume(list, dataRecordCategory.getClassifyDesc());
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("89")){
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
        if (categoryid.equals("93")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("89")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 35f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 35f, result);
        }
        //废气中颗粒物排放浓度
        if (categoryid.equals("98")){
            if (productvolume <= 120f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 120f, productvolume);
        }
        //废气中非甲烷总烃排放浓度
        if (categoryid.equals("99")){
            if (productvolume <= 18f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 18f, productvolume);
        }
        //废气中SO2排放浓度
        if (categoryid.equals("286")){
            if (productvolume <= 50f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 50f, productvolume);
        }
        //废气中氮氧化物排放浓度
        if (categoryid.equals("287")){
            if (productvolume <= 200f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 200f, productvolume);
        }
        //废气中甲醛排放浓度
        if (categoryid.equals("288")){
            if (productvolume <= 25f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 25f, productvolume);
        }
        //废气中氨排放浓度
        if (categoryid.equals("289")){
            if (productvolume <= 1.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 1.5f, productvolume);
        }
        //废水中COD排放浓度
        if (categoryid.equals("101")){
            if (productvolume <= 100f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 100f, productvolume);
        }
        //废水中NH3-N排放浓度
        if (categoryid.equals("102")){
            if (productvolume <= 15f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 15f, productvolume);
        }
        //废水中石油类排放浓度
        if (categoryid.equals("103")){
            if (productvolume <= 5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 5f, productvolume);
        }
        //废水中SS排放浓度
        if (categoryid.equals("104")){
            if (productvolume <= 70f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 70f, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }
}
