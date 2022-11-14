package com.helpshift.common.platform;

import android.os.Environment;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class AndroidBackupDAO implements BackupDAO {
    public final String BACKUP_FILE_NAME = "__hs__backup_dao_storage";
    public String externalDirectoryPath;

    private boolean backupExists() {
        try {
            return new File(Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath()), "__hs__backup_dao_storage").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private void backupHashMap(HashMap<String, Serializable> hashMap) {
        if (hashMap != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath());
                if (!externalStoragePublicDirectory.exists()) {
                    externalStoragePublicDirectory.mkdirs();
                }
                if (externalStoragePublicDirectory.canWrite()) {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(externalStoragePublicDirectory, "__hs__backup_dao_storage")));
                    try {
                        objectOutputStream2.writeObject(hashMap);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        IOUtils.closeQuitely(objectOutputStream);
                        throw th;
                    }
                    objectOutputStream = objectOutputStream2;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuitely(objectOutputStream);
                throw th;
            }
            IOUtils.closeQuitely(objectOutputStream);
        }
    }

    private String getExternalDirectoryPath() {
        if (this.externalDirectoryPath == null) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(".backups/");
            outline24.append(HelpshiftContext.getApplicationContext().getPackageName());
            outline24.append("/helpshift/databases/");
            this.externalDirectoryPath = outline24.toString();
        }
        return this.externalDirectoryPath;
    }

    private HashMap<String, Serializable> restoreHashMap() {
        ObjectInputStream objectInputStream;
        Throwable th;
        HashMap<String, Serializable> hashMap;
        ObjectInputStream objectInputStream2 = null;
        if (!backupExists()) {
            return null;
        }
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath());
            if (externalStoragePublicDirectory.canRead()) {
                objectInputStream = new ObjectInputStream(new FileInputStream(new File(externalStoragePublicDirectory, "__hs__backup_dao_storage")));
                try {
                    hashMap = (HashMap) objectInputStream.readObject();
                    objectInputStream2 = objectInputStream;
                } catch (Exception unused) {
                    IOUtils.closeQuitely(objectInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuitely(objectInputStream);
                    throw th;
                }
            } else {
                hashMap = null;
            }
            IOUtils.closeQuitely(objectInputStream2);
            return hashMap;
        } catch (Exception unused2) {
            objectInputStream = null;
            IOUtils.closeQuitely(objectInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            IOUtils.closeQuitely(objectInputStream);
            throw th;
        }
    }

    public synchronized void delete() {
        if (backupExists()) {
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getExternalDirectoryPath());
                if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                    File file = new File(externalStoragePublicDirectory, "__hs__backup_dao_storage");
                    if (file.canWrite()) {
                        file.delete();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized Serializable getValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, Serializable> restoreHashMap = restoreHashMap();
        if (restoreHashMap == null) {
            return null;
        }
        return restoreHashMap.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeKey(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            java.util.HashMap r0 = r2.restoreHashMap()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            boolean r1 = r0.containsKey(r3)     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x001b
            r0.remove(r3)     // Catch:{ all -> 0x001d }
            r2.backupHashMap(r0)     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidBackupDAO.removeKey(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void storeValue(java.lang.String r3, java.io.Serializable r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0029
            if (r4 != 0) goto L_0x000a
            goto L_0x0029
        L_0x000a:
            java.util.HashMap r0 = r2.restoreHashMap()     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0015
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x002b }
            r0.<init>()     // Catch:{ all -> 0x002b }
        L_0x0015:
            java.lang.Object r1 = r0.get(r3)     // Catch:{ all -> 0x002b }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0021
            monitor-exit(r2)
            return
        L_0x0021:
            r0.put(r3, r4)     // Catch:{ all -> 0x002b }
            r2.backupHashMap(r0)     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidBackupDAO.storeValue(java.lang.String, java.io.Serializable):void");
    }
}
