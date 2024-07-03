package com.ultimobiletools.commons.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

public class CustomAppCompatCheckbox extends AppCompatCheckBox {

    public CustomAppCompatCheckbox(Context context) {
        super(context);
    }

    public CustomAppCompatCheckbox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomAppCompatCheckbox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setColors(int textColor, int accentColor, int backgroundColor) {
        setTextColor(textColor);
        int[][] states = new int[][]{
            new int[]{-android.R.attr.state_checked},
            new int[]{android.R.attr.state_checked}
        };
        int[] colors = new int[]{
            adjustAlpha(textColor, 0.6f),
            accentColor
        };
        ColorStateList colorStateList = new ColorStateList(states, colors);
        setButtonTintList(colorStateList);
    }

    private int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
