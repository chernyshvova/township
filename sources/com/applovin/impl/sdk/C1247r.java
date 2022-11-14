package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1102e;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.vungle.warren.VungleSettings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.r */
public class C1247r {

    /* renamed from: a */
    public final String f2404a = "FileManager";

    /* renamed from: b */
    public final C1188m f2405b;

    /* renamed from: c */
    public final C1314v f2406c;

    /* renamed from: d */
    public final Object f2407d = new Object();

    public C1247r(C1188m mVar) {
        this.f2405b = mVar;
        this.f2406c = mVar.mo10922B();
    }

    /* renamed from: a */
    private long m2440a() {
        long longValue = ((Long) this.f2405b.mo10946a(C1085b.f1638bq)).longValue();
        if (longValue < 0 || !m2444b()) {
            return -1;
        }
        return longValue;
    }

    /* renamed from: a */
    private long m2441a(long j) {
        return j / VungleSettings.MEGABYTE;
    }

    /* renamed from: a */
    private void m2442a(long j, Context context) {
        C1314v vVar;
        String str;
        if (m2444b()) {
            long intValue = (long) ((Integer) this.f2405b.mo10946a(C1085b.f1639br)).intValue();
            if (intValue == -1) {
                vVar = this.f2406c;
                str = "Cache has no maximum size set; skipping drop...";
            } else {
                int i = (m2441a(j) > intValue ? 1 : (m2441a(j) == intValue ? 0 : -1));
                vVar = this.f2406c;
                if (i > 0) {
                    vVar.mo11372b("FileManager", "Cache has exceeded maximum size; dropping...");
                    for (File b : m2448d(context)) {
                        m2446b(b);
                    }
                    this.f2405b.mo10939T().mo10757a(C1103f.f1928f);
                    return;
                }
                str = "Cache is present but under size limit; not dropping...";
            }
            vVar.mo11372b("FileManager", str);
        }
    }

    /* renamed from: a */
    private boolean m2443a(File file, String str, List<String> list, boolean z, C1102e eVar) {
        if (file == null || !file.exists() || file.isDirectory()) {
            ByteArrayOutputStream a = mo11239a(str, list, z, eVar);
            if (!(eVar == null || a == null)) {
                eVar.mo10743a((long) a.size());
            }
            return mo11244a(a, file);
        }
        C1314v vVar = this.f2406c;
        vVar.mo11372b("FileManager", "File exists for " + str);
        if (eVar == null) {
            return true;
        }
        eVar.mo10745b(file.length());
        return true;
    }

    /* renamed from: b */
    private boolean m2444b() {
        return ((Boolean) this.f2405b.mo10946a(C1085b.f1637bp)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r1, r4.f2405b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        throw r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0041=Splitter:B:21:0x0041, B:16:0x0034=Splitter:B:16:0x0034} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2445b(java.io.ByteArrayOutputStream r5, java.io.File r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.v r0 = r4.f2406c
            java.lang.String r1 = "FileManager"
            java.lang.String r2 = "Writing resource to filesystem: "
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            java.lang.String r3 = r6.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.mo11372b(r1, r2)
            java.lang.Object r0 = r4.f2407d
            monitor-enter(r0)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0040, all -> 0x0033 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0040, all -> 0x0033 }
            r5.writeTo(r2)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r5 = 1
            com.applovin.impl.sdk.m r6 = r4.f2405b     // Catch:{ all -> 0x002b }
            com.applovin.impl.sdk.utils.Utils.close(r2, r6)     // Catch:{ all -> 0x002b }
            goto L_0x004f
        L_0x002b:
            r5 = move-exception
            goto L_0x0058
        L_0x002d:
            r5 = move-exception
            r1 = r2
            goto L_0x0034
        L_0x0030:
            r5 = move-exception
            r1 = r2
            goto L_0x0041
        L_0x0033:
            r5 = move-exception
        L_0x0034:
            com.applovin.impl.sdk.v r6 = r4.f2406c     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unknown failure to write file."
            r6.mo11373b(r2, r3, r5)     // Catch:{ all -> 0x0051 }
        L_0x003d:
            com.applovin.impl.sdk.m r5 = r4.f2405b     // Catch:{ all -> 0x002b }
            goto L_0x004b
        L_0x0040:
            r5 = move-exception
        L_0x0041:
            com.applovin.impl.sdk.v r6 = r4.f2406c     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unable to write data to file."
            r6.mo11373b(r2, r3, r5)     // Catch:{ all -> 0x0051 }
            goto L_0x003d
        L_0x004b:
            com.applovin.impl.sdk.utils.Utils.close(r1, r5)     // Catch:{ all -> 0x002b }
            r5 = 0
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return r5
        L_0x0051:
            r5 = move-exception
            com.applovin.impl.sdk.m r6 = r4.f2405b     // Catch:{ all -> 0x002b }
            com.applovin.impl.sdk.utils.Utils.close(r1, r6)     // Catch:{ all -> 0x002b }
            throw r5     // Catch:{ all -> 0x002b }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            goto L_0x005b
        L_0x005a:
            throw r5
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1247r.m2445b(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* renamed from: b */
    private boolean m2446b(File file) {
        boolean delete;
        C1314v vVar = this.f2406c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Removing file ");
        outline24.append(file.getName());
        outline24.append(" from filesystem...");
        vVar.mo11372b("FileManager", outline24.toString());
        synchronized (this.f2407d) {
            try {
                delete = file.delete();
            } catch (Exception e) {
                C1314v vVar2 = this.f2406c;
                vVar2.mo11373b("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return delete;
    }

    /* renamed from: c */
    private long m2447c(Context context) {
        long j;
        boolean z;
        long a = m2440a();
        boolean z2 = a != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f2407d) {
            List<String> b = this.f2405b.mo10980b(C1085b.f1644bw);
            j = 0;
            for (File next : m2448d(context)) {
                if (!z2 || b.contains(next.getName()) || seconds - TimeUnit.MILLISECONDS.toSeconds(next.lastModified()) <= a) {
                    z = false;
                } else {
                    C1314v vVar = this.f2406c;
                    vVar.mo11372b("FileManager", "File " + next.getName() + " has expired, removing...");
                    z = m2446b(next);
                }
                if (z) {
                    this.f2405b.mo10939T().mo10757a(C1103f.f1927e);
                } else {
                    j += next.length();
                }
            }
        }
        return j;
    }

    /* renamed from: d */
    private List<File> m2448d(Context context) {
        List<File> asList;
        File e = m2449e(context);
        if (!e.isDirectory()) {
            return Collections.emptyList();
        }
        synchronized (this.f2407d) {
            asList = Arrays.asList(e.listFiles());
        }
        return asList;
    }

    /* renamed from: e */
    private File m2449e(Context context) {
        return new File(context.getFilesDir(), "al");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r9 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0024] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0053=Splitter:B:27:0x0053, B:35:0x0066=Splitter:B:35:0x0066, B:43:0x008e=Splitter:B:43:0x008e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo11238a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.sdk.v r1 = r8.f2406c
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Reading resource from filesystem: "
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            java.lang.String r4 = r9.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.mo11372b(r2, r3)
            java.lang.Object r1 = r8.f2407d
            monitor-enter(r1)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0063, all -> 0x0051 }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0063, all -> 0x0051 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004d, all -> 0x004b }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004d, all -> 0x004b }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004d, all -> 0x004b }
        L_0x002d:
            r6 = 0
            int r7 = r2.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004d, all -> 0x004b }
            if (r7 < 0) goto L_0x0044
            r3.write(r5, r6, r7)     // Catch:{ Exception -> 0x0038, all -> 0x004b }
            goto L_0x002d
        L_0x0038:
            com.applovin.impl.sdk.m r4 = r8.f2405b     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004d, all -> 0x004b }
            com.applovin.impl.sdk.utils.Utils.close(r3, r4)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004d, all -> 0x004b }
            com.applovin.impl.sdk.m r9 = r8.f2405b     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            return r0
        L_0x0044:
            com.applovin.impl.sdk.m r9 = r8.f2405b     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            return r3
        L_0x004b:
            r9 = move-exception
            goto L_0x0053
        L_0x004d:
            r3 = move-exception
            goto L_0x0066
        L_0x004f:
            r9 = move-exception
            goto L_0x008e
        L_0x0051:
            r9 = move-exception
            r2 = r0
        L_0x0053:
            com.applovin.impl.sdk.v r3 = r8.f2406c     // Catch:{ all -> 0x00ad }
            java.lang.String r4 = "FileManager"
            java.lang.String r5 = "Unknown failure to read file."
            r3.mo11373b(r4, r5, r9)     // Catch:{ all -> 0x00ad }
            com.applovin.impl.sdk.m r9 = r8.f2405b     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            return r0
        L_0x0063:
            r2 = move-exception
            r3 = r2
            r2 = r0
        L_0x0066:
            com.applovin.impl.sdk.v r4 = r8.f2406c     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r6.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r7 = "Failed to read file: "
            r6.append(r7)     // Catch:{ all -> 0x00ad }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x00ad }
            r6.append(r9)     // Catch:{ all -> 0x00ad }
            r6.append(r3)     // Catch:{ all -> 0x00ad }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00ad }
            r4.mo11372b(r5, r9)     // Catch:{ all -> 0x00ad }
            com.applovin.impl.sdk.m r9 = r8.f2405b     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            return r0
        L_0x008c:
            r9 = move-exception
            r2 = r0
        L_0x008e:
            com.applovin.impl.sdk.v r3 = r8.f2406c     // Catch:{ all -> 0x00ad }
            java.lang.String r4 = "FileManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r5.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00ad }
            r5.append(r9)     // Catch:{ all -> 0x00ad }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00ad }
            r3.mo11374c(r4, r9)     // Catch:{ all -> 0x00ad }
            com.applovin.impl.sdk.m r9 = r8.f2405b     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            return r0
        L_0x00ad:
            r9 = move-exception
            com.applovin.impl.sdk.m r0 = r8.f2405b     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r0)     // Catch:{ all -> 0x00b4 }
            throw r9     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            goto L_0x00b8
        L_0x00b7:
            throw r9
        L_0x00b8:
            goto L_0x00b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1247r.mo11238a(java.io.File):java.io.ByteArrayOutputStream");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.io.InputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r9, r7.f2405b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c9, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r2, r7.f2405b);
        com.applovin.impl.sdk.utils.Utils.close(r9, r7.f2405b);
        com.applovin.impl.sdk.utils.Utils.disconnect(r10, r7.f2405b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d8, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo11239a(java.lang.String r8, java.util.List<java.lang.String> r9, boolean r10, com.applovin.impl.sdk.p028d.C1102e r11) {
        /*
            r7 = this;
            java.lang.String r0 = "FileManager"
            r1 = 0
            if (r10 == 0) goto L_0x0022
            boolean r9 = com.applovin.impl.sdk.utils.Utils.isDomainWhitelisted(r8, r9)
            if (r9 != 0) goto L_0x0022
            com.applovin.impl.sdk.v r9 = r7.f2406c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Domain is not whitelisted, skipping precache for url: "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.mo11372b(r0, r8)
            return r1
        L_0x0022:
            com.applovin.impl.sdk.m r9 = r7.f2405b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.p027c.C1085b.f1667cT
            java.lang.Object r9 = r9.mo10946a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0047
            java.lang.String r9 = "https://"
            boolean r10 = r8.contains(r9)
            if (r10 != 0) goto L_0x0047
            com.applovin.impl.sdk.v r10 = r7.f2406c
            java.lang.String r2 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r10.mo11375d(r0, r2)
            java.lang.String r10 = "http://"
            java.lang.String r8 = r8.replace(r10, r9)
        L_0x0047:
            com.applovin.impl.sdk.v r9 = r7.f2406c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Loading "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r2 = "..."
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.mo11372b(r0, r10)
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0120, all -> 0x011c }
            r9.<init>()     // Catch:{ IOException -> 0x0120, all -> 0x011c }
            java.net.URL r10 = new java.net.URL     // Catch:{ IOException -> 0x0119, all -> 0x0116 }
            r10.<init>(r8)     // Catch:{ IOException -> 0x0119, all -> 0x0116 }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ IOException -> 0x0119, all -> 0x0116 }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x0119, all -> 0x0116 }
            com.applovin.impl.sdk.m r2 = r7.f2405b     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p027c.C1085b.f1665cR     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            java.lang.Object r2 = r2.mo10946a(r3)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r10.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            com.applovin.impl.sdk.m r2 = r7.f2405b     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p027c.C1085b.f1666cS     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            java.lang.Object r2 = r2.mo10946a(r3)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r10.setReadTimeout(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r2 = 1
            r10.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r10.setUseCaches(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r3 = 0
            r10.setAllowUserInteraction(r3)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r10.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            int r2 = r10.getResponseCode()     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r11.mo10742a((int) r2)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 < r4) goto L_0x0101
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r4) goto L_0x00b2
            goto L_0x0101
        L_0x00b2:
            java.io.InputStream r2 = r10.getInputStream()     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ IOException -> 0x00ff }
        L_0x00ba:
            int r6 = r2.read(r5, r3, r4)     // Catch:{ IOException -> 0x00ff }
            if (r6 < 0) goto L_0x00d9
            r9.write(r5, r3, r6)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00ba
        L_0x00c4:
            com.applovin.impl.sdk.m r3 = r7.f2405b     // Catch:{ IOException -> 0x00ff }
            com.applovin.impl.sdk.utils.Utils.close(r9, r3)     // Catch:{ IOException -> 0x00ff }
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r2, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r9, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r8)
            return r1
        L_0x00d9:
            com.applovin.impl.sdk.v r3 = r7.f2406c     // Catch:{ IOException -> 0x00ff }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ff }
            r4.<init>()     // Catch:{ IOException -> 0x00ff }
            java.lang.String r5 = "Loaded resource at "
            r4.append(r5)     // Catch:{ IOException -> 0x00ff }
            r4.append(r8)     // Catch:{ IOException -> 0x00ff }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00ff }
            r3.mo11372b(r0, r4)     // Catch:{ IOException -> 0x00ff }
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r2, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r9, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r8)
            return r9
        L_0x00ff:
            r3 = move-exception
            goto L_0x0124
        L_0x0101:
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r1, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r9, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r8)
            return r1
        L_0x0111:
            r8 = move-exception
            goto L_0x014f
        L_0x0113:
            r3 = move-exception
            r2 = r1
            goto L_0x0124
        L_0x0116:
            r8 = move-exception
            r10 = r1
            goto L_0x014f
        L_0x0119:
            r3 = move-exception
            r10 = r1
            goto L_0x0123
        L_0x011c:
            r8 = move-exception
            r9 = r1
            r10 = r9
            goto L_0x014f
        L_0x0120:
            r3 = move-exception
            r9 = r1
            r10 = r9
        L_0x0123:
            r2 = r10
        L_0x0124:
            com.applovin.impl.sdk.v r4 = r7.f2406c     // Catch:{ all -> 0x014d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x014d }
            r5.<init>()     // Catch:{ all -> 0x014d }
            java.lang.String r6 = "Error loading "
            r5.append(r6)     // Catch:{ all -> 0x014d }
            r5.append(r8)     // Catch:{ all -> 0x014d }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x014d }
            r4.mo11373b(r0, r8, r3)     // Catch:{ all -> 0x014d }
            r11.mo10744a((java.lang.Exception) r3)     // Catch:{ all -> 0x014d }
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r2, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r9, r8)
            com.applovin.impl.sdk.m r8 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r8)
            return r1
        L_0x014d:
            r8 = move-exception
            r1 = r2
        L_0x014f:
            com.applovin.impl.sdk.m r11 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r1, r11)
            com.applovin.impl.sdk.m r11 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.close(r9, r11)
            com.applovin.impl.sdk.m r9 = r7.f2405b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r9)
            goto L_0x0160
        L_0x015f:
            throw r8
        L_0x0160:
            goto L_0x015f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1247r.mo11239a(java.lang.String, java.util.List, boolean, com.applovin.impl.sdk.d.e):java.io.ByteArrayOutputStream");
    }

    /* renamed from: a */
    public File mo11240a(String str, Context context) {
        File file;
        if (!StringUtils.isValidString(str)) {
            this.f2406c.mo11372b("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        C1314v vVar = this.f2406c;
        vVar.mo11372b("FileManager", "Looking up cached resource: " + str);
        if (str.contains("icon")) {
            str = str.replace("/", "_").replace(CodelessMatcher.CURRENT_CLASS_NAME, "_");
        }
        synchronized (this.f2407d) {
            File e = m2449e(context);
            file = new File(e, str);
            try {
                e.mkdirs();
            } catch (Throwable th) {
                C1314v vVar2 = this.f2406c;
                vVar2.mo11373b("FileManager", "Unable to make cache directory at " + e, th);
                return null;
            }
        }
        return file;
    }

    /* renamed from: a */
    public String mo11241a(Context context, String str, String str2, List<String> list, boolean z, C1102e eVar) {
        return mo11242a(context, str, str2, list, z, false, eVar);
    }

    /* renamed from: a */
    public String mo11242a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, C1102e eVar) {
        if (!StringUtils.isValidString(str)) {
            this.f2406c.mo11372b("FileManager", "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (StringUtils.isValidString(lastPathSegment) && StringUtils.isValidString(str2)) {
            String str3 = str2;
            lastPathSegment = GeneratedOutlineSupport.outline16(str2, lastPathSegment);
        }
        String str4 = lastPathSegment;
        Context context2 = context;
        File a = mo11240a(str4, context);
        if (!m2443a(a, str, list, z, eVar)) {
            return null;
        }
        C1314v vVar = this.f2406c;
        vVar.mo11372b("FileManager", "Caching succeeded for file " + str4);
        return z2 ? Uri.fromFile(a).toString() : str4;
    }

    /* renamed from: a */
    public void mo11243a(Context context) {
        if (m2444b() && this.f2405b.mo10986c()) {
            this.f2406c.mo11372b("FileManager", "Compacting cache...");
            synchronized (this.f2407d) {
                m2442a(m2447c(context), context);
            }
        }
    }

    /* renamed from: a */
    public boolean mo11244a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        C1314v vVar = this.f2406c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Caching ");
        outline24.append(file.getAbsolutePath());
        outline24.append("...");
        vVar.mo11372b("FileManager", outline24.toString());
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            C1314v vVar2 = this.f2406c;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("No data for ");
            outline242.append(file.getAbsolutePath());
            vVar2.mo11375d("FileManager", outline242.toString());
            return false;
        } else if (!m2445b(byteArrayOutputStream, file)) {
            C1314v vVar3 = this.f2406c;
            StringBuilder outline243 = GeneratedOutlineSupport.outline24("Unable to cache ");
            outline243.append(file.getAbsolutePath());
            vVar3.mo11376e("FileManager", outline243.toString());
            return false;
        } else {
            C1314v vVar4 = this.f2406c;
            vVar4.mo11372b("FileManager", "Caching completed for " + file);
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo11245a(File file, String str, List<String> list, C1102e eVar) {
        return m2443a(file, str, list, true, eVar);
    }

    /* renamed from: b */
    public void mo11246b(Context context) {
        try {
            mo11240a(".nomedia", context);
            File file = new File(m2449e(context), ".nomedia");
            if (!file.exists()) {
                C1314v vVar = this.f2406c;
                vVar.mo11372b("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
                if (!file.createNewFile()) {
                    this.f2406c.mo11376e("FileManager", "Failed to create .nomedia file");
                }
            }
        } catch (IOException e) {
            this.f2406c.mo11373b("FileManager", "Failed to create .nomedia file", e);
        }
    }

    /* renamed from: b */
    public boolean mo11247b(String str, Context context) {
        boolean z;
        synchronized (this.f2407d) {
            File a = mo11240a(str, context);
            z = a != null && a.exists() && !a.isDirectory();
        }
        return z;
    }
}
