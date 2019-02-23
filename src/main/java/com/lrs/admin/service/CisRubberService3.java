package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//合成橡胶_顺丁橡胶_供应商
@Service
public class CisRubberService3 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            float volume = 0f;
            productvolume = energyConsume(list);
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("70")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float result = divided(productvolume, volume);
            b = true;
            dataRecordCategory.setProductVolume(result);
            return  transFormToExtend(dataRecordCategory, b, 0f, result);
        }
        //单位产品新鲜水消耗量
        if (categoryid.equals("72")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("70")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 30f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 30f, result);
        }

        //废气中非甲烷总烃排放浓度
        if (categoryid.equals("78")){
            float refer =  120f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废气中丁二烯排放浓度
        if (categoryid.equals("79")){
            float refer =  1f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中BOD5含量
        if (categoryid.equals("81")){
            float refer = 20f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中CODcr含量
        if (categoryid.equals("82")){
            float refer = 60f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中SS含量
        if (categoryid.equals("83")){
            float refer = 70f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中NH3-N含量
        if (categoryid.equals("277")){
            float refer = 8f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中TP含量
        if (categoryid.equals("278")){
            float refer = 1f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中石油类含量
        if (categoryid.equals("279")){
            float refer = 5f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //废水中苯含量
        if (categoryid.equals("84")){
            float refer = 0.1f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        b = true;
        return transFormToExtend(dataRecordCategory, b , 0f, productvolume);
    }
}
