package com.android.zzh.androidexample.activity;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.zzh.androidexample.R;

import org.w3c.dom.Text;

/**
 * Created by zzh on 16/3/1.
 */
public class ScrollActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_activity);
        textView = (TextView)findViewById(R.id.textView_scroll_activity);
        editText = (EditText)findViewById(R.id.EditText_scroll_activity);
        button = (Button)findViewById(R.id.Button_scroll_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string =  editText.getText().toString();
                textView.scrollTo(Integer.valueOf(string),0);
            }
        });



    }
}
