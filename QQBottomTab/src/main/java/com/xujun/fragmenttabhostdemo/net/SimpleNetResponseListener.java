package com.xujun.fragmenttabhostdemo.net;

/**
 * <pre>
 * Created by lzq on 2017/8/31.
 *
 */

public abstract class SimpleNetResponseListener<T> implements OnNetResponseListener<T> {
    /**
     * 网络请求开始
     */

    public void onStart(){}

    /**
     * 网络请求结束
     */
    public void onFinish(){}

    /**
     * 网络请求成功
     * @param data 返回的数据实体类信息 泛型定义
     */
    public void onSuccess(String data){

    }

    /**
     * 请求失败
     * @param t 异常
     */
    public void onFailure(Throwable t){}
}
