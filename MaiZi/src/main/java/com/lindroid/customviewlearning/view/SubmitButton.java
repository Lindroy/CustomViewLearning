package com.lindroid.customviewlearning.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.lindroid.customviewlearning.R;

/**
 * Created by linyu on 2017/5/3.
 * 自定义提交按钮
 */

public class SubmitButton extends Button {
    public SubmitButton(Context context) {
        super(context);
        init();
    }

    public SubmitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SubmitButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setBackgroundResource(R.drawable.btn_submit);
        setTextSize(20);
        setTextColor(getResources().getColor(android.R.color.white));
    }
}
