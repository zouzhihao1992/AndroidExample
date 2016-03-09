package com.android.zzh.androidexample.activity;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.zzh.androidexample.R;


/**
 * Created by zzh on 16/3/9.
 */
public class ColorFilterActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {
    private TextView textView;
    private ImageView imageView ;
    float a = 1,r = 1,g = 1, b = 1;
    Drawable drawable , drawable_textView, drawable_image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorfilter_activity);
        textView = (TextView)findViewById(R.id.textView_colorfilter_activity);
        imageView = (ImageView)findViewById(R.id.imageView_colorfilter_activity);
        ((SeekBar)findViewById(R.id.seekbar_a)).setOnSeekBarChangeListener(this);
        ((SeekBar)findViewById(R.id.seekbar_r)).setOnSeekBarChangeListener(this);
        ((SeekBar)findViewById(R.id.seekbar_g)).setOnSeekBarChangeListener(this);
        ((SeekBar)findViewById(R.id.seekbar_b)).setOnSeekBarChangeListener(this);
        drawable_textView = textView.getBackground();
        drawable_image = imageView.getBackground();
        drawable = drawable_textView;
        ((RadioGroup)findViewById(R.id.RadioGroup_colorfilter_activity_txt_image)).setOnCheckedChangeListener(this);
        ((RadioGroup)findViewById(R.id.RadioGroup_colorfilter_activity_matrix)).setOnCheckedChangeListener(this);
        ((RadioGroup)findViewById(R.id.RadioGroup_colorfilter_activity_light)).setOnCheckedChangeListener(this);
        ((Button)findViewById(R.id.PoterDuffButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ColorFilterActivity.this,PoterDuffColorFilter.class));
            }
        });

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float buf = (float) progress / 100;
        switch (seekBar.getId()) {
            case R.id.seekbar_a:
                a = buf;
                break;
            case R.id.seekbar_b:
                b = buf;
                break;
            case R.id.seekbar_g:
                g = buf;
                break;
            case R.id.seekbar_r:
                r = buf;
                break;
        }
        setArgb(a, r, g, b);

    }

    private void setArgb(float a, float r, float g, float b) {

        ColorMatrix mColorMatrix = new ColorMatrix(new float[]{
                r, 0, 0, 0, 0,
                0, g, 0, 0, 0,
                0, 0, b, 0, 0,
                0, 0, 0, a, 0,
        });

        drawable.setColorFilter(new ColorMatrixColorFilter(mColorMatrix));
        textView.postInvalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ColorMatrix mcolorMatrix;
        ColorMatrixColorFilter colorMatrixColorFilter;
        switch (checkedId){
            case R.id.RadioButton_select_text:
                drawable = drawable_textView;
                break;
            case R.id.RadioButton_select_image:
                drawable = drawable_image;
                break;
            case R.id.RadioButton_matrix1:
                mcolorMatrix = new ColorMatrix(new float[]{
                        0, 1, 0, 0, 0,
                        0, 0, 1, 0, 0,
                        1, 0, 0, 0, 0,
                        0, 0, 0, 1, 0});
                colorMatrixColorFilter = new ColorMatrixColorFilter(mcolorMatrix);
                drawable.setColorFilter(colorMatrixColorFilter);
                break;
            case R.id.RadioButton_matrix2:
                mcolorMatrix = new ColorMatrix(new float[]{
                        -1, 0, 0, 1, 0,
                        0, -1, 0, 1, 0,
                        0, 0, -1, 1, 0,
                        0, 0, 0, 1, 0,
                });
                colorMatrixColorFilter = new ColorMatrixColorFilter(mcolorMatrix);
                drawable.setColorFilter(colorMatrixColorFilter);
                break;
            case R.id.RadioButton_light1:
                drawable.setColorFilter(new LightingColorFilter(0xf02f00, 0x0));
                break;
            case R.id.RadioButton_light2:
                drawable.setColorFilter(new LightingColorFilter(0x0000ff, 0x000088));
                break;
        }

        textView.postInvalidate();
    }
}
