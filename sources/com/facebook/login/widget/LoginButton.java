package com.facebook.login.widget;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.C1541R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.C1563R;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class LoginButton extends FacebookButtonBase {
    public static final int MAX_BUTTON_TRANSPARENCY = 255;
    public static final int MIN_BUTTON_TRANSPARENCY = 0;
    public static final String TAG = LoginButton.class.getName();
    public AccessTokenTracker accessTokenTracker;
    @Nullable
    public ActivityResultLauncher<Collection<? extends String>> androidXLoginCaller;
    @Nullable
    public CallbackManager callbackManager;
    public boolean confirmLogout;
    public Float customButtonRadius;
    public int customButtonTransparency;
    public final String loggerID;
    public String loginLogoutEventName;
    public LoginManager loginManager;
    public String loginText;
    public String logoutText;
    public LoginButtonProperties properties;
    public boolean toolTipChecked;
    public long toolTipDisplayTime;
    public ToolTipMode toolTipMode;
    public ToolTipPopup toolTipPopup;
    public ToolTipPopup.Style toolTipStyle;

    /* renamed from: com.facebook.login.widget.LoginButton$4 */
    public static /* synthetic */ class C15724 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.facebook.login.widget.LoginButton$ToolTipMode[] r0 = com.facebook.login.widget.LoginButton.ToolTipMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode = r0
                r1 = 1
                com.facebook.login.widget.LoginButton$ToolTipMode r2 = com.facebook.login.widget.LoginButton.ToolTipMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.login.widget.LoginButton$ToolTipMode r3 = com.facebook.login.widget.LoginButton.ToolTipMode.DISPLAY_ALWAYS     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.login.widget.LoginButton$ToolTipMode r2 = com.facebook.login.widget.LoginButton.ToolTipMode.NEVER_DISPLAY     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.widget.LoginButton.C15724.<clinit>():void");
        }
    }

    public static class LoginButtonProperties {
        public String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        public DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        @Nullable
        public String messengerPageId;
        public List<String> permissions = Collections.emptyList();
        public boolean resetMessengerState;
        public boolean shouldSkipAccountDeduplication = false;
        public LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;

        public void clearPermissions() {
            this.permissions = null;
        }

        public String getAuthType() {
            return this.authType;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public LoginTargetApp getLoginTargetApp() {
            return this.targetApp;
        }

        @Nullable
        public String getMessengerPageId() {
            return this.messengerPageId;
        }

        public List<String> getPermissions() {
            return this.permissions;
        }

        public boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public void setAuthType(String str) {
            this.authType = str;
        }

        public void setDefaultAudience(DefaultAudience defaultAudience2) {
            this.defaultAudience = defaultAudience2;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior2) {
            this.loginBehavior = loginBehavior2;
        }

        public void setLoginTargetApp(LoginTargetApp loginTargetApp) {
            this.targetApp = loginTargetApp;
        }

        public void setMessengerPageId(@Nullable String str) {
            this.messengerPageId = str;
        }

        public void setPermissions(List<String> list) {
            this.permissions = list;
        }

        public void setResetMessengerState(boolean z) {
            this.resetMessengerState = z;
        }

        public void setShouldSkipAccountDeduplication(boolean z) {
            this.shouldSkipAccountDeduplication = z;
        }
    }

    public class LoginClickListener implements View.OnClickListener {
        public LoginClickListener() {
        }

        public LoginManager getLoginManager() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager instance = LoginManager.getInstance();
                instance.setDefaultAudience(LoginButton.this.getDefaultAudience());
                instance.setLoginBehavior(LoginButton.this.getLoginBehavior());
                instance.setLoginTargetApp(getLoginTargetApp());
                instance.setAuthType(LoginButton.this.getAuthType());
                instance.setFamilyLogin(isFamilyLogin());
                instance.setShouldSkipAccountDeduplication(LoginButton.this.getShouldSkipAccountDeduplication());
                instance.setMessengerPageId(LoginButton.this.getMessengerPageId());
                instance.setResetMessengerState(LoginButton.this.getResetMessengerState());
                return instance;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public LoginTargetApp getLoginTargetApp() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return LoginTargetApp.FACEBOOK;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public boolean isFamilyLogin() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
            }
            return false;
        }

        public void onClick(View view) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginButton.this.callExternalOnClickListener(view);
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    if (AccessToken.isCurrentAccessTokenActive()) {
                        performLogout(LoginButton.this.getContext());
                    } else {
                        performLogin();
                    }
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(LoginButton.this.getContext());
                    Bundle bundle = new Bundle();
                    int i = 0;
                    bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
                    if (AccessToken.isCurrentAccessTokenActive()) {
                        i = 1;
                    }
                    bundle.putInt("access_token_expired", i);
                    internalAppEventsLogger.logEventImplicitly(LoginButton.this.loginLogoutEventName, bundle);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public void performLogin() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginManager loginManager = getLoginManager();
                    if (LoginButton.this.androidXLoginCaller != null) {
                        ((LoginManager.FacebookLoginActivityResultContract) LoginButton.this.androidXLoginCaller.getContract()).setCallbackManager(LoginButton.this.callbackManager != null ? LoginButton.this.callbackManager : new CallbackManagerImpl());
                        LoginButton.this.androidXLoginCaller.launch(LoginButton.this.properties.permissions);
                    } else if (LoginButton.this.getFragment() != null) {
                        loginManager.logIn(LoginButton.this.getFragment(), (Collection<String>) LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    } else if (LoginButton.this.getNativeFragment() != null) {
                        loginManager.logIn(LoginButton.this.getNativeFragment(), (Collection<String>) LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    } else {
                        loginManager.logIn(LoginButton.this.getActivity(), (Collection<String>) LoginButton.this.properties.permissions, LoginButton.this.getLoggerID());
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public void performLogout(Context context) {
            String str;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    final LoginManager loginManager = getLoginManager();
                    if (LoginButton.this.confirmLogout) {
                        String string = LoginButton.this.getResources().getString(C1563R.string.com_facebook_loginview_log_out_action);
                        String string2 = LoginButton.this.getResources().getString(C1563R.string.com_facebook_loginview_cancel_action);
                        Profile currentProfile = Profile.getCurrentProfile();
                        if (currentProfile == null || currentProfile.getName() == null) {
                            str = LoginButton.this.getResources().getString(C1563R.string.com_facebook_loginview_logged_in_using_facebook);
                        } else {
                            str = String.format(LoginButton.this.getResources().getString(C1563R.string.com_facebook_loginview_logged_in_as), new Object[]{currentProfile.getName()});
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage(str).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                loginManager.logOut();
                            }
                        }).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                        builder.create().show();
                        return;
                    }
                    loginManager.logOut();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static ToolTipMode DEFAULT;
        public int intValue;
        public String stringValue;

        /* access modifiers changed from: public */
        static {
            ToolTipMode toolTipMode;
            DEFAULT = toolTipMode;
        }

        /* access modifiers changed from: public */
        ToolTipMode(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public static ToolTipMode fromInt(int i) {
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == i) {
                    return toolTipMode;
                }
            }
            return null;
        }

        public int getValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    public LoginButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    private void checkToolTipSettings() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                int ordinal = this.toolTipMode.ordinal();
                if (ordinal == 0) {
                    final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    final FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                                    LoginButton.this.getActivity().runOnUiThread(new Runnable() {
                                        public void run() {
                                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                                try {
                                                    LoginButton.this.showToolTipPerSettings(queryAppSettings);
                                                } catch (Throwable th) {
                                                    CrashShieldHandler.handleThrowable(th, this);
                                                }
                                            }
                                        }
                                    });
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                } else if (ordinal == 1) {
                    displayToolTip(getResources().getString(C1563R.string.com_facebook_tooltip_default));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void displayToolTip(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ToolTipPopup toolTipPopup2 = new ToolTipPopup(str, this);
                this.toolTipPopup = toolTipPopup2;
                toolTipPopup2.setStyle(this.toolTipStyle);
                this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
                this.toolTipPopup.show();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private int measureButtonWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (!CrashShieldHandler.isObjectCrashing(this) && fetchedAppSettings != null) {
            try {
                if (fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
                    displayToolTip(fetchedAppSettings.getNuxContent());
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.configureButton(context, attributeSet, i, i2);
                setInternalOnClickListener(getNewLoginClickListener());
                parseLoginButtonAttributes(context, attributeSet, i, i2);
                if (isInEditMode()) {
                    setBackgroundColor(getResources().getColor(C1541R.color.com_facebook_blue));
                    this.loginText = "Continue with Facebook";
                } else {
                    this.accessTokenTracker = new AccessTokenTracker() {
                        public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                            LoginButton.this.setButtonText();
                            LoginButton.this.setButtonIcon();
                        }
                    };
                }
                setButtonText();
                setButtonRadius();
                setButtonTransparency();
                setButtonIcon();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void dismissToolTip() {
        ToolTipPopup toolTipPopup2 = this.toolTipPopup;
        if (toolTipPopup2 != null) {
            toolTipPopup2.dismiss();
            this.toolTipPopup = null;
        }
    }

    public String getAuthType() {
        return this.properties.getAuthType();
    }

    @Nullable
    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public int getDefaultRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public int getDefaultStyleResource() {
        return C1563R.style.com_facebook_loginview_default_style;
    }

    public String getLoggerID() {
        return this.loggerID;
    }

    public LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    @StringRes
    public int getLoginButtonContinueLabel() {
        return C1563R.string.com_facebook_loginview_log_in_button_continue;
    }

    public int getLoginButtonWidth(int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Resources resources = getResources();
            String str = this.loginText;
            if (str == null) {
                str = resources.getString(C1563R.string.com_facebook_loginview_log_in_button_continue);
                int measureButtonWidth = measureButtonWidth(str);
                if (Button.resolveSize(measureButtonWidth, i) < measureButtonWidth) {
                    str = resources.getString(C1563R.string.com_facebook_loginview_log_in_button);
                }
            }
            return measureButtonWidth(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public LoginManager getLoginManager() {
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        return this.loginManager;
    }

    public LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    @Nullable
    public String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener();
    }

    public List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    public boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public void onAttachedToWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onAttachedToWindow();
                if (getContext() instanceof ActivityResultRegistryOwner) {
                    this.androidXLoginCaller = ((ActivityResultRegistryOwner) getContext()).getActivityResultRegistry().register("facebook-login", getLoginManager().createLogInActivityResultContract(this.callbackManager, this.loggerID), new ActivityResultCallback<CallbackManager.ActivityResultParameters>() {
                        public void onActivityResult(CallbackManager.ActivityResultParameters activityResultParameters) {
                        }
                    });
                }
                if (this.accessTokenTracker != null && !this.accessTokenTracker.isTracking()) {
                    this.accessTokenTracker.startTracking();
                    setButtonText();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onDetachedFromWindow();
                if (this.androidXLoginCaller != null) {
                    this.androidXLoginCaller.unregister();
                }
                if (this.accessTokenTracker != null) {
                    this.accessTokenTracker.stopTracking();
                }
                dismissToolTip();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onDraw(canvas);
                if (!this.toolTipChecked && !isInEditMode()) {
                    this.toolTipChecked = true;
                    checkToolTipSettings();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onLayout(z, i, i2, i3, i4);
                setButtonText();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
                int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
                Resources resources = getResources();
                int loginButtonWidth = getLoginButtonWidth(i);
                String str = this.logoutText;
                if (str == null) {
                    str = resources.getString(C1563R.string.com_facebook_loginview_log_out_button);
                }
                setMeasuredDimension(Button.resolveSize(Math.max(loginButtonWidth, measureButtonWidth(str)), i), compoundPaddingTop);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onVisibilityChanged(View view, int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onVisibilityChanged(view, i);
                if (i != 0) {
                    dismissToolTip();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.toolTipMode = ToolTipMode.DEFAULT;
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1563R.styleable.com_facebook_login_view, i, i2);
                this.confirmLogout = obtainStyledAttributes.getBoolean(C1563R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
                this.loginText = obtainStyledAttributes.getString(C1563R.styleable.com_facebook_login_view_com_facebook_login_text);
                this.logoutText = obtainStyledAttributes.getString(C1563R.styleable.com_facebook_login_view_com_facebook_logout_text);
                this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(C1563R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
                if (obtainStyledAttributes.hasValue(C1563R.styleable.com_facebook_login_view_com_facebook_login_button_radius)) {
                    this.customButtonRadius = Float.valueOf(obtainStyledAttributes.getDimension(C1563R.styleable.com_facebook_login_view_com_facebook_login_button_radius, 0.0f));
                }
                int integer = obtainStyledAttributes.getInteger(C1563R.styleable.com_facebook_login_view_com_facebook_login_button_transparency, 255);
                this.customButtonTransparency = integer;
                if (integer < 0) {
                    this.customButtonTransparency = 0;
                }
                if (this.customButtonTransparency > 255) {
                    this.customButtonTransparency = 255;
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<LoginResult> facebookCallback) {
        getLoginManager().registerCallback(callbackManager2, facebookCallback);
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            Log.w(TAG, "You're registering a callback on the one Facebook login button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public void setAuthType(String str) {
        this.properties.setAuthType(str);
    }

    public void setButtonIcon() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), C1541R.C1542drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @TargetApi(29)
    public void setButtonRadius() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.customButtonRadius != null) {
                    Drawable background = getBackground();
                    if (Build.VERSION.SDK_INT >= 29 && (background instanceof StateListDrawable)) {
                        StateListDrawable stateListDrawable = (StateListDrawable) background;
                        for (int i = 0; i < stateListDrawable.getStateCount(); i++) {
                            GradientDrawable gradientDrawable = (GradientDrawable) stateListDrawable.getStateDrawable(i);
                            if (gradientDrawable != null) {
                                gradientDrawable.setCornerRadius(this.customButtonRadius.floatValue());
                            }
                        }
                    }
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setCornerRadius(this.customButtonRadius.floatValue());
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setButtonText() {
        String str;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Resources resources = getResources();
                if (!isInEditMode() && AccessToken.isCurrentAccessTokenActive()) {
                    if (this.logoutText != null) {
                        str = this.logoutText;
                    } else {
                        str = resources.getString(C1563R.string.com_facebook_loginview_log_out_button);
                    }
                    setText(str);
                } else if (this.loginText != null) {
                    setText(this.loginText);
                } else {
                    String string = resources.getString(getLoginButtonContinueLabel());
                    int width = getWidth();
                    if (width != 0 && measureButtonWidth(string) > width) {
                        string = resources.getString(C1563R.string.com_facebook_loginview_log_in_button);
                    }
                    setText(string);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setButtonTransparency() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                getBackground().setAlpha(this.customButtonTransparency);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.properties.setDefaultAudience(defaultAudience);
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.properties.setLoginBehavior(loginBehavior);
    }

    public void setLoginManager(LoginManager loginManager2) {
        this.loginManager = loginManager2;
    }

    public void setLoginTargetApp(LoginTargetApp loginTargetApp) {
        this.properties.setLoginTargetApp(loginTargetApp);
    }

    public void setLoginText(String str) {
        this.loginText = str;
        setButtonText();
    }

    public void setLogoutText(String str) {
        this.logoutText = str;
        setButtonText();
    }

    public void setMessengerPageId(String str) {
        this.properties.setMessengerPageId(str);
    }

    public void setPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setReadPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setResetMessengerState(boolean z) {
        this.properties.setResetMessengerState(z);
    }

    public void setToolTipDisplayTime(long j) {
        this.toolTipDisplayTime = j;
    }

    public void setToolTipMode(ToolTipMode toolTipMode2) {
        this.toolTipMode = toolTipMode2;
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.toolTipStyle = style;
    }

    public void unregisterCallback(CallbackManager callbackManager2) {
        getLoginManager().unregisterCallback(callbackManager2);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public void setPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setPublishPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setReadPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        super(context, attributeSet, i, i2, str, str2);
        this.properties = new LoginButtonProperties();
        this.loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.customButtonTransparency = 255;
        this.loggerID = UUID.randomUUID().toString();
        this.callbackManager = null;
        this.androidXLoginCaller = null;
    }
}
