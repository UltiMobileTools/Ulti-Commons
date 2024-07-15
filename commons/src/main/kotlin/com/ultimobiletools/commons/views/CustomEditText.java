package com.ultimobiletools.commons.views;

import static com.ultimobiletools.commons.extensions.UltiIntKt.adjustAlpha;
import static com.ultimobiletools.commons.helpers.ConstantsKt.MEDIUM_ALPHA;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;


public class CustomEditText extends AppCompatEditText {

    public CustomEditText(@NonNull Context context) {
        super(context);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setColors(int textColor, int accentColor, int backgroundColor) {
        getBackground().mutate().setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);
        // requires android:textCursorDrawable="@null" in xml to color the cursor too
        setTextColor(textColor);
        setHintTextColor(adjustAlpha(textColor, MEDIUM_ALPHA));
        setLinkTextColor(accentColor);
    }

}
