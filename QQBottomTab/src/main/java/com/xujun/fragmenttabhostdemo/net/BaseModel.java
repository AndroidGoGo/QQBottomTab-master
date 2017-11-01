package com.xujun.fragmenttabhostdemo.net;

import android.content.ContentValues;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wusl on 2017/6/13.
 * 解析推送列表数据
 */

public class BaseModel {


    protected String companyId="";

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
