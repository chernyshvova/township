package com.facebook.appevents.p030ml;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.android.billingclient.api.zzam;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.playrix.engine.Shortcuts;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.facebook.appevents.ml.ModelManager */
/* compiled from: ModelManager.kt */
public final class ModelManager {
    public static final String ASSET_URI_KEY = "asset_uri";
    public static final String CACHE_KEY_MODELS = "models";
    public static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    public static final ModelManager INSTANCE = new ModelManager();
    public static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    public static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = CollectionsKt__CollectionsKt.listOf(IntegrityManager.INTEGRITY_TYPE_NONE, IntegrityManager.INTEGRITY_TYPE_ADDRESS, IntegrityManager.INTEGRITY_TYPE_HEALTH);
    public static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = CollectionsKt__CollectionsKt.listOf("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
    public static final String MTML_USE_CASE = "MTML";
    public static final String RULES_URI_KEY = "rules_uri";
    public static final String SDK_MODEL_ASSET = "%s/model_asset";
    public static final String THRESHOLD_KEY = "thresholds";
    public static final String USE_CASE_KEY = "use_case";
    public static final String VERSION_ID_KEY = "version_id";
    public static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    /* renamed from: com.facebook.appevents.ml.ModelManager$Task */
    /* compiled from: ModelManager.kt */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        /* renamed from: com.facebook.appevents.ml.ModelManager$Task$WhenMappings */
        /* compiled from: ModelManager.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Task.values().length];
                Task task = Task.MTML_INTEGRITY_DETECT;
                iArr[0] = 1;
                Task task2 = Task.MTML_APP_EVENT_PREDICTION;
                iArr[1] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final String toKey() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "integrity_detect";
            }
            if (ordinal == 1) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toUseCase() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (ordinal == 1) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: com.facebook.appevents.ml.ModelManager$TaskHandler */
    /* compiled from: ModelManager.kt */
    public static final class TaskHandler {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public String assetUri;
        public Model model;
        public Runnable onPostExecute;
        public File ruleFile;
        public String ruleUri;
        public float[] thresholds;
        public String useCase;
        public int versionId;

        /* renamed from: com.facebook.appevents.ml.ModelManager$TaskHandler$Companion */
        /* compiled from: ModelManager.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final void deleteOldFiles(String str, int i) {
                File[] listFiles;
                Utils utils = Utils.INSTANCE;
                File mlDir = Utils.getMlDir();
                if (mlDir != null && (listFiles = mlDir.listFiles()) != null) {
                    if (!(listFiles.length == 0)) {
                        String str2 = str + '_' + i;
                        int length = listFiles.length;
                        int i2 = 0;
                        while (i2 < length) {
                            File file = listFiles[i2];
                            i2++;
                            String name = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "name");
                            if (CharsKt__CharKt.startsWith$default(name, str, false, 2) && !CharsKt__CharKt.startsWith$default(name, str2, false, 2)) {
                                file.delete();
                            }
                        }
                    }
                }
            }

            private final void download(String str, String str2, FileDownloadTask.Callback callback) {
                Utils utils = Utils.INSTANCE;
                File file = new File(Utils.getMlDir(), str2);
                if (str == null || file.exists()) {
                    callback.onComplete(file);
                } else {
                    new FileDownloadTask(str, file, callback).execute(new String[0]);
                }
            }

            /* renamed from: execute$lambda-1  reason: not valid java name */
            public static final void m3589execute$lambda1(List list, File file) {
                Intrinsics.checkNotNullParameter(list, "$slaves");
                Intrinsics.checkNotNullParameter(file, "file");
                Model build = Model.Companion.build(file);
                if (build != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.Companion.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004e: INVOKE  
                              (wrap: com.facebook.appevents.ml.ModelManager$TaskHandler$Companion : 0x0043: SGET  (r2v4 com.facebook.appevents.ml.ModelManager$TaskHandler$Companion) =  com.facebook.appevents.ml.ModelManager.TaskHandler.Companion com.facebook.appevents.ml.ModelManager$TaskHandler$Companion)
                              (wrap: java.lang.String : 0x0045: INVOKE  (r3v0 java.lang.String) = 
                              (r0v5 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.getRuleUri():java.lang.String type: VIRTUAL)
                              (wrap: java.lang.String : ?: STR_CONCAT  (r1v1 java.lang.String) = 
                              (wrap: java.lang.String : 0x0027: INVOKE  (r2v0 java.lang.String) = 
                              (r0v5 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.getUseCase():java.lang.String type: VIRTUAL)
                              ('_' char)
                              (wrap: int : 0x0033: INVOKE  (r2v2 int) = 
                              (r0v5 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.getVersionId():int type: VIRTUAL)
                              ("_rule")
                            )
                              (wrap: com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI : 0x004b: CONSTRUCTOR  (r4v0 com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI) = 
                              (r0v5 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                              (r6v1 'build' com.facebook.appevents.ml.Model)
                             call: com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI.<init>(com.facebook.appevents.ml.ModelManager$TaskHandler, com.facebook.appevents.ml.Model):void type: CONSTRUCTOR)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.download(java.lang.String, java.lang.String, com.facebook.appevents.internal.FileDownloadTask$Callback):void type: DIRECT in method: com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.execute$lambda-1(java.util.List, java.io.File):void, dex: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:250)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR  (r4v0 com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI) = 
                              (r0v5 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                              (r6v1 'build' com.facebook.appevents.ml.Model)
                             call: com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI.<init>(com.facebook.appevents.ml.ModelManager$TaskHandler, com.facebook.appevents.ml.Model):void type: CONSTRUCTOR in method: com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.execute$lambda-1(java.util.List, java.io.File):void, dex: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 71 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 77 more
                            */
                        /*
                            java.lang.String r0 = "$slaves"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                            java.lang.String r0 = "file"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                            com.facebook.appevents.ml.Model$Companion r0 = com.facebook.appevents.p030ml.Model.Companion
                            com.facebook.appevents.ml.Model r6 = r0.build(r6)
                            if (r6 == 0) goto L_0x0052
                            java.util.Iterator r5 = r5.iterator()
                        L_0x0016:
                            boolean r0 = r5.hasNext()
                            if (r0 == 0) goto L_0x0052
                            java.lang.Object r0 = r5.next()
                            com.facebook.appevents.ml.ModelManager$TaskHandler r0 = (com.facebook.appevents.p030ml.ModelManager.TaskHandler) r0
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r2 = r0.getUseCase()
                            r1.append(r2)
                            r2 = 95
                            r1.append(r2)
                            int r2 = r0.getVersionId()
                            r1.append(r2)
                            java.lang.String r2 = "_rule"
                            r1.append(r2)
                            java.lang.String r1 = r1.toString()
                            com.facebook.appevents.ml.ModelManager$TaskHandler$Companion r2 = com.facebook.appevents.p030ml.ModelManager.TaskHandler.Companion
                            java.lang.String r3 = r0.getRuleUri()
                            com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI r4 = new com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI
                            r4.<init>(r0, r6)
                            r2.download(r3, r1, r4)
                            goto L_0x0016
                        L_0x0052:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p030ml.ModelManager.TaskHandler.Companion.m3589execute$lambda1(java.util.List, java.io.File):void");
                    }

                    /* renamed from: execute$lambda-1$lambda-0  reason: not valid java name */
                    public static final void m3590execute$lambda1$lambda0(TaskHandler taskHandler, Model model, File file) {
                        Intrinsics.checkNotNullParameter(taskHandler, "$slave");
                        Intrinsics.checkNotNullParameter(file, "file");
                        taskHandler.setModel(model);
                        taskHandler.setRuleFile(file);
                        Runnable access$getOnPostExecute$p = taskHandler.onPostExecute;
                        if (access$getOnPostExecute$p != null) {
                            access$getOnPostExecute$p.run();
                        }
                    }

                    public final TaskHandler build(JSONObject jSONObject) {
                        if (jSONObject == null) {
                            return null;
                        }
                        try {
                            String string = jSONObject.getString(ModelManager.USE_CASE_KEY);
                            String string2 = jSONObject.getString(ModelManager.ASSET_URI_KEY);
                            String optString = jSONObject.optString(ModelManager.RULES_URI_KEY, (String) null);
                            int i = jSONObject.getInt(ModelManager.VERSION_ID_KEY);
                            float[] access$parseJsonArray = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY));
                            Intrinsics.checkNotNullExpressionValue(string, "useCase");
                            Intrinsics.checkNotNullExpressionValue(string2, "assetUri");
                            return new TaskHandler(string, string2, optString, i, access$parseJsonArray);
                        } catch (Exception unused) {
                            return null;
                        }
                    }

                    public final void execute(TaskHandler taskHandler) {
                        Intrinsics.checkNotNullParameter(taskHandler, "handler");
                        execute(taskHandler, zzam.listOf(taskHandler));
                    }

                    public final void execute(TaskHandler taskHandler, List<TaskHandler> list) {
                        Intrinsics.checkNotNullParameter(taskHandler, "master");
                        Intrinsics.checkNotNullParameter(list, "slaves");
                        deleteOldFiles(taskHandler.getUseCase(), taskHandler.getVersionId());
                        download(taskHandler.getAssetUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId(), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: INVOKE  
                              (r2v0 'this' com.facebook.appevents.ml.ModelManager$TaskHandler$Companion A[THIS])
                              (wrap: java.lang.String : 0x0031: INVOKE  (r3v1 java.lang.String) = 
                              (r3v0 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.getAssetUri():java.lang.String type: VIRTUAL)
                              (wrap: java.lang.String : ?: STR_CONCAT  (r0v4 java.lang.String) = 
                              (wrap: java.lang.String : 0x001a: INVOKE  (r1v1 java.lang.String) = 
                              (r3v0 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.getUseCase():java.lang.String type: VIRTUAL)
                              ('_' char)
                              (wrap: int : 0x0026: INVOKE  (r1v3 int) = 
                              (r3v0 'taskHandler' com.facebook.appevents.ml.ModelManager$TaskHandler)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.getVersionId():int type: VIRTUAL)
                            )
                              (wrap: com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0 : 0x0037: CONSTRUCTOR  (r1v4 com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0) = 
                              (r4v0 'list' java.util.List<com.facebook.appevents.ml.ModelManager$TaskHandler>)
                             call: com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0.<init>(java.util.List):void type: CONSTRUCTOR)
                             com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.download(java.lang.String, java.lang.String, com.facebook.appevents.internal.FileDownloadTask$Callback):void type: DIRECT in method: com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.execute(com.facebook.appevents.ml.ModelManager$TaskHandler, java.util.List):void, dex: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0037: CONSTRUCTOR  (r1v4 com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0) = 
                              (r4v0 'list' java.util.List<com.facebook.appevents.ml.ModelManager$TaskHandler>)
                             call: com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0.<init>(java.util.List):void type: CONSTRUCTOR in method: com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.execute(com.facebook.appevents.ml.ModelManager$TaskHandler, java.util.List):void, dex: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 59 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 65 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "master"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                            java.lang.String r0 = "slaves"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            java.lang.String r0 = r3.getUseCase()
                            int r1 = r3.getVersionId()
                            r2.deleteOldFiles(r0, r1)
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            java.lang.String r1 = r3.getUseCase()
                            r0.append(r1)
                            r1 = 95
                            r0.append(r1)
                            int r1 = r3.getVersionId()
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            java.lang.String r3 = r3.getAssetUri()
                            com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0 r1 = new com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0
                            r1.<init>(r4)
                            r2.download(r3, r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p030ml.ModelManager.TaskHandler.Companion.execute(com.facebook.appevents.ml.ModelManager$TaskHandler, java.util.List):void");
                    }
                }

                public TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
                    Intrinsics.checkNotNullParameter(str, "useCase");
                    Intrinsics.checkNotNullParameter(str2, "assetUri");
                    this.useCase = str;
                    this.assetUri = str2;
                    this.ruleUri = str3;
                    this.versionId = i;
                    this.thresholds = fArr;
                }

                public final String getAssetUri() {
                    return this.assetUri;
                }

                public final Model getModel() {
                    return this.model;
                }

                public final File getRuleFile() {
                    return this.ruleFile;
                }

                public final String getRuleUri() {
                    return this.ruleUri;
                }

                public final float[] getThresholds() {
                    return this.thresholds;
                }

                public final String getUseCase() {
                    return this.useCase;
                }

                public final int getVersionId() {
                    return this.versionId;
                }

                public final void setAssetUri(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.assetUri = str;
                }

                public final void setModel(Model model2) {
                    this.model = model2;
                }

                public final TaskHandler setOnPostExecute(Runnable runnable) {
                    this.onPostExecute = runnable;
                    return this;
                }

                public final void setRuleFile(File file) {
                    this.ruleFile = file;
                }

                public final void setRuleUri(String str) {
                    this.ruleUri = str;
                }

                public final void setThresholds(float[] fArr) {
                    this.thresholds = fArr;
                }

                public final void setUseCase(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.useCase = str;
                }

                public final void setVersionId(int i) {
                    this.versionId = i;
                }
            }

            /* renamed from: com.facebook.appevents.ml.ModelManager$WhenMappings */
            /* compiled from: ModelManager.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Task.values().length];
                    Task task = Task.MTML_APP_EVENT_PREDICTION;
                    iArr[1] = 1;
                    Task task2 = Task.MTML_INTEGRITY_DETECT;
                    iArr[0] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public static final /* synthetic */ float[] access$parseJsonArray(ModelManager modelManager, JSONArray jSONArray) {
                Class<ModelManager> cls = ModelManager.class;
                if (CrashShieldHandler.isObjectCrashing(cls)) {
                    return null;
                }
                try {
                    return modelManager.parseJsonArray(jSONArray);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                    return null;
                }
            }

            private final void addModels(JSONObject jSONObject) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            try {
                                TaskHandler build = TaskHandler.Companion.build(jSONObject.getJSONObject(keys.next()));
                                if (build != null) {
                                    taskHandlers.put(build.getUseCase(), build);
                                }
                            } catch (JSONException unused) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }

            public static final void enable() {
                Class<ModelManager> cls = ModelManager.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        Utility utility = Utility.INSTANCE;
                        Utility.runOnNonUiThread($$Lambda$KNMvWVVOx1J2nhRNfxa7Dpikjp0.INSTANCE);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ Exception -> 0x0083, all -> 0x007f }, RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x005d A[Catch:{ Exception -> 0x0083, all -> 0x007f }] */
            /* renamed from: enable$lambda-0  reason: not valid java name */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static final void m3586enable$lambda0() {
                /*
                    java.lang.String r0 = "model_request_timestamp"
                    java.lang.String r1 = "models"
                    java.lang.Class<com.facebook.appevents.ml.ModelManager> r2 = com.facebook.appevents.p030ml.ModelManager.class
                    boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
                    if (r3 == 0) goto L_0x000d
                    return
                L_0x000d:
                    com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    java.lang.String r4 = "com.facebook.internal.MODEL_STORE"
                    r5 = 0
                    android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    r4 = 0
                    java.lang.String r4 = r3.getString(r1, r4)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    if (r4 == 0) goto L_0x0031
                    int r6 = r4.length()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    if (r6 != 0) goto L_0x0028
                    r5 = 1
                L_0x0028:
                    if (r5 == 0) goto L_0x002b
                    goto L_0x0031
                L_0x002b:
                    org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    r5.<init>(r4)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    goto L_0x0036
                L_0x0031:
                    org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    r5.<init>()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                L_0x0036:
                    r6 = 0
                    long r6 = r3.getLong(r0, r6)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    boolean r4 = com.facebook.internal.FeatureManager.isEnabled(r4)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    if (r4 == 0) goto L_0x0054
                    int r4 = r5.length()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    if (r4 == 0) goto L_0x0054
                    com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    boolean r4 = r4.isValidTimestamp(r6)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    if (r4 != 0) goto L_0x0074
                L_0x0054:
                    com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    org.json.JSONObject r5 = r4.fetchModels()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    if (r5 != 0) goto L_0x005d
                    return
                L_0x005d:
                    android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    android.content.SharedPreferences$Editor r1 = r3.putString(r1, r4)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r3)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    r0.apply()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                L_0x0074:
                    com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    r0.addModels(r5)     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    r0.enableMTML()     // Catch:{ Exception -> 0x0083, all -> 0x007f }
                    goto L_0x0083
                L_0x007f:
                    r0 = move-exception
                    com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
                L_0x0083:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p030ml.ModelManager.m3586enable$lambda0():void");
            }

            private final void enableMTML() {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        String str = null;
                        int i = 0;
                        for (Map.Entry next : taskHandlers.entrySet()) {
                            String str2 = (String) next.getKey();
                            TaskHandler taskHandler = (TaskHandler) next.getValue();
                            if (Intrinsics.areEqual(str2, Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                                String assetUri = taskHandler.getAssetUri();
                                int max = Math.max(i, taskHandler.getVersionId());
                                FeatureManager featureManager = FeatureManager.INSTANCE;
                                if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                                    arrayList.add(taskHandler.setOnPostExecute($$Lambda$b9HGJdS7rH7dtnacHJy1lAJYPTY.INSTANCE));
                                }
                                str = assetUri;
                                i = max;
                            }
                            if (Intrinsics.areEqual(str2, Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                                str = taskHandler.getAssetUri();
                                i = Math.max(i, taskHandler.getVersionId());
                                FeatureManager featureManager2 = FeatureManager.INSTANCE;
                                if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                                    arrayList.add(taskHandler.setOnPostExecute($$Lambda$hezzgqVvKqPN9xHTZB2MDRWPuaY.INSTANCE));
                                }
                            }
                        }
                        if (str != null && i > 0 && !arrayList.isEmpty()) {
                            TaskHandler.Companion.execute(new TaskHandler(MTML_USE_CASE, str, (String) null, i, (float[]) null), arrayList);
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }

            /* renamed from: enableMTML$lambda-1  reason: not valid java name */
            public static final void m3587enableMTML$lambda1() {
                Class<ModelManager> cls = ModelManager.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
                        SuggestedEventsManager.enable();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
            }

            /* renamed from: enableMTML$lambda-2  reason: not valid java name */
            public static final void m3588enableMTML$lambda2() {
                Class<ModelManager> cls = ModelManager.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        IntegrityManager integrityManager = IntegrityManager.INSTANCE;
                        IntegrityManager.enable();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
            }

            private final JSONObject fetchModels() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
                    Bundle bundle = new Bundle();
                    bundle.putString("fields", TextUtils.join(",", strArr));
                    GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app/model_asset", (GraphRequest.Callback) null);
                    newGraphPathRequest.setParameters(bundle);
                    JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                    if (jSONObject == null) {
                        return null;
                    }
                    return parseRawJsonObject(jSONObject);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            }

            public static final File getRuleFile(Task task) {
                Class<ModelManager> cls = ModelManager.class;
                if (CrashShieldHandler.isObjectCrashing(cls)) {
                    return null;
                }
                try {
                    Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
                    TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
                    if (taskHandler == null) {
                        return null;
                    }
                    return taskHandler.getRuleFile();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                    return null;
                }
            }

            private final boolean isLocaleEnglish() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return false;
                }
                try {
                    Utility utility = Utility.INSTANCE;
                    Locale resourceLocale = Utility.getResourceLocale();
                    if (resourceLocale != null) {
                        String language = resourceLocale.getLanguage();
                        Intrinsics.checkNotNullExpressionValue(language, "locale.language");
                        if (CharsKt__CharKt.contains$default(language, "en", false, 2)) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return false;
                }
            }

            private final boolean isValidTimestamp(long j) {
                if (CrashShieldHandler.isObjectCrashing(this) || j == 0) {
                    return false;
                }
                try {
                    return System.currentTimeMillis() - j < 259200000;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return false;
                }
            }

            private final float[] parseJsonArray(JSONArray jSONArray) {
                if (CrashShieldHandler.isObjectCrashing(this) || jSONArray == null) {
                    return null;
                }
                try {
                    float[] fArr = new float[jSONArray.length()];
                    int i = 0;
                    int length = jSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            try {
                                String string = jSONArray.getString(i);
                                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                                fArr[i] = Float.parseFloat(string);
                            } catch (JSONException unused) {
                            }
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    return fArr;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            }

            /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|21) */
            /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
                return new org.json.JSONObject();
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0064 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final org.json.JSONObject parseRawJsonObject(org.json.JSONObject r13) {
                /*
                    r12 = this;
                    java.lang.String r0 = "asset_uri"
                    java.lang.String r1 = "thresholds"
                    java.lang.String r2 = "version_id"
                    java.lang.String r3 = "rules_uri"
                    java.lang.String r4 = "use_case"
                    boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
                    r6 = 0
                    if (r5 == 0) goto L_0x0012
                    return r6
                L_0x0012:
                    org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
                    r5.<init>()     // Catch:{ all -> 0x006a }
                    java.lang.String r7 = "data"
                    org.json.JSONArray r13 = r13.getJSONArray(r7)     // Catch:{ JSONException -> 0x0064 }
                    r7 = 0
                    int r8 = r13.length()     // Catch:{ JSONException -> 0x0064 }
                    if (r8 <= 0) goto L_0x0069
                L_0x0024:
                    int r9 = r7 + 1
                    org.json.JSONObject r7 = r13.getJSONObject(r7)     // Catch:{ JSONException -> 0x0064 }
                    org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0064 }
                    r10.<init>()     // Catch:{ JSONException -> 0x0064 }
                    java.lang.String r11 = r7.getString(r2)     // Catch:{ JSONException -> 0x0064 }
                    r10.put(r2, r11)     // Catch:{ JSONException -> 0x0064 }
                    java.lang.String r11 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
                    r10.put(r4, r11)     // Catch:{ JSONException -> 0x0064 }
                    org.json.JSONArray r11 = r7.getJSONArray(r1)     // Catch:{ JSONException -> 0x0064 }
                    r10.put(r1, r11)     // Catch:{ JSONException -> 0x0064 }
                    java.lang.String r11 = r7.getString(r0)     // Catch:{ JSONException -> 0x0064 }
                    r10.put(r0, r11)     // Catch:{ JSONException -> 0x0064 }
                    boolean r11 = r7.has(r3)     // Catch:{ JSONException -> 0x0064 }
                    if (r11 == 0) goto L_0x0058
                    java.lang.String r11 = r7.getString(r3)     // Catch:{ JSONException -> 0x0064 }
                    r10.put(r3, r11)     // Catch:{ JSONException -> 0x0064 }
                L_0x0058:
                    java.lang.String r7 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
                    r5.put(r7, r10)     // Catch:{ JSONException -> 0x0064 }
                    if (r9 < r8) goto L_0x0062
                    goto L_0x0069
                L_0x0062:
                    r7 = r9
                    goto L_0x0024
                L_0x0064:
                    org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
                    r5.<init>()     // Catch:{ all -> 0x006a }
                L_0x0069:
                    return r5
                L_0x006a:
                    r13 = move-exception
                    com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p030ml.ModelManager.parseRawJsonObject(org.json.JSONObject):org.json.JSONObject");
            }

            public static final String[] predict(Task task, float[][] fArr, String[] strArr) {
                Model model;
                Class<ModelManager> cls = ModelManager.class;
                if (CrashShieldHandler.isObjectCrashing(cls)) {
                    return null;
                }
                try {
                    Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
                    Intrinsics.checkNotNullParameter(fArr, "denses");
                    Intrinsics.checkNotNullParameter(strArr, "texts");
                    TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
                    if (taskHandler == null) {
                        model = null;
                    } else {
                        model = taskHandler.getModel();
                    }
                    if (model == null) {
                        return null;
                    }
                    float[] thresholds = taskHandler.getThresholds();
                    int length = strArr.length;
                    boolean z = false;
                    int length2 = fArr[0].length;
                    MTensor mTensor = new MTensor(new int[]{length, length2});
                    if (length > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            System.arraycopy(fArr[i], 0, mTensor.getData(), i * length2, length2);
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    MTensor predictOnMTML = model.predictOnMTML(mTensor, strArr, task.toKey());
                    if (predictOnMTML == null || thresholds == null) {
                        return null;
                    }
                    if (predictOnMTML.getData().length == 0) {
                        return null;
                    }
                    if (thresholds.length == 0) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    int ordinal = task.ordinal();
                    if (ordinal == 0) {
                        return INSTANCE.processIntegrityDetectionResult(predictOnMTML, thresholds);
                    }
                    if (ordinal == 1) {
                        return INSTANCE.processSuggestedEventResult(predictOnMTML, thresholds);
                    }
                    throw new NoWhenBranchMatchedException();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                    return null;
                }
            }

            private final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    int shape = mTensor.getShape(0);
                    int shape2 = mTensor.getShape(1);
                    float[] data = mTensor.getData();
                    if (shape2 != fArr.length) {
                        return null;
                    }
                    IntRange until = zzam.until(0, shape);
                    ArrayList arrayList = new ArrayList(zzam.collectionSizeOrDefault(until, 10));
                    Iterator it = until.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        String str = IntegrityManager.INTEGRITY_TYPE_NONE;
                        int length = fArr.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = i2 + 1;
                            if (data[(nextInt * shape2) + i2] >= fArr[i]) {
                                str = MTML_INTEGRITY_DETECT_PREDICTION.get(i2);
                            }
                            i++;
                            i2 = i3;
                        }
                        arrayList.add(str);
                    }
                    Object[] array = arrayList.toArray(new String[0]);
                    if (array != null) {
                        return (String[]) array;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            }

            private final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    int shape = mTensor.getShape(0);
                    int shape2 = mTensor.getShape(1);
                    float[] data = mTensor.getData();
                    if (shape2 != fArr.length) {
                        return null;
                    }
                    IntRange until = zzam.until(0, shape);
                    ArrayList arrayList = new ArrayList(zzam.collectionSizeOrDefault(until, 10));
                    Iterator it = until.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        String str = "other";
                        int length = fArr.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = i2 + 1;
                            if (data[(nextInt * shape2) + i2] >= fArr[i]) {
                                str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i2);
                            }
                            i++;
                            i2 = i3;
                        }
                        arrayList.add(str);
                    }
                    Object[] array = arrayList.toArray(new String[0]);
                    if (array != null) {
                        return (String[]) array;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            }
        }
