package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.text.Regex;

/* compiled from: SensitiveUserDataUtils.kt */
public final class SensitiveUserDataUtils {
    public static final SensitiveUserDataUtils INSTANCE = new SensitiveUserDataUtils();

    private final boolean isCreditCard(TextView textView) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            String replace = new Regex("\\s").replace(ViewHierarchy.getTextOfView(textView), "");
            int length = replace.length();
            if (length < 12) {
                return false;
            }
            if (length > 19) {
                return false;
            }
            int i2 = length - 1;
            if (i2 >= 0) {
                boolean z = false;
                i = 0;
                while (true) {
                    int i3 = i2 - 1;
                    char charAt = replace.charAt(i2);
                    if (!Character.isDigit(charAt)) {
                        return false;
                    }
                    int digit = Character.digit(charAt, 10);
                    if (digit >= 0) {
                        if (z && (digit = digit * 2) > 9) {
                            digit = (digit % 10) + 1;
                        }
                        i += digit;
                        z = !z;
                        if (i3 < 0) {
                            break;
                        }
                        i2 = i3;
                    } else {
                        throw new IllegalArgumentException("Char " + charAt + " is not a decimal digit");
                    }
                }
            } else {
                i = 0;
            }
            if (i % 10 == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isEmail(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            boolean z = true;
            if (textView.getInputType() == 32) {
                return true;
            }
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            String textOfView = ViewHierarchy.getTextOfView(textView);
            if (textOfView == null) {
                return false;
            }
            if (textOfView.length() != 0) {
                z = false;
            }
            if (z) {
                return false;
            }
            return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPassword(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPersonName(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView.getInputType() == 96;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPhoneNumber(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView.getInputType() == 3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isPostalAddress(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView.getInputType() == 112;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public static final boolean isSensitiveUserData(View view) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (!(view instanceof TextView)) {
                return false;
            }
            if (INSTANCE.isPassword((TextView) view) || INSTANCE.isCreditCard((TextView) view) || INSTANCE.isPersonName((TextView) view) || INSTANCE.isPostalAddress((TextView) view) || INSTANCE.isPhoneNumber((TextView) view) || INSTANCE.isEmail((TextView) view)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
