package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaf extends Drawable implements Drawable.Callback {
    public int zaa;
    public long zab;
    public int zac;
    public int zad;
    public int zae;
    public int zaf;
    public int zag;
    public boolean zah;
    public boolean zai;
    public zai zaj;
    public Drawable zak;
    public Drawable zal;
    public boolean zam;
    public boolean zan;
    public boolean zao;
    public int zap;

    public zaf(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this((zai) null);
        drawable = drawable == null ? zag.zaa : drawable;
        this.zak = drawable;
        drawable.setCallback(this);
        zai zai2 = this.zaj;
        zai2.zab = drawable.getChangingConfigurations() | zai2.zab;
        drawable2 = drawable2 == null ? zag.zaa : drawable2;
        this.zal = drawable2;
        drawable2.setCallback(this);
        zai zai3 = this.zaj;
        zai3.zab = drawable2.getChangingConfigurations() | zai3.zab;
    }

    private final boolean zab() {
        if (!this.zam) {
            this.zan = (this.zak.getConstantState() == null || this.zal.getConstantState() == null) ? false : true;
            this.zam = true;
        }
        return this.zan;
    }

    public final void draw(Canvas canvas) {
        int i = this.zaa;
        boolean z = false;
        boolean z2 = true;
        if (i == 1) {
            this.zab = SystemClock.uptimeMillis();
            this.zaa = 2;
        } else if (i == 2 && this.zab >= 0) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zab)) / ((float) this.zaf);
            if (uptimeMillis < 1.0f) {
                z2 = false;
            }
            if (z2) {
                this.zaa = 0;
            }
            this.zag = (int) ((((float) this.zad) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
            z = z2;
        } else {
            z = true;
        }
        int i2 = this.zag;
        boolean z3 = this.zah;
        Drawable drawable = this.zak;
        Drawable drawable2 = this.zal;
        if (z) {
            if (!z3 || i2 == 0) {
                drawable.draw(canvas);
            }
            int i3 = this.zae;
            if (i2 == i3) {
                drawable2.setAlpha(i3);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zae - i2);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zae);
        }
        if (i2 > 0) {
            drawable2.setAlpha(i2);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zae);
        }
        invalidateSelf();
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zai zai2 = this.zaj;
        return changingConfigurations | zai2.zaa | zai2.zab;
    }

    @Nullable
    public final Drawable.ConstantState getConstantState() {
        if (!zab()) {
            return null;
        }
        this.zaj.zaa = getChangingConfigurations();
        return this.zaj;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zak.getIntrinsicHeight(), this.zal.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zak.getIntrinsicWidth(), this.zal.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.zao) {
            this.zap = Drawable.resolveOpacity(this.zak.getOpacity(), this.zal.getOpacity());
            this.zao = true;
        }
        return this.zap;
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final Drawable mutate() {
        if (!this.zai && super.mutate() == this) {
            if (zab()) {
                this.zak.mutate();
                this.zal.mutate();
                this.zai = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        this.zak.setBounds(rect);
        this.zal.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void setAlpha(int i) {
        if (this.zag == this.zae) {
            this.zag = i;
        }
        this.zae = i;
        invalidateSelf();
    }

    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.zak.setColorFilter(colorFilter);
        this.zal.setColorFilter(colorFilter);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zaa() {
        return this.zal;
    }

    public final void zaa(int i) {
        this.zac = 0;
        this.zad = this.zae;
        this.zag = 0;
        this.zaf = 250;
        this.zaa = 1;
        invalidateSelf();
    }

    public zaf(@Nullable zai zai2) {
        this.zaa = 0;
        this.zae = 255;
        this.zag = 0;
        this.zah = true;
        this.zaj = new zai(zai2);
    }
}
