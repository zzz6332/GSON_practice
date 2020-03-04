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
                /*  这段网络请求后的数据为：{
    "HeWeather6": [
        {
            "basic": {
                "cid": "CN101040100",
                "location": "重庆",
                "parent_city": "重庆",
                "admin_area": "重庆",
                "cnty": "中国",
                "lat": "29.56376076",
                "lon": "106.55046082",
                "tz": "+8.00"
            },
            "update": {
                "loc": "2020-03-04 14:33",
                "utc": "2020-03-04 06:33"
            },
            "status": "ok",
            "now": {
                "cloud": "94",
                "cond_code": "399",
                "cond_txt": "雨",
                "fl": "11",
                "hum": "95",
                "pcpn": "2.6",
                "pres": "992",
                "tmp": "11",
                "vis": "16",
                "wind_deg": "90",
                "wind_dir": "东风",
                "wind_sc": "1",
                "wind_spd": "4"
            }
        }
    ]
}
        */
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(response, JsonBean.class);
                tv.setText(jsonBean.getHeWeather6().get(0).getBasic().getAdmin_area());
            }
        });
    }
}
