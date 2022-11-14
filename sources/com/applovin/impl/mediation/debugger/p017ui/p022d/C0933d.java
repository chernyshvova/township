package com.applovin.impl.mediation.debugger.p017ui.p022d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.d */
public abstract class C0933d extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a */
    public final LayoutInflater f1059a;

    /* renamed from: b */
    public List<C0929c> f1060b = new ArrayList();

    /* renamed from: c */
    public final Context f1061c;

    /* renamed from: d */
    public Map<Integer, Integer> f1062d = new HashMap();

    /* renamed from: e */
    public C0935a f1063e;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.d$a */
    public interface C0935a {
        /* renamed from: a */
        void mo10111a(C0927a aVar, C0929c cVar);
    }

    public C0933d(Context context) {
        this.f1061c = context;
        this.f1059a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: e */
    private C0927a m1207e(int i) {
        for (int i2 = 0; i2 < mo10120b(); i2++) {
            Integer num = this.f1062d.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + mo10118a(i2)) {
                    return new C0927a(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public abstract int mo10118a(int i);

    /* renamed from: a */
    public Bitmap mo10192a(ListView listView) {
        int count = getCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824);
        int i = 0;
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ArrayList arrayList = new ArrayList(count);
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            View view = getView(i3, (View) null, listView);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            arrayList.add(createBitmap);
            i2 += view.getMeasuredHeight();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(listView.getMeasuredWidth(), i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Bitmap bitmap = (Bitmap) it.next();
            canvas.drawBitmap(bitmap, 0.0f, (float) i, paint);
            i += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap2;
    }

    /* renamed from: a */
    public void mo10193a(C0935a aVar) {
        this.f1063e = aVar;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    /* renamed from: b */
    public abstract int mo10120b();

    /* renamed from: b */
    public abstract C0929c mo10121b(int i);

    /* renamed from: c */
    public abstract List<C0929c> mo10122c(int i);

    /* renamed from: d */
    public C0929c getItem(int i) {
        return this.f1060b.get(i);
    }

    public int getCount() {
        return this.f1060b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return getItem(i).mo10170i();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0928b bVar;
        C0929c d = getItem(i);
        if (view == null) {
            view = this.f1059a.inflate(d.mo10171j(), viewGroup, false);
            bVar = new C0928b();
            bVar.f1019a = (TextView) view.findViewById(16908308);
            bVar.f1020b = (TextView) view.findViewById(16908309);
            bVar.f1021c = (ImageView) view.findViewById(C1368R.C1370id.imageView);
            bVar.f1022d = (ImageView) view.findViewById(C1368R.C1370id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (C0928b) view.getTag();
        }
        bVar.mo10167a(i);
        bVar.mo10168a(d);
        view.setEnabled(d.mo10124b());
        return view;
    }

    public int getViewTypeCount() {
        return C0929c.m1176h();
    }

    /* renamed from: i */
    public void mo10202i() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0933d.this.notifyDataSetChanged();
            }
        });
    }

    public boolean isEnabled(int i) {
        return getItem(i).mo10124b();
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f1060b = new ArrayList();
        Integer valueOf = Integer.valueOf(mo10120b());
        this.f1062d = new HashMap(valueOf.intValue());
        Integer num = 0;
        for (int i = 0; i < valueOf.intValue(); i++) {
            Integer valueOf2 = Integer.valueOf(mo10118a(i));
            if (valueOf2.intValue() != 0) {
                this.f1060b.add(mo10121b(i));
                this.f1060b.addAll(mo10122c(i));
                this.f1062d.put(Integer.valueOf(i), num);
                num = Integer.valueOf(valueOf2.intValue() + 1 + num.intValue());
            }
        }
        this.f1060b.add(new C0936e(""));
    }

    public void onClick(View view) {
        C0928b bVar = (C0928b) view.getTag();
        C0929c b = bVar.mo10169b();
        C0927a e = m1207e(bVar.mo10166a());
        C0935a aVar = this.f1063e;
        if (aVar != null && e != null) {
            aVar.mo10111a(e, b);
        }
    }
}
