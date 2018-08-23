package com.chaychan.bottombarlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button bt3;
    private Button bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void useVp(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void noUseVp(View view) {
        startActivity(new Intent(this, FragmentManagerActivity.class));
    }


    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        bt3 = (Button) findViewById(R.id.bt_3);
        bt4 = (Button) findViewById(R.id.bt_4);

        btn1.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, ViewPagerActivity.class));
                break;
            case R.id.bt_3:
                startActivity(new Intent(this, FragmentManagerActivity.class));
                break;
            case R.id.bt_4:
                startActivity(new Intent(this, NewHomeActivity.class));
                break;
        }
    }
}
