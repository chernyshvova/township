package com.vungle.warren.omsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.android.billingclient.api.zzam;
import com.iab.omid.library.vungle.C2890b;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.p050a.C2884a;
import com.iab.omid.library.vungle.p050a.C2887d;
import com.iab.omid.library.vungle.p050a.C2888e;
import com.iab.omid.library.vungle.p051b.C2892b;
import com.iab.omid.library.vungle.p051b.C2895d;
import com.iab.omid.library.vungle.p051b.C2898f;
import com.iab.omid.library.vungle.p053d.C2904b;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OMInjector {
    public static final String OM_SDK_JS = "omsdk.js";
    public static final String OM_SESSION_JS = "omsdk-session.js";
    public AtomicReference<Context> contextRef;
    public Handler uiHandler = new Handler(Looper.getMainLooper());

    public OMInjector(Context context) {
        this.contextRef = new AtomicReference<>(context.getApplicationContext());
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private File writeToFile(String str, File file) throws IOException {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                closeQuietly(fileWriter2);
                return file;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                closeQuietly(fileWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(fileWriter);
            throw th;
        }
    }

    public void init() {
        this.uiHandler.post(new Runnable() {
            public void run() {
                if (!Omid.INSTANCE.f3500a) {
                    C2890b bVar = Omid.INSTANCE;
                    Context applicationContext = ((Context) OMInjector.this.contextRef.get()).getApplicationContext();
                    zzam.m25a((Object) applicationContext, "Application Context cannot be null");
                    if (!bVar.f3500a) {
                        bVar.f3500a = true;
                        C2898f a = C2898f.m3490a();
                        if (a.f3516d != null) {
                            C2884a aVar = new C2884a();
                            C2888e eVar = a.f3515c;
                            Handler handler = new Handler();
                            if (eVar != null) {
                                a.f3517e = new C2887d(handler, applicationContext, aVar, a);
                                C2892b bVar2 = C2892b.f3504a;
                                if (applicationContext instanceof Application) {
                                    ((Application) applicationContext).registerActivityLifecycleCallbacks(bVar2);
                                }
                                C2904b.m3499a(applicationContext);
                                C2895d.f3508a.f3509b = applicationContext.getApplicationContext();
                                return;
                            }
                            throw null;
                        }
                        throw null;
                    }
                }
            }
        });
    }

    @WorkerThread
    @NonNull
    public List<File> injectJsFiles(@NonNull File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(writeToFile(Res.OM_JS, new File(file, OM_SDK_JS)));
        arrayList.add(writeToFile(Res.OM_SESSION_JS, new File(file, OM_SESSION_JS)));
        return arrayList;
    }
}
