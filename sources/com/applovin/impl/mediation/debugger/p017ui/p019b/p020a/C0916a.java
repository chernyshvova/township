package com.applovin.impl.mediation.debugger.p017ui.p019b.p020a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.sdk.utils.C1262f;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a.a */
public class C0916a extends C0929c {

    /* renamed from: a */
    public final C0883b f960a;

    /* renamed from: o */
    public final Context f961o;

    public C0916a(C0883b bVar, Context context) {
        super(C0929c.C0932b.DETAIL);
        this.f960a = bVar;
        this.f961o = context;
        this.f1027d = m1110q();
        this.f1028e = m1111r();
    }

    /* renamed from: q */
    private SpannedString m1110q() {
        return StringUtils.createSpannedString(this.f960a.mo10076i(), mo10124b() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
    }

    /* renamed from: r */
    private SpannedString m1111r() {
        if (!mo10124b()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(m1112s());
        spannableStringBuilder.append(new SpannableString("\n"));
        spannableStringBuilder.append(m1113t());
        if (this.f960a.mo10067a() == C0883b.C0884a.INVALID_INTEGRATION) {
            spannableStringBuilder.append(new SpannableString("\n"));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString("Invalid Integration", SupportMenu.CATEGORY_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    /* renamed from: s */
    private SpannedString m1112s() {
        if (!this.f960a.mo10071d()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", SupportMenu.CATEGORY_MASK);
        }
        if (!TextUtils.isEmpty(this.f960a.mo10077j())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.f960a.mo10077j(), ViewCompat.MEASURED_STATE_MASK));
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString(this.f960a.mo10072e() ? "Retrieving SDK Version..." : "SDK Found", ViewCompat.MEASURED_STATE_MASK);
    }

    /* renamed from: t */
    private SpannedString m1113t() {
        if (!this.f960a.mo10072e()) {
            return StringUtils.createListItemDetailSpannedString("Adapter Missing", SupportMenu.CATEGORY_MASK);
        }
        if (TextUtils.isEmpty(this.f960a.mo10078k())) {
            return StringUtils.createListItemDetailSpannedString("Adapter Found", ViewCompat.MEASURED_STATE_MASK);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
        spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.f960a.mo10078k(), ViewCompat.MEASURED_STATE_MASK));
        if (this.f960a.mo10073f()) {
            spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, 127, 0)));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(this.f960a.mo10079l(), ViewCompat.MEASURED_STATE_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    /* renamed from: b */
    public boolean mo10124b() {
        return this.f960a.mo10067a() != C0883b.C0884a.MISSING;
    }

    /* renamed from: d */
    public C0883b mo10141d() {
        return this.f960a;
    }

    /* renamed from: e */
    public int mo10142e() {
        int o = this.f960a.mo10082o();
        return o > 0 ? o : C1368R.C1369drawable.applovin_ic_mediation_placeholder;
    }

    /* renamed from: f */
    public int mo10143f() {
        return mo10124b() ? C1368R.C1369drawable.applovin_ic_disclosure_arrow : super.mo10142e();
    }

    /* renamed from: g */
    public int mo10144g() {
        return C1262f.m2502a(C1368R.color.applovin_sdk_disclosureButtonColor, this.f961o);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediatedNetworkListItemViewModel{text=");
        outline24.append(this.f1027d);
        outline24.append(", detailText=");
        outline24.append(this.f1028e);
        outline24.append(", network=");
        outline24.append(this.f960a);
        outline24.append("}");
        return outline24.toString();
    }
}
