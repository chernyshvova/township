package com.playrix.engine;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLObjectHandle;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.ArrayList;

public class EglContextManager {
    public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT = 64;
    public static String mGlRenderer = new String();
    public static String mGlVendor = new String();
    public static final EglContextManager mInstance = new EglContextManager();
    public ArrayList<AuxContextData> mAuxContextDatas = new ArrayList<>();
    public DepthSurfaceInfo mDepthSurfaceInfo = new DepthSurfaceInfo();
    public int mEglApiVersion = 0;
    public EGLDisplay mEglDisplay = null;
    public EGLContext mEglRenderContext = null;
    public EGLSurface mEglStubSurface = null;
    public EGLSurface mEglSurface = null;
    public EGLConfig mEglSurfaceConfig = null;
    public boolean mIsRenderContextCreated = false;
    public boolean mNotifyContextCreated = false;
    public int mRequestedMainSurfaceDepthBits = 16;
    public int mRequestedMainSurfaceStencilBits = 8;
    public EglSurfaceConfig mSurfaceConfig;

    public static class AuxContextData {
        public EGLContext eglContext;
        public EGLSurface eglDummySurface;
    }

    public static class DepthSurfaceInfo {
        public int depthBits = 16;
        public int stencilBits = 8;
    }

    public static class EglSurfaceConfig {
        public final int alphaSize;
        public final int blueSize;
        public final int depthSize;
        public final int greenSize;
        public final int redSize;
        public final int stencilSize;

        public EglSurfaceConfig(int i, int i2, int i3, int i4, int i5, int i6) {
            this.redSize = i;
            this.greenSize = i2;
            this.blueSize = i3;
            this.alphaSize = i4;
            this.depthSize = i5;
            this.stencilSize = i6;
        }
    }

    public interface Renderer {
        void onContextCreated(EGLConfig eGLConfig);

        void onDrawFrame();

        void onSurfaceChanged(int i, int i2);
    }

    public static EGLConfig chooseConfig(EglSurfaceConfig eglSurfaceConfig, EGLDisplay eGLDisplay, int i) {
        int[] iArr = {12324, eglSurfaceConfig.redSize, 12323, eglSurfaceConfig.greenSize, 12322, eglSurfaceConfig.blueSize, 12321, eglSurfaceConfig.alphaSize, 12325, eglSurfaceConfig.depthSize, 12326, eglSurfaceConfig.stencilSize, 12352, i, 12344};
        int[] iArr2 = new int[1];
        if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, new EGLConfig[1], 0, 1, iArr2, 0)) {
            int i2 = iArr2[0];
            if (i2 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, i2, iArr2, 0)) {
                    return chooseConfig(eglSurfaceConfig, eGLDisplay, eGLConfigArr);
                }
                throw new RuntimeException("eglChooseConfig#2 failed");
            }
            throw new RuntimeException("No configs match configSpec");
        }
        throw new RuntimeException("eglChooseConfig failed");
    }

    public static int createAuxContextsAndSurfaces(int i) {
        return mInstance.createAuxContextsAndSurfacesInternal(i);
    }

    private int createAuxContextsAndSurfacesInternal(int i) {
        Logger.logDebug("createAuxContextAndSurfaceInternal()");
        int[] iArr = {12440, this.mEglApiVersion, 12344};
        for (int i2 = 0; i2 < i; i2++) {
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, this.mEglSurfaceConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eglCreatePbufferSurface == null || eglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
                Logger.logError("Failed to create AUX stub surface!");
                return i2;
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, this.mEglSurfaceConfig, this.mEglRenderContext, iArr, 0);
            if (eglCreateContext == null || eglCreateContext == EGL14.EGL_NO_CONTEXT) {
                destroySurface(eglCreatePbufferSurface, "aux");
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to create AUX egl context for API ");
                outline24.append(this.mEglApiVersion);
                outline24.append(" even though primary context creation was successful!");
                Logger.logError(outline24.toString());
                return i2;
            }
            AuxContextData auxContextData = new AuxContextData();
            auxContextData.eglDummySurface = eglCreatePbufferSurface;
            auxContextData.eglContext = eglCreateContext;
            this.mAuxContextDatas.add(auxContextData);
        }
        return i;
    }

    private void createWindowSurface(Object obj) {
        if (this.mIsRenderContextCreated) {
            if (this.mEglSurface != null) {
                destroyWindowSurface();
            }
            try {
                EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglSurfaceConfig, obj, new int[]{12344}, 0);
                this.mEglSurface = eglCreateWindowSurface;
                if (eglCreateWindowSurface == null || eglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
                    this.mEglSurface = null;
                    throw new RuntimeException("no surface");
                } else if (!EGL14.eglMakeCurrent(this.mEglDisplay, eglCreateWindowSurface, eglCreateWindowSurface, this.mEglRenderContext)) {
                    throw new RuntimeException("eglMakeCurrent failed " + EGL14.eglGetError());
                }
            } catch (Exception e) {
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("eglCreateWindowSurface failed "));
            }
        }
    }

    private void destroySurface(EGLSurface eGLSurface, String str) {
        try {
            Logger.logDebug("destroySurface: mEglDisplay=" + this.mEglDisplay + ", surface=" + eGLSurface + ", contextType=" + str);
            if (!EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface)) {
                new RuntimeException("eglDestroySurface of " + str + " context surface failed " + EGL14.eglGetError());
            }
        } catch (Throwable th) {
            Logger.logError(th.getMessage());
        }
    }

    public static void fetchStringsFromGL() {
        mGlRenderer = GLES20.glGetString(7937);
        mGlVendor = GLES20.glGetString(7936);
    }

    public static int findConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        int[] iArr = new int[1];
        return EGL14.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr, 0) ? iArr[0] : i2;
    }

    public static int getAPIVersion() {
        return mInstance.mEglApiVersion;
    }

    public static String getGlRenderer() {
        if (mGlRenderer.isEmpty()) {
            updateGLStrings();
        }
        return mGlRenderer;
    }

    public static String getGlVendor() {
        if (mGlVendor.isEmpty()) {
            updateGLStrings();
        }
        return mGlVendor;
    }

    public static EglContextManager getInstance() {
        return mInstance;
    }

    public static DepthSurfaceInfo getMainDepthSurfaceInfo() {
        return mInstance.mDepthSurfaceInfo;
    }

    public static long getNativeHandle(EGLObjectHandle eGLObjectHandle) {
        if (Build.VERSION.SDK_INT >= 21) {
            return eGLObjectHandle.getNativeHandle();
        }
        return (long) eGLObjectHandle.getHandle();
    }

    public static boolean makeAuxContextCurrent(int i) {
        return mInstance.makeAuxContextCurrentInternal(i);
    }

    private boolean makeAuxContextCurrentInternal(int i) {
        if (i < 0 || i >= this.mAuxContextDatas.size()) {
            Logger.logError("EglContextManager.setAuxContextCurrentInternal(): index " + i + " is out of range!");
            return false;
        }
        AuxContextData auxContextData = this.mAuxContextDatas.get(i);
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLSurface eGLSurface = auxContextData.eglDummySurface;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, auxContextData.eglContext)) {
            return true;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EglContextManager: error setting aux context: ");
        outline24.append(EGL14.eglGetError());
        Logger.logError(outline24.toString());
        return false;
    }

    public static void makeNoAuxContextCurrent() {
        mInstance.makeNoAuxContextCurrentInternal();
    }

    private void makeNoAuxContextCurrentInternal() {
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("EglContextManager: error unsetting aux context: ");
            outline24.append(EGL14.eglGetError());
            Logger.logError(outline24.toString());
        }
    }

    private void onChosenConfig() {
        int findConfigAttrib = findConfigAttrib(this.mEglDisplay, this.mEglSurfaceConfig, 12325, 0);
        int findConfigAttrib2 = findConfigAttrib(this.mEglDisplay, this.mEglSurfaceConfig, 12323, 0);
        int findConfigAttrib3 = findConfigAttrib(this.mEglDisplay, this.mEglSurfaceConfig, 12322, 0);
        int findConfigAttrib4 = findConfigAttrib(this.mEglDisplay, this.mEglSurfaceConfig, 12326, 0);
        int findConfigAttrib5 = findConfigAttrib(this.mEglDisplay, this.mEglSurfaceConfig, 12321, 0);
        int findConfigAttrib6 = findConfigAttrib(this.mEglDisplay, this.mEglSurfaceConfig, 12324, 0);
        DepthSurfaceInfo depthSurfaceInfo = this.mDepthSurfaceInfo;
        depthSurfaceInfo.depthBits = findConfigAttrib;
        depthSurfaceInfo.stencilBits = findConfigAttrib4;
        Logger.logDebug("EglConftextManager: chosen EGL config is r=" + findConfigAttrib6 + ",g=" + findConfigAttrib2 + ",b=" + findConfigAttrib3 + ",a=" + findConfigAttrib5 + ",d=" + findConfigAttrib + ",s=" + findConfigAttrib4);
    }

    private void releaseAuxContext(AuxContextData auxContextData) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("releaseAuxContext(): data.eglDummySurface=");
        outline24.append(auxContextData.eglDummySurface);
        outline24.append(", data.eglContext=");
        outline24.append(auxContextData.eglContext);
        Logger.logDebug(outline24.toString());
        destroySurface(auxContextData.eglDummySurface, "aux");
        if (!EGL14.eglDestroyContext(this.mEglDisplay, auxContextData.eglContext)) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("eglDestroyContex failed ");
            outline242.append(EGL14.eglGetError());
            Logger.logError(outline242.toString());
        }
    }

    public static void releaseAuxContextsAndSurfaces() {
        mInstance.releaseAuxContextsAndSurfacesInternal();
    }

    private void releaseAuxContextsAndSurfacesInternal() {
        for (int i = 0; i < this.mAuxContextDatas.size(); i++) {
            releaseAuxContext(this.mAuxContextDatas.get(i));
        }
        this.mAuxContextDatas.clear();
    }

    private void releaseRenderContext() {
        this.mIsRenderContextCreated = false;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("releaseRenderContext(): mEglDisplay = ");
        outline24.append(this.mEglDisplay);
        outline24.append(",mEglRenderContext =");
        outline24.append(this.mEglRenderContext);
        Logger.logDebug(outline24.toString());
        EGLDisplay eGLDisplay = this.mEglDisplay;
        if (!(eGLDisplay == null || this.mEglRenderContext == null)) {
            try {
                if (!EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
                    throw new RuntimeException("eglMakeCurrent failed " + EGL14.eglGetError());
                }
            } catch (Exception e) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("EglContextManager close failed ");
                outline242.append(e.toString());
                Logger.sysError(outline242.toString());
            }
        }
        EGLSurface eGLSurface = this.mEglStubSurface;
        if (eGLSurface != null) {
            destroySurface(eGLSurface, "stub");
            this.mEglStubSurface = null;
        }
        EGLContext eGLContext = this.mEglRenderContext;
        if (eGLContext != null) {
            try {
                if (EGL14.eglDestroyContext(this.mEglDisplay, eGLContext)) {
                    this.mEglRenderContext = null;
                } else {
                    throw new RuntimeException("eglDestroyContex failed " + EGL14.eglGetError());
                }
            } catch (Exception e2) {
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("EglContextManager close failed ");
                outline243.append(e2.toString());
                Logger.sysError(outline243.toString());
            }
        }
        this.mEglSurfaceConfig = null;
    }

    public static int scoreConfig(EglSurfaceConfig eglSurfaceConfig, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int i = 0;
        int findConfigAttrib = findConfigAttrib(eGLDisplay, eGLConfig, 12325, 0);
        int findConfigAttrib2 = findConfigAttrib(eGLDisplay, eGLConfig, 12326, 0);
        int findConfigAttrib3 = findConfigAttrib(eGLDisplay, eGLConfig, 12324, 0);
        int findConfigAttrib4 = findConfigAttrib(eGLDisplay, eGLConfig, 12323, 0);
        int findConfigAttrib5 = findConfigAttrib(eGLDisplay, eGLConfig, 12322, 0);
        int findConfigAttrib6 = findConfigAttrib(eGLDisplay, eGLConfig, 12321, 0);
        Logger.logDebug("EglContextManager: scoring config r=" + findConfigAttrib3 + ",g=" + findConfigAttrib4 + ",b=" + findConfigAttrib5 + ",a=" + findConfigAttrib6 + ",d=" + findConfigAttrib + ",s=" + findConfigAttrib2);
        if ((eglSurfaceConfig.depthSize > 0 && findConfigAttrib == 0) || ((eglSurfaceConfig.stencilSize > 0 && findConfigAttrib2 == 0) || (eglSurfaceConfig.alphaSize > 0 && findConfigAttrib6 == 0))) {
            i = -1000;
        }
        int i2 = eglSurfaceConfig.depthSize;
        int i3 = findConfigAttrib > i2 ? i - 1 : i + ((findConfigAttrib - i2) * 2);
        int i4 = eglSurfaceConfig.stencilSize;
        return ((((findConfigAttrib2 > i4 ? i3 - 1 : i3 + ((findConfigAttrib2 - i4) * 2)) - Math.abs(findConfigAttrib3 - eglSurfaceConfig.redSize)) - Math.abs(findConfigAttrib4 - eglSurfaceConfig.greenSize)) - Math.abs(findConfigAttrib5 - eglSurfaceConfig.blueSize)) - Math.abs(findConfigAttrib6 - eglSurfaceConfig.alphaSize);
    }

    public static void setDepthSettings(int i, int i2, boolean z) {
        Logger.logDebug("EglContextManager.setDepthSettings(depthBits:" + i + ",stencilBits:" + i2 + ",depthTexture:" + z + ")");
        mInstance.setDepthSettingsInternal(i, i2, z);
    }

    private void setDepthSettingsInternal(int i, int i2, boolean z) {
        if (i == 0 && i2 == 0) {
            this.mRequestedMainSurfaceDepthBits = 0;
            this.mRequestedMainSurfaceStencilBits = 0;
            return;
        }
        this.mRequestedMainSurfaceDepthBits = i;
        if (z) {
            this.mRequestedMainSurfaceStencilBits = 0;
        } else {
            this.mRequestedMainSurfaceStencilBits = i2;
        }
    }

    public static void swapBuffers() {
        mInstance.swapBuffersInternal();
    }

    private void tryCreateContext(int i, int i2) {
        EGLConfig chooseConfig = chooseConfig(this.mSurfaceConfig, this.mEglDisplay, i2);
        if (chooseConfig != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, chooseConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, i, 12344}, 0);
            if (eglCreateContext == null || eglCreateContext == EGL14.EGL_NO_CONTEXT) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("createRenderContext failed ");
                outline24.append(EGL14.eglGetError());
                throw new RuntimeException(outline24.toString());
            }
            this.mEglSurfaceConfig = chooseConfig;
            this.mEglRenderContext = eglCreateContext;
            this.mEglApiVersion = i;
            onChosenConfig();
            return;
        }
        throw new RuntimeException("No config chosen");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dc A[SYNTHETIC, Splitter:B:37:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e8 A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void updateGLStrings() {
        /*
            com.playrix.engine.EglContextManager r0 = mInstance
            boolean r1 = r0.mIsRenderContextCreated
            if (r1 == 0) goto L_0x000b
            fetchStringsFromGL()
            goto L_0x0104
        L_0x000b:
            r1 = 9
            int[] r3 = new int[r1]     // Catch:{ all -> 0x00c2 }
            r1 = 12324(0x3024, float:1.727E-41)
            r10 = 0
            r3[r10] = r1     // Catch:{ all -> 0x00c2 }
            r1 = 8
            r11 = 1
            r3[r11] = r1     // Catch:{ all -> 0x00c2 }
            r2 = 12323(0x3023, float:1.7268E-41)
            r12 = 2
            r3[r12] = r2     // Catch:{ all -> 0x00c2 }
            r13 = 3
            r3[r13] = r1     // Catch:{ all -> 0x00c2 }
            r2 = 12322(0x3022, float:1.7267E-41)
            r14 = 4
            r3[r14] = r2     // Catch:{ all -> 0x00c2 }
            r2 = 5
            r3[r2] = r1     // Catch:{ all -> 0x00c2 }
            r2 = 6
            r4 = 12321(0x3021, float:1.7265E-41)
            r3[r2] = r4     // Catch:{ all -> 0x00c2 }
            r2 = 7
            r3[r2] = r1     // Catch:{ all -> 0x00c2 }
            r15 = 12344(0x3038, float:1.7298E-41)
            r3[r1] = r15     // Catch:{ all -> 0x00c2 }
            android.opengl.EGLConfig[] r1 = new android.opengl.EGLConfig[r11]     // Catch:{ all -> 0x00c2 }
            int[] r8 = new int[r11]     // Catch:{ all -> 0x00c2 }
            android.opengl.EGLDisplay r2 = r0.mEglDisplay     // Catch:{ all -> 0x00c2 }
            r4 = 0
            r6 = 0
            r9 = 0
            r7 = 1
            r0 = 5
            r5 = r1
            boolean r2 = android.opengl.EGL14.eglChooseConfig(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00c2 }
            if (r2 == 0) goto L_0x00ba
            int[] r2 = new int[r13]     // Catch:{ all -> 0x00c2 }
            r3 = 12440(0x3098, float:1.7432E-41)
            r2[r10] = r3     // Catch:{ all -> 0x00c2 }
            r2[r11] = r12     // Catch:{ all -> 0x00c2 }
            r2[r12] = r15     // Catch:{ all -> 0x00c2 }
            com.playrix.engine.EglContextManager r3 = mInstance     // Catch:{ all -> 0x00c2 }
            android.opengl.EGLDisplay r3 = r3.mEglDisplay     // Catch:{ all -> 0x00c2 }
            r4 = r1[r10]     // Catch:{ all -> 0x00c2 }
            android.opengl.EGLContext r5 = android.opengl.EGL14.EGL_NO_CONTEXT     // Catch:{ all -> 0x00c2 }
            android.opengl.EGLContext r2 = android.opengl.EGL14.eglCreateContext(r3, r4, r5, r2, r10)     // Catch:{ all -> 0x00c2 }
            if (r2 == 0) goto L_0x00b2
            android.opengl.EGLContext r3 = android.opengl.EGL14.EGL_NO_CONTEXT     // Catch:{ all -> 0x00b0 }
            if (r2 == r3) goto L_0x00b2
            com.playrix.engine.EglContextManager r3 = mInstance     // Catch:{ all -> 0x00b0 }
            android.opengl.EGLDisplay r3 = r3.mEglDisplay     // Catch:{ all -> 0x00b0 }
            r1 = r1[r10]     // Catch:{ all -> 0x00b0 }
            int[] r0 = new int[r0]     // Catch:{ all -> 0x00b0 }
            r4 = 12375(0x3057, float:1.7341E-41)
            r0[r10] = r4     // Catch:{ all -> 0x00b0 }
            r0[r11] = r11     // Catch:{ all -> 0x00b0 }
            r4 = 12374(0x3056, float:1.734E-41)
            r0[r12] = r4     // Catch:{ all -> 0x00b0 }
            r0[r13] = r11     // Catch:{ all -> 0x00b0 }
            r0[r14] = r15     // Catch:{ all -> 0x00b0 }
            android.opengl.EGLSurface r0 = android.opengl.EGL14.eglCreatePbufferSurface(r3, r1, r0, r10)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a8
            android.opengl.EGLSurface r1 = android.opengl.EGL14.EGL_NO_SURFACE     // Catch:{ all -> 0x00a6 }
            if (r0 == r1) goto L_0x00a8
            com.playrix.engine.EglContextManager r1 = mInstance     // Catch:{ all -> 0x00a6 }
            android.opengl.EGLDisplay r1 = r1.mEglDisplay     // Catch:{ all -> 0x00a6 }
            boolean r1 = android.opengl.EGL14.eglMakeCurrent(r1, r0, r0, r2)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x009e
            fetchStringsFromGL()     // Catch:{ all -> 0x00a6 }
            com.playrix.engine.EglContextManager r1 = mInstance     // Catch:{ all -> 0x00a6 }
            android.opengl.EGLDisplay r1 = r1.mEglDisplay     // Catch:{ all -> 0x00a6 }
            android.opengl.EGLSurface r3 = android.opengl.EGL14.EGL_NO_SURFACE     // Catch:{ all -> 0x00a6 }
            android.opengl.EGLSurface r4 = android.opengl.EGL14.EGL_NO_SURFACE     // Catch:{ all -> 0x00a6 }
            android.opengl.EGLContext r5 = android.opengl.EGL14.EGL_NO_CONTEXT     // Catch:{ all -> 0x00a6 }
            android.opengl.EGL14.eglMakeCurrent(r1, r3, r4, r5)     // Catch:{ all -> 0x00a6 }
            goto L_0x00da
        L_0x009e:
            java.lang.Throwable r1 = new java.lang.Throwable     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = "eglMakeCurrent failed!"
            r1.<init>(r3)     // Catch:{ all -> 0x00a6 }
            throw r1     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r1 = move-exception
            goto L_0x00c6
        L_0x00a8:
            java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = "eglCreatePbufferSurface failed!"
            r0.<init>(r1)     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            goto L_0x00c4
        L_0x00b2:
            java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = "eglCreateContext failed!"
            r0.<init>(r1)     // Catch:{ all -> 0x00c2 }
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00ba:
            java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = "eglChooseConfig failed!"
            r0.<init>(r1)     // Catch:{ all -> 0x00c2 }
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r0 = move-exception
            r2 = 0
        L_0x00c4:
            r1 = r0
            r0 = 0
        L_0x00c6:
            java.lang.String r3 = "Exception in getGlRenderer(): "
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.playrix.engine.Logger.logError(r1)
        L_0x00da:
            if (r0 == 0) goto L_0x00e6
            com.playrix.engine.EglContextManager r1 = mInstance     // Catch:{ all -> 0x00e4 }
            android.opengl.EGLDisplay r1 = r1.mEglDisplay     // Catch:{ all -> 0x00e4 }
            android.opengl.EGL14.eglDestroySurface(r1, r0)     // Catch:{ all -> 0x00e4 }
            goto L_0x00e6
        L_0x00e4:
            r0 = move-exception
            goto L_0x00f0
        L_0x00e6:
            if (r2 == 0) goto L_0x0104
            com.playrix.engine.EglContextManager r0 = mInstance     // Catch:{ all -> 0x00e4 }
            android.opengl.EGLDisplay r0 = r0.mEglDisplay     // Catch:{ all -> 0x00e4 }
            android.opengl.EGL14.eglDestroyContext(r0, r2)     // Catch:{ all -> 0x00e4 }
            goto L_0x0104
        L_0x00f0:
            java.lang.String r1 = "Exception in getGlRenderer() while freeing resources: "
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.playrix.engine.Logger.logError(r0)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.EglContextManager.updateGLStrings():void");
    }

    public void close() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EglContextManager.close(): mAuxContextDatas.size() == ");
        outline24.append(this.mAuxContextDatas.size());
        Logger.logDebug(outline24.toString());
        for (int i = 0; i < this.mAuxContextDatas.size(); i++) {
            releaseAuxContext(this.mAuxContextDatas.get(i));
        }
        this.mAuxContextDatas.clear();
        destroyWindowSurface();
        releaseRenderContext();
        EGLDisplay eGLDisplay = this.mEglDisplay;
        if (eGLDisplay != null) {
            try {
                if (EGL14.eglTerminate(eGLDisplay)) {
                    this.mEglDisplay = null;
                    return;
                }
                throw new RuntimeException("eglTerminate failed " + EGL14.eglGetError());
            } catch (Exception e) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("EglContextManager close failed ");
                outline242.append(e.toString());
                Logger.sysError(outline242.toString());
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createRenderContext() {
        /*
            r10 = this;
            boolean r0 = r10.mIsRenderContextCreated
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = "createRenderContext() error: context already created!"
            com.playrix.engine.Logger.logError(r0)
            return
        L_0x000a:
            com.playrix.engine.EglContextManager$EglSurfaceConfig r0 = r10.mSurfaceConfig
            if (r0 != 0) goto L_0x0062
            int r0 = r10.mRequestedMainSurfaceDepthBits
            int r8 = r10.mRequestedMainSurfaceStencilBits
            com.playrix.engine.EglContextManager$EglSurfaceConfig r9 = new com.playrix.engine.EglContextManager$EglSurfaceConfig
            r2 = 8
            r3 = 8
            r4 = 8
            r5 = 8
            r1 = r9
            r6 = r0
            r7 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r10.mSurfaceConfig = r9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "createRenderContext(): surface config is: r="
            r1.append(r2)
            r2 = 8
            r1.append(r2)
            java.lang.String r3 = ",g="
            r1.append(r3)
            r1.append(r2)
            java.lang.String r3 = ",b="
            r1.append(r3)
            r1.append(r2)
            java.lang.String r3 = ",alpha="
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = ",depth="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ",stencil="
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = r1.toString()
            com.playrix.engine.Logger.logDebug(r0)
        L_0x0062:
            r0 = 64
            r1 = 4
            r2 = 2
            r3 = 3
            r10.tryCreateContext(r3, r0)     // Catch:{ Exception -> 0x006b }
            goto L_0x006e
        L_0x006b:
            r10.tryCreateContext(r2, r1)     // Catch:{ Exception -> 0x00c8 }
        L_0x006e:
            android.opengl.EGLDisplay r0 = r10.mEglDisplay     // Catch:{ Exception -> 0x00c8 }
            android.opengl.EGLConfig r4 = r10.mEglSurfaceConfig     // Catch:{ Exception -> 0x00c8 }
            r5 = 5
            int[] r5 = new int[r5]     // Catch:{ Exception -> 0x00c8 }
            r6 = 12375(0x3057, float:1.7341E-41)
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x00c8 }
            r6 = 1
            r5[r6] = r6     // Catch:{ Exception -> 0x00c8 }
            r8 = 12374(0x3056, float:1.734E-41)
            r5[r2] = r8     // Catch:{ Exception -> 0x00c8 }
            r5[r3] = r6     // Catch:{ Exception -> 0x00c8 }
            r2 = 12344(0x3038, float:1.7298E-41)
            r5[r1] = r2     // Catch:{ Exception -> 0x00c8 }
            android.opengl.EGLSurface r0 = android.opengl.EGL14.eglCreatePbufferSurface(r0, r4, r5, r7)     // Catch:{ Exception -> 0x00c8 }
            r10.mEglStubSurface = r0     // Catch:{ Exception -> 0x00c8 }
            if (r0 == 0) goto L_0x00bd
            android.opengl.EGLSurface r1 = android.opengl.EGL14.EGL_NO_SURFACE     // Catch:{ Exception -> 0x00c8 }
            if (r0 == r1) goto L_0x00bd
            android.opengl.EGLDisplay r1 = r10.mEglDisplay     // Catch:{ Exception -> 0x00c8 }
            android.opengl.EGLContext r2 = r10.mEglRenderContext     // Catch:{ Exception -> 0x00c8 }
            boolean r0 = android.opengl.EGL14.eglMakeCurrent(r1, r0, r0, r2)     // Catch:{ Exception -> 0x00c8 }
            if (r0 == 0) goto L_0x00a2
            r10.mIsRenderContextCreated = r6     // Catch:{ Exception -> 0x00c8 }
            r10.mNotifyContextCreated = r6     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00e0
        L_0x00a2:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x00c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c8 }
            r1.<init>()     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r2 = "eglMakeCurrent stub failed "
            r1.append(r2)     // Catch:{ Exception -> 0x00c8 }
            int r2 = android.opengl.EGL14.eglGetError()     // Catch:{ Exception -> 0x00c8 }
            r1.append(r2)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00c8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00c8 }
            throw r0     // Catch:{ Exception -> 0x00c8 }
        L_0x00bd:
            r0 = 0
            r10.mEglStubSurface = r0     // Catch:{ Exception -> 0x00c8 }
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r1 = "no stub surface"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00c8 }
            throw r0     // Catch:{ Exception -> 0x00c8 }
        L_0x00c8:
            r0 = move-exception
            java.lang.String r1 = "EglContextManager create failed "
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.playrix.engine.Logger.sysError(r0)
            r10.releaseRenderContext()
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.EglContextManager.createRenderContext():void");
    }

    public void destroyWindowSurface() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("destroyWindowSurface(): mIsRenderContextCreated = ");
        outline24.append(this.mIsRenderContextCreated);
        outline24.append(", mEglSurface = ");
        outline24.append(this.mEglSurface);
        Logger.logDebug(outline24.toString());
        if (this.mIsRenderContextCreated && this.mEglSurface != null) {
            try {
                if (EGL14.eglMakeCurrent(this.mEglDisplay, this.mEglStubSurface, this.mEglStubSurface, this.mEglRenderContext)) {
                    destroySurface(this.mEglSurface, "render");
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglMakeCurrent stub failed " + EGL14.eglGetError());
            } catch (Exception e) {
                Logger.logError(e.toString());
            }
        }
    }

    public boolean draw(Object obj, boolean z, int i, int i2, Renderer renderer) {
        boolean z2;
        int eglGetError;
        if (!this.mIsRenderContextCreated) {
            return false;
        }
        if (this.mEglSurface == null || z) {
            createWindowSurface(obj);
            if (this.mEglSurface == null) {
                return false;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.mNotifyContextCreated) {
            if (renderer != null) {
                renderer.onContextCreated(this.mEglSurfaceConfig);
            }
            this.mNotifyContextCreated = false;
        }
        if (z2 && renderer != null) {
            renderer.onSurfaceChanged(i, i2);
        }
        if (renderer != null) {
            renderer.onDrawFrame();
        }
        if (!EGL14.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) && (eglGetError = EGL14.eglGetError()) != 12288) {
            if (eglGetError == 12301 || eglGetError == 12302) {
                onLostRenderContext();
            } else {
                Logger.sysWarning("eglSwapBuffers failed " + eglGetError);
                return false;
            }
        }
        return true;
    }

    public void initDisplay() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("eglInitialize: version: ");
                outline24.append(iArr[0]);
                outline24.append(CodelessMatcher.CURRENT_CLASS_NAME);
                outline24.append(iArr[1]);
                Logger.logDebug(outline24.toString());
                return;
            }
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("eglInitialize failed ");
            outline242.append(EGL14.eglGetError());
            throw new RuntimeException(outline242.toString());
        }
        StringBuilder outline243 = GeneratedOutlineSupport.outline24("eglGetDisplay failed ");
        outline243.append(EGL14.eglGetError());
        throw new RuntimeException(outline243.toString());
    }

    public boolean isRenderContextCreated() {
        return this.mIsRenderContextCreated;
    }

    public void onLostRenderContext() {
        destroyWindowSurface();
        releaseRenderContext();
        createRenderContext();
    }

    public void swapBuffersInternal() {
        EGLSurface eGLSurface = this.mEglSurface;
        if (eGLSurface == null) {
            Logger.logError("swapBuffersInternal() trying to swap when mEglSurface == null!");
        } else if (!EGL14.eglSwapBuffers(this.mEglDisplay, eGLSurface)) {
            int eglGetError = EGL14.eglGetError();
            Logger.logError("swapBuffersInternal() EGL error: " + eglGetError);
        }
    }

    public static EGLConfig chooseConfig(EglSurfaceConfig eglSurfaceConfig, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        EGLConfig eGLConfig = null;
        int i = 0;
        for (EGLConfig eGLConfig2 : eGLConfigArr) {
            int scoreConfig = scoreConfig(eglSurfaceConfig, eGLDisplay, eGLConfig2);
            if (scoreConfig > i || eGLConfig == null) {
                eGLConfig = eGLConfig2;
                i = scoreConfig;
            }
        }
        return eGLConfig;
    }
}
