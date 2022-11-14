package com.playrix.engine;

import android.content.Context;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.atomic.AtomicLong;

public class DummyEdit extends AppCompatEditText {
    public static final boolean ALWAYS_USE_SET_TEXT = true;
    public static final boolean DEBUG = false;
    public static final int FLAG_CAP_SENTENCES = 2;
    public static final int FLAG_CURSOR = 8;
    public static final int FLAG_SUGGESTIONS = 4;
    public static final int FLAG_UPPERCASE = 1;
    public static final String TAG = "DummyEdit ";
    public static final AtomicLong currentFieldId = new AtomicLong(0);
    public static int currentFlags;
    public static final AtomicLong lastChangeId = new AtomicLong(0);
    public static long lastChangedField = -1;
    public static final Object lastChangedLocker = new Object();
    public static int lastChangedSelectionEnd = -1;
    public static int lastChangedSelectionStart = -1;
    public static String lastChangedText = null;
    public boolean cursorEnabled = false;
    public final TextInputWrapper listener = new TextInputWrapper();

    public static class CustomFilter implements InputFilter {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (i2 <= i || charSequence.length() == 0 || !NativeThread.getInstance().isLibrariesLoaded()) {
                return null;
            }
            CharSequence subSequence = charSequence.subSequence(i, i2);
            String nativeTextFieldFilter = KeyboardManager.nativeTextFieldFilter(subSequence.toString(), spanned.toString(), i3, i4);
            if (nativeTextFieldFilter.equals(subSequence.toString())) {
                return null;
            }
            if (!(charSequence instanceof Spanned)) {
                return nativeTextFieldFilter;
            }
            SpannableString spannableString = new SpannableString(nativeTextFieldFilter);
            TextUtils.copySpansFrom((Spanned) charSequence, i, nativeTextFieldFilter.length() + i, (Class) null, spannableString, 0);
            return spannableString;
        }
    }

    public class TextInputWrapper implements TextWatcher, TextView.OnEditorActionListener {
        public boolean enableSendTextChanged;

        public TextInputWrapper() {
            this.enableSendTextChanged = true;
        }

        public void afterTextChanged(Editable editable) {
            DummyEdit.debugLog("afterTextChanged: <" + editable + ">, span trans=" + editable.nextSpanTransition(0, 1009, (Class) null), editable);
            DummyEdit dummyEdit = DummyEdit.this;
            sendTextChanged(editable.toString(), dummyEdit.getSelectionStart(), dummyEdit.getSelectionEnd());
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("beforeTextChanged: <");
            outline24.append(charSequence.toString());
            outline24.append("> st=");
            outline24.append(i);
            outline24.append(" ");
            outline24.append(i2);
            outline24.append("<->");
            outline24.append(i3);
            DummyEdit.debugLog(outline24.toString(), charSequence);
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            DummyEdit.debugLog("onEditorAction: id=" + i + " ev=" + keyEvent, (CharSequence) null);
            if ((i != 0 || keyEvent == null || keyEvent.getAction() != 0) && i != 6) {
                return false;
            }
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    KeyboardManager.nativeKeyDown(-66);
                }
            });
            return false;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("onTextChanged: newchars=<");
            outline24.append(charSequence.subSequence(i, i + i3));
            outline24.append("> st=");
            outline24.append(i);
            outline24.append(" ");
            outline24.append(i2);
            outline24.append("<->");
            outline24.append(i3);
            DummyEdit.debugLog(outline24.toString(), charSequence);
        }

        public void sendTextChanged(String str, int i, int i2) {
            final long j = DummyEdit.currentFieldId.get();
            if (DummyEdit.this.processChangeTextField(j, str, i, i2) && this.enableSendTextChanged) {
                final long incrementAndGet = DummyEdit.lastChangeId.incrementAndGet();
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        KeyboardManager.nativeTextFieldChanged(str2, i3, i4, incrementAndGet, j);
                    }
                });
            }
        }
    }

    public DummyEdit(Context context) {
        super(context);
        init(context);
    }

    public static void debugLog(String str) {
        debugLog(str, (CharSequence) null);
    }

    public static void debugLog(String str, CharSequence charSequence) {
    }

    private void init(Context context) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("DummyEdit IMEs Default: ");
        outline24.append(Settings.Secure.getString(context.getContentResolver(), "default_input_method"));
        outline24.append("; enabled: ");
        outline24.append(Settings.Secure.getString(context.getContentResolver(), "enabled_input_methods"));
        Logger.logInfo(outline24.toString());
        setImeOptions(301989894);
        setInputType(540673);
        currentFlags = 2;
        setCursorEnabled(false);
        setOnEditorActionListener(this.listener);
        addTextChangedListener(this.listener);
        setFilters(new InputFilter[]{new CustomFilter()});
    }

    private void moveSelectionToEnd() {
        try {
            setSelection(length());
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("moveSelectionToEnd failed: "));
        }
    }

    /* access modifiers changed from: private */
    public boolean processChangeTextField(long j, String str, int i, int i2) {
        synchronized (lastChangedLocker) {
            if (j == lastChangedField && i == lastChangedSelectionStart && i2 == lastChangedSelectionEnd && lastChangedText != null && lastChangedText.equals(str)) {
                return false;
            }
            lastChangedField = j;
            lastChangedSelectionStart = i;
            lastChangedSelectionEnd = i2;
            lastChangedText = str;
            return true;
        }
    }

    public static int updateFlags(int i, boolean z, int i2) {
        return z ? i | i2 : i & (i2 ^ -1);
    }

    public void disableListener() {
        removeTextChangedListener(this.listener);
    }

    public void enableListener() {
        addTextChangedListener(this.listener);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        debugLog("DummyEdit onKeyDown c=" + i + " ev=" + keyEvent);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (i != 4 && !this.cursorEnabled) {
            moveSelectionToEnd();
        }
        return onKeyDown;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        debugLog("onKeyPreIme c=" + i + " ev=" + keyEvent);
        if (i == 4 && keyEvent.getAction() == 1) {
            KeyboardManager.notifyKeyboardHide();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void onSelectionChanged(int i, int i2) {
        if (!this.cursorEnabled) {
            int length = length();
            if (length <= 0) {
                return;
            }
            if (i != length || i2 != length) {
                moveSelectionToEnd();
                return;
            }
            return;
        }
        TextInputWrapper textInputWrapper = this.listener;
        if (textInputWrapper != null) {
            textInputWrapper.sendTextChanged(getEditableText().toString(), i, i2);
        }
        super.onSelectionChanged(i, i2);
    }

    public void setCursorEnabled(boolean z) {
        debugLog("setCursorEnabled " + z);
        this.cursorEnabled = z;
        boolean isFocusable = isFocusable();
        boolean isFocusableInTouchMode = isFocusableInTouchMode();
        boolean isClickable = isClickable();
        boolean isLongClickable = isLongClickable();
        if (!z) {
            setTextIsSelectable(false);
            setCursorVisible(false);
            setMovementMethod((MovementMethod) null);
        } else {
            setTextIsSelectable(true);
            setCursorVisible(true);
            setMovementMethod(getDefaultMovementMethod());
        }
        setFocusable(isFocusable);
        setFocusableInTouchMode(isFocusableInTouchMode);
        setClickable(isClickable);
        setLongClickable(isLongClickable);
        moveSelectionToEnd();
    }

    public void setInputFlags(int i) {
        int inputType = getInputType();
        boolean z = false;
        int updateFlags = updateFlags(updateFlags(updateFlags(inputType, (i & 2) == 2, 16384), (i & 1) == 1, 4096), (i & 4) != 4, 524288);
        if ((i & 8) == 8) {
            z = true;
        }
        setCursorEnabled(z);
        currentFlags = i;
        if (updateFlags != inputType) {
            debugLog("setInputType " + updateFlags);
            setInputType(updateFlags);
        }
    }

    public void setInputText(String str, int i, int i2, long j, long j2) {
        StringBuilder sb;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        long j3 = j;
        currentFieldId.set(j2);
        long j4 = lastChangeId.get();
        if (j3 == 0 || j3 == j4) {
            Editable editableText = getEditableText();
            if (editableText == null) {
                debugLog("setInputText: <" + str2 + "> skipped update (none edit)");
                return;
            }
            boolean z = str2.contentEquals(editableText) || ((currentFlags & 1) == 1 && str2.equalsIgnoreCase(editableText.toString()));
            boolean z2 = !this.cursorEnabled ? getSelectionStart() == length() && getSelectionEnd() == length() : getSelectionStart() == i3 && getSelectionEnd() == i4;
            if (!z || !z2) {
                debugLog("setInputText: <" + str2 + ">!=<" + editableText + ">, current id=" + j4, editableText);
                try {
                    this.listener.enableSendTextChanged = false;
                    disableListener();
                    beginBatchEdit();
                    if (!z) {
                        setText(str);
                    }
                    if (!this.cursorEnabled) {
                        moveSelectionToEnd();
                    } else {
                        setSelection(Math.min(i3, length()), Math.min(i4, length()));
                    }
                    processChangeTextField(currentFieldId.get(), getEditableText().toString(), getSelectionStart(), getSelectionEnd());
                    endBatchEdit();
                    sb = new StringBuilder();
                } catch (Exception e) {
                    Logger.logError("setInputText failed: " + e.toString());
                    processChangeTextField(currentFieldId.get(), getEditableText().toString(), getSelectionStart(), getSelectionEnd());
                    endBatchEdit();
                    sb = new StringBuilder();
                } catch (Throwable th) {
                    processChangeTextField(currentFieldId.get(), getEditableText().toString(), getSelectionStart(), getSelectionEnd());
                    endBatchEdit();
                    debugLog("setInputText: after setText and cursor move <" + getText() + ">", getEditableText());
                    enableListener();
                    this.listener.enableSendTextChanged = true;
                    throw th;
                }
                sb.append("setInputText: after setText and cursor move <");
                sb.append(getText());
                sb.append(">");
                debugLog(sb.toString(), getEditableText());
                enableListener();
                this.listener.enableSendTextChanged = true;
                return;
            }
            debugLog("setInputText: <" + str2 + "> == <" + editableText + "> skipped update (eq)");
            return;
        }
        debugLog("setInputText: skipped stale change to <" + str2 + "> for id=" + j3 + ", current id=" + j4);
    }

    public DummyEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DummyEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
