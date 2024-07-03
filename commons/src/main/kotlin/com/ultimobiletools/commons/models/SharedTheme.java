package com.ultimobiletools.commons.models;

public class SharedTheme {
    private int textColor;
    private int backgroundColor;
    private int primaryColor;
    private int appIconColor;
    private int lastUpdatedTS;
    private int accentColor;

    public SharedTheme(int textColor, int backgroundColor, int primaryColor, int appIconColor, int accentColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.primaryColor = primaryColor;
        this.appIconColor = appIconColor;
        this.lastUpdatedTS = 0;
        this.accentColor = accentColor;
    }

    public SharedTheme(int textColor, int backgroundColor, int primaryColor, int appIconColor, int lastUpdatedTS, int accentColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.primaryColor = primaryColor;
        this.appIconColor = appIconColor;
        this.lastUpdatedTS = lastUpdatedTS;
        this.accentColor = accentColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public int getAppIconColor() {
        return appIconColor;
    }

    public int getLastUpdatedTS() {
        return lastUpdatedTS;
    }

    public int getAccentColor() {
        return accentColor;
    }
}
