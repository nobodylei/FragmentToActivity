package com.lei.fragmenttoactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yanle on 2018/2/7.
 */

public class MyFragment extends Fragment{
    private EditText et_content;
    private Button btn_pass;
    private MyListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建接口的子类对象
        listener = (MyListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resource,null);
        et_content = view.findViewById(R.id.et_content);
        btn_pass = view.findViewById(R.id.btn_pass);

        btn_pass.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮时获取EditText中的值传递到activity
                String info = et_content.getText().toString();
                listener.sendMessage(info);//接口回调形式回传数据
            }
        });
        return view;
    }

    //定义接口 接口中定义回传数据的函数
    interface MyListener {
        void sendMessage(String str);
    }
}
