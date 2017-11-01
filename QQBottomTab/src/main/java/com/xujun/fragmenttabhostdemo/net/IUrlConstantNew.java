package com.xujun.fragmenttabhostdemo.net;

/**
 * Created by ${lzq} on 2017-07-20.
 * 公司： 深圳市珍乐科技有限公司
 * 项目：1号掌柜
 */
public class IUrlConstantNew {

    /**
     * 基础网络请求
     */
   public static final String BASE_NET_URL_NEW = "http://vip.zhenler.com";
    //  public static final String BASE_NET_URL_NEW = "http://119.23.132.192";
    //       public static final String BASE_NET_URL_NEW = "http://192.168.134.254:8080";
//   public static final String BASE_NET_URL_NEW = "http://192.168.134.2:8082";


    public static final String SERVER_NAME = "";

    //   public static final String SERVER_NAME = "/zhenler-server";
    /**
     * 登录接口
     */
    public static final String LOGIN_URL = SERVER_NAME + "/api/user/toLogin";
    /**
     * 获取验证码接口
     */
    public static final String GETSMSCODE_URL = SERVER_NAME + "/api/sms/getSmsCode";
    /**
     * 注册接口
     */
    public static final String REGISTER_URL = SERVER_NAME + "/api/user/register";
    /**
     * 校验验证码
     */
    public static final String COMFISMSCODE_URL = SERVER_NAME + "/api/sms/checkSmsCodeByMobile";


    /**
     * 校验手机号是否注册过
     */
    public static final String CHECKNUMBER_URL = SERVER_NAME + "/api/user/checkMobile";
    /**
     * 修改密码
     */
    public static final String UPDATAPASS_URL = SERVER_NAME + "/api/user/updatePassword";
    /**
     * 我的账户
     */
    public static final String MYACCOUNT_URL = SERVER_NAME + "/api/tradeAccount/findTradeAccountList";
    /**
     * 可提现金额
     */
    public static final String INITMONEY_URL = SERVER_NAME + "/api/tradeDetail/findAvailableTotalBalance";
    /**
     * 总金额
     */
    public static final String INITTOTALMONEY_URL = SERVER_NAME + "/api/tradeDetail/findTotalBalance";

    /**
     * 初始化交易明细
     */
    public static final String INITTRADEDETIAL_URL = SERVER_NAME + "/api/tradeDetail/findTradeDetailList";
    /**
     * 交易详细信息
     */
    public static final String FINDTRADEDETIALBYORDER_URL = SERVER_NAME + "/api/tradeDetail/findTradeDetailByOrder";
    /**
     * 查询该用户是否已经绑定
     */
    public static final String CHECKISBINDUSER_URL = SERVER_NAME + "/api/tradeAccount/getTradeAccount";
    /**
     * 绑定银行卡
     */
    public static final String BINDBANKCARD_URL = SERVER_NAME + "/api/tradeAccount/saveOrUpdateTradeAccount";
    /**
     * 检查验证码是否有效
     */
    public static final String CHECKSMSCODEBYMOBILE_URL = SERVER_NAME + "/api/sms/checkSmsCodeByMobile";
    /**
     * 查看提现记录
     */
    public static final String FINDTRADECASHLIST_URL = SERVER_NAME + "/api/tradeCash/findTradeCashList";

    /**
     * 查看提现细节
     */
    public static final String FINDTRADECASHDETAILLIST_URL = SERVER_NAME + "/api/tradeCash/findTradeCashDetailList";


    /**
     * 获取服务费
     */
    public static final String GETSERVICECHARGE_URL = SERVER_NAME + "/api/dic/getServiceCharge";
    /**
     * 确认提现
     */
    public static final String CONFIRMPAYMENT_URL = SERVER_NAME + "/api/llpay/confirmPayment";


    /**
     * 提现
     */
    public static final String PAYMENT_URL = SERVER_NAME + "/api/llpay/payment";
    /**
     * 支付协议
     */
    public static final String PAYMENTAGREE_URL = SERVER_NAME + "/api/tradeDetail/paymentAgree";
    /**
     * 初始化报表数据概览
     */
    public static final String GETDATAOVERVIEW_URL = SERVER_NAME + "/api/report/getDataOverview";
    /**
     * 初始化业务板块数据
     */
    public static final String GETBUSINESSSEGMENTS_URL = SERVER_NAME + "/api/report/getBusinessSegments";

    /**
     * 初始化支付饼状图
     */
    public static final String GETPAYTYPEREPORT_URL = SERVER_NAME + "/api/report/getpayTypeReport";
    /**
     * 初始化会员充值情况
     */
    public static final String GETMEMBERRECHARGE_URL = SERVER_NAME + "/api/report/getMemberRecharge";
    /**
     * 初始化会员充值列表
     */
    public static final String GETMEMBERRECHARGELIST_URL = SERVER_NAME + "/api/report/getMemberRechargeList";
    /**
     * 经营走势报表
     */
    public static final String GETOPERATINGTREND_URL = SERVER_NAME + "/api/report/getOperatingTrend";
    /**
     * 菜品占比
     */
    public static final String GETFOODPROPORTION_URL = SERVER_NAME + "/api/report/getFoodProportion";
    /**
     * 获取菜品分类下拉框
     */
    public static final String FINDFOODCATALOG_URL = SERVER_NAME + "/api/foodCatalog/findFoodCatalog";
    /**
     * 下拉框分页加载
     */
    public static final String GETFOODCLASSIFYPROPORTION_URL = SERVER_NAME + "/api/report/getFoodClassifyProportion";
    /**
     * 获取交接班
     */
    public static final String GETRSCHANGESHIFTSLIST_URL = SERVER_NAME + "/api/report/getRsChangeShiftsList";


    /**
     * 获取交接班详情
     */
    public static final String GETRESCHANGESHIFTSDETAIL_URL = SERVER_NAME + "/api/report/getResChangeShiftsDetail";


    /**
     * 获取异常内容
     */
    public static final String GETEXCEPTIONREPORT_URL = SERVER_NAME + "/api/report/getExceptionReport";
    /**
     * 创建店铺
     */
    public static final String CREATERESTAURANT_URL = SERVER_NAME + "/api/restaurant/createRestaurant";
    /**
     * 获取异常详情
     */
    public static final String GETEXCEPTIONREPORTDETAIL_URL = SERVER_NAME + "/api/report/getExceptionReportDetail";

    /**
     * 订单生成 （连连支付，生成二维码）
     */
    public static final String CREATE_ORDER_LIANLIAN = SERVER_NAME + "/api/llpay/createOrder";

    /**
     * 订单查询  查询二维码支付  支付结果）
     */
    public static final String QUERY_ORDER_LIANLIAN = SERVER_NAME + "/api/llpay/queryOrder";

//http://192.168.134.254:8080/zhenler-server//api/memberRechargeLog/getMemberRechargeLogList?resId=0000000055dd15670155ddd056ef0121&startTime=2017-07-01&endTime=2017-08-08
    /**
     * 获取会员列表
     */
    public static final String GET_MEMBERRECHARGELOG_LIST_URL = SERVER_NAME + "/api/memberRechargeLog/getMemberRechargeLogList";

    /**
     * 获取订单详情 /api/consumer/getConsumerDetail?resId=000000005c2536d5015c2e169199061f&id=c6fa12b9bad84f399936d66d56b96b95
     */
    public static final String GET_CONSUMERDETAIL_URL = SERVER_NAME + "/api/consumer/getConsumerDetail";

    /**
     * 获取城市地址
     */
    public static final String GET_REGIONBYPID_LIST_URL = SERVER_NAME + "/api/region/getRegionByPid";

    /**
     * 获取菜系
     */
    public static final String GET_DICLIST_LIST_URL = SERVER_NAME + "/api/dic/getDicList";

    /**
     * 获取订单详情列表
     */
    public static final String GET_CONSUMER_LIST_URL = SERVER_NAME + "/api/consumer/getConsumerList";

    /**
     * 获取所有省
     */
    public static final String GET_ALLPROVINCE_LIST_URL = SERVER_NAME + "/api/region/getAllProvince";

    /**
     * 修改用户信息
     */
    public static final String UPDATE_SHIRO_USER = SERVER_NAME + "/api/user/updateShiroUser";
 public static final String GET_SMS_CODE_URL = "";
}
