package com.ultimobiletools.commons.models;

public final class CustomLicense {
    private final long id;
    private final int titleId;
    private final int textId;
    private final int urlId;

    public CustomLicense(long id, int titleId, int textId, int urlId) {
        this.id = id;
        this.titleId = titleId;
        this.textId = textId;
        this.urlId = urlId;
    }

    public long getId() {
        return id;
    }

    public int getTitleId() {
        return titleId;
    }

    public int getTextId() {
        return textId;
    }

    public int getUrlId() {
        return urlId;
    }
}
