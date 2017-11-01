package star.yx;

import android.app.Application;

/**
 * Created by Administrator on 2017/9/14.
 */

public class App extends Application {
    public  static App app ;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

       // EaseUI.getInstance().init(this,null);
       // EMClient.getInstance().setDebugMode(true);
    }


}
