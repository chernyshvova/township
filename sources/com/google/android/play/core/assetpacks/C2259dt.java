package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2314cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.google.android.play.core.assetpacks.dt */
public final class C2259dt {

    /* renamed from: a */
    public static final Pattern f3179a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    /* renamed from: a */
    public static List<File> m2946a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(C2258ds.f3178a);
        if (listFiles == null) {
            fileArr = new File[0];
        } else {
            File[] fileArr2 = new File[r2];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > listFiles.length || fileArr2[parseInt] != null) {
                    throw new C2214bv("Metadata folder ordering corrupt.");
                }
                fileArr2[parseInt] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    C2263dx a = new C2206bm(fileInputStream).mo33204a();
                    if (a.f3187a != null) {
                        File file5 = new File(file, a.f3187a);
                        if (file5.exists()) {
                            arrayList.add(file5);
                            fileInputStream.close();
                        } else {
                            throw new C2214bv(String.format("Missing asset file %s during slice reconstruction.", new Object[]{file5.getCanonicalPath()}));
                        }
                    } else {
                        throw new C2214bv("Metadata files corrupt. Could not read local file header.");
                    }
                } catch (Throwable th) {
                    C2314cj.f3259a.mo33290a(th, th);
                }
            }
        }
        return arrayList;
        throw th;
    }
}
