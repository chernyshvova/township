package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfse<P> {
    public final ConcurrentMap<zzfsd, List<zzfsc<P>>> zza = new ConcurrentHashMap();
    public zzfsc<P> zzb;
    public final Class<P> zzc;

    public zzfse(Class<P> cls) {
        this.zzc = cls;
    }

    public static <P> zzfse<P> zzb(Class<P> cls) {
        return new zzfse<>(cls);
    }

    public final zzfsc<P> zza() {
        return this.zzb;
    }

    public final void zzc(zzfsc<P> zzfsc) {
        if (zzfsc.zzb() == zzfyu.ENABLED) {
            List list = (List) this.zza.get(new zzfsd(zzfsc.zzd(), (zzfsb) null));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzb = zzfsc;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        throw new IllegalArgumentException("the primary entry has to be ENABLED");
    }

    public final zzfsc<P> zzd(P p, zzfze zzfze) throws GeneralSecurityException {
        byte[] bArr;
        if (zzfze.zzd() == zzfyu.ENABLED) {
            zzfzy zzfzy = zzfzy.UNKNOWN_PREFIX;
            int ordinal = zzfze.zzf().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzfrj.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzfze.zze()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzfze.zze()).array();
            }
            zzfsc zzfsc = new zzfsc(p, bArr, zzfze.zzd(), zzfze.zzf(), zzfze.zze());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzfsc);
            zzfsd zzfsd = new zzfsd(zzfsc.zzd(), (zzfsb) null);
            List list = (List) this.zza.put(zzfsd, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzfsc);
                this.zza.put(zzfsd, Collections.unmodifiableList(arrayList2));
            }
            return zzfsc;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final Class<P> zze() {
        return this.zzc;
    }
}
