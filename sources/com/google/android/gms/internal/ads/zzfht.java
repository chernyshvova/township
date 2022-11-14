package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfht {
    public static boolean zza(zzhl zzhl) {
        zzhl zzhl2 = zzhl.UNSUPPORTED;
        int ordinal = zzhl.ordinal();
        return ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4;
    }

    public static final zzhl zzb(Context context, zzfgn zzfgn) {
        zzhl zzhl;
        FileInputStream fileInputStream;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzfgn.zzf(5017, "No lib/");
            zzhl = zzhl.UNKNOWN;
        } else {
            File[] listFiles = file.listFiles(new zzfoq(Pattern.compile(".*\\.so$", 2)));
            if (listFiles == null || listFiles.length == 0) {
                zzfgn.zzf(5017, "No .so");
                zzhl = zzhl.UNKNOWN;
            } else {
                try {
                    fileInputStream = new FileInputStream(listFiles[0]);
                    byte[] bArr = new byte[20];
                    if (fileInputStream.read(bArr) == 20) {
                        byte[] bArr2 = {0, 0};
                        if (bArr[5] == 2) {
                            zzc(bArr, (String) null, context, zzfgn);
                            zzhl = zzhl.UNSUPPORTED;
                        } else {
                            bArr2[0] = bArr[19];
                            bArr2[1] = bArr[18];
                            short s = ByteBuffer.wrap(bArr2).getShort();
                            if (s == 3) {
                                zzhl = zzhl.X86;
                            } else if (s == 40) {
                                zzhl = zzhl.ARM7;
                            } else if (s == 62) {
                                zzhl = zzhl.X86_64;
                            } else if (s != 183) {
                                zzc(bArr, (String) null, context, zzfgn);
                                zzhl = zzhl.UNSUPPORTED;
                            } else {
                                zzhl = zzhl.ARM64;
                            }
                        }
                        fileInputStream.close();
                    } else {
                        fileInputStream.close();
                        zzhl = zzhl.UNSUPPORTED;
                    }
                } catch (IOException e) {
                    zzc((byte[]) null, e.toString(), context, zzfgn);
                } catch (Throwable th) {
                    zzgcg.zza(th, th);
                }
            }
        }
        if (zzhl == zzhl.UNKNOWN) {
            String zzd = zzd(context, zzfgn);
            if (TextUtils.isEmpty(zzd)) {
                zzc((byte[]) null, "Empty dev arch", context, zzfgn);
                zzhl = zzhl.UNSUPPORTED;
            } else if (zzd.equalsIgnoreCase("i686") || zzd.equalsIgnoreCase("x86")) {
                zzhl = zzhl.X86;
            } else if (zzd.equalsIgnoreCase("x86_64")) {
                zzhl = zzhl.X86_64;
            } else if (zzd.equalsIgnoreCase("arm64-v8a")) {
                zzhl = zzhl.ARM64;
            } else if (zzd.equalsIgnoreCase("armeabi-v7a") || zzd.equalsIgnoreCase("armv71")) {
                zzhl = zzhl.ARM7;
            } else {
                zzc((byte[]) null, zzd, context, zzfgn);
                zzhl = zzhl.UNSUPPORTED;
            }
        }
        zzfgn.zzf(5018, zzhl.name());
        return zzhl;
        throw th;
    }

    public static final void zzc(byte[] bArr, String str, Context context, zzfgn zzfgn) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("os.arch:");
        outline24.append(zzfkl.OS_ARCH.zza());
        outline24.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null) {
                outline24.append("supported_abis:");
                outline24.append(Arrays.toString(strArr));
                outline24.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        outline24.append("CPU_ABI:");
        outline24.append(Build.CPU_ABI);
        outline24.append(";CPU_ABI2:");
        outline24.append(Build.CPU_ABI2);
        outline24.append(";");
        if (bArr != null) {
            outline24.append("ELF:");
            outline24.append(Arrays.toString(bArr));
            outline24.append(";");
        }
        if (str != null) {
            outline24.append("dbg:");
            outline24.append(str);
            outline24.append(";");
        }
        zzfgn.zzf(4007, outline24.toString());
    }

    public static final String zzd(Context context, zzfgn zzfgn) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String zza = zzfkl.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzfgn.zzd(2024, 0, e);
        } catch (IllegalAccessException e2) {
            zzfgn.zzd(2024, 0, e2);
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }
}
