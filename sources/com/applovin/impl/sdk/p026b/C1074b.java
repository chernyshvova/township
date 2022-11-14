package com.applovin.impl.sdk.p026b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.b.b */
public class C1074b {

    /* renamed from: a */
    public final C1188m f1471a;

    /* renamed from: b */
    public final Activity f1472b;

    /* renamed from: c */
    public AlertDialog f1473c;

    /* renamed from: d */
    public C1081a f1474d;

    /* renamed from: com.applovin.impl.sdk.b.b$a */
    public interface C1081a {
        /* renamed from: a */
        void mo9492a();

        /* renamed from: b */
        void mo9493b();
    }

    public C1074b(Activity activity, C1188m mVar) {
        this.f1471a = mVar;
        this.f1472b = activity;
    }

    /* renamed from: a */
    public void mo10655a() {
        this.f1472b.runOnUiThread(new Runnable() {
            public void run() {
                if (C1074b.this.f1473c != null) {
                    C1074b.this.f1473c.dismiss();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo10656a(final C1057e eVar, @Nullable final Runnable runnable) {
        this.f1472b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(C1074b.this.f1472b);
                builder.setTitle(eVar.mo10604aj());
                String ak = eVar.mo10605ak();
                if (AppLovinSdkUtils.isValidString(ak)) {
                    builder.setMessage(ak);
                }
                builder.setPositiveButton(eVar.mo10606al(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Runnable runnable = runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                builder.setCancelable(false);
                AlertDialog unused = C1074b.this.f1473c = builder.show();
            }
        });
    }

    /* renamed from: a */
    public void mo10657a(C1081a aVar) {
        this.f1474d = aVar;
    }

    /* renamed from: b */
    public void mo10658b() {
        this.f1472b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog unused = C1074b.this.f1473c = new AlertDialog.Builder(C1074b.this.f1472b).setTitle((CharSequence) C1074b.this.f1471a.mo10946a(C1085b.f1596bA)).setMessage((CharSequence) C1074b.this.f1471a.mo10946a(C1085b.f1597bB)).setCancelable(false).setPositiveButton((CharSequence) C1074b.this.f1471a.mo10946a(C1085b.f1599bD), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1074b.this.f1474d.mo9492a();
                    }
                }).setNegativeButton((CharSequence) C1074b.this.f1471a.mo10946a(C1085b.f1598bC), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1074b.this.f1474d.mo9493b();
                    }
                }).show();
            }
        });
    }

    /* renamed from: c */
    public boolean mo10659c() {
        AlertDialog alertDialog = this.f1473c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
