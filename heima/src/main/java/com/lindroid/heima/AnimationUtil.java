package com.lindroid.heima;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by lin on 2017/5/6.
 * 动画工具类
 */

public class AnimationUtil {
    public static int runningAnimationCount = 0;

    /**
     * 旋转出去的动画
     */
    public static void rotateOutAnim(RelativeLayout layout, long delay) {
        //获取子View个数
        int childCount = layout.getChildCount();
        //父布局已经隐藏，禁用所有子View的点击事件
        for (int i = 0; i < childCount; i++) {
            layout.getChildAt(i).setEnabled(false);
        }
        RotateAnimation ra = new RotateAnimation(0f, -180f,//开始和结束时的角度
                Animation.RELATIVE_TO_SELF, 0.5f, //相对的x左标
                Animation.RELATIVE_TO_SELF, 1.0f); //相对的y左标
        ra.setDuration(500);
        ra.setStartOffset(delay); //动画延时执行
        ra.setFillAfter(true); //动画结束之后不返回
        ra.setAnimationListener(new MyAnimationListener()); //添加动画监听事件
        layout.startAnimation(ra);
    }

    /**
     * 旋转回来的动画
     */
    public static void rotateInAnim(RelativeLayout layout, long delay) {
        //获取子View个数
        int childCount = layout.getChildCount();
        //父布局已经隐藏，禁用所有子View的点击事件
        for (int i = 0; i < childCount; i++) {
            layout.getChildAt(i).setEnabled(true);
        }
        RotateAnimation ra = new RotateAnimation(-180, 0f,//开始和结束时的角度
                Animation.RELATIVE_TO_SELF, 0.5f, //相对的x左标
                Animation.RELATIVE_TO_SELF, 1.0f); //相对的y左标
        ra.setDuration(500);
        ra.setStartOffset(delay); //动画延时执行
        ra.setFillAfter(true); //动画结束之后不返回
        ra.setAnimationListener(new MyAnimationListener()); //添加动画监听事件
        layout.startAnimation(ra);
    }

    static class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            runningAnimationCount++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            runningAnimationCount--;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
