/**
 * BrandBigData.com Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * 循环引用，引发stackoverflow
 * @author HaoBin
 * @version $Id: JsonMain.java, v0.1 2018/3/9 12:28 HaoBin
 */
public class JsonMain {
    public static void main(String[] args) {
        JSonObject obj = new JSonObject("haobin");
        JSonObject obj2 = new JSonObject("haobin2");
        obj.setMe(obj2);
        obj2.setMe(obj);
        String txt = new Gson().toJson(obj);
        System.out.println(txt);
    }
}