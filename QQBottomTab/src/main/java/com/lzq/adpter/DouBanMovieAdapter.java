package com.lzq.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzq.activity.demo.TestActivity;
import com.lzq.modle.Subject;
import com.xujun.fragmenttabhostdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${廖昭启} on 2017/9/26.
 */

public class DouBanMovieAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public DouBanMovieAdapter(TestActivity testActivity) {
        mContext = testActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Subject.Avatars images = mSubjectList.get(position).getImages();
        Subject subject = mSubjectList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(mContext).load(mSubjectList.get(position)
                .getImages().getMedium())
                .placeholder(R.drawable.direct_setting)
                .into(viewHolder.mIvMoviePic);
        List<Subject.Cast> directors = subject.getDirectors();
        StringBuilder sbDirectors = new StringBuilder();
        StringBuilder sbyanyuan = new StringBuilder();
        StringBuilder sbother = new StringBuilder();
        for (int i = 0; i < directors.size(); i++) {

            sbDirectors.append(directors.get(i).getName() + " ");

        }
        viewHolder.mTvMoieName.setText(subject.getTitle());
        viewHolder.mTvMoviewDaoyan.setText("导演:" + sbDirectors);
        List<Subject.Cast> casts = subject.getCasts();
        for (int i = 0; i < casts.size(); i++) {

            sbyanyuan.append(casts.get(i).getName() + " ");

        }
        viewHolder.mTvMovieDetial.setText("演员:" + sbyanyuan);
        List<String> genres = subject.getGenres();
        for (int i = 0; i < genres.size(); i++) {
            sbother.append(genres.get(i) + " ");

        }
        viewHolder.mTvMovieInfo.setText("影片类型:" + sbother + " 总播放量:" + subject.getCollect_count());

    }


    @Override
    public int getItemCount() {
        return mSubjectList.size();
    }

    private List<Subject> mSubjectList = new ArrayList<>();

    public void loadDatas(List<Subject> subjectList) {
        mSubjectList.clear();
        mSubjectList.addAll(subjectList);
        notifyDataSetChanged();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvMovieDetial;
        public View mView;
        private final ImageView mIvMoviePic;
        private final TextView mTvMoieName;
        private final TextView mTvMoviewDaoyan;
        private final TextView mTvMovieInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mIvMoviePic = (ImageView) mView.findViewById(R.id.iv_moviePic);
            mTvMoieName = (TextView) mView.findViewById(R.id.tv_movieName);
            mTvMoviewDaoyan = (TextView) mView.findViewById(R.id.tv_movieDaoyan);
            mTvMovieDetial = (TextView) mView.findViewById(R.id.tv_moviedetial);
            mTvMovieInfo = (TextView) mView.findViewById(R.id.tv_otherInfo);

        }
    }


}
