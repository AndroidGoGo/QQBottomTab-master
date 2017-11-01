package com.xujun.fragmenttabhostdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lzq.activity.demo.IMActivity;
import com.lzq.activity.demo.RedpackActivity;
import com.lzq.activity.demo.TestActivity;
import com.xujun.fragmenttabhostdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View view) {

        switch (view.getId()) {
            case R.id.btn_first_style:
                jump(FirstStyleActivity.class);
                break;
            case R.id.btn_second_style:
                jump(SecondStyleActivity.class);
                break;

            case R.id.btn_third_style:
                jump(ThreeActivity.class);
                break;

            case R.id.btn_four_style:
                jump(FourActivity.class);
                break;
            case R.id.btn_big_pic:
                jump(BigPicActivity.class);

                break;
            case R.id.btn_glide_demo:
                jump(GlideDemoActivity.class);
                break;
            case R.id.vp_demo:
                jump(ScreachActivity.class);

                break;
            case R.id.im_demoByWangyi:
                jump(IMActivity.class);
                break;

            case  R.id.im_demoByHuanxin:

                jump(RedpackActivity.class);
                break;

            case R.id.test_act:
                jump(TestActivity.class);


            default:
                break;
        }
    }

    public void jump(Class<? extends Activity> clz) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        startActivity(intent);
    }
}
