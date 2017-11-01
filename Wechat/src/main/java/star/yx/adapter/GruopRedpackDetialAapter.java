package star.yx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import star.yx.modul.RedPackGruopDetialModul;
import star.yx.activity.GruopRedpackDetialActivity;
import star.yx.tabview.R;

/**
 * Created by ${廖昭启} on 2017/10/24.
 */

public class GruopRedpackDetialAapter extends RecyclerView.Adapter {
    private Context mContext;
    public GruopRedpackDetialAapter(GruopRedpackDetialActivity gruopRedpackDetialActivity) {
        mContext  = gruopRedpackDetialActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gruop_redpack_detial, parent, false);
        ViewHolder  viewHolder  = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ViewHolder  viewHolder   = (ViewHolder) holder;
       viewHolder.mTvDates.setText(mRedPackGruopDetialModulList.get(position).getTime());


    }

    @Override
    public int getItemCount() {
        return mRedPackGruopDetialModulList.size();
    }
private  List<RedPackGruopDetialModul> mRedPackGruopDetialModulList  = new ArrayList<>();
    public void loadDatas(List<RedPackGruopDetialModul> redPackGruopDetialModulList) {
        mRedPackGruopDetialModulList.clear();
        mRedPackGruopDetialModulList.addAll(redPackGruopDetialModulList);
    }

    static class  ViewHolder  extends  RecyclerView.ViewHolder{


        public  TextView mTvDates;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvDates = (TextView) itemView.findViewById(R.id.tv_date);

        }
    }
}
