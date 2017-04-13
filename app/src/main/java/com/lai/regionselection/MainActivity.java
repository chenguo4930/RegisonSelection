package com.lai.regionselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_address;//spinner的地址
    private TextView tv_allAddress;//输入的详细地址
    private Button btn_show;//选择地区按钮
    private int requestCode = 101;//请求码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化控件id
        initClick();//初始化点击
    }

    //初始化点击
    private void initClick() {
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowRegionActivity.class);
                intent.putExtra("address", "address");
                intent.putExtra("allAddress", "addAddress");
                startActivityForResult(intent, requestCode);
            }
        });
    }

    //初始化控件id
    private void initView() {
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_allAddress = (TextView) findViewById(R.id.tv_allAddress);
        btn_show = (Button) findViewById(R.id.btn_show);
    }

    /**
     * 将返回数据给tv
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == 102) {
            tv_address.setText(data.getStringExtra("address"));
            tv_allAddress.setText(data.getStringExtra("allAddress"));
        }
    }
}
