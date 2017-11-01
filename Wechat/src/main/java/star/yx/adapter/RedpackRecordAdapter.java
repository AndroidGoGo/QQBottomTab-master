package star.yx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import star.yx.modul.RedPackModul;
import star.yx.utils.PriceFormaterUtils;
import star.yx.tabview.R;
import star.yx.activity.RedpackRecordActvity;

/**
 * Created by ${廖昭启} on 2017/10/24.
 */

public class RedpackRecordAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public RedpackRecordAdapter(RedpackRecordActvity redpackRecordActvity) {
        mContext = redpackRecordActvity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_redrecord, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mTv_redType.setText(mRedPackModulList.get(position).getRedPackType()==1?"普通红包":"拼手气红包");
        String  status  = mRedPackModulList.get(position).getRec()<+mRedPackModulList.get(position).getCount()?"已过期 ":"";
        viewHolder.mTv_count.setText(status+mRedPackModulList.get(position).getRec()+"/"+""+mRedPackModulList.get(position).getCount()+"个");
        viewHolder.mTv_date.setText(mRedPackModulList.get(position).getDates());
        viewHolder.mTv_money.setText(PriceFormaterUtils.format(mRedPackModulList.get(position).getMoney()));

    }

    @Override
    public int getItemCount() {
        return mRedPackModulList.size();
    }

    private List<RedPackModul> mRedPackModulList = new ArrayList<>();

    public void loadDatas(List<RedPackModul> redPackModulList) {
        mRedPackModulList.clear();
        mRedPackModulList.addAll(redPackModulList);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private final TextView mTv_redType;
        private final TextView mTv_money;
        private final TextView mTv_date;
        private final TextView mTv_count;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTv_redType = (TextView) mView.findViewById(R.id.tv_redType);
            mTv_money = (TextView) mView.findViewById(R.id.tv_money);
            mTv_date = (TextView) mView.findViewById(R.id.tv_date);
            mTv_count = (TextView) mView.findViewById(R.id.tv_count);


        }
    }
}
