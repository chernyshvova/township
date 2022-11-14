package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfod<K, V> extends zzfmp<K, V> {
    public static final zzfmp<Object, Object> zza = new zzfod((Object) null, new Object[0], 0);
    public final transient Object[] zzb;
    public final transient Object zzc;
    public final transient int zzd;

    public zzfod(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v3 ?, r2v5 ?, r2v4 ?, r2v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public static <K, V> com.google.android.gms.internal.ads.zzfod<K, V> zzh(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.ads.zzfmp<java.lang.Object, java.lang.Object> r10 = zza
            com.google.android.gms.internal.ads.zzfod r10 = (com.google.android.gms.internal.ads.zzfod) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.gms.internal.ads.zzflm.zza(r10, r1)
            com.google.android.gms.internal.ads.zzfod r10 = new com.google.android.gms.internal.ads.zzfod
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            java.lang.String r4 = "index"
            com.google.android.gms.internal.ads.zzfke.zzf(r10, r3, r4)
            int r3 = com.google.android.gms.internal.ads.zzfmv.zzi(r10)
            if (r10 != r2) goto L_0x002f
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.gms.internal.ads.zzflm.zza(r1, r2)
            goto L_0x00e3
        L_0x002f:
            int r0 = r3 + -1
            r2 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r3 > r2) goto L_0x0071
            byte[] r2 = new byte[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x003b:
            if (r1 >= r10) goto L_0x006e
            int r3 = r1 + r1
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.ads.zzflm.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfmd.zza(r6)
        L_0x0050:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x005e
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x003b
        L_0x005e:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0069
            int r6 = r6 + 1
            goto L_0x0050
        L_0x0069:
            java.lang.IllegalArgumentException r10 = zzi(r4, r5, r11, r7)
            throw r10
        L_0x006e:
            r0 = r2
            goto L_0x00e3
        L_0x0071:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r3 > r2) goto L_0x00af
            short[] r2 = new short[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x007b:
            if (r1 >= r10) goto L_0x006e
            int r3 = r1 + r1
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.ads.zzflm.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfmd.zza(r6)
        L_0x0090:
            r6 = r6 & r0
            short r7 = r2[r6]
            char r7 = (char) r7
            r8 = 65535(0xffff, float:9.1834E-41)
            if (r7 != r8) goto L_0x009f
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x007b
        L_0x009f:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00aa
            int r6 = r6 + 1
            goto L_0x0090
        L_0x00aa:
            java.lang.IllegalArgumentException r10 = zzi(r4, r5, r11, r7)
            throw r10
        L_0x00af:
            int[] r2 = new int[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x00b4:
            if (r1 >= r10) goto L_0x006e
            int r3 = r1 + r1
            r5 = r11[r3]
            r6 = r3 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.ads.zzflm.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.ads.zzfmd.zza(r7)
        L_0x00c9:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r4) goto L_0x00d3
            r2[r7] = r3
            int r1 = r1 + 1
            goto L_0x00b4
        L_0x00d3:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00de
            int r7 = r7 + 1
            goto L_0x00c9
        L_0x00de:
            java.lang.IllegalArgumentException r10 = zzi(r5, r6, r11, r8)
            throw r10
        L_0x00e3:
            com.google.android.gms.internal.ads.zzfod r1 = new com.google.android.gms.internal.ads.zzfod
            r1.<init>(r0, r11, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfod.zzh(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzfod");
    }

    public static IllegalArgumentException zzi(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        StringBuilder sb = new StringBuilder(length + 39 + length2 + valueOf3.length() + valueOf4.length());
        GeneratedOutlineSupport.outline34(sb, "Multiple entries with same key: ", valueOf, "=", valueOf2);
        return new IllegalArgumentException(GeneratedOutlineSupport.outline20(sb, " and ", valueOf3, "=", valueOf4));
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzc;
        V[] vArr = this.zzb;
        int i = this.zzd;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (!vArr[0].equals(obj)) {
                return null;
            }
            return vArr[1];
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zza2 = zzfmd.zza(obj.hashCode());
                while (true) {
                    int i2 = zza2 & length;
                    byte b = bArr[i2] & Base64.EQUALS_SIGN_ENC;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zza2 = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zza3 = zzfmd.zza(obj.hashCode());
                while (true) {
                    int i3 = zza3 & length2;
                    char c = (char) sArr[i3];
                    if (c == 65535) {
                        return null;
                    }
                    if (vArr[c].equals(obj)) {
                        return vArr[c ^ 1];
                    }
                    zza3 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zza4 = zzfmd.zza(obj.hashCode());
                while (true) {
                    int i4 = zza4 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zza4 = i4 + 1;
                }
            }
        }
    }

    public final int size() {
        return this.zzd;
    }

    public final zzfmv<Map.Entry<K, V>> zzd() {
        return new zzfoa(this, this.zzb, 0, this.zzd);
    }

    public final zzfmv<K> zze() {
        return new zzfob(this, new zzfoc(this.zzb, 0, this.zzd));
    }

    public final zzfmg<V> zzg() {
        return new zzfoc(this.zzb, 1, this.zzd);
    }
}
