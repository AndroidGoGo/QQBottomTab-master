package com.lzq.activity.demo;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzq.adpter.DouBanMovieAdapter;
import com.lzq.modle.BaseResponse;
import com.lzq.modle.Subject;
import com.lzq.net.NewApi;
import com.lzq.net.NewBaseNet;
import com.lzq.net.UrlBase;
import com.lzq.widget.RefreshLayout;
import com.lzq.widget.dialog.HbDialog;
import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.net.SimpleNetResponseListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
                //refreshUi();
                getWeather();

        }

    }

    private int start = 0;
    private int count = 10;

    private void getWeather() {
        // .addParam("key","5112902d41b4afbe45aad32f4128f7a8")
     /*   new NewBaseNet().setMethod(NewApi.WX_NEWS)
                .setBaseUrl("http://121.42.225.27:8087")
                .setDataName("newslist")
                .addParam("num", 10)
                .setOnNetResponseListener(new SimpleNetResponseListener<BaseResponse<String>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onSuccess(String data) {
                        super.onSuccess(data);


                    }
                }).build().onNetLoad();*/
        String path = Environment.getExternalStorageDirectory() + File.separator + "sp003";

        new NewBaseNet().setMethod("appLogin").addFile(getImagePathFromSD("/storage/emulated/0/spa003/").get(0))
                .addParam("user_id", "4aa2b2b6874b460b8f7f04326dc6e431")
                .addParam("title", "你是我的小宝贝")
                .addParam("circle_id", "147486260014205")
                .addParam("title_content", "你是我的小宝贝你是我的小宝贝你是我的小宝贝")
                .setOnNetResponseListener(new SimpleNetResponseListener<BaseResponse<String>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        Log.e("测试找师傅接口", "开始。。。。");
                    }

                    @Override
                    public void onSuccess(String data) {
                        super.onSuccess(data);
                        Log.e("找师傅返回的数据", "========" + data);

                    }
                }).build().onNetLoad();


    }

    private void refreshUi() {

        new NewBaseNet().setBaseUrl(UrlBase.BASE_NET_URL_MOVIE).setMethod(NewApi.TOP250).setDataName("subjects").addParam("count", "10").addParam("start", "1")
                .setOnNetResponseListener(new SimpleNetResponseListener<BaseResponse<String>>() {

                    @Override
                    public void onSuccess(String data) {
                        super.onSuccess(data);
                        List<Subject> subjectList = new Gson().fromJson(data, new TypeToken<List<Subject>>() {
                        }.getType());
                        for (int i = 0; i < subjectList.size(); i++) {
                            Log.e("解析Json", subjectList.get(i).toString());
                        }
                        mDouBanMovieAdapter.loadDatas(subjectList);
                    }

                }).build().onNetLoad();

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


    /**
     * 检查扩展名，得到图片格式的文件
     *
     * @param fName 文件名
     * @return
     */
    private boolean checkIsImageFile(String fName) {
        boolean isImageFile = false;
        // 获取扩展名
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("jpg") || FileEnd.equals("png") || FileEnd.equals("gif")
                || FileEnd.equals("jpeg") || FileEnd.equals("bmp")) {
            isImageFile = true;
        } else {
            isImageFile = false;
        }
        return isImageFile;
    }


    private List<File> getImagePathFromSD(String filePath) {
        Log.e("路径","======"+filePath);
        // 图片列表
        List<File> imagePathList = new ArrayList<File>();
        // 得到sd卡内image文件夹的路径   File.separator(/)
        // 得到该路径文件夹下所有的文件
        File fileAll = new File(filePath);
        File[] files = fileAll.listFiles();
        // 将所有的文件存入ArrayList中,并过滤所有图片格式的文件
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (checkIsImageFile(files[i].getPath())) {

                imagePathList.add(files[i]);
            }
        }
        // Collections.sort(imagePathList, new FileComparator());
        return imagePathList;
    }

}
