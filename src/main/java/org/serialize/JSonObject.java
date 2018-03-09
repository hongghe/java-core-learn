/**
 * BrandBigData.com Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.serialize;

/**
 * @author HaoBin
 * @version $Id: JSonObject.java, v0.1 2018/3/9 12:26 HaoBin
 */
public class JSonObject {
    private String name;
    private JSonObject me;
    public JSonObject(String name) {
        this.name = name;
    }

    public JSonObject getMe() {
        return me;
    }

    public void setMe(JSonObject me) {
        this.me = me;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}