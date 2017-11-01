package com.xujun.fragmenttabhostdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xujun.fragmenttabhostdemo.R;

/**
 * Created by Administrator on 2017/9/13.
 * //http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%AE%89%E5%8D%93%E8%83%8C%E6%99%AF%E5%9B%BE&step_word=&hs=2&pn=11&spn=0&di=46572272120&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=959795621%2C2914789028&os=1942219385%2C942890548&simid=3488062907%2C530972709&adpicid=0&lpn=0&ln=1981&fr=&fmq=1505303833479_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.club.pchome.net%2Fkdsarticle%2F2014%2F03small%2F17%2F991b3371460eea3b6c8085c1123d723e_1000x750.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Frtv_z%26e3Bh1fstuj_z%26e3Bv54AzdH3Fv5gpjgp_ldlan_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0
 *  http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%AE%89%E5%8D%93%E8%83%8C%E6%99%AF%E5%9B%BE&step_word=&hs=2&pn=12&spn=0&di=99862636940&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1149610203%2C2176968952&os=2741130579%2C4146444957&simid=3377992064%2C162470879&adpicid=0&lpn=0&ln=1981&fr=&fmq=1505303833479_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fa5.topitme.com%2Fo086%2F1008645787d0d12f99.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bp5rtp_z%26e3B4jAzdH3Fwsk74AzdH3F8ac0ldnAzdH3Ftpj4AzdH3F9mdlc9m&gsm=0&rpstart=0&rpnum=0
 */

public class GlideDemoAdapter extends RecyclerView.Adapter {
    private Context  mContext;
    public GlideDemoAdapter(Context context) {
        mContext =context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_glide_demo, parent, false);
        ViewHolder  viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder  viewHolder = (ViewHolder) holder;

        viewHolder.mView.setTag(position);
        if (position<3&&((int)viewHolder.mView.getTag())==position){
            viewHolder.tv_glideDemo.setText("第4张图");
            viewHolder.iv_glideDemo.setBackgroundResource(R.drawable.ic_launcher);
            viewHolder.tv_glideDemo.setVisibility(View.GONE);

        }else {
            viewHolder.tv_glideDemo.setText("第"+position+"张图");
            viewHolder.iv_glideDemo.setBackgroundResource(R.mipmap.hb);
        }

       // Glide.with(mContext).load("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=3&spn=0&di=143793958770&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2611079001%2C3896435225&os=2508326020%2C1898002125&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic49.nipic.com%2Ffile%2F20140927%2F19617624_230415502002_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F888am0am_z%26e3Bip4s&gsm=0").placeholder(R.drawable.direct_setting).into(viewHolder.iv_glideDemo);

    }

    @Override
    public int getItemCount() {
        return 30;
    }
    final static class ViewHolder extends  RecyclerView.ViewHolder{
        private  View  mView;

        private final ImageView iv_glideDemo;
        private final TextView tv_glideDemo;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            iv_glideDemo = (ImageView) itemView.findViewById(R.id.iv_glide);
            tv_glideDemo = (TextView) itemView.findViewById(R.id.tv_glide);

        }

    }
}
