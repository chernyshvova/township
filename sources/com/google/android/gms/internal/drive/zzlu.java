package com.google.android.gms.internal.drive;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class zzlu<T> implements zzmf<T> {
    public static final int[] zzub = new int[0];
    public static final Unsafe zzuc = zznd.zzff();
    public final int[] zzud;
    public final Object[] zzue;
    public final int zzuf;
    public final int zzug;
    public final zzlq zzuh;
    public final boolean zzui;
    public final boolean zzuj;
    public final boolean zzuk;
    public final boolean zzul;
    public final int[] zzum;
    public final int zzun;
    public final int zzuo;
    public final zzly zzup;
    public final zzla zzuq;
    public final zzmx<?, ?> zzur;
    public final zzjy<?> zzus;
    public final zzll zzut;

    public zzlu(int[] iArr, Object[] objArr, int i, int i2, zzlq zzlq, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzly zzly, zzla zzla, zzmx<?, ?> zzmx, zzjy<?> zzjy, zzll zzll) {
        this.zzud = iArr;
        this.zzue = objArr;
        this.zzuf = i;
        this.zzug = i2;
        this.zzuj = zzlq instanceof zzkk;
        this.zzuk = z;
        this.zzui = zzjy != null && zzjy.zze(zzlq);
        this.zzul = false;
        this.zzum = iArr2;
        this.zzun = i3;
        this.zzuo = i4;
        this.zzup = zzly;
        this.zzuq = zzla;
        this.zzur = zzmx;
        this.zzus = zzjy;
        this.zzuh = zzlq;
        this.zzut = zzll;
    }

    public static <T> zzlu<T> zza(Class<T> cls, zzlo zzlo, zzly zzly, zzla zzla, zzmx<?, ?> zzmx, zzjy<?> zzjy, zzll zzll) {
        int i;
        char c;
        int[] iArr;
        char c2;
        int i2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i3;
        boolean z;
        int i4;
        zzme zzme;
        int i5;
        Class<?> cls2;
        int i6;
        String str;
        int i7;
        int i8;
        char c7;
        char c8;
        Field field;
        int i9;
        char charAt;
        int i10;
        Field field2;
        Field field3;
        int i11;
        char charAt2;
        int i12;
        char charAt3;
        int i13;
        char charAt4;
        int i14;
        int i15;
        char charAt5;
        int i16;
        char charAt6;
        int i17;
        char charAt7;
        int i18;
        char charAt8;
        int i19;
        char charAt9;
        int i20;
        char charAt10;
        int i21;
        char charAt11;
        int i22;
        char charAt12;
        int i23;
        char charAt13;
        char charAt14;
        zzlo zzlo2 = zzlo;
        if (zzlo2 instanceof zzme) {
            zzme zzme2 = (zzme) zzlo2;
            char c9 = 0;
            boolean z2 = zzme2.zzec() == zzkk.zze.zzsg;
            String zzek = zzme2.zzek();
            int length = zzek.length();
            char charAt15 = zzek.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzek.charAt(i24);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c10 |= (charAt14 & 8191) << i25;
                    i25 += 13;
                    i24 = i;
                }
                charAt15 = c10 | (charAt14 << i25);
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt16 = zzek.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzek.charAt(i26);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c11 |= (charAt13 & 8191) << i27;
                    i27 += 13;
                    i26 = i23;
                }
                charAt16 = c11 | (charAt13 << i27);
                i26 = i23;
            }
            if (charAt16 == 0) {
                iArr = zzub;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                i2 = 0;
                c2 = 0;
                c = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzek.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzek.charAt(i28);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c12 |= (charAt12 & 8191) << i29;
                        i29 += 13;
                        i28 = i22;
                    }
                    charAt17 = c12 | (charAt12 << i29);
                    i28 = i22;
                }
                int i30 = i28 + 1;
                char charAt18 = zzek.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzek.charAt(i30);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c13 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i30 = i21;
                    }
                    charAt18 = c13 | (charAt11 << i31);
                    i30 = i21;
                }
                int i32 = i30 + 1;
                c3 = zzek.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzek.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c14 |= (charAt10 & 8191) << i33;
                        i33 += 13;
                        i32 = i20;
                    }
                    c3 = c14 | (charAt10 << i33);
                    i32 = i20;
                }
                int i34 = i32 + 1;
                char charAt19 = zzek.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzek.charAt(i34);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c15 |= (charAt9 & 8191) << i35;
                        i35 += 13;
                        i34 = i19;
                    }
                    charAt19 = c15 | (charAt9 << i35);
                    i34 = i19;
                }
                int i36 = i34 + 1;
                c2 = zzek.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzek.charAt(i36);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c16 |= (charAt8 & 8191) << i37;
                        i37 += 13;
                        i36 = i18;
                    }
                    c2 = c16 | (charAt8 << i37);
                    i36 = i18;
                }
                int i38 = i36 + 1;
                char charAt20 = zzek.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzek.charAt(i38);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c17 |= (charAt7 & 8191) << i39;
                        i39 += 13;
                        i38 = i17;
                    }
                    charAt20 = c17 | (charAt7 << i39);
                    i38 = i17;
                }
                int i40 = i38 + 1;
                char charAt21 = zzek.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzek.charAt(i41);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c18 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i41 = i16;
                    }
                    charAt21 = c18 | (charAt6 << i42);
                    i14 = i16;
                } else {
                    i14 = i40;
                }
                int i43 = i14 + 1;
                char charAt22 = zzek.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzek.charAt(i44);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c19 |= (charAt5 & 8191) << i45;
                        i45 += 13;
                        i44 = i15;
                    }
                    charAt22 = c19 | (charAt5 << i45);
                    i43 = i15;
                }
                int i46 = (charAt17 << 1) + charAt18;
                c4 = charAt19;
                i2 = i46;
                c = charAt22;
                c9 = charAt17;
                i26 = i43;
                char c20 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c5 = c20;
            }
            Unsafe unsafe = zzuc;
            Object[] zzel = zzme2.zzel();
            Class<?> cls3 = zzme2.zzee().getClass();
            int i47 = i26;
            int[] iArr2 = new int[(c2 * 3)];
            Object[] objArr = new Object[(c2 << 1)];
            int i48 = c + c5;
            char c21 = c;
            int i49 = i47;
            int i50 = i48;
            int i51 = 0;
            int i52 = 0;
            while (i49 < length) {
                int i53 = i49 + 1;
                int charAt23 = zzek.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzek.charAt(i56);
                        c6 = c;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i55 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i56 = i13;
                        c = c6;
                    }
                    charAt23 = i55 | (charAt4 << i57);
                    i3 = i13;
                } else {
                    c6 = c;
                    i3 = i53;
                }
                int i58 = i3 + 1;
                char charAt24 = zzek.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzek.charAt(i60);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c22 |= (charAt3 & 8191) << i61;
                        i61 += 13;
                        i60 = i12;
                        z2 = z;
                    }
                    charAt24 = c22 | (charAt3 << i61);
                    i4 = i12;
                } else {
                    z = z2;
                    i4 = i59;
                }
                char c23 = charAt24 & 255;
                char c24 = c4;
                if ((charAt24 & 1024) != 0) {
                    iArr[i51] = i52;
                    i51++;
                }
                char c25 = c3;
                if (c23 >= '3') {
                    int i62 = i4 + 1;
                    char charAt25 = zzek.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzek.charAt(i62);
                            if (charAt2 < c26) {
                                break;
                            }
                            c27 |= (charAt2 & 8191) << i63;
                            i63 += 13;
                            i62 = i11;
                            c26 = 55296;
                        }
                        charAt25 = c27 | (charAt2 << i63);
                        i62 = i11;
                    }
                    int i64 = c23 - '3';
                    int i65 = i62;
                    if (i64 == 9 || i64 == 17) {
                        objArr[((i52 / 3) << 1) + 1] = zzel[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzel[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzel[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzel[i66] = field2;
                    }
                    zzme = zzme2;
                    String str2 = zzek;
                    i8 = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzel[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzel[i67] = field3;
                    }
                    cls2 = cls3;
                    i5 = i2;
                    i4 = i65;
                    str = str2;
                    i6 = 0;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    c7 = c9;
                } else {
                    zzme = zzme2;
                    String str3 = zzek;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzel[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzel[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzel[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzel[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzel[i71];
                                    c21 = i69;
                                } else {
                                    i68 = i71;
                                    c8 = 1;
                                    c21 = i69;
                                }
                            }
                            c8 = 1;
                        }
                        i68 = i10;
                    }
                    i8 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != c8 || c23 > 17) {
                        i5 = i68;
                        c7 = c9;
                        cls2 = cls3;
                        str = str3;
                        i7 = 0;
                        i6 = 0;
                    } else {
                        int i72 = i4 + 1;
                        str = str3;
                        char charAt26 = str.charAt(i4);
                        if (charAt26 >= 55296) {
                            char c28 = charAt26 & 8191;
                            int i73 = 13;
                            while (true) {
                                i9 = i72 + 1;
                                charAt = str.charAt(i72);
                                if (charAt < 55296) {
                                    break;
                                }
                                c28 |= (charAt & 8191) << i73;
                                i73 += 13;
                                i72 = i9;
                            }
                            charAt26 = c28 | (charAt << i73);
                            i72 = i9;
                        }
                        int i74 = (charAt26 / ' ') + (c9 << 1);
                        Object obj3 = zzel[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzel[i74] = field;
                        }
                        c7 = c9;
                        cls2 = cls3;
                        i7 = (int) unsafe.objectFieldOffset(field);
                        i6 = charAt26 % ' ';
                        i4 = i72;
                    }
                    if (c23 >= 18 && c23 <= '1') {
                        iArr[i50] = i8;
                        i50++;
                    }
                }
                int i75 = i52 + 1;
                iArr2[i52] = charAt23;
                int i76 = i75 + 1;
                iArr2[i75] = i8 | ((charAt24 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((charAt24 & 512) != 0 ? DriveFile.MODE_WRITE_ONLY : 0) | (c23 << 20);
                i52 = i76 + 1;
                iArr2[i76] = (i6 << 20) | i7;
                c9 = c7;
                zzek = str;
                i49 = i4;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                cls3 = cls2;
                c3 = c25;
                i2 = i5;
                zzme2 = zzme;
            }
            char c29 = c4;
            boolean z3 = z2;
            return new zzlu(iArr2, objArr, c3, c4, zzme2.zzee(), z2, false, iArr, c, i48, zzly, zzla, zzmx, zzjy, zzll);
        }
        int zzec = ((zzms) zzlo2).zzec();
        int i77 = zzkk.zze.zzsg;
        throw new NoSuchMethodError();
    }

    private final zzmf zzap(int i) {
        int i2 = (i / 3) << 1;
        zzmf zzmf = (zzmf) this.zzue[i2];
        if (zzmf != null) {
            return zzmf;
        }
        zzmf zzf = zzmd.zzej().zzf((Class) this.zzue[i2 + 1]);
        this.zzue[i2] = zzf;
        return zzf;
    }

    private final Object zzaq(int i) {
        return this.zzue[(i / 3) << 1];
    }

    private final zzko zzar(int i) {
        return (zzko) this.zzue[((i / 3) << 1) + 1];
    }

    private final int zzas(int i) {
        return this.zzud[i + 1];
    }

    private final int zzat(int i) {
        return this.zzud[i + 2];
    }

    private final int zzau(int i) {
        if (i < this.zzuf || i > this.zzug) {
            return -1;
        }
        return zzq(i, 0);
    }

    private final void zzb(T t, T t2, int i) {
        int zzas = zzas(i);
        int i2 = this.zzud[i];
        long j = (long) (zzas & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zznd.zzo(t, j);
            Object zzo2 = zznd.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zznd.zza((Object) t, j, zzkm.zza(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zznd.zza((Object) t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    public static <E> List<E> zzd(Object obj, long j) {
        return (List) zznd.zzo(obj, j);
    }

    public static <T> double zze(T t, long j) {
        return ((Double) zznd.zzo(t, j)).doubleValue();
    }

    public static <T> float zzf(T t, long j) {
        return ((Float) zznd.zzo(t, j)).floatValue();
    }

    public static <T> int zzg(T t, long j) {
        return ((Integer) zznd.zzo(t, j)).intValue();
    }

    public static <T> long zzh(T t, long j) {
        return ((Long) zznd.zzo(t, j)).longValue();
    }

    public static <T> boolean zzi(T t, long j) {
        return ((Boolean) zznd.zzo(t, j)).booleanValue();
    }

    public static zzmy zzo(Object obj) {
        zzkk zzkk = (zzkk) obj;
        zzmy zzmy = zzkk.zzrq;
        if (zzmy != zzmy.zzfa()) {
            return zzmy;
        }
        zzmy zzfb = zzmy.zzfb();
        zzkk.zzrq = zzfb;
        return zzfb;
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzud.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzud[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.drive.zzmh.zzd(com.google.android.gms.internal.drive.zznd.zzo(r10, r6), com.google.android.gms.internal.drive.zznd.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzk(r10, r6) == com.google.android.gms.internal.drive.zznd.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzj(r10, r6) == com.google.android.gms.internal.drive.zznd.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzk(r10, r6) == com.google.android.gms.internal.drive.zznd.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzj(r10, r6) == com.google.android.gms.internal.drive.zznd.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzj(r10, r6) == com.google.android.gms.internal.drive.zznd.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzj(r10, r6) == com.google.android.gms.internal.drive.zznd.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.drive.zzmh.zzd(com.google.android.gms.internal.drive.zznd.zzo(r10, r6), com.google.android.gms.internal.drive.zznd.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.drive.zzmh.zzd(com.google.android.gms.internal.drive.zznd.zzo(r10, r6), com.google.android.gms.internal.drive.zznd.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.drive.zzmh.zzd(com.google.android.gms.internal.drive.zznd.zzo(r10, r6), com.google.android.gms.internal.drive.zznd.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzl(r10, r6) == com.google.android.gms.internal.drive.zznd.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzj(r10, r6) == com.google.android.gms.internal.drive.zznd.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzk(r10, r6) == com.google.android.gms.internal.drive.zznd.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzj(r10, r6) == com.google.android.gms.internal.drive.zznd.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzk(r10, r6) == com.google.android.gms.internal.drive.zznd.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.drive.zznd.zzk(r10, r6) == com.google.android.gms.internal.drive.zznd.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.drive.zznd.zzm(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.drive.zznd.zzm(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.drive.zznd.zzn(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.drive.zznd.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.drive.zzmh.zzd(com.google.android.gms.internal.drive.zznd.zzo(r10, r6), com.google.android.gms.internal.drive.zznd.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzud
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzas(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzat(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.drive.zznd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.drive.zznd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.drive.zznd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.drive.zznd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.drive.zznd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.drive.zznd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.drive.zznd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.drive.zznd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.drive.zznd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.drive.zznd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.drive.zzmh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.drive.zznd.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.drive.zznd.zzl(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.drive.zznd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.drive.zznd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.drive.zznd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.drive.zznd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.drive.zznd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.drive.zznd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.drive.zznd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.drive.zznd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.drive.zznd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.drive.zznd.zzm(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.drive.zznd.zzm(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.drive.zznd.zzn(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.drive.zznd.zzn(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.drive.zzmx<?, ?> r0 = r9.zzur
            java.lang.Object r0 = r0.zzr(r10)
            com.google.android.gms.internal.drive.zzmx<?, ?> r2 = r9.zzur
            java.lang.Object r2 = r2.zzr(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzui
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.drive.zzjy<?> r0 = r9.zzus
            com.google.android.gms.internal.drive.zzkb r10 = r0.zzb(r10)
            com.google.android.gms.internal.drive.zzjy<?> r0 = r9.zzus
            com.google.android.gms.internal.drive.zzkb r11 = r0.zzb(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzud
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022d
            int r3 = r8.zzas(r1)
            int[] r4 = r8.zzud
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0229
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zze((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            double r3 = zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.drive.zznd.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.drive.zznd.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0229
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.drive.zznd.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zze((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.drive.zznd.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.drive.zznd.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.drive.zznd.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.drive.zznd.zzm(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.drive.zznd.zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.drive.zzkm.zzu(r3)
        L_0x0227:
            int r3 = r3 + r2
            r2 = r3
        L_0x0229:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022d:
            int r2 = r2 * 53
            com.google.android.gms.internal.drive.zzmx<?, ?> r0 = r8.zzur
            java.lang.Object r0 = r0.zzr(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.zzui
            if (r1 == 0) goto L_0x024b
            int r0 = r0 * 53
            com.google.android.gms.internal.drive.zzjy<?> r1 = r8.zzus
            com.google.android.gms.internal.drive.zzkb r9 = r1.zzb(r9)
            int r9 = r9.hashCode()
            int r0 = r0 + r9
        L_0x024b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zzup.newInstance(this.zzuh);
    }

    public final void zzc(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzud.length; i += 3) {
                int zzas = zzas(i);
                long j = (long) (1048575 & zzas);
                int i2 = this.zzud[i];
                switch ((zzas & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzuq.zza(t, t2, j);
                        break;
                    case 50:
                        zzmh.zza(this.zzut, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zznd.zza((Object) t, j, zznd.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzuk) {
                zzmh.zza(this.zzur, t, t2);
                if (this.zzui) {
                    zzmh.zza(this.zzus, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0323, code lost:
        r11 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r13, r12, r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0839, code lost:
        r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r10, r9, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x09fa, code lost:
        r7 = r7 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:473:0x0a06, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x0a07, code lost:
        r4 = r4 + 3;
        r6 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzn(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.zzuk
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 1
            r7 = 0
            r9 = 0
            if (r2 == 0) goto L_0x04fd
            sun.misc.Unsafe r2 = zzuc
            r10 = 0
            r11 = 0
        L_0x0016:
            int[] r12 = r0.zzud
            int r12 = r12.length
            if (r10 >= r12) goto L_0x04f5
            int r12 = r0.zzas(r10)
            r3 = r3 & r12
            int r3 = r3 >>> 20
            int[] r13 = r0.zzud
            r13 = r13[r10]
            r12 = r12 & r5
            long r14 = (long) r12
            com.google.android.gms.internal.drive.zzke r12 = com.google.android.gms.internal.drive.zzke.DOUBLE_LIST_PACKED
            int r12 = r12.mo29723id()
            if (r3 < r12) goto L_0x0040
            com.google.android.gms.internal.drive.zzke r12 = com.google.android.gms.internal.drive.zzke.SINT64_LIST_PACKED
            int r12 = r12.mo29723id()
            if (r3 > r12) goto L_0x0040
            int[] r12 = r0.zzud
            int r16 = r10 + 2
            r12 = r12[r16]
            r12 = r12 & r5
            goto L_0x0041
        L_0x0040:
            r12 = 0
        L_0x0041:
            switch(r3) {
                case 0: goto L_0x04e2;
                case 1: goto L_0x04d7;
                case 2: goto L_0x04c8;
                case 3: goto L_0x04b9;
                case 4: goto L_0x04aa;
                case 5: goto L_0x049f;
                case 6: goto L_0x0494;
                case 7: goto L_0x0489;
                case 8: goto L_0x046c;
                case 9: goto L_0x0458;
                case 10: goto L_0x0446;
                case 11: goto L_0x0436;
                case 12: goto L_0x0426;
                case 13: goto L_0x041a;
                case 14: goto L_0x040e;
                case 15: goto L_0x03fe;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d8;
                case 18: goto L_0x03ce;
                case 19: goto L_0x03c4;
                case 20: goto L_0x03ba;
                case 21: goto L_0x03b0;
                case 22: goto L_0x03a6;
                case 23: goto L_0x039c;
                case 24: goto L_0x0392;
                case 25: goto L_0x0388;
                case 26: goto L_0x037e;
                case 27: goto L_0x0370;
                case 28: goto L_0x0366;
                case 29: goto L_0x035c;
                case 30: goto L_0x0352;
                case 31: goto L_0x0348;
                case 32: goto L_0x033e;
                case 33: goto L_0x0334;
                case 34: goto L_0x032a;
                case 35: goto L_0x0307;
                case 36: goto L_0x02ea;
                case 37: goto L_0x02cd;
                case 38: goto L_0x02b0;
                case 39: goto L_0x0292;
                case 40: goto L_0x0274;
                case 41: goto L_0x0256;
                case 42: goto L_0x0238;
                case 43: goto L_0x021a;
                case 44: goto L_0x01fc;
                case 45: goto L_0x01de;
                case 46: goto L_0x01c0;
                case 47: goto L_0x01a2;
                case 48: goto L_0x0184;
                case 49: goto L_0x0176;
                case 50: goto L_0x0166;
                case 51: goto L_0x0158;
                case 52: goto L_0x014c;
                case 53: goto L_0x013c;
                case 54: goto L_0x012c;
                case 55: goto L_0x011c;
                case 56: goto L_0x0110;
                case 57: goto L_0x0104;
                case 58: goto L_0x00f8;
                case 59: goto L_0x00da;
                case 60: goto L_0x00c6;
                case 61: goto L_0x00b4;
                case 62: goto L_0x00a4;
                case 63: goto L_0x0094;
                case 64: goto L_0x0088;
                case 65: goto L_0x007c;
                case 66: goto L_0x006c;
                case 67: goto L_0x005c;
                case 68: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x04ef
        L_0x0046:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            com.google.android.gms.internal.drive.zzlq r3 = (com.google.android.gms.internal.drive.zzlq) r3
            com.google.android.gms.internal.drive.zzmf r12 = r0.zzap(r10)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc(r13, r3, r12)
            goto L_0x04ee
        L_0x005c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            long r14 = zzh(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzf((int) r13, (long) r14)
            goto L_0x04ee
        L_0x006c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = zzg(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzi(r13, r3)
            goto L_0x04ee
        L_0x007c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzh((int) r13, (long) r7)
            goto L_0x04ee
        L_0x0088:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzk(r13, r9)
            goto L_0x04ee
        L_0x0094:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = zzg(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzl(r13, r3)
            goto L_0x04ee
        L_0x00a4:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = zzg(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzh((int) r13, (int) r3)
            goto L_0x04ee
        L_0x00b4:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            com.google.android.gms.internal.drive.zzjc r3 = (com.google.android.gms.internal.drive.zzjc) r3
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc((int) r13, (com.google.android.gms.internal.drive.zzjc) r3)
            goto L_0x04ee
        L_0x00c6:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            com.google.android.gms.internal.drive.zzmf r12 = r0.zzap(r10)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzc((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.drive.zzmf) r12)
            goto L_0x04ee
        L_0x00da:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.drive.zzjc
            if (r12 == 0) goto L_0x00f0
            com.google.android.gms.internal.drive.zzjc r3 = (com.google.android.gms.internal.drive.zzjc) r3
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc((int) r13, (com.google.android.gms.internal.drive.zzjc) r3)
            goto L_0x04ee
        L_0x00f0:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.drive.zzjr.zzb((int) r13, (java.lang.String) r3)
            goto L_0x04ee
        L_0x00f8:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc((int) r13, (boolean) r6)
            goto L_0x04ee
        L_0x0104:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzj(r13, r9)
            goto L_0x04ee
        L_0x0110:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzg((int) r13, (long) r7)
            goto L_0x04ee
        L_0x011c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = zzg(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzg((int) r13, (int) r3)
            goto L_0x04ee
        L_0x012c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            long r14 = zzh(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zze((int) r13, (long) r14)
            goto L_0x04ee
        L_0x013c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            long r14 = zzh(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzd((int) r13, (long) r14)
            goto L_0x04ee
        L_0x014c:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzb((int) r13, (float) r4)
            goto L_0x04ee
        L_0x0158:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x04ef
            r14 = 0
            int r3 = com.google.android.gms.internal.drive.zzjr.zzb((int) r13, (double) r14)
            goto L_0x04ee
        L_0x0166:
            com.google.android.gms.internal.drive.zzll r3 = r0.zzut
            java.lang.Object r12 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            java.lang.Object r14 = r0.zzaq(r10)
            int r3 = r3.zzb(r13, r12, r14)
            goto L_0x04ee
        L_0x0176:
            java.util.List r3 = zzd(r1, r14)
            com.google.android.gms.internal.drive.zzmf r12 = r0.zzap(r10)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzd(r13, r3, r12)
            goto L_0x04ee
        L_0x0184:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzc(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x0198
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x0198:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x01a2:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzg((java.util.List<java.lang.Integer>) r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x01b6
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x01b6:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x01c0:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzi(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x01d4
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x01d4:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x01de:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzh(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x01f2
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x01f2:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x01fc:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzd(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x0210
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x0210:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x021a:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzf((java.util.List<java.lang.Integer>) r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x022e
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x022e:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x0238:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzj(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x024c
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x024c:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x0256:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzh(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x026a
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x026a:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x0274:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzi(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x0288
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x0288:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x0292:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zze(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x02a6
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x02a6:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x02b0:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzb(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x02c4
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x02c4:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x02cd:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zza(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x02e1
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x02e1:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x02ea:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzh(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x02fe
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x02fe:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
            goto L_0x0323
        L_0x0307:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.drive.zzmh.zzi(r3)
            if (r3 <= 0) goto L_0x04ef
            boolean r14 = r0.zzul
            if (r14 == 0) goto L_0x031b
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x031b:
            int r12 = com.google.android.gms.internal.drive.zzjr.zzab(r13)
            int r13 = com.google.android.gms.internal.drive.zzjr.zzad(r3)
        L_0x0323:
            int r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r13, r12, r3, r11)
            r11 = r3
            goto L_0x04ef
        L_0x032a:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzq(r13, r3, r9)
            goto L_0x04ee
        L_0x0334:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzu(r13, r3, r9)
            goto L_0x04ee
        L_0x033e:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzw(r13, r3, r9)
            goto L_0x04ee
        L_0x0348:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzv(r13, r3, r9)
            goto L_0x04ee
        L_0x0352:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzr(r13, r3, r9)
            goto L_0x04ee
        L_0x035c:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzt(r13, r3, r9)
            goto L_0x04ee
        L_0x0366:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzd((int) r13, (java.util.List<com.google.android.gms.internal.drive.zzjc>) r3)
            goto L_0x04ee
        L_0x0370:
            java.util.List r3 = zzd(r1, r14)
            com.google.android.gms.internal.drive.zzmf r12 = r0.zzap(r10)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzc((int) r13, (java.util.List<?>) r3, (com.google.android.gms.internal.drive.zzmf) r12)
            goto L_0x04ee
        L_0x037e:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzc(r13, r3)
            goto L_0x04ee
        L_0x0388:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzx(r13, r3, r9)
            goto L_0x04ee
        L_0x0392:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzv(r13, r3, r9)
            goto L_0x04ee
        L_0x039c:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzw(r13, r3, r9)
            goto L_0x04ee
        L_0x03a6:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzs(r13, r3, r9)
            goto L_0x04ee
        L_0x03b0:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzp(r13, r3, r9)
            goto L_0x04ee
        L_0x03ba:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzo(r13, r3, r9)
            goto L_0x04ee
        L_0x03c4:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzv(r13, r3, r9)
            goto L_0x04ee
        L_0x03ce:
            java.util.List r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzw(r13, r3, r9)
            goto L_0x04ee
        L_0x03d8:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            com.google.android.gms.internal.drive.zzlq r3 = (com.google.android.gms.internal.drive.zzlq) r3
            com.google.android.gms.internal.drive.zzmf r12 = r0.zzap(r10)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc(r13, r3, r12)
            goto L_0x04ee
        L_0x03ee:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            long r14 = com.google.android.gms.internal.drive.zznd.zzk(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzf((int) r13, (long) r14)
            goto L_0x04ee
        L_0x03fe:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzi(r13, r3)
            goto L_0x04ee
        L_0x040e:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzh((int) r13, (long) r7)
            goto L_0x04ee
        L_0x041a:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzk(r13, r9)
            goto L_0x04ee
        L_0x0426:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzl(r13, r3)
            goto L_0x04ee
        L_0x0436:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzh((int) r13, (int) r3)
            goto L_0x04ee
        L_0x0446:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            com.google.android.gms.internal.drive.zzjc r3 = (com.google.android.gms.internal.drive.zzjc) r3
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc((int) r13, (com.google.android.gms.internal.drive.zzjc) r3)
            goto L_0x04ee
        L_0x0458:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            com.google.android.gms.internal.drive.zzmf r12 = r0.zzap(r10)
            int r3 = com.google.android.gms.internal.drive.zzmh.zzc((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.drive.zzmf) r12)
            goto L_0x04ee
        L_0x046c:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            java.lang.Object r3 = com.google.android.gms.internal.drive.zznd.zzo(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.drive.zzjc
            if (r12 == 0) goto L_0x0482
            com.google.android.gms.internal.drive.zzjc r3 = (com.google.android.gms.internal.drive.zzjc) r3
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc((int) r13, (com.google.android.gms.internal.drive.zzjc) r3)
            goto L_0x04ee
        L_0x0482:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.drive.zzjr.zzb((int) r13, (java.lang.String) r3)
            goto L_0x04ee
        L_0x0489:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzc((int) r13, (boolean) r6)
            goto L_0x04ee
        L_0x0494:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzj(r13, r9)
            goto L_0x04ee
        L_0x049f:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzg((int) r13, (long) r7)
            goto L_0x04ee
        L_0x04aa:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zznd.zzj(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzg((int) r13, (int) r3)
            goto L_0x04ee
        L_0x04b9:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            long r14 = com.google.android.gms.internal.drive.zznd.zzk(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zze((int) r13, (long) r14)
            goto L_0x04ee
        L_0x04c8:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            long r14 = com.google.android.gms.internal.drive.zznd.zzk(r1, r14)
            int r3 = com.google.android.gms.internal.drive.zzjr.zzd((int) r13, (long) r14)
            goto L_0x04ee
        L_0x04d7:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            int r3 = com.google.android.gms.internal.drive.zzjr.zzb((int) r13, (float) r4)
            goto L_0x04ee
        L_0x04e2:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x04ef
            r14 = 0
            int r3 = com.google.android.gms.internal.drive.zzjr.zzb((int) r13, (double) r14)
        L_0x04ee:
            int r11 = r11 + r3
        L_0x04ef:
            int r10 = r10 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04f5:
            com.google.android.gms.internal.drive.zzmx<?, ?> r2 = r0.zzur
            int r1 = zza(r2, r1)
            int r1 = r1 + r11
            return r1
        L_0x04fd:
            sun.misc.Unsafe r2 = zzuc
            r3 = -1
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x0503:
            int[] r9 = r0.zzud
            int r9 = r9.length
            if (r4 >= r9) goto L_0x0a0c
            int r9 = r0.zzas(r4)
            int[] r10 = r0.zzud
            r11 = r10[r4]
            r12 = 267386880(0xff00000, float:2.3665827E-29)
            r12 = r12 & r9
            int r12 = r12 >>> 20
            r13 = 17
            if (r12 > r13) goto L_0x052b
            int r13 = r4 + 2
            r10 = r10[r13]
            r13 = r10 & r5
            int r14 = r10 >>> 20
            int r6 = r6 << r14
            if (r13 == r3) goto L_0x054b
            long r14 = (long) r13
            int r8 = r2.getInt(r1, r14)
            r3 = r13
            goto L_0x054b
        L_0x052b:
            boolean r6 = r0.zzul
            if (r6 == 0) goto L_0x0548
            com.google.android.gms.internal.drive.zzke r6 = com.google.android.gms.internal.drive.zzke.DOUBLE_LIST_PACKED
            int r6 = r6.mo29723id()
            if (r12 < r6) goto L_0x0548
            com.google.android.gms.internal.drive.zzke r6 = com.google.android.gms.internal.drive.zzke.SINT64_LIST_PACKED
            int r6 = r6.mo29723id()
            if (r12 > r6) goto L_0x0548
            int[] r6 = r0.zzud
            int r10 = r4 + 2
            r6 = r6[r10]
            r6 = r6 & r5
            r10 = r6
            goto L_0x054a
        L_0x0548:
            r6 = 0
            r10 = 0
        L_0x054a:
            r6 = 0
        L_0x054b:
            r9 = r9 & r5
            long r13 = (long) r9
            switch(r12) {
                case 0: goto L_0x09fc;
                case 1: goto L_0x09f2;
                case 2: goto L_0x09e5;
                case 3: goto L_0x09d9;
                case 4: goto L_0x09cd;
                case 5: goto L_0x09c3;
                case 6: goto L_0x09ba;
                case 7: goto L_0x09b1;
                case 8: goto L_0x0998;
                case 9: goto L_0x0988;
                case 10: goto L_0x0979;
                case 11: goto L_0x096c;
                case 12: goto L_0x095f;
                case 13: goto L_0x0955;
                case 14: goto L_0x094a;
                case 15: goto L_0x093d;
                case 16: goto L_0x0930;
                case 17: goto L_0x091d;
                case 18: goto L_0x0910;
                case 19: goto L_0x0903;
                case 20: goto L_0x08f6;
                case 21: goto L_0x08e9;
                case 22: goto L_0x08dc;
                case 23: goto L_0x08cf;
                case 24: goto L_0x08c2;
                case 25: goto L_0x08b5;
                case 26: goto L_0x08a9;
                case 27: goto L_0x0899;
                case 28: goto L_0x088d;
                case 29: goto L_0x0880;
                case 30: goto L_0x0873;
                case 31: goto L_0x0866;
                case 32: goto L_0x0859;
                case 33: goto L_0x084c;
                case 34: goto L_0x083f;
                case 35: goto L_0x081d;
                case 36: goto L_0x0800;
                case 37: goto L_0x07e3;
                case 38: goto L_0x07c6;
                case 39: goto L_0x07a8;
                case 40: goto L_0x078a;
                case 41: goto L_0x076c;
                case 42: goto L_0x074e;
                case 43: goto L_0x0730;
                case 44: goto L_0x0712;
                case 45: goto L_0x06f4;
                case 46: goto L_0x06d6;
                case 47: goto L_0x06b8;
                case 48: goto L_0x069a;
                case 49: goto L_0x068a;
                case 50: goto L_0x067a;
                case 51: goto L_0x066c;
                case 52: goto L_0x065f;
                case 53: goto L_0x064f;
                case 54: goto L_0x063f;
                case 55: goto L_0x062f;
                case 56: goto L_0x0621;
                case 57: goto L_0x0614;
                case 58: goto L_0x0607;
                case 59: goto L_0x05e9;
                case 60: goto L_0x05d5;
                case 61: goto L_0x05c3;
                case 62: goto L_0x05b3;
                case 63: goto L_0x05a3;
                case 64: goto L_0x0596;
                case 65: goto L_0x0588;
                case 66: goto L_0x0578;
                case 67: goto L_0x0568;
                case 68: goto L_0x0552;
                default: goto L_0x0550;
            }
        L_0x0550:
            goto L_0x0a07
        L_0x0552:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.drive.zzlq r6 = (com.google.android.gms.internal.drive.zzlq) r6
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r4)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc(r11, r6, r9)
            goto L_0x09f0
        L_0x0568:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            long r9 = zzh(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzf((int) r11, (long) r9)
            goto L_0x09f0
        L_0x0578:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            int r6 = zzg(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzi(r11, r6)
            goto L_0x09f0
        L_0x0588:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzh((int) r11, (long) r9)
            goto L_0x09f0
        L_0x0596:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r6 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzk(r11, r6)
            goto L_0x09f0
        L_0x05a3:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            int r6 = zzg(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzl(r11, r6)
            goto L_0x09f0
        L_0x05b3:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            int r6 = zzg(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzh((int) r11, (int) r6)
            goto L_0x09f0
        L_0x05c3:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.drive.zzjc r6 = (com.google.android.gms.internal.drive.zzjc) r6
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc((int) r11, (com.google.android.gms.internal.drive.zzjc) r6)
            goto L_0x09f0
        L_0x05d5:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r4)
            int r6 = com.google.android.gms.internal.drive.zzmh.zzc((int) r11, (java.lang.Object) r6, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x09f0
        L_0x05e9:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            boolean r9 = r6 instanceof com.google.android.gms.internal.drive.zzjc
            if (r9 == 0) goto L_0x05ff
            com.google.android.gms.internal.drive.zzjc r6 = (com.google.android.gms.internal.drive.zzjc) r6
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc((int) r11, (com.google.android.gms.internal.drive.zzjc) r6)
            goto L_0x09f0
        L_0x05ff:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.drive.zzjr.zzb((int) r11, (java.lang.String) r6)
            goto L_0x09f0
        L_0x0607:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r6 = 1
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc((int) r11, (boolean) r6)
            goto L_0x09f0
        L_0x0614:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r6 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzj(r11, r6)
            goto L_0x09f0
        L_0x0621:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzg((int) r11, (long) r9)
            goto L_0x09f0
        L_0x062f:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            int r6 = zzg(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzg((int) r11, (int) r6)
            goto L_0x09f0
        L_0x063f:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            long r9 = zzh(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zze((int) r11, (long) r9)
            goto L_0x09f0
        L_0x064f:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            long r9 = zzh(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzd((int) r11, (long) r9)
            goto L_0x09f0
        L_0x065f:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r6 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzb((int) r11, (float) r6)
            goto L_0x09f0
        L_0x066c:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0a07
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzb((int) r11, (double) r9)
            goto L_0x09f0
        L_0x067a:
            com.google.android.gms.internal.drive.zzll r6 = r0.zzut
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.lang.Object r10 = r0.zzaq(r4)
            int r6 = r6.zzb(r11, r9, r10)
            goto L_0x09f0
        L_0x068a:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r4)
            int r6 = com.google.android.gms.internal.drive.zzmh.zzd(r11, r6, r9)
            goto L_0x09f0
        L_0x069a:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzc(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x06ae
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x06ae:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x06b8:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzg((java.util.List<java.lang.Integer>) r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x06cc
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x06cc:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x06d6:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzi(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x06ea
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x06ea:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x06f4:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzh(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0708
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0708:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x0712:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzd(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0726
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0726:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x0730:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzf((java.util.List<java.lang.Integer>) r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0744
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0744:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x074e:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzj(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0762
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0762:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x076c:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzh(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0780
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0780:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x078a:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzi(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x079e
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x079e:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x07a8:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zze(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x07bc
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x07bc:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x07c6:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzb(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x07da
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x07da:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x07e3:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zza(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x07f7
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x07f7:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x0800:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzh(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0814
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0814:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
            goto L_0x0839
        L_0x081d:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzi(r6)
            if (r6 <= 0) goto L_0x0a07
            boolean r9 = r0.zzul
            if (r9 == 0) goto L_0x0831
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x0831:
            int r9 = com.google.android.gms.internal.drive.zzjr.zzab(r11)
            int r10 = com.google.android.gms.internal.drive.zzjr.zzad(r6)
        L_0x0839:
            int r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r10, r9, r6, r7)
            goto L_0x0a06
        L_0x083f:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzmh.zzq(r11, r6, r9)
            goto L_0x09f0
        L_0x084c:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzu(r11, r9, r6)
            goto L_0x09f0
        L_0x0859:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzw(r11, r9, r6)
            goto L_0x09f0
        L_0x0866:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzv(r11, r9, r6)
            goto L_0x09f0
        L_0x0873:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzr(r11, r9, r6)
            goto L_0x09f0
        L_0x0880:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzt(r11, r9, r6)
            goto L_0x09f0
        L_0x088d:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzd((int) r11, (java.util.List<com.google.android.gms.internal.drive.zzjc>) r6)
            goto L_0x09f0
        L_0x0899:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r4)
            int r6 = com.google.android.gms.internal.drive.zzmh.zzc((int) r11, (java.util.List<?>) r6, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x09f0
        L_0x08a9:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.drive.zzmh.zzc(r11, r6)
            goto L_0x09f0
        L_0x08b5:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzmh.zzx(r11, r6, r9)
            goto L_0x09f0
        L_0x08c2:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzv(r11, r9, r6)
            goto L_0x09f0
        L_0x08cf:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzw(r11, r9, r6)
            goto L_0x09f0
        L_0x08dc:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzs(r11, r9, r6)
            goto L_0x09f0
        L_0x08e9:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzp(r11, r9, r6)
            goto L_0x09f0
        L_0x08f6:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzo(r11, r9, r6)
            goto L_0x09f0
        L_0x0903:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzv(r11, r9, r6)
            goto L_0x09f0
        L_0x0910:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.drive.zzmh.zzw(r11, r9, r6)
            goto L_0x09f0
        L_0x091d:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.drive.zzlq r6 = (com.google.android.gms.internal.drive.zzlq) r6
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r4)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc(r11, r6, r9)
            goto L_0x09f0
        L_0x0930:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzf((int) r11, (long) r9)
            goto L_0x09f0
        L_0x093d:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            int r6 = r2.getInt(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzi(r11, r6)
            goto L_0x09f0
        L_0x094a:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzh((int) r11, (long) r9)
            goto L_0x09f0
        L_0x0955:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            r6 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzk(r11, r6)
            goto L_0x09f0
        L_0x095f:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            int r6 = r2.getInt(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzl(r11, r6)
            goto L_0x09f0
        L_0x096c:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            int r6 = r2.getInt(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzh((int) r11, (int) r6)
            goto L_0x09f0
        L_0x0979:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.drive.zzjc r6 = (com.google.android.gms.internal.drive.zzjc) r6
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc((int) r11, (com.google.android.gms.internal.drive.zzjc) r6)
            goto L_0x09f0
        L_0x0988:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r4)
            int r6 = com.google.android.gms.internal.drive.zzmh.zzc((int) r11, (java.lang.Object) r6, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x09f0
        L_0x0998:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            java.lang.Object r6 = r2.getObject(r1, r13)
            boolean r9 = r6 instanceof com.google.android.gms.internal.drive.zzjc
            if (r9 == 0) goto L_0x09aa
            com.google.android.gms.internal.drive.zzjc r6 = (com.google.android.gms.internal.drive.zzjc) r6
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc((int) r11, (com.google.android.gms.internal.drive.zzjc) r6)
            goto L_0x09f0
        L_0x09aa:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.drive.zzjr.zzb((int) r11, (java.lang.String) r6)
            goto L_0x09f0
        L_0x09b1:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            r6 = 1
            int r6 = com.google.android.gms.internal.drive.zzjr.zzc((int) r11, (boolean) r6)
            goto L_0x09fa
        L_0x09ba:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            r6 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzj(r11, r6)
            goto L_0x09fa
        L_0x09c3:
            r6 = r6 & r8
            r9 = 0
            if (r6 == 0) goto L_0x0a07
            int r6 = com.google.android.gms.internal.drive.zzjr.zzg((int) r11, (long) r9)
            goto L_0x09f0
        L_0x09cd:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            int r6 = r2.getInt(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzg((int) r11, (int) r6)
            goto L_0x09f0
        L_0x09d9:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zze((int) r11, (long) r9)
            goto L_0x09f0
        L_0x09e5:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r13)
            int r6 = com.google.android.gms.internal.drive.zzjr.zzd((int) r11, (long) r9)
        L_0x09f0:
            int r7 = r7 + r6
            goto L_0x0a07
        L_0x09f2:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            r6 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzb((int) r11, (float) r6)
        L_0x09fa:
            int r7 = r7 + r6
            goto L_0x0a07
        L_0x09fc:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0a07
            r9 = 0
            int r6 = com.google.android.gms.internal.drive.zzjr.zzb((int) r11, (double) r9)
            int r6 = r6 + r7
        L_0x0a06:
            r7 = r6
        L_0x0a07:
            int r4 = r4 + 3
            r6 = 1
            goto L_0x0503
        L_0x0a0c:
            r2 = 0
            com.google.android.gms.internal.drive.zzmx<?, ?> r3 = r0.zzur
            int r3 = zza(r3, r1)
            int r3 = r3 + r7
            boolean r4 = r0.zzui
            if (r4 == 0) goto L_0x0a66
            com.google.android.gms.internal.drive.zzjy<?> r4 = r0.zzus
            com.google.android.gms.internal.drive.zzkb r1 = r4.zzb(r1)
            r4 = 0
        L_0x0a1f:
            com.google.android.gms.internal.drive.zzmi<FieldDescriptorType, java.lang.Object> r5 = r1.zzos
            int r5 = r5.zzer()
            if (r4 >= r5) goto L_0x0a3f
            com.google.android.gms.internal.drive.zzmi<FieldDescriptorType, java.lang.Object> r5 = r1.zzos
            java.util.Map$Entry r5 = r5.zzaw(r4)
            java.lang.Object r6 = r5.getKey()
            com.google.android.gms.internal.drive.zzkd r6 = (com.google.android.gms.internal.drive.zzkd) r6
            java.lang.Object r5 = r5.getValue()
            int r5 = com.google.android.gms.internal.drive.zzkb.zzb((com.google.android.gms.internal.drive.zzkd<?>) r6, (java.lang.Object) r5)
            int r2 = r2 + r5
            int r4 = r4 + 1
            goto L_0x0a1f
        L_0x0a3f:
            com.google.android.gms.internal.drive.zzmi<FieldDescriptorType, java.lang.Object> r1 = r1.zzos
            java.lang.Iterable r1 = r1.zzes()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a49:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0a65
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.google.android.gms.internal.drive.zzkd r5 = (com.google.android.gms.internal.drive.zzkd) r5
            java.lang.Object r4 = r4.getValue()
            int r4 = com.google.android.gms.internal.drive.zzkb.zzb((com.google.android.gms.internal.drive.zzkd<?>) r5, (java.lang.Object) r4)
            int r2 = r2 + r4
            goto L_0x0a49
        L_0x0a65:
            int r3 = r3 + r2
        L_0x0a66:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zzn(java.lang.Object):int");
    }

    public final boolean zzp(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzun) {
                return !this.zzui || this.zzus.zzb(t).isInitialized();
            }
            int i5 = this.zzum[i3];
            int i6 = this.zzud[i5];
            int zzas = zzas(i5);
            if (!this.zzuk) {
                int i7 = this.zzud[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzuc.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzas) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzas) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzas, zzap(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzi = this.zzut.zzi(zznd.zzo(t, (long) (zzas & 1048575)));
                            if (!zzi.isEmpty()) {
                                if (this.zzut.zzm(zzaq(i5)).zztw.zzfj() == zznr.MESSAGE) {
                                    zzmf<?> zzmf = null;
                                    Iterator<?> it = zzi.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzmf == null) {
                                            zzmf = zzmd.zzej().zzf(next.getClass());
                                        }
                                        if (!zzmf.zzp(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zznd.zzo(t, (long) (zzas & 1048575));
                if (!list.isEmpty()) {
                    zzmf zzap = zzap(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzap.zzp(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzas, zzap(i5))) {
                return false;
            }
            i3++;
        }
    }

    public final void zzd(T t) {
        int i;
        int i2 = this.zzun;
        while (true) {
            i = this.zzuo;
            if (i2 >= i) {
                break;
            }
            long zzas = (long) (zzas(this.zzum[i2]) & 1048575);
            Object zzo = zznd.zzo(t, zzas);
            if (zzo != null) {
                zznd.zza((Object) t, zzas, this.zzut.zzk(zzo));
            }
            i2++;
        }
        int length = this.zzum.length;
        while (i < length) {
            this.zzuq.zza(t, (long) this.zzum[i]);
            i++;
        }
        this.zzur.zzd(t);
        if (this.zzui) {
            this.zzus.zzd(t);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.drive.zzns r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzui
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.drive.zzjy<?> r3 = r0.zzus
            com.google.android.gms.internal.drive.zzkb r3 = r3.zzb(r1)
            com.google.android.gms.internal.drive.zzmi<FieldDescriptorType, java.lang.Object> r5 = r3.zzos
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zzud
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzuc
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzas(r10)
            int[] r13 = r0.zzud
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzuk
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005d
            r4 = 17
            if (r15 > r4) goto L_0x005d
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0057
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
        L_0x0057:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0060
        L_0x005d:
            r17 = r10
            r4 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x007e
            com.google.android.gms.internal.drive.zzjy<?> r9 = r0.zzus
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.drive.zzjy<?> r9 = r0.zzus
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0060
        L_0x007c:
            r5 = 0
            goto L_0x0060
        L_0x007e:
            r9 = r12 & r16
            long r9 = (long) r9
            r12 = r17
            switch(r15) {
                case 0: goto L_0x0485;
                case 1: goto L_0x0479;
                case 2: goto L_0x046d;
                case 3: goto L_0x0461;
                case 4: goto L_0x0455;
                case 5: goto L_0x0449;
                case 6: goto L_0x043d;
                case 7: goto L_0x0431;
                case 8: goto L_0x0425;
                case 9: goto L_0x0414;
                case 10: goto L_0x0405;
                case 11: goto L_0x03f8;
                case 12: goto L_0x03eb;
                case 13: goto L_0x03de;
                case 14: goto L_0x03d1;
                case 15: goto L_0x03c4;
                case 16: goto L_0x03b7;
                case 17: goto L_0x03a6;
                case 18: goto L_0x0396;
                case 19: goto L_0x0386;
                case 20: goto L_0x0376;
                case 21: goto L_0x0366;
                case 22: goto L_0x0356;
                case 23: goto L_0x0346;
                case 24: goto L_0x0336;
                case 25: goto L_0x0326;
                case 26: goto L_0x0317;
                case 27: goto L_0x0304;
                case 28: goto L_0x02f5;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02d5;
                case 31: goto L_0x02c5;
                case 32: goto L_0x02b5;
                case 33: goto L_0x02a5;
                case 34: goto L_0x0295;
                case 35: goto L_0x0285;
                case 36: goto L_0x0275;
                case 37: goto L_0x0265;
                case 38: goto L_0x0255;
                case 39: goto L_0x0245;
                case 40: goto L_0x0235;
                case 41: goto L_0x0225;
                case 42: goto L_0x0215;
                case 43: goto L_0x0205;
                case 44: goto L_0x01f5;
                case 45: goto L_0x01e5;
                case 46: goto L_0x01d5;
                case 47: goto L_0x01c5;
                case 48: goto L_0x01b5;
                case 49: goto L_0x01a2;
                case 50: goto L_0x0199;
                case 51: goto L_0x018a;
                case 52: goto L_0x017b;
                case 53: goto L_0x016c;
                case 54: goto L_0x015d;
                case 55: goto L_0x014e;
                case 56: goto L_0x013f;
                case 57: goto L_0x0130;
                case 58: goto L_0x0121;
                case 59: goto L_0x0112;
                case 60: goto L_0x00ff;
                case 61: goto L_0x00ef;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00d3;
                case 64: goto L_0x00c5;
                case 65: goto L_0x00b7;
                case 66: goto L_0x00a9;
                case 67: goto L_0x009b;
                case 68: goto L_0x0089;
                default: goto L_0x0086;
            }
        L_0x0086:
            r13 = 0
            goto L_0x0490
        L_0x0089:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzb((int) r14, (long) r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzjc r4 = (com.google.android.gms.internal.drive.zzjc) r4
            r2.zza((int) r14, (com.google.android.gms.internal.drive.zzjc) r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x0086
        L_0x0112:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.drive.zzns) r2)
            goto L_0x0086
        L_0x0121:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            boolean r4 = zzi(r1, r9)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzc((int) r14, (long) r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzc((int) r14, (int) r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zza((int) r14, (long) r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzf(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zze(r1, r9)
            r2.zza((int) r14, (double) r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza((com.google.android.gms.internal.drive.zzns) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmf r10 = r0.zzap(r12)
            com.google.android.gms.internal.drive.zzmh.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.drive.zzns) r2, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.drive.zzmh.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.drive.zzns) r2, (boolean) r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.drive.zzns) r2, (boolean) r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.drive.zzmh.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmf r10 = r0.zzap(r12)
            com.google.android.gms.internal.drive.zzmh.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.drive.zzns) r2, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.drive.zzns) r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.drive.zzmh.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.drive.zzns) r2, (boolean) r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zzud
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.drive.zzns) r2, (boolean) r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x0490
        L_0x03b7:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzb((int) r14, (long) r9)
            goto L_0x0490
        L_0x03c4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0490
        L_0x03d1:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0490
        L_0x03de:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzjc r4 = (com.google.android.gms.internal.drive.zzjc) r4
            r2.zza((int) r14, (com.google.android.gms.internal.drive.zzjc) r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzmf r9 = r0.zzap(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.drive.zzmf) r9)
            goto L_0x0490
        L_0x0425:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.drive.zzns) r2)
            goto L_0x0490
        L_0x0431:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            boolean r4 = com.google.android.gms.internal.drive.zznd.zzl(r1, r9)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0490
        L_0x0449:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzc((int) r14, (long) r9)
            goto L_0x0490
        L_0x0455:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzc((int) r14, (int) r4)
            goto L_0x0490
        L_0x0461:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zza((int) r14, (long) r9)
            goto L_0x0490
        L_0x046d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0490
        L_0x0479:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            float r4 = com.google.android.gms.internal.drive.zznd.zzm(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.drive.zznd.zzn(r1, r9)
            r2.zza((int) r14, (double) r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.drive.zzjy<?> r4 = r0.zzus
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0494
        L_0x04a9:
            r5 = 0
            goto L_0x0494
        L_0x04ab:
            com.google.android.gms.internal.drive.zzmx<?, ?> r3 = r0.zzur
            zza(r3, r1, (com.google.android.gms.internal.drive.zzns) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zzb(java.lang.Object, com.google.android.gms.internal.drive.zzns):void");
    }

    private final int zzp(int i, int i2) {
        if (i < this.zzuf || i > this.zzug) {
            return -1;
        }
        return zzq(i, i2);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    public static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(arrays, name.length() + GeneratedOutlineSupport.outline3(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", arrays));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzas = (long) (zzas(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zznd.zzo(t, zzas);
            Object zzo2 = zznd.zzo(t2, zzas);
            if (zzo != null && zzo2 != null) {
                zznd.zza((Object) t, zzas, zzkm.zza(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zznd.zza((Object) t, zzas, zzo2);
                zzb(t, i);
            }
        }
    }

    public static <UT, UB> int zza(zzmx<UT, UB> zzmx, T t) {
        return zzmx.zzn(zzmx.zzr(t));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.drive.zzns r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzcd()
            int r1 = com.google.android.gms.internal.drive.zzkk.zze.zzsj
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.drive.zzmx<?, ?> r0 = r13.zzur
            zza(r0, r14, (com.google.android.gms.internal.drive.zzns) r15)
            boolean r0 = r13.zzui
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.drive.zzjy<?> r0 = r13.zzus
            com.google.android.gms.internal.drive.zzkb r0 = r0.zzb(r14)
            com.google.android.gms.internal.drive.zzmi<FieldDescriptorType, java.lang.Object> r1 = r0.zzos
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzud
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzas(r7)
            int[] r9 = r13.zzud
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.drive.zzjy<?> r10 = r13.zzus
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.drive.zzjy<?> r10 = r13.zzus
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            com.google.android.gms.internal.drive.zzmf r10 = r13.zzap(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzm(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            com.google.android.gms.internal.drive.zzjc r8 = (com.google.android.gms.internal.drive.zzjc) r8
            r15.zza((int) r9, (com.google.android.gms.internal.drive.zzjc) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            com.google.android.gms.internal.drive.zzmf r10 = r13.zzap(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.drive.zzns) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            r13.zza((com.google.android.gms.internal.drive.zzns) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmf r10 = r13.zzap(r7)
            com.google.android.gms.internal.drive.zzmh.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.drive.zzns) r15, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmf r10 = r13.zzap(r7)
            com.google.android.gms.internal.drive.zzmh.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.drive.zzns) r15, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.drive.zzns) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzud
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.drive.zzmh.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            com.google.android.gms.internal.drive.zzmf r10 = r13.zzap(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.drive.zznd.zzk(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.drive.zznd.zzk(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r14, r10)
            r15.zzm(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            com.google.android.gms.internal.drive.zzjc r8 = (com.google.android.gms.internal.drive.zzjc) r8
            r15.zza((int) r9, (com.google.android.gms.internal.drive.zzjc) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            com.google.android.gms.internal.drive.zzmf r10 = r13.zzap(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.drive.zzmf) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.drive.zznd.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.drive.zzns) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.drive.zznd.zzl(r14, r10)
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.drive.zznd.zzk(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.drive.zznd.zzj(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.drive.zznd.zzk(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.drive.zznd.zzk(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.drive.zznd.zzm(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.drive.zznd.zzn(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.drive.zzjy<?> r14 = r13.zzus
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzuk
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzui
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.drive.zzjy<?> r0 = r13.zzus
            com.google.android.gms.internal.drive.zzkb r0 = r0.zzb(r14)
            com.google.android.gms.internal.drive.zzmi<FieldDescriptorType, java.lang.Object> r1 = r0.zzos
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzud
            int r7 = r7.length
            r8 = 0
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzas(r8)
            int[] r10 = r13.zzud
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.drive.zzjy<?> r11 = r13.zzus
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.drive.zzjy<?> r11 = r13.zzus
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            com.google.android.gms.internal.drive.zzmf r11 = r13.zzap(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.drive.zzmf) r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzm(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            com.google.android.gms.internal.drive.zzjc r9 = (com.google.android.gms.internal.drive.zzjc) r9
            r15.zza((int) r10, (com.google.android.gms.internal.drive.zzjc) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            com.google.android.gms.internal.drive.zzmf r11 = r13.zzap(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.drive.zzmf) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.drive.zzns) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            r13.zza((com.google.android.gms.internal.drive.zzns) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmf r11 = r13.zzap(r8)
            com.google.android.gms.internal.drive.zzmh.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.drive.zzns) r15, (com.google.android.gms.internal.drive.zzmf) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmf r11 = r13.zzap(r8)
            com.google.android.gms.internal.drive.zzmh.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.drive.zzns) r15, (com.google.android.gms.internal.drive.zzmf) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.drive.zzns) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzud
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.drive.zzmh.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.drive.zzns) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            com.google.android.gms.internal.drive.zzmf r11 = r13.zzap(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.drive.zzmf) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.drive.zznd.zzk(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.drive.zznd.zzj(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.drive.zznd.zzk(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.drive.zznd.zzj(r14, r11)
            r15.zzm(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.drive.zznd.zzj(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.drive.zznd.zzj(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            com.google.android.gms.internal.drive.zzjc r9 = (com.google.android.gms.internal.drive.zzjc) r9
            r15.zza((int) r10, (com.google.android.gms.internal.drive.zzjc) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            com.google.android.gms.internal.drive.zzmf r11 = r13.zzap(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.drive.zzmf) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.drive.zznd.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.drive.zzns) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.drive.zznd.zzl(r14, r11)
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.drive.zznd.zzj(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.drive.zznd.zzk(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.drive.zznd.zzj(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.drive.zznd.zzk(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.drive.zznd.zzk(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.drive.zznd.zzm(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.drive.zznd.zzn(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.drive.zzjy<?> r2 = r13.zzus
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.drive.zzmx<?, ?> r0 = r13.zzur
            zza(r0, r14, (com.google.android.gms.internal.drive.zzns) r15)
            return
        L_0x0a44:
            r13.zzb(r14, (com.google.android.gms.internal.drive.zzns) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(java.lang.Object, com.google.android.gms.internal.drive.zzns):void");
    }

    private final void zzb(T t, int i) {
        if (!this.zzuk) {
            int zzat = zzat(i);
            long j = (long) (zzat & 1048575);
            zznd.zza((Object) t, j, zznd.zzj(t, j) | (1 << (zzat >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zznd.zza((Object) t, (long) (zzat(i2) & 1048575), i);
    }

    private final <K, V> void zza(zzns zzns, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzns.zza(i, this.zzut.zzm(zzaq(i2)), this.zzut.zzi(obj));
        }
    }

    public static <UT, UB> void zza(zzmx<UT, UB> zzmx, T t, zzns zzns) throws IOException {
        zzmx.zza(zzmx.zzr(t), zzns);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.drive.zznm r4, java.lang.Class<?> r5, com.google.android.gms.internal.drive.zziz r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.drive.zzlv.zzox
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.drive.zziy.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r1, r2, r6)
            long r2 = r6.zznl
            long r2 = com.google.android.gms.internal.drive.zzjo.zzk(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zznm = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r1, r2, r6)
            int r2 = r6.zznk
            int r2 = com.google.android.gms.internal.drive.zzjo.zzw(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zznm = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.drive.zzmd r4 = com.google.android.gms.internal.drive.zzmd.zzej()
            com.google.android.gms.internal.drive.zzmf r4 = r4.zzf(r5)
            int r1 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.drive.zziz) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r1, r2, r6)
            long r2 = r6.zznl
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zznm = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r1, r2, r6)
            int r2 = r6.zznk
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zznm = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.drive.zziy.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zznm = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.drive.zziy.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zznm = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zznm = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.drive.zziy.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zznm = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.drive.zziy.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r1, r2, r6)
            long r2 = r6.zznl
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zznm = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(byte[], int, int, com.google.android.gms.internal.drive.zznm, java.lang.Class, com.google.android.gms.internal.drive.zziz):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.drive.zziz r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzuc
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.drive.zzkp r11 = (com.google.android.gms.internal.drive.zzkp) r11
            boolean r12 = r11.zzbo()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.drive.zzkp r11 = r11.zzr(r12)
            sun.misc.Unsafe r12 = zzuc
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.drive.zzmf r1 = r0.zzap(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.drive.zziz) r27)
            java.lang.Object r8 = r7.zznm
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r9 = r7.zznk
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.drive.zziz) r27)
            java.lang.Object r8 = r7.zznm
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.drive.zzle r11 = (com.google.android.gms.internal.drive.zzle) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r3, r1, r7)
            long r4 = r7.zznl
            long r4 = com.google.android.gms.internal.drive.zzjo.zzk(r4)
            r11.zzv(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.drive.zzle r11 = (com.google.android.gms.internal.drive.zzle) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r7)
            long r8 = r7.zznl
            long r8 = com.google.android.gms.internal.drive.zzjo.zzk(r8)
            r11.zzv(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r7)
            long r8 = r7.zznl
            long r8 = com.google.android.gms.internal.drive.zzjo.zzk(r8)
            r11.zzv(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.drive.zzkl r11 = (com.google.android.gms.internal.drive.zzkl) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r4 = r7.zznk
            int r4 = com.google.android.gms.internal.drive.zzjo.zzw(r4)
            r11.zzam(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.drive.zzkl r11 = (com.google.android.gms.internal.drive.zzkl) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r4 = r7.zznk
            int r4 = com.google.android.gms.internal.drive.zzjo.zzw(r4)
            r11.zzam(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r4 = r7.zznk
            int r4 = com.google.android.gms.internal.drive.zzjo.zzw(r4)
            r11.zzam(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.drive.zziy.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.drive.zzkp<?>) r11, (com.google.android.gms.internal.drive.zziz) r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.drive.zziy.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.drive.zzkp<?>) r6, (com.google.android.gms.internal.drive.zziz) r7)
        L_0x0131:
            com.google.android.gms.internal.drive.zzkk r1 = (com.google.android.gms.internal.drive.zzkk) r1
            com.google.android.gms.internal.drive.zzmy r3 = r1.zzrq
            com.google.android.gms.internal.drive.zzmy r4 = com.google.android.gms.internal.drive.zzmy.zzfa()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.drive.zzko r4 = r0.zzar(r8)
            com.google.android.gms.internal.drive.zzmx<?, ?> r5 = r0.zzur
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.drive.zzmh.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.drive.zzmy r3 = (com.google.android.gms.internal.drive.zzmy) r3
            if (r3 == 0) goto L_0x014e
            r1.zzrq = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r4 = r7.zznk
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.drive.zzjc r4 = com.google.android.gms.internal.drive.zzjc.zznq
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.drive.zzjc r6 = com.google.android.gms.internal.drive.zzjc.zzb((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r4 = r7.zznk
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.drive.zzjc r4 = com.google.android.gms.internal.drive.zzjc.zznq
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.drive.zzjc r6 = com.google.android.gms.internal.drive.zzjc.zzb((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdj()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdj()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.drive.zzmf r1 = r0.zzap(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r6 = r7.zznk
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.drive.zzkm.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r8 = r7.zznk
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r6, r7)
            int r6 = r7.zznk
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.drive.zzkm.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdj()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdj()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r6 = r7.zznk
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.drive.zznf.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.drive.zzkm.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r8 = r7.zznk
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r6, r7)
            int r6 = r7.zznk
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.drive.zznf.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.drive.zzkm.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdn()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdj()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdn()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdj()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.drive.zzja r11 = (com.google.android.gms.internal.drive.zzja) r11
            int r2 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r4 = r7.zznk
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.drive.zziy.zzb(r3, r2, r7)
            long r5 = r7.zznl
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.addBoolean(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.drive.zzja r11 = (com.google.android.gms.internal.drive.zzja) r11
            int r4 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r7)
            long r8 = r7.zznl
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.addBoolean(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r8 = r7.zznk
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.drive.zziy.zzb(r3, r6, r7)
            long r8 = r7.zznl
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.addBoolean(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.drive.zzkl r11 = (com.google.android.gms.internal.drive.zzkl) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1)
            r11.zzam(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.drive.zzkl r11 = (com.google.android.gms.internal.drive.zzkl) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r18, r19)
            r11.zzam(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4)
            r11.zzam(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.drive.zzle r11 = (com.google.android.gms.internal.drive.zzle) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.drive.zziy.zzb(r3, r1)
            r11.zzv(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.drive.zzle r11 = (com.google.android.gms.internal.drive.zzle) r11
            long r8 = com.google.android.gms.internal.drive.zziy.zzb(r18, r19)
            r11.zzv(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4)
            r11.zzv(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.drive.zziy.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.drive.zzkp<?>) r11, (com.google.android.gms.internal.drive.zziz) r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.drive.zziy.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.drive.zzkp<?>) r25, (com.google.android.gms.internal.drive.zziz) r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.drive.zzle r11 = (com.google.android.gms.internal.drive.zzle) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r3, r1, r7)
            long r4 = r7.zznl
            r11.zzv(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.drive.zzle r11 = (com.google.android.gms.internal.drive.zzle) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r7)
            long r8 = r7.zznl
            r11.zzv(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r7)
            long r8 = r7.zznl
            r11.zzv(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.drive.zzkh r11 = (com.google.android.gms.internal.drive.zzkh) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.drive.zziy.zzd(r3, r1)
            r11.zzc(r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.drive.zzkh r11 = (com.google.android.gms.internal.drive.zzkh) r11
            float r1 = com.google.android.gms.internal.drive.zziy.zzd(r18, r19)
            r11.zzc(r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.drive.zziy.zzd(r3, r4)
            r11.zzc(r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.drive.zzju r11 = (com.google.android.gms.internal.drive.zzju) r11
            int r1 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r7)
            int r2 = r7.zznk
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.drive.zziy.zzc(r3, r1)
            r11.zzc(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdi()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.drive.zzju r11 = (com.google.android.gms.internal.drive.zzju) r11
            double r8 = com.google.android.gms.internal.drive.zziy.zzc(r18, r19)
            r11.zzc(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r3, r1, r7)
            int r6 = r7.zznk
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.drive.zziy.zzc(r3, r4)
            r11.zzc(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.drive.zziz):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.drive.zziz r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzuc
            java.lang.Object r12 = r7.zzaq(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.drive.zzll r2 = r7.zzut
            boolean r2 = r2.zzj(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.drive.zzll r2 = r7.zzut
            java.lang.Object r2 = r2.zzl(r12)
            com.google.android.gms.internal.drive.zzll r3 = r7.zzut
            r3.zzb(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.drive.zzll r8 = r7.zzut
            com.google.android.gms.internal.drive.zzlj r8 = r8.zzm(r12)
            com.google.android.gms.internal.drive.zzll r12 = r7.zzut
            java.util.Map r12 = r12.zzh(r1)
            int r10 = com.google.android.gms.internal.drive.zziy.zza(r9, r10, r15)
            int r13 = r15.zznk
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zztv
            V r0 = r8.zztx
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.drive.zziy.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.drive.zziz) r15)
            int r10 = r15.zznk
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.drive.zznm r1 = r8.zztw
            int r1 = r1.zzfk()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.drive.zznm r4 = r8.zztw
            V r10 = r8.zztx
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.drive.zznm) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.drive.zziz) r6)
            java.lang.Object r0 = r15.zznm
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.drive.zznm r1 = r8.zztu
            int r1 = r1.zzfk()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.drive.zznm r4 = r8.zztu
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.drive.zznm) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.drive.zziz) r6)
            java.lang.Object r14 = r15.zznm
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.drive.zziy.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.drive.zziz) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.drive.zzkq r8 = com.google.android.gms.internal.drive.zzkq.zzdm()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.drive.zzkq r8 = com.google.android.gms.internal.drive.zzkq.zzdi()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.drive.zziz):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.drive.zziz r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzuc
            int[] r7 = r0.zzud
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.drive.zzmf r2 = r0.zzap(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.drive.zziz) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zznm
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zznm
            java.lang.Object r3 = com.google.android.gms.internal.drive.zzkm.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r11)
            long r3 = r11.zznl
            long r3 = com.google.android.gms.internal.drive.zzjo.zzk(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r11)
            int r3 = r11.zznk
            int r3 = com.google.android.gms.internal.drive.zzjo.zzw(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r11)
            int r4 = r11.zznk
            com.google.android.gms.internal.drive.zzko r5 = r0.zzar(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzan(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.drive.zzmy r1 = zzo(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzb(r2, r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zznm
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.drive.zzmf r2 = r0.zzap(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.drive.zziz) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zznm
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zznm
            java.lang.Object r3 = com.google.android.gms.internal.drive.zzkm.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r11)
            int r4 = r11.zznk
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.drive.zznf.zze(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.drive.zzkq r1 = com.google.android.gms.internal.drive.zzkq.zzdn()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.drive.zzkm.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r11)
            long r3 = r11.zznl
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.drive.zziy.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zza(r3, r4, r11)
            int r3 = r11.zznk
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.drive.zziy.zzb(r3, r4, r11)
            long r3 = r11.zznl
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.drive.zziy.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.drive.zziy.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.drive.zziz):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x036a, code lost:
        if (r0 == r15) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b3, code lost:
        if (r0 == r15) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0174, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0213, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0215, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r35;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x023f, code lost:
        r33 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b6, code lost:
        r0 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02b8, code lost:
        r6 = r6 | r22;
        r7 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02bc, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02c0, code lost:
        r13 = r34;
        r11 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02c6, code lost:
        r2 = r7;
        r19 = r9;
        r27 = r10;
        r25 = r11;
        r7 = r33;
        r9 = r8;
        r8 = r35;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.drive.zziz r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = zzuc
            r16 = 0
            r0 = r33
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x047d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.drive.zziy.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.drive.zziz) r9)
            int r3 = r9.zznk
            r4 = r0
            r5 = r3
            goto L_0x002d
        L_0x002b:
            r5 = r0
            r4 = r3
        L_0x002d:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.zzp(r3, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzau(r3)
        L_0x003e:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004d
            r25 = r3
            r2 = r4
            r9 = r5
            r27 = r10
            r8 = r11
            r19 = 0
            goto L_0x03e1
        L_0x004d:
            int[] r1 = r15.zzud
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02d4
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r17
            r5 = -1
            if (r1 == r7) goto L_0x007e
            if (r7 == r5) goto L_0x0078
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0078:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
        L_0x007e:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x029e;
                case 1: goto L_0x0284;
                case 2: goto L_0x025e;
                case 3: goto L_0x025e;
                case 4: goto L_0x0243;
                case 5: goto L_0x021e;
                case 6: goto L_0x01fb;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01ae;
                case 9: goto L_0x0178;
                case 10: goto L_0x015d;
                case 11: goto L_0x0243;
                case 12: goto L_0x012b;
                case 13: goto L_0x01fb;
                case 14: goto L_0x021e;
                case 15: goto L_0x0110;
                case 16: goto L_0x00e3;
                case 17: goto L_0x0091;
                default: goto L_0x0082;
            }
        L_0x0082:
            r12 = r32
            r13 = r36
            r9 = r2
            r11 = r3
            r33 = r7
            r8 = r19
            r19 = -1
        L_0x008e:
            r7 = r4
            goto L_0x02c6
        L_0x0091:
            r8 = 3
            if (r0 != r8) goto L_0x00d7
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.drive.zzmf r0 = r15.zzap(r2)
            r1 = r32
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r34
            r4 = r8
            r8 = r19
            r19 = -1
            r5 = r36
            int r0 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.drive.zziz) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00ba
            r5 = r36
            java.lang.Object r1 = r5.zznm
            r10.putObject(r14, r12, r1)
            goto L_0x00c9
        L_0x00ba:
            r5 = r36
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zznm
            java.lang.Object r1 = com.google.android.gms.internal.drive.zzkm.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00c9:
            r6 = r6 | r22
            r12 = r32
            r13 = r34
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r35
            r9 = r5
            goto L_0x0017
        L_0x00d7:
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            goto L_0x023f
        L_0x00e3:
            r5 = r36
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = -1
            if (r0 != 0) goto L_0x010b
            r2 = r12
            r12 = r32
            int r13 = com.google.android.gms.internal.drive.zziy.zzb(r12, r4, r5)
            long r0 = r5.zznl
            long r17 = com.google.android.gms.internal.drive.zzjo.zzk(r0)
            r0 = r10
            r1 = r31
            r33 = r13
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r33
            goto L_0x02bc
        L_0x010b:
            r12 = r32
            r13 = r5
            goto L_0x023f
        L_0x0110:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x023f
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r4, r13)
            int r1 = r13.zznk
            int r1 = com.google.android.gms.internal.drive.zzjo.zzw(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0174
        L_0x012b:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x023f
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r4, r13)
            int r1 = r13.zznk
            com.google.android.gms.internal.drive.zzko r4 = r15.zzar(r9)
            if (r4 == 0) goto L_0x0159
            boolean r4 = r4.zzan(r1)
            if (r4 == 0) goto L_0x014b
            goto L_0x0159
        L_0x014b:
            com.google.android.gms.internal.drive.zzmy r2 = zzo(r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r8, r1)
            goto L_0x02bc
        L_0x0159:
            r10.putInt(r14, r2, r1)
            goto L_0x0174
        L_0x015d:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x023f
            int r0 = com.google.android.gms.internal.drive.zziy.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zznm
            r10.putObject(r14, r2, r1)
        L_0x0174:
            r6 = r6 | r22
            goto L_0x02bc
        L_0x0178:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x01aa
            com.google.android.gms.internal.drive.zzmf r0 = r15.zzap(r9)
            r5 = r34
            int r0 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.drive.zziz) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x019b
            java.lang.Object r1 = r13.zznm
            r10.putObject(r14, r2, r1)
            goto L_0x0213
        L_0x019b:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zznm
            java.lang.Object r1 = com.google.android.gms.internal.drive.zzkm.zza((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0213
        L_0x01aa:
            r5 = r34
            goto L_0x023f
        L_0x01ae:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x023f
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01c9
            int r0 = com.google.android.gms.internal.drive.zziy.zzc(r12, r4, r13)
            goto L_0x01cd
        L_0x01c9:
            int r0 = com.google.android.gms.internal.drive.zziy.zzd(r12, r4, r13)
        L_0x01cd:
            java.lang.Object r1 = r13.zznm
            r10.putObject(r14, r2, r1)
            goto L_0x0213
        L_0x01d3:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != 0) goto L_0x023f
            int r0 = com.google.android.gms.internal.drive.zziy.zzb(r12, r4, r13)
            r33 = r0
            long r0 = r13.zznl
            r20 = 0
            int r4 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r4 == 0) goto L_0x01f2
            r0 = 1
            goto L_0x01f3
        L_0x01f2:
            r0 = 0
        L_0x01f3:
            com.google.android.gms.internal.drive.zznd.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r33
            goto L_0x0215
        L_0x01fb:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x023f
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0213:
            r6 = r6 | r22
        L_0x0215:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x0017
        L_0x021e:
            r5 = r34
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r19 = -1
            r12 = r32
            r13 = r36
            if (r0 != r1) goto L_0x023f
            long r17 = com.google.android.gms.internal.drive.zziy.zzb(r12, r4)
            r0 = r10
            r1 = r31
            r33 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x02b6
        L_0x023f:
            r33 = r7
            goto L_0x008e
        L_0x0243:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != 0) goto L_0x02c6
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r7, r13)
            int r1 = r13.zznk
            r10.putInt(r14, r2, r1)
            goto L_0x02b8
        L_0x025e:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != 0) goto L_0x02c6
            int r7 = com.google.android.gms.internal.drive.zziy.zzb(r12, r7, r13)
            long r4 = r13.zznl
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r33
            goto L_0x02c0
        L_0x0284:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != r1) goto L_0x02c6
            float r0 = com.google.android.gms.internal.drive.zziy.zzd(r12, r7)
            com.google.android.gms.internal.drive.zznd.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x02b8
        L_0x029e:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r19 = -1
            r12 = r32
            r13 = r36
            r7 = r4
            if (r0 != r1) goto L_0x02c6
            double r0 = com.google.android.gms.internal.drive.zziy.zzc(r12, r7)
            com.google.android.gms.internal.drive.zznd.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x02b6:
            int r0 = r7 + 8
        L_0x02b8:
            r6 = r6 | r22
            r7 = r33
        L_0x02bc:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c0:
            r13 = r34
            r11 = r35
            goto L_0x0017
        L_0x02c6:
            r2 = r7
            r19 = r9
            r27 = r10
            r25 = r11
            r7 = r33
            r9 = r8
            r8 = r35
            goto L_0x03e1
        L_0x02d4:
            r5 = r3
            r18 = r7
            r8 = r19
            r19 = -1
            r7 = r4
            r28 = r12
            r12 = r32
            r13 = r9
            r9 = r2
            r2 = r28
            r1 = 27
            if (r11 != r1) goto L_0x0339
            r1 = 2
            if (r0 != r1) goto L_0x032c
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.drive.zzkp r0 = (com.google.android.gms.internal.drive.zzkp) r0
            boolean r1 = r0.zzbo()
            if (r1 != 0) goto L_0x0309
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0300
            r1 = 10
            goto L_0x0302
        L_0x0300:
            int r1 = r1 << 1
        L_0x0302:
            com.google.android.gms.internal.drive.zzkp r0 = r0.zzr(r1)
            r10.putObject(r14, r2, r0)
        L_0x0309:
            r11 = r0
            com.google.android.gms.internal.drive.zzmf r0 = r15.zzap(r9)
            r1 = r8
            r2 = r32
            r3 = r7
            r4 = r34
            r7 = r5
            r5 = r11
            r22 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r35
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r18
            r6 = r22
            r13 = r34
            goto L_0x0017
        L_0x032c:
            r22 = r6
            r25 = r5
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            goto L_0x03b6
        L_0x0339:
            r22 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x0388
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r30
            r33 = r1
            r1 = r31
            r23 = r2
            r2 = r32
            r3 = r7
            r20 = r4
            r4 = r34
            r5 = r8
            r25 = r6
            r15 = r7
            r7 = r33
            r26 = r8
            r8 = r9
            r19 = r9
            r27 = r10
            r9 = r20
            r12 = r23
            r14 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.drive.zziz) r14)
            if (r0 != r15) goto L_0x036e
            goto L_0x03dd
        L_0x036e:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r7 = r18
            r2 = r19
            r6 = r22
            r1 = r25
            r3 = r26
            r10 = r27
            goto L_0x0017
        L_0x0388:
            r33 = r0
            r23 = r2
            r25 = r6
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c0
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x03b6
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r23
            r8 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.drive.zziz) r8)
            if (r0 != r15) goto L_0x036e
            goto L_0x03dd
        L_0x03b6:
            r8 = r35
            r2 = r15
        L_0x03b9:
            r7 = r18
            r6 = r22
            r9 = r26
            goto L_0x03e1
        L_0x03c0:
            r7 = r33
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r8 = r5
            r5 = r26
            r6 = r25
            r9 = r11
            r10 = r23
            r12 = r19
            r13 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.drive.zziz) r13)
            if (r0 != r15) goto L_0x0461
        L_0x03dd:
            r8 = r35
            r2 = r0
            goto L_0x03b9
        L_0x03e1:
            if (r9 != r8) goto L_0x03ef
            if (r8 != 0) goto L_0x03e6
            goto L_0x03ef
        L_0x03e6:
            r10 = r30
            r13 = r31
            r0 = r7
            r1 = -1
            r7 = r2
            goto L_0x048b
        L_0x03ef:
            r10 = r30
            boolean r0 = r10.zzui
            if (r0 == 0) goto L_0x043c
            r11 = r36
            com.google.android.gms.internal.drive.zzjx r0 = r11.zznn
            com.google.android.gms.internal.drive.zzjx r1 = com.google.android.gms.internal.drive.zzjx.zzci()
            if (r0 == r1) goto L_0x0439
            com.google.android.gms.internal.drive.zzlq r0 = r10.zzuh
            com.google.android.gms.internal.drive.zzjx r1 = r11.zznn
            r12 = r25
            com.google.android.gms.internal.drive.zzkk$zzd r0 = r1.zza(r0, r12)
            if (r0 != 0) goto L_0x0429
            com.google.android.gms.internal.drive.zzmy r4 = zzo(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.drive.zziy.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.drive.zzmy) r4, (com.google.android.gms.internal.drive.zziz) r5)
            r14 = r31
            r13 = r34
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r19
            r10 = r27
            r12 = r32
            goto L_0x045e
        L_0x0429:
            r13 = r31
            r0 = r13
            com.google.android.gms.internal.drive.zzkk$zzc r0 = (com.google.android.gms.internal.drive.zzkk.zzc) r0
            r0.zzdg()
            com.google.android.gms.internal.drive.zzkb<java.lang.Object> r0 = r0.zzrw
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0439:
            r13 = r31
            goto L_0x0440
        L_0x043c:
            r13 = r31
            r11 = r36
        L_0x0440:
            r12 = r25
            com.google.android.gms.internal.drive.zzmy r4 = zzo(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.drive.zziy.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.drive.zzmy) r4, (com.google.android.gms.internal.drive.zziz) r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r19
            r10 = r27
            r12 = r32
            r13 = r34
        L_0x045e:
            r11 = r8
            goto L_0x0017
        L_0x0461:
            r12 = r25
            r9 = r26
            r15 = r30
            r14 = r31
            r13 = r34
            r11 = r35
            r3 = r9
            r1 = r12
            r7 = r18
            r2 = r19
            r6 = r22
            r10 = r27
            r12 = r32
            r9 = r36
            goto L_0x0017
        L_0x047d:
            r22 = r6
            r18 = r7
            r27 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r7 = r0
            r9 = r3
            r0 = r18
            r1 = -1
        L_0x048b:
            if (r0 == r1) goto L_0x0493
            long r0 = (long) r0
            r2 = r27
            r2.putInt(r13, r0, r6)
        L_0x0493:
            r0 = 0
            int r1 = r10.zzun
            r5 = r0
            r11 = r1
        L_0x0498:
            int r0 = r10.zzuo
            if (r11 >= r0) goto L_0x04cc
            int[] r0 = r10.zzum
            r1 = r0[r11]
            com.google.android.gms.internal.drive.zzmx<?, ?> r6 = r10.zzur
            int[] r0 = r10.zzud
            r2 = r0[r1]
            int r0 = r10.zzas(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.drive.zznd.zzo(r13, r3)
            if (r0 != 0) goto L_0x04b4
            goto L_0x04c7
        L_0x04b4:
            com.google.android.gms.internal.drive.zzko r4 = r10.zzar(r1)
            if (r4 != 0) goto L_0x04bb
            goto L_0x04c7
        L_0x04bb:
            com.google.android.gms.internal.drive.zzll r3 = r10.zzut
            java.util.Map r3 = r3.zzh(r0)
            r0 = r30
            java.lang.Object r5 = r0.zza((int) r1, (int) r2, r3, (com.google.android.gms.internal.drive.zzko) r4, r5, r6)
        L_0x04c7:
            com.google.android.gms.internal.drive.zzmy r5 = (com.google.android.gms.internal.drive.zzmy) r5
            int r11 = r11 + 1
            goto L_0x0498
        L_0x04cc:
            if (r5 == 0) goto L_0x04d3
            com.google.android.gms.internal.drive.zzmx<?, ?> r0 = r10.zzur
            r0.zzf(r13, r5)
        L_0x04d3:
            if (r8 != 0) goto L_0x04df
            r0 = r34
            if (r7 != r0) goto L_0x04da
            goto L_0x04e5
        L_0x04da:
            com.google.android.gms.internal.drive.zzkq r0 = com.google.android.gms.internal.drive.zzkq.zzdm()
            throw r0
        L_0x04df:
            r0 = r34
            if (r7 > r0) goto L_0x04e6
            if (r9 != r8) goto L_0x04e6
        L_0x04e5:
            return r7
        L_0x04e6:
            com.google.android.gms.internal.drive.zzkq r0 = com.google.android.gms.internal.drive.zzkq.zzdm()
            goto L_0x04ec
        L_0x04eb:
            throw r0
        L_0x04ec:
            goto L_0x04eb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.drive.zziz):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013d, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015b, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020f, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022e, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.drive.zziz r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzuk
            if (r0 == 0) goto L_0x025d
            sun.misc.Unsafe r9 = zzuc
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0254
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.drive.zziy.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.drive.zziz) r11)
            int r3 = r11.zznk
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.zzp(r7, r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzau(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0231
        L_0x004b:
            int[] r0 = r15.zzud
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0167
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014e;
                case 1: goto L_0x013f;
                case 2: goto L_0x012d;
                case 3: goto L_0x012d;
                case 4: goto L_0x011f;
                case 5: goto L_0x010f;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00b0;
                case 10: goto L_0x00a3;
                case 11: goto L_0x011f;
                case 12: goto L_0x0094;
                case 13: goto L_0x00fe;
                case 14: goto L_0x010f;
                case 15: goto L_0x0081;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x01a4
        L_0x0066:
            if (r6 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.drive.zziy.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zznl
            long r21 = com.google.android.gms.internal.drive.zzjo.zzk(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013d
        L_0x0081:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r8, r11)
            int r1 = r11.zznk
            int r1 = com.google.android.gms.internal.drive.zzjo.zzw(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x0094:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r8, r11)
            int r1 = r11.zznk
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x00a3:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            int r0 = com.google.android.gms.internal.drive.zziy.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zznm
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00b0:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            com.google.android.gms.internal.drive.zzmf r0 = r15.zzap(r4)
            int r0 = com.google.android.gms.internal.drive.zziy.zza((com.google.android.gms.internal.drive.zzmf) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.drive.zziz) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r11.zznm
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00c7:
            java.lang.Object r5 = r11.zznm
            java.lang.Object r1 = com.google.android.gms.internal.drive.zzkm.zza((java.lang.Object) r1, (java.lang.Object) r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00d1:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00de
            int r0 = com.google.android.gms.internal.drive.zziy.zzc(r12, r8, r11)
            goto L_0x00e2
        L_0x00de:
            int r0 = com.google.android.gms.internal.drive.zziy.zzd(r12, r8, r11)
        L_0x00e2:
            java.lang.Object r1 = r11.zznm
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00e8:
            r2 = r1
            if (r6 != 0) goto L_0x01a4
            int r1 = com.google.android.gms.internal.drive.zziy.zzb(r12, r8, r11)
            long r5 = r11.zznl
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r0 = 0
        L_0x00f9:
            com.google.android.gms.internal.drive.zznd.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010b
        L_0x00fe:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010b:
            r2 = r4
            r1 = r7
            goto L_0x0251
        L_0x010f:
            r2 = r1
            if (r6 != r0) goto L_0x01a4
            long r5 = com.google.android.gms.internal.drive.zziy.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0159
        L_0x011f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r12, r8, r11)
            int r1 = r11.zznk
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x012d:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r6 = com.google.android.gms.internal.drive.zziy.zzb(r12, r8, r11)
            long r4 = r11.zznl
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013d:
            r0 = r6
            goto L_0x015b
        L_0x013f:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015f
            float r0 = com.google.android.gms.internal.drive.zziy.zzd(r12, r8)
            com.google.android.gms.internal.drive.zznd.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015b
        L_0x014e:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015f
            double r0 = com.google.android.gms.internal.drive.zziy.zzc(r12, r8)
            com.google.android.gms.internal.drive.zznd.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0159:
            int r0 = r8 + 8
        L_0x015b:
            r1 = r7
            r2 = r10
            goto L_0x0251
        L_0x015f:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ab
        L_0x0167:
            r0 = 27
            if (r3 != r0) goto L_0x01af
            if (r6 != r10) goto L_0x01a4
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.drive.zzkp r0 = (com.google.android.gms.internal.drive.zzkp) r0
            boolean r3 = r0.zzbo()
            if (r3 != 0) goto L_0x018b
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0182
            r3 = 10
            goto L_0x0184
        L_0x0182:
            int r3 = r3 << 1
        L_0x0184:
            com.google.android.gms.internal.drive.zzkp r0 = r0.zzr(r3)
            r9.putObject(r14, r1, r0)
        L_0x018b:
            r5 = r0
            com.google.android.gms.internal.drive.zzmf r0 = r15.zzap(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.drive.zziy.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0251
        L_0x01a4:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ab:
            r26 = -1
            goto L_0x0212
        L_0x01af:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e5
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.drive.zziz) r14)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x01e5:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0214
            r7 = r30
            if (r7 != r10) goto L_0x0212
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.drive.zziz) r8)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x0212:
            r2 = r15
            goto L_0x0231
        L_0x0214:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.drive.zziz) r13)
            if (r0 != r15) goto L_0x0241
        L_0x0230:
            r2 = r0
        L_0x0231:
            com.google.android.gms.internal.drive.zzmy r4 = zzo(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.drive.zziy.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.drive.zzmy) r4, (com.google.android.gms.internal.drive.zziz) r5)
        L_0x0241:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0251:
            r10 = -1
            goto L_0x0017
        L_0x0254:
            r4 = r13
            if (r0 != r4) goto L_0x0258
            return
        L_0x0258:
            com.google.android.gms.internal.drive.zzkq r0 = com.google.android.gms.internal.drive.zzkq.zzdm()
            throw r0
        L_0x025d:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.drive.zziz) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlu.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.drive.zziz):void");
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzko zzko, UB ub, zzmx<UT, UB> zzmx) {
        zzlj<?, ?> zzm = this.zzut.zzm(zzaq(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzko.zzan(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmx.zzez();
                }
                zzjk zzu = zzjc.zzu(zzli.zza(zzm, next.getKey(), next.getValue()));
                try {
                    zzli.zza(zzu.zzby(), zzm, next.getKey(), next.getValue());
                    zzmx.zza(ub, i2, zzu.zzbx());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public static boolean zza(Object obj, int i, zzmf zzmf) {
        return zzmf.zzp(zznd.zzo(obj, (long) (i & 1048575)));
    }

    public static void zza(int i, Object obj, zzns zzns) throws IOException {
        if (obj instanceof String) {
            zzns.zza(i, (String) obj);
        } else {
            zzns.zza(i, (zzjc) obj);
        }
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzuk) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzuk) {
            int zzas = zzas(i);
            long j = (long) (zzas & 1048575);
            switch ((zzas & 267386880) >>> 20) {
                case 0:
                    return zznd.zzn(t, j) != RoundRectDrawableWithShadow.COS_45;
                case 1:
                    return zznd.zzm(t, j) != 0.0f;
                case 2:
                    return zznd.zzk(t, j) != 0;
                case 3:
                    return zznd.zzk(t, j) != 0;
                case 4:
                    return zznd.zzj(t, j) != 0;
                case 5:
                    return zznd.zzk(t, j) != 0;
                case 6:
                    return zznd.zzj(t, j) != 0;
                case 7:
                    return zznd.zzl(t, j);
                case 8:
                    Object zzo = zznd.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzjc) {
                        return !zzjc.zznq.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zznd.zzo(t, j) != null;
                case 10:
                    return !zzjc.zznq.equals(zznd.zzo(t, j));
                case 11:
                    return zznd.zzj(t, j) != 0;
                case 12:
                    return zznd.zzj(t, j) != 0;
                case 13:
                    return zznd.zzj(t, j) != 0;
                case 14:
                    return zznd.zzk(t, j) != 0;
                case 15:
                    return zznd.zzj(t, j) != 0;
                case 16:
                    return zznd.zzk(t, j) != 0;
                case 17:
                    return zznd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzat = zzat(i);
            return (zznd.zzj(t, (long) (zzat & 1048575)) & (1 << (zzat >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zznd.zzj(t, (long) (zzat(i2) & 1048575)) == i;
    }
}
