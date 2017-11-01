package com.lzq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.xujun.fragmenttabhostdemo.R;

/**
 * Created by ${廖昭启} on 2017/10/11.
 */

public class RefreshLayout extends ViewGroup {

    private static final int UPDATE_PROGRESS = 101;
    private View mHeadView = null;
    private View mFooterView = null;
    private View mContentView = null;
    private Scroller mScroller = null;
    private int mWaith;
    private int mHeigh;
    private RecyclerView mRecyclerView;
    private int mCount;
    private TextView tv_refresh_footer;
    private TextView tv_refresh_header;
    private CBProgressBar probar_load_footer;
    private CBProgressBar probar_load_header;
    private boolean stop;

    public RefreshLayout(Context context, AttributeSet attrs, View headView) {

        super(context, attrs);
        mHeadView = headView;
    }

    public RefreshLayout(Context context) {
        super(context);
        mHeadView = View.inflate(context,R.layout.item_headview,null);

        mFooterView = View.inflate(context,R.layout.item_footerview,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mHeadView.setLayoutParams(params);
        mFooterView.setLayoutParams(params);
        addView(mFooterView);
        addView(mHeadView);
        tv_refresh_footer = (TextView) mFooterView.findViewById(R.id.tv_refresh);
        tv_refresh_header = (TextView) mHeadView.findViewById(R.id.tv_refresh);
        probar_load_footer = (CBProgressBar) mFooterView.findViewById(R.id.proBar_refresh);
        probar_load_header = (CBProgressBar) mHeadView.findViewById(R.id.proBar_refresh);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view == mHeadView) {
                view.layout(0, -view.getMeasuredHeight(), view.getMeasuredWidth(), 100);
                break;
            } else if (view == mFooterView) {
                view.layout(0, view.getMeasuredHeight(), view.getMeasuredWidth(), view.getMeasuredHeight() * 2);
                break;
            } else {
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                mRecyclerView = (RecyclerView) view;
            }

        }

    }

    private float mStartY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.computeScrollOffset()) {
                    int scollDis = Math.round(event.getY() - mStartY);
                    int scrollY = getScrollY();
                    if (scollDis != 0) {
                        /*if (y > 0) { //手势下滑
                            y = -y;
                        } else {//手势上滑
                            y = Math.abs(y);
                        }*/
                        scollDis = scollDis > 0 ? -scollDis : Math.abs(scollDis);
                        textUpdate(scrollY);
                        mScroller.startScroll(0, scrollY, 0, scollDis, 0);
                        invalidate();
                    }
                }
                    case MotionEvent.ACTION_UP:
                        textUpdate(getScrollY());
                        //回弹
                        reBound();
                        break;



        }

        return true;
    }

    private void reBound() {
        int scrollY = getScrollY();
        int scrollDis; //滑动距离
        int absY = Math.abs(scrollY);
        if (scrollY != 0) {
            //判断是否超过200
            if (absY < 200) { //没超过:直接回弹到默认位置
                scrollDis = scrollY > 0 ? 0 - scrollY : absY;
                mScroller.startScroll(0, scrollY, 0, scrollDis, 1000);
                invalidate();
                return;
            } else { //超过200需要加载数据
                scrollDis = scrollY > 0 ? 0 - (scrollY - 100) : absY - 100;
                mScroller.startScroll(0, scrollY, 0, scrollDis, 1000);
                invalidate();
                // 加载/刷新数据
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int y = getScrollY();
                        if (y > 0) { //上滑
                            mCallBack.upRefresh(mScroller, y);
                        } else { //下滑
                            mCallBack.downLoad(mScroller, y);
                        }
                    }
                }, 2000);
            }

        }
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }

    private LinearLayoutManager mLayoutManager = null;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mCount = mRecyclerView.getAdapter().getItemCount();
        mLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        int position = mLayoutManager.findFirstCompletelyVisibleItemPosition();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int y = Math.round(ev.getY() - mStartY);
                if (position == 0 && y > 0) {
                    return true;
                } else if (mLayoutManager.findLastCompletelyVisibleItemPosition() == mCount - 1 && y < 0) {
                    return true;
                }
                return false;
        }
        return false;
    }


    private void textUpdate(int scrollY) {
        if (scrollY < 0) {//修改Header中的text
            scrollY = Math.abs(scrollY);
            if (scrollY > 200 && !tv_refresh_header.getText().toString().equals("松开刷新")) {
                tv_refresh_header.setText("松开刷新");
            } else if (scrollY < 200 && !tv_refresh_header.getText().toString().equals("下拉刷新")) {
                tv_refresh_header.setText("下拉刷新");
            }
        } else { //修改Footer中的text
            if (scrollY > 200 && !tv_refresh_header.getText().toString().equals("松开加载更多")) {
                tv_refresh_footer.setText("松开加载更多");

            } else if (scrollY < 200 && !tv_refresh_header.getText().toString().equals("上拉加载更多")) {
                tv_refresh_footer.setText("上拉加载更多");
            }
        }


    }

    public interface RefreshCallBack {
        void upRefresh(Scroller scroller, int y);

        void downLoad(Scroller scroller, int y);
    }

    private RefreshCallBack mCallBack = null;

    public void setRefreshCallBack(RefreshCallBack callBack) {
        if (callBack != null) {
            this.mCallBack = callBack;
        }
    }

    private boolean isDownloading;
    Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PROGRESS:
                    probar_load_footer.setProgress( msg.arg1);
                    probar_load_header.setProgress( msg.arg1);

                    if(msg.arg1==100){
                        isDownloading = false;
                      //  btnDownload.setText("下载");

                    }
                    break;

                default:
                    break;
            }
        };
    };


    private void downloading(CBProgressBar cbProgress){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while(!stop){
                    if(progress>=100){
                        break;
                    }
                    Message msg = handler.obtainMessage();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress+=1;
                    msg.what= UPDATE_PROGRESS;
                    msg.arg1 = progress;
                    msg.sendToTarget();
                }
                progress = 0;
            }
        }).start();

    }
}
