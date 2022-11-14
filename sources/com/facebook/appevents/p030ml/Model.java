package com.facebook.appevents.p030ml;

import androidx.annotation.RestrictTo;
import com.android.billingclient.api.zzam;
import com.facebook.appevents.p030ml.ModelManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.playrix.engine.Shortcuts;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.ml.Model */
/* compiled from: Model.kt */
public final class Model {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SEQ_LEN = 128;
    public static final Map<String, String> mapping = zzam.hashMapOf(new Pair("embedding.weight", "embed.weight"), new Pair("dense1.weight", "fc1.weight"), new Pair("dense2.weight", "fc2.weight"), new Pair("dense3.weight", "fc3.weight"), new Pair("dense1.bias", "fc1.bias"), new Pair("dense2.bias", "fc2.bias"), new Pair("dense3.bias", "fc3.bias"));
    public final MTensor convs0Bias;
    public final MTensor convs0Weight;
    public final MTensor convs1Bias;
    public final MTensor convs1Weight;
    public final MTensor convs2Bias;
    public final MTensor convs2Weight;
    public final MTensor embedding;
    public final MTensor fc1Bias;
    public final MTensor fc1Weight;
    public final MTensor fc2Bias;
    public final MTensor fc2Weight;
    public final Map<String, MTensor> finalWeights;

    /* renamed from: com.facebook.appevents.ml.Model$Companion */
    /* compiled from: Model.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, MTensor> parse(File file) {
            Utils utils = Utils.INSTANCE;
            Map<String, MTensor> parseModelWeights = Utils.parseModelWeights(file);
            if (parseModelWeights == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Map access$getMapping$cp = Model.access$getMapping$cp();
            for (Map.Entry next : parseModelWeights.entrySet()) {
                String str = (String) next.getKey();
                if (access$getMapping$cp.containsKey(next.getKey()) && (str = (String) access$getMapping$cp.get(next.getKey())) == null) {
                    return null;
                }
                hashMap.put(str, next.getValue());
            }
            return hashMap;
        }

        public final Model build(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            Map<String, MTensor> parse = parse(file);
            if (parse == null) {
                return null;
            }
            try {
                return new Model(parse, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public Model(Map<String, MTensor> map) {
        MTensor mTensor = map.get("embed.weight");
        if (mTensor != null) {
            this.embedding = mTensor;
            Operator operator = Operator.INSTANCE;
            MTensor mTensor2 = map.get("convs.0.weight");
            if (mTensor2 != null) {
                this.convs0Weight = Operator.transpose3D(mTensor2);
                Operator operator2 = Operator.INSTANCE;
                MTensor mTensor3 = map.get("convs.1.weight");
                if (mTensor3 != null) {
                    this.convs1Weight = Operator.transpose3D(mTensor3);
                    Operator operator3 = Operator.INSTANCE;
                    MTensor mTensor4 = map.get("convs.2.weight");
                    if (mTensor4 != null) {
                        this.convs2Weight = Operator.transpose3D(mTensor4);
                        MTensor mTensor5 = map.get("convs.0.bias");
                        if (mTensor5 != null) {
                            this.convs0Bias = mTensor5;
                            MTensor mTensor6 = map.get("convs.1.bias");
                            if (mTensor6 != null) {
                                this.convs1Bias = mTensor6;
                                MTensor mTensor7 = map.get("convs.2.bias");
                                if (mTensor7 != null) {
                                    this.convs2Bias = mTensor7;
                                    Operator operator4 = Operator.INSTANCE;
                                    MTensor mTensor8 = map.get("fc1.weight");
                                    if (mTensor8 != null) {
                                        this.fc1Weight = Operator.transpose2D(mTensor8);
                                        Operator operator5 = Operator.INSTANCE;
                                        MTensor mTensor9 = map.get("fc2.weight");
                                        if (mTensor9 != null) {
                                            this.fc2Weight = Operator.transpose2D(mTensor9);
                                            MTensor mTensor10 = map.get("fc1.bias");
                                            if (mTensor10 != null) {
                                                this.fc1Bias = mTensor10;
                                                MTensor mTensor11 = map.get("fc2.bias");
                                                if (mTensor11 != null) {
                                                    this.fc2Bias = mTensor11;
                                                    this.finalWeights = new HashMap();
                                                    for (String str : zzam.setOf((T[]) new String[]{ModelManager.Task.MTML_INTEGRITY_DETECT.toKey(), ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey()})) {
                                                        String stringPlus = Intrinsics.stringPlus(str, ".weight");
                                                        String stringPlus2 = Intrinsics.stringPlus(str, ".bias");
                                                        MTensor mTensor12 = map.get(stringPlus);
                                                        MTensor mTensor13 = map.get(stringPlus2);
                                                        if (mTensor12 != null) {
                                                            Operator operator6 = Operator.INSTANCE;
                                                            this.finalWeights.put(stringPlus, Operator.transpose2D(mTensor12));
                                                        }
                                                        if (mTensor13 != null) {
                                                            this.finalWeights.put(stringPlus2, mTensor13);
                                                        }
                                                    }
                                                    return;
                                                }
                                                throw new IllegalStateException("Required value was null.".toString());
                                            }
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public /* synthetic */ Model(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        Class<Model> cls = Model.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return mapping;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final MTensor predictOnMTML(MTensor mTensor, String[] strArr, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor, "dense");
            Intrinsics.checkNotNullParameter(strArr, "texts");
            Intrinsics.checkNotNullParameter(str, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
            Operator operator = Operator.INSTANCE;
            MTensor embedding2 = Operator.embedding(strArr, 128, this.embedding);
            Operator operator2 = Operator.INSTANCE;
            MTensor conv1D = Operator.conv1D(embedding2, this.convs0Weight);
            Operator operator3 = Operator.INSTANCE;
            Operator.addmv(conv1D, this.convs0Bias);
            Operator operator4 = Operator.INSTANCE;
            Operator.relu(conv1D);
            Operator operator5 = Operator.INSTANCE;
            MTensor conv1D2 = Operator.conv1D(conv1D, this.convs1Weight);
            Operator operator6 = Operator.INSTANCE;
            Operator.addmv(conv1D2, this.convs1Bias);
            Operator operator7 = Operator.INSTANCE;
            Operator.relu(conv1D2);
            Operator operator8 = Operator.INSTANCE;
            MTensor maxPool1D = Operator.maxPool1D(conv1D2, 2);
            Operator operator9 = Operator.INSTANCE;
            MTensor conv1D3 = Operator.conv1D(maxPool1D, this.convs2Weight);
            Operator operator10 = Operator.INSTANCE;
            Operator.addmv(conv1D3, this.convs2Bias);
            Operator operator11 = Operator.INSTANCE;
            Operator.relu(conv1D3);
            Operator operator12 = Operator.INSTANCE;
            MTensor maxPool1D2 = Operator.maxPool1D(conv1D, conv1D.getShape(1));
            Operator operator13 = Operator.INSTANCE;
            MTensor maxPool1D3 = Operator.maxPool1D(maxPool1D, maxPool1D.getShape(1));
            Operator operator14 = Operator.INSTANCE;
            MTensor maxPool1D4 = Operator.maxPool1D(conv1D3, conv1D3.getShape(1));
            Operator operator15 = Operator.INSTANCE;
            Operator.flatten(maxPool1D2, 1);
            Operator operator16 = Operator.INSTANCE;
            Operator.flatten(maxPool1D3, 1);
            Operator operator17 = Operator.INSTANCE;
            Operator.flatten(maxPool1D4, 1);
            Operator operator18 = Operator.INSTANCE;
            MTensor concatenate = Operator.concatenate(new MTensor[]{maxPool1D2, maxPool1D3, maxPool1D4, mTensor});
            Operator operator19 = Operator.INSTANCE;
            MTensor dense = Operator.dense(concatenate, this.fc1Weight, this.fc1Bias);
            Operator operator20 = Operator.INSTANCE;
            Operator.relu(dense);
            Operator operator21 = Operator.INSTANCE;
            MTensor dense2 = Operator.dense(dense, this.fc2Weight, this.fc2Bias);
            Operator operator22 = Operator.INSTANCE;
            Operator.relu(dense2);
            MTensor mTensor2 = this.finalWeights.get(Intrinsics.stringPlus(str, ".weight"));
            MTensor mTensor3 = this.finalWeights.get(Intrinsics.stringPlus(str, ".bias"));
            if (mTensor2 != null) {
                if (mTensor3 != null) {
                    Operator operator23 = Operator.INSTANCE;
                    MTensor dense3 = Operator.dense(dense2, mTensor2, mTensor3);
                    Operator operator24 = Operator.INSTANCE;
                    Operator.softmax(dense3);
                    return dense3;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
