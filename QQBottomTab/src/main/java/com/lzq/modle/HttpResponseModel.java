package com.lzq.modle;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/21.
 */

public class HttpResponseModel {
    private static final long serialVersionUID = 1L;
    /**
     * 请求的地址
     */
    private String requestUrl;
    /**
     * 返回的二进制数据
     */
    private byte[] response;
    /**
     * 第几次请求
     */
    private int which;
    /**
     * 请求附带的参数（供回调函数使用）
     */
    private Map<String, Object> attachParams;
    /**
     * 请求的参数
     * */
    private Object params;

    public HttpResponseModel(String requestUrl, byte[] response, int which, Map<String, Object> attachParams, Object params) {
        this.requestUrl = requestUrl;
        this.response = response;
        this.which = which;
        this.attachParams = attachParams;
        this.params = params;
    }


    public String getRequestUrl() {
        return requestUrl;
    }

    public byte[] getResponse() {
        return response;
    }

    public int getWhich() {
        return which;
    }

    public Map<String, Object> getAttachParams() {
        return attachParams;
    }

    public void setResponse(byte[] response) {
        this.response = response;
    }

    public Object getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "HttpResponseModel{" +
                "requestUrl='" + requestUrl + '\'' +
                ", response=" + Arrays.toString(response) +
                ", which=" + which +
                ", attachParams=" + attachParams +
                ", params=" + params +
                '}';
    }
}
