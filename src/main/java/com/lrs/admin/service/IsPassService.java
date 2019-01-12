package com.lrs.admin.service;

import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.DataRecordCategoryExtend;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IsPassService {
    @Resource
    private SteelCordService1 steelCordService1;
    @Resource
    private SbrRubberService2 sbrRubberService2;
    @Resource
    private CisRubberService3 cisRubberService3;
    @Resource
    private NylonCordService4 nylonCordService4;
    @Resource
    private BeadWireService5 beadWireService5;
    @Resource
    private CarbonBlackService6 carbonBlackService6;
    @Resource
    private NaturalRubberService7 naturalRubberService7;
    @Resource
    private TyreProduceService8 tyreProduceService8;
    @Resource
    private ReclaRubberService9 reclaRubberService9;

    /*protected static Map<String, String> map = new HashMap(){
        {
            put( "1" ,  "钢帘线_供应商");
            put( "2" , "合成橡胶_丁苯橡胶_供应商");
            put( "3" , "合成橡胶_顺丁橡胶_供应商");
            put( "4" , "尼龙帘布_供应商");
            put( "5" , "胎圈钢丝_供应商");
            put( "6" , "炭黑_供应商");
            put( "7" , "天然橡胶_供应商");
            put( "8" , "轮胎生产_回收商");
            put( "9" , "再生胶_回收商");

        }
    };
    private static Map<String, String> map = new HashMap<String, String>() {
        {
            put("1", "steel_cord");
            put("2", "sbr_rubber");
            put("3", "cis_rubber");
            put("4", "nylon_cord");
            put("5", "bead_wire");
            put("6", "carbon_black");
            put("7", "natural_rubber");
            put("8", "tyre_produce");
            put("9", "recla_rubber");
        }
    };*/

    public DataRecordCategoryExtend selectFactory(String productid, DataRecordCategory dataRecordCategory, List<DataRecord> list){
        if (StringUtils.isEmpty(productid)){
            return null;
        }
        switch (productid){
            case "1" :
                return steelCordService1.isPass(dataRecordCategory, list);
            case "2" :
                return sbrRubberService2.isPass(dataRecordCategory, list);
            case "3" :
                return cisRubberService3.isPass(dataRecordCategory, list);
            case "4" :
                return nylonCordService4.isPass(dataRecordCategory, list);
            case "5" :
                return beadWireService5.isPass(dataRecordCategory, list);
            case "6" :
                return carbonBlackService6.isPass(dataRecordCategory, list);
            case "7" :
                return naturalRubberService7.isPass(dataRecordCategory, list);
            case "8" :
                return tyreProduceService8.isPass(dataRecordCategory, list);
            case "9" :
                return reclaRubberService9.isPass(dataRecordCategory, list);
            default:
                return null;
        }
    }

}
