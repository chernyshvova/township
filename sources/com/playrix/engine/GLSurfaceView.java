package com.playrix.engine;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

public class GLSurfaceView extends GLSurfaceViewV17 {
    public static final int FINGER_NOT_SET_ID = -1;
    public static boolean mDeliverTouchEvents;
    public boolean isTouched = false;
    public final MultiFingerDoubleTapDetector mDoubleTap2Detector;
    public final MultiFingerDoubleTapDetector mDoubleTap3Detector;
    public final ScaleGestureDetector mScaleDetector;
    public int mainFingerId = -1;

    public static class MultiFingerDoubleTapDetector {
        public final int TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        public final int[] mActivePointerIds;
        public int mActivePointerIdsCount = 0;
        public boolean mDetectedTap = false;
        public final int mFingers;
        public long mFirstDownTime = 0;
        public int mTapCount = 0;

        public MultiFingerDoubleTapDetector(int i) {
            this.mFingers = i;
            this.mActivePointerIds = new int[i];
        }

        private boolean appendActionPointer(int i) {
            if (this.mActivePointerIdsCount == this.mFingers) {
                return false;
            }
            int i2 = 0;
            while (true) {
                int i3 = this.mActivePointerIdsCount;
                if (i2 >= i3) {
                    int[] iArr = this.mActivePointerIds;
                    this.mActivePointerIdsCount = i3 + 1;
                    iArr[i3] = i;
                    return true;
                } else if (this.mActivePointerIds[i2] == i) {
                    return false;
                } else {
                    i2++;
                }
            }
        }

        private void onDoubleTap() {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeMultiFingerDoubleTap(MultiFingerDoubleTapDetector.this.mFingers);
                }
            });
        }

        private boolean removeActionPointer(int i) {
            int i2 = 0;
            while (true) {
                int i3 = this.mActivePointerIdsCount;
                if (i2 >= i3) {
                    return false;
                }
                int[] iArr = this.mActivePointerIds;
                if (iArr[i2] == i) {
                    int i4 = i3 - 1;
                    this.mActivePointerIdsCount = i4;
                    iArr[i2] = iArr[i4];
                    return true;
                }
                i2++;
            }
        }

        public void onTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            boolean z = true;
            if (actionMasked == 0) {
                this.mActivePointerIdsCount = 0;
                if (motionEvent.getPointerCount() != 1 || !appendActionPointer(motionEvent.getPointerId(0))) {
                    z = false;
                }
                if (z) {
                    if (this.mFirstDownTime == 0 || motionEvent.getEventTime() - this.mFirstDownTime >= ((long) this.TIMEOUT)) {
                        this.mFirstDownTime = motionEvent.getDownTime();
                        this.mTapCount = 0;
                    }
                    this.mDetectedTap = false;
                    return;
                }
                this.mFirstDownTime = 0;
            } else if (actionMasked != 1) {
                if (actionMasked == 3) {
                    this.mFirstDownTime = 0;
                } else if (actionMasked != 5) {
                    if (actionMasked == 6) {
                        if (this.mActivePointerIdsCount == this.mFingers) {
                            this.mDetectedTap = true;
                        }
                        if (!removeActionPointer(motionEvent.getPointerId(motionEvent.getActionIndex()))) {
                            this.mFirstDownTime = 0;
                        }
                    }
                } else if (!appendActionPointer(motionEvent.getPointerId(motionEvent.getActionIndex()))) {
                    this.mFirstDownTime = 0;
                    this.mDetectedTap = false;
                }
            } else if (this.mDetectedTap) {
                int i = this.mTapCount + 1;
                this.mTapCount = i;
                if (i == 2 && motionEvent.getEventTime() - this.mFirstDownTime < ((long) this.TIMEOUT)) {
                    this.mFirstDownTime = 0;
                    onDoubleTap();
                }
            } else {
                this.mFirstDownTime = 0;
            }
        }
    }

    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            final float scaleFactor = scaleGestureDetector.getScaleFactor();
            final float focusX = scaleGestureDetector.getFocusX();
            final float focusY = scaleGestureDetector.getFocusY();
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeScale((int) (GLSurfaceView.this.getResolutionScaleW() * focusX), (int) (GLSurfaceView.this.getResolutionScaleH() * focusY), scaleFactor);
                }
            });
            return super.onScale(scaleGestureDetector);
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            final float scaleFactor = scaleGestureDetector.getScaleFactor();
            final float focusX = scaleGestureDetector.getFocusX();
            final float focusY = scaleGestureDetector.getFocusY();
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeScaleBegin((int) (GLSurfaceView.this.getResolutionScaleW() * focusX), (int) (GLSurfaceView.this.getResolutionScaleH() * focusY), scaleFactor);
                }
            });
            return super.onScaleBegin(scaleGestureDetector);
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeScaleEnd();
                }
            });
            super.onScaleEnd(scaleGestureDetector);
        }
    }

    public GLSurfaceView(Context context) {
        super(context);
        setRenderer(new Renderer());
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.mDoubleTap2Detector = new MultiFingerDoubleTapDetector(2);
        this.mDoubleTap3Detector = new MultiFingerDoubleTapDetector(3);
        mDeliverTouchEvents = true;
    }

    private void onMainFingerDown(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            this.mainFingerId = motionEvent.getPointerId(0);
            sendNativeTouch(0, motionEvent);
        }
    }

    private void onMainFingerMove(MotionEvent motionEvent) {
        sendNativeTouch(2, motionEvent);
    }

    private void onMainFingerReset() {
        if (this.mainFingerId != -1) {
            this.mainFingerId = -1;
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeCancelMouse();
                }
            });
        }
    }

    private void onMainFingerUp(MotionEvent motionEvent) {
        sendNativeTouch(1, motionEvent);
        this.mainFingerId = -1;
    }

    private void sendNativeTouch(final int i, MotionEvent motionEvent) {
        int findPointerIndex;
        int i2 = this.mainFingerId;
        if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
            final int x = (int) motionEvent.getX(findPointerIndex);
            final int y = (int) motionEvent.getY(findPointerIndex);
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeTouch(i, (int) (GLSurfaceView.this.getResolutionScaleW() * ((float) x)), (int) (GLSurfaceView.this.getResolutionScaleH() * ((float) y)));
                }
            });
        }
    }

    public static void setDeliverTouchEvents(boolean z) {
        mDeliverTouchEvents = z;
    }

    public boolean isTouchInProgress() {
        return this.isTouched;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            final float axisValue = motionEvent.getAxisValue(9);
            Engine.runOnGLThread(new Runnable() {
                public void run() {
                    Engine.nativeMouseWheel((int) axisValue);
                }
            });
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        this.isTouched = false;
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (mDeliverTouchEvents) {
            int pointerCount = motionEvent.getPointerCount();
            int action = motionEvent.getAction() & 255;
            if ((pointerCount == 1 && (action == 0 || action == 1 || action == 3)) || action == 6 || pointerCount > 1) {
                try {
                    this.mScaleDetector.onTouchEvent(motionEvent);
                    this.mDoubleTap2Detector.onTouchEvent(motionEvent);
                    this.mDoubleTap3Detector.onTouchEvent(motionEvent);
                } catch (Exception unused) {
                }
            }
            if (action == 0) {
                onMainFingerDown(motionEvent);
                this.isTouched = true;
            } else if (action == 5) {
                onMainFingerReset();
            } else if (action == 1) {
                onMainFingerUp(motionEvent);
                this.isTouched = false;
            } else if (action == 3) {
                onMainFingerReset();
                this.isTouched = false;
            } else if (action == 2) {
                onMainFingerMove(motionEvent);
            }
        }
        return true;
    }

    public void resetTouchInProgress() {
        this.isTouched = false;
    }
}
