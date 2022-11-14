package com.applovin.impl.mediation.debugger.p017ui.p022d;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.b */
public class C0928b {

    /* renamed from: a */
    public TextView f1019a;

    /* renamed from: b */
    public TextView f1020b;

    /* renamed from: c */
    public ImageView f1021c;

    /* renamed from: d */
    public ImageView f1022d;

    /* renamed from: e */
    public C0929c f1023e;

    /* renamed from: f */
    public int f1024f;

    /* renamed from: a */
    public int mo10166a() {
        return this.f1024f;
    }

    /* renamed from: a */
    public void mo10167a(int i) {
        this.f1024f = i;
    }

    /* renamed from: a */
    public void mo10168a(C0929c cVar) {
        this.f1023e = cVar;
        this.f1019a.setText(cVar.mo10172k());
        this.f1019a.setTextColor(cVar.mo10175n());
        if (this.f1020b != null) {
            if (!TextUtils.isEmpty(cVar.mo10146c_())) {
                this.f1020b.setTypeface((Typeface) null, 0);
                this.f1020b.setVisibility(0);
                this.f1020b.setText(cVar.mo10146c_());
                this.f1020b.setTextColor(cVar.mo10125c());
                if (cVar.mo10147d_()) {
                    this.f1020b.setTypeface((Typeface) null, 1);
                }
            } else {
                this.f1020b.setVisibility(8);
            }
        }
        if (this.f1021c != null) {
            if (cVar.mo10142e() > 0) {
                this.f1021c.setImageResource(cVar.mo10142e());
                this.f1021c.setColorFilter(cVar.mo10176o());
                this.f1021c.setVisibility(0);
            } else {
                this.f1021c.setVisibility(8);
            }
        }
        if (this.f1022d == null) {
            return;
        }
        if (cVar.mo10143f() > 0) {
            this.f1022d.setImageResource(cVar.mo10143f());
            this.f1022d.setColorFilter(cVar.mo10144g());
            this.f1022d.setVisibility(0);
            return;
        }
        this.f1022d.setVisibility(8);
    }

    /* renamed from: b */
    public C0929c mo10169b() {
        return this.f1023e;
    }
}
