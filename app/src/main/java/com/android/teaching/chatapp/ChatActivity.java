package com.android.teaching.chatapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    //private FIlmsFirebaseInteractor fIlmsFirebaseInteractor;
    private MyAdapter myAdapter;
    private ListView listView;
    private FirebaseDatabase firebaseDatabase;
    MessageModel messageModel;

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_chat_menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                Intent intent = new Intent(this, NewMessageActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.chat_activity_toolbar);
        setSupportActionBar(myToolbar);
        //No necesita parametros
        getSupportActionBar();

        myAdapter = new MyAdapter();

        listView = findViewById(R.id.list);

        listView.setAdapter(myAdapter);
    }

    public class MyAdapter extends BaseAdapter {
        ArrayList<MessageModel> messageModels = new ArrayList<>();

        @Override
        public int getCount() {
            return 3;
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
