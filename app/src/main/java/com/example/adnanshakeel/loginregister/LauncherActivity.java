package com.example.adnanshakeel.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
public class LauncherActivity extends AppCompatActivity {
private static int timeOut=5000;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent launcherIntent= new Intent(LauncherActivity.this,LoginActivity.class);
                startActivity(launcherIntent);
                finish();
            }
        },timeOut);


    }
}
