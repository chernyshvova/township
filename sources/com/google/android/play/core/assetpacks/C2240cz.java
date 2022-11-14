package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.android.billingclient.api.zzam;
import com.google.android.gms.drive.DriveFile;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2315ck;
import com.google.android.play.core.tasks.C2353m;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.play.core.assetpacks.cz */
public final class C2240cz implements C2281w {

    /* renamed from: a */
    public static final C2292ag f3103a = new C2292ag("FakeAssetPackService");

    /* renamed from: b */
    public final String f3104b;

    /* renamed from: c */
    public final C2192aw f3105c;

    /* renamed from: e */
    public final Context f3106e;

    /* renamed from: f */
    public final C2251dl f3107f;

    /* renamed from: g */
    public final C2315ck<Executor> f3108g;

    /* renamed from: i */
    public final Handler f3109i = new Handler(Looper.getMainLooper());

    static {
        new AtomicInteger(1);
    }

    public C2240cz(File file, C2192aw awVar, C2218bz bzVar, Context context, C2251dl dlVar, C2315ck<Executor> ckVar) {
        this.f3104b = file.getAbsolutePath();
        this.f3105c = awVar;
        this.f3106e = context;
        this.f3107f = dlVar;
        this.f3108g = ckVar;
    }

    /* renamed from: a */
    public static long m2906a(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0;
    }

    /* renamed from: a */
    public final Task<List<String>> mo33159a(Map<String, Long> map) {
        f3103a.mo33278a(4, "syncPacks()", new Object[0]);
        return zzam.m17a(new ArrayList());
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo33166b(int i, String str, String str2, int i2) {
        f3103a.mo33278a(4, "getChunkFileDescriptor(session=%d, %s, %s, %d)", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
        C2353m mVar = new C2353m();
        try {
            for (File file : mo33225b(str)) {
                if (zzam.m19a(file).equals(str2)) {
                    mVar.mo33335a(ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY));
                    return mVar;
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e) {
            f3103a.mo33278a(5, "getChunkFileDescriptor failed", new Object[]{e});
            mVar.mo33334a((Exception) new LocalTestingException("Asset Slice file not found.", e));
        } catch (LocalTestingException e2) {
            f3103a.mo33278a(5, "getChunkFileDescriptor failed", new Object[]{e2});
            mVar.mo33334a((Exception) e2);
        }
    }

    /* renamed from: b */
    public final File[] mo33225b(String str) throws LocalTestingException {
        File file = new File(this.f3104b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new C2238cx(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File a : listFiles) {
                        if (zzam.m19a(a).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    /* renamed from: a */
    public final void mo33160a() {
        f3103a.mo33278a(4, "keepAlive", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33161a(int i) {
        f3103a.mo33278a(4, "notifySessionFailed", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33162a(int i, String str) {
        f3103a.mo33278a(4, "notifyModuleCompleted", new Object[0]);
        this.f3108g.mo33293a().execute(new C2237cw(this, i, str));
    }

    /* renamed from: a */
    public final void mo33224a(int i, String str, int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f3107f.mo33237a());
        bundle.putInt("session_id", i);
        File[] b = mo33225b(str);
        ArrayList arrayList = new ArrayList();
        int length = b.length;
        long j = 0;
        int i3 = 0;
        while (i3 < length) {
            File file = b[i3];
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String a = zzam.m19a(file);
            bundle.putParcelableArrayList(zzam.m21a("chunk_intents", str, a), arrayList2);
            try {
                bundle.putString(zzam.m21a("uncompressed_hash_sha256", str, a), zzam.m22a((List<File>) Arrays.asList(new File[]{file})));
                bundle.putLong(zzam.m21a("uncompressed_size", str, a), file.length());
                arrayList.add(a);
                i3++;
            } catch (NoSuchAlgorithmException e) {
                throw new LocalTestingException("SHA256 algorithm not supported.", e);
            } catch (IOException e2) {
                throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e2);
            }
        }
        bundle.putStringArrayList(zzam.m20a("slice_ids", str), arrayList);
        bundle.putLong(zzam.m20a("pack_version", str), (long) this.f3107f.mo33237a());
        bundle.putInt(zzam.m20a("status", str), i2);
        bundle.putInt(zzam.m20a("error_code", str), 0);
        bundle.putLong(zzam.m20a("bytes_downloaded", str), m2906a(i2, j));
        bundle.putLong(zzam.m20a("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", m2906a(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f3109i.post(new C2239cy(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    /* renamed from: a */
    public final void mo33164a(int i, String str, String str2, int i2) {
        f3103a.mo33278a(4, "notifyChunkTransferred", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33165a(List<String> list) {
        f3103a.mo33278a(4, "cancelDownload(%s)", new Object[]{list});
    }
}
