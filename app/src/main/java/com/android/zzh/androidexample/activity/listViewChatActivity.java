package com.android.zzh.androidexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.zzh.androidexample.R;
import com.android.zzh.androidexample.adapter.MsgAdapter;
import com.android.zzh.androidexample.other.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/2/26.
 */
public class listViewChatActivity extends AppCompatActivity {

    private List<Msg> lists;
    ListView listView ;
    Button sendButton;
    EditText editText;
    MsgAdapter msgAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_chat_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_listview_chat);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.listview_chat);
        sendButton = (Button)findViewById(R.id.Button_chat);
        editText = (EditText)findViewById(R.id.EditText_chat);
        initData();
        msgAdapter = new MsgAdapter(this,R.layout.item_listview_chat,lists);
        listView.setAdapter(msgAdapter);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if(!content.equals("")){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    lists.add(msg);
                    msgAdapter.notifyDataSetChanged();
                    listView.setSelection(lists.size());
                    editText.setText("");
                }
            }
        });

    }

    private void initData(){
        lists = new ArrayList<>();
        for (int i = 'a'; i <= 'h' ; i++){
            Msg msg = new Msg(""+(char)i ,Msg.TYPE_RECEIVED);
            Msg msg2 = new Msg(""+(char)(i+10),Msg.TYPE_SENT);
            lists.add(msg);
            lists.add(msg2);
        }
    }
}
