package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.security.OidcSecurityUtil;
import com.helpshift.analytics.AnalyticsEventKey;
import com.playrix.gplay.billing.Security;
import com.vungle.warren.VungleSettings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzi {
    public static X509Certificate[][] zza(String str) throws zzf, SecurityException, IOException {
        ByteBuffer byteBuffer;
        int limit;
        int position;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> zza = zzj.zza(randomAccessFile);
            if (zza != null) {
                ByteBuffer byteBuffer2 = (ByteBuffer) zza.first;
                long longValue = ((Long) zza.second).longValue();
                long j = -20 + longValue;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new zzf("ZIP64 APK not supported");
                    }
                }
                long zzb = zzj.zzb(byteBuffer2);
                if (zzb >= longValue) {
                    StringBuilder sb = new StringBuilder(122);
                    sb.append("ZIP Central Directory offset out of range: ");
                    sb.append(zzb);
                    sb.append(". ZIP End of Central Directory offset: ");
                    sb.append(longValue);
                    throw new zzf(sb.toString());
                } else if (zzj.zzd(byteBuffer2) + zzb != longValue) {
                    throw new zzf("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (zzb >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(zzb - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    int i = 8;
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        int i2 = 0;
                        long j2 = allocate.getLong(0);
                        if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                            StringBuilder sb2 = new StringBuilder(57);
                            sb2.append("APK Signing Block size out of range: ");
                            sb2.append(j2);
                            throw new zzf(sb2.toString());
                        }
                        int i3 = (int) (8 + j2);
                        long j3 = zzb - ((long) i3);
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i3);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j3));
                                byteBuffer = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                                    int capacity = byteBuffer.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer.capacity();
                                        if (capacity <= byteBuffer.capacity()) {
                                            limit = byteBuffer.limit();
                                            position = byteBuffer.position();
                                            byteBuffer.position(0);
                                            byteBuffer.limit(capacity);
                                            byteBuffer.position(8);
                                            ByteBuffer slice = byteBuffer.slice();
                                            slice.order(byteBuffer.order());
                                            byteBuffer.position(0);
                                            byteBuffer.limit(limit);
                                            byteBuffer.position(position);
                                            while (slice.hasRemaining()) {
                                                i2++;
                                                if (slice.remaining() >= i) {
                                                    long j5 = slice.getLong();
                                                    if (j5 < 4 || j5 > 2147483647L) {
                                                        StringBuilder sb3 = new StringBuilder(76);
                                                        sb3.append("APK Signing Block entry #");
                                                        sb3.append(i2);
                                                        sb3.append(" size out of range: ");
                                                        sb3.append(j5);
                                                        throw new zzf(sb3.toString());
                                                    }
                                                    int i4 = (int) j5;
                                                    int position2 = slice.position() + i4;
                                                    if (i4 > slice.remaining()) {
                                                        int remaining = slice.remaining();
                                                        StringBuilder sb4 = new StringBuilder(91);
                                                        sb4.append("APK Signing Block entry #");
                                                        sb4.append(i2);
                                                        sb4.append(" size out of range: ");
                                                        sb4.append(i4);
                                                        sb4.append(", available: ");
                                                        sb4.append(remaining);
                                                        throw new zzf(sb4.toString());
                                                    } else if (slice.getInt() == 1896449818) {
                                                        X509Certificate[][] zzb2 = zzb(randomAccessFile.getChannel(), new zze(zzi(slice, i4 - 4), longValue2, zzb, longValue, byteBuffer2, (zza) null));
                                                        randomAccessFile.close();
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException unused) {
                                                        }
                                                        return zzb2;
                                                    } else {
                                                        slice.position(position2);
                                                        i = 8;
                                                    }
                                                } else {
                                                    StringBuilder sb5 = new StringBuilder(70);
                                                    sb5.append("Insufficient data to read size of APK Signing Block entry #");
                                                    sb5.append(i2);
                                                    throw new zzf(sb5.toString());
                                                }
                                            }
                                            throw new zzf("No APK Signature Scheme v2 block in APK Signing Block");
                                        }
                                        StringBuilder sb6 = new StringBuilder(41);
                                        sb6.append("end > capacity: ");
                                        sb6.append(capacity);
                                        sb6.append(" > ");
                                        sb6.append(capacity2);
                                        throw new IllegalArgumentException(sb6.toString());
                                    }
                                    StringBuilder sb7 = new StringBuilder(38);
                                    sb7.append("end < start: ");
                                    sb7.append(capacity);
                                    sb7.append(" < ");
                                    sb7.append(8);
                                    throw new IllegalArgumentException(sb7.toString());
                                }
                                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                            }
                            StringBuilder sb8 = new StringBuilder(103);
                            sb8.append("APK Signing Block sizes in header and footer do not match: ");
                            sb8.append(j4);
                            sb8.append(" vs ");
                            sb8.append(j2);
                            throw new zzf(sb8.toString());
                        }
                        StringBuilder sb9 = new StringBuilder(59);
                        sb9.append("APK Signing Block offset out of range: ");
                        sb9.append(j3);
                        throw new zzf(sb9.toString());
                    }
                    throw new zzf("No APK Signing Block before ZIP Central Directory");
                } else {
                    StringBuilder sb10 = new StringBuilder(87);
                    sb10.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb10.append(zzb);
                    throw new zzf(sb10.toString());
                }
            } else {
                long length = randomAccessFile.length();
                StringBuilder sb11 = new StringBuilder(102);
                sb11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb11.append(length);
                sb11.append(" bytes");
                throw new zzf(sb11.toString());
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    public static X509Certificate[][] zzb(FileChannel fileChannel, zze zze) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zzj = zzj(zze.zza);
                int i = 0;
                while (zzj.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(zzc(zzj(zzj), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException(GeneratedOutlineSupport.outline10(48, "Failed to parse/verify signer #", i, " block"), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    zzd(hashMap, fileChannel, zze.zzb, zze.zzc, zze.zzd, zze.zze);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    public static X509Certificate[] zzc(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        Pair pair;
        String str2;
        String str3;
        ByteBuffer zzj = zzj(byteBuffer);
        ByteBuffer zzj2 = zzj(byteBuffer);
        byte[] zzk = zzk(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        int i = -1;
        int i2 = 0;
        byte[] bArr2 = null;
        while (zzj2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer zzj3 = zzj(zzj2);
                if (zzj3.remaining() >= 8) {
                    int i3 = zzj3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (!(i3 == 513 || i3 == 514 || i3 == 769)) {
                        switch (i3) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                continue;
                        }
                    }
                    if (i != -1) {
                        int zzf = zzf(i3);
                        int zzf2 = zzf(i);
                        if (zzf != 1) {
                            if (zzf2 != 1) {
                            }
                        }
                    }
                    bArr2 = zzk(zzj3);
                    i = i3;
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException(GeneratedOutlineSupport.outline9(45, "Failed to parse signature record #", i2), e);
            }
        }
        if (i != -1) {
            if (i == 513 || i == 514) {
                str = "EC";
            } else if (i != 769) {
                switch (i) {
                    case 257:
                    case 258:
                    case 259:
                    case 260:
                        str = Security.KEY_FACTORY_ALGORITHM;
                        break;
                    default:
                        String valueOf = String.valueOf(Long.toHexString((long) i));
                        if (valueOf.length() != 0) {
                            str3 = "Unknown signature algorithm: 0x".concat(valueOf);
                        } else {
                            str3 = new String("Unknown signature algorithm: 0x");
                        }
                        throw new IllegalArgumentException(str3);
                }
            } else {
                str = "DSA";
            }
            if (i == 513) {
                pair = Pair.create("SHA256withECDSA", (Object) null);
            } else if (i == 514) {
                pair = Pair.create("SHA512withECDSA", (Object) null);
            } else if (i != 769) {
                switch (i) {
                    case 257:
                        pair = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(Utility.HASH_ALGORITHM_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                        break;
                    case 258:
                        pair = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                        break;
                    case 259:
                        pair = Pair.create(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256, (Object) null);
                        break;
                    case 260:
                        pair = Pair.create("SHA512withRSA", (Object) null);
                        break;
                    default:
                        String valueOf2 = String.valueOf(Long.toHexString((long) i));
                        if (valueOf2.length() != 0) {
                            str2 = "Unknown signature algorithm: 0x".concat(valueOf2);
                        } else {
                            str2 = new String("Unknown signature algorithm: 0x");
                        }
                        throw new IllegalArgumentException(str2);
                }
            } else {
                pair = Pair.create("SHA256withDSA", (Object) null);
            }
            String str4 = (String) pair.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(zzk));
                Signature instance = Signature.getInstance(str4);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(zzj);
                if (instance.verify(bArr2)) {
                    zzj.clear();
                    ByteBuffer zzj4 = zzj(zzj);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (zzj4.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer zzj5 = zzj(zzj4);
                            if (zzj5.remaining() >= 8) {
                                int i5 = zzj5.getInt();
                                arrayList2.add(Integer.valueOf(i5));
                                if (i5 == i) {
                                    bArr = zzk(zzj5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException(GeneratedOutlineSupport.outline9(42, "Failed to parse digest record #", i4), e2);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int zzf3 = zzf(i);
                        byte[] put = map.put(Integer.valueOf(zzf3), bArr);
                        if (put == null || MessageDigest.isEqual(put, bArr)) {
                            ByteBuffer zzj6 = zzj(zzj);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (zzj6.hasRemaining()) {
                                i6++;
                                byte[] zzk2 = zzk(zzj6);
                                try {
                                    arrayList3.add(new zzg((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(zzk2)), zzk2));
                                } catch (CertificateException e3) {
                                    throw new SecurityException(GeneratedOutlineSupport.outline9(41, "Failed to decode certificate #", i6), e3);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(zzk, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(zzg(zzf3).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(String.valueOf(str4).concat(" signature did not verify"));
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                throw new SecurityException(GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str4).length() + 27), "Failed to verify ", str4, " signature"), e4);
            }
        } else if (i2 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    public static void zzd(Map<Integer, byte[]> map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            zzd zzd = new zzd(fileChannel, 0, j);
            zzd zzd2 = new zzd(fileChannel, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j4 = j;
            zzj.zzc(duplicate, j);
            zzb zzb = new zzb(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            int i2 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i2] = intValue.intValue();
                i2++;
            }
            try {
                byte[][] zze = zze(iArr, new zzc[]{zzd, zzd2, zzb});
                while (i < size) {
                    int i3 = iArr[i];
                    Map<Integer, byte[]> map2 = map;
                    if (MessageDigest.isEqual(map.get(Integer.valueOf(i3)), zze[i])) {
                        i++;
                    } else {
                        throw new SecurityException(zzg(i3).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    public static byte[][] zze(int[] iArr, zzc[] zzcArr) throws DigestException {
        long j;
        int i;
        int length;
        int[] iArr2 = iArr;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        while (true) {
            j = VungleSettings.MEGABYTE;
            if (i3 >= 3) {
                break;
            }
            j3 += (zzcArr[i3].zza() + 1048575) / VungleSettings.MEGABYTE;
            i3++;
        }
        if (j3 < 2097151) {
            int i4 = (int) j3;
            byte[][] bArr = new byte[iArr2.length][];
            int i5 = 0;
            while (true) {
                length = iArr2.length;
                if (i5 >= length) {
                    break;
                }
                byte[] bArr2 = new byte[((zzh(iArr2[i5]) * i4) + 5)];
                bArr2[0] = 90;
                zzl(i4, bArr2, 1);
                bArr[i5] = bArr2;
                i5++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i6 = 0;
            while (i6 < iArr2.length) {
                String zzg = zzg(iArr2[i6]);
                try {
                    messageDigestArr[i6] = MessageDigest.getInstance(zzg);
                    i6++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(zzg.concat(" digest not supported"), e);
                }
            }
            int i7 = 0;
            int i8 = 0;
            for (i = 3; i7 < i; i = 3) {
                zzc zzc = zzcArr[i7];
                int i9 = i7;
                int i10 = i8;
                long zza = zzc.zza();
                long j4 = j;
                long j5 = j2;
                while (zza > j2) {
                    int min = (int) Math.min(zza, j4);
                    zzl(min, bArr3, 1);
                    for (int i11 = 0; i11 < length; i11++) {
                        messageDigestArr[i11].update(bArr3);
                    }
                    try {
                        zzc.zzb(messageDigestArr, j5, min);
                        int i12 = 0;
                        while (i12 < iArr2.length) {
                            int i13 = iArr2[i12];
                            byte[] bArr4 = bArr[i12];
                            int zzh = zzh(i13);
                            byte[] bArr5 = bArr3;
                            MessageDigest messageDigest = messageDigestArr[i12];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr4, (i10 * zzh) + 5, zzh);
                            if (digest == zzh) {
                                i12++;
                                bArr3 = bArr5;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        byte[] bArr6 = bArr3;
                        MessageDigest[] messageDigestArr3 = messageDigestArr;
                        long j6 = (long) min;
                        j5 += j6;
                        zza -= j6;
                        i10++;
                        j2 = 0;
                        j4 = VungleSettings.MEGABYTE;
                    } catch (IOException e2) {
                        throw new DigestException(GeneratedOutlineSupport.outline11(59, "Failed to digest chunk #", i10, " of section #", i2), e2);
                    }
                }
                byte[] bArr7 = bArr3;
                MessageDigest[] messageDigestArr4 = messageDigestArr;
                i8 = i10;
                i2++;
                i7 = i9 + 1;
                j2 = 0;
                j = VungleSettings.MEGABYTE;
            }
            byte[][] bArr8 = new byte[iArr2.length][];
            int i14 = 0;
            while (i14 < iArr2.length) {
                int i15 = iArr2[i14];
                byte[] bArr9 = bArr[i14];
                String zzg2 = zzg(i15);
                try {
                    bArr8[i14] = MessageDigest.getInstance(zzg2).digest(bArr9);
                    i14++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(zzg2.concat(" digest not supported"), e3);
                }
            }
            return bArr8;
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Too many chunks: ");
        sb2.append(j3);
        throw new DigestException(sb2.toString());
    }

    public static int zzf(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    public static String zzg(int i) {
        if (i == 1) {
            return Utility.HASH_ALGORITHM_SHA256;
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(44, "Unknown content digest algorthm: ", i));
    }

    public static int zzh(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(44, "Unknown content digest algorthm: ", i));
    }

    public static ByteBuffer zzi(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(17, "size: ", i));
        }
    }

    public static ByteBuffer zzj(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return zzi(byteBuffer, i);
            } else {
                throw new IOException(GeneratedOutlineSupport.outline11(101, "Length-prefixed field longer than remaining buffer. Field length: ", i, ", remaining: ", byteBuffer.remaining()));
            }
        } else {
            throw new IOException(GeneratedOutlineSupport.outline9(93, "Remaining buffer too short to contain length of length-prefixed field. Remaining: ", byteBuffer.remaining()));
        }
    }

    public static byte[] zzk(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            throw new IOException(GeneratedOutlineSupport.outline11(90, "Underflow while reading length-prefixed value. Length: ", i, ", available: ", byteBuffer.remaining()));
        }
    }

    public static void zzl(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }
}
