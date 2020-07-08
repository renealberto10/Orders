package com.pumpkinapplabs.orders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtuser, txtrol, txttoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
            int user=bundle.getInt("userid");
            int rol=bundle.getInt("rolid");
            String token=bundle.getString("token");
            txtuser =findViewById(R.id.iduser);
            txtuser.setText("" +user);
            txtrol = findViewById(R.id.idrol);
            txtrol.setText("" +rol);
            txttoken= findViewById(R.id.token);
            txttoken.setText(token);


    }
}