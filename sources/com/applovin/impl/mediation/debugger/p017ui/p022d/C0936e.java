package com.applovin.impl.mediation.debugger.p017ui.p022d;

import android.text.SpannedString;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.e */
public class C0936e extends C0929c {
    public C0936e(String str) {
        super(C0929c.C0932b.SECTION);
        this.f1027d = new SpannedString(str);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("SectionListItemViewModel{text=");
        outline24.append(this.f1027d);
        outline24.append("}");
        return outline24.toString();
    }
}
