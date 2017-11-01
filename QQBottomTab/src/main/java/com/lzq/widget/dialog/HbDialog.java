package com.lzq.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.lzq.util.AppUtils;
import com.xujun.fragmenttabhostdemo.R;

/**
 * Created by Administrator on 2017/9/21.
 */

public class HbDialog extends BaseDialog {
    private Context mContext;

    private View view;

    public HbDialog(Context context) {
       this(context, R.style.CustomLoading);
        mContext = context;
    }

    public HbDialog(Context context, int style) {
        super(context, style, 0.6f, 0.3f);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_demo, null);
        setContentView(view);
        view.findViewById(R.id.btn_cancel).setOnClickListener(this);
        view.findViewById(R.id.btn_true).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {

            case R.id.btn_cancel:
                AppUtils.showMessage(mContext, "红包未领取");
                dismiss();
                break;
            case R.id.btn_true:
                AppUtils.showMessage(mContext, "恭喜您获得100元！！");
                dismiss();
        }
    }
}
