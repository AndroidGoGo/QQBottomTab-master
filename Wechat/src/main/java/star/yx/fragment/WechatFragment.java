package star.yx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import star.yx.interfaces.ITabClickListener;
import star.yx.tabview.R;
import star.yx.test.BaseRecyclerViewAdapter;
import star.yx.test.BaseSwipeRefreshLayout;
import star.yx.widegt.StatusHookView;

/**
 * Created by yx on 16/4/3.
 */
public class WechatFragment extends BaseFragment implements ITabClickListener, View.OnClickListener, StatusHookView.HookStatusChangeListener {
    private BaseSwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mListView;
    private LinearLayoutManager layoutManager;
    WechatAdapter adapter;
    private StatusHookView mStatusHookView;
    private Context mContext;

    @Override
    public void fetchData() {
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_layout, container, false);
        mContext = getActivity();
        mSwipeRefreshLayout = (BaseSwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mListView = (RecyclerView) view.findViewById(R.id.list);
        mStatusHookView = (StatusHookView) view.findViewById(R.id.view_status);
        Button btnChangeStatus = (Button) view.findViewById(R.id.btn_change_Hookstatus);
        btnChangeStatus.setOnClickListener(this);
        mStatusHookView.setOnClickListener(this);
        mStatusHookView.setOnHookStatusChangeListener(this);

        this.layoutManager = new LinearLayoutManager(this.getContext());
        this.layoutManager.setOrientation(1);
        this.mListView.setLayoutManager(this.layoutManager);
        adapter = new WechatAdapter();
        mListView.setAdapter(adapter);
        return view;
    }


    private void getData() {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    mSwipeRefreshLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }

    private boolean status;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_change_Hookstatus) {
            status = !status;
            mStatusHookView.setChecked(status);
        }
    }

    @Override
    public void onHookStatusChangeListener(StatusHookView statusHookView, boolean isCheck) {
        Toast.makeText(mContext, (isCheck ? "已收藏" : "收藏失败"), Toast.LENGTH_SHORT).show();
    }


    class WechatAdapter extends BaseRecyclerViewAdapter {
        public WechatAdapter() {
            super(R.layout.contact_item);
        }

        @Override
        public void onBindViewData(ViewHolder var1, int var2) {
            var1.getTextView(R.id.contact).setText("你有新消息");
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }
}
