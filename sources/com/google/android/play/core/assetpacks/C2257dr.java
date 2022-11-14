package com.google.android.play.core.assetpacks;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2314cj;
import com.helpshift.common.domain.network.NetworkConstants;
import com.swrve.sdk.SwrveImp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* renamed from: com.google.android.play.core.assetpacks.dr */
public final class C2257dr {

    /* renamed from: a */
    public static final C2292ag f3170a = new C2292ag("SliceMetadataManager");

    /* renamed from: b */
    public final byte[] f3171b = new byte[8192];

    /* renamed from: c */
    public final C2198bb f3172c;

    /* renamed from: d */
    public final String f3173d;

    /* renamed from: e */
    public final int f3174e;

    /* renamed from: f */
    public final long f3175f;

    /* renamed from: g */
    public final String f3176g;

    /* renamed from: h */
    public int f3177h;

    public C2257dr(C2198bb bbVar, String str, int i, long j, String str2) {
        this.f3172c = bbVar;
        this.f3173d = str;
        this.f3174e = i;
        this.f3175f = j;
        this.f3176g = str2;
        this.f3177h = -1;
    }

    /* renamed from: a */
    public final C2256dq mo33242a() throws IOException {
        File c = this.f3172c.mo33180c(this.f3173d, this.f3174e, this.f3175f, this.f3176g);
        if (c.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(c);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new C2214bv("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f3177h = Integer.parseInt(properties.getProperty("metadataFileCounter", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                    return new C2256dq(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e) {
                    throw new C2214bv("Slice checkpoint file corrupt.", (Exception) e);
                }
            } catch (Throwable th) {
                C2314cj.f3259a.mo33290a(th, th);
            }
        } else {
            throw new C2214bv("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* renamed from: b */
    public final File mo33250b() {
        return new File(mo33255e(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f3177h)}));
    }

    /* renamed from: b */
    public final void mo33251b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f3177h));
        FileOutputStream fileOutputStream = new FileOutputStream(mo33256f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: c */
    public final int mo33253c() throws IOException {
        File c = this.f3172c.mo33180c(this.f3173d, this.f3174e, this.f3175f, this.f3176g);
        if (!c.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(c);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C2214bv("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: d */
    public final boolean mo33254d() {
        FileInputStream fileInputStream;
        File c = this.f3172c.mo33180c(this.f3173d, this.f3174e, this.f3175f, this.f3176g);
        if (!c.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(c);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") != null) {
                return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
            }
            f3170a.mo33278a(6, "Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
            return false;
        } catch (IOException e) {
            f3170a.mo33278a(6, "Could not read checkpoint while checking if extraction finished. %s", new Object[]{e});
            return false;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: e */
    public final File mo33255e() {
        File f = this.f3172c.mo33184f(this.f3173d, this.f3174e, this.f3175f, this.f3176g);
        if (!f.exists()) {
            f.mkdirs();
        }
        return f;
    }

    /* renamed from: f */
    public final File mo33256f() throws IOException {
        File c = this.f3172c.mo33180c(this.f3173d, this.f3174e, this.f3175f, this.f3176g);
        c.getParentFile().mkdirs();
        c.createNewFile();
        return c;
    }

    /* renamed from: a */
    public final void mo33243a(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", NetworkConstants.apiVersion);
        properties.put("fileOffset", String.valueOf(mo33250b().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f3177h));
        FileOutputStream fileOutputStream = new FileOutputStream(mo33256f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: b */
    public final void mo33252b(byte[] bArr, int i) throws IOException {
        this.f3177h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo33250b());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: a */
    public final void mo33244a(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo33250b(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: a */
    public final void mo33245a(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo33250b(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.f3171b);
                if (read > 0) {
                    randomAccessFile.write(this.f3171b, 0, read);
                }
            } while (read == this.f3171b.length);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: a */
    public final void mo33246a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f3177h));
        FileOutputStream fileOutputStream = new FileOutputStream(mo33256f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: a */
    public final void mo33247a(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        this.f3177h++;
        try {
            fileOutputStream = new FileOutputStream(new File(mo33255e(), String.format("%s-LFH.dat", new Object[]{Integer.valueOf(this.f3177h)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new C2214bv("Could not write metadata file.", (Exception) e);
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }

    /* renamed from: a */
    public final void mo33248a(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", SwrveImp.CAMPAIGN_RESPONSE_VERSION);
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f3177h));
        FileOutputStream fileOutputStream = new FileOutputStream(mo33256f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            C2198bb bbVar = this.f3172c;
            String str = this.f3173d;
            int i2 = this.f3174e;
            long j = this.f3175f;
            String str2 = this.f3176g;
            if (bbVar != null) {
                File file = new File(bbVar.mo33184f(str, i2, j, str2), "checkpoint_ext.dat");
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.close();
                    return;
                } catch (Throwable th) {
                    C2314cj.f3259a.mo33290a(th, th);
                }
            } else {
                throw null;
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            C2314cj.f3259a.mo33290a(th, th2);
        }
    }

    /* renamed from: a */
    public final void mo33249a(byte[] bArr, InputStream inputStream) throws IOException {
        this.f3177h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo33250b());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.f3171b);
            while (read > 0) {
                fileOutputStream.write(this.f3171b, 0, read);
                read = inputStream.read(this.f3171b);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C2314cj.f3259a.mo33290a(th, th);
        }
        throw th;
    }
}
