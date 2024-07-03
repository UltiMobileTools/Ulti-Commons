package com.ultimobiletools.commons.views;

import android.content.Context;
import android.util.AttributeSet;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setColors(int textColor, int accentColor, int backgroundColor) {
        setTextColor(textColor);
        setLinkTextColor(accentColor);
    }
}
