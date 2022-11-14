package com.playrix.engine;

import android.content.DialogInterface;
import android.util.Log;
import com.playrix.engine.Dialog;

public class SystemDialog {
    public static final int ACTION_CANCEL = -1;
    public static final int ACTION_NEGATIVE = 0;
    public static final int ACTION_NEUTRAL = 1;
    public static final int ACTION_POSITIVE = 2;
    public static final String TAG = "Dialog";
    public static volatile Dialog mCurrentDialog;

    public static native void buttonClickHandler(int i, long j);

    public static void close() {
        Engine.runOnUiThread(new Runnable() {
            public void run() {
                Dialog access$000 = SystemDialog.mCurrentDialog;
                if (access$000 != null) {
                    access$000.dismiss();
                    Dialog unused = SystemDialog.mCurrentDialog = null;
                    Engine.getActivity().onDialogFocusChanged(false);
                }
            }
        });
    }

    public static boolean isPresent() {
        return mCurrentDialog != null;
    }

    public static void show(String str, String str2, String[] strArr, boolean z, boolean z2, final long j) {
        final long j2 = j;
        final String str3 = str;
        final String str4 = str2;
        final boolean z3 = z;
        final String[] strArr2 = strArr;
        final boolean z4 = z2;
        if (!Engine.runOnUiThread(new Runnable() {
            public void run() {
                if (SystemDialog.mCurrentDialog == null) {
                    EngineActivity activity = Engine.getActivity();
                    if (activity == null) {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                SystemDialog.buttonClickHandler(-1, j2);
                            }
                        });
                        return;
                    }
                    Dialog.Builder builder = new Dialog.Builder(activity);
                    builder.setTitle(str3);
                    builder.setMessage(str4);
                    builder.setCancelable(z3);
                    Dialog.Builder.ButtonInfo[] buttonInfoArr = new Dialog.Builder.ButtonInfo[strArr2.length];
                    final int i = 0;
                    while (true) {
                        String[] strArr = strArr2;
                        if (i >= strArr.length) {
                            break;
                        }
                        buttonInfoArr[i] = new Dialog.Builder.ButtonInfo(strArr[i], new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Engine.runOnGLThread(new Runnable() {
                                    public void run() {
                                        C32232 r0 = C32232.this;
                                        SystemDialog.buttonClickHandler(i, j2);
                                    }
                                });
                            }
                        });
                        i++;
                    }
                    builder.setButtons(buttonInfoArr);
                    if (z3) {
                        builder.setCancelable(true);
                        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Dialog unused = SystemDialog.mCurrentDialog = null;
                                Engine.getActivity().onDialogFocusChanged(false);
                                Engine.runOnGLThread(new Runnable() {
                                    public void run() {
                                        SystemDialog.buttonClickHandler(-1, j2);
                                    }
                                });
                            }
                        });
                    }
                    if (!z4) {
                        builder.setOnFocusListener(activity);
                    }
                    Dialog create = builder.create();
                    Dialog unused = SystemDialog.mCurrentDialog = create;
                    ImmersiveMode.showDialog(create);
                    return;
                }
                Log.e(SystemDialog.TAG, "Attempt to show more than one dialog");
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        SystemDialog.buttonClickHandler(-1, j2);
                    }
                });
            }
        })) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    SystemDialog.buttonClickHandler(-1, j);
                }
            });
        }
    }
}
