package com.xujun.fragmenttabhostdemo.base;

import com.lzq.modle.HttpResponseModel;

/**
 * Created by YI on 2016/2/23.
 * 网络请求处理分发接口
 */
public interface HttpHandler {
    /**
     * 网络请求数据返回错误
     */
    void httpErr(HttpResponseModel message) throws Exception;

    /**
     * 网络请求数据返回成功
     *
     * @param message 返回的序列化结果对象
     */
    void httpSuccess(HttpResponseModel message) throws Exception;
}
