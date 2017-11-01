package star.yx.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import star.yx.utils.PriceFormaterUtils;
import star.yx.tabview.R;


/**
 * Created by ${廖昭启} on 2017/10/24.
 */

public class RedpackActivity extends Activity {

    @BindView(R.id.img_return)
    ImageView mImgReturn;
    @BindView(R.id.title_name)
    TextView mTitleName;
    @BindView(R.id.title_right)
    TextView mTitleRight;
    @BindView(R.id.tv_redPac_count)
    TextView mTvRedPacCount;
    @BindView(R.id.et_input_count)
    EditText mEtInputCount;
    @BindView(R.id.tv_group_acount)
    TextView mTvGroupAcount;
    @BindView(R.id.tv_redPacke_type)
    TextView mTvRedPackeType;
    @BindView(R.id.tv_tip)
    TextView mTvTip;
    @BindView(R.id.tv_redPac_unit)
    TextView mTvRedPacUnit;
    @BindView(R.id.et_input_money)
    EditText mEtInputMoney;
    @BindView(R.id.tv_current_redPack_type)
    TextView mTvCurrentRedPackType;
    @BindView(R.id.btn_change_redPack_type)
    Button mBtnChangeRedPackType;
    @BindView(R.id.et_blessing)
    EditText mEtBlessing;
    @BindView(R.id.tv_refresh_redpackge_blessing)
    TextView mTvRefreshRedpackgeBlessing;
    @BindView(R.id.tv_amount)
    TextView mTvAmount;
    @BindView(R.id.btn_config_money)
    Button mBtnConfigMoney;

    private boolean mRedpackgType;
    private  String[]  mBlessings;
    private  int currentCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packge);
        ButterKnife.bind(this);
        mBlessings   = new String[]{"情绪不对，红包安慰！","打赏你哒！","约起来吧！","恭喜发财，大吉大利！"};
        initListener();
    }

    private void initListener() {
        mEtInputMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String inputMoney = mEtInputMoney.getText().toString().trim();

                double money = Double.parseDouble(inputMoney==null|inputMoney.equals("")?"0":inputMoney);
                mTvAmount.setText(PriceFormaterUtils.format(money));


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.img_return, R.id.title_right, R.id.btn_change_redPack_type, R.id.tv_refresh_redpackge_blessing, R.id.btn_config_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return:
                finish();
                break;
            case R.id.title_right:

                Intent intentToRecord = new Intent(this,RedpackRecordActvity.class);
                startActivity(intentToRecord);
                break;
            case R.id.btn_change_redPack_type:
                mRedpackgType = !mRedpackgType;

                toChangeRedPackType();

                break;
            case R.id.tv_refresh_redpackge_blessing:
                toRefreshBlessing();

                break;
            case R.id.btn_config_money:

                Intent intent = new Intent();
                intent.putExtra("amount", mTvAmount.getText().toString().trim());
                intent.putExtra("count", mEtInputCount.getText().toString().trim());
                intent.putExtra("blessing", mEtBlessing.getText().toString().toString().equals("") ?
                        mEtBlessing.getHint().toString().trim() :
                        mEtBlessing.getText().toString().trim());
                setResult(101,intent);
                finish();


                break;
        }
    }

    private void toRefreshBlessing() {
        mEtBlessing.setText(mBlessings[currentCount]);
        currentCount+=1;
        if (currentCount==4){
            currentCount=0;
        }

    }

    private void toChangeRedPackType() {
        mTvRedPackeType.setText(!mRedpackgType ? "总金额" : "单个金额");
        mTvTip.setVisibility(!mRedpackgType ? View.VISIBLE : View.GONE);
        mBtnChangeRedPackType.setText(!mRedpackgType ? "改为普通红包" : "改为拼手气红包");
        mTvCurrentRedPackType.setText(!mRedpackgType ? "当前为拼手气红包," : "当前为普通红包,");


    }
}
