package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//钢帘线_供应商
@Service
public class SteelCordService1 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("1")){
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
                if (record.getCategoryId().equals("1")){
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
        if (categoryid.equals("7")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("1")){
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
        //颗粒物(烟尘)
        if (categoryid.equals("12")){
            if (productvolume <= 120f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 120f, productvolume);
        }
        //SO2
        if (categoryid.equals("13")){
            if (productvolume <= 550f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 550f, productvolume);
        }
        //NOX
        if (categoryid.equals("14")){
            if (productvolume <= 200f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 200f, productvolume);
        }
        //NH3
        if (categoryid.equals("15")){
            if (productvolume <= 1.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 1.5f, productvolume);
        }
        //臭气
        if (categoryid.equals("16")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }
        //硫酸雾
        if (categoryid.equals("19")){
            if (productvolume <= 30f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 30f, productvolume);
        }
        //HCl
        if (categoryid.equals("18")){
            if (productvolume <= 30f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 30f, productvolume);
        }
        //COD
        if (categoryid.equals("23")){
            if (productvolume <= 80f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 80f, productvolume);
        }
        //SS
        if (categoryid.equals("24")){
            if (productvolume <= 50f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 50f, productvolume);
        }
        //总铜
        if (categoryid.equals("25")){
            if (productvolume <= 0.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.5f, productvolume);
        }
        //总锌
        if (categoryid.equals("26")){
            if (productvolume <= 1.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 1.5f, productvolume);
        }
        //NH3-N
        if (categoryid.equals("27")){
            if (productvolume <= 15f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 15f, productvolume);
        }
        //TP
        if (categoryid.equals("28")){
            if (productvolume <= 0.5f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.5f, productvolume);
        }
        //石油类
        if (categoryid.equals("29")){
            if (productvolume <= 3f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 3f, productvolume);
        }
        //总氮
        if (categoryid.equals("35")){
            if (productvolume <= 20f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 20f, productvolume);
        }
        //总铁
        if (categoryid.equals("40")){
            if (productvolume <= 3f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 3f, productvolume);
        }
        //总氰化物
        if (categoryid.equals("41")){
            if (productvolume <= 0.3f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.3f, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }
}
