package com.lindroid.heima;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
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

    private boolean isLevel1Display = true;
    private boolean isLevel2Display = true;
    private boolean isLevel3Display = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_ku);
        ButterKnife.bind(this);
    }

    /**
     * 按键监听事件
     *
     * @param keyCode 事件码
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) { //如果按下的是菜单键
            Log.e("Tag", "keyCode=" + keyCode);
            if (isLevel1Display) {
                long delay = 0;
                //隐藏三级菜单
                if (isLevel3Display) {
                    AnimationUtil.rotateOutAnim(rlLevel3, 0);
                    isLevel3Display = false;
                    delay += 200;
                }
                //隐藏二级菜单
                if (isLevel2Display) {
                    AnimationUtil.rotateOutAnim(rlLevel2, delay);
                    isLevel2Display = false;
                    delay += 200;
                }
                //隐藏一级菜单
                AnimationUtil.rotateOutAnim(rlLevel1, delay);
            } else {
                AnimationUtil.rotateInAnim(rlLevel1, 0);
                AnimationUtil.rotateInAnim(rlLevel2, 200);
                AnimationUtil.rotateInAnim(rlLevel3, 400);

                isLevel2Display = true;
                isLevel3Display = true;
            }
            isLevel1Display = !isLevel1Display;
        }
        return true; //返回true表示响应当前事件
    }

    @OnClick({R.id.ib_home, R.id.ib_menu, R.id.ib_more})
    public void onViewClicked(View view) {
        if (AnimationUtil.runningAnimationCount > 0) {
            return; //当前有动画执行时，不执行点击事件
        }
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
                    AnimationUtil.rotateInAnim(rlLevel2, 0);
                }
                isLevel2Display = !isLevel2Display;
                break;
            case R.id.ib_menu:
                if (isLevel3Display) {
                    //如果当前的三级菜单处于显示状态，让其旋转消失
                    AnimationUtil.rotateOutAnim(rlLevel3,0);
                } else {
                    AnimationUtil.rotateInAnim(rlLevel3, 0);
                }
                isLevel3Display = !isLevel3Display;
                break;
            case R.id.ib_more:
                break;
        }
    }
}
