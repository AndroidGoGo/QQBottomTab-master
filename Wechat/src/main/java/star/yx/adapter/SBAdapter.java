package star.yx.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import star.yx.tabview.R;

/**
 * Created by ${廖昭启} on 2017/10/26.
 */

public class SBAdapter extends RecyclerView.Adapter {
    private Context  mContext;
    public SBAdapter(FragmentActivity activity) {
        mContext = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sb, parent, false);
        ViewHolder   viewHolder  = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder  viewHolder  = (ViewHolder) holder;
        viewHolder.mTvName.setText(mdatas.get(position));

    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    List<String> mdatas = new ArrayList<>();

    public void loadDatas(List<String> mdatas) {
        this.mdatas = mdatas;
        notifyDataSetChanged();
    }

    static class ViewHolder  extends RecyclerView.ViewHolder{

        private final TextView mTvName;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
