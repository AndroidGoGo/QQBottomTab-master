package com.xujun.fragmenttabhostdemo;

import android.support.multidex.MultiDexApplication;

/**
 * Created by Administrator on 2017/9/14.
 */

public class App extends MultiDexApplication {
    public  static App app ;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

       // EaseUI.getInstance().init(this,null);
       // EMClient.getInstance().setDebugMode(true);
    }


}
