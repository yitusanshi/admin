package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

//轮胎生产_回收商
@Service
public class TyreProduceService8 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        float productvolume = dataRecordCategory.getProductVolume();
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            float volume = -1f;
            float result = 0f;
            float referce = 0f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204")){
                    volume = record.getProductVolume();
                    result = divided(productvolume, volume);
                    referce = 415f;
                    if (result < referce){
                        b = true;
                    }

                    break;
                }
                if (record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                    result = divided(productvolume, volume);
                    referce = 285f;
                    if (result < referce){
                        b = true;
                    }

                    break;
                }
            }

            dataRecordCategory.setProductVolume(productvolume);
            return  transFormToExtend(dataRecordCategory, b, referce, result);
        }
        //单位产品橡胶消耗量
        if (categoryid.equals("206")){
            float volume = -1f;
            float reference = 0f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204")){
                    volume = record.getProductVolume();
                    reference = 0.5f;
                    break;
                }
                if (record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                    reference = 0.55f;
                    break;
                }

            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= reference){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, reference, result);
        }

        //单位产品橡胶消耗量(斜交线)
        if (categoryid.equals("204")){
            float count = 0f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("206") || record.getCategoryId().equals("207")){
                    count += record.getProductVolume();
                }
            }
            float result = divided(count, productvolume);
            if (result <= 0.5f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 0.5f, result);
        }
        //单位产品橡胶消耗量(子午线)
        if (categoryid.equals("205")){
            float count = 0f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("206") || record.getCategoryId().equals("207")){
                    count += record.getProductVolume();
                }
            }
            float result = divided(productvolume, count);
            if (result <= 0.55f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 0.55f, result);
        }
        //单位产品新鲜水消耗量
        if (categoryid.equals("212")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            float result = divided(water, volume);
            if (result <= 26f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 26f, result);
        }

        //单位产品废气量
        if (categoryid.equals("219")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float gas = dataRecordCategory.getProductVolume();
            float result = divided(gas, volume);
            if (result <= 1300f){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b, 1300f, productvolume);
        }
        //单位产品废气中非甲烷总烃
        if (categoryid.equals("222")){
            float volume = -1f;
            float allGas = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                }
                if (record.getCategoryId().equals("219")){
                    allGas = record.getProductVolume();
                }
            }
            float sum = productvolume * allGas;
            float result = divided(sum, volume);
            if (result <= 0.4f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.4f, result);
        }
        //恶臭
        if (categoryid.equals("223")){
            float refer = 20f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //单位产品炭黑粉尘量
        if (categoryid.equals("224")){
            float volume = -1f;
            float allGas = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                }
                if (record.getCategoryId().equals("219")){
                    allGas = record.getProductVolume();
                }
            }
            float sum = productvolume * allGas;
            float result = divided(sum, volume);
            if (result <= 0.016f){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, 0.016f, result);
        }
        //废水排放量
        if (categoryid.equals("299")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float refer = 7f;
            float result = divided(productvolume, volume);
            if (result <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //COD
        if (categoryid.equals("300")){
            float refer = 300f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //BOD5
        if (categoryid.equals("301")){
            float refer = 80f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //SS
        if (categoryid.equals("302")){
            float refer = 150f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //NH3-N
        if (categoryid.equals("303")){
            float refer = 30f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //总磷
        if (categoryid.equals("304")){
            float refer = 1f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //石油类
        if (categoryid.equals("305")){
            float refer = 10f;
            if (productvolume <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, productvolume);
        }
        //单位产品固体废物产生量
        if (categoryid.equals("225")){
            float refer = 0.05f;
            float product = 0f;
            float result = 0f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                     product = record.getProductVolume();
                }
                if (record.getCategoryId().equals("226")){
                    productvolume += record.getProductVolume();
                }
            }
            result = divided(productvolume, product);
            if (result <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, result);
        }
        //单位产品固体废物产生量
        if (categoryid.equals("226")){
            float refer = 0.05f;
            float product = 0f;
            float result = 0f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("204") || record.getCategoryId().equals("205")){
                    product += record.getProductVolume();
                }
                if (record.getCategoryId().equals("225")){
                    productvolume += record.getProductVolume();
                }
            }
            result = divided(productvolume, product);
            if (result <= refer){
                b =true;
            }
            return transFormToExtend(dataRecordCategory, b, refer, result);
        }
        return transFormToExtend(dataRecordCategory, b , 0f, 0f);
    }
}
