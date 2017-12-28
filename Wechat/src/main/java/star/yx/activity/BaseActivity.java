package star.yx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ${廖昭启} on 2017/11/2.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewById());
    }

    public abstract int getContentViewById();

    /**
     * @param clazz
     * @param bundle
     * 不带返回值的页面跳转
     */
    public void startNewActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * @param tClass
     * @param bundle
     * @param requestCode
     * 带返回值的页面跳转
     */
    public void startNewActivityForResult(Class<?> tClass,Bundle bundle,int requestCode){
        Intent  intent = new Intent(this,tClass);
        if (bundle!=null){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requestCode);

    }



}
