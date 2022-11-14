package com.google.android.gms.drive.metadata.internal;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzid;
import com.google.android.gms.internal.drive.zzif;
import com.google.android.gms.internal.drive.zzin;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzf {
    public static final Map<String, MetadataField<?>> zzjf = new HashMap();
    public static final Map<String, zzg> zzjg = new HashMap();

    static {
        zzb(zzhs.zzjl);
        zzb(zzhs.zzkr);
        zzb(zzhs.zzki);
        zzb(zzhs.zzkp);
        zzb(zzhs.zzks);
        zzb(zzhs.zzjy);
        zzb(zzhs.zzjx);
        zzb(zzhs.zzjz);
        zzb(zzhs.zzka);
        zzb(zzhs.zzkb);
        zzb(zzhs.zzjv);
        zzb(zzhs.zzkd);
        zzb(zzhs.zzke);
        zzb(zzhs.zzkf);
        zzb(zzhs.zzkn);
        zzb(zzhs.zzjm);
        zzb(zzhs.zzkk);
        zzb(zzhs.zzjo);
        zzb(zzhs.zzjw);
        zzb(zzhs.zzjp);
        zzb(zzhs.zzjq);
        zzb(zzhs.zzjr);
        zzb(zzhs.zzjs);
        zzb(zzhs.zzkh);
        zzb(zzhs.zzkc);
        zzb(zzhs.zzkj);
        zzb(zzhs.zzkl);
        zzb(zzhs.zzkm);
        zzb(zzhs.zzko);
        zzb(zzhs.zzkt);
        zzb(zzhs.zzku);
        zzb(zzhs.zzju);
        zzb(zzhs.zzjt);
        zzb(zzhs.zzkq);
        zzb(zzhs.zzkg);
        zzb(zzhs.zzjn);
        zzb(zzhs.zzkv);
        zzb(zzhs.zzkw);
        zzb(zzhs.zzkx);
        zzb(zzhs.zzky);
        zzb(zzhs.zzkz);
        zzb(zzhs.zzla);
        zzb(zzhs.zzlb);
        zzb(zzif.zzld);
        zzb(zzif.zzlf);
        zzb(zzif.zzlg);
        zzb(zzif.zzlh);
        zzb(zzif.zzle);
        zzb(zzif.zzli);
        zzb(zzin.zzlk);
        zzb(zzin.zzll);
        zza(zzo.zzjk);
        zza(zzid.zzlc);
    }

    public static void zza(DataHolder dataHolder) {
        for (zzg zzb : zzjg.values()) {
            zzb.zzb(dataHolder);
        }
    }

    public static void zzb(MetadataField<?> metadataField) {
        if (zzjf.containsKey(metadataField.getName())) {
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Duplicate field name registered: ".concat(valueOf) : new String("Duplicate field name registered: "));
        } else {
            zzjf.put(metadataField.getName(), metadataField);
        }
    }

    public static Collection<MetadataField<?>> zzbc() {
        return Collections.unmodifiableCollection(zzjf.values());
    }

    public static MetadataField<?> zzf(String str) {
        return zzjf.get(str);
    }

    public static void zza(zzg zzg) {
        if (zzjg.put(zzg.zzbd(), zzg) != null) {
            String zzbd = zzg.zzbd();
            throw new IllegalStateException(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(zzbd, 46), "A cleaner for key ", zzbd, " has already been registered"));
        }
    }
}
