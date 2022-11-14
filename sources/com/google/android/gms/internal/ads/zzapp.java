package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapp {
    public static final zzarv zza = new zzapo();
    public static final Pattern zzd = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzb = -1;
    public int zzc = -1;

    public final boolean zza(zzarq zzarq) {
        for (int i = 0; i < zzarq.zza(); i++) {
            zzarp zzb2 = zzarq.zzb(i);
            if (zzb2 instanceof zzaru) {
                zzaru zzaru = (zzaru) zzb2;
                String str = zzaru.zzb;
                String str2 = zzaru.zzc;
                if (!"iTunSMPB".equals(str)) {
                    continue;
                } else {
                    Matcher matcher = zzd.matcher(str2);
                    if (matcher.find()) {
                        try {
                            int parseInt = Integer.parseInt(matcher.group(1), 16);
                            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                            if (parseInt > 0 || parseInt2 > 0) {
                                this.zzb = parseInt;
                                this.zzc = parseInt2;
                                return true;
                            }
                        } catch (NumberFormatException unused) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public final boolean zzb() {
        return (this.zzb == -1 || this.zzc == -1) ? false : true;
    }
}
