package com.ultimobiletools.commons.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;

public class CustomAutoCompleteTextView extends androidx.appcompat.widget.AppCompatAutoCompleteTextView {

    public CustomAutoCompleteTextView(Context context) {
        super(context);
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setColors(int textColor, int accentColor, int backgroundColor) {
        getBackground().mutate().setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);

        // requires android:textCursorDrawable="@null" in xml to color the cursor too
        setTextColor(textColor);
        setHintTextColor(adjustAlpha(textColor, 0.5f));
        setLinkTextColor(accentColor);
    }

    private int adjustAlpha(int color, float alpha) {
        int a = Math.round(Color.alpha(color) * alpha);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        return Color.argb(a, r, g, b);
    }
}
