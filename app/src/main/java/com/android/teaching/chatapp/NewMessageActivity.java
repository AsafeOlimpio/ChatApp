package com.android.teaching.chatapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class NewMessageActivity extends AppCompatActivity {

    private EditText username;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.chat_activity_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("New Message");
        //No necesita parametros
        getSupportActionBar();

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        username = findViewById(R.id.username_input);
        message = findViewById(R.id.message_input);
    }

    public void enviar(View view) {
        String usernameinput = username.getText().toString();
        String messageinput = message.getText().toString();

        if (TextUtils.isEmpty(usernameinput)){

            username.setError(getString(R.string.empty_username));
        }

        else if (TextUtils.isEmpty(messageinput)){
            message.setError(getString(R.string.empty_message));
        }

        else {
            String token = FirebaseInstanceId.getInstance().getToken();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("messages");

            myRef.child(token).child("text").setValue(usernameinput);
            myRef.child(token).child("username").setValue(messageinput);
        }
    }
}
