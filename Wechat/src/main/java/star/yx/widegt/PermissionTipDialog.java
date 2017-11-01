package star.yx.widegt;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import star.yx.tabview.R;


/**
 * 创建人 zhengpf
 * 时间 2017/5/10
 * 类说明:
 */

public class PermissionTipDialog extends Dialog {

    private static final String TAG = PermissionTipDialog.class.getSimpleName();

    private Context context;

    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_cancel;
    private TextView tv_confirm;

    private String content;

    private OnClickChooseListener onClickChooseListener;

    public void setOnClickChooseListener(OnClickChooseListener onClickChooseListener) {
        this.onClickChooseListener = onClickChooseListener;
    }

    public PermissionTipDialog(Context context) {
        super(context, R.style.LoadingDialog);
        this.context = context;
    }

    public PermissionTipDialog(Context context, String content) {
        super(context, R.style.LoadingDialog);
        this.context = context;
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        init();
    }

    private void init(){
        initUI();
        initListener();
    }

    private void initUI() {
        tv_title = (TextView) findViewById(R.id.permission_tv_title);
        tv_content =(TextView) findViewById(R.id.permission_tv_content);
        tv_cancel = (TextView) findViewById(R.id.permission_tv_cancel);
        tv_confirm = (TextView) findViewById(R.id.permission_tv_confirm);
        tv_title.setText("权限申请");
        if (TextUtils.isEmpty(content)){
            tv_content.setText("在"+ context.getResources().getString(R.string.app_name) +"-权限选项下开启权限,以正常使用App功能");
        }else {
            tv_content.setText(content);
        }
        tv_cancel.setText("取消");
        tv_confirm.setText("去设置");

        setCancelable(false);
    }

    private void initListener() {
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onClickChooseListener){
                    onClickChooseListener.onClickChoose(1);
                }
            }
        });

        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onClickChooseListener){
                    onClickChooseListener.onClickChoose(0);
                }
            }
        });
    }

    public interface OnClickChooseListener{
        void onClickChoose(int choice);
    }
}
