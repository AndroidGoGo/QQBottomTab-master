package star.yx.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import star.yx.adapter.SBAdapter;
import star.yx.adapter.TubatuAdapter;
import star.yx.interfaces.ITabClickListener;
import star.yx.tabview.ClipViewPager;
import star.yx.tabview.R;
import star.yx.viewutils.ScalePageTransformer;


/**
 * Created by yx on 16/4/3.
 */
public class ContactsFragment extends BaseFragment implements ITabClickListener {


    private ClipViewPager mRvSbdabing;
    List<String> mdatas = new ArrayList<>();
    private SBAdapter mSbAdapter;
    private View mView;
    private TubatuAdapter mTubatuAdapter;

    @Override
    public void fetchData() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void initDatas() {
        for (int i = 0; i < 6; i++) {
            mdatas.add("傻逼大兵"+i) ;
        }
        mRvSbdabing.setOffscreenPageLimit(mdatas.size());
        mTubatuAdapter.addAll(mdatas);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_sb_dabing, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();




        initDatas();


    }

    private void initView() {
        mRvSbdabing = (ClipViewPager)mView.findViewById(R.id.viewpager);
        mRvSbdabing.setSpeedScroller(300);
        mRvSbdabing.setPageTransformer(true, new ScalePageTransformer());
        mView.findViewById(R.id.view_contianer).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mRvSbdabing.dispatchTouchEvent(event);
            }
        });
        mTubatuAdapter = new TubatuAdapter(getActivity());
        mRvSbdabing.setAdapter(mTubatuAdapter);

    }



    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }





}
