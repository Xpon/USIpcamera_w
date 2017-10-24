package com.example.huajie.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.huajie.myapplication.utils.Util;

public class MainActivity extends AppCompatActivity {
    private static final String GENERATE_STREAM_TEXT_V1 = "Your app server";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String streamJson = Util.syncRequest(GENERATE_STREAM_TEXT_V1);
                        Intent intent = new Intent(MainActivity.this,SWCameraStreamingActivity.class);
                        intent.putExtra("stream_json_str",streamJson);
                        startActivity(intent);
                    }
                }).start();
            }
        });
    }
}
