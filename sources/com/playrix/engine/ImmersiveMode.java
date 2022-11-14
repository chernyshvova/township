package com.playrix.engine;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import com.facebook.LegacyTokenHelper;
import java.lang.ref.WeakReference;
import java.util.HashSet;

@TargetApi(19)
public class ImmersiveMode {
    public static final State state = new State();

    public static class State {
        public WeakReference<Activity> activity;
        public Handler handler;
        public boolean isApplicationInImmersiveMode;
        public boolean isInitialized;
        public int normalDecorFlags;
        public int normalVisibleInsets;
        public final HashSet<Dialog> shownDialogs;

        public State() {
            this.activity = null;
            this.handler = null;
            this.isApplicationInImmersiveMode = false;
            this.isInitialized = false;
            this.normalDecorFlags = 0;
            this.normalVisibleInsets = 0;
            this.shownDialogs = new HashSet<>();
        }

        private synchronized void appendDialog(Dialog dialog, final DialogInterface.OnDismissListener onDismissListener) {
            if (!this.shownDialogs.contains(dialog)) {
                this.shownDialogs.add(dialog);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        DialogInterface.OnDismissListener onDismissListener = onDismissListener;
                        if (onDismissListener != null) {
                            onDismissListener.onDismiss(dialogInterface);
                        }
                        ImmersiveMode.state.removeDialog(dialogInterface);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public synchronized boolean initialize() {
            if (this.isInitialized) {
                return true;
            }
            Activity activity2 = getActivity();
            if (activity2 == null) {
                return false;
            }
            try {
                Window window = activity2.getWindow();
                View decorView = window.getDecorView();
                if (Build.VERSION.SDK_INT < 30) {
                    decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                        public void onSystemUiVisibilityChange(int i) {
                            ImmersiveMode.state.restoreTransparentBars();
                        }
                    });
                    decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View view, boolean z) {
                            ImmersiveMode.state.restoreTransparentBars();
                        }
                    });
                    this.normalDecorFlags = decorView.getSystemUiVisibility();
                } else if (window.getInsetsController() == null) {
                    Logger.logError("Error initialize immersive mode - null insets controller");
                    return false;
                } else {
                    WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                    if (rootWindowInsets != null) {
                        this.normalVisibleInsets = (rootWindowInsets.isVisible(WindowInsets.Type.captionBar()) ? WindowInsets.Type.captionBar() : 0) | (rootWindowInsets.isVisible(WindowInsets.Type.statusBars()) ? WindowInsets.Type.statusBars() : 0) | (rootWindowInsets.isVisible(WindowInsets.Type.navigationBars()) ? WindowInsets.Type.navigationBars() : 0);
                    }
                }
                this.isInitialized = true;
                return true;
            } catch (Exception e) {
                Logger.logError("Error initialize immersive mode " + e.toString());
                return false;
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void restoreTransparentBars() {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.isApplicationInImmersiveMode     // Catch:{ all -> 0x0052 }
                if (r0 == 0) goto L_0x0050
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0052 }
                r1 = 30
                if (r0 < r1) goto L_0x000c
                goto L_0x0050
            L_0x000c:
                android.app.Activity r0 = r3.getActivity()     // Catch:{ all -> 0x0052 }
                if (r0 != 0) goto L_0x0014
                monitor-exit(r3)
                return
            L_0x0014:
                android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x0035 }
                r3.restoreTransparentBarsWindow(r0)     // Catch:{ Exception -> 0x0035 }
                java.util.HashSet<android.app.Dialog> r0 = r3.shownDialogs     // Catch:{ Exception -> 0x0035 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0035 }
            L_0x0021:
                boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0035 }
                if (r1 == 0) goto L_0x004e
                java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0035 }
                android.app.Dialog r1 = (android.app.Dialog) r1     // Catch:{ Exception -> 0x0035 }
                android.view.Window r1 = r1.getWindow()     // Catch:{ Exception -> 0x0035 }
                r3.restoreTransparentBarsWindow(r1)     // Catch:{ Exception -> 0x0035 }
                goto L_0x0021
            L_0x0035:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
                r1.<init>()     // Catch:{ all -> 0x0052 }
                java.lang.String r2 = "Error restore immersive mode "
                r1.append(r2)     // Catch:{ all -> 0x0052 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0052 }
                r1.append(r0)     // Catch:{ all -> 0x0052 }
                java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0052 }
                com.playrix.engine.Logger.logError(r0)     // Catch:{ all -> 0x0052 }
            L_0x004e:
                monitor-exit(r3)
                return
            L_0x0050:
                monitor-exit(r3)
                return
            L_0x0052:
                r0 = move-exception
                monitor-exit(r3)
                goto L_0x0056
            L_0x0055:
                throw r0
            L_0x0056:
                goto L_0x0055
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.ImmersiveMode.State.restoreTransparentBars():void");
        }

        private synchronized void restoreTransparentBarsWindow(Window window) {
            if (Build.VERSION.SDK_INT < 30) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(this.normalDecorFlags | (ImmersiveMode.immersiveDecorFlags() & -4097));
                decorView.setSystemUiVisibility(this.normalDecorFlags | ImmersiveMode.immersiveDecorFlags());
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void setFocusChangedWindow() {
            /*
                r5 = this;
                monitor-enter(r5)
                boolean r0 = r5.isApplicationInImmersiveMode     // Catch:{ all -> 0x0036 }
                if (r0 == 0) goto L_0x0034
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0036 }
                r1 = 30
                if (r0 < r1) goto L_0x000c
                goto L_0x0034
            L_0x000c:
                android.app.Activity r0 = r5.getActivity()     // Catch:{ all -> 0x0036 }
                if (r0 != 0) goto L_0x0014
                monitor-exit(r5)
                return
            L_0x0014:
                android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0036 }
                r1 = 8
                r0.addFlags(r1)     // Catch:{ all -> 0x0036 }
                android.view.View r2 = r0.getDecorView()     // Catch:{ all -> 0x0036 }
                int r3 = r5.normalDecorFlags     // Catch:{ all -> 0x0036 }
                int r4 = com.playrix.engine.ImmersiveMode.immersiveDecorFlags()     // Catch:{ all -> 0x0036 }
                r3 = r3 | r4
                r3 = r3 | 1024(0x400, float:1.435E-42)
                r3 = r3 | 4
                r2.setSystemUiVisibility(r3)     // Catch:{ all -> 0x0036 }
                r0.clearFlags(r1)     // Catch:{ all -> 0x0036 }
                monitor-exit(r5)
                return
            L_0x0034:
                monitor-exit(r5)
                return
            L_0x0036:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.ImmersiveMode.State.setFocusChangedWindow():void");
        }

        /* access modifiers changed from: private */
        public synchronized void switchImmersiveMode() {
            Activity activity2 = getActivity();
            if (activity2 != null) {
                try {
                    Window window = activity2.getWindow();
                    if (this.isApplicationInImmersiveMode) {
                        window.addFlags(ImmersiveMode.layoutFlags());
                        if (Build.VERSION.SDK_INT < 30) {
                            window.getDecorView().setSystemUiVisibility(this.normalDecorFlags | ImmersiveMode.immersiveDecorFlags());
                        } else {
                            WindowInsetsController insetsController = window.getInsetsController();
                            if (insetsController != null) {
                                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar());
                            }
                        }
                    } else {
                        window.clearFlags(ImmersiveMode.layoutFlags());
                        if (Build.VERSION.SDK_INT < 30) {
                            window.getDecorView().setSystemUiVisibility(this.normalDecorFlags);
                        } else {
                            WindowInsetsController insetsController2 = window.getInsetsController();
                            if (insetsController2 != null) {
                                insetsController2.show(this.normalVisibleInsets);
                            }
                        }
                    }
                } catch (Exception e) {
                    Logger.logError("Error switch immersive mode " + e.toString());
                }
            } else {
                return;
            }
        }

        public synchronized Activity getActivity() {
            return this.activity != null ? (Activity) this.activity.get() : null;
        }

        public synchronized boolean isImmersiveModeEnabled() {
            return this.isApplicationInImmersiveMode;
        }

        public synchronized void onCreateActivity(Activity activity2) {
            this.activity = new WeakReference<>(activity2);
            this.handler = new Handler(Looper.getMainLooper());
        }

        public synchronized void removeDialog(DialogInterface dialogInterface) {
            if (this.shownDialogs.contains(dialogInterface)) {
                this.shownDialogs.remove(dialogInterface);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void restoreTranslucentBarsDelayed() {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r4.isApplicationInImmersiveMode     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x0021
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0023 }
                r1 = 30
                if (r0 < r1) goto L_0x000c
                goto L_0x0021
            L_0x000c:
                r4.restoreTransparentBars()     // Catch:{ all -> 0x0023 }
                android.os.Handler r0 = r4.handler     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x001f
                android.os.Handler r0 = r4.handler     // Catch:{ all -> 0x0023 }
                com.playrix.engine.ImmersiveMode$State$5 r1 = new com.playrix.engine.ImmersiveMode$State$5     // Catch:{ all -> 0x0023 }
                r1.<init>()     // Catch:{ all -> 0x0023 }
                r2 = 500(0x1f4, double:2.47E-321)
                r0.postDelayed(r1, r2)     // Catch:{ all -> 0x0023 }
            L_0x001f:
                monitor-exit(r4)
                return
            L_0x0021:
                monitor-exit(r4)
                return
            L_0x0023:
                r0 = move-exception
                monitor-exit(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.ImmersiveMode.State.restoreTranslucentBarsDelayed():void");
        }

        public synchronized void setFocusChangedWindowDelayed() {
            if (this.isApplicationInImmersiveMode && this.handler != null) {
                try {
                    setFocusChangedWindow();
                    this.handler.postDelayed(new Runnable() {
                        public void run() {
                            State.this.setFocusChangedWindow();
                        }
                    }, 2000);
                } catch (Exception e) {
                    Logger.logError("Error focus set immersive mode " + e.toString());
                }
            }
            return;
        }

        public synchronized void setImmersiveMode(boolean z) {
            if (z != this.isApplicationInImmersiveMode) {
                if (ImmersiveMode.isAvailable()) {
                    this.isApplicationInImmersiveMode = z;
                    Advertising.getInstance().setImmersiveMode(z);
                    Activity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.runOnUiThread(new Runnable() {
                            public void run() {
                                if (State.this.initialize()) {
                                    State.this.switchImmersiveMode();
                                }
                            }
                        });
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void showDialog(android.app.Dialog r4, android.content.DialogInterface.OnDismissListener r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                if (r4 != 0) goto L_0x0005
                monitor-exit(r3)
                return
            L_0x0005:
                boolean r0 = r3.initialize()     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x000e
                r3.appendDialog(r4, r5)     // Catch:{ all -> 0x005f }
            L_0x000e:
                boolean r5 = r3.isApplicationInImmersiveMode     // Catch:{ all -> 0x005f }
                if (r5 != 0) goto L_0x0016
                r4.show()     // Catch:{ all -> 0x005f }
                goto L_0x005d
            L_0x0016:
                android.view.Window r5 = r4.getWindow()     // Catch:{ all -> 0x005f }
                r0 = 8
                r5.addFlags(r0)     // Catch:{ all -> 0x005f }
                r4.show()     // Catch:{ all -> 0x005f }
                int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005f }
                r1 = 30
                if (r5 >= r1) goto L_0x003b
                android.view.Window r5 = r4.getWindow()     // Catch:{ all -> 0x005f }
                android.view.View r5 = r5.getDecorView()     // Catch:{ all -> 0x005f }
                int r1 = r3.normalDecorFlags     // Catch:{ all -> 0x005f }
                int r2 = com.playrix.engine.ImmersiveMode.immersiveDecorFlags()     // Catch:{ all -> 0x005f }
                r1 = r1 | r2
                r5.setSystemUiVisibility(r1)     // Catch:{ all -> 0x005f }
                goto L_0x0056
            L_0x003b:
                android.view.Window r5 = r4.getWindow()     // Catch:{ all -> 0x005f }
                android.view.WindowInsetsController r5 = r5.getInsetsController()     // Catch:{ all -> 0x005f }
                if (r5 == 0) goto L_0x0056
                int r1 = android.view.WindowInsets.Type.statusBars()     // Catch:{ all -> 0x005f }
                int r2 = android.view.WindowInsets.Type.navigationBars()     // Catch:{ all -> 0x005f }
                r1 = r1 | r2
                int r2 = android.view.WindowInsets.Type.captionBar()     // Catch:{ all -> 0x005f }
                r1 = r1 | r2
                r5.hide(r1)     // Catch:{ all -> 0x005f }
            L_0x0056:
                android.view.Window r4 = r4.getWindow()     // Catch:{ all -> 0x005f }
                r4.clearFlags(r0)     // Catch:{ all -> 0x005f }
            L_0x005d:
                monitor-exit(r3)
                return
            L_0x005f:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.ImmersiveMode.State.showDialog(android.app.Dialog, android.content.DialogInterface$OnDismissListener):void");
        }
    }

    public static void enable(boolean z) {
        state.setImmersiveMode(z);
    }

    public static int immersiveDecorFlags() {
        return 4866;
    }

    public static boolean isAvailable() {
        int identifier;
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return true;
            }
            Activity activity = state.getActivity();
            if (activity == null || (identifier = activity.getResources().getIdentifier("config_enableTranslucentDecor", LegacyTokenHelper.TYPE_BOOLEAN, "android")) == 0) {
                return false;
            }
            return activity.getResources().getBoolean(identifier);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isEnabled() {
        return state.isImmersiveModeEnabled();
    }

    public static int layoutFlags() {
        return 201326592;
    }

    public static void onCreate(Activity activity) {
        state.onCreateActivity(activity);
    }

    public static void onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 25 || i == 24) {
            state.restoreTranslucentBarsDelayed();
        }
    }

    public static void onResume() {
        state.restoreTransparentBars();
    }

    public static void onWindowFocusChanged(boolean z) {
        if (z) {
            state.setFocusChangedWindowDelayed();
        }
    }

    public static void showDialog(Dialog dialog) {
        state.showDialog(dialog, (DialogInterface.OnDismissListener) null);
    }

    public static void showDialog(Dialog dialog, DialogInterface.OnDismissListener onDismissListener) {
        state.showDialog(dialog, onDismissListener);
    }
}
