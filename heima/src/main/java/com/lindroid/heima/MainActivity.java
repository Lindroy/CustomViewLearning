package com.lindroid.heima;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_menu, R.id.btn_slide})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_menu:
                startActivity(new Intent(this,YouKuActivity.class));
                break;
            case R.id.btn_slide:
                break;
        }
    }
}
