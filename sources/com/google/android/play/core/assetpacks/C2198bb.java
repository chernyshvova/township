package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2314cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.assetpacks.bb */
public final class C2198bb {

    /* renamed from: a */
    public static final C2292ag f2948a = new C2292ag("AssetPackStorage");

    /* renamed from: d */
    public final Context f2949d;

    /* renamed from: e */
    public final C2251dl f2950e;

    static {
        TimeUnit.DAYS.toMillis(14);
        TimeUnit.DAYS.toMillis(28);
    }

    public C2198bb(Context context, C2251dl dlVar) {
        this.f2949d = context;
        this.f2950e = dlVar;
    }

    /* renamed from: a */
    public static void m2856a(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long b = m2857b(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(b)) && !file2.getName().equals("stale.tmp")) {
                    m2858c(file2);
                }
            }
        }
    }

    /* renamed from: b */
    public static long m2857b(File file) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e) {
            f2948a.mo33279a((Throwable) e, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    /* renamed from: c */
    public static boolean m2858c(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File c : listFiles) {
                z &= m2858c(c);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* renamed from: a */
    public final File mo33174a(String str, int i, long j) {
        return new File(new File(mo33185g(str), String.valueOf(i)), String.valueOf(j));
    }

    /* renamed from: a */
    public final File mo33175a(String str, int i, long j, String str2) {
        return new File(new File(new File(mo33187h(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0095 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0096  */
    @androidx.annotation.Nullable
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.AssetPackLocation mo33177b(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            java.io.File r0 = new java.io.File
            java.io.File r1 = r8.mo33188i()
            r0.<init>(r1, r9)
            boolean r1 = r0.exists()
            r2 = 3
            r3 = 6
            r4 = 1
            r5 = 0
            r6 = 0
            if (r1 != 0) goto L_0x0022
            com.google.android.play.core.internal.ag r0 = f2948a
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r5] = r9
            java.lang.String r9 = "Pack not found with pack name: %s"
            r0.mo33278a((int) r2, (java.lang.String) r9, (java.lang.Object[]) r1)
        L_0x001f:
            r9 = r6
            goto L_0x0093
        L_0x0022:
            java.io.File r1 = new java.io.File
            com.google.android.play.core.assetpacks.dl r7 = r8.f2950e
            int r7 = r7.mo33237a()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r1.<init>(r0, r7)
            boolean r0 = r1.exists()
            r7 = 2
            if (r0 != 0) goto L_0x0050
            com.google.android.play.core.internal.ag r0 = f2948a
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r1[r5] = r9
            com.google.android.play.core.assetpacks.dl r9 = r8.f2950e
            int r9 = r9.mo33237a()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1[r4] = r9
            java.lang.String r9 = "Pack not found with pack name: %s app version: %s"
            r0.mo33278a((int) r2, (java.lang.String) r9, (java.lang.Object[]) r1)
            goto L_0x001f
        L_0x0050:
            java.io.File[] r0 = r1.listFiles()
            if (r0 == 0) goto L_0x007b
            int r1 = r0.length
            if (r1 != 0) goto L_0x005a
            goto L_0x007b
        L_0x005a:
            if (r1 <= r4) goto L_0x0074
            com.google.android.play.core.internal.ag r0 = f2948a
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r1[r5] = r9
            com.google.android.play.core.assetpacks.dl r9 = r8.f2950e
            int r9 = r9.mo33237a()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1[r4] = r9
            java.lang.String r9 = "Multiple pack versions found for pack name: %s app version: %s"
            r0.mo33278a((int) r3, (java.lang.String) r9, (java.lang.Object[]) r1)
            goto L_0x001f
        L_0x0074:
            r9 = r0[r5]
            java.lang.String r9 = r9.getCanonicalPath()
            goto L_0x0093
        L_0x007b:
            com.google.android.play.core.internal.ag r0 = f2948a
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r1[r5] = r9
            com.google.android.play.core.assetpacks.dl r9 = r8.f2950e
            int r9 = r9.mo33237a()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1[r4] = r9
            java.lang.String r9 = "No pack version found for pack name: %s app version: %s"
            r0.mo33278a((int) r2, (java.lang.String) r9, (java.lang.Object[]) r1)
            goto L_0x001f
        L_0x0093:
            if (r9 != 0) goto L_0x0096
            return r6
        L_0x0096:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "assets"
            r0.<init>(r9, r1)
            boolean r1 = r0.isDirectory()
            if (r1 != 0) goto L_0x00af
            com.google.android.play.core.internal.ag r9 = f2948a
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r5] = r0
            java.lang.String r0 = "Failed to find assets directory: %s"
            r9.mo33278a((int) r3, (java.lang.String) r0, (java.lang.Object[]) r1)
            return r6
        L_0x00af:
            java.lang.String r0 = r0.getCanonicalPath()
            com.google.android.play.core.assetpacks.bg r1 = new com.google.android.play.core.assetpacks.bg
            r1.<init>(r5, r9, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2198bb.mo33177b(java.lang.String):com.google.android.play.core.assetpacks.AssetPackLocation");
    }

    /* renamed from: b */
    public final File mo33178b(String str, int i, long j, String str2) {
        return new File(new File(new File(mo33187h(str, i, j), "_slices"), "_verified"), str2);
    }

    /* renamed from: c */
    public final File mo33179c(String str, int i, long j) {
        return new File(mo33187h(str, i, j), "_packs");
    }

    /* renamed from: c */
    public final File mo33180c(String str, int i, long j, String str2) {
        return new File(mo33184f(str, i, j, str2), "checkpoint.dat");
    }

    /* renamed from: d */
    public final int mo33181d(String str, int i, long j) throws IOException {
        File file = new File(mo33179c(str, i, j), "merge.tmp");
        if (!file.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e) {
                    throw new C2214bv("Merge checkpoint file corrupt.", (Exception) e);
                }
            } else {
                throw new C2214bv("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: e */
    public final File mo33182e(String str, int i, long j, String str2) {
        return new File(mo33184f(str, i, j, str2), "slice.zip");
    }

    /* renamed from: f */
    public final long mo33183f(String str) {
        return m2857b(new File(mo33185g(str), String.valueOf((int) m2857b(mo33185g(str)))));
    }

    /* renamed from: g */
    public final File mo33185g(String str) {
        return new File(mo33188i(), str);
    }

    /* renamed from: g */
    public final List<File> mo33186g() {
        ArrayList arrayList = new ArrayList();
        try {
            if (mo33188i().exists()) {
                if (mo33188i().listFiles() != null) {
                    for (File file : mo33188i().listFiles()) {
                        if (!file.getCanonicalPath().equals(new File(mo33188i(), "_tmp").getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e) {
            f2948a.mo33278a(6, "Could not process directory while scanning installed packs. %s", new Object[]{e});
        }
    }

    /* renamed from: h */
    public final File mo33187h(String str, int i, long j) {
        return new File(new File(new File(new File(mo33188i(), "_tmp"), str), String.valueOf(i)), String.valueOf(j));
    }

    /* renamed from: i */
    public final File mo33188i() {
        return new File(this.f2949d.getFilesDir(), "assetpacks");
    }

    /* renamed from: a */
    public final void mo33176a(String str, int i, long j, int i2) throws IOException {
        File file = new File(mo33179c(str, i, j), "merge.tmp");
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* renamed from: f */
    public final File mo33184f(String str, int i, long j, String str2) {
        return new File(new File(new File(mo33187h(str, i, j), "_slices"), "_metadata"), str2);
    }
}
