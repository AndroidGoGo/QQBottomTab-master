package com.lzq.net;

import com.lzq.modle.BaseResponse;
import com.xujun.fragmenttabhostdemo.net.CommonResponse;
import com.xujun.fragmenttabhostdemo.net.IUrlConstantNew;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by lzq on 2017/9/22.
 */

public interface NewApi {
    String GETWEATHERDATAS = "getWeatherDatas";//与方法名保持一致,此处通过反射调用
    @POST(UrlBase.GET_WEATHERDATAS_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getWeatherDatas(@FieldMap Map<String, String> map);



    String LIMITBUY = "limitBuy";//与方法名保持一致,此处通过反射调用
    @POST(UrlBase.GET_LIMITBY)
    @FormUrlEncoded
    Observable<BaseResponse<String>> limitBuy(@FieldMap Map<String, String> map);

    String TOP250 = "top250";//与方法名保持一致,此处通过反射调用
    @POST(UrlBase.GET_MOVIE250)
    @FormUrlEncoded
    Observable<BaseResponse<String>> top250(@FieldMap Map<String, String> map);

    //FrmIntelliPhysicalReportInterface.componentInterface


    String COMPONENTINTERFACE = "componentInterface";//与方法名保持一致,此处通过反射调用
    @POST(UrlBase.GET_COMPONENTINTERFACE)
    @FormUrlEncoded
    Observable<BaseResponse<String>> componentInterface(@FieldMap Map<String, String> map);

    String MOBILE = "index";//与方法名保持一致,此处通过反射调用
    @POST(UrlBase.GET_MOBILE)
    @FormUrlEncoded
    Observable<BaseResponse<String>> index(@FieldMap Map<String, String> map);

    String GET_SMS_CODE = "getSmsCode";//与方法名保持一致
    @FormUrlEncoded
    @GET(IUrlConstantNew.GET_SMS_CODE_URL)
    Call<CommonResponse<String>> getSmsCode(@FieldMap Map<String, String> map);


    String GET_NEWS = "getNews";//与方法名保持一致
    @FormUrlEncoded
    @POST(UrlBase.GET_NEWS)
    Call<CommonResponse<String>> getNews(@FieldMap Map<String, String> map);

    String WX_NEWS = "social";//与方法名保持一致
    @POST("/social?key=5112902d41b4afbe45aad32f4128f7a8&num=10")
    @FormUrlEncoded
    Observable<BaseResponse<String>> social(

            @FieldMap Map<String, String> map);

   // String WX_NEWS = "login";//与方法名保持一致
    @POST("/forms/FrmIfc.appLogin")
    @FormUrlEncoded
    Observable<BaseResponse<String>> appLogin(

            @FieldMap Map<String, String> map);


    @Multipart
    @POST("saveTitle.do")
    Observable<String> sendFileStr(@Part List<MultipartBody.Part> partList, @FieldMap Map<String, String> map);



}
