package com.lzq.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


/**
 * Created by YI on 2016/8/30.
 */
public class AppUtils {
    private static Toast toast;

    public static final int SerialNumberLength = 5;//流水号长度
    /**
     * 图像加载配置参数
     */
/*    public static final DisplayImageOptions options = new DisplayImageOptions.Builder()
            .bitmapConfig(Bitmap.Config.RGB_565)
            .cacheOnDisk(true)
            .resetViewBeforeLoading(true)
            .cacheInMemory(true).considerExifParams(true).build();*/

    /**
     * 提示信息
     */
    public static final void showMessage(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public static final void showMessage(Context context, int msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 弹出对话框
     */
    public static final void showDialog(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) return;
        dialog.show();
    }

    public static final void closeDialog(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) return;
        dialog.dismiss();
    }


    // 获得本周一0点时间
    public static long getWeekStar() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTimeInMillis();
    }

    // 获得本周日24点时间
    public static long getWeekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getWeekStar());
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTimeInMillis();
    }

    // 获得本月第一天0点时间
    public static long getMonthStar(int before) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - before, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }

    // 获得本月第一天0点时间
    public static long getMonthStar() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }


    // 获得本月最后一天24点时间
    public static long getMonthEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTimeInMillis();
    }

    // 获得本月第一天0点时间
    public static long getMonthStar(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        mCalendar.set(Calendar.DAY_OF_MONTH, mCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return mCalendar.getTimeInMillis();
    }


    // 获得本月最后一天24点时间
    public static long getMonthEnd(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), 24, 59, 59);
        mCalendar.set(Calendar.DAY_OF_MONTH, mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return mCalendar.getTimeInMillis();
    }

    /**
     * 获取一天的开始
     */
    public static final long getDayStar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一天的结束
     */
    public static final long getDayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一天的结束
     */
    public static final long getDayEnd(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return mCalendar.getTimeInMillis();
    }

    /**
     * 获取一天的开始
     */
    public static final long getDayStar(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return mCalendar.getTimeInMillis();
    }

    /**
     * 获取一周的结束
     */
    public static final long getWeekEnd(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(Calendar.DAY_OF_WEEK, mCalendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        return mCalendar.getTimeInMillis();
    }

    /**
     * 获取一周的开始
     */
    public static final long getWeekStar(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(Calendar.DAY_OF_WEEK, mCalendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        return mCalendar.getTimeInMillis();
    }


    /**
     * 获取一年的开始
     */
    public static final long getYearStar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), 0, 0, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    public static final long getYearStar(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(mCalendar.get(Calendar.YEAR), 0, 0, 0, 0, 0);
        return mCalendar.getTimeInMillis();
    }

    public static final long getYearEnd(Calendar calendar) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(calendar.getTimeInMillis());
        mCalendar.set(mCalendar.get(Calendar.YEAR), mCalendar.getActualMaximum(Calendar.MONTH), mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH),
                mCalendar.getActualMaximum(Calendar.HOUR_OF_DAY), mCalendar.getActualMaximum(Calendar.MINUTE), mCalendar.getActualMaximum(Calendar.SECOND));
        return mCalendar.getTimeInMillis();
    }

    //根据时间间隔来判断是按什么来划分区段
    public static final int timeGap(long startTime, long endTime) {
        if (endTime - startTime <= 24 * 60 * 60 * 1000) {//按小时
            return 0;
        } else if (endTime - startTime <= 31 * 24 * 60 * 60 * 1000) {//按天
            return 1;
        } else {//按月
            return 2;
        }
    }

    public static final boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * 日期格式化
     */
    public static final String dateFormat(String str, long date) {
        SimpleDateFormat format = new SimpleDateFormat(str);
        return format.format(new Date(date));
    }

    /**
     * 日期格式化
     */
    public static final String dateFormat(long date, String str) {
        SimpleDateFormat format = new SimpleDateFormat(str);
        return format.format(new Date(date));
    }

    public static final double formatDouble(double value, int leg) {
        try {
            if (value == Double.NaN) return 0;
            value += 0.001;
            StringBuffer sb = new StringBuffer("0");
            if (leg > 0) {
                for (int i = 0; i < leg; i++) {
                    if (i == 0) {
                        sb.append(".");
                    }
                    sb.append("0");
                }
            }
            DecimalFormat format = new DecimalFormat(sb.toString());
            return Double.parseDouble(format.format(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static final String formatDouble(double value) {
        if (value == Double.NaN) return "0";
        value += 0.001;
        StringBuffer sb = new StringBuffer("0.00");
        DecimalFormat format = new DecimalFormat(sb.toString());
        return format.format(value);

    }

    public static final double formatDoubleValue(double value) {
        try {
            value += 0.001;
            StringBuffer sb = new StringBuffer("0.00");
            DecimalFormat format = new DecimalFormat(sb.toString());
            return Double.parseDouble(format.format(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 生成数据库ID
     */
    public static final String generalDbId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取十位随机数
     * 生成优惠券号
     *
     * @return
     */
    public static String generalCouponNum() {
        Random r = new Random();
        long num = Math.abs(r.nextLong() % 10000000000L);
        String s = String.valueOf(num);
        for (int i = 0; i < 10 - s.length(); i++) {
            s = "0" + s;
        }
        return s;
    }

    static final Object object = new Object();



    /**
     * 系统配置进行操作
     *
     * @param values 更新的数据值
     */
 /*   public synchronized static final StatementBean.SystemConfig getSystemConfig(ContentValues values) {
        synchronized (object) {
            DbHelperLocal dbHelperLocal = App.app.getLocalDb();
            SQLiteDatabase db = dbHelperLocal.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from " + DbHelperLocal.SYSTEMCONFIG_TABLE, null);
            StatementBean.SystemConfig systemConfig = ProtoBufUtils.cursorToProtobufSingle(StatementBean.SystemConfig.newBuilder(), cursor);
            if (values != null) {
                if (StringUtils.isNull(systemConfig.getId())) {//没有插入过配置
                    values.put("id", AppUtils.generalDbId());
                    values.put("createTime", System.currentTimeMillis());
                    values.put("lastUpdateTime", System.currentTimeMillis());
                    db.insert(DbHelperLocal.SYSTEMCONFIG_TABLE, null, values);
                } else {
                    db.update(DbHelperLocal.SYSTEMCONFIG_TABLE, values, null, null);
                }
                cursor = db.rawQuery("select * from " + DbHelperLocal.SYSTEMCONFIG_TABLE, null);
                systemConfig = ProtoBufUtils.cursorToProtobufSingle(StatementBean.SystemConfig.newBuilder(), cursor);
            }
            return systemConfig;
        }
    }*/

    /**
     * 获取本机IP
     *
     * @param context 上下文
     */
    public static final String getClientIp(Context context) {

        //获取wifi服务
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启
        if (!wifiManager.isWifiEnabled()) {
            return "";
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String ip = intToIp(ipAddress);
        return ip;

//        try {
//            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
//                NetworkInterface intf = en.nextElement();
//                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
//                    InetAddress inetAddress = enumIpAddr.nextElement();
//                    if (!inetAddress.isLoopbackAddress()
//                            && !inetAddress.isLinkLocalAddress()) {
//                        return inetAddress.getHostAddress().toString();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
    }

    private static String intToIp(int i) {

        return (i & 0xFF ) + "." +
                ((i >> 8 ) & 0xFF) + "." +
                ((i >> 16 ) & 0xFF) + "." +
                ( i >> 24 & 0xFF) ;
    }

    /**
     * 获取本地Mac地址
     *
     * @param context
     * @return
     */
  /*  public static String getClientMacAddress(Context context) {
        String mac_s = SharedPreferencesUtils.getString(context, IConstant.MainServer.CURRENT_MAC_ADDRESS);
        if (TextUtils.isEmpty(mac_s)) {
            try {
                byte[] mac;
                NetworkInterface ne = NetworkInterface.getByInetAddress(InetAddress
                        .getByName(getClientIp(context)));
                mac = ne.getHardwareAddress();
                mac_s = byte2hex(mac).toLowerCase();
                SharedPreferencesUtils.commit(context, IConstant.MainServer.CURRENT_MAC_ADDRESS, mac_s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mac_s;
    }*/

    /**
     * 判断本机是否主机
     *
     *
     * @return
     */
/*    public static boolean isCurrentMainServer(Context context) {
        String mainServerMac = SharedPreferencesUtils.getString(context, IConstant.MainServer.MAIN_SERVER_MAC_ADDRESS);
        if (TextUtils.isEmpty(mainServerMac)) {
            return false;
        } else {
            return getClientMacAddress(context)
                    .equals(mainServerMac);
        }
    }*/

    public static String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer(b.length);
        String stmp = "";
        int len = b.length;
        for (int n = 0; n < len; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs.append("0").append(stmp);
            else {
                hs = hs.append(stmp);
            }
        }
        return String.valueOf(hs);
    }

    /**
     * Check if this device has a camera
     */
    public static final boolean checkCameraHardware(Context context) {
        return hasBackFacingCamera();
    }


    private static boolean checkCameraFacing(final int facing) {
        if (getSdkVersion() < Build.VERSION_CODES.GINGERBREAD) {
            return false;
        }
        final int cameraCount = Camera.getNumberOfCameras();
        Camera.CameraInfo info = new Camera.CameraInfo();
        for (int i = 0; i < cameraCount; i++) {
            Camera.getCameraInfo(i, info);
            if (facing == info.facing) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasBackFacingCamera() {
        final int CAMERA_FACING_BACK = 0;
        return checkCameraFacing(CAMERA_FACING_BACK);
    }

    public static boolean hasFrontFacingCamera() {
        final int CAMERA_FACING_BACK = 1;
        return checkCameraFacing(CAMERA_FACING_BACK);
    }

    public static int getSdkVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * MD5
     *
     * @param plainText 待加密文本
     */
    public static String Md5(String plainText) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }
}
