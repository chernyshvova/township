package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.model.CookieDBAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcsw implements zzcsg {
    public final CookieManager zza;

    public zzcsw(Context context) {
        this.zza = zzs.zze().zzk(context);
    }

    public final void zza(Map<String, String> map) {
        String str;
        if (this.zza != null) {
            if (map.get("clear") != null) {
                String str2 = (String) zzbex.zzc().zzb(zzbjn.zzaz);
                String cookie = this.zza.getCookie(str2);
                if (cookie != null) {
                    List<String> zzc = zzfkk.zza(zzfjr.zzb(';')).zzc(cookie);
                    int i = 0;
                    while (i < zzc.size()) {
                        CookieManager cookieManager = this.zza;
                        Iterator<String> it = zzfkk.zza(zzfjr.zzb('=')).zzb(zzc.get(i)).iterator();
                        if (it == null) {
                            throw null;
                        } else if (it.hasNext()) {
                            String valueOf = String.valueOf(it.next());
                            String valueOf2 = String.valueOf((String) zzbex.zzc().zzb(zzbjn.zzaq));
                            if (valueOf2.length() != 0) {
                                str = valueOf.concat(valueOf2);
                            } else {
                                str = new String(valueOf);
                            }
                            cookieManager.setCookie(str2, str);
                            i++;
                        } else {
                            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline10(91, "position (0) must be less than the number of elements that remained (", 0, ")"));
                        }
                    }
                    return;
                }
                return;
            }
            String str3 = map.get(CookieDBAdapter.CookieColumns.TABLE_NAME);
            if (!TextUtils.isEmpty(str3)) {
                this.zza.setCookie((String) zzbex.zzc().zzb(zzbjn.zzaz), str3);
            }
        }
    }
}
