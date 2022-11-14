package com.playrix.gplay;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.playrix.engine.Logger;
import java.util.HashMap;

public class Achievements {
    public final HashMap<String, Integer> achievements = new HashMap<>();
    public AchievementsClient achievementsClient = null;
    public final Activity activity;

    public Achievements(Activity activity2) {
        this.activity = activity2;
    }

    private synchronized void loadAchievements() {
        if (this.achievementsClient != null) {
            this.achievementsClient.load(false).addOnCompleteListener(new OnCompleteListener<AnnotatedData<AchievementBuffer>>() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.google.android.gms.tasks.Task<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.achievement.AchievementBuffer>>} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: com.google.android.gms.tasks.Task<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.achievement.AchievementBuffer>>} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: com.google.android.gms.games.achievement.AchievementBuffer} */
                /* JADX WARNING: type inference failed for: r7v1, types: [com.google.android.gms.common.data.AbstractDataBuffer] */
                /* JADX WARNING: type inference failed for: r7v11 */
                /* JADX WARNING: type inference failed for: r7v17 */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[Catch:{ ApiException -> 0x0078, Exception -> 0x0059, all -> 0x0054, all -> 0x009a }] */
                /* JADX WARNING: Removed duplicated region for block: B:42:0x009d  */
                /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onComplete(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.achievement.AchievementBuffer>> r7) {
                    /*
                        r6 = this;
                        r0 = 0
                        java.lang.Class<com.google.android.gms.common.api.ApiException> r1 = com.google.android.gms.common.api.ApiException.class
                        java.lang.Object r7 = r7.getResult(r1)     // Catch:{ ApiException -> 0x0078, Exception -> 0x0059, all -> 0x0054 }
                        com.google.android.gms.games.AnnotatedData r7 = (com.google.android.gms.games.AnnotatedData) r7     // Catch:{ ApiException -> 0x0078, Exception -> 0x0059, all -> 0x0054 }
                        if (r7 != 0) goto L_0x000c
                        return
                    L_0x000c:
                        java.lang.Object r7 = r7.get()     // Catch:{ ApiException -> 0x0078, Exception -> 0x0059, all -> 0x0054 }
                        com.google.android.gms.games.achievement.AchievementBuffer r7 = (com.google.android.gms.games.achievement.AchievementBuffer) r7     // Catch:{ ApiException -> 0x0078, Exception -> 0x0059, all -> 0x0054 }
                        if (r7 != 0) goto L_0x001a
                        if (r7 == 0) goto L_0x0019
                        r7.release()
                    L_0x0019:
                        return
                    L_0x001a:
                        com.playrix.gplay.Achievements r0 = com.playrix.gplay.Achievements.this     // Catch:{ ApiException -> 0x0052, Exception -> 0x0050 }
                        monitor-enter(r0)     // Catch:{ ApiException -> 0x0052, Exception -> 0x0050 }
                        java.util.Iterator r1 = r7.iterator()     // Catch:{ all -> 0x004d }
                    L_0x0021:
                        boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004d }
                        if (r2 == 0) goto L_0x0043
                        java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004d }
                        com.google.android.gms.games.achievement.Achievement r2 = (com.google.android.gms.games.achievement.Achievement) r2     // Catch:{ all -> 0x004d }
                        com.playrix.gplay.Achievements r3 = com.playrix.gplay.Achievements.this     // Catch:{ all -> 0x004d }
                        java.util.HashMap r3 = r3.achievements     // Catch:{ all -> 0x004d }
                        java.lang.String r4 = r2.getAchievementId()     // Catch:{ all -> 0x004d }
                        int r2 = r2.getType()     // Catch:{ all -> 0x004d }
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x004d }
                        r3.put(r4, r2)     // Catch:{ all -> 0x004d }
                        goto L_0x0021
                    L_0x0043:
                        monitor-exit(r0)     // Catch:{ all -> 0x004d }
                        com.playrix.gplay.Achievements$2$1 r0 = new com.playrix.gplay.Achievements$2$1     // Catch:{ ApiException -> 0x0052, Exception -> 0x0050 }
                        r0.<init>()     // Catch:{ ApiException -> 0x0052, Exception -> 0x0050 }
                        com.playrix.engine.Engine.runOnGLThread(r0)     // Catch:{ ApiException -> 0x0052, Exception -> 0x0050 }
                        goto L_0x0096
                    L_0x004d:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x004d }
                        throw r1     // Catch:{ ApiException -> 0x0052, Exception -> 0x0050 }
                    L_0x0050:
                        r0 = move-exception
                        goto L_0x005d
                    L_0x0052:
                        r0 = move-exception
                        goto L_0x007c
                    L_0x0054:
                        r7 = move-exception
                        r5 = r0
                        r0 = r7
                        r7 = r5
                        goto L_0x009b
                    L_0x0059:
                        r7 = move-exception
                        r5 = r0
                        r0 = r7
                        r7 = r5
                    L_0x005d:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
                        r1.<init>()     // Catch:{ all -> 0x009a }
                        java.lang.String r2 = "GoogleGameCenter: loadAchievements failed:"
                        r1.append(r2)     // Catch:{ all -> 0x009a }
                        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009a }
                        r1.append(r0)     // Catch:{ all -> 0x009a }
                        java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x009a }
                        com.playrix.engine.Logger.logError(r0)     // Catch:{ all -> 0x009a }
                        if (r7 == 0) goto L_0x0099
                        goto L_0x0096
                    L_0x0078:
                        r7 = move-exception
                        r5 = r0
                        r0 = r7
                        r7 = r5
                    L_0x007c:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
                        r1.<init>()     // Catch:{ all -> 0x009a }
                        java.lang.String r2 = "GoogleGameCenter: loadAchievements failed:"
                        r1.append(r2)     // Catch:{ all -> 0x009a }
                        int r0 = r0.getStatusCode()     // Catch:{ all -> 0x009a }
                        r1.append(r0)     // Catch:{ all -> 0x009a }
                        java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x009a }
                        com.playrix.engine.Logger.logError(r0)     // Catch:{ all -> 0x009a }
                        if (r7 == 0) goto L_0x0099
                    L_0x0096:
                        r7.release()
                    L_0x0099:
                        return
                    L_0x009a:
                        r0 = move-exception
                    L_0x009b:
                        if (r7 == 0) goto L_0x00a0
                        r7.release()
                    L_0x00a0:
                        goto L_0x00a2
                    L_0x00a1:
                        throw r0
                    L_0x00a2:
                        goto L_0x00a1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.playrix.gplay.Achievements.C32772.onComplete(com.google.android.gms.tasks.Task):void");
                }
            });
        }
    }

    public synchronized void clear() {
        this.achievementsClient = null;
        this.achievements.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setAchievementProgress(java.lang.String r3, float r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.games.AchievementsClient r0 = r2.achievementsClient     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r2.achievements     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x002e }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0013
            monitor-exit(r2)
            return
        L_0x0013:
            int r0 = r0.intValue()     // Catch:{ all -> 0x002e }
            r1 = 1
            if (r0 != r1) goto L_0x0027
            r0 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r0
            int r4 = (int) r4     // Catch:{ all -> 0x002e }
            if (r4 <= 0) goto L_0x002c
            com.google.android.gms.games.AchievementsClient r0 = r2.achievementsClient     // Catch:{ all -> 0x002e }
            r0.setSteps(r3, r4)     // Catch:{ all -> 0x002e }
            goto L_0x002c
        L_0x0027:
            com.google.android.gms.games.AchievementsClient r4 = r2.achievementsClient     // Catch:{ all -> 0x002e }
            r4.unlock(r3)     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r2)
            return
        L_0x002e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.gplay.Achievements.setAchievementProgress(java.lang.String, float):void");
    }

    public synchronized void setClient(AchievementsClient achievementsClient2) {
        this.achievementsClient = achievementsClient2;
        loadAchievements();
    }

    public synchronized void showAchievements(final int i) {
        if (this.achievementsClient != null) {
            this.achievementsClient.getAchievementsIntent().addOnCompleteListener(new OnCompleteListener<Intent>() {
                public void onComplete(@NonNull Task<Intent> task) {
                    try {
                        Achievements.this.activity.startActivityForResult(task.getResult(ApiException.class), i);
                    } catch (ApiException e) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("GoogleGameCenter: showAchievements failed:");
                        outline24.append(e.getStatusCode());
                        Logger.logError(outline24.toString());
                    } catch (Exception e2) {
                        GeneratedOutlineSupport.outline32(e2, GeneratedOutlineSupport.outline24("GoogleGameCenter: showAchievements failed:"));
                    }
                }
            });
        }
    }
}
