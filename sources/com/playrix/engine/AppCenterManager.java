package com.playrix.engine;

import android.app.Application;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.util.AttachmentConstants;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.AbstractCrashesListener;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterConsumer;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

public class AppCenterManager {
    public static final String LOG_PREFIX = "[AppCenter] ";

    public static class AppCenterCrashesListener extends AbstractCrashesListener {
        public static final String LOG_PREFIX = "[AppCenterCrashesListener] ";

        public AppCenterCrashesListener() {
        }

        public Iterable<ErrorAttachmentLog> getErrorAttachments(ErrorReport errorReport) {
            new CrashInfo(errorReport);
            Attachment access$400 = AppCenterManager.nativeGetAttachment();
            ArrayList arrayList = new ArrayList();
            String str = access$400.description;
            if (str != null && !str.isEmpty()) {
                String str2 = access$400.description;
                if (str2 == null) {
                    str2 = "";
                }
                arrayList.add(ErrorAttachmentLog.attachmentWithBinary(str2.getBytes(ErrorAttachmentLog.CHARSET), "description.txt", "text/plain"));
            }
            String str3 = access$400.fileName;
            if (str3 != null && !str3.isEmpty()) {
                arrayList.add(ErrorAttachmentLog.attachmentWithBinary(access$400.data, access$400.fileName, AttachmentConstants.UNKNOWN_FILE_MIME));
            }
            return arrayList;
        }

        public void onSendingFailed(ErrorReport errorReport, Exception exc) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[AppCenterCrashesListener] [onSendingFailed] ");
            outline24.append(errorReport.f3581id);
            outline24.append(" : ");
            outline24.append(exc.toString());
            Logger.logError(outline24.toString());
        }

        public void onSendingSucceeded(ErrorReport errorReport) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[AppCenterCrashesListener] [onSendingSucceeded] ");
            outline24.append(errorReport.f3581id);
            Logger.logInfo(outline24.toString());
        }

        public boolean shouldProcess(ErrorReport errorReport) {
            return AppCenterManager.nativeShouldCrashBeUploaded(new CrashInfo(errorReport));
        }
    }

    public static class Attachment {
        public byte[] data;
        public String description;
        public String fileName;

        public Attachment(byte[] bArr, String str, String str2) {
            this.data = bArr;
            this.fileName = str;
            this.description = str2;
        }
    }

    public static class CrashInfo {
        public String dumpPath;
        public String path;

        public CrashInfo(ErrorReport errorReport) {
            String findLogPathById = findLogPathById(errorReport.f3581id);
            this.path = findLogPathById;
            this.dumpPath = getDumpPath(findLogPathById);
        }

        public static String findLogPathById(String str) {
            for (File file : ErrorLogHelper.getStoredErrorLogFiles()) {
                if (file.getName().startsWith(str)) {
                    return file.getAbsolutePath();
                }
            }
            return "";
        }

        public static String getDumpPath(String str) {
            JSONObject readJsonFile = readJsonFile(str);
            if (readJsonFile == null) {
                Logger.logError("[AppCenter] [CrashInfo.getDumpPath] cannot read " + str);
                return "";
            }
            try {
                if (readJsonFile.getJSONObject("exception").getString("type").equals("minidump")) {
                    return readJsonFile.getJSONObject("exception").getString("minidumpFilePath");
                }
                return "";
            } catch (Exception unused) {
                Logger.logError("[AppCenter] [CrashInfo.getDumpPath] cannot get exception.stackTrace value");
                return "";
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[SYNTHETIC, Splitter:B:13:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0037 A[SYNTHETIC, Splitter:B:21:0x0037] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static org.json.JSONObject readJsonFile(java.lang.String r5) {
            /*
                r0 = 0
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0034, all -> 0x002a }
                r1.<init>(r5)     // Catch:{ Exception -> 0x0034, all -> 0x002a }
                java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0034, all -> 0x002a }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0034, all -> 0x002a }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0034, all -> 0x002a }
                r5.<init>(r2)     // Catch:{ Exception -> 0x0034, all -> 0x002a }
                long r1 = r1.length()     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                int r2 = (int) r1     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                byte[] r1 = new byte[r2]     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                r5.read(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0035, all -> 0x0028 }
                r5.close()     // Catch:{ Exception -> 0x0027 }
            L_0x0027:
                return r2
            L_0x0028:
                r0 = move-exception
                goto L_0x002e
            L_0x002a:
                r5 = move-exception
                r4 = r0
                r0 = r5
                r5 = r4
            L_0x002e:
                if (r5 == 0) goto L_0x0033
                r5.close()     // Catch:{ Exception -> 0x0033 }
            L_0x0033:
                throw r0
            L_0x0034:
                r5 = r0
            L_0x0035:
                if (r5 == 0) goto L_0x003a
                r5.close()     // Catch:{ Exception -> 0x003a }
            L_0x003a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.AppCenterManager.CrashInfo.readJsonFile(java.lang.String):org.json.JSONObject");
        }
    }

    public static String getSdkVersion() {
        return "4.3.1";
    }

    public static void initialize(String str) {
        DefaultAppCenterFuture defaultAppCenterFuture;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        Application application = Engine.getApplication();
        if (application == null) {
            Logger.logError("[AppCenter] init error, empty context");
            return;
        }
        Crashes.getInstance().setInstanceListener(new AppCenterCrashesListener());
        Class[] clsArr = {Analytics.class, Crashes.class};
        AppCenter instance = AppCenter.getInstance();
        synchronized (instance) {
            if (str != null) {
                if (!str.isEmpty()) {
                    instance.configureAndStartServices(application, str, true, clsArr);
                }
            }
            AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
        }
        Crashes instance2 = Crashes.getInstance();
        synchronized (instance2) {
            defaultAppCenterFuture = new DefaultAppCenterFuture();
            instance2.postAsyncGetter(new Runnable(defaultAppCenterFuture) {
                public final /* synthetic */ DefaultAppCenterFuture val$future;

                public void run(
/*
Method generation error in method: com.microsoft.appcenter.crashes.Crashes.1.run():void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.microsoft.appcenter.crashes.Crashes.1.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:260)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:70)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            }, defaultAppCenterFuture, null);
        }
        defaultAppCenterFuture.thenAccept(new AppCenterConsumer<String>() {
            public void accept(String str) {
                if (str != null) {
                    File file = new File(str);
                    if (file.isDirectory()) {
                        AppCenterManager.nativeInitBreakpad(file.getPath());
                        Logger.logInfo("[AppCenter] crashDir: " + file.getAbsolutePath());
                        return;
                    }
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("[AppCenter] Cannot initialize DumpMaker. crashDir: ");
                    outline24.append(file.getAbsolutePath());
                    Logger.logError(outline24.toString());
                    return;
                }
                Logger.logError("[AppCenter] Cannot initialize DumpMaker. crashDir: null");
            }
        });
        Crashes instance3 = Crashes.getInstance();
        synchronized (instance3) {
            defaultAppCenterFuture2 = new DefaultAppCenterFuture();
            instance3.postAsyncGetter(new Runnable(defaultAppCenterFuture2) {
                public final /* synthetic */ DefaultAppCenterFuture val$future;

                public void run(
/*
Method generation error in method: com.microsoft.appcenter.crashes.Crashes.2.run():void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.microsoft.appcenter.crashes.Crashes.2.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:260)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:70)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            }, defaultAppCenterFuture2, Boolean.FALSE);
        }
        defaultAppCenterFuture2.thenAccept(new AppCenterConsumer<Boolean>() {
            public void accept(Boolean bool) {
                DefaultAppCenterFuture defaultAppCenterFuture;
                if (!bool.booleanValue() || !bool.booleanValue()) {
                    AppCenterManager.nativeHasCrashedInLastSession(false, -1);
                    return;
                }
                Crashes instance = Crashes.getInstance();
                synchronized (instance) {
                    defaultAppCenterFuture = new DefaultAppCenterFuture();
                    instance.postAsyncGetter(new Runnable(defaultAppCenterFuture) {
                        public final /* synthetic */ DefaultAppCenterFuture val$future;

                        public void run(
/*
Method generation error in method: com.microsoft.appcenter.crashes.Crashes.4.run():void, dex: classes2.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.microsoft.appcenter.crashes.Crashes.4.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:260)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    }, defaultAppCenterFuture, null);
                }
                defaultAppCenterFuture.thenAccept(new AppCenterConsumer<ErrorReport>() {
                    public void accept(ErrorReport errorReport) {
                        Date date = errorReport != null ? errorReport.appErrorTime : null;
                        AppCenterManager.nativeHasCrashedInLastSession(true, date != null ? date.getTime() / 1000 : -1);
                    }
                });
            }
        });
    }

    public static native Attachment nativeGetAttachment();

    public static native void nativeHasCrashedInLastSession(boolean z, long j);

    public static native void nativeInitBreakpad(String str);

    public static native boolean nativeShouldCrashBeUploaded(CrashInfo crashInfo);

    public static void setLogLevel(int i) {
        AppCenter instance = AppCenter.getInstance();
        synchronized (instance) {
            instance.mLogLevelConfigured = true;
            AppCenterLog.sLogLevel = i;
        }
    }

    public static void setUserId(String str) {
        boolean z;
        AppCenter instance = AppCenter.getInstance();
        synchronized (instance) {
            if (!instance.mConfiguredFromApp) {
                AppCenterLog.error("AppCenter", "AppCenter must be configured from application, libraries cannot use call setUserId.");
            } else if (instance.mAppSecret == null && instance.mTransmissionTargetToken == null) {
                AppCenterLog.error("AppCenter", "AppCenter must be configured with a secret from application to call setUserId.");
            } else {
                if (str != null) {
                    if (instance.mAppSecret != null) {
                        if (str.length() > 256) {
                            AppCenterLog.error("AppCenter", "userId is limited to 256 characters.");
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            return;
                        }
                    }
                    if (instance.mTransmissionTargetToken != null && !UserIdContext.checkUserIdValidForOneCollector(str)) {
                        return;
                    }
                }
                UserIdContext.getInstance().setUserId(str);
            }
        }
    }
}
