package com.ultimobiletools.commons.interfaces;


import androidx.biometric.auth.AuthPromptHost;

import com.ultimobiletools.commons.views.CustomScrollView;

public interface SecurityTab {

    void initTab(String requiredHash, HashListener listener, CustomScrollView scrollView, AuthPromptHost biometricPromptHost, boolean showBiometricAuthentication);

    void visibilityChanged(boolean isVisible);
}
