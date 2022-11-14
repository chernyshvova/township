package com.playrix.engine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AsanaTaskDialog {
    public Activity _activity = null;
    public Button _buttonCancel = null;
    public Button _buttonCreate = null;
    public CheckBox _checkScreenshot = null;
    public AlertDialog _dialog = null;
    public EditText _editDescription = null;
    public EditText _editFollowers = null;
    public EditText _editTitle = null;
    public TextView _progressText = null;
    public View _spinner = null;
    public Spinner _spinnerAuthor = null;
    public ArrayAdapter<String> _spinnerAuthorAdapter = null;
    public Spinner _spinnerFollowerSelect = null;
    public ArrayAdapter<String> _spinnerFollowerSelectAdapter = null;
    public boolean _spinnerShown = false;
    public TextView _textInfo = null;

    public class FollowerSelectListener implements AdapterView.OnItemSelectedListener {
        public FollowerSelectListener() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (adapterView == AsanaTaskDialog.this._spinnerFollowerSelect) {
                AsanaTaskDialog.this._editFollowers.setText(AsanaTaskDialog.nativeOnAddFollower(AsanaTaskDialog.this._editFollowers.getText().toString(), i));
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public AsanaTaskDialog(Activity activity) {
        this._activity = activity;
    }

    public static native String nativeOnAddFollower(String str, int i);

    public static native void nativeOnCreate(String str, String str2, int i, String str3, boolean z);

    public static native void nativeOnDismiss();

    /* access modifiers changed from: private */
    public void processCreate() {
        final int selectedItemPosition = this._spinnerAuthor.getSelectedItemPosition();
        final String obj = this._editTitle.getText().toString();
        final String obj2 = this._editDescription.getText().toString();
        final String obj3 = this._editFollowers.getText().toString();
        final boolean isChecked = this._checkScreenshot.isChecked();
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.nativeOnCreate(obj, obj2, selectedItemPosition, obj3, isChecked);
            }
        });
    }

    public static AsanaTaskDialog show() {
        EngineActivity activity = Engine.getActivity();
        if (activity == null) {
            return null;
        }
        AsanaTaskDialog asanaTaskDialog = new AsanaTaskDialog(activity);
        asanaTaskDialog.showDialog();
        return asanaTaskDialog;
    }

    private void showDialog() {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AsanaTaskDialog.this._activity);
                    builder.setTitle(C3204R.string.asana_task_dialog_title);
                    View inflate = AsanaTaskDialog.this._activity.getLayoutInflater().inflate(C3204R.layout.asana_task_dialog, (ViewGroup) null);
                    builder.setView(inflate);
                    AlertDialog unused = AsanaTaskDialog.this._dialog = builder.create();
                    AsanaTaskDialog.this._dialog.setCancelable(false);
                    AsanaTaskDialog.this._dialog.setCanceledOnTouchOutside(false);
                    C30271 r0 = new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            Engine.runOnGLThread(new Runnable() {
                                public void run() {
                                    AsanaTaskDialog.nativeOnDismiss();
                                }
                            });
                        }
                    };
                    Button unused2 = AsanaTaskDialog.this._buttonCreate = (Button) inflate.findViewById(C3204R.C3206id.btn_create);
                    AsanaTaskDialog.this._buttonCreate.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AsanaTaskDialog.this.processCreate();
                        }
                    });
                    Button unused3 = AsanaTaskDialog.this._buttonCancel = (Button) inflate.findViewById(C3204R.C3206id.btn_cancel);
                    AsanaTaskDialog.this._buttonCancel.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AsanaTaskDialog.this._dialog.dismiss();
                        }
                    });
                    EditText unused4 = AsanaTaskDialog.this._editTitle = (EditText) inflate.findViewById(C3204R.C3206id.edit_title);
                    EditText unused5 = AsanaTaskDialog.this._editDescription = (EditText) inflate.findViewById(C3204R.C3206id.edit_description);
                    Spinner unused6 = AsanaTaskDialog.this._spinnerAuthor = (Spinner) inflate.findViewById(C3204R.C3206id.spinner_author);
                    ArrayAdapter unused7 = AsanaTaskDialog.this._spinnerAuthorAdapter = new ArrayAdapter(AsanaTaskDialog.this._activity, 17367043);
                    AsanaTaskDialog.this._spinnerAuthor.setAdapter(AsanaTaskDialog.this._spinnerAuthorAdapter);
                    EditText unused8 = AsanaTaskDialog.this._editFollowers = (EditText) inflate.findViewById(C3204R.C3206id.edit_followers);
                    Spinner unused9 = AsanaTaskDialog.this._spinnerFollowerSelect = (Spinner) inflate.findViewById(C3204R.C3206id.spinner_follower_selector);
                    ArrayAdapter unused10 = AsanaTaskDialog.this._spinnerFollowerSelectAdapter = new ArrayAdapter(AsanaTaskDialog.this._activity, 17367043);
                    AsanaTaskDialog.this._spinnerFollowerSelect.setAdapter(AsanaTaskDialog.this._spinnerFollowerSelectAdapter);
                    AsanaTaskDialog.this._spinnerFollowerSelect.setOnItemSelectedListener(new FollowerSelectListener());
                    CheckBox unused11 = AsanaTaskDialog.this._checkScreenshot = (CheckBox) inflate.findViewById(C3204R.C3206id.check_screenshot);
                    TextView unused12 = AsanaTaskDialog.this._textInfo = (TextView) inflate.findViewById(C3204R.C3206id.text_info);
                    TextView unused13 = AsanaTaskDialog.this._progressText = (TextView) inflate.findViewById(C3204R.C3206id.progress_dialog_text);
                    View unused14 = AsanaTaskDialog.this._spinner = inflate.findViewById(C3204R.C3206id.progress_dialog);
                    AsanaTaskDialog.this._spinner.setVisibility(4);
                    ImmersiveMode.showDialog(AsanaTaskDialog.this._dialog, r0);
                } catch (Exception unused15) {
                }
            }
        });
    }

    public void addAuthor(final String str) {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._spinnerAuthorAdapter.add(str);
            }
        });
    }

    public void clearAuthors() {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._spinnerAuthorAdapter.clear();
            }
        });
    }

    public void hide() {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._dialog.dismiss();
            }
        });
    }

    public void selectAuthor(final int i) {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._spinnerAuthor.setSelection(i);
            }
        });
    }

    public void setData(String str, String str2, String str3, boolean z) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z2 = z;
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._editTitle.setText(str4);
                AsanaTaskDialog.this._editDescription.setText(str5);
                AsanaTaskDialog.this._editFollowers.setText(str6);
                AsanaTaskDialog.this._checkScreenshot.setChecked(z2);
            }
        });
    }

    public void setFollowers(final String[] strArr) {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._spinnerFollowerSelectAdapter.clear();
                for (String add : strArr) {
                    AsanaTaskDialog.this._spinnerFollowerSelectAdapter.add(add);
                }
            }
        });
    }

    public void setInfo(final String str) {
        this._activity.runOnUiThread(new Runnable() {
            public void run() {
                AsanaTaskDialog.this._textInfo.setText(str);
            }
        });
    }

    public void showWaitingMessage(final String str, final boolean z) {
        if (this._spinnerShown != z) {
            this._spinnerShown = z;
            this._activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        AsanaTaskDialog.this._activity.getWindow().setFlags(16, 16);
                        AsanaTaskDialog.this._progressText.setText(str);
                        AsanaTaskDialog.this._spinner.setVisibility(0);
                        AsanaTaskDialog.this._buttonCreate.setVisibility(4);
                        AsanaTaskDialog.this._buttonCancel.setVisibility(4);
                        return;
                    }
                    AsanaTaskDialog.this._spinner.setVisibility(8);
                    AsanaTaskDialog.this._buttonCreate.setVisibility(0);
                    AsanaTaskDialog.this._buttonCancel.setVisibility(0);
                    AsanaTaskDialog.this._activity.getWindow().clearFlags(16);
                }
            });
        }
    }
}
