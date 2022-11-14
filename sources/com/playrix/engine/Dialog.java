package com.playrix.engine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

public class Dialog extends AlertDialog {
    public FocusListener mFocusListener = null;

    public static class Builder {
        public Activity mActivity;
        public ButtonInfo[] mButtons = null;
        public boolean mCancelable;
        public CharSequence mMessage;
        public DialogInterface.OnClickListener mNegativeButtonListener = null;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mNeutralButtonListener = null;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener = null;
        public FocusListener mOnFocusListener = null;
        public DialogInterface.OnClickListener mPositiveButtonListener = null;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;

        public static class ButtonInfo {
            public final DialogInterface.OnClickListener mListener;
            public final CharSequence mText;

            public ButtonInfo(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.mText = charSequence;
                this.mListener = onClickListener;
            }
        }

        public Builder(Activity activity) {
            this.mActivity = activity;
        }

        public Dialog create() {
            final Dialog dialog = new Dialog(this.mActivity);
            dialog.setTitle(this.mTitle);
            if (this.mButtons == null) {
                dialog.setMessage(this.mMessage);
                DialogInterface.OnClickListener onClickListener = this.mPositiveButtonListener;
                if (onClickListener != null) {
                    dialog.setButton(-1, this.mPositiveButtonText, onClickListener);
                }
                DialogInterface.OnClickListener onClickListener2 = this.mNegativeButtonListener;
                if (onClickListener2 != null) {
                    dialog.setButton(-2, this.mNegativeButtonText, onClickListener2);
                }
                DialogInterface.OnClickListener onClickListener3 = this.mNeutralButtonListener;
                if (onClickListener3 != null) {
                    dialog.setButton(-3, this.mNeutralButtonText, onClickListener3);
                }
            } else {
                try {
                    LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
                    View inflate = layoutInflater.inflate(C3204R.layout.system_dialog, (ViewGroup) null);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C3204R.C3206id.buttons);
                    for (final int i = 0; i < this.mButtons.length; i++) {
                        final ButtonInfo buttonInfo = this.mButtons[i];
                        AppCompatButton appCompatButton = (AppCompatButton) layoutInflater.inflate(C3204R.layout.system_dialog_button, linearLayout, false);
                        appCompatButton.setText(buttonInfo.mText);
                        if (buttonInfo.mListener != null) {
                            appCompatButton.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    buttonInfo.mListener.onClick(dialog, i);
                                }
                            });
                        }
                        linearLayout.addView(appCompatButton);
                    }
                    ((TextView) inflate.findViewById(C3204R.C3206id.message)).setText(this.mMessage);
                    dialog.setView(inflate);
                } catch (Exception e) {
                    e.toString();
                }
            }
            dialog.setCancelable(this.mCancelable);
            if (this.mCancelable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(this.mOnCancelListener);
            dialog.setFocusListener(this.mOnFocusListener);
            return dialog;
        }

        public Builder setButtons(ButtonInfo[] buttonInfoArr) {
            this.mButtons = buttonInfoArr;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mCancelable = z;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.mMessage = charSequence;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.mNegativeButtonText = charSequence;
            this.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.mNeutralButtonText = charSequence;
            this.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnFocusListener(FocusListener focusListener) {
            this.mOnFocusListener = focusListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.mPositiveButtonText = charSequence;
            this.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }
    }

    public interface FocusListener {
        void onDialogFocusChanged(boolean z);
    }

    public Dialog(Context context) {
        super(context);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        FocusListener focusListener = this.mFocusListener;
        if (focusListener != null) {
            focusListener.onDialogFocusChanged(z);
        }
    }

    public void setFocusListener(FocusListener focusListener) {
        this.mFocusListener = focusListener;
    }

    public void show() {
        TextView textView;
        super.show();
        TextView textView2 = (TextView) findViewById(16908299);
        if (textView2 != null) {
            textView2.setGravity(17);
            textView2.setTextAlignment(4);
        }
        int identifier = getContext().getResources().getIdentifier("alertTitle", "id", "android");
        if (identifier > 0 && (textView = (TextView) findViewById(identifier)) != null) {
            textView.setGravity(17);
            textView.setTextAlignment(4);
        }
    }
}
