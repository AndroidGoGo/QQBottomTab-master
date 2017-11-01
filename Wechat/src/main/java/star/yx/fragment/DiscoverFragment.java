package star.yx.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import star.yx.activity.RedpackActivity;
import star.yx.activity.RedpackRecordActvity;
import star.yx.interfaces.ITabClickListener;
import star.yx.tabview.R;
import star.yx.widegt.RedpackDialog;

/**
 * Created by yx on 16/4/3.
 */
public class DiscoverFragment extends BaseFragment implements ITabClickListener {
    private View mView;
    private TextView mTvToRedPack;
    private Button mBtnGetRedpack;

    @Override
    public void fetchData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discvover_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mView = view;
        mTvToRedPack = (TextView) mView.findViewById(R.id.tv_toRedpac);
        mBtnGetRedpack = (Button) mView.findViewById(R.id.btn_getRedpack);
        mBtnGetRedpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RedpackDialog.Builder builder = new RedpackDialog.Builder(getActivity(), R.style.Dialog);
                builder.setName("廖先生")
                        .setType(0)
                        .setBlessing("恭喜发财，大吉大利！！！！")
                        .setOpenButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), RedpackActivity.class);
                        startActivity(intent);
                        dialog.dismiss();

                    }
                })
                        .setCloseButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTolookRecord(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),RedpackRecordActvity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                Dialog dialog = builder.create();
                Window dialogWindow = dialog.getWindow();


                WindowManager m = getActivity().getWindowManager();
                Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
                WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
                p.height = (int) (d.getHeight() * 0.7); // 高度设置为屏幕的0.6
                p.width = (int) (d.getWidth() * 0.75); // 宽度设置为屏幕的0.65
                dialogWindow.setAttributes(p);

                        dialog.show();

            }
        });
        mTvToRedPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RedpackActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 101) {


            String amount = data.getStringExtra("amount");
            String count = data.getStringExtra("count");
            String blessing = data.getStringExtra("blessing");
            Toast.makeText(getActivity(), "发了" + amount + "个红包" + "，共" + count + "元，" + "贺语：" + blessing, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
