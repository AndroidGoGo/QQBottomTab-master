package com.lzq.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.widget.ViewUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.lzq.modle.HttpResponseModel;
import com.lzq.util.AppUtils;
import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.base.BaseHttpHandler;
import com.xujun.fragmenttabhostdemo.base.HttpHandler;


/**
 * Created by YI on 2016/9/23.
 */

public class BaseDialog extends Dialog implements View.OnClickListener,
        DialogInterface.OnShowListener, DialogInterface.OnDismissListener, HttpHandler {
    public View view;
    protected Context context;
    protected LayoutInflater inflater;
    protected ViewGroup.LayoutParams layoutParams =
            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    protected DisplayMetrics displayMetrics;
    protected BaseHttpHandler baseHttpHandler = new BaseHttpHandler(this);

    public BaseDialog(Context context) {
        this(context, R.style.CustomLoading);
    }

    public BaseDialog(Context context, int style) {
        super(context, style);
        this.context = context;
        displayMetrics = context.getResources().getDisplayMetrics();
        setOnShowListener(this);
        setOnDismissListener(this);
        fullWindowW(1);
        inflater = LayoutInflater.from(context);
    }

    public BaseDialog(Context context, int style, float fullWindow) {
        super(context, style);
        this.context = context;
        displayMetrics = context.getResources().getDisplayMetrics();
        setOnShowListener(this);
        setOnDismissListener(this);

        fullWindowWH(fullWindow);

        inflater = LayoutInflater.from(context);
    }

    public BaseDialog(Context context, int style, float fullWindowWidth, float fullWindowHeight) {
        super(context, style);
        this.context = context;
        displayMetrics = context.getResources().getDisplayMetrics();
        setOnShowListener(this);
        setOnDismissListener(this);

        fullWindowWH(fullWindowWidth, fullWindowHeight);

        inflater = LayoutInflater.from(context);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view, layoutParams);
    }

    @Override
    public void onClick(View v) {
    //    ViewUtils.hideKeyboard(this, (Activity) context);
    }


    protected void fullWindowWH() {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
    }

    protected void fullWindowWH(float fullWindow) {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = (int) (displayMetrics.widthPixels * fullWindow);
        layoutParams.height = (int) (displayMetrics.heightPixels * fullWindow);
    }

    protected void fullWindowWH(float fullWindowWidth, float fullWindowHeight) {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = (int) (displayMetrics.widthPixels * fullWindowWidth);
        layoutParams.height = (int) (displayMetrics.heightPixels * fullWindowHeight);
    }

    /**
     * 设置为窗口宽度的几分之一
     */
    protected void fullWindowW(float precent) {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = (int) ((float) displayMetrics.widthPixels / precent) -
                (int) (2 * context.getResources().getDimension(R.dimen._10dp));
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    protected void fullWindowTop() {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
    }

    protected void fullWindowBottom() {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
    }


    protected void fullWindowBottom(float precent) {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = (int) ((float) displayMetrics.widthPixels / precent);
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
    }


    protected void fullWindowRight(float precent) {
        layoutParams = getWindow().getAttributes();
        Rect rect = new Rect();
        View v = getWindow().getDecorView();
        v.getWindowVisibleDisplayFrame(rect);
        layoutParams.width = (int) ((float) displayMetrics.widthPixels / precent);
        Window window = getWindow();
        window.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
       // ViewUtils.hideKeyboard(this, (Activity) context);
    }

    @Override
    public void onShow(DialogInterface dialog) {

        //ViewUtils.hideKeyboard(this, (Activity) context);
    }



    @Override
    public void httpSuccess(HttpResponseModel message) throws Exception {

    }

    @Override
    public void httpErr(HttpResponseModel message) throws Exception {

    }
}
