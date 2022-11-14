package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeb {
    public static boolean zza = false;
    public static final CountDownLatch zzb = new CountDownLatch(1);
    public static MessageDigest zzc;
    public static final Object zzd = new Object();
    public static final Object zze = new Object();

    public static void zza() {
        synchronized (zze) {
            if (!zza) {
                zza = true;
                new Thread(new zzea((zzdz) null)).start();
            }
        }
    }

    public static String zzb(zzdc zzdc, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] zzao = zzdc.zzao();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbN)).booleanValue()) {
            Vector<byte[]> zzc2 = zzc(zzao, 255);
            if (zzc2 == null || zzc2.size() == 0) {
                bArr = zzg(zzd(zzcv.PSN_ENCODE_SIZE_FAIL).zzao(), str, true);
            } else {
                zzdu zza2 = zzdv.zza();
                int size = zzc2.size();
                for (int i = 0; i < size; i++) {
                    zza2.zza(zzgcz.zzt(zzg(zzc2.get(i), str, false)));
                }
                zza2.zzb(zzgcz.zzt(zze(zzao)));
                bArr = ((zzdv) zza2.zzah()).zzao();
            }
        } else if (zzfz.zza != null) {
            byte[] zza3 = zzfz.zza.zza(zzao, str != null ? str.getBytes() : new byte[0]);
            zzdu zza4 = zzdv.zza();
            zza4.zza(zzgcz.zzt(zza3));
            zza4.zzc(zzdj.TINK_HYBRID);
            bArr = ((zzdv) zza4.zzah()).zzao();
        } else {
            throw new GeneralSecurityException();
        }
        return zzdx.zza(bArr, true);
    }

    public static Vector<byte[]> zzc(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i2 = (length + 254) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i4 > 255) {
                    length2 = i4 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i4, length2));
                i3++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static zzdc zzd(zzcv zzcv) {
        zzcn zzj = zzdc.zzj();
        zzj.zzl((long) zzcv.zza());
        return (zzdc) zzj.zzah();
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzd) {
            zza();
            MessageDigest messageDigest = null;
            try {
                if (zzb.await(2, TimeUnit.SECONDS)) {
                    if (zzc != null) {
                        messageDigest = zzc;
                    }
                }
            } catch (InterruptedException unused) {
            }
            if (messageDigest != null) {
                messageDigest.reset();
                messageDigest.update(bArr);
                digest = zzc.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    public static byte[] zzg(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = true != z ? 255 : 239;
        if (bArr.length > i) {
            bArr = zzd(zzcv.PSN_ENCODE_SIZE_FAIL).zzao();
        }
        int length = bArr.length;
        if (length < i) {
            byte[] bArr3 = new byte[(i - length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zze(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        zzed[] zzedArr = new zzeq().zzcG;
        int length2 = zzedArr.length;
        for (int i2 = 0; i2 < 12; i2++) {
            zzedArr[i2].zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzgch(str.getBytes("UTF-8")).zza(bArr4);
        }
        return bArr4;
    }
}
