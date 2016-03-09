package com.android.zzh.androidexample.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by zzh on 16/3/7.
 */
public class RoundRectImageDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private RectF mRectF;

    public RoundRectImageDrawable(Bitmap bitmap){
        mBitmap = bitmap;
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);
        mRectF = new RectF(0,0,bitmap.getWidth(),bitmap.getHeight());
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {  //这四个数来至layout的四个参数
        Log.d("zzh","setBounds left:" +left+ " top:" +top + " right:" + right+" bottom:"+bottom);
        super.setBounds(left, top, right, bottom);
        mRectF = new RectF(left,top,right,bottom);
    }

    @Override
    public void draw(Canvas canvas) {
        Log.d("zzh","draw left:" +mRectF.left+ " top:" +mRectF.top + " right:" + mRectF.right+" bottom:"+mRectF.bottom);
        canvas.drawRoundRect(mRectF,30,30,mPaint);

    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }
}
