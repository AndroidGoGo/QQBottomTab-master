package com.xujun.fragmenttabhostdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.base.BaseFragmentAdapter;
import com.xujun.fragmenttabhostdemo.fragment.ItemFragement;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/16.
 */

public class ScreachActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    private TabLayout tabTitle;
    private ViewPager viewPagerContainer;
    private ArrayList<Fragment> mFragments;
    private int position = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        mFragments = new ArrayList<>();
        String titles[] = {"动态", "用户", "文章"};
        tabTitle = (TabLayout) findViewById(R.id.tl_activity_search);
        viewPagerContainer = (ViewPager) findViewById(R.id.pager);

        for (int i = 0; i < titles.length; i++) {
            ItemFragement itemFragement = ItemFragement.newInstance(titles[i]);
            tabTitle.addTab(tabTitle.newTab().setText(titles[i]),false);
            mFragments.add(itemFragement);
        }
        BaseFragmentAdapter baseFragmentAdapter = new BaseFragmentAdapter
                (getSupportFragmentManager(), mFragments, titles);

        viewPagerContainer.setAdapter(baseFragmentAdapter);
        viewPagerContainer.setOffscreenPageLimit(baseFragmentAdapter.getCount() - 1);
        viewPagerContainer.setCurrentItem(position);
        viewPagerContainer.addOnPageChangeListener(this);
        tabTitle.setOnTabSelectedListener(this);
       // viewPagerContainer.setCurrentItem(0);
        tabTitle.getTabAt(position).select();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText editText = (EditText) findViewById(R.id.et_inputOrderNumber);
        editText.clearFocus();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        tabTitle.getTabAt(position).select();
     }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

       viewPagerContainer.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {


    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        Log.e(this.getClass().getName(),tab.getText().toString().trim());

    }
}
