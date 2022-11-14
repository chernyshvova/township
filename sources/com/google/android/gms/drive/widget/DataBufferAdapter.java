package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    public static final GmsLogger zzbz = new GmsLogger("DataBufferAdapter", "");
    public final int fieldId;
    public final int resource;
    public final Context zzgw;
    public int zzmz;
    public final List<DataBuffer<T>> zzna;
    public final LayoutInflater zznb;
    public boolean zznc;

    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.zznc = true;
        this.zzgw = context;
        this.zzmz = i;
        this.resource = i;
        this.fieldId = i2;
        this.zzna = list;
        this.zznb = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private final View zza(int i, View view, ViewGroup viewGroup, int i2) {
        TextView textView;
        if (view == null) {
            view = this.zznb.inflate(i2, viewGroup, false);
        }
        try {
            if (this.fieldId == 0) {
                textView = (TextView) view;
            } else {
                textView = (TextView) view.findViewById(this.fieldId);
            }
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return view;
        } catch (ClassCastException e) {
            zzbz.mo17108e("DataBufferAdapter", "You must supply a resource ID for a TextView", e);
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.zzna.add(dataBuffer);
        if (this.zznc) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer<T> release : this.zzna) {
            release.release();
        }
        this.zzna.clear();
        if (this.zznc) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.zzgw;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer<T> count : this.zzna) {
            i += count.getCount();
        }
        return i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzmz);
    }

    public T getItem(int i) throws CursorIndexOutOfBoundsException {
        int i2 = i;
        for (DataBuffer next : this.zzna) {
            int count = next.getCount();
            if (count <= i2) {
                i2 -= count;
            } else {
                try {
                    return next.get(i2);
                } catch (CursorIndexOutOfBoundsException unused) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.resource);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zznc = true;
    }

    public void setDropDownViewResource(int i) {
        this.zzmz = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.zznc = z;
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, list);
    }

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }
}
