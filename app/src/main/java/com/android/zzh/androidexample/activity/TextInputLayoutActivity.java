package com.android.zzh.androidexample.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.android.zzh.androidexample.R;

public class TextInputLayoutActivity extends AppCompatActivity {
    private android.support.design.widget.TextInputLayout textInputLayout;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input_layout);

        //当EditText中的输入多于十位时，提示错误信息。
        textInputLayout = (android.support.design.widget.TextInputLayout)findViewById(R.id.textInputLayout);
        editText = textInputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>10){
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("输入不能超过10位");
                }
                else{
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
