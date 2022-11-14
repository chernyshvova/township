package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    public AbstractWindowedCursor zza;

    @KeepForSdk
    public CursorWrapper(@RecentlyNonNull Cursor cursor) {
        super(cursor);
        String str;
        for (int i = 0; i < 10 && (cursor instanceof android.database.CursorWrapper); i++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String name = cursor.getClass().getName();
            if (name.length() != 0) {
                str = "Unknown type: ".concat(name);
            } else {
                str = new String("Unknown type: ");
            }
            throw new IllegalArgumentException(str);
        }
        this.zza = (AbstractWindowedCursor) cursor;
    }

    @KeepForSdk
    public void fillWindow(int i, @RecentlyNonNull CursorWindow cursorWindow) {
        this.zza.fillWindow(i, cursorWindow);
    }

    @RecentlyNonNull
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.zza.getWindow();
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Cursor getWrappedCursor() {
        return this.zza;
    }

    public final boolean onMove(int i, int i2) {
        return this.zza.onMove(i, i2);
    }

    @KeepForSdk
    public void setWindow(@Nullable CursorWindow cursorWindow) {
        this.zza.setWindow(cursorWindow);
    }
}
