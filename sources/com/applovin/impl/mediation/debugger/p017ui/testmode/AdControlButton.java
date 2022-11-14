package com.applovin.impl.mediation.debugger.p017ui.testmode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.C0653a;
import com.applovin.impl.sdk.utils.C1262f;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    public final Button f1075a;

    /* renamed from: b */
    public final C0653a f1076b;

    /* renamed from: c */
    public C0942b f1077c;

    /* renamed from: d */
    public MaxAdFormat f1078d;

    /* renamed from: e */
    public C0941a f1079e;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton$a */
    public interface C0941a {
        void onClick(AdControlButton adControlButton);
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton$b */
    public enum C0942b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1075a = new Button(getContext());
        this.f1076b = new C0653a(getContext(), 20, 16842873);
        this.f1077c = C0942b.LOAD;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f1075a.setTextColor(-1);
        this.f1075a.setOnClickListener(this);
        frameLayout.addView(this.f1075a, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f1076b.setColor(-1);
        addView(this.f1076b, new FrameLayout.LayoutParams(-1, -1, 17));
        m1229a(C0942b.LOAD);
    }

    /* renamed from: a */
    private void m1229a(C0942b bVar) {
        if (C0942b.LOADING == bVar) {
            setEnabled(false);
            this.f1076b.mo9422a();
        } else {
            setEnabled(true);
            this.f1076b.mo9423b();
        }
        this.f1075a.setText(m1230b(bVar));
        this.f1075a.setBackgroundColor(m1231c(bVar));
    }

    /* renamed from: b */
    private String m1230b(C0942b bVar) {
        return C0942b.LOAD == bVar ? "Load" : C0942b.LOADING == bVar ? "" : "Show";
    }

    /* renamed from: c */
    private int m1231c(C0942b bVar) {
        return C1262f.m2502a((C0942b.LOAD == bVar || C0942b.LOADING == bVar) ? C1368R.color.applovin_sdk_brand_color : C1368R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    public C0942b getControlState() {
        return this.f1077c;
    }

    public MaxAdFormat getFormat() {
        return this.f1078d;
    }

    public void onClick(View view) {
        C0941a aVar = this.f1079e;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(C0942b bVar) {
        if (this.f1077c != bVar) {
            m1229a(bVar);
        }
        this.f1077c = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f1078d = maxAdFormat;
    }

    public void setOnClickListener(C0941a aVar) {
        this.f1079e = aVar;
    }
}
