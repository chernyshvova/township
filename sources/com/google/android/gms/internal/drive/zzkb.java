package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzkb<FieldDescriptorType extends zzkd<FieldDescriptorType>> {
    public static final zzkb zzov = new zzkb(true);
    public final zzmi<FieldDescriptorType, Object> zzos = zzmi.zzav(16);
    public boolean zzot;
    public boolean zzou = false;

    public zzkb() {
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzos.get(fielddescriptortype);
        return obj instanceof zzkt ? zzkt.zzdp() : obj;
    }

    public static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzkd zzkd = (zzkd) entry.getKey();
        if (zzkd.zzcr() == zznr.MESSAGE) {
            if (zzkd.zzcs()) {
                for (zzlq isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzlq) {
                    if (!((zzlq) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzkt) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzkd zzkd = (zzkd) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzkt) {
            value = zzkt.zzdp();
        }
        if (zzkd.zzcs()) {
            Object zza = zza(zzkd);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zze : (List) value) {
                ((List) zza).add(zze(zze));
            }
            this.zzos.put(zzkd, zza);
        } else if (zzkd.zzcr() == zznr.MESSAGE) {
            Object zza2 = zza(zzkd);
            if (zza2 == null) {
                this.zzos.put(zzkd, zze(value));
                return;
            }
            if (zza2 instanceof zzlx) {
                obj = zzkd.zza((zzlx) zza2, (zzlx) value);
            } else {
                obj = zzkd.zza(((zzlq) zza2).zzcy(), (zzlq) value).zzdf();
            }
            this.zzos.put(zzkd, obj);
        } else {
            this.zzos.put(zzkd, zze(value));
        }
    }

    public static <T extends zzkd<T>> zzkb<T> zzcn() {
        return zzov;
    }

    public static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzkd zzkd = (zzkd) entry.getKey();
        Object value = entry.getValue();
        if (zzkd.zzcr() != zznr.MESSAGE || zzkd.zzcs() || zzkd.zzct()) {
            return zzb((zzkd<?>) zzkd, value);
        }
        if (value instanceof zzkt) {
            return zzjr.zzb(((zzkd) entry.getKey()).zzcp(), (zzkx) (zzkt) value);
        }
        return zzjr.zzb(((zzkd) entry.getKey()).zzcp(), (zzlq) value);
    }

    public static Object zze(Object obj) {
        if (obj instanceof zzlx) {
            return ((zzlx) obj).zzef();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzkb zzkb = new zzkb();
        for (int i = 0; i < this.zzos.zzer(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzaw = this.zzos.zzaw(i);
            zzkb.zza((zzkd) zzaw.getKey(), zzaw.getValue());
        }
        for (Map.Entry next : this.zzos.zzes()) {
            zzkb.zza((zzkd) next.getKey(), next.getValue());
        }
        zzkb.zzou = this.zzou;
        return zzkb;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzou) {
            return new zzkw(this.zzos.zzet().iterator());
        }
        return this.zzos.zzet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkb)) {
            return false;
        }
        return this.zzos.equals(((zzkb) obj).zzos);
    }

    public final int hashCode() {
        return this.zzos.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzos.zzer(); i++) {
            if (!zzb(this.zzos.zzaw(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzos.zzes()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzou) {
            return new zzkw(this.zzos.entrySet().iterator());
        }
        return this.zzos.entrySet().iterator();
    }

    public final void zzbp() {
        if (!this.zzot) {
            this.zzos.zzbp();
            this.zzot = true;
        }
    }

    public final int zzco() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzos.zzer(); i2++) {
            i += zzd(this.zzos.zzaw(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zzos.zzes()) {
            i += zzd(zzd);
        }
        return i;
    }

    public zzkb(boolean z) {
        zzbp();
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzcs()) {
            zza(fielddescriptortype.zzcq(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(fielddescriptortype.zzcq(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzkt) {
            this.zzou = true;
        }
        this.zzos.put(fielddescriptortype, obj);
    }

    public static int zzb(zznm zznm, Object obj) {
        switch (zzkc.zzox[zznm.ordinal()]) {
            case 1:
                return zzjr.zzb(((Double) obj).doubleValue());
            case 2:
                return zzjr.zzb(((Float) obj).floatValue());
            case 3:
                return zzjr.zzo(((Long) obj).longValue());
            case 4:
                return zzjr.zzp(((Long) obj).longValue());
            case 5:
                return zzjr.zzac(((Integer) obj).intValue());
            case 6:
                return zzjr.zzr(((Long) obj).longValue());
            case 7:
                return zzjr.zzaf(((Integer) obj).intValue());
            case 8:
                return zzjr.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzjr.zzd((zzlq) obj);
            case 10:
                if (obj instanceof zzkt) {
                    return zzjr.zza((zzkx) (zzkt) obj);
                }
                return zzjr.zzc((zzlq) obj);
            case 11:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzm((String) obj);
            case 12:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzc((byte[]) obj);
            case 13:
                return zzjr.zzad(((Integer) obj).intValue());
            case 14:
                return zzjr.zzag(((Integer) obj).intValue());
            case 15:
                return zzjr.zzs(((Long) obj).longValue());
            case 16:
                return zzjr.zzae(((Integer) obj).intValue());
            case 17:
                return zzjr.zzq(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzkn) {
                    return zzjr.zzah(((zzkn) obj).zzcp());
                }
                return zzjr.zzah(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.drive.zzkn) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.drive.zzkt) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.internal.drive.zznm r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.drive.zzkm.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.drive.zzkc.zzow
            com.google.android.gms.internal.drive.zznr r2 = r2.zzfj()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003e;
                case 3: goto L_0x003b;
                case 4: goto L_0x0038;
                case 5: goto L_0x0035;
                case 6: goto L_0x0032;
                case 7: goto L_0x0029;
                case 8: goto L_0x0020;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0044
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzlq
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzkt
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x001e:
            r0 = 0
            goto L_0x0043
        L_0x0020:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzkn
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0029:
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzjc
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0032:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0043
        L_0x0035:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0043
        L_0x0038:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0043
        L_0x003b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0043
        L_0x003e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0043
        L_0x0041:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0043:
            r1 = r0
        L_0x0044:
            if (r1 == 0) goto L_0x0047
            return
        L_0x0047:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x0050
        L_0x004f:
            throw r2
        L_0x0050:
            goto L_0x004f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzkb.zza(com.google.android.gms.internal.drive.zznm, java.lang.Object):void");
    }

    public final void zza(zzkb<FieldDescriptorType> zzkb) {
        for (int i = 0; i < zzkb.zzos.zzer(); i++) {
            zzc(zzkb.zzos.zzaw(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzkb.zzos.zzes()) {
            zzc(zzc);
        }
    }

    public static void zza(zzjr zzjr, zznm zznm, int i, Object obj) throws IOException {
        if (zznm == zznm.GROUP) {
            zzlq zzlq = (zzlq) obj;
            zzkm.zzf(zzlq);
            zzjr.zzb(i, 3);
            zzlq.zzb(zzjr);
            zzjr.zzb(i, 4);
            return;
        }
        zzjr.zzb(i, zznm.zzfk());
        switch (zzkc.zzox[zznm.ordinal()]) {
            case 1:
                zzjr.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzjr.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzjr.zzl(((Long) obj).longValue());
                return;
            case 4:
                zzjr.zzl(((Long) obj).longValue());
                return;
            case 5:
                zzjr.zzx(((Integer) obj).intValue());
                return;
            case 6:
                zzjr.zzn(((Long) obj).longValue());
                return;
            case 7:
                zzjr.zzaa(((Integer) obj).intValue());
                return;
            case 8:
                zzjr.zzc(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzlq) obj).zzb(zzjr);
                return;
            case 10:
                zzjr.zzb((zzlq) obj);
                return;
            case 11:
                if (obj instanceof zzjc) {
                    zzjr.zza((zzjc) obj);
                    return;
                } else {
                    zzjr.zzl((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzjc) {
                    zzjr.zza((zzjc) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzjr.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzjr.zzy(((Integer) obj).intValue());
                return;
            case 14:
                zzjr.zzaa(((Integer) obj).intValue());
                return;
            case 15:
                zzjr.zzn(((Long) obj).longValue());
                return;
            case 16:
                zzjr.zzz(((Integer) obj).intValue());
                return;
            case 17:
                zzjr.zzm(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzkn) {
                    zzjr.zzx(((zzkn) obj).zzcp());
                    return;
                } else {
                    zzjr.zzx(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zzb(zzkd<?> zzkd, Object obj) {
        zznm zzcq = zzkd.zzcq();
        int zzcp = zzkd.zzcp();
        if (!zzkd.zzcs()) {
            return zza(zzcq, zzcp, obj);
        }
        int i = 0;
        if (zzkd.zzct()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzcq, zzb);
            }
            return zzjr.zzaj(i) + zzjr.zzab(zzcp) + i;
        }
        for (Object zza : (List) obj) {
            i += zza(zzcq, zzcp, zza);
        }
        return i;
    }

    public static int zza(zznm zznm, int i, Object obj) {
        int zzab = zzjr.zzab(i);
        if (zznm == zznm.GROUP) {
            zzkm.zzf((zzlq) obj);
            zzab <<= 1;
        }
        return zzb(zznm, obj) + zzab;
    }
}
