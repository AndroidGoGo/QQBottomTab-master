package star.yx.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import star.yx.adapter.GruopRedpackDetialAapter;
import star.yx.modul.RedPackGruopDetialModul;
import star.yx.tabview.R;
import star.yx.widegt.ArcHeaderView;

/**
 * Created by ${廖昭启} on 2017/10/24.
 */

public class GruopRedpackDetialActivity extends Activity {
    @BindView(R.id.img_return)
    ImageView mImgReturn;
    @BindView(R.id.tv_redPacType)
    TextView mTvRedPacType;
    @BindView(R.id.arcHeader)
    ArcHeaderView mArcHeader;
    @BindView(R.id.tv_tip)
    TextView mTvTip;
    @BindView(R.id.rv_redpackDetial)
    RecyclerView mRvRedpackDetial;
    private List<RedPackGruopDetialModul> mRedPackGruopDetialModulList    = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gruop_redpackge_detial);
        ButterKnife.bind(this);

        initDatas();
        initView();
    }

    private void initDatas() {
        for (int i = 0; i < 5; i++) {
            RedPackGruopDetialModul  redPackGruopDetialModul = new RedPackGruopDetialModul();
            redPackGruopDetialModul.setTime(getCurrentTime());

            mRedPackGruopDetialModulList.add(redPackGruopDetialModul);

        }




    }

    private void initView() {
        ArcHeaderView arcHeaderView = (ArcHeaderView) findViewById(R.id.arcHeader);
        arcHeaderView.setColor(Color.parseColor("#FF3030"),Color.parseColor("#FF7F50"));
        GruopRedpackDetialAapter gruopRedpackDetialAapter = new GruopRedpackDetialAapter(this);
        mRvRedpackDetial.setLayoutManager(new LinearLayoutManager(this));
        mRvRedpackDetial.setAdapter(gruopRedpackDetialAapter);
        gruopRedpackDetialAapter.loadDatas(mRedPackGruopDetialModulList);

    }

    @OnClick(R.id.img_return)
    public void onViewClicked() {
        finish();
    }
    private String getCurrentTime() {

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);


    }
}
