package com.android.teaching.chatapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    //private FIlmsFirebaseInteractor fIlmsFirebaseInteractor;
    private MyAdapter myAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //myAdapter = new MyAdapter();

        //listView.findViewById(R.id.list);
        //listView.setAdapter(myAdapter);

    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.chat_activity_model, viewGroup, false);
            TextView textViewUser = rowView.findViewById(R.id.chat_upper_text);
            TextView textViewMessage =rowView.findViewById(R.id.chat_down_text);
            return rowView;
        }
    }
}
