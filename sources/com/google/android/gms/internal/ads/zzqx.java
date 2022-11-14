package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.view.DisplayCompat;
import com.facebook.internal.WebDialog;
import com.unity3d.services.core.log.DeviceLog;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqx {
    public static final /* synthetic */ int zza = 0;
    public static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    public static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    public static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, WebDialog.MAX_PADDING_SCREEN_HEIGHT, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, DeviceLog.MAX_DEBUG_MSG_LENGTH, DisplayCompat.DISPLAY_SIZE_4K_WIDTH, 4096, 6144, 7680};

    public static zzkc zza(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable zzsa zzsa) {
        zzakq zzakq;
        int i = 0;
        int i2 = -1;
        if (bArr[0] == Byte.MAX_VALUE) {
            zzakq = new zzakq(bArr, bArr.length);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b = copyOf[0];
            if (b == -2 || b == -1) {
                for (int i3 = 0; i3 < copyOf.length - 1; i3 += 2) {
                    byte b2 = copyOf[i3];
                    int i4 = i3 + 1;
                    copyOf[i3] = copyOf[i4];
                    copyOf[i4] = b2;
                }
            }
            int length = copyOf.length;
            zzakq = new zzakq(copyOf, length);
            if (copyOf[0] == 31) {
                zzakq zzakq2 = new zzakq(copyOf, length);
                while (zzakq2.zzb() >= 16) {
                    zzakq2.zzf(2);
                    zzakq.zzl(zzakq2.zzh(14), 14);
                }
            }
            zzakq.zza(copyOf, copyOf.length);
        }
        zzakq.zzf(60);
        int i5 = zzb[zzakq.zzh(6)];
        int i6 = zzc[zzakq.zzh(4)];
        int zzh = zzakq.zzh(5);
        if (zzh < 29) {
            i2 = (zzd[zzh] * 1000) / 2;
        }
        zzakq.zzf(10);
        if (zzakq.zzh(2) > 0) {
            i = 1;
        }
        zzkb zzkb = new zzkb();
        zzkb.zza(str);
        zzkb.zzj("audio/vnd.dts");
        zzkb.zzf(i2);
        zzkb.zzw(i5 + i);
        zzkb.zzx(i6);
        zzkb.zzm((zzsa) null);
        zzkb.zzd(str2);
        return zzkb.zzD();
    }
}
