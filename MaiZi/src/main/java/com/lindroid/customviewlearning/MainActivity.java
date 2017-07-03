package com.lindroid.customviewlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lindroid.customviewlearning.view.ItemView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 1、自定义布局需要加上android:clickable="true"才能看到点击变色的效果
 * 2、自定义的布局不设置具体高度，然后在activity_main中设置具体高度的话条目之间会有间距，不知道为何。
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.itemView1)
    ItemView itemView1;
    @Bind(R.id.itemView2)
    ItemView itemView2;
    @Bind(R.id.itemView3)
    ItemView itemView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        itemView1.setView("姓名", "Lindroid", true);
        itemView2.setView("年龄", null, true);
        itemView3.setView("学校", "深圳大学", false);
    }
}
