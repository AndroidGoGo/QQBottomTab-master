package star.yx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import star.yx.tabview.R;

/**
 * Created by ${廖昭启} on 2017/10/26.
 */

public class TubatuAdapter extends RecyclingPagerAdapter {

    private List<Integer> mList;
    private Context mContext;
    private List<String> mStringList = new ArrayList<>();

    public TubatuAdapter(Context context) {

        mContext = context;


    }

    public void addAll(List<String> strList) {
        mStringList.addAll(strList);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup container) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sb, container, false);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_resource);
        tvName.setText(mStringList.get(position));
        Glide.with(mContext).
                load("http://www.imgeek.org/uploads/article/20160713/c7132fc48c89e6bdc188ad2bb0cb5164.png").
                into(imageView);


        return view;
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }
}
