package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//胎圈钢丝_供应商
@Service
public class BeadWireService5 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("108")){
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
                if (record.getCategoryId().equals("108")){
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
        if (categoryid.equals("114")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("108")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 52f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 52f, result);
        }

        //颗粒物
        if (categoryid.equals("119")){
            if (productvolume <= 120f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 120f, productvolume);
        }
        //SO2
        if (categoryid.equals("120")){
            if (productvolume <= 550f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 550f, productvolume);
        }
        //NOX
        if (categoryid.equals("121")){
            if (productvolume <= 200f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 200f, productvolume);
        }
        //NH3
        if (categoryid.equals("122")){
            if (productvolume <= 1.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 1.5f, productvolume);
        }
        //臭气
        if (categoryid.equals("123")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }
        //HCl
        if (categoryid.equals("125")){
            if (productvolume <= 30f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 30f, productvolume);
        }
        //硫酸雾
        if (categoryid.equals("126")){
            if (productvolume <= 30f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 30f, productvolume);
        }
        //二苯胺
        if (categoryid.equals("128")){
            if (productvolume <= 70f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 70f, productvolume);
        }
        //非甲烷总烃
        if (categoryid.equals("129")){
            if (productvolume <= 120f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 120f, productvolume);
        }
        //COD
        if (categoryid.equals("132")){
            if (productvolume <= 80f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 80f, productvolume);
        }
        //SS
        if (categoryid.equals("133")){
            if (productvolume <= 50f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 50f, productvolume);
        }
        //总铜
        if (categoryid.equals("134")){
            if (productvolume <= 0.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.5f, productvolume);
        }
        //总锌
        if (categoryid.equals("135")){
            if (productvolume <= 1.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 1.5f, productvolume);
        }
        //NH3-N
        if (categoryid.equals("136")){
            if (productvolume <= 15f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 15f, productvolume);
        }
        //TP
        if (categoryid.equals("137")){
            if (productvolume <= 0.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.5f, productvolume);
        }
        //石油类
        if (categoryid.equals("138")){
            if (productvolume <= 3f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 3f, productvolume);
        }
        //总氮
        if (categoryid.equals("144")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }
        //总铁
        if (categoryid.equals("150")){
            if (productvolume <= 3f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 3f, productvolume);
        }
        //总氰化物
        if (categoryid.equals("149")){
            if (productvolume <= 0.3f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.3f, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }
}
