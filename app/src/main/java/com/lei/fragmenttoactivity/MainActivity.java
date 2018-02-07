package com.lei.fragmenttoactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * 演示Fragment向Acivity传值
 */
public class MainActivity extends AppCompatActivity implements MyFragment.MyListener {
    private TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_show = findViewById(R.id.tv_show);
    }

    @Override
    public void sendMessage(String str) {//回传数据进行展示
        if(str != null) {
            tv_show.setText(str);
        }
    }
}
