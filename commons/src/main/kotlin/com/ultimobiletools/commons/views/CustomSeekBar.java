package com.ultimobiletools.commons.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;

public class CustomSeekBar extends androidx.appcompat.widget.AppCompatSeekBar {

    public CustomSeekBar(Context context) {
        super(context);
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setColors(int textColor, int accentColor, int backgroundColor) {
        if (getProgressDrawable() != null) {
            getProgressDrawable().mutate().setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);
        }
        if (getThumb() != null) {
            getThumb().mutate().setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);
        }
    }
}
