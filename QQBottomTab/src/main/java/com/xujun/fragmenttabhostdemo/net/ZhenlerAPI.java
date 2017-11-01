package com.xujun.fragmenttabhostdemo.net;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ${lzq} on 2017-07-20.
 * 公司： 深圳市珍乐科技有限公司
 * 项目：1号掌柜
 */
public interface ZhenlerAPI {
    /**
     * 登陆
     */
    String LOGIN = "login";//与方法名保持一致

    @POST(IUrlConstantNew.LOGIN_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> login(@FieldMap Map<String, String> map);

    /**
     * 获取注册验证码
     */
    String GETSMSCODE = "getSmsCode";//与方法名保持一致

    @POST(IUrlConstantNew.GETSMSCODE_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getSmsCode(@FieldMap Map<String, String> map);

    /**
     * 校验验证码
     */
    String COMFISMSCODE = "comfiSmsCode";//与方法名保持一致

    @POST(IUrlConstantNew.COMFISMSCODE_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> comfiSmsCode(@FieldMap Map<String, String> map);

    /**
     * 注册
     */
    String REGISTER = "register";//与方法名保持一致

    @POST(IUrlConstantNew.REGISTER_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> register(@FieldMap Map<String, String> map);

    /**
     * 校验手机号是否被注册
     */
    String CHECKNUMBER = "checkNumber";//与方法名保持一致

    @POST(IUrlConstantNew.CHECKNUMBER_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> checkNumber(@FieldMap Map<String, String> map);


    /**
     * 更新我的密码
     */
    String UPDATAPASS = "updatePassword";//与方法名保持一致

    @POST(IUrlConstantNew.UPDATAPASS_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> updatePassword(@FieldMap Map<String, String> map);

    /**
     * 查看我的账户
     */
    String MYACCOUNT = "myAccount";//与方法名保持一致

    @POST(IUrlConstantNew.MYACCOUNT_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> myAccount(@FieldMap Map<String, String> map);

    /**
     * 初始化可提现金额
     */
    String INITMONEY = "initMoney";//与方法名保持一致

    @POST(IUrlConstantNew.INITMONEY_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> initMoney(@FieldMap Map<String, String> map);

    /**
     * 初始化总金额
     */
    String INITTOTALMONEY = "initTotalMoney";//与方法名保持一致

    @POST(IUrlConstantNew.INITTOTALMONEY_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> initTotalMoney(@FieldMap Map<String, String> map);

    /**
     * 初始化交易记录
     */
    String INITTRADEDETIAL = "initTradeDetial";//与方法名保持一致

    @POST(IUrlConstantNew.INITTRADEDETIAL_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> initTradeDetial(@FieldMap Map<String, String> map);

    /**
     * 查看订单详情
     */
    String FINDTRADEDETIALBYORDER = "findTradeDetialByOrder";//与方法名保持一致

    @POST(IUrlConstantNew.FINDTRADEDETIALBYORDER_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> findTradeDetialByOrder(@FieldMap Map<String, String> map);

    /**
     * 查询是否已经绑定银行卡
     */
    String CHECKISBINDUSER = "checkIsBindedUser";//与方法名保持一致

    @POST(IUrlConstantNew.CHECKISBINDUSER_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> checkIsBindedUser(@FieldMap Map<String, String> map);


    /**
     * 绑定银行卡
     */
    String BINDBANKCARD = "bindBankCard";//与方法名保持一致

    @POST(IUrlConstantNew.BINDBANKCARD_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> bindBankCard(@FieldMap Map<String, String> map);

    /**
     * 检查验证码是否有效
     */
    String CHECKSMSCODEBYMOBILE = "checkSmsCodeByMobile";//与方法名保持一致

    @POST(IUrlConstantNew.CHECKSMSCODEBYMOBILE_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> checkSmsCodeByMobile(@FieldMap Map<String, String> map);


    /**
     * 查看提现记录
     */
    String FINDTRADECASHLIST = "findTradeCashList";//与方法名保持一致

    @POST(IUrlConstantNew.FINDTRADECASHLIST_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> findTradeCashList(@FieldMap Map<String, String> map);

    /**
     * 查看提现进度流程详情
     */
    /*findTradeCashDetailList*/
    String FINDTRADECASHDETAILLIST = "findTradeCashDetailList";//与方法名保持一致

    @POST(IUrlConstantNew.FINDTRADECASHDETAILLIST_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> findTradeCashDetailList(@FieldMap Map<String, String> map);

    /**
     * 获取服务费
     */
    String GETSERVICECHARGE = "getServiceCharge";//与方法名保持一致

    @POST(IUrlConstantNew.GETSERVICECHARGE_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getServiceCharge(@FieldMap Map<String, String> map);

    /**
     * 确认提现
     */
    String CONFIRMPAYMENT = "confirmPayment";//与方法名保持一致

    @POST(IUrlConstantNew.CONFIRMPAYMENT_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> confirmPayment(@FieldMap Map<String, String> map);


    /**
     * 提现
     */
    String PAYMENT = "payment";//与方法名保持一致

    @POST(IUrlConstantNew.PAYMENT_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> payment(@FieldMap Map<String, String> map);


    /**
     * 提现
     */
    String PAYMENTAGREE = "paymentAgree";//与方法名保持一致

    @POST(IUrlConstantNew.PAYMENTAGREE_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> paymentAgree(@FieldMap Map<String, String> map);


    /**
     * 初始化营业报表概览
     */
    String GETDATAOVERVIEW = "getDataOverview";//与方法名保持一致

    @POST(IUrlConstantNew.GETDATAOVERVIEW_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getDataOverview(@FieldMap Map<String, String> map);


    /**
     * 初始化营业业务板块数据
     */
    String GETBUSINESSSEGMENTS = "getBusinessSegments";//与方法名保持一致

    @POST(IUrlConstantNew.GETBUSINESSSEGMENTS_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getBusinessSegments(@FieldMap Map<String, String> map);

    // 支付方式报表
    String GETPAYTYPEREPORT = "getpayTypeReport";//与方法名保持一致

    @POST(IUrlConstantNew.GETPAYTYPEREPORT_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getpayTypeReport(@FieldMap Map<String, String> map);


    // 会员充值情况
    String GETMEMBERRECHARGE = "getMemberRecharge";//与方法名保持一致

    @POST(IUrlConstantNew.GETMEMBERRECHARGE_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getMemberRecharge(@FieldMap Map<String, String> map);

    // 会员充值列表
    String GETMEMBERRECHARGELIST = "getMemberRechargeList";//与方法名保持一致

    @POST(IUrlConstantNew.GETMEMBERRECHARGELIST_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getMemberRechargeList(@FieldMap Map<String, String> map);


    /**
     * 经营走势报表
     */
//    getOperatingTrend
    String GETOPERATINGTREND = "getOperatingTrend";//与方法名保持一致

    @POST(IUrlConstantNew.GETOPERATINGTREND_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getOperatingTrend(@FieldMap Map<String, String> map);

    // getFoodProportion


    /**
     * 获取菜品占比
     * * @param map
     *
     * @return
     */
    String GETFOODPROPORTION = "getFoodProportion";//与方法名保持一致

    @POST(IUrlConstantNew.GETFOODPROPORTION_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getFoodProportion(@FieldMap Map<String, String> map);

    /**
     * 获取菜品分类下拉框
     */
//http://192.168.134.254:8080/zhenler-server//api/foodCatalog/findFoodCatalog?resId=0000000055dd15670155ddd056ef0121
    String FINDFOODCATALOG = "findFoodCatalog";//与方法名保持一致

    @POST(IUrlConstantNew.FINDFOODCATALOG_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> findFoodCatalog(@FieldMap Map<String, String> map);

    /**
     * 分类加载
     */
    String GETFOODCLASSIFYPROPORTION = "getFoodClassifyProportion";//与方法名保持一致

    @POST(IUrlConstantNew.GETFOODCLASSIFYPROPORTION_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getFoodClassifyProportion(@FieldMap Map<String, String> map);


    /**
     * 交接班
     */
    String GETRSCHANGESHIFTSLIST = "getRsChangeShiftsList";//与方法名保持一致

    @POST(IUrlConstantNew.GETRSCHANGESHIFTSLIST_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getRsChangeShiftsList(@FieldMap Map<String, String> map);


    /**
     * 交接班详情
     */
    String GETRESCHANGESHIFTSDETAIL = "getResChangeShiftsDetail";//与方法名保持一致

    @POST(IUrlConstantNew.GETRESCHANGESHIFTSDETAIL_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getResChangeShiftsDetail(@FieldMap Map<String, String> map);


    /**
     * 异常报表
     */
    String GETEXCEPTIONREPORT = "getExceptionReport";//与方法名保持一致

    @POST(IUrlConstantNew.GETEXCEPTIONREPORT_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getExceptionReport(@FieldMap Map<String, String> map);

    /**
     * 异常报表详情
     */
    String GETEXCEPTIONREPORTDETAIL = "getExceptionReportDetail";//与方法名保持一致

    @POST(IUrlConstantNew.GETEXCEPTIONREPORTDETAIL_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> getExceptionReportDetail(@FieldMap Map<String, String> map);

    /**
     * 创建店铺
     */
    String CREATERESTAURANT = "createRestaurant";//与方法名保持一致

    @POST(IUrlConstantNew.CREATERESTAURANT_URL)
    @FormUrlEncoded
    Observable<CommonResponse<String>> createRestaurant(@FieldMap Map<String, String> map);

    /**
     * 连连支付生成订单
     * 反射调用
     *
     * @param resId 参数
     * @return
     */
    String CREATE_ORDER_LIANLIAN = "createOrderLianlian";//与方法名保持一致

    @FormUrlEncoded
    @POST(IUrlConstantNew.CREATE_ORDER_LIANLIAN)
    Observable<CommonResponse<String>> createOrderLianlian(
            @FieldMap Map<String, String> map);

    /**
     * 连连支付  查询二维码 支付结果(微信  支付宝)
     * 反射调用
     *
     * @param resId 参数
     * @return
     */
    String QUERY_ORDER_LIANLIAN = "queryOrderLianlian";//与方法名保持一致

    @FormUrlEncoded
    @POST(IUrlConstantNew.QUERY_ORDER_LIANLIAN)
    Observable<CommonResponse<String>> queryOrderLianlian(
            @FieldMap Map<String, String> map);


    /**
     * 获取订单详情列表
     */
    String GET_CONSUMER_LIST = "getConsumerList";//与方法名保持一致

    @FormUrlEncoded
    @POST(IUrlConstantNew.GET_CONSUMER_LIST_URL)
    Observable<CommonResponse<String>> getConsumerList(
            @FieldMap Map<String, String> map);

    //getAllProvince  获取所有省份
    String GET_ALLPROVINCE_LIST = "getAllProvince";//与方法名保持一致
    @FormUrlEncoded
    @POST(IUrlConstantNew.GET_ALLPROVINCE_LIST_URL)
    Observable<CommonResponse<String>> getAllProvince(
            @FieldMap Map<String, String> map);


    //获取菜系
    String GET_DICLIST_LIST = "getDicList";//与方法名保持一致
    @FormUrlEncoded
    @POST(IUrlConstantNew.GET_DICLIST_LIST_URL)
    Observable<CommonResponse<String>> getDicList(
            @FieldMap Map<String, String> map);

    //获取城市和县/区详情
    String GET_REGIONBYPID_LIST = "getRegionByPid";//与方法名保持一致
    @FormUrlEncoded
    @POST(IUrlConstantNew.GET_REGIONBYPID_LIST_URL)
    Observable<CommonResponse<String>> getRegionByPid(
            @FieldMap Map<String, String> map);


    //
   // http://192.168.134.254:8080/zhenler-server//api/memberRechargeLog/getMemberRechargeLogList?resId=0000000055dd15670155ddd056ef0121&startTime=2017-07-01&endTime=2017-08-08


    /**
     * 获取会员充值列表
     */
    String GET_MEMBERRECHARGELOG_LIST = "getMemberRechargeLogList";//与方法名保持一致
    @FormUrlEncoded
    @POST(IUrlConstantNew.GET_MEMBERRECHARGELOG_LIST_URL)
    Observable<CommonResponse<String>> getMemberRechargeLogList(
            @FieldMap Map<String, String> map);



   // http://192.168.134.254:8080/zhenler-server//api/consumer/getConsumerDetail?resId=000000005c2536d5015c2e169199061f&id=c6fa12b9bad84f399936d66d56b96b95


    /**
     * 获取订单详情
     */
    String GET_CONSUMERDETAIL = "getConsumerDetail";//与方法名保持一致
    @FormUrlEncoded
    @POST(IUrlConstantNew.GET_CONSUMERDETAIL_URL)
    Observable<CommonResponse<String>> getConsumerDetail(
            @FieldMap Map<String, String> map);

    /**
     * 修改用户信息
     */
    String UPDATE_SHIRO_USER = "updateShiroUser";//与方法名保持一致
    @FormUrlEncoded
    @POST(IUrlConstantNew.UPDATE_SHIRO_USER)
    Observable<CommonResponse<String>> updateShiroUser(
            @FieldMap Map<String, String> map);
}
