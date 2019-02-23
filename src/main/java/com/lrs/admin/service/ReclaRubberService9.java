package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//再生胶_回收商
@Service
public class ReclaRubberService9 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("227")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float result = divided(productvolume, volume);
            if (result < 98f){
                b = true;
            }
            dataRecordCategory.setProductVolume(productvolume);
            return  transFormToExtend(dataRecordCategory, b, 98f, result);
        }
        //单位产品新鲜水消耗量
        if (categoryid.equals("230")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("227")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 0.5f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 0.5f, result);
        }
        //单位产品废气排放量
        if (categoryid.equals("237")){
            float refer = 2000f;
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("227")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float gas = dataRecordCategory.getProductVolume();
            float result = divided(gas, volume);
            if (result <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, result);
        }
        //颗粒物
        if (categoryid.equals("238")){
            float refer = 12f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //硫化氢含量
        if (categoryid.equals("239")){
            float refer = 0.1f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //非甲烷总烃含量
        if (categoryid.equals("240")){
            float refer = 20f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //甲苯及二甲苯合计
        if (categoryid.equals("241")){
            float refer = 30f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //COD含量
        if (categoryid.equals("243")){
            float refer = 100f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //石油类含量
        if (categoryid.equals("244")){
            float refer = 10f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }
}
