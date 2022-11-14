package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;

public class Room {
    public static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NonNull Context context, @NonNull Class<T> cls, @NonNull String str) {
        if (str != null && str.trim().length() != 0) {
            return new RoomDatabase.Builder<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    @NonNull
    public static <T, C> T getGeneratedImplementation(Class<C> cls, String str) {
        String str2;
        String name = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + CodelessMatcher.CURRENT_CLASS_NAME + str3;
            }
            return Class.forName(str2).newInstance();
        } catch (ClassNotFoundException unused) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("cannot find implementation for ");
            outline24.append(cls.getCanonicalName());
            outline24.append(". ");
            outline24.append(str3);
            outline24.append(" does not exist");
            throw new RuntimeException(outline24.toString());
        } catch (IllegalAccessException unused2) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Cannot access the constructor");
            outline242.append(cls.getCanonicalName());
            throw new RuntimeException(outline242.toString());
        } catch (InstantiationException unused3) {
            StringBuilder outline243 = GeneratedOutlineSupport.outline24("Failed to create an instance of ");
            outline243.append(cls.getCanonicalName());
            throw new RuntimeException(outline243.toString());
        }
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NonNull Context context, @NonNull Class<T> cls) {
        return new RoomDatabase.Builder<>(context, cls, (String) null);
    }
}
