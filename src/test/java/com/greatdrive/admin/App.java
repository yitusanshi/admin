package com.greatdrive.admin;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:wanglei1
 * @Date: 2018/12/1 14:59
 */
public class App {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        /*json1.put("种类id1", "消耗量1");
        json1.put("种类id2", "消耗量2");
        json2.put("种类id3", "消耗量3");
        json2.put("种类id4", "消耗量4");
        jsonObject.put("分类id1", json1);
        jsonObject.put("分类id2", json2);*/
        json1.put("种类id1", "种类名称1");
        json1.put("种类id2", "种类名称2");
        json2.put("种类id3", "种类名称3");
        json2.put("种类id4", "种类名称4");
        jsonObject.put("分类id1", json1);
        jsonObject.put("分类id2", json2);
        JSONObject json3 = jsonObject.getJSONObject("分类id1");
        json3.put("种类id5", "种类名称5");
        System.out.println(jsonObject.toJSONString());
        String s = "records[2]";
        String key = s.substring(8,9);
        System.out.println(key);
    }
}
