package com.xujun.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.adapter.GlideDemoAdapter;

/**
 * Created by Administrator on 2017/9/13.
 */

public class GlideDemoActivity extends AppCompatActivity {

    private RecyclerView rvGlideDemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_demo);
        rvGlideDemo = (RecyclerView) findViewById(R.id.rv_glideDemo);
        GlideDemoAdapter glideDemoAdapter = new GlideDemoAdapter(this);
        rvGlideDemo.setLayoutManager(new LinearLayoutManager(this));
        rvGlideDemo.setAdapter(glideDemoAdapter);


    }

}
