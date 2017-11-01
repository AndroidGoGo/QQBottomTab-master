package com.xujun.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.xujun.fragmenttabhostdemo.R;

/**
 * Created by Administrator on 2017/9/13.
 */

public class BigPicActivity extends AppCompatActivity {

    private float mx;
    private float my;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibig_pic);
        final ImageView bigImageView = (ImageView) findViewById(R.id.big_imageView);
        DisplayMetrics dm = new DisplayMetrics();
        int widthPixels = dm.widthPixels;
        int heightPixels = dm.heightPixels;
        bigImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                float curX, curY;

                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        mx = motionEvent.getX();
                        my = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        curX = motionEvent.getX();
                        curY = motionEvent.getY();
                        bigImageView.scrollBy((int) (mx - curX), (int) (my - curY));
                        mx = curX;
                        my = curY;
                        break;
                    case MotionEvent.ACTION_UP:
                        curX = motionEvent.getX();
                        curY = motionEvent.getY();
                        bigImageView.scrollBy((int) (mx - curX), (int) (my - curY));
                        break;
                }
                return true;
            }
        });
    }
}
