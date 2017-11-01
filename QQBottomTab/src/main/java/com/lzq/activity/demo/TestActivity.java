package com.lzq.activity.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

import com.lzq.adpter.DouBanMovieAdapter;
import com.lzq.modle.BaseResponse;
import com.lzq.net.NewApi;
import com.lzq.net.NewBaseNet;
import com.lzq.widget.RefreshLayout;
import com.lzq.widget.dialog.HbDialog;
import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.net.SimpleNetResponseListener;

/**
 * Created by Administrator on 2017/9/21.
 */

public class TestActivity extends BaseActivity implements View.OnClickListener, RefreshLayout.RefreshCallBack {

    private HbDialog hbDialog;
    private Button button;
    private Button button_getWeather;
    private RecyclerView mRvDoubanMovie;
    private DouBanMovieAdapter mDouBanMovieAdapter;
//    private RefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();


    }

    private void initView() {
        mRvDoubanMovie = (RecyclerView) findViewById(R.id.rv_doubanMovieDemo);
      //  mRefreshLayout = (RefreshLayout) findViewById(R.id.refresh);
      //  mRefreshLayout.setRefreshCallBack(this);
        mDouBanMovieAdapter = new DouBanMovieAdapter(this);
        mRvDoubanMovie.setLayoutManager(new LinearLayoutManager(this));
        mRvDoubanMovie.setAdapter(mDouBanMovieAdapter);
        button = (Button) findViewById(R.id.btn_showDialog);
        button_getWeather = (Button) findViewById(R.id.btn_getWeather);
        button.setOnClickListener(this);
        button_getWeather.setOnClickListener(this);
        hbDialog = new HbDialog(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_showDialog:
                hbDialog.show();
                break;

            case R.id.btn_getWeather:

                getWeather();
        }

    }

    private int start = 0;
    private int count = 10;

    private void getWeather() {

        new NewBaseNet().setMethod(NewApi.MOBILE).addParam("act", "mb_store").addParam("op", "storeurl")
                .addParam("store_id","1")
                .setOnNetResponseListener(new SimpleNetResponseListener<BaseResponse<String>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        Log.e("开始", "开始请求数据");
                    }

                    @Override
                    public void onSuccess(String data) {
                        super.onSuccess(data);

                        //  String response = data.getSubjects();
                        Log.e("服务器返回的数据", data);//respone  用Bean来解析就行了
                     /*   List<Subject> subjectList = new Gson().fromJson(data, new TypeToken<List<Subject>>() {
                        }.getType());
                        for (int i = 0; i < subjectList.size(); i++) {
                            Log.e("解析Json", subjectList.get(i).toString());
                        }
                        mDouBanMovieAdapter.loadDatas(subjectList);*/


                    }

                    @Override
                    public void onFailure(Throwable t) {
                        super.onFailure(t);


                    }
                }).build().onNetLoad();
    }

    private void refreshUi() {


    }


    @Override
    public void upRefresh(Scroller scroller, int y) {


    }

    @Override
    public void downLoad(Scroller scroller, int y) {
        start += 1;
        count += 10;
        getWeather();
    }
}
