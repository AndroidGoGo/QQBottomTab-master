package star.yx.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import star.yx.activity.RomanticActivity;
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
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RomanticActivity.class);
                mContext.startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }
}
