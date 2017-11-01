package com.xujun.fragmenttabhostdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


import com.xujun.dialog.PermissionTipDialog;

import java.util.ArrayList;
import java.util.List;


/**
 * 创建人 zhengpf
 * 时间 2017/5/10
 * 类说明:权限处理工具类
 */

public class PermissionUtil {

    private static final String TAG = PermissionUtil.class.getSimpleName();

    //App运行时权限
    public static final int REQUEST_APP_PERMISSION_CODE = 0;

    //定位
    public static final int REQUEST_LOCATION_PERMISSION_CODE = 1;

    //相机
    public static final int REQUEST_CAMERA_PERMISSION_CODE = 2;

    //录音
    public static final int REQUEST_MICROPHONE_PERMISSION_CODE = 3;

    //联系人
    public static final int REQUEST_CONTACT_PERMISSION_CODE = 4;

    //外部存储
    public static final int REQUEST_STORAGE_PERMISSION_CODE = 5;

    //电话
    public static final int REQUEST_PHONE_PERMISSION_CODE = 6;

    /**
     * 判断SDK版本是否在6.0及以上
     * @return
     */
    public static boolean isMNC(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            return true;
        }
        return false;
    }



    /**
     * 检测权限状态
     * @param context
     * @param permission
     * @return trues 权限已授予 falses 权限未授予
     */
    public static boolean checkPermissionStatus(Context context, String permission){
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }

    /**
     * 申请权限(单个)
     * @param activity
     * @param permission
     * @param permissionRequestCode
     */
    public static void requestPermission(Activity activity, String permission, int permissionRequestCode){
        ActivityCompat.requestPermissions(activity, new String[]{permission}, permissionRequestCode);
    }


    /**
     * 申请权限(多个)
     * @param activity
     * @param permissions
     * @param permissionRequestCode
     */
    public static void requestPermission(Activity activity, List<String> permissions, int permissionRequestCode){
        ActivityCompat.requestPermissions(activity, permissions.toArray(new String[permissions.size()]), permissionRequestCode);
    }

    /**
     * 同时申请多个权限,调用这一个方法即可
     * 处理权限验证结果
     * @param activity
     * @param permissionList
     * @param requestCode
     */
    public static boolean dealCheckPermissionResult(Activity activity, List<String> permissionList, int requestCode){
        List<String> deniedPermission = new ArrayList<String>();
        if (null != permissionList && !permissionList.isEmpty()){
            for (String data : permissionList) {
                if (!checkPermissionStatus(activity, data)){
                    deniedPermission.add(data);
                }
            }
        }

        if (!deniedPermission.isEmpty()){
            //不为空,则说明有权限未被允许使用,要进行权限申请
            requestPermission(activity, deniedPermission, requestCode);
            return false;
        }else {
            return true;
        }
    }

    /**
     * 显示设置权限对话框
     */
    public static void showPermissionSetDialog(final Context context){
        final PermissionTipDialog dialog = new PermissionTipDialog(context);
        dialog.show();
        dialog.setOnClickChooseListener(new PermissionTipDialog.OnClickChooseListener() {
            @Override
            public void onClickChoose(int choice) {
                if (choice == 0){
                    startAppSettings(context);
                }
                dialog.dismiss();
            }
        });
    }

    // 启动应用的设置
    private static void startAppSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
