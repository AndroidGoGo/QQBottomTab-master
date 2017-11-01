package com.lzq.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lzq.activity.demo.BaseActivity;
import com.lzq.modle.HttpResponseModel;
import com.lzq.util.AppUtils;
import com.xujun.fragmenttabhostdemo.activity.MainActivity;
import com.xujun.fragmenttabhostdemo.base.BaseHttpHandler;
import com.xujun.fragmenttabhostdemo.base.HttpHandler;



import org.json.JSONObject;

import java.util.List;

/**
 * Created by YI on 2016/4/15.
 * 基础帧
 */
public class BaseFragment extends Fragment implements View.OnClickListener, HttpHandler{
    protected BaseHttpHandler baseHttpHandler = new BaseHttpHandler(this);
    protected Context context;
    public FragmentManager fragmentManager;
    protected DisplayMetrics displayMetrics;
    protected View view;
    public FragmentManager mFragmentManager;
    protected BaseActivity baseActivity;
    protected String checkTag;
    protected JSONObject params = new JSONObject();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getFragmentManager();
        fragmentManager = getChildFragmentManager();
        context = getActivity();
        displayMetrics = getResources().getDisplayMetrics();
        baseActivity = (BaseActivity) getActivity();
        //baseActivity.attachKeyDown(this);

    }

    //检验是否处于可见状态
    public boolean isShow() {
        boolean bl = isVisible();
        Fragment fragment = getParentFragment();
        while (fragment != null && bl) {
            bl = fragment.isVisible();
            fragment = fragment.getParentFragment();
        }
        return bl;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        baseHttpHandler = null;
     //   baseActivity.unAttachKeyDown(this);
    }


    protected <T extends View> T findViewById(int id) {
        return (T) view.findViewById(id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        onResume();
        //遍历子帧，刷新界面
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null && !hidden) {
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                if (fragment.isVisible()) {
                    fragment.onHiddenChanged(false);
                    break;
                }
            }
        }
    }

    @Override
    public void httpErr(HttpResponseModel message) throws Exception {
        AppUtils.showMessage(context, new String(message.getResponse()));
    }

    @Override
    public void httpSuccess(HttpResponseModel message) throws Exception {

    }

    @Override
    public void onClick(View v) {
       // ViewUtils.hideKeyboard((Activity) context);
    }

    protected void clearAllFragment() {
        List<Fragment> fragments = fragmentManager.getFragments();
      //  Logger.log(fragments);
        if (fragments != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (transaction != null) {
                for (Fragment fragment : fragments) {
                    if (fragment != null)
                        transaction.remove(fragment);
                    fragment.onDestroy();
                }
                transaction.commit();
            }
        }
    }



}
