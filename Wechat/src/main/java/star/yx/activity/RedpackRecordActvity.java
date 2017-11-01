package star.yx.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import star.yx.adapter.RedpackRecordAdapter;
import star.yx.modul.RedPackModul;
import star.yx.tabview.R;

/**
 * Created by ${廖昭启} on 2017/10/24.
 */

public class RedpackRecordActvity extends Activity implements View.OnClickListener {

    private Dialog dialog;
    private View inflate;
    private ImageView mIvChooseRecRcrodType;
    private RecyclerView mRvRedpackRecored;
    private List<RedPackModul> mRedPackModulList;
    private RedpackRecordAdapter mRedpackRecordAdapter;
    private ImageView mIvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packge_record);
        mRedPackModulList = new ArrayList<>();
        initDatas();
        initView();

        initDialog();
        initListener();

    }

    private void initDatas() {
        for (int i = 0; i < 17; i++) {

            RedPackModul modul = new RedPackModul();

            Random rd = new java.util.Random();
            int type = rd.nextInt(2);
            DecimalFormat df = new DecimalFormat("#.00");
            String format = df.format(Math.random() * 10);
            int count = rd.nextInt(10);


            modul.setRedPackType(type);
            modul.setMoney(Double.parseDouble(format));
            modul.setDates("2017-10-22");
            modul.setStatus(rd.nextInt(3));
            modul.setCount(count);
            modul.setRec(rd.nextInt(count == 0 ? 1 : count));
            mRedPackModulList.add(modul);

        }


    }

    private void initListener() {
        mIvChooseRecRcrodType.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
    }

    private void initView() {

        mIvBack = (ImageView) findViewById(R.id.img_return);
        mIvChooseRecRcrodType = (ImageView) findViewById(R.id.iv_chooseRecord_Type);

        mRvRedpackRecored = (RecyclerView) findViewById(R.id.rv_redpackRecored);
        mRedpackRecordAdapter = new RedpackRecordAdapter(this);
        mRvRedpackRecored.setLayoutManager(new LinearLayoutManager(this));
        mRvRedpackRecored.setAdapter(mRedpackRecordAdapter);
        mRedpackRecordAdapter.loadDatas(mRedPackModulList);


    }

    private void initDialog() {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.bottom_dialog, null);
        //初始化控件
        TextView tv_ByRec = (TextView) inflate.findViewById(R.id.tv_byRec);
        TextView tvBysend = (TextView) inflate.findViewById(R.id.tv_bySend);
        tv_ByRec.setOnClickListener(this);
        tvBysend.setOnClickListener(this);


        //将布局设置给Dialog
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(true);

     /*   DisplayMetrics dm = new DisplayMetrics();
       getWindowManager().getDefaultDisplay().getMetrics(dm);
        Window wm = getWindow();
        WindowManager.LayoutParams lp = wm.getAttributes();
        lp.width = dm.widthPixels;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        lp.y = 20;*/
        Window dialogWindow = dialog.getWindow();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //获得窗体的属性
        WindowManager.LayoutParams lp =dialogWindow.getAttributes();
        lp.width = (int)(display.getWidth()); //设置宽度

        dialogWindow.setGravity(Gravity.BOTTOM);


      //将属性设置给窗体
        dialogWindow.setAttributes(lp);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_return:

                finish();
                break;

            case R.id.tv_byRec:
                toChooseRec();
                break;

            case R.id.tv_bySend:
                toChooseSend();

                break;
            case R.id.iv_chooseRecord_Type:

                dialog.show();//

                break;
        }
    }

    private void toChooseSend() {
        List<RedPackModul> moduls = new ArrayList<>();
        for (int i = 0; i < mRedPackModulList.size(); i++) {
            if (mRedPackModulList.get(i).getRedPackType() == 1) {
                moduls.add(mRedPackModulList.get(i));
            }
        }
        mRedpackRecordAdapter.loadDatas(moduls);
        dialog.dismiss();


    }

    private void toChooseRec() {

        List<RedPackModul> moduls = new ArrayList<>();
        for (int i = 0; i < mRedPackModulList.size(); i++) {
            if (!(mRedPackModulList.get(i).getRedPackType() == 1)) {
                moduls.add(mRedPackModulList.get(i));
            }
        }
        mRedpackRecordAdapter.loadDatas(moduls);
        dialog.dismiss();
    }

}
