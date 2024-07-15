package com.ultimobiletools.commons.views.bottommenu;

public interface BottomActionMenuCallback {

    void onItemClicked(BottomActionMenuItem item);

    void onViewCreated(BottomActionMenuView view);

    void onViewDestroyed();
}
