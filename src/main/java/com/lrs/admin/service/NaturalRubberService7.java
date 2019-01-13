package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

//天然橡胶_供应商
@Service
public class NaturalRubberService7 extends BaseJudgeService{
    @Override
    public DataRecordCategoryExtend isPass(DataRecordCategory dataRecordCategory, List<DataRecordCategory> list) {
        String categoryid = dataRecordCategory.getCategoryId();
        System.out.println(dataRecordCategory.getCategoryId()+"=========="+dataRecordCategory.getProductVolume());
        float productvolume = dataRecordCategory.getProductVolume();
       
        Boolean b = false;
        if (categoryid.equals("-1")){
            productvolume = energyConsume(list);
            if (productvolume <= 45){
                b = true;
            }
            dataRecordCategory.setProductVolume(productvolume);
            return  transFormToExtend(dataRecordCategory, b, 45f);
        }

        //吨干胶耗水量-乳标胶
        if (categoryid.equals("246")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("178")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            if (water/volume <= 12){
                b = true;
            }
           return  transFormToExtend(dataRecordCategory, b, 12f);

        }


        //吨干胶耗水量-凝标胶
        if (categoryid.equals("184")){
            float volume = -1f;
            for (DataRecordCategory record : list){
                if (record.getCategoryId().equals("245")){
                    volume = record.getProductVolume();
                    break;
                }
            }
            float water = dataRecordCategory.getProductVolume();
            if (water/volume <= 20f){
                b = true;
            }
            return  transFormToExtend(dataRecordCategory, b, 20f);

        }
        //废气中SO2排放浓度
        if (categoryid.equals("190")){
            if (productvolume < 850f){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , 850f);
        }
        //废气中NOx排放浓度
        if (categoryid.equals("191")){
            if (productvolume < 240f){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , 240f);
        }
        //废气中颗粒物排放浓度
        if (categoryid.equals("192")){
            float reference = 240f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , reference);
        }
        //恶臭排放浓度
        if (categoryid.equals("194")){
            float reference = 20f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , reference);
        }
        //废水中COD含量
        if (categoryid.equals("196")){
            float reference = 100f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , reference);
        }
        //废水中BOD5含量
        if (categoryid.equals("197")){
            float reference = 30f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , reference);
        }
        //废水中NH3-N含量
        if (categoryid.equals("198")){
            float reference = 20f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , reference);
        }
        //废水中SS含量
        if (categoryid.equals("199")){
            float reference = 70f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecordCategory, b , reference);
        }
        /*//废气中SO2排放浓度
        if (categoryid.equals("190")){
            float reference = 850f;
            if (productvolume < reference){
                b = true;
            }
            return transFormToExtend(dataRecord, b , reference);
        }*/

        return transFormToExtend(dataRecordCategory, b , 0L);
    }
}
