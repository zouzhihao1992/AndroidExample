package com.android.zzh.androidexample.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/3/8.
 */
public class ShaderActivity extends AppCompatActivity {
    private ImageView imageView;
    private RadioGroup radioGroup;
    private ArcShape arcShape;
    private ShapeDrawable shapeDrawable1,shapeDrawable2,shapeDrawable3,shapeDrawable4,shapeDrawable5;
    Bitmap bitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shader_activity);
        imageView = (ImageView)findViewById(R.id.ImageView_shader_activity);

        radioGroup = (RadioGroup)findViewById(R.id.RadioGroup_shader_activity);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.toolbarimg);

        arcShape = new ArcShape(45,270);

        shapeDrawable1 = new ShapeDrawable(arcShape);
        shapeDrawable1.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable1.getPaint().setColor(Color.RED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            imageView.setBackground(shapeDrawable1);
        }

        arcShape = new ArcShape(45,270);
        shapeDrawable2 = new ShapeDrawable(arcShape);


        arcShape = new ArcShape(45,270);
        shapeDrawable3 = new ShapeDrawable(arcShape);

        arcShape = new ArcShape(45,270);
        shapeDrawable4 = new ShapeDrawable(arcShape);

        arcShape = new ArcShape(45,270);
        shapeDrawable5 = new ShapeDrawable(arcShape);

        shapeDrawable1.setShaderFactory(new ShapeDrawable.ShaderFactory(){

            @Override
            public Shader resize(int width, int height) {
                return new BitmapShader(bitmap,Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
            }
        });

        shapeDrawable2.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient linearGradient = new LinearGradient(0,0,width,height,new int[]{
                        Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW},null, Shader.TileMode.REPEAT);
                RadialGradient radialGradient = new RadialGradient(width/2,height/2,width/2,
                        new int[]{
                                Color.WHITE,
                                Color.GRAY,
                                Color.DKGRAY,Color.BLACK
                        },null, Shader.TileMode.REPEAT);
                return new ComposeShader(linearGradient,radialGradient, PorterDuff.Mode.MULTIPLY);
            }
        });

        shapeDrawable3.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                return new LinearGradient(0,0,width,height,
                        new int[]{
                                Color.RED,
                                Color.GREEN,
                                Color.BLUE,
                                Color.YELLOW
                        },null, Shader.TileMode.REPEAT);
            }
        });

        shapeDrawable4.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                return new RadialGradient(width/2,height/2,width/2,
                        new int[]{
                                Color.RED,
                                Color.GREEN,
                                Color.BLUE,
                                Color.YELLOW
                        },null, Shader.TileMode.REPEAT);
            }
        });

        shapeDrawable5.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                return new SweepGradient(width/2,height/2,
                        new int[]{
                                Color.RED,
                                Color.GREEN,
                                Color.BLUE,
                                Color.YELLOW

                        },new float[]{0.1f,0.3f,0.6f,1f});
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.RadioButton_BitmapShader:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            imageView.setBackground(shapeDrawable1);
                        }
                        break;
                    case R.id.RadioButton_ComposeShader:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            imageView.setBackground(shapeDrawable2);
                        }
                        break;
                    case R.id.RadioButton_LinearGradient:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            imageView.setBackground(shapeDrawable3);
                        }
                        break;
                    case R.id.RadioButton_RadialGradient:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            imageView.setBackground(shapeDrawable4);
                        }
                        break;
                    case R.id.RadioButton_sweepGradient:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            imageView.setBackground(shapeDrawable5);
                        }
                        break;
                }
            }
        });

    }
}
