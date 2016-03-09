package com.android.zzh.androidexample.activity;

import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.zzh.androidexample.R;

/**
 * Created by zzh on 16/3/8.
 */
public class XMLShapeActivity extends AppCompatActivity {

    private ShapeDrawable shapeDrawable;
    private ArcShape arcShape;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_shape_activity);

        //需要在xml中指定具体尺寸，不然无法显示。
        //因为ImageView未指定src内容，measure时，其measureWidth和measureHeight都是0
        Path path = new Path();
        path.moveTo(50,0);
        path.lineTo(0,50);
        path.lineTo(50,100);
        path.lineTo(50,100);
        path.lineTo(100,50);
        path.close();
        PathShape pathShape = new PathShape(path,100,100);
        shapeDrawable = new ShapeDrawable(pathShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(Color.BLUE);
        ((ImageView) findViewById(R.id.ImageView_path)).setBackground(shapeDrawable);



        arcShape = new ArcShape(0,150);
        shapeDrawable = new ShapeDrawable(arcShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setColor(Color.BLUE);

        findViewById(R.id.ImageView_arc).setBackground(shapeDrawable);


        arcShape = new ArcShape(0,-150);
        shapeDrawable = new ShapeDrawable(arcShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(Color.RED);

        findViewById(R.id.ImageView_arc2).setBackground(shapeDrawable);

    }
}
