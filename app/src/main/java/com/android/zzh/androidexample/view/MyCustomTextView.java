package com.android.zzh.androidexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zzh on 16/3/3.
 */
public class MyCustomTextView extends TextView {

    private Paint mpaint1;
    private Paint mpaint2;
    private int measureWidth = 0;
    private int measureHeight = 0;
    public MyCustomTextView(Context context) {
        super(context);
        init();
    }

    public MyCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyCustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mpaint1 = new Paint();
        mpaint1.setColor(Color.BLUE);
        mpaint1.setStyle(Paint.Style.FILL);

        mpaint2 = new Paint();
        mpaint2.setColor(Color.YELLOW);
        mpaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l      , t, r, b);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        measureWidth = getMeasuredWidth();
        measureHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //此处的获得的getMeasureWidth，getMeasuredHeight不准确。系统会measure多次
//        canvas.drawRect(0,0,measureWidth,measureHeight,mpaint1);
//        canvas.drawRect(10,10,measureWidth-10,measureHeight-10,mpaint2);
//        canvas.save();
//        canvas.translate(10,0);
          super.onDraw(canvas);
//        canvas.restore();
    }
}
