package com.lindroid.heima;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YouKuActivity extends AppCompatActivity {

    @Bind(R.id.rl_level1)
    RelativeLayout rlLevel1;
    @Bind(R.id.rl_level2)
    RelativeLayout rlLevel2;
    @Bind(R.id.rl_level3)
    RelativeLayout rlLevel3;

    private boolean isLevel2Display = true;
    private boolean isLevel3Display = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_ku);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ib_home, R.id.ib_menu, R.id.ib_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_home:
                if (isLevel2Display) {
                    long delay = 0;
                    if (isLevel3Display) {
                        delay = 200;
                        isLevel3Display = false;
                        //如果当前的三级菜单处于显示状态，让其旋转消失
                        AnimationUtil.rotateOutAnim(rlLevel3,0);
                    }
                    //如果当前的二级菜单处于显示状态，让其旋转消失
                    AnimationUtil.rotateOutAnim(rlLevel2,delay);
                } else {
                    AnimationUtil.rotateInAnim(rlLevel2);
                }
                isLevel2Display = !isLevel2Display;
                break;
            case R.id.ib_menu:
                if (isLevel3Display) {
                    //如果当前的三级菜单处于显示状态，让其旋转消失
                    AnimationUtil.rotateOutAnim(rlLevel3,0);
                } else {
                    AnimationUtil.rotateInAnim(rlLevel3);
                }
                isLevel3Display = !isLevel3Display;
                break;
            case R.id.ib_more:
                break;
        }
    }
}
