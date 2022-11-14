package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2306cb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.google.android.play.core.assetpacks.be */
public final class C2201be extends C2306cb {

    /* renamed from: a */
    public final File f2955a;

    /* renamed from: b */
    public final File f2956b;

    /* renamed from: c */
    public final NavigableMap<Long, File> f2957c = new TreeMap();

    public C2201be(File file, File file2) throws IOException {
        this.f2955a = file;
        this.f2956b = file2;
        ArrayList arrayList = (ArrayList) C2259dt.m2946a(this.f2955a, this.f2956b);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            long j = 0;
            while (it.hasNext()) {
                File file3 = (File) it.next();
                this.f2957c.put(Long.valueOf(j), file3);
                j += file3.length();
            }
            return;
        }
        throw new C2214bv(String.format("Virtualized slice archive empty for %s, %s", new Object[]{this.f2955a, this.f2956b}));
    }

    /* renamed from: a */
    public final long mo33192a() {
        Map.Entry<Long, File> lastEntry = this.f2957c.lastEntry();
        return lastEntry.getValue().length() + lastEntry.getKey().longValue();
    }

    /* renamed from: a */
    public final InputStream mo33193a(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new C2214bv(String.format("Invalid input parameters %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j3 = j + j2;
        if (j3 <= mo33192a()) {
            Long floorKey = this.f2957c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.f2957c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new C2200bd(mo33194a(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(mo33194a(j, floorKey));
            Collection values = this.f2957c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new C2242dc(Collections.enumeration(values)));
            }
            arrayList.add(new C2200bd(new FileInputStream((File) this.f2957c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new C2214bv(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", new Object[]{Long.valueOf(mo33192a()), Long.valueOf(j3)}));
    }

    /* renamed from: a */
    public final InputStream mo33194a(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.f2957c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new C2214bv(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", new Object[]{l}));
    }

    public final void close() {
    }
}
