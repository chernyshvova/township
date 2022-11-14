package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztp {
    public static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i = zzalh.zza;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza(zzabe zzabe) {
        for (int i = 0; i < zzabe.zza(); i++) {
            zzabd zzb2 = zzabe.zzb(i);
            if (zzb2 instanceof zzabz) {
                zzabz zzabz = (zzabz) zzb2;
                if ("iTunSMPB".equals(zzabz.zzb) && zzc(zzabz.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzaci) {
                zzaci zzaci = (zzaci) zzb2;
                if ("com.apple.iTunes".equals(zzaci.zza) && "iTunSMPB".equals(zzaci.zzb) && zzc(zzaci.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final boolean zzb() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }
}
