package com.android.zzh.androidexample.activity;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.zzh.androidexample.R;

import java.util.concurrent.ConcurrentLinkedDeque;

public class CommonViewActivity extends AppCompatActivity {
    private android.support.design.widget.TextInputLayout textInputLayout;
    private EditText editText;
    Button AlertDialogButton ;
    Button ProgressDialogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_view_layout);

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
        AlertDialogButton = (Button)findViewById(R.id.AlertDialogButton);
        AlertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(CommonViewActivity.this);
                dialog.setTitle("This is a AlertDialog");
                dialog.setMessage("This is message part");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

        ProgressDialogButton = (Button)findViewById(R.id.ProgressDialogButton);
        ProgressDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(CommonViewActivity.this);
                progressDialog.setTitle("ProgressDialog");
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }


}
