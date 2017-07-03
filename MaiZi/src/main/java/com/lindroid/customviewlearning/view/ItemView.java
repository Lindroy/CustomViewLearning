package com.lindroid.customviewlearning.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lindroid.customviewlearning.R;

/**
 * Created by linyu on 2017/7/2.
 */

public class ItemView extends LinearLayout {
    private TextView tvLeft;
    private TextView tvRight;
    private ImageView ivArrow;

    public ItemView(Context context) {
        super(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_layout, this);
        tvLeft = (TextView) findViewById(R.id.tv_left);
        tvRight = (TextView) findViewById(R.id.tv_right);
        ivArrow = (ImageView) findViewById(R.id.ivArrow);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param leftStr:左边标题文字
     * @param rightStr:右边说明文字
     * @param isShowArrow:是否显示箭头
     */
    public void setView(String leftStr, String rightStr, boolean isShowArrow) {
        if (leftStr != null) {
            tvLeft.setText(leftStr);
        }

        if (rightStr != null) {
            tvRight.setText(rightStr);
        }

        ivArrow.setVisibility(isShowArrow ? VISIBLE : INVISIBLE);
    }
}
