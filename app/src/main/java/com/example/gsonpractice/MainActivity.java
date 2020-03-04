package com.example.gsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.gsonpractice.someclass.JsonBean;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        HttpUtil.sendHttpRequest("https://free-api.heweather.net/s6/weather/now?location=重庆&key=69eb00f8b34e4c3cb3969e9a94416c70", new HttpListener() {
            @Override
            public void OnFinish(String response) {
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(response,JsonBean.class);
                tv.setText(jsonBean.getHeWeather6().get(0).getBasic().getAdmin_area());
            }
        });
    }
}
