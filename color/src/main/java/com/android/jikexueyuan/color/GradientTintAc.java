package com.android.jikexueyuan.color;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by admin on 2016/1/5.
 */
public class GradientTintAc extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private GradientDrawable linear, radial, sweep;
    private ImageView example;
    private TextView gradient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradient);
        linear = new GradientDrawable();
        linear.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        linear.setColors(new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff});
        linear.setShape(GradientDrawable.RECTANGLE);

        radial = new GradientDrawable();
        radial.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        radial.setColors(new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff});
        radial.setShape(GradientDrawable.OVAL);

        sweep = new GradientDrawable();
        sweep.setGradientType(GradientDrawable.SWEEP_GRADIENT);
        sweep.setColors(new int[]{0xffff0000, 0xff00ff00, 0xffffff00, 0xff00ffff, 0xff0000ff, 0xffff0000});
        sweep.setShape(GradientDrawable.OVAL);

        ((RadioGroup) findViewById(R.id.rgp)).setOnCheckedChangeListener(this);
        ((RadioGroup) findViewById(R.id.rgp1)).setOnCheckedChangeListener(this);
        gradient = (TextView) findViewById(R.id.grdient);
        example = (ImageView) findViewById(R.id.example);

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.linear:
                gradient.setBackground(linear);
                break;
            case R.id.radial:
                radial.setGradientRadius(gradient.getWidth() / 2);
                gradient.setBackground(radial);
                break;
            case R.id.sweep:
                gradient.setBackground(sweep);
                break;
            case R.id.tint1:
                example.getDrawable().setTint(0x88ffff00);
                example.getDrawable().setTintMode(PorterDuff.Mode.ADD);
                break;
            case R.id.tint2:
                example.getDrawable().setTint(0x88ffff00);
                example.getDrawable().setTintMode(PorterDuff.Mode.SCREEN);
                break;
            case R.id.tint3:
                example.getDrawable().setTint(0x88ffff00);
                example.getDrawable().setTintMode(PorterDuff.Mode.SRC_OVER);
                break;
            case R.id.tint4:
                example.getDrawable().setTint(0x88ffff00);
                example.getDrawable().setTintMode(PorterDuff.Mode.SRC_IN);
                break;
            case R.id.tint5:
                example.getDrawable().setTint(0x88ffff00);
                example.getDrawable().setTintMode(PorterDuff.Mode.MULTIPLY);
                break;
            case R.id.tint6:
                example.getDrawable().setTint(0x88ffff00);
                example.getDrawable().setTintMode(PorterDuff.Mode.SRC_ATOP);
                break;
        }

    }
}