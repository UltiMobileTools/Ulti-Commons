package com.ultimobiletools.commons.views;

import android.content.Context;
import android.util.AttributeSet;

public class CustomButton extends androidx.appcompat.widget.AppCompatButton {

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setColors(int textColor, int accentColor, int backgroundColor) {
        setTextColor(textColor);
    }
}
