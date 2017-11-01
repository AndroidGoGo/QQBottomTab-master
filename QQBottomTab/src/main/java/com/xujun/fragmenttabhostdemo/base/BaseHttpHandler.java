package com.xujun.fragmenttabhostdemo.base;

import android.os.Handler;
import android.os.Message;


import com.lzq.modle.HttpResponseModel;
import com.lzq.modle.HttpResponseMsgType;

import java.util.logging.Logger;

/**
 * Created by YI on 2016/2/23.
 * 网络请求回调
 */
public final class BaseHttpHandler extends Handler {
    HttpHandler httpHandler;

    public BaseHttpHandler(HttpHandler httpHandler) {
        this.httpHandler = httpHandler;
    }

    @Override
    public final void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg == null)
            return;
        if (httpHandler == null)
            return;
        int what = msg.what;
        switch (what) {
            case HttpResponseMsgType.RESPONSE_ERR:
                try {
                    httpHandler.httpErr((HttpResponseModel) msg.obj);
                } catch (Exception e) {
                    e.printStackTrace();

                }
                break;
            case HttpResponseMsgType.RESPONSE_SUCCESS:
                try {
                    httpHandler.httpSuccess((HttpResponseModel) msg.obj);
                } catch (Exception e) {
                    e.printStackTrace();

                }
                break;
        }
    }
}
