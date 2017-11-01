package com.xujun.fragmenttabhostdemo.net;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;


import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzq.net.NewApi;
import com.xujun.fragmenttabhostdemo.utils.SetterExclusionStrategy;

import org.json.JSONException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 请求参数需封装为json格式
 * Created by lzq on 2017/6/13.
 */

public class BaseModelImp {

    Observable<CommonResponse<String>> observable;
    String method, mark;
    OnNetResponseListener<CommonResponse<String>> onNetResponseListener;
    Map<String, Object> params = new ArrayMap<>();
    BaseModel model;
    private Object objParam;
    private boolean needFailedStatus=false;


    /**
     * ZhenlerAPI中定义的请求方法名
     *
     * @param method
     * @return
     */

    /**
     * 是否需要返回状态
     * @return
     *
     *      */
    public BaseModelImp setMethod(String method) {
    this.method = method;
    return this;
    }


    public BaseModelImp needFailedStatus() {
        this.needFailedStatus=true;
        return this;
    }

    public BaseModelImp setParam(BaseModel model) {
        this.model = model;
        return this;
    }

    public BaseModelImp setParam(Object objParam) {
        this.objParam = objParam;
        return this;
    }

    public BaseModelImp addParam(String key, Object param) {
        params.put(key, param);
        return this;
    }


    public BaseModelImp setMark(String mark) {
        this.mark = mark;
        return this;
    }

    public BaseModelImp build() {
        try {
            ExclusionStrategy excludeStrategy = new SetterExclusionStrategy(new String[]{"createTime", "lastUpdateTime", "birthday"});
            Gson gson = new GsonBuilder().setExclusionStrategies(excludeStrategy)
                    .create();

//            Method invokeMethod = ZhenlerAPI.class.getDeclaredMethod(method, new Class[]{RequestBody.class,String.class});
            Method invokeMethod = NewApi.class.getDeclaredMethod(method, new Class[]{Map.class});
//            RequestBody body;
            String request = null;
            if (model != null) {
                request = gson.toJson(model);
            }
            if (objParam != null) {
                request = gson.toJson(objParam);
            }
            if (params.size() > 0) {
                request = gson.toJson(params);
            }
            if (TextUtils.isEmpty(request)) {
                observable = (Observable<CommonResponse<String>>) invokeMethod.invoke(RetrofitService.createZhenlerAPI());
            } else {
                Log.v("request参数", "request---------" + request);
                observable = (Observable<CommonResponse<String>>) invokeMethod.invoke(RetrofitService.createZhenlerAPI()
                        , CommonInterfaceReqUtils.initRequestParameters(request));
//                JSONObject obj=new JSONObject(request);
//                body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),request);
//                observable = (Observable<CommonResponse<String>>) invokeMethod.invoke(RetrofitService.createZhenlerAPI()
//                        , body, CommonInterfaceReqUtils.initRequestParameters(obj));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BaseModelImp setOnNetResponseListener(OnNetResponseListener<CommonResponse<String>> onNetResponseListener) {
        this.onNetResponseListener = onNetResponseListener;
        return this;
    }

    public void onNetLoad() {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (onNetResponseListener != null)
                            onNetResponseListener.onStart();
                    }
                })
                .subscribe(new Observer<CommonResponse<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CommonResponse<String> value) {
                        //这是判断是否是业务层面的服务器请求异常，此处是根据返回的值是否为空来判断的，根据自己和服务器的约定自行判断业务异常
                        Log.e("BaseModelImp服务器返回---", value.toString());
                        value.setMethodName(method);
                        value.setMark(mark);
                        if(needFailedStatus){
                            if (onNetResponseListener != null)
                                onNetResponseListener.onSuccess("");
                        }else{
                            if (value.isReturnStatus()) {
                                if (onNetResponseListener != null)
                                    onNetResponseListener.onSuccess("");
                            } else {
                                if (onNetResponseListener != null)
                                    onNetResponseListener.onFailure(new Exception("错误码:"+value.toString() ));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        //此处属于服务器请求异常！
                        if (onNetResponseListener != null) {
                            onNetResponseListener.onFailure(e);
                            onNetResponseListener.onFinish();
                        }

                    }

                    @Override
                    public void onComplete() {
                        //仅成功后会调用,失败则不会调用
                        if (onNetResponseListener != null)
                            onNetResponseListener.onFinish();
                    }
                });
    }
}
