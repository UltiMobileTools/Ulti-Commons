package com.ultimobiletools.commons.models;
public class CustomTheme {
    private final String label;
    private final int textColorId;
    private final int backgroundColorId;
    private final int primaryColorId;
    private final int appIconColorId;

    public CustomTheme(String label, int textColorId, int backgroundColorId, int primaryColorId, int appIconColorId) {
        this.label = label;
        this.textColorId = textColorId;
        this.backgroundColorId = backgroundColorId;
        this.primaryColorId = primaryColorId;
        this.appIconColorId = appIconColorId;
    }

    public String getLabel() {
        return label;
    }

    public int getTextColorId() {
        return textColorId;
    }

    public int getBackgroundColorId() {
        return backgroundColorId;
    }

    public int getPrimaryColorId() {
        return primaryColorId;
    }

    public int getAppIconColorId() {
        return appIconColorId;
    }
}
