package com.xujun.fragmenttabhostdemo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.xujun.fragmenttabhostdemo.R;

/**
 * Created by Administrator on 2017/9/13.
 */

public class BigPicImageView extends View {

    private Bitmap bitmap;
    private int startX;
    private int starty;
    private int correntX = 0;
    private int corenntY = 0;
    DisplayMetrics dm = new DisplayMetrics();
    private int width;
    private int height;
    private Context mContext;


    public BigPicImageView(Context context) {
        super(context);
        mContext = context;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.big_pic);
        width = bitmap.getWidth();
        height = bitmap.getHeight();

    }

    public BigPicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.big_pic);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    public BigPicImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getRawX();
                starty = (int) event.getRawY();

                break;

            case MotionEvent.ACTION_MOVE:
                float dx = event.getRawX() - startX;
                float dy = event.getRawY() - starty;
                correntX -= dx;
                corenntY -= dy;

                if (correntX < 0) {
                    correntX = 0;
                } else if (correntX + dm.widthPixels > width) {
                    correntX = width - dm.widthPixels;
                }
                if (corenntY < 0) {
                    corenntY = 0;
                } else if (corenntY + dm.heightPixels > height) {
                    corenntY = height - starty;
                }
                startX = (int) event.getRawX();
                starty = (int) event.getRawY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(mContext, "手指抬起", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(correntX, corenntY, correntX + dm.widthPixels, corenntY + dm.heightPixels);
        Rect rect1 = new Rect(0, 0, dm.widthPixels, dm.heightPixels);
        canvas.drawBitmap(bitmap, rect, rect1, null);

    }
}
