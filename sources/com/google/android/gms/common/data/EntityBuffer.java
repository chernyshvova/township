package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    public boolean zaa = false;
    public ArrayList<Integer> zab;

    @KeepForSdk
    public EntityBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zaa() {
        synchronized (this) {
            if (!this.zaa) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.zab = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i = 1;
                    while (i < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i));
                                string = string2;
                            }
                            i++;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(primaryDataMarkerColumn).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(primaryDataMarkerColumn);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(windowIndex);
                            throw new NullPointerException(sb.toString());
                        }
                    }
                }
                this.zaa = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006f, code lost:
        if (r6.mDataHolder.getString(r4, r7, r3) == null) goto L_0x0073;
     */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get(int r7) {
        /*
            r6 = this;
            r6.zaa()
            int r0 = r6.zaa(r7)
            r1 = 0
            if (r7 < 0) goto L_0x0073
            java.util.ArrayList<java.lang.Integer> r2 = r6.zab
            int r2 = r2.size()
            if (r7 != r2) goto L_0x0013
            goto L_0x0073
        L_0x0013:
            java.util.ArrayList<java.lang.Integer> r2 = r6.zab
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            if (r7 != r2) goto L_0x0036
            com.google.android.gms.common.data.DataHolder r2 = r6.mDataHolder
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            com.google.android.gms.common.data.DataHolder r2 = (com.google.android.gms.common.data.DataHolder) r2
            int r2 = r2.getCount()
            java.util.ArrayList<java.lang.Integer> r4 = r6.zab
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            goto L_0x0050
        L_0x0036:
            java.util.ArrayList<java.lang.Integer> r2 = r6.zab
            int r4 = r7 + 1
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.ArrayList<java.lang.Integer> r4 = r6.zab
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
        L_0x0050:
            int r2 = r2 - r4
            if (r2 != r3) goto L_0x0072
            int r7 = r6.zaa(r7)
            com.google.android.gms.common.data.DataHolder r3 = r6.mDataHolder
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.common.data.DataHolder r3 = (com.google.android.gms.common.data.DataHolder) r3
            int r3 = r3.getWindowIndex(r7)
            java.lang.String r4 = r6.getChildDataMarkerColumn()
            if (r4 == 0) goto L_0x0072
            com.google.android.gms.common.data.DataHolder r5 = r6.mDataHolder
            java.lang.String r7 = r5.getString(r4, r7, r3)
            if (r7 != 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r1 = r2
        L_0x0073:
            java.lang.Object r7 = r6.getEntry(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.EntityBuffer.get(int):java.lang.Object");
    }

    @KeepForSdk
    @RecentlyNullable
    public String getChildDataMarkerColumn() {
        return null;
    }

    @KeepForSdk
    public int getCount() {
        zaa();
        return this.zab.size();
    }

    @RecentlyNonNull
    @KeepForSdk
    public abstract T getEntry(int i, int i2);

    @RecentlyNonNull
    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();

    private final int zaa(int i) {
        if (i >= 0 && i < this.zab.size()) {
            return this.zab.get(i).intValue();
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline10(53, "Position ", i, " is out of bounds for this buffer"));
    }
}
