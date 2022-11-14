package com.playrix.engine;

import android.opengl.EGLConfig;
import com.playrix.engine.EglContextManager;
import java.util.UUID;

public class Renderer implements EglContextManager.Renderer {
    public UUID blockerId = null;
    public boolean init = false;
    public int surfaceHeight = 0;
    public int surfaceWidth = 0;

    public void onContextCreated(EGLConfig eGLConfig) {
        this.surfaceWidth = 0;
        this.surfaceHeight = 0;
        this.init = true;
    }

    public void onDrawFrame() {
        if (this.surfaceWidth != 0 && this.surfaceHeight != 0) {
            if (!this.init) {
                UUID uuid = this.blockerId;
                if (uuid != null) {
                    BlockingManager.unblock(uuid);
                    this.blockerId = null;
                }
            } else if (this.blockerId == null) {
                this.blockerId = BlockingManager.block();
            }
            if (this.init) {
                Engine.nativeOnCreate();
                this.init = false;
            }
            Engine.nativeRender();
        }
    }

    public void onSurfaceChanged(int i, int i2) {
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        if (i != 0 && i2 != 0) {
            Engine.nativeResize(i, i2);
        }
    }
}
