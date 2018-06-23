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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {


    private MyAdapter myAdapter;
    private ListView listView;
    private FirebaseDatabase firebaseDatabase;
    private ArrayList <MessageModel> messageModelArrayList;


    //I Should have used "onCreateOptionsMenu"


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_chat_menu, menu);
        return super.onCreateOptionsMenu(menu);
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
        getSupportActionBar();

        listView = findViewById(R.id.list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("messages");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                messageModelArrayList = new ArrayList<>();

                //Get Data
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    messageModelArrayList.add(snapshot.getValue(MessageModel.class));
                }

                //Create Adapter
                listView.setAdapter(new MyAdapter());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return messageModelArrayList.size();
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
            View views = LayoutInflater.from(ChatActivity.this).inflate(R.layout.chat_activity_model,viewGroup,false);

            ((TextView) view.findViewById(R.id.chat_upper_text)).setText(messageModelArrayList.get(i).getUsername());
            ((TextView) view.findViewById(R.id.chat_down_text)).setText(messageModelArrayList.get(i).getText());
            return view;
        }
    }
}
