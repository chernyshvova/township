package com.playrix.engine;

import android.content.Context;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import com.playrix.engine.KeyboardExtension;

public class KeyboardManager {
    public static final String TAG = "[KeyboardManager] ";
    public static InputMethodManager inputMgr = null;
    public static boolean mEditFieldVisible = false;
    public static int mNativeFlags;

    public static void OnClearButton() {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                DummyEdit access$000 = KeyboardManager.getEdit();
                if (access$000 == null || access$000.getText() == null) {
                    Logger.logError("[KeyboardManager.OnClearButton] empty DummyEdit or text");
                } else {
                    access$000.getText().clear();
                }
            }
        });
    }

    public static DummyEdit getEdit() {
        EngineActivity activity = Engine.getActivity();
        if (activity != null) {
            return activity.getEdit();
        }
        return null;
    }

    public static void init(Context context) {
        inputMgr = (InputMethodManager) context.getSystemService("input_method");
    }

    public static KeyboardExtension initKeyboardExtension() {
        final EngineActivity activity = Engine.getActivity();
        if (activity == null) {
            return null;
        }
        if (activity.mKeyboardExtension == null) {
            activity.mKeyboardExtension = new KeyboardExtension(activity, getEdit(), activity.GetParentFramelayout(), new KeyboardExtension.OnWindowFocusChangedListener() {
                public void onFocus(boolean z) {
                    EngineActivity.this.onKeyboardFocus(z);
                }
            }, new KeyboardExtension.OnKeyboardCloseListener() {
                public void onClose() {
                    EngineActivity.this.getEdit().requestFocus();
                }
            });
        }
        return activity.mKeyboardExtension;
    }

    public static native void nativeKeyDown(int i);

    public static native void nativeKeyboardChangePosition(float f);

    public static native void nativeKeyboardHide();

    public static native void nativeKeyboardImeChangeVisibility(boolean z);

    public static native void nativeOnSendButton();

    public static native void nativeTextFieldChanged(String str, int i, int i2, long j, long j2);

    public static native String nativeTextFieldFilter(String str, String str2, int i, int i2);

    public static void notifyKeyboardHide() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                KeyboardManager.nativeKeyboardHide();
            }
        });
        toggleKeyboard(false);
    }

    public static void onPlayrixActivityCreated() {
        initKeyboardExtension();
        setInputFlags(mNativeFlags);
        boolean z = mEditFieldVisible;
        if (z) {
            setInputFieldVisible(z);
        }
    }

    public static void setInputFieldVisible(final boolean z) {
        mEditFieldVisible = z;
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                KeyboardExtension access$200 = KeyboardManager.initKeyboardExtension();
                if (access$200 != null) {
                    access$200.setEditFieldVisible(z);
                }
            }
        });
    }

    public static void setInputFlags(final int i) {
        mNativeFlags = i;
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                DummyEdit access$000 = KeyboardManager.getEdit();
                if (access$000 != null) {
                    access$000.setInputFlags(i);
                } else {
                    Logger.logError("Attempt to set input flags when edit control not ready (ignored)");
                }
            }
        });
    }

    public static void setInputText(String str, int i, int i2, long j, long j2) {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final long j3 = j;
        final long j4 = j2;
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                DummyEdit access$000 = KeyboardManager.getEdit();
                if (access$000 != null) {
                    access$000.setInputText(str2, i3, i4, j3, j4);
                } else {
                    Logger.logError("Attempt to set text when edit control not ready (ignored)");
                }
            }
        });
    }

    public static void toggleKeyboard(final boolean z) {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                EngineActivity activity = Engine.getActivity();
                if (activity != null) {
                    KeyboardExtension keyboardExtension = activity.mKeyboardExtension;
                    if (keyboardExtension != null) {
                        keyboardExtension.setActive(z);
                    }
                    DummyEdit access$000 = KeyboardManager.getEdit();
                    if (KeyboardManager.inputMgr == null || access$000 == null) {
                        Logger.logError("[KeyboardManager] null inputMgr or edit when trying to toggle keyboard");
                    } else if (z) {
                        access$000.requestFocus();
                        KeyboardManager.inputMgr.showSoftInput(access$000, 0, (ResultReceiver) null);
                    } else {
                        KeyboardManager.inputMgr.hideSoftInputFromWindow(access$000.getWindowToken(), 0, (ResultReceiver) null);
                    }
                }
            }
        });
    }
}
